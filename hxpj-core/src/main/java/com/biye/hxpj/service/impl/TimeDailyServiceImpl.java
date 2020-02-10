package com.biye.hxpj.service.impl;

import com.biye.hxpj.mapper.*;
import com.biye.hxpj.model.*;
import com.biye.hxpj.service.HoneycombRecordService;
import com.biye.hxpj.service.TimeDailyService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.tools.internal.xjc.reader.dtd.bindinfo.BIAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @program: hxpj
 * @description: 每日定时任务
 * @author: LiLei
 * @create: 2019-05-05 16:15
 **/
@Service
public class TimeDailyServiceImpl implements TimeDailyService {
    @Autowired
    HoneycombRecordService honeycombRecordService;
    @Resource
    HoneycombEmApartmentroomMapper honeycombEmApartmentroomMapper;
    @Resource
    HoneycombWmApartmentroomMapper honeycombWmApartmentroomMapper;
    @Resource
    ComputeWmDailydevicerecordMapper computeWmDailydevicerecordMapper;
    @Resource
    ComputeEmDailydevicerecordMapper computeEmDailydevicerecordMapper;
    @Resource
    ComputeEmDailyfirmrecordMapper computeEmDailyfirmrecordMapperl;
    @Resource
    ComputeWmDailyfirmrecordMapper computeWmDailyfirmrecordMapper;
    @Resource
    TotalEmHourMapper totalEmHourMapper;
    @Resource
    TotalWmHourMapper totalWmHourMapper;
    /***
     * 计算并向compute_em_dailydevicerecord、compute_em_dailyfirmrecord表插入数据
     */
    @Override
    public void timeComputeDailyEm() {
        String totalScale="0";
        //获取所有已部署的电表
        Long id=null;
        List<HoneycombEmApartmentroom> emList=honeycombEmApartmentroomMapper.findAllEmApart(id,id);
        int emSize=emList.size();
        Integer pageNum=1;
        Integer pageSize=emSize;

        Map<String,String> deviceScaleMap=new HashMap<String, String>();
        boolean isNext=true;
        while (isNext){
            PageInfo<HoneycombEmrecord> pageInfo=honeycombRecordService.getEmRecordList(pageNum,pageSize);
            int pages=pageInfo.getPages();
            List<HoneycombEmrecord> list=pageInfo.getList();
            for (HoneycombEmrecord honeycombEmrecord:list){
                String dateTime=honeycombEmrecord.getDataTime();
                if (!istoday(dateTime)){
                    isNext=false;
                    break;
                }
                String deviceId=honeycombEmrecord.getDeviceId();
                String scale=honeycombEmrecord.getScale();
                if (!deviceScaleMap.containsKey(deviceId)){
                    deviceScaleMap.put(deviceId,scale);
                }else {
                    String scale1=deviceScaleMap.get(deviceId);
                    String scal=twoStringAdd(scale,scale1);
                    deviceScaleMap.put(deviceId,scal);
                }
            }
            if (pageNum==pages){
                isNext=false;
            }
            if (isNext){
                pageNum++;
            }else {
                break;
            }
        }
        //从EmList取出其他属性,并存入到CompteList中,最后插入到数据库中,完成每日用电统计
        List<ComputeEmDailydevicerecord> emDailylist=new ArrayList<ComputeEmDailydevicerecord>();
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
        String dateDay=sdf1.format(date);
        String updateTime=sdf.format(date);
        for (HoneycombEmApartmentroom honeycombEmApartmentroom:emList){
            String device=honeycombEmApartmentroom.getDeviceId();
            if (deviceScaleMap.containsKey(device)){
                String scale=deviceScaleMap.get(device);
                totalScale=twoStringAdd(totalScale,scale);
                Long roomId=honeycombEmApartmentroom.getRoomId();
                Long apartmentId=honeycombEmApartmentroom.getApartmentId();
                String firm=honeycombEmApartmentroom.getFirmApartmentroom().getFirm();
                ComputeEmDailydevicerecord computeEmDailydevicerecord=new ComputeEmDailydevicerecord();
                computeEmDailydevicerecord.setFirmName(firm);
                computeEmDailydevicerecord.setApartmentId(apartmentId);
                computeEmDailydevicerecord.setRoomId(roomId);
                computeEmDailydevicerecord.setDevice(device);
                computeEmDailydevicerecord.setUpdateTime(updateTime);
                computeEmDailydevicerecord.setScale(scale);
                computeEmDailydevicerecord.setDateDay(dateDay);
                emDailylist.add(computeEmDailydevicerecord);
            }
        }

        computeEmDailydevicerecordMapper.insertList(emDailylist);
        //对total_em_hour表的添加
        TotalEmHour totalEmHour=new TotalEmHour();
        BigDecimal totalScale1=new BigDecimal(totalScale);
        totalEmHour.setDataScale(totalScale1);
        totalEmHour.setDataHour(updateTime);
        totalEmHourMapper.insertSelective(totalEmHour);
        //每日公司用电
        //遍历EmDailyList
        //Key:firm Value:scale
        Map<String,String> firmScaleMap=new HashMap<String, String>();
        for (ComputeEmDailydevicerecord computeEmDailydevicerecord1:emDailylist){
            String firmName=computeEmDailydevicerecord1.getFirmName();
            String firmScale=computeEmDailydevicerecord1.getScale();
            if (!firmScaleMap.containsKey(firmName)){
                firmScaleMap.put(firmName,firmScale);
            }else {
                String firmScale1=firmScaleMap.get(firmName);
                String firmScale2=twoStringAdd(firmScale,firmScale1);
                firmScaleMap.put(firmName,firmScale2);
            }
        }
        List<ComputeEmDailyfirmrecord> computeEmDailyfirmrecordList=new ArrayList<>();
        for (Map.Entry<String,String> entry :firmScaleMap.entrySet()){
            ComputeEmDailyfirmrecord computeEmDailyfirmrecord=new ComputeEmDailyfirmrecord();
            computeEmDailyfirmrecord.setFirmName(entry.getKey());
            computeEmDailyfirmrecord.setScale(entry.getValue());
            computeEmDailyfirmrecord.setUpdateTime(updateTime);
            computeEmDailyfirmrecord.setDateDay(dateDay);
            computeEmDailyfirmrecordList.add(computeEmDailyfirmrecord);
        }
        computeEmDailyfirmrecordMapperl.insertList(computeEmDailyfirmrecordList);
        //存入total_em_hour每日总体用电量

    }

    @Override
    public void timeComputeDailyWm() {
        //获取已部署水表列表
        String totalScale="0";
        Long id=null;
        List<HoneycombWmApartmentroom> wmList=honeycombWmApartmentroomMapper.findAllWm(id,id);
        int wmSize=wmList.size();
        Integer pageNum=1;
        Integer pageSize=wmSize;
        //计算水表每日用水量,得出deviceScaleMap
        //Key:deviceId  Value:scale
        Map<String,String> deviceScaleMap=new HashMap<String, String>();
        boolean isNext=true;
        while (isNext){
            PageInfo<HoneycombWmrecord> pageInfo=honeycombRecordService.getWmRecordList(pageNum,pageSize);
            int pages=pageInfo.getPages();
            List<HoneycombWmrecord> list=pageInfo.getList();
            for (HoneycombWmrecord honeycombWmrecord:list){
                String dateTime=honeycombWmrecord.getDataTime();
                if (!istoday(dateTime)){
                    isNext=false;
                    break;
                }
                String deviceId=honeycombWmrecord.getDeviceId();
                String scale=honeycombWmrecord.getScale();
                if (!deviceScaleMap.containsKey(deviceId)){
                    deviceScaleMap.put(deviceId,scale);
                }else {
                    String scale1=deviceScaleMap.get(deviceId);
                    String scal=twoStringAdd(scale,scale1);
                    deviceScaleMap.put(deviceId,scal);
                }
            }
            if (pageNum==pages){
                isNext=false;
            }
            if (isNext){
                pageNum++;
            }else {
                break;
            }
        }
        //从WmList取出其他属性,并存入到CompteList中,最后插入到数据库中,完成每日用电统计
        List<ComputeWmDailydevicerecord> wmDailyList=new ArrayList<>();
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
        String dateDay=sdf1.format(date);
        String updateTime=sdf.format(date);
        for (HoneycombWmApartmentroom honeycombWmApartmentroom:wmList){
            String device=honeycombWmApartmentroom.getDeviceId();
            if (deviceScaleMap.containsKey(device)){
                String scale=deviceScaleMap.get(device);
                totalScale=twoStringAdd(totalScale,scale);
                Long roomId=honeycombWmApartmentroom.getRoomId();
                Long apartmentId=honeycombWmApartmentroom.getApartmentId();
                String firm=honeycombWmApartmentroom.getFirmApartmentroom().getFirm();
                ComputeWmDailydevicerecord computeWmDailydevicerecord=new ComputeWmDailydevicerecord();
                computeWmDailydevicerecord.setFirmName(firm);
                computeWmDailydevicerecord.setApartmentId(apartmentId);
                computeWmDailydevicerecord.setRoomId(roomId);
                computeWmDailydevicerecord.setDevice(device);
                computeWmDailydevicerecord.setUpdateTime(updateTime);
                computeWmDailydevicerecord.setScale(scale);
                computeWmDailydevicerecord.setDateDay(dateDay);
                wmDailyList.add(computeWmDailydevicerecord);
            }
        }
        //批量插入每日水表记录
        computeWmDailydevicerecordMapper.insertList(wmDailyList);

        //更新total_wm_hour表，echart数据：昨日用电统计图
        TotalWmHour totalWmHour=new TotalWmHour();
        BigDecimal totalScale1=new BigDecimal(totalScale);
        totalWmHour.setDataHour(updateTime);
        totalWmHour.setDataScale(totalScale1);
        totalWmHourMapper.insertSelective(totalWmHour);
        //每日公司用水
        //遍历WmDailyList
        //Key:firm Value:scale
        Map<String,String> firmScaleMap=new HashMap<String, String>();
        for (ComputeWmDailydevicerecord computeWmDailydevicerecord1:wmDailyList){
            String firmName=computeWmDailydevicerecord1.getFirmName();
            String firmScale=computeWmDailydevicerecord1.getScale();
            if (!firmScaleMap.containsKey(firmName)){
                firmScaleMap.put(firmName,firmScale);
            }else {
                String firmScale1=firmScaleMap.get(firmName);
                String firmScale2=twoStringAdd(firmScale,firmScale1);
                firmScaleMap.put(firmName,firmScale2);
            }
        }
        List<ComputeWmDailyfirmrecord> computeWmDailyfirmrecordList=new ArrayList<>();
        for (Map.Entry<String,String> entry :firmScaleMap.entrySet()){
            ComputeWmDailyfirmrecord computeWmDailyfirmrecord=new ComputeWmDailyfirmrecord();
            computeWmDailyfirmrecord.setFirmName(entry.getKey());
            computeWmDailyfirmrecord.setScale(entry.getValue());
            computeWmDailyfirmrecord.setUpdateTime(updateTime);
            computeWmDailyfirmrecord.setDateDay(dateDay);
            computeWmDailyfirmrecordList.add(computeWmDailyfirmrecord);
        }
        //批量插入每日公司用水
        computeWmDailyfirmrecordMapper.insertList(computeWmDailyfirmrecordList);
    }


    private String twoStringAdd(String a,String b){
        BigDecimal bigDecimalA=new BigDecimal(a);
        BigDecimal bigDecimalB=new BigDecimal(b);
        return bigDecimalA.add(bigDecimalB).toString();
    }
    private boolean istoday(String testDay){
        try{
            boolean is=false;
            Date date=new Date();
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            //String today=sdf.format(date);
            String today="2019-04-23";
            Date date1=sdf.parse(testDay);
            String testDay1=sdf.format(date1);
            if (today.equals(testDay1)){
                is=true;
            }
            return is;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}

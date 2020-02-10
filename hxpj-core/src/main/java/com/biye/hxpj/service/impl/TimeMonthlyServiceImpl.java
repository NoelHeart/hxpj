package com.biye.hxpj.service.impl;

import com.biye.hxpj.mapper.*;
import com.biye.hxpj.model.*;
import com.biye.hxpj.service.ComputeDailyService;
import com.biye.hxpj.service.TimeMonthlyService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @program: hxpj
 * @description: 每月统计
 * @author: LiLei
 * @create: 2019-05-05 16:18
 **/
@Service
public class TimeMonthlyServiceImpl implements TimeMonthlyService {
    @Autowired
    ComputeDailyService computeDailyService;
    @Resource
    HoneycombEmApartmentroomMapper honeycombEmApartmentroomMapper;
    @Resource
    HoneycombWmApartmentroomMapper honeycombWmApartmentroomMapper;
    @Resource
    ComputeEmMonthlydevicerecordMapper computeEmMonthlydevicerecordMapper;
    @Resource
    ComputeWmMonthlydevicerecordMapper computeWmMonthlydevicerecordMapper;
    @Resource
    ComputeEmMonthlyfirmrecordMapper computeEmMonthlyfirmrecordMapper;
    @Resource
    ComputeWmMonthlyfirmrecordMapper computeWmMonthlyfirmrecordMapper;
    @Resource
    TotalEmDailyMapper totalEmDailyMapper;
    @Resource
    TotalWmDailyMapper totalWmDailyMapper;

    @Override
    public void timeComputeMonthlyEm() {
        //deviceMonthly电表设备月统计
        //获取所有已部署的电表
        Long id=null;
        List<HoneycombEmApartmentroom> emList=honeycombEmApartmentroomMapper.findAllEmApart(id,id);
        int emSzie=emList.size();
        Integer pageNum=1;
        Integer pageSize=emSzie;
        Map<String,String> deviceScaleMap=new HashMap<String, String>();
        boolean isNext=true;
        while (isNext){
            PageInfo<ComputeEmDailydevicerecord> pageInfo=computeDailyService.getDailyEmRecordList(pageNum,pageSize);
            int pages=pageInfo.getPages();
            List<ComputeEmDailydevicerecord> list=pageInfo.getList();
            for (ComputeEmDailydevicerecord computeEmDailydevicerecord:list){
                String dateDay=computeEmDailydevicerecord.getDateDay();
                if (!isThisMonth(dateDay)){
                    isNext=false;
                    break;
                }
                String deviceId=computeEmDailydevicerecord.getDevice();
                String scale=computeEmDailydevicerecord.getScale();
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
        String totalScale="0";
        //从EmList取出其他属性,并存入到CompteList中,最后插入到数据库中,完成每月用电统计
        List<ComputeEmMonthlydevicerecord> emMonthlyList=new ArrayList<>();
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM");
        String dateMonth=sdf1.format(date);
        String updateTime=sdf.format(date);
        for (HoneycombEmApartmentroom honeycombEmApartmentroom:emList){
            String device=honeycombEmApartmentroom.getDeviceId();
            if (deviceScaleMap.containsKey(device)){
                String scale=deviceScaleMap.get(device);
                totalScale=twoStringAdd(totalScale,scale);
                Long roomId=honeycombEmApartmentroom.getRoomId();
                Long apartmentId=honeycombEmApartmentroom.getApartmentId();
                String firm=honeycombEmApartmentroom.getFirmApartmentroom().getFirm();
                ComputeEmMonthlydevicerecord computeEmMonthlydevicerecord=new ComputeEmMonthlydevicerecord();
                computeEmMonthlydevicerecord.setFirmName(firm);
                computeEmMonthlydevicerecord.setRoomId(roomId);
                computeEmMonthlydevicerecord.setApartmentId(apartmentId);
                computeEmMonthlydevicerecord.setUpdateTime(updateTime);
                computeEmMonthlydevicerecord.setDateMonth(dateMonth);
                computeEmMonthlydevicerecord.setDevice(device);
                computeEmMonthlydevicerecord.setScale(scale);
                emMonthlyList.add(computeEmMonthlydevicerecord);
            }
        }
        //批量插入每月用电统计表
        computeEmMonthlydevicerecordMapper.insertList(emMonthlyList);
        //插入total_em_daily，每天更新一次
        SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd");
        String dateDay=sdf2.format(date);
        TotalEmDaily totalEmDaily=new TotalEmDaily();
        BigDecimal totalScale1=new BigDecimal(totalScale);
        totalEmDaily.setDataDay(dateDay);
        totalEmDaily.setDataScale(totalScale1);
        totalEmDailyMapper.insertSelective(totalEmDaily);
        //每月公司用电
        //遍历EmDailyList
        //Key:firm Value:scale
        Map<String,String> firmScaleMap=new HashMap<>();
        for(ComputeEmMonthlydevicerecord computeEmMonthlydevicerecord:emMonthlyList){
            String firmName=computeEmMonthlydevicerecord.getFirmName();
            String firmScale=computeEmMonthlydevicerecord.getScale();
            if (!firmScaleMap.containsKey(firmName)){
                firmScaleMap.put(firmName,firmScale);
            }else {
                String firmScale1=firmScaleMap.get(firmName);
                String firmScale2=twoStringAdd(firmScale,firmScale1);
                firmScaleMap.put(firmName,firmScale2);
            }
        }
        List<ComputeEmMonthlyfirmrecord> computeEmMonthlyfirmrecordList=new ArrayList<>();
        for (Map.Entry<String,String> entry :firmScaleMap.entrySet()){
            ComputeEmMonthlyfirmrecord computeEmMonthlyfirmrecord=new ComputeEmMonthlyfirmrecord();
            computeEmMonthlyfirmrecord.setUpdateTime(updateTime);
            computeEmMonthlyfirmrecord.setFirmName(entry.getKey());
            computeEmMonthlyfirmrecord.setScale(entry.getValue());
            computeEmMonthlyfirmrecord.setDateMonth(dateMonth);
            computeEmMonthlyfirmrecordList.add(computeEmMonthlyfirmrecord);
        }
        //批量插入每月公司用电统计表
        computeEmMonthlyfirmrecordMapper.insertEmList(computeEmMonthlyfirmrecordList);
    }

    @Override
    public void timeComputeMonthlyWm() {
        //deviceMonthly水表设备月统计
        //获取所有已部署的电表
        Long id=null;
        List<HoneycombWmApartmentroom> wmList=honeycombWmApartmentroomMapper.findAllWm(id,id);
        int wmSize=wmList.size();
        Integer pageNum=1;
        Integer pageSize=wmSize;
        Map<String,String> deviceScaleMap=new HashMap<String, String>();
        boolean isNext=true;
        while (isNext){
            PageInfo<ComputeWmDailydevicerecord> pageInfo=computeDailyService.getDailyWmRecordList(pageNum,pageSize);
            int pages=pageInfo.getPages();
            List<ComputeWmDailydevicerecord> list=pageInfo.getList();
            for (ComputeWmDailydevicerecord computeWmDailydevicerecord:list){
                String dateDay=computeWmDailydevicerecord.getDateDay();
                if (!isThisMonth(dateDay)){
                    isNext=false;
                    break;
                }
                String deviceId=computeWmDailydevicerecord.getDevice();
                String scale=computeWmDailydevicerecord.getScale();
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
        String totalScale="0";
        //从EmList取出其他属性,并存入到CompteList中,最后插入到数据库中,完成每月用电统计
        List<ComputeWmMonthlydevicerecord> wmMonthlydeviceList=new ArrayList<>();
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM");
        String dateMonth=sdf1.format(date);
        String updateTime=sdf.format(date);
        for (HoneycombWmApartmentroom honeycombWmApartmentroom:wmList){
            String device=honeycombWmApartmentroom.getDeviceId();
            if (deviceScaleMap.containsKey(device)){
                String scale=deviceScaleMap.get(device);
                totalScale=twoStringAdd(totalScale,scale);
                Long roomId=honeycombWmApartmentroom.getRoomId();
                Long apartmentId=honeycombWmApartmentroom.getApartmentId();
                String firm=honeycombWmApartmentroom.getFirmApartmentroom().getFirm();
                ComputeWmMonthlydevicerecord computeWmMonthlydevicerecord=new ComputeWmMonthlydevicerecord();
                computeWmMonthlydevicerecord.setFirmName(firm);
                computeWmMonthlydevicerecord.setRoomId(roomId);
                computeWmMonthlydevicerecord.setApartmentId(apartmentId);
                computeWmMonthlydevicerecord.setUpdateTime(updateTime);
                computeWmMonthlydevicerecord.setDateMonth(dateMonth);
                computeWmMonthlydevicerecord.setDevice(device);
                computeWmMonthlydevicerecord.setScale(scale);
                wmMonthlydeviceList.add(computeWmMonthlydevicerecord);
            }
        }
        //批量插入每月用水统计表
        computeWmMonthlydevicerecordMapper.insertWmDList(wmMonthlydeviceList);
        //total_wm_daily表的添加，每天更新一次
        SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd");
        String dateDay=sdf2.format(date);
        TotalWmDaily totalWmDaily=new TotalWmDaily();
        BigDecimal totalScale1=new BigDecimal(totalScale);
        totalWmDaily.setDataDay(dateDay);
        totalWmDaily.setDataScale(totalScale1);
        totalWmDailyMapper.insertSelective(totalWmDaily);
        //每月公司用水
        //遍历EmDailyList
        //Key:firm Value:scale
        Map<String,String> firmScaleMap=new HashMap<>();
        for(ComputeWmMonthlydevicerecord computeWmMonthlydevicerecord:wmMonthlydeviceList){
            String firmName=computeWmMonthlydevicerecord.getFirmName();
            String firmScale=computeWmMonthlydevicerecord.getScale();
            if (!firmScaleMap.containsKey(firmName)){
                firmScaleMap.put(firmName,firmScale);
            }else {
                String firmScale1=firmScaleMap.get(firmName);
                String firmScale2=twoStringAdd(firmScale,firmScale1);
                firmScaleMap.put(firmName,firmScale2);
            }
        }
        List<ComputeWmMonthlyfirmrecord> computeWmMonthlyfirmrecordList=new ArrayList<>();
        for (Map.Entry<String,String> entry :firmScaleMap.entrySet()){
            ComputeWmMonthlyfirmrecord computeWmMonthlyfirmrecord=new ComputeWmMonthlyfirmrecord();

            computeWmMonthlyfirmrecord.setUpdateTime(updateTime);
            computeWmMonthlyfirmrecord.setFirmName(entry.getKey());
            computeWmMonthlyfirmrecord.setScale(entry.getValue());
            computeWmMonthlyfirmrecord.setDateMonth(dateMonth);
            computeWmMonthlyfirmrecordList.add(computeWmMonthlyfirmrecord);
        }
        //批量插入每月公司用水统计表
        computeWmMonthlyfirmrecordMapper.insertWmFirmList(computeWmMonthlyfirmrecordList);
    }
    private String twoStringAdd(String a,String b){
        BigDecimal bigDecimalA=new BigDecimal(a);
        BigDecimal bigDecimalB=new BigDecimal(b);
        return bigDecimalA.add(bigDecimalB).toString();
    }

    private boolean isThisMonth(String dateDay){
        try{
            boolean is=false;
            Date date=new Date();
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM");
            String thisMonth=sdf.format(date);
            Date date1=sdf.parse(dateDay);
            String testDay1=sdf.format(date1);
            if (thisMonth.equals(testDay1)){
                is=true;
            }
            return is;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}

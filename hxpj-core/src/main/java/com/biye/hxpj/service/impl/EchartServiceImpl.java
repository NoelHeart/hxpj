package com.biye.hxpj.service.impl;

import com.biye.hxpj.mapper.TotalEmDailyMapper;
import com.biye.hxpj.mapper.TotalEmHourMapper;
import com.biye.hxpj.mapper.TotalWmDailyMapper;
import com.biye.hxpj.mapper.TotalWmHourMapper;
import com.biye.hxpj.model.TotalEmDaily;
import com.biye.hxpj.model.TotalEmHour;
import com.biye.hxpj.model.TotalWmDaily;
import com.biye.hxpj.model.TotalWmHour;
import com.biye.hxpj.service.EchartService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @program: hxpj
 * @description: 图表数据
 * @author: LiLei
 * @create: 2019-05-10 14:37
 **/
@Service
public class EchartServiceImpl implements EchartService {
    @Resource
    TotalEmDailyMapper totalEmDailyMapper;
    @Resource
    TotalWmDailyMapper totalWmDailyMapper;
    @Resource
    TotalWmHourMapper totalWmHourMapper;
    @Resource
    TotalEmHourMapper totalEmHourMapper;

    /**
     * 上个月每日总体用电量统计数据
     * */
    @Override
    public List<TotalEmDaily> getEMDailyScaleList() {
        List<TotalEmDaily> lastMonthEmScale=new ArrayList<>();
        Integer pageNum=1;
        Integer pageSize=30;
        boolean isNext=true;
        while (isNext){
            PageHelper.startPage(pageNum,pageSize);
            List<TotalEmDaily> emList1=totalEmDailyMapper.findAllEm();
            PageInfo<TotalEmDaily> pageInfo=new PageInfo<>(emList1);
            int pages=pageInfo.getPages();
            for (TotalEmDaily totalEmDaily:emList1){
                String dateDay=totalEmDaily.getDataDay();
                if (!isLastMonth(dateDay)){
                    isNext=false;
                    break;
                }else {
                    String dateDay1=getDateDay(dateDay);
                    totalEmDaily.setDataDay(dateDay1);
                    lastMonthEmScale.add(totalEmDaily);
                }
            }
            if (pageNum==pages){
                isNext=false;
            }
            if (isNext){
                pageNum++;
            }else {break;}
        }
        Collections.reverse(lastMonthEmScale);
        return lastMonthEmScale;
    }
    /**
     * 上个月每日总体用水量统计数据
     * */
    @Override
    public List<TotalWmDaily> getWmDailyScaleList() {
        List<TotalWmDaily> lastMonthWmScale=new ArrayList<>();
        Integer pageNum=1;
        Integer pageSize=30;
        boolean isNext=true;
        while (isNext){
            PageHelper.startPage(pageNum,pageSize);
            List<TotalWmDaily> wmList1=totalWmDailyMapper.findAllWm();
            PageInfo<TotalWmDaily> pageInfo=new PageInfo<>(wmList1);
            int pages=pageInfo.getPages();
            for (TotalWmDaily totalWmDaily:wmList1){
                String dateDay=totalWmDaily.getDataDay();
                if (!isLastMonth(dateDay)){
                    isNext=false;
                    break;
                }else {
                    String dateDay1=getDateDay(dateDay);
                    totalWmDaily.setDataDay(dateDay1);
                    lastMonthWmScale.add(totalWmDaily);
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
        Collections.reverse(lastMonthWmScale);
        return lastMonthWmScale;
    }

    /**
     * 昨日总体用电量统计数据
     * */
    @Override
    public List<TotalEmHour> getEmTotalHour() {
        List<TotalEmHour> emHourList=new ArrayList<>();
        Integer pageNum=1;
        Integer pageSize=50;
        int fortimes=0;
        boolean isNext=true;
        while (isNext){
            PageHelper.startPage(pageNum,pageSize);
            List<TotalEmHour> emHourList1=totalEmHourMapper.findAll();
            PageInfo<TotalEmHour> pageInfo=new PageInfo<>(emHourList1);
            int pages=pageInfo.getPages();
            for (TotalEmHour totalEmHour:emHourList1){
                String dataHour=totalEmHour.getDataHour();
                if (fortimes==24){
                    isNext=false;
                    break;
                }
                if (isYesterday(dataHour)){
                    String hour=getDateHour(dataHour);
                    totalEmHour.setDataHour(hour);
                    emHourList.add(totalEmHour);
                    fortimes++;
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
        Collections.reverse(emHourList);
        return emHourList;
    }

    /**
     * 昨日总体用水量统计数据
     * */
    @Override
    public List<TotalWmHour> getWmTotalHour() {
        List<TotalWmHour> wmHourList=new ArrayList<>();
        Integer pageNum=1;
        Integer pageSize=50;
        int fortimes=0;
        boolean isNext=true;
        while (isNext){
            PageHelper.startPage(pageNum,pageSize);
            List<TotalWmHour> wmHourList1=totalWmHourMapper.findAll();
            PageInfo<TotalWmHour> pageInfo=new PageInfo<>(wmHourList1);
            int pages=pageInfo.getPages();
            for (TotalWmHour totalWmHour:wmHourList1){
                String dataHour=totalWmHour.getDataHour();
                if (fortimes==24){
                    isNext=false;
                    break;
                }
                if (isYesterday(dataHour)){
                    String hour=getDateHour(dataHour);
                    totalWmHour.setDataHour(hour);
                    wmHourList.add(totalWmHour);
                    fortimes++;
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
        Collections.reverse(wmHourList);
        return wmHourList;
    }

    private boolean isLastMonth(String dateDay){
        try{
            boolean is=false;
            Calendar cal=Calendar.getInstance();
            cal.add(cal.MONTH,-1);
            Date currentTime=cal.getTime();//当前时间的上一个月
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM");
            String lastMonth=sdf.format(currentTime);
            Date date1=sdf.parse(dateDay);
            String testDay1=sdf.format(date1);
            if (lastMonth.equals(testDay1)){
                is=true;
            }
            return is;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    private boolean isYesterday(String dataTime){
        try {
            boolean is=false;
            Calendar cal=Calendar.getInstance();
            cal.add(Calendar.DATE,-1);
            Date yesterdayDate=cal.getTime();
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            String yerterday=sdf.format(yesterdayDate);
            Date date1=sdf.parse(dataTime);
            String dateString=sdf.format(date1);
            if (yerterday.equals(dateString)){
                is=true;
            }
            return is;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }



    }
    private String getDateHour(String date){
        try {
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            SimpleDateFormat sdf1=new SimpleDateFormat("HH");
            Date date1=sdf.parse(date);
            String hour=sdf1.format(date1);
            return hour;
        }catch (Exception e){
            e.printStackTrace();
            return "01";
        }
    }
    private String getDateDay(String date){
        try {
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat sdf1=new SimpleDateFormat("dd");
            Date date1=sdf.parse(date);
            String day=sdf1.format(date1);
            return day;
        } catch (Exception e){
            e.printStackTrace();
            return "01";
        }
    }
}

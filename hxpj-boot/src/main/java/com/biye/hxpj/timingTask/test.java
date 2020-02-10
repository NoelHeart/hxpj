package com.biye.hxpj.timingTask;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @program: hxpj
 * @description: 测试定时任务
 * @author: LiLei
 * @create: 2019-05-05 00:30
 **/
//@Component
//public class test {
//
//    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
//
//    //定义每过3秒执行任务
//    @Scheduled(fixedRate = 3000)
//    public void reportNowTime(){
//        System.out.println("第一个定是任务---现在时间："+dateFormat.format(new Date()));
//    }
//    @Scheduled(fixedRate = 4000)
//    public void reportTaxk2(){
//        System.out.println("第二个定时任务---现在时间："+dateFormat.format(new Date()));
//    }
//}
public class test{
    public static void main(String[] args){
        try{
            String date="2019-05-06 16:13:00";
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            SimpleDateFormat sdf1=new SimpleDateFormat("HH");
            Date date1=sdf.parse(date);
            String hour=sdf1.format(date1);
            System.out.println(hour);
//            Calendar cal=Calendar.getInstance();
//            cal.add(Calendar.DATE,-1);
//            Date yesterdayDate=cal.getTime();
//            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
//            String yerterday=sdf.format(yesterdayDate);
//            System.out.println(yerterday);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

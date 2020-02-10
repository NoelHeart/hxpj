package com.biye.hxpj.timingTask;

import com.biye.hxpj.service.ComputeDailyService;
import com.biye.hxpj.service.TimeDailyService;
import com.biye.hxpj.service.TimeMonthlyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @program: hxpj
 * @description: 异步执行定时任务
 * @author: LiLei
 * @create: 2019-05-05 15:52
 * 常用的CRON表达式："/5 * * * * ?" 每隔5秒执行一次、
 **/
//"0 */1 * * * ?" 每隔1分钟执行一次、"/5 * * * * ?" 每隔5秒执行一次、“0 0 23 * * ?” 每天23点执行一次、“0 0 1 1 * ?” 每月1号凌晨1点执行一次、
//“0 0 23 L * ?” 每月最后一天23点执行一次、"0 30 0-23 * * ? "从30分钟开始、每隔1小时执行一次
@Component
@EnableAsync
public class TimeTask {
//    @Autowired
//    TimeDailyService timeDailyService;
//    @Autowired
//    TimeMonthlyService timeMonthlyService;
//
    /**
     * 每月用水用电定时任务  每月执行一次
     * */
//
//    @Scheduled(cron = "0 */1 * * * ?")
//    @Async
//    public void computeMonthlyEm(){
//        try {
//            timeMonthlyService.timeComputeMonthlyEm();
//            System.out.println("成功更新设备每月用电记录、公司每月用电记录！");
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//    @Scheduled(cron = "0 */1 * * * ?")
//    @Async
//    public void computeMonthlyWm(){
//        try {
//            timeMonthlyService.timeComputeMonthlyWm();
//            System.out.println("成功更新设备每月用水记录、公司每月用水记录！");
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
    /**
     * 每日用水用电定时任务 每天23点执行一次 现设为1分钟
     * */
//    @Scheduled(cron = "0 */1 * * * ?")
//    @Async
//    public void computeDailyEm(){
//        try {
//            timeDailyService.timeComputeDailyEm();
//            System.out.println("成功更新设备每日用电记录、公司每日用电记录！");
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//    @Scheduled(cron = "0 */1 * * * ?")
//    @Async
//    public void computeDailyWm(){
//        try {
//            timeDailyService.timeComputeDailyWm();
//            System.out.println("成功更新设备每日用水记录、公司每日用水记录！");
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }


}

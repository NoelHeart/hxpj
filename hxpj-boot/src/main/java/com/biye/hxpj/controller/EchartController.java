package com.biye.hxpj.controller;

import com.alibaba.fastjson.JSONObject;
import com.biye.hxpj.model.TotalEmDaily;
import com.biye.hxpj.model.TotalEmHour;
import com.biye.hxpj.model.TotalWmDaily;
import com.biye.hxpj.model.TotalWmHour;
import com.biye.hxpj.response.ResponseResult;
import com.biye.hxpj.service.EchartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: hxpj
 * @description: 图表逻辑控制
 * @author: LiLei
 * @create: 2019-05-10 15:34
 **/
@RequestMapping("/echart")
@RestController
public class EchartController {
    @Autowired
    EchartService echartService;
    /**
     * 首页 上月用电量变化图
     * */
    @GetMapping("/getLastMonthEmScaleList")
    public ResponseResult getLastMonthEmScaleList(){
        try {
            List<TotalEmDaily> totalEmDailyList=echartService.getEMDailyScaleList();
            int totalDay=totalEmDailyList.size();
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("totalDay",totalDay);
            jsonObject.put("list",totalEmDailyList);
            return ResponseResult.buildSuccess(jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"获取上月用电量变化图表异常！");
        }
    }
    /**
     * 首页 上月用水量变化图
     * */
    @GetMapping("/getLastMonthWmScaleList")
    public ResponseResult getLastMonthWmScaleList(){
        try {
            List<TotalWmDaily> totalWmDailyList=echartService.getWmDailyScaleList();
            int totalDay=totalWmDailyList.size();
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("totalDay",totalDay);
            jsonObject.put("list",totalWmDailyList);
            return ResponseResult.buildSuccess(jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"获取上月水量变化图表异常！");
        }
    }
    /**
     * 昨日总体用电量变化图
     * */
    @GetMapping("/getYesterdayEmChart")
    public ResponseResult getYesterdayEmChart(){
        try {
            List<TotalEmHour> totalEmHourList=echartService.getEmTotalHour();
            int totalHour=totalEmHourList.size();
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("totalDay",totalHour);
            jsonObject.put("list",totalEmHourList);
            return ResponseResult.buildSuccess(jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"获取昨日用电量变化图异常！");
        }
    }
    /**
     * 昨日总体用水量变化图
     * */
    @GetMapping("/getYesterdayWmChart")
    public ResponseResult getYesterdayWmChart(){
        try {
            List<TotalWmHour> totalwmHourList=echartService.getWmTotalHour();
            int totalHour=totalwmHourList.size();
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("totalDay",totalHour);
            jsonObject.put("list",totalwmHourList);
            return ResponseResult.buildSuccess(jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"获取昨日用水量变化图异常！");
        }
    }
}

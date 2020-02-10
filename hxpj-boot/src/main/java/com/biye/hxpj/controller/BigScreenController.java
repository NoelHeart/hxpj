package com.biye.hxpj.controller;

import com.alibaba.fastjson.JSONObject;
import com.biye.hxpj.mapper.HxscreenScreen11Mapper;
import com.biye.hxpj.mapper.HxscreenScreen23Mapper;
import com.biye.hxpj.mapper.HxscreenScreen24TodayMapper;
import com.biye.hxpj.mapper.HxscreenScreen24YesterMapper;
import com.biye.hxpj.model.HxscreenScreen21;
import com.biye.hxpj.response.ResponseResult;
import com.biye.hxpj.service.BigDataScreenService;
import com.biye.hxpj.utils.TotalHaoNeng;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: hxpj
 * @description: 大屏显示
 * @author: LiLei
 * @create: 2019-05-26 12:22
 **/
@RequestMapping("/bigScreen")
@RestController
public class BigScreenController {
    @Autowired
    BigDataScreenService bigDataScreenService;
    @GetMapping("/getTotalHaoNeng")
    public ResponseResult getTotalHaoNeng(){
        try {
            JSONObject jsonObject=new JSONObject();
            HxscreenScreen21 hxscreenScreen21= bigDataScreenService.getHxscreenHaoNeng();

            TotalHaoNeng totalHaoNeng1=new TotalHaoNeng();
            totalHaoNeng1.setDataType("电");
            totalHaoNeng1.setMonthUse(hxscreenScreen21.getEleMon());
            totalHaoNeng1.setYearUse(hxscreenScreen21.getEleYear());
            totalHaoNeng1.setUnit("千瓦时");
            TotalHaoNeng totalHaoNeng2=new TotalHaoNeng();
            totalHaoNeng2.setDataType("水");
            totalHaoNeng2.setMonthUse(hxscreenScreen21.getWaterMon());
            totalHaoNeng2.setYearUse(hxscreenScreen21.getWaterYear());
            totalHaoNeng2.setUnit("吨");
            TotalHaoNeng totalHaoNeng3=new TotalHaoNeng();
            totalHaoNeng3.setDataType("综合耗能");
            totalHaoNeng3.setMonthUse(hxscreenScreen21.getContentMon());
            totalHaoNeng3.setYearUse(hxscreenScreen21.getContentYear());
            totalHaoNeng3.setUnit("千克标准煤");

            List<TotalHaoNeng> totalHaoNengArrayList=new ArrayList<>();
            totalHaoNengArrayList.add(totalHaoNeng1);
            totalHaoNengArrayList.add(totalHaoNeng2);
            totalHaoNengArrayList.add(totalHaoNeng3);
            jsonObject.put("list",totalHaoNengArrayList);
            return ResponseResult.buildSuccess(jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"获取总耗能情况数据异常");
        }
    }
    @GetMapping("/getInComeChart")
    public ResponseResult getInComeChart(){
        try {
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("content",bigDataScreenService.getHxSscreenShouZhiList());
            return ResponseResult.buildSuccess(jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"获取收支情况表异常！");
        }
    }
    /**
     * 各大楼能耗饼状图
     * */
    @GetMapping("/getBuildUseData")
    public ResponseResult getBuildUseData(){
        try {
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("content",bigDataScreenService.getHxscreen22Last());
            return ResponseResult.buildSuccess(jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"获取能耗饼状图数据异常！");
        }
    }
    /**
     * 昨日今日用水用电折线图
     * */
    @Resource
    HxscreenScreen24TodayMapper hxscreenScreen24TodayMapper;
    @Resource
    HxscreenScreen24YesterMapper hxscreenScreen24YesterMapper;
    @GetMapping("/getYesTodUseData")
    public ResponseResult getYesTodUseData(){
        try {
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("yesList",hxscreenScreen24YesterMapper.findAll());
            jsonObject.put("todList",hxscreenScreen24TodayMapper.findAll());
            return ResponseResult.buildSuccess(jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"获取昨日今日用量数据异常！");
        }
    }
    /**
     * 12月耗能柱形图
     * */
    @Resource
    HxscreenScreen23Mapper hxscreenScreen23Mapper;
    @GetMapping("/getEmWm12Data")
    public ResponseResult getEmWm12Data(){
        try {
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("list",hxscreenScreen23Mapper.findAll());
            return ResponseResult.buildSuccess(jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"获取12月耗能数据异常！");
        }
    }
    /**
     *数量
     * */
    @Resource
    HxscreenScreen11Mapper hxscreenScreen11Mapper;
    @GetMapping("/getNumDeviceData")
    public ResponseResult getNumDeviceData(){
        try {
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("list",hxscreenScreen11Mapper.findAll());
            return ResponseResult.buildSuccess(jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"获取设备情况信息错误！");
        }
    }
}

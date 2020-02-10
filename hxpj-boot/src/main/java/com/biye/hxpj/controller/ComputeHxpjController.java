package com.biye.hxpj.controller;

import com.alibaba.fastjson.JSONObject;
import com.biye.hxpj.model.*;
import com.biye.hxpj.request.PageData;
import com.biye.hxpj.response.ResponseResult;
import com.biye.hxpj.service.ComputeDailyService;
import com.biye.hxpj.service.ComputeFirmService;
import com.biye.hxpj.service.HoneycombEWmApartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: hxpj
 * @description: 业务计算
 * @author: LiLei
 * @create: 2019-04-24 16:53
 **/

@RequestMapping("/compute")
@RestController
public class ComputeHxpjController {
    /**
     * @Param scale,device
     * compute1 每日用电统计
     * */
    @Autowired
    ComputeDailyService computeDailyService;
    @Autowired
    HoneycombEWmApartService honeycombEWmApartService;

    @RequestMapping("/getEmDailyRecordList")
    public ResponseResult getEmDailyRecordList(@RequestBody PageData pageData){
        try{
            if (pageData==null){
                return ResponseResult.buildError(4003,"获取EmDailyRecordList入参错误！");
            }
            Integer pageNum=pageData.getPageNum();
            Integer pageSize=pageData.getPageSize();
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("content",computeDailyService.getDailyEmRecordList(pageNum,pageSize));
            return ResponseResult.buildSuccess(jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"获取EmDailyRecordList异常！");
        }
    }
    @RequestMapping("/deleteEmDailyRecord")
    public ResponseResult deleteEmDailyRecord(@RequestBody ComputeEmDailydevicerecord computeEmDailydevicerecord){
        try{
            if (computeEmDailydevicerecord.getId()==null){
                return ResponseResult.buildError(4003,"删除记录失败，入参为空！");
            }
            computeDailyService.deleteDailyEmRecord(computeEmDailydevicerecord);
            JSONObject jsonObject=new JSONObject();
            return ResponseResult.buildSuccess(jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"删除记录异常！");
        }
    }
    @RequestMapping("/addEmDailyRecord")
    public ResponseResult addEmDailyRecord(@RequestBody ComputeEmDailydevicerecord computeEmDailydevicerecord){
        try{
            if (computeEmDailydevicerecord.getDevice()==null){
                return ResponseResult.buildError(4003,"入参为空！");
            }
            if (honeycombEWmApartService.selectEmByDeviceId(computeEmDailydevicerecord.getDevice())==null){
                return ResponseResult.buildError(4003,"该电表没有被部署！请先添加！");
            }
            computeDailyService.addDailyEmRecord(computeEmDailydevicerecord);
            JSONObject jsonObject=new JSONObject();
            return ResponseResult.buildSuccess("成功添加！",jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"添加记录异常！");
        }
    }
    /**
     * compute2 每日用水统计
     * */
    @RequestMapping("/getWmDailyRecordList")
    public ResponseResult getWmDailyRecordList(@RequestBody PageData pageData){
        try{
            if (pageData==null){
                return ResponseResult.buildError(4003,"获取WmDailyRecordList入参错误！");
            }
            Integer pageNum=pageData.getPageNum();
            Integer pageSize=pageData.getPageSize();
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("content",computeDailyService.getDailyWmRecordList(pageNum,pageSize));
            return ResponseResult.buildSuccess(jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"获取WmDailyRecordList异常！");
        }
    }
    @RequestMapping("/deleteWmDailyRecord")
    public ResponseResult deleteWmDailyRecord(@RequestBody ComputeWmDailydevicerecord computeWmDailydevicerecord){
        try{
            if (computeWmDailydevicerecord.getId()==null){
                return ResponseResult.buildError(4003,"删除记录失败，入参为空！");
            }
            computeDailyService.deleteDailyWmRecord(computeWmDailydevicerecord);
            JSONObject jsonObject=new JSONObject();
            return ResponseResult.buildSuccess(jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"删除记录异常！");
        }
    }
    @RequestMapping("/addWmDailyRecord")
    public ResponseResult addWmDailyRecord(@RequestBody ComputeWmDailydevicerecord computeWmDailydevicerecord){
        try{
            if (computeWmDailydevicerecord.getDevice()==null){
                return ResponseResult.buildError(4003,"入参为空！");
            }
            if (honeycombEWmApartService.selectWmByDeviceId(computeWmDailydevicerecord.getDevice())==null){
                return ResponseResult.buildError(4003,"该水表没有被部署！请先添加！");
            }
            computeDailyService.addDailyWmRecord(computeWmDailydevicerecord);
            JSONObject jsonObject=new JSONObject();
            return ResponseResult.buildSuccess("成功添加！",jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"添加记录异常！");
        }
    }
    /**
     * compute3 每月用电统计
     * */
    @RequestMapping("/getEmMonthRecordList")
    public ResponseResult getEmMonthRecordList(@RequestBody PageData pageData){
        try{
            if (pageData==null){
                return ResponseResult.buildError(4003,"获取EmMonthRecordList入参错误！");
            }
            Integer pageNum=pageData.getPageNum();
            Integer pageSize=pageData.getPageSize();
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("content",computeDailyService.getMonthlyEmRecordList(pageNum,pageSize));
            return ResponseResult.buildSuccess(jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"获取EmMonthRecordList异常！");
        }
    }
    @RequestMapping("/deleteEmMonthRecord")
    public ResponseResult deleteEmMonthRecord(@RequestBody ComputeEmMonthlydevicerecord computeEmMonthlydevicerecord){
        try{
            if (computeEmMonthlydevicerecord.getId()==null){
                return ResponseResult.buildError(4003,"删除记录失败，入参为空！");
            }
            computeDailyService.deleteMonthlyEmRecord(computeEmMonthlydevicerecord);
            JSONObject jsonObject=new JSONObject();
            return ResponseResult.buildSuccess(jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"删除记录异常！");
        }
    }
    @RequestMapping("/addEmMonthRecord")
    public ResponseResult addEmMonthRecord(@RequestBody ComputeEmMonthlydevicerecord computeEmMonthlydevicerecord){
        try{
            if (computeEmMonthlydevicerecord.getDevice()==null){
                return ResponseResult.buildError(4003,"入参为空！");
            }
            if (honeycombEWmApartService.selectEmByDeviceId(computeEmMonthlydevicerecord.getDevice())==null){
                return ResponseResult.buildError(4003,"该电表没有被部署！请先添加！");
            }
            computeDailyService.addMonthlyEmRecord(computeEmMonthlydevicerecord);
            JSONObject jsonObject=new JSONObject();
            return ResponseResult.buildSuccess("成功添加！",jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"添加记录异常！");
        }
    }
    /**
     * compute4 每月用水统计
     * */
    @RequestMapping("/getWmMonthRecordList")
    public ResponseResult getWmMonthRecordList(@RequestBody PageData pageData){
        try{
            if (pageData==null){
                return ResponseResult.buildError(4003,"获取EmMonthRecordList入参错误！");
            }
            Integer pageNum=pageData.getPageNum();
            Integer pageSize=pageData.getPageSize();
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("content",computeDailyService.getMonthlyWmRecordList(pageNum,pageSize));
            return ResponseResult.buildSuccess(jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"获取EmMonthRecordList异常！");
        }
    }
    @RequestMapping("/deleteWmMonthRecord")
    public ResponseResult deleteWmMonthRecord(@RequestBody ComputeWmMonthlydevicerecord computeWmMonthlydevicerecord){
        try{
            if (computeWmMonthlydevicerecord.getId()==null){
                return ResponseResult.buildError(4003,"删除记录失败，入参为空！");
            }
            computeDailyService.deleteMonthlyWmRecord(computeWmMonthlydevicerecord);
            JSONObject jsonObject=new JSONObject();
            return ResponseResult.buildSuccess(jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"删除记录异常！");
        }
    }
    @RequestMapping("/addWmMonthRecord")
    public ResponseResult addWmMonthRecord(@RequestBody ComputeWmMonthlydevicerecord computeWmMonthlydevicerecord){
        try{
            if (computeWmMonthlydevicerecord.getDevice()==null){
                return ResponseResult.buildError(4003,"入参为空！");
            }
            if (honeycombEWmApartService.selectWmByDeviceId(computeWmMonthlydevicerecord.getDevice())==null){
                return ResponseResult.buildError(4003,"该水表没有被部署！请先添加！");
            }
            computeDailyService.addMonthlyWmRecord(computeWmMonthlydevicerecord);
            JSONObject jsonObject=new JSONObject();
            return ResponseResult.buildSuccess("成功添加！",jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"添加记录异常！");
        }
    }

    @Autowired
    ComputeFirmService computeFirmService;
    /**
     * @Param scale,firmName
     * compute5 企业用电日统计
     * */
    @RequestMapping("/getEmFirmDaily")
    public ResponseResult getEmFirmDaily(@RequestBody PageData pageData){
        try{
            if (pageData==null){
                return ResponseResult.buildError(4003,"获取EmFirmDaily失败，入参为空！");
            }
            Integer pageNum=pageData.getPageNum();
            Integer pageSize=pageData.getPageSize();
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("content",computeFirmService.getEmFirmDailyList(pageNum,pageSize));
            return ResponseResult.buildSuccess(jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"获取EmFirmDaily异常！");
        }
    }
    @RequestMapping("/addEmFirmDaily")
    public ResponseResult addEmFirmDaily(@RequestBody ComputeEmDailyfirmrecord computeEmDailyfirmrecord){
        try {
            computeFirmService.addEmFirmDaily(computeEmDailyfirmrecord);
            JSONObject jsonObject=new JSONObject();
            return ResponseResult.buildSuccess("成功添加！",jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"添加EmFirmDaily异常！");
        }
    }
    @RequestMapping("/deleteEmFirmDaily")
    public ResponseResult deleteEmFirmDaily(@RequestBody ComputeEmDailyfirmrecord computeEmDailyfirmrecord){
        try {
            if (computeEmDailyfirmrecord.getId()==null){
                return ResponseResult.buildError(4003,"删除失败，入参为空！");
            }
            computeFirmService.deleteEmFirmDaily(computeEmDailyfirmrecord);
            JSONObject jsonObject=new JSONObject();
            return ResponseResult.buildSuccess("成功删除该记录！",jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"删除异常！");
        }
    }
    /**
     * compute6 企业用水日统计
     * */
    @RequestMapping("/getWmFirmDaily")
    public ResponseResult getWmFirmDaily(@RequestBody PageData pageData){
        try{
            if (pageData==null){
                return ResponseResult.buildError(4003,"获取WmFirmDaily失败，入参为空！");
            }
            Integer pageNum=pageData.getPageNum();
            Integer pageSize=pageData.getPageSize();
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("content",computeFirmService.getWmFirmDailyList(pageNum,pageSize));
            return ResponseResult.buildSuccess(jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"获取EmFirmDaily异常！");
        }
    }
    @RequestMapping("/addWmFirmDaily")
    public ResponseResult addWmFirmDaily(@RequestBody ComputeWmDailyfirmrecord computeWmDailyfirmrecord){
        try {
            computeFirmService.addWmFirmDaily(computeWmDailyfirmrecord);
            JSONObject jsonObject=new JSONObject();
            return ResponseResult.buildSuccess("成功添加！",jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"添加WmFirmDaily异常！");
        }
    }
    @RequestMapping("/deleteWmFirmDaily")
    public ResponseResult deleteWmFirmDaily(@RequestBody ComputeWmDailyfirmrecord computeWmDailyfirmrecord){
        try {
            if (computeWmDailyfirmrecord.getId()==null){
                return ResponseResult.buildError(4003,"删除失败，入参为空！");
            }
            computeFirmService.deleteWmFirmDaily(computeWmDailyfirmrecord);
            JSONObject jsonObject=new JSONObject();
            return ResponseResult.buildSuccess("成功删除该记录！",jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"删除异常！");
        }
    }
    /**
     * compute7 企业用电月统计
     * */
    @RequestMapping("/getEmFirmMonth")
    public ResponseResult getEmFirmMonth(@RequestBody PageData pageData){
        try{
            if (pageData==null){
                return ResponseResult.buildError(4003,"获取EmFirmMonth失败，入参为空！");
            }
            Integer pageNum=pageData.getPageNum();
            Integer pageSize=pageData.getPageSize();
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("content",computeFirmService.getEmFirmMonthlyList(pageNum,pageSize));
            return ResponseResult.buildSuccess(jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"获取EmFirmDaily异常！");
        }
    }
    @RequestMapping("/addEmFirmMonth")
    public ResponseResult addEmFirmMonth(@RequestBody ComputeEmMonthlyfirmrecord computeEmMonthlyfirmrecord){
        try {
            computeFirmService.addEmFirmMonthly(computeEmMonthlyfirmrecord);
            JSONObject jsonObject=new JSONObject();
            return ResponseResult.buildSuccess("成功添加！",jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"添加EmFirmMonthly异常！");
        }
    }
    @RequestMapping("/deleteEmFirmMonth")
    public ResponseResult deleteEmFirmMonth(@RequestBody ComputeEmMonthlyfirmrecord computeEmMonthlyfirmrecord){
        try {
            if (computeEmMonthlyfirmrecord.getId()==null){
                return ResponseResult.buildError(4003,"删除失败，入参为空！");
            }
            computeFirmService.deleteEmFirmMonthly(computeEmMonthlyfirmrecord);
            JSONObject json=new JSONObject();
            return ResponseResult.buildSuccess("成功删除该记录！",json);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"删除异常！");
        }
    }
    /**
     * compute8 企业用水月统计
     * */
    @RequestMapping("/getWmFirmMonth")
    public ResponseResult getWmFirmMonth(@RequestBody PageData pageData){
        try{
            if (pageData==null){
                return ResponseResult.buildError(4003,"获取WmFirmMonth失败，入参为空！");
            }
            Integer pageNum=pageData.getPageNum();
            Integer pageSize=pageData.getPageSize();
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("content",computeFirmService.getWmFirmMonthlyList(pageNum,pageSize));
            return ResponseResult.buildSuccess(jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"获取EmFirmDaily异常！");
        }
    }
    @RequestMapping("/addWmFirmMonth")
    public ResponseResult addWmFirmMonth(@RequestBody ComputeWmMonthlyfirmrecord computeWmMonthlyfirmrecord){
        try {
            computeFirmService.addWmFirmMonthly(computeWmMonthlyfirmrecord);
            JSONObject jsonObject=new JSONObject();
            return ResponseResult.buildSuccess("成功添加！",jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"添加WmFirmMonthly异常！");
        }
    }
    @RequestMapping("/deleteWmFirmMonth")
    public ResponseResult deleteWmFirmMonth(@RequestBody ComputeWmMonthlyfirmrecord computeWmMonthlyfirmrecord){
        try {
            if (computeWmMonthlyfirmrecord.getId()==null){
                return ResponseResult.buildError(4003,"删除失败，入参为空！");
            }
            computeFirmService.deleteWmFirmMonthly(computeWmMonthlyfirmrecord);
            JSONObject jsonObject=new JSONObject();
            return ResponseResult.buildSuccess("成功删除该记录！",jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"删除异常！");
        }
    }


}

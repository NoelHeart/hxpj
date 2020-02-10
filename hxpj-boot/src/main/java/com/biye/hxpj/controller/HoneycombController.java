package com.biye.hxpj.controller;

import com.alibaba.fastjson.JSONObject;
import com.biye.hxpj.mapper.HoneycombEmApartmentroomMapper;
import com.biye.hxpj.model.*;
import com.biye.hxpj.request.PageData;
import com.biye.hxpj.response.ResponseResult;
import com.biye.hxpj.service.*;
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.bcel.internal.generic.RET;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @program: hxpj
 * @description: 核心数据模块
 * @author: LiLei
 * @create: 2019-04-14 21:35
 **/
@RequestMapping("/honeycomb")
@RestController
public class HoneycombController {
    @Autowired
    private HoneycombFirmsService honeycombFirmsService;
/**
 * Honeycomb1逻辑控制  企业列表
 * */
    @PostMapping("/getFirmsList")
    public ResponseResult getFirmList(@RequestBody PageData pageData){
        try{
            if (pageData==null){
                return ResponseResult.buildError(4003,"获取frimlist入参错误！");
            }
            Integer page=pageData.getPageNum();
            Integer size=pageData.getPageSize();
            String firmname=pageData.getFirm();
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("content",honeycombFirmsService.findFirmList(page,size,firmname));
            return ResponseResult.buildSuccess(jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"获取公司表异常！");
        }
    }
    @PostMapping("/createFirm")
    public ResponseResult addFirm(@RequestBody HoneycombFirms honeycombFirms){
        try{
            JSONObject jsonObject=new JSONObject();
            if(honeycombFirms==null){
                return ResponseResult.buildError(4003,"入参为空！");
            }
            String name=honeycombFirms.getFirm();
            HoneycombFirms honeycombFirms1=honeycombFirmsService.findByName(name);
            if (honeycombFirms1==null){
                honeycombFirmsService.addFirm(honeycombFirms);
                return ResponseResult.buildSuccess("成功创建该公司",jsonObject);
            }else {
                return ResponseResult.buildError(4003,"该公司已存在!");
            }
        }catch (Exception e){
            return ResponseResult.buildError(4003,"添加公司异常！");
        }
    }
    @PostMapping("/updateFirm")
    public ResponseResult updateFirm(@RequestBody HoneycombFirms honeycombFirms){
        try{
            if (honeycombFirms==null){
                return ResponseResult.buildError(4003,"入参为空！");
            }
            honeycombFirmsService.updateFirm(honeycombFirms);
            JSONObject jsonObject=new JSONObject();
            return ResponseResult.buildSuccess("更新成功！",jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"更新公司后台异常！");
        }
    }
    @PostMapping("/deleteFirm")
    public ResponseResult deleteFirm(@RequestBody HoneycombFirms honeycombFirms){
        try{
            if (honeycombFirms==null){
                return ResponseResult.buildError(4003,"入参为空！");
            }
            honeycombFirmsService.deleteFirm(honeycombFirms.getId());
            JSONObject jsonObject=new JSONObject();
            return ResponseResult.buildSuccess("成功删除",jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"删除公司后台异常！");
        }
    }


    /**
     * Honeycomb2逻辑控制 企业用房分配
     * */


    @Autowired
    private HoneycombFirmApartmentService honeycombFirmApartmentService;
    /**
     * @Param: PageData封装所有分页list请求  pageNum  pageSize
     * */
    @PostMapping("/getFirmApartmentList")
    public ResponseResult getFirmApartmentList(@RequestBody PageData pageData){
        try{
            if (pageData==null){
                return ResponseResult.buildError(4003,"获取FirmApartmentList入参错误！");
            }
            Integer page=pageData.getPageNum();
            Integer size=pageData.getPageSize();
            String firm=pageData.getFirm();
            Long apartmentId=pageData.getApartmentId();
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("content",honeycombFirmApartmentService.findFirmApartmentroomList(page,size,firm,apartmentId));
            return ResponseResult.buildSuccess(jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"获取FirmApartmentList异常！");
        }
    }
    @PostMapping("/addFirmApartment")
    public ResponseResult addFirmApartment(@RequestBody FirmApartmentroom firmApartmentroom){
        try{
            if(firmApartmentroom==null){
                return ResponseResult.buildError(4003,"入参为空！");
            }
            if(firmApartmentroom.getFirm()==null){
                return ResponseResult.buildError(4003,"该公司不存在，请先添加该公司");
            }
            Long apartmentId=firmApartmentroom.getApartmentId();
            Long roomId=firmApartmentroom.getRoomId();
            if (honeycombFirmApartmentService.isHaveFrim(apartmentId,roomId)){
                return ResponseResult.buildError(4003,"该房间已被占用");
            }
            honeycombFirmApartmentService.addFirmApartment(firmApartmentroom);
            JSONObject jsonObject=new JSONObject();
            return ResponseResult.buildSuccess("成功添加！",jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"添加FirmApartment异常");
        }
    }
    @GetMapping("/getApartmentIdList")
    public ResponseResult getApartmentIdList(){
        try{
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("ApartmentIdList",honeycombFirmApartmentService.findApartment());
            return ResponseResult.buildSuccess(jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"获取ApartmentIdList异常！");
        }
    }
    @GetMapping("/getAllFrimList")
    public ResponseResult getAllFrimList(){
        try{
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("allFrimList",honeycombFirmsService.findAllFirm());
            return ResponseResult.buildSuccess(jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"获取getAllFrimList异常");
        }
    }
    @PostMapping("/updateFirmApart")
    public ResponseResult updateFirmApart(@RequestBody FirmApartmentroom firmApartmentroom){
        try{
            if(firmApartmentroom==null){
                return ResponseResult.buildError(4003,"入参为空！");
            }
            if(firmApartmentroom.getFirm()==null||firmApartmentroom.getFirm().equals("")){
                return ResponseResult.buildError(4003,"该公司不存在，请先添加该公司");
            }
            honeycombFirmApartmentService.updateById(firmApartmentroom);
            JSONObject jsonObject=new JSONObject();
            return ResponseResult.buildSuccess("更新数据成功！",jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"更新updateFirmApart异常！");
        }
    }
    @PostMapping("deleteFirmApart")
    public ResponseResult deleteFirmApart(@RequestBody FirmApartmentroom firmApartmentroom){
        try{
            if(firmApartmentroom.getId()==null){
                return ResponseResult.buildError(4003,"删除失败" );
            }
            int Aass=honeycombFirmApartmentService.deleteById(firmApartmentroom.getId());
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("dele",Aass);
            return ResponseResult.buildSuccess("成功删除数据！",jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"删除deleteFirmApart异常！");
        }
    }

    /**
     * Honeycomb3逻辑控制 电表清单
     * */
    @Autowired
    HoneycombMeterService honeycombMeterService;

    @PostMapping("/getElectricList")
    public ResponseResult getElectricList(@RequestBody PageData pageData){
        try{
            Integer pageNum=pageData.getPageNum();
            Integer pageSize=pageData.getPageSize();
            String deviceId=pageData.getMohuSelect();
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("content",honeycombMeterService.getElectricList(pageNum,pageSize,deviceId));
            return ResponseResult.buildSuccess(jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"获取getElectricList异常！");
        }
    }
    /**
     * @Param: deviceId  title  type（设备类型 0：电表1：水表）
     * */
    @PostMapping("/addElectricMeter")
    public ResponseResult addElectricMeter(@RequestBody HoneycombElectricMeter honeycombElectricMeter){
        try{
            if (honeycombElectricMeter.getDeviceId()==null){
                return ResponseResult.buildError(4003,"缺少DeviceId");
            }
            if (honeycombMeterService.electricIsHave(honeycombElectricMeter)){
                return ResponseResult.buildError(4003,"该电表已存在");
            }else {
                honeycombMeterService.addElectric(honeycombElectricMeter);
                JSONObject jsonObject=new JSONObject();
                return ResponseResult.buildSuccess("成功添加电表！",jsonObject);
            }
        }catch (Exception e){
            return ResponseResult.buildError(4003,"添加ElectricMeter异常！");
        }
    }
    @PostMapping("/updateElectricMeter")
    public ResponseResult updateElectricMeter(@RequestBody HoneycombElectricMeter honeycombElectricMeter){
        try{
            if (honeycombElectricMeter.getDeviceId()==null){
                return ResponseResult.buildError(4003,"数据为空！");
            }
            honeycombMeterService.updateElectric(honeycombElectricMeter);
            JSONObject jsonObject=new JSONObject();
            return ResponseResult.buildSuccess("更新ElectricMeter成功！",jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"更新ElectricMeter异常！");
        }
    }
    @PostMapping("/deleteElectricMeter")
    public  ResponseResult deleteElectricMeter(@RequestBody HoneycombElectricMeter honeycombElectricMeter){
        try{
            if (honeycombElectricMeter.getDeviceId()==null){
                return ResponseResult.buildError(4003,"ElectricMeter入参错误！");
            }
            honeycombMeterService.deleteElectric(honeycombElectricMeter);
            JSONObject jsonObject=new JSONObject();
            return ResponseResult.buildSuccess("删除ElectricMeter成功！",jsonObject);
        }
        catch (Exception e){
            return ResponseResult.buildError(4003,"删除ElectricMeter异常");
        }
    }

    /**
     * Honeycomb4逻辑控制 水表清单
     * */
    @PostMapping("/getWaterList")
    public ResponseResult getWaterList(@RequestBody PageData pageData){
        try{
            Integer pageNum=pageData.getPageNum();
            Integer pageSize=pageData.getPageSize();
            String deviceId=pageData.getMohuSelect();
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("content",honeycombMeterService.getWaterList(pageNum,pageSize,deviceId));
            return ResponseResult.buildSuccess(jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"获取getElectricList异常！");
        }
    }
    @PostMapping("/addWaterMeter")
    public ResponseResult addWaterMeter(@RequestBody HoneycombWaterMeter honeycombWaterMeter){
        try{
            if (honeycombWaterMeter.getDeviceId()==null){
                return ResponseResult.buildError(4003,"缺少水表DeviceId");
            }
            if (honeycombMeterService.waterIsHave(honeycombWaterMeter)){
                return ResponseResult.buildError(4003,"该水表已存在！");
            }else {
                honeycombMeterService.addWater(honeycombWaterMeter);
                JSONObject jsonObject=new JSONObject();
                return ResponseResult.buildSuccess("成功添加水表",jsonObject);
            }
        }catch (Exception e){
            return ResponseResult.buildError(4003,"添加WaterMeter异常");
        }
    }
    @PostMapping("/updateWaterMeter")
    public ResponseResult updateWaterMeter(@RequestBody HoneycombWaterMeter honeycombWaterMeter){
        try{
            if (honeycombWaterMeter.getDeviceId()==null){
                return ResponseResult.buildError(4003,"WaterMeter数据为空！");
            }
            honeycombMeterService.updateWater(honeycombWaterMeter);
            JSONObject jsonObject=new JSONObject();
            return ResponseResult.buildSuccess("更新WaterMeter成功！",jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"更新WaterMeter异常！");
        }
    }
    @PostMapping("/deleteWaterMeter")
    public  ResponseResult deleteWaterMeter(@RequestBody HoneycombWaterMeter honeycombWaterMeter){
        try{
            if (honeycombWaterMeter.getDeviceId()==null){
                return ResponseResult.buildError(4003,"deleteWaterMeter入参错误！");
            }
            honeycombMeterService.deleteWater(honeycombWaterMeter);
            JSONObject jsonObject=new JSONObject();
            return ResponseResult.buildSuccess("deleteWaterMeter成功！",jsonObject);
        }
        catch (Exception e){
            return ResponseResult.buildError(4003,"删除ElectricMeter异常");
        }
    }

    /**
     * Honeycomb5逻辑控制 电表部署
     * */
    @Autowired
    HoneycombEWmApartService honeycombEWmApartService;

    @PostMapping("/addEmApart")
    public ResponseResult addEmApart(@RequestBody HoneycombEmApartmentroom honeycombEmApartmentroom){
        try{
            if (honeycombEmApartmentroom==null){
                return ResponseResult.buildError(4003,"addEmApart入参为空");
            }
            if (honeycombEmApartmentroom.getDeviceId()==null){
                return ResponseResult.buildError(4003,"查无该电表！请先添加！");
            }
            String deviceId=honeycombEmApartmentroom.getDeviceId();
            Long apartId=honeycombEmApartmentroom.getApartmentId();
            Long roomId=honeycombEmApartmentroom.getRoomId();
            if (!honeycombFirmApartmentService.isHaveApart(apartId,roomId)){
                return ResponseResult.buildError(4003,"查无此房间，请先添加！");
            }
            if (honeycombEWmApartService.sleectEmByTwoId(apartId,roomId)!=null){
                return ResponseResult.buildError(4003,"该房间已部署电表");
            }
            if (honeycombEWmApartService.selectEmByDeviceId(deviceId)!=null){
                return ResponseResult.buildError(4003,"该电表已被部署！");
            }
            honeycombEWmApartService.addEmApartmentroom(honeycombEmApartmentroom);
            JSONObject jsonObject=new JSONObject();
            return ResponseResult.buildSuccess("成功部署该电表",jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"添加电表部署异常！");
        }
    }
    @PostMapping("/getEmApartList")
    public ResponseResult getEmApartList(@RequestBody PageData pageData){
        try{
            if (pageData == null){
                return ResponseResult.buildError(4003,"获取电表部署入参错误");
            }
            Integer pageNum = pageData.getPageNum();
            Integer pageSize=pageData.getPageSize();
            Long apartmentId=pageData.getApartmentId();
            Long roomId=pageData.getRoomId();
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("content",honeycombEWmApartService.getEmApartList(pageNum,pageSize,apartmentId,roomId));
            return ResponseResult.buildSuccess(jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"获取电表部署异常");
        }
    }
    @GetMapping("/getAllEm")
    public ResponseResult getAllEm(){
        try{
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("allEmList",honeycombMeterService.findAllElect());
            return ResponseResult.buildSuccess(jsonObject);
        }catch (Exception E){
            return ResponseResult.buildError(4003,"获取所有电表部署异常！");
        }
    }
    @PostMapping("/updateEmApart")
    public ResponseResult updateEmApart(@RequestBody HoneycombEmApartmentroom honeycombEmApartmentroom){
        try{
            if (honeycombEmApartmentroom.getDeviceId()==null || honeycombEmApartmentroom.getDeviceId().equals("")){
                return ResponseResult.buildError(4003,"查无该电表！请先添加电表！");
            }
            honeycombEWmApartService.updateEmApart(honeycombEmApartmentroom);
            JSONObject jsonObject=new JSONObject();
            return ResponseResult.buildSuccess("更新电表部署成功！",jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"更新电表部署异常");
        }
    }
    @PostMapping("/deleteEmApart")
    public ResponseResult deleteEmApart(@RequestBody HoneycombEmApartmentroom honeycombEmApartmentroom){
        try{
            if(honeycombEmApartmentroom.getId()==null){
                return ResponseResult.buildError(4003,"删除电表部署异常！");
            }
            honeycombEWmApartService.deleteEmApart(honeycombEmApartmentroom);
            JSONObject jsonObject=new JSONObject();
            return ResponseResult.buildSuccess("成功删除电表部署！",jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"删除电表部署异常！");
        }
    }
    /**
     * Honeycomb6逻辑控制 水表部署
     * */

    @PostMapping("/addWmApart")
    public ResponseResult addWmApart(@RequestBody HoneycombWmApartmentroom honeycombWmApartmentroom){
        try{
            if (honeycombWmApartmentroom.getDeviceId()==null){
                return ResponseResult.buildError(4003,"查无该水表，请先添加水表！");
            }
            String deviceId=honeycombWmApartmentroom.getDeviceId();
            Long apartId=honeycombWmApartmentroom.getApartmentId();
            Long roomId=honeycombWmApartmentroom.getRoomId();
            if (!honeycombFirmApartmentService.isHaveApart(apartId,roomId)){
                return ResponseResult.buildError(4003,"添加失败,查无此房间，请先添加该房间！");
            }
            HoneycombWmApartmentroom honeycombWmApartmentroom1=honeycombEWmApartService.sleectWmByTwoId(apartId,roomId);
            if (honeycombEWmApartService.sleectWmByTwoId(apartId,roomId)!=null){
                return ResponseResult.buildError(4003,"该房间已部署水表");
            }
            if (honeycombEWmApartService.selectWmByDeviceId(deviceId)!=null){
                return ResponseResult.buildError(4003,"该水表已被部署！");
            }
            honeycombEWmApartService.addWmApartmentroom(honeycombWmApartmentroom);
            JSONObject jsonObject=new JSONObject();
            return ResponseResult.buildSuccess("成功部署该水表",jsonObject);

        }catch (Exception e){
            return ResponseResult.buildError(4003,"添加水表部署异常！");
        }
    }
    @PostMapping("/getWmApartList")
    public ResponseResult getWmApartList(@RequestBody PageData pageData){
        try{
            if (pageData == null){
                return ResponseResult.buildError(4003,"获取水表部署入参错误");
            }
            Integer pageNum = pageData.getPageNum();
            Integer pageSize=pageData.getPageSize();
            Long apartmentId=pageData.getApartmentId();
            Long roomId=pageData.getRoomId();
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("content",honeycombEWmApartService.getWmApartList(pageNum,pageSize,apartmentId,roomId));
            return ResponseResult.buildSuccess(jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"获取水表部署异常");
        }
    }
    @GetMapping("/getAllWm")
    public ResponseResult getAllWm(){
        try{
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("allWmList",honeycombMeterService.findAllWater());
            return ResponseResult.buildSuccess(jsonObject);
        }catch (Exception E){
            return ResponseResult.buildError(4003,"获取所有水表异常！");
        }
    }
    @PostMapping("/updateWmApart")
    public ResponseResult updateEmApart(@RequestBody HoneycombWmApartmentroom honeycombwmApartmentroom){
        try{
            if (honeycombwmApartmentroom.getId()==null){
                return ResponseResult.buildError(4003,"updateWmApart入参为空！");
            }

            if (honeycombwmApartmentroom.getDeviceId()==null||honeycombwmApartmentroom.getDeviceId().equals("")){
                return ResponseResult.buildError(4003,"查无该水表，请先添加水表！");
            }
            honeycombEWmApartService.updateWmApart(honeycombwmApartmentroom);
            JSONObject jsonObject=new JSONObject();
            return ResponseResult.buildSuccess("更新水表部署成功！",jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"更新水表部署异常");
        }
    }
    @PostMapping("/deleteWmApart")
    public ResponseResult deleteEmApart(@RequestBody HoneycombWmApartmentroom honeycombWmApartmentroom){
        try{
            if(honeycombWmApartmentroom.getId()==null){
                return ResponseResult.buildError(4003,"删除水表部署异常！");
            }
            honeycombEWmApartService.deleteWmApart(honeycombWmApartmentroom);
            JSONObject jsonObject=new JSONObject();
            return ResponseResult.buildSuccess("成功删除水表部署！",jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"删除水表部署异常！");
        }
    }

    /**
     * Honeycomb7逻辑控制 住户登记
     * */
    @Autowired
    HoneycombRoomerService honeycombRoomerService;
    @PostMapping("/addRooomer")
    public ResponseResult addRooomer(@RequestBody HoneycombPersonApartmentroom honeycombPersonApartmentroom){
        try{
            if (honeycombPersonApartmentroom==null){
                return ResponseResult.buildError(4003,"添加住户入参为空！");
            }
            Long apartId=honeycombPersonApartmentroom.getApartmentId();
            Long roomId=honeycombPersonApartmentroom.getRoomId();
            if (!honeycombFirmApartmentService.isHaveApart(apartId,roomId)){
                return ResponseResult.buildError(4003,"添加失败,查无此房间，请先添加该房间！");
            }
            honeycombRoomerService.addRoomer(honeycombPersonApartmentroom);
            JSONObject jsonObject=new JSONObject();
            return ResponseResult.buildSuccess("成功添加住户！",jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"添加住户异常！");
        }
    }
    @PostMapping("/updateRoomer")
    public ResponseResult updateRoomer(@RequestBody HoneycombPersonApartmentroom honeycombPersonApartmentroom){
        try{
            if (honeycombPersonApartmentroom==null){
                return ResponseResult.buildError(4003,"更新住户入参为空！");
            }
            Long apartId=honeycombPersonApartmentroom.getApartmentId();
            Long roomId=honeycombPersonApartmentroom.getRoomId();
            if (!honeycombFirmApartmentService.isHaveApart(apartId,roomId)){
                return ResponseResult.buildError(4003,"添加失败,查无此房间，请先添加该房间！");
            }
            honeycombRoomerService.updateRoomer(honeycombPersonApartmentroom);
            JSONObject jsonObject=new JSONObject();
            return ResponseResult.buildSuccess("成功更新住户信息",jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"更新住户异常！");
        }
    }
    @PostMapping("/deleteRoomer")
    public ResponseResult deleteRoomer(@RequestBody HoneycombPersonApartmentroom honeycombPersonApartmentroom){
        try{
            if (honeycombPersonApartmentroom.getId()==null){
                return ResponseResult.buildError(4003,"删除住户失败，入参为空！");
            }
            honeycombRoomerService.deleteRoomer(honeycombPersonApartmentroom);
            JSONObject jsonObject=new JSONObject();
            return ResponseResult.buildSuccess("成功删除该住户！",jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"删除住户异常！");
        }
    }
    @PostMapping("/getRoomerList")
    public ResponseResult getRoomerList(@RequestBody PageData pageData){
        try{
            if (pageData==null){
                return ResponseResult.buildError(4003,"获取住户信息列表失败，入参为空！");
            }
            Integer pageNum=pageData.getPageNum();
            Integer pageSize=pageData.getPageSize();
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("content",honeycombRoomerService.getRoomList(pageNum,pageSize));
            return ResponseResult.buildSuccess(jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"获取住户信息列表异常！");
        }
    }

    /**
     * Honeycomb8逻辑控制 电表每小时记录
     * */
    @Autowired
    HoneycombRecordService honeycombRecordService;
    @Resource
    HoneycombEmApartmentroomMapper honeycombEmApartmentroomMapper;
    @PostMapping("/addEmRecord")
    public ResponseResult addEmRecord(@RequestBody HoneycombEmrecord honeycombEmrecord){
        try{
            if (honeycombEmrecord==null){
                return ResponseResult.buildError(4003,"添加电表每小时记录入参错误！");
            }
            if (honeycombEWmApartService.selectEmByDeviceId(honeycombEmrecord.getDeviceId())==null){
                return ResponseResult.buildError(4003,"该电表没有被部署！");
            }
            honeycombRecordService.addEmRecord(honeycombEmrecord);
            JSONObject jsonObject=new JSONObject();
            return ResponseResult.buildSuccess("成功添加电表每小时记录",jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"添加电表每小时记录异常!");
        }
    }
    @PostMapping("/getEmRecordList")
    public ResponseResult getEmRecordList(@RequestBody PageData pageData){
        try{
            if (pageData==null){
                return ResponseResult.buildError(4003,"入参错误！");
            }
            Integer pageNum=pageData.getPageNum();
            Integer pageSize=pageData.getPageSize();
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("content", honeycombRecordService.getEmRecordList(pageNum,pageSize));
            return ResponseResult.buildSuccess(jsonObject);
        }catch (Exception E){
            return ResponseResult.buildError(4003,"获取getEmRecordList异常！");
        }
    }
    @PostMapping("/updateEmRecord")
    public ResponseResult updateEmRecord(@RequestBody HoneycombEmrecord honeycombEmrecord){
        try{
            if (honeycombEmrecord.getId()==null){
                return ResponseResult.buildError(4003,"updateEmRecord入参为空！");
            }
            if (honeycombEWmApartService.selectEmByDeviceId(honeycombEmrecord.getDeviceId())==null){
                return ResponseResult.buildError(4003,"该电表没有被部署！");
            }
            honeycombRecordService.updateEmRecord(honeycombEmrecord);
            JSONObject jsonObject=new JSONObject();
            return ResponseResult.buildSuccess("成功更新电表每小时记录！",jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"更新updateEmRecord异常！");
        }
    }
    @PostMapping("/deleteEmRecord")
    public ResponseResult deleteEmRecord(@RequestBody HoneycombEmrecord honeycombEmrecord){
        try{
            if (honeycombEmrecord.getId()==null){
                return ResponseResult.buildError(4003,"deleteEmRecord入参错误！");
            }
            honeycombRecordService.deleteEmRecord(honeycombEmrecord);
            JSONObject jsonObject=new JSONObject();
            return ResponseResult.buildSuccess("成功删除电表每小时记录！",jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"deleteEmRecord异常！");
        }

    }
    @GetMapping("/getAEmRecord")
    public ResponseResult getAEmRecord(){
        try{
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("111",honeycombEmApartmentroomMapper.selectByTwoId(3l,702l));
            return ResponseResult.buildSuccess(jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"获取getAEmRecord异常");
        }
    }
    /**
     * Honeycomb9逻辑控制 水表每日记录
     * */
    @PostMapping("/addWmRecord")
    public ResponseResult addWmRecord(@RequestBody HoneycombWmrecord honeycombWmrecord){
        try{
            if (honeycombWmrecord==null){
                return ResponseResult.buildError(4003,"入参为空！");
            }
            if (honeycombEWmApartService.selectWmByDeviceId(honeycombWmrecord.getDeviceId())==null){
                return ResponseResult.buildError(4003,"该水表尚未部署，请先部署！");
            }
            honeycombRecordService.addWmRecord(honeycombWmrecord);
            JSONObject jsonObject=new JSONObject();
            return ResponseResult.buildSuccess("成功添加水表每日记录！",jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"添加水表每日记录异常！");
        }
    }
    @PostMapping("/getWmRecordList")
    public ResponseResult getWmRecordList(@RequestBody PageData pageData){
        try{
            if (pageData==null){
                return ResponseResult.buildError(4003,"getWmRecordList入参为空！");
            }
            Integer pageNum=pageData.getPageNum();
            Integer pageSize=pageData.getPageSize();
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("content",honeycombRecordService.getWmRecordList(pageNum,pageSize));
            return ResponseResult.buildSuccess(jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"getWmRecordList异常！");
        }
    }
    @PostMapping("/updateWmRecord")
    public ResponseResult updateWmRecord(@RequestBody HoneycombWmrecord honeycombWmrecord){
        try{
            if (honeycombWmrecord.getId()==null){
                return ResponseResult.buildError(4003,"updateWmRecord入参为空！");
            }
            if (honeycombEWmApartService.selectWmByDeviceId(honeycombWmrecord.getDeviceId())==null){
                return ResponseResult.buildError(4003,"该水表尚未部署，请先部署！");
            }
            honeycombRecordService.updateWmRecord(honeycombWmrecord);
            JSONObject jsonObject=new JSONObject();
            return ResponseResult.buildSuccess("成功更新水表每日记录！",jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"updateWmRecord异常！");
        }
    }
    @PostMapping("/deleteWmRecord")
    public ResponseResult deleteWmRecord(@RequestBody HoneycombWmrecord honeycombWmrecord){
        try{
            if (honeycombWmrecord.getId()==null){
                return ResponseResult.buildError(4003,"deleteWmRecord入参为空！");
            }
            honeycombRecordService.deleteWmRecord(honeycombWmrecord);
            JSONObject jsonObject=new JSONObject();
            return ResponseResult.buildSuccess("成功删除该水表每日记录",jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"deleteWmRecord异常！");
        }
    }

    /**
     * Honeycomb10逻辑控制 电表事件记录
     * */
    @Autowired
    HoneycombEventService honeycombEventService;
    @PostMapping("/getEmEventList")
    public ResponseResult getEmEventList(@RequestBody PageData pageData){
        try{
            if (pageData==null){
                return ResponseResult.buildError(4003,"获取电表事件失败，入参为空！");
            }
            Integer pageNum=pageData.getPageNum();
            Integer pageSize=pageData.getPageSize();
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("content",honeycombEventService.getEventList(pageNum,pageSize));
            return ResponseResult.buildSuccess(jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"获取电表事件列表异常！");
        }
    }
    @PostMapping("/addEmEvent")
    public ResponseResult addEmEvent(@RequestBody HoneycombEventrecord honeycombEventrecord){
        try{
            if (honeycombEventrecord==null){
                return ResponseResult.buildError(4003,"添加电表事件记录失败，入参错误！");
            }
            if (honeycombEWmApartService.selectEmByDeviceId(honeycombEventrecord.getDeviceId())==null){
                return ResponseResult.buildError(4003,"该电表没有被部署！请先添加！");
            }
            honeycombEventService.addEvent(honeycombEventrecord);
            JSONObject jsonObject=new JSONObject();
            return ResponseResult.buildSuccess("成功添加电表事件记录！",jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"添加addEmEvent异常！");
        }
    }
    @PostMapping("/updateEvent")
    public ResponseResult updateEvent(@RequestBody HoneycombEventrecord honeycombEventrecord){
        try{
            if (honeycombEventrecord.getId()==null){
                return ResponseResult.buildError(4003,"更新电表事件记录失败！入参错误！");
            }
            if (honeycombEWmApartService.selectEmByDeviceId(honeycombEventrecord.getDeviceId())==null){
                return ResponseResult.buildError(4003,"该电表没有被部署！请先添加！");
            }
            honeycombEventService.updateEvent(honeycombEventrecord);
            JSONObject jsonObject=new JSONObject();
            return ResponseResult.buildSuccess("成功更新电表事件记录！",jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"更新电表事件记录异常！");
        }
    }
    @PostMapping("/deleteEvent")
    public ResponseResult deleteEvent(@RequestBody HoneycombEventrecord honeycombEventrecord){
        try{
            if (honeycombEventrecord.getId()==null){
                return ResponseResult.buildError(4003,"删除电表事件记录失败，入参错误！");
            }
            honeycombEventService.deleteEvent(honeycombEventrecord);
            JSONObject jsonObject=new JSONObject();
            return ResponseResult.buildSuccess("成功删除电表事件记录！",jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"删除电表事件记录异常！");
        }
    }
}

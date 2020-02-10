package com.biye.hxpj.controller;

import com.alibaba.fastjson.JSONObject;
import com.biye.hxpj.model.*;
import com.biye.hxpj.request.PageData;
import com.biye.hxpj.response.ResponseResult;
import com.biye.hxpj.service.HxscreenFirstService;
import com.biye.hxpj.service.HxscreenSecondService;
import com.biye.hxpj.service.HxscreenThirdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: hxpj
 * @description: Hxscreen 大屏展示数据
 * @author: LiLei
 **/

@RequestMapping("/hxscreen")
@RestController
public class HxscreenController {
    @Autowired
    HxscreenFirstService hxscreenFirstService;
    @Autowired
    HxscreenSecondService hxscreenSecondService;

    /**
     * hxscreen1逻辑控制 地图显示数据
     * */
    @PostMapping("/getHxscreenMapList")
    public ResponseResult getHxscreenMapList(@RequestBody PageData pageData){
        try {
            if (pageData==null){
                return ResponseResult.buildError(4003,"获取地图显示数据失败，入参错误！");
            }
            Integer pageNum=pageData.getPageNum();
            Integer pageSize=pageData.getPageSize();
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("content",hxscreenFirstService.getHxscreenMapList(pageNum,pageSize));
            return ResponseResult.buildSuccess(jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"获取地图显示数据异常！");
        }
    }
    @PostMapping("/addHxscreenMap")
    public ResponseResult addHxscreenMap(@RequestBody HxscreenScreenMap hxscreenScreenMap){
        try {
            hxscreenFirstService.addHxscreenMap(hxscreenScreenMap);
            JSONObject jsonObject=new JSONObject();
            return ResponseResult.buildSuccess("成功添加地图显示数据！",jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"添加地图显示数据异常！");
        }
    }
    @PostMapping("/deleteHxscreenMap")
    public ResponseResult deleteHxscreenMap(@RequestBody HxscreenScreenMap hxscreenScreenMap){
        try {
            if (hxscreenScreenMap.getId()==null){
                return ResponseResult.buildError(4003,"删除地图显示数据失败，入参为空！");
            }
            JSONObject jsonObject=new JSONObject();
            hxscreenFirstService.deleteHxscreenMap(hxscreenScreenMap);
            return ResponseResult.buildSuccess("成功删除地图显示数据！",jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"删除地图显示数据异常！");
        }
    }
    /**
     * hxscreen2逻辑控制 智能设备情况
     * */
    @PostMapping("/getHxscreen11List")
    public ResponseResult getHxscreen11List(@RequestBody PageData pageData){
        try {
            if (pageData==null){
                return ResponseResult.buildError(4003,"获取智能设备情况失败，入参错误！");
            }
            Integer pageNum=pageData.getPageNum();
            Integer pageSize=pageData.getPageSize();
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("content",hxscreenFirstService.getHxscreen11List(pageNum,pageSize));
            return ResponseResult.buildSuccess(jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"获取智能设备情况异常！");
        }
    }
    @PostMapping("/addHxscreen11")
    public ResponseResult addHxscreen11(@RequestBody HxscreenScreen11 hxscreenScreen11){
        try {
            hxscreenFirstService.addHxscreen11(hxscreenScreen11);
            JSONObject jsonObject=new JSONObject();
            return ResponseResult.buildSuccess("成功添加智能设备情况！",jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"添加智能设备情况异常！");
        }
    }
    @PostMapping("/deleteHxscreen11")
    public ResponseResult deleteHxscreen11(@RequestBody HxscreenScreen11 hxscreenScreen11){
        try {
            if (hxscreenScreen11.getId()==null){
                return ResponseResult.buildError(4003,"删除智能设备情况失败，入参为空！");
            }
            JSONObject jsonObject=new JSONObject();
            hxscreenFirstService.deleteHxscreen11(hxscreenScreen11);
            return ResponseResult.buildSuccess("成功删除智能设备情况！",jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"删除智能设备情况异常！");
        }
    }
    /**
     * hxscreen3逻辑控制 各大楼能耗饼状图 hxscreen_screen2_2
     * */

    @PostMapping("/getHxscreen22List")
    public ResponseResult getHxscreen22List(@RequestBody PageData pageData){
        try {
            if (pageData==null){
                return ResponseResult.buildError(4003,"获取各大楼能耗饼状图失败，入参错误！");
            }
            Integer pageNum=pageData.getPageNum();
            Integer pageSize=pageData.getPageSize();
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("content",hxscreenFirstService.getHxscreen22List(pageNum,pageSize));
            return ResponseResult.buildSuccess(jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"获取各大楼能耗饼状图异常！");
        }
    }
    @PostMapping("/addHxscreen22")
    public ResponseResult addHxscreen22(@RequestBody HxscreenScreen22 hxscreenScreen22){
        try {
            hxscreenFirstService.addHxscreen22(hxscreenScreen22);
            JSONObject jsonObject=new JSONObject();
            return ResponseResult.buildSuccess("成功添加各大楼能耗饼状图！",jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"添加各大楼能耗饼状图异常！");
        }
    }
    @PostMapping("/deleteHxscreen22")
    public ResponseResult deleteHxscreen22(@RequestBody HxscreenScreen22 hxscreenScreen22){
        try {
            if (hxscreenScreen22.getId()==null){
                return ResponseResult.buildError(4003,"删除各大楼能耗饼状图失败，入参为空！");
            }
            JSONObject jsonObject=new JSONObject();
            hxscreenFirstService.deleteHxscreen22(hxscreenScreen22);
            return ResponseResult.buildSuccess("成功各大楼能耗饼状图！",jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"删除各大楼能耗饼状图异常！");
        }
    }

    /**
     * hxscreen4逻辑控制 当天用电量折线图 hxscreen_screen2_4_today
     * */

    @PostMapping("/getHxscreen24TodayList")
    public ResponseResult getHxscreen24TodayList(@RequestBody PageData pageData){
        try {
            if (pageData==null){
                return ResponseResult.buildError(4003,"获取当天用电量折线图失败，入参错误！");
            }
            Integer pageNum=pageData.getPageNum();
            Integer pageSize=pageData.getPageSize();
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("content",hxscreenFirstService.getHxscreen24TodayList(pageNum,pageSize));
            return ResponseResult.buildSuccess(jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"获取当天用电量折线图异常！");
        }
    }
    @PostMapping("/addHxscreen24Today")
    public ResponseResult addHxscreen24Today(@RequestBody HxscreenScreen24Today hxscreenScreen24Today){
        try {
            hxscreenFirstService.addHxscreen24Today(hxscreenScreen24Today);
            JSONObject jsonObject=new JSONObject();
            return ResponseResult.buildSuccess("成功添加当天用电量折线图！",jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"添加当天用电量折线图异常！");
        }
    }
    @PostMapping("/deleteHxscreen24Today")
    public ResponseResult deleteHxscreen24Today(@RequestBody HxscreenScreen24Today hxscreenScreen24Today){
        try {
            if (hxscreenScreen24Today.getId()==null){
                return ResponseResult.buildError(4003,"删除当天用电量折线图失败，入参为空！");
            }
            JSONObject jsonObject=new JSONObject();
            hxscreenFirstService.deleteHxscreen24Today(hxscreenScreen24Today);
            return ResponseResult.buildSuccess("成功删除当天用电量折线图！",jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"删除当天用电量折线图！");
        }
    }
    /**
     * hxscreen5逻辑控制 近12月耗能柱形图 hxscreen_screen2_3
     * */
    @PostMapping("/getHxscreen23List")
    public ResponseResult getHxscreen23List(@RequestBody PageData pageData){
        try {
            if (pageData==null){
                return ResponseResult.buildError(4003,"获取近12月耗能柱形图失败，入参错误！");
            }
            Integer pageNum=pageData.getPageNum();
            Integer pageSize=pageData.getPageSize();
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("content",hxscreenFirstService.getHxscreen23List(pageNum,pageSize));
            return ResponseResult.buildSuccess(jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"获取近12月耗能柱形图异常！");
        }
    }
    @PostMapping("/addHxscreen23")
    public ResponseResult addHxscreen23(@RequestBody HxscreenScreen23 hxscreenScreen23){
        try {
            hxscreenFirstService.addHxscreen23(hxscreenScreen23);
            JSONObject jsonObject=new JSONObject();
            return ResponseResult.buildSuccess("成功添加近12月耗能柱形图！",jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"添加近12月耗能柱形图异常！");
        }
    }
    @PostMapping("/deleteHxscreen23")
    public ResponseResult deleteHxscreen23(@RequestBody HxscreenScreen23 hxscreenScreen23){
        try {
            if (hxscreenScreen23.getId()==null){
                return ResponseResult.buildError(4003,"删除近12月耗能柱形图失败，入参为空！");
            }
            JSONObject jsonObject=new JSONObject();
            hxscreenFirstService.deleteHxscreen23(hxscreenScreen23);
            return ResponseResult.buildSuccess("成功删除近12月耗能柱形图！",jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"删除近12月耗能柱形图！");
        }
    }
    /**
     * hxscreen6逻辑控制 总能耗情况统计表格 hxscreen_screen2_1
     * */

    @PostMapping("/getHxscreen21List")
    public ResponseResult getHxscreen21List(@RequestBody PageData pageData){
        try {
            if (pageData==null){
                return ResponseResult.buildError(4003,"获取总能耗情况统计表格失败，入参错误！");
            }
            Integer pageNum=pageData.getPageNum();
            Integer pageSize=pageData.getPageSize();
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("content",hxscreenFirstService.getHxscreen21List(pageNum,pageSize));
            return ResponseResult.buildSuccess(jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"获取总能耗情况统计表格异常！");
        }
    }
    @PostMapping("/addHxscreen21")
    public ResponseResult addHxscreen21(@RequestBody HxscreenScreen21 hxscreenScreen21){
        try {
            hxscreenFirstService.addHxscreen21(hxscreenScreen21);
            JSONObject jsonObject=new JSONObject();
            return ResponseResult.buildSuccess("成功添加总能耗情况统计表格！",jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"添加总能耗情况统计表格异常！");
        }
    }
    @PostMapping("/deleteHxscreen21")
    public ResponseResult deleteHxscreen21(@RequestBody HxscreenScreen21 hxscreenScreen21){
        try {
            if (hxscreenScreen21.getId()==null){
                return ResponseResult.buildError(4003,"删除总能耗情况统计表格失败，入参为空！");
            }
            JSONObject jsonObject=new JSONObject();
            hxscreenFirstService.deleteHxscreen21(hxscreenScreen21);
            return ResponseResult.buildSuccess("成功删除总能耗情况统计表格！",jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"删除总能耗情况统计表格异常！");
        }
    }
    /**
     * hxscreen7逻辑控制 前一天电量折线图 hxscreen_screen2_4_yester
     * */
    @PostMapping("/getHxscreen24YesterList")
    public ResponseResult getHxscreen24YesterList(@RequestBody PageData pageData){
        try {
            if (pageData==null){
                return ResponseResult.buildError(4003,"获取前一天电量折线图失败，入参错误！");
            }
            Integer pageNum=pageData.getPageNum();
            Integer pageSize=pageData.getPageSize();
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("content",hxscreenSecondService.getHxscreen24YesterList(pageNum,pageSize));
            return ResponseResult.buildSuccess(jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"获取前一天电量折线图异常！");
        }
    }
    @PostMapping("/addHxscreen24Yester")
    public ResponseResult addHxscreen24Yester(@RequestBody HxscreenScreen24Yester hxscreenScreen24Yester){
        try {
            hxscreenSecondService.addHxscreen24Yester(hxscreenScreen24Yester);
            JSONObject jsonObject=new JSONObject();
            return ResponseResult.buildSuccess("成功添加前一天电量折线图！",jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"添加前一天电量折线图异常！");
        }
    }
    @PostMapping("/deleteHxscreen24Yester")
    public ResponseResult deleteHxscreen24Yester(@RequestBody HxscreenScreen24Yester hxscreenScreen24Yester){
        try {
            if (hxscreenScreen24Yester.getId()==null){
                return ResponseResult.buildError(4003,"删除前一天电量折线图失败，入参为空！");
            }
            JSONObject jsonObject=new JSONObject();
            hxscreenSecondService.deleteHxscreen24Yester(hxscreenScreen24Yester);
            return ResponseResult.buildSuccess("成功删除前一天电量折线图！",jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"删除前一天电量折线图异常！");
        }
    }

    /**
     * hxscreen8逻辑控制 收入与入住人数柱形图 hxscreen_screen1_2
     * */
    @PostMapping("/getHxscreen12List")
    public ResponseResult getHxscreen12List(@RequestBody PageData pageData){
        try {
            if (pageData==null){
                return ResponseResult.buildError(4003,"获取收入与入住人数柱形图失败，入参错误！");
            }
            Integer pageNum=pageData.getPageNum();
            Integer pageSize=pageData.getPageSize();
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("content",hxscreenSecondService.getHxscreen12List(pageNum,pageSize));
            return ResponseResult.buildSuccess(jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"获取收入与入住人数柱形图异常！");
        }
    }
    @PostMapping("/addHxscreen12")
    public ResponseResult addHxscreen12(@RequestBody HxscreenScreen12 hxscreenScreen12){
        try {
            hxscreenSecondService.addHxscreen12(hxscreenScreen12);
            JSONObject jsonObject=new JSONObject();
            return ResponseResult.buildSuccess("成功添加收入与入住人数柱形图！",jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"添加收入与入住人数柱形图异常！");
        }
    }
    @PostMapping("/deleteHxscreen12")
    public ResponseResult deleteHxscreen12(@RequestBody HxscreenScreen12 hxscreenScreen12){
        try {
            if (hxscreenScreen12.getId()==null){
                return ResponseResult.buildError(4003,"删除收入与入住人数柱形图失败，入参为空！");
            }
            JSONObject jsonObject=new JSONObject();
            hxscreenSecondService.deleteHxscreen12(hxscreenScreen12);
            return ResponseResult.buildSuccess("成功删除收入与入住人数柱形图！",jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"删除收入与入住人数柱形图异常！");
        }
    }

    /**
     * hxscreen9逻辑控制 摄像头列表 hxscreen_camera
     * */
    @PostMapping("/getHxscreenCameraList")
    public ResponseResult getHxscreenCameraList(@RequestBody PageData pageData){
        try {
            if (pageData==null){
                return ResponseResult.buildError(4003,"获取摄像头列表失败，入参错误！");
            }
            Integer pageNum=pageData.getPageNum();
            Integer pageSize=pageData.getPageSize();
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("content",hxscreenSecondService.getHxscreenCameraList(pageNum,pageSize));
            return ResponseResult.buildSuccess(jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"获取摄像头列表异常！");
        }
    }
    @PostMapping("/addHxscreenCamera")
    public ResponseResult addHxscreenCamera(@RequestBody HxscreenCamera hxscreenCamera){
        try {
            if (hxscreenCamera.getCameraId()==null){
                return ResponseResult.buildError(4003,"添加摄像头列表失败，入参为空！");
            }
            hxscreenSecondService.addHxscreenCamera(hxscreenCamera);
            JSONObject jsonObject=new JSONObject();
            return ResponseResult.buildSuccess("成功添加摄像头列表！",jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"添加摄像头列表异常！");
        }
    }
    @PostMapping("/deleteHxscreenCamera")
    public ResponseResult deleteHxscreenCamera(@RequestBody HxscreenCamera hxscreenCamera){
        try {
            if (hxscreenCamera.getCameraId()==null){
                return ResponseResult.buildError(4003,"删除摄像头列表失败，入参为空！");
            }
            JSONObject jsonObject=new JSONObject();
            hxscreenSecondService.deleteHxscreenCamera(hxscreenCamera);
            return ResponseResult.buildSuccess("成功删除摄像头列表！",jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"删除摄像头列表异常！");
        }
    }
    /**
     * hxscreen10逻辑控制 1号窗口摄像头 hxscreen_window1
     * */
    @PostMapping("/getHxscreenWindow1List")
    public ResponseResult getHxscreenWindow1List(@RequestBody PageData pageData){
        try {
            if (pageData==null){
                return ResponseResult.buildError(4003,"获取1号窗口摄像头失败，入参错误！");
            }
            Integer pageNum=pageData.getPageNum();
            Integer pageSize=pageData.getPageSize();
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("content",hxscreenSecondService.getHxscreenWindow1List(pageNum,pageSize));
            return ResponseResult.buildSuccess(jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"获取1号窗口摄像头异常！");
        }
    }
    @PostMapping("/addHxscreenWindow1")
    public ResponseResult addHxscreenWindow1(@RequestBody HxscreenWindow1 hxscreenWindow1){
        try {
            hxscreenSecondService.addHxscreenWindow1(hxscreenWindow1);
            JSONObject jsonObject=new JSONObject();
            return ResponseResult.buildSuccess("成功添加1号窗口摄像头！",jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"添加1号窗口摄像头异常！");
        }
    }
    @PostMapping("/deleteHxscreenWindow1")
    public ResponseResult deleteHxscreenWindow1(@RequestBody HxscreenWindow1 hxscreenWindow1){
        try {
            if (hxscreenWindow1.getId()==null){
                return ResponseResult.buildError(4003,"删除1号窗口摄像头失败，入参为空！");
            }
            JSONObject jsonObject=new JSONObject();
            hxscreenSecondService.deleteHxscreenWindow1(hxscreenWindow1);
            return ResponseResult.buildSuccess("成功删除1号窗口摄像头！",jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"删除1号窗口摄像头异常！");
        }
    }

    /**
     * hxscreen11逻辑控制 2号窗口摄像头 hxscreen_window2
     * */
    @PostMapping("/getHxscreenWindow2List")
    public ResponseResult getHxscreenWindow2List(@RequestBody PageData pageData){
        try {
            if (pageData==null){
                return ResponseResult.buildError(4003,"获取2号窗口摄像头失败，入参错误！");
            }
            Integer pageNum=pageData.getPageNum();
            Integer pageSize=pageData.getPageSize();
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("content",hxscreenSecondService.getHxscreenWindow2List(pageNum,pageSize));
            return ResponseResult.buildSuccess(jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"获取2号窗口摄像头异常！");
        }
    }
    @PostMapping("/addHxscreenWindow2")
    public ResponseResult addHxscreenWindow2(@RequestBody HxscreenWindow2 hxscreenWindow2){
        try {
            hxscreenSecondService.addHxscreenWindow2(hxscreenWindow2);
            JSONObject jsonObject=new JSONObject();
            return ResponseResult.buildSuccess("成功添加2号窗口摄像头！",jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"添加2号窗口摄像头异常！");
        }
    }
    @PostMapping("/deleteHxscreenWindow2")
    public ResponseResult deleteHxscreenWindow2(@RequestBody HxscreenWindow2 hxscreenWindow2){
        try {
            if (hxscreenWindow2.getId()==null){
                return ResponseResult.buildError(4003,"删除2号窗口摄像头失败，入参为空！");
            }
            JSONObject jsonObject=new JSONObject();
            hxscreenSecondService.deleteHxscreenWindow2(hxscreenWindow2);
            return ResponseResult.buildSuccess("成功删除2号窗口摄像头！",jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"删除2号窗口摄像头异常！");
        }
    }


    @Autowired
    HxscreenThirdService hxscreenThirdService;
    /**
     * hxscreen12逻辑控制 3号窗口摄像头 hxscreen_window3
     * */
    @PostMapping("/getHxscreenWindow3List")
    public ResponseResult getHxscreenWindow3List(@RequestBody PageData pageData){
        try {
            if (pageData==null){
                return ResponseResult.buildError(4003,"获取3号摄像头数据失败，入参错误！");
            }
            Integer pageNum=pageData.getPageNum();
            Integer pageSize=pageData.getPageSize();
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("content",hxscreenThirdService.getWindow3List(pageNum,pageSize));
            return ResponseResult.buildSuccess(jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"获取3号摄像头数据异常！");
        }
    }
    @PostMapping("/addHxscreenWindow3")
    public ResponseResult addHxscreenWindow3(@RequestBody HxscreenWindow3 hxscreenWindow3){
        try {
            JSONObject jsonObject=new JSONObject();
            hxscreenThirdService.addWindow3(hxscreenWindow3);
            return ResponseResult.buildSuccess("成功添加数据！",jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"添加3号摄像头数据异常");
        }
    }
    @PostMapping("/deleteHxscreenWindow3")
    public ResponseResult deleteHxscreenWindow3(@RequestBody HxscreenWindow3 hxscreenWindow3){
        try {
            if (hxscreenWindow3.getId()==null){
                return ResponseResult.buildError(4003,"删除3号摄像头数据失败，入参为空！");
            }
            JSONObject jsonObject=new JSONObject();
            hxscreenThirdService.deleteWindow3(hxscreenWindow3);
            return ResponseResult.buildSuccess("成功删除数据！",jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"删除3号摄像头数据异常！");
        }
    }
    /**
     * hxscreen13逻辑控制 4号窗口摄像头 hxscreen_window4
     * */
    @PostMapping("/getHxscreenWindow4List")
    public ResponseResult getHxscreenWindow4List(@RequestBody PageData pageData){
        try {
            if (pageData==null){
                return ResponseResult.buildError(4003,"获取4号摄像头数据失败，入参错误！");
            }
            Integer pageNum=pageData.getPageNum();
            Integer pageSize=pageData.getPageSize();
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("content",hxscreenThirdService.getWindow4List(pageNum,pageSize));
            return ResponseResult.buildSuccess(jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"获取4号摄像头数据异常！");
        }
    }
    @PostMapping("/addHxscreenWindow4")
    public ResponseResult addHxscreenWindow4(@RequestBody HxscreenWindow4 hxscreenWindow4){
        try {
            JSONObject jsonObject=new JSONObject();
            hxscreenThirdService.addWindow4(hxscreenWindow4);
            return ResponseResult.buildSuccess("成功添加数据！",jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"添加4号摄像头数据异常");
        }
    }
    @PostMapping("/deleteHxscreenWindow4")
    public ResponseResult deleteHxscreenWindow4(@RequestBody HxscreenWindow4 hxscreenWindow4){
        try {
            if (hxscreenWindow4.getId()==null){
                return ResponseResult.buildError(4003,"删除4号摄像头数据失败，入参为空！");
            }
            JSONObject jsonObject=new JSONObject();
            hxscreenThirdService.deleteWindow4(hxscreenWindow4);
            return ResponseResult.buildSuccess("成功删除数据！",jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"删除4号摄像头数据异常！");
        }
    }

    /**
     * hxscreen14逻辑控制 每日大楼用水 hxscreen_water_dailyuse
     * */

    @PostMapping("/getHxscreenWaterDailyList")
    public ResponseResult getHxscreenWaterDailyList(@RequestBody PageData pageData){
        try {
            if (pageData==null){
                return ResponseResult.buildError(4003,"获取每日大楼用水数据失败，入参错误！");
            }
            Integer pageNum=pageData.getPageNum();
            Integer pageSize=pageData.getPageSize();
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("content",hxscreenThirdService.getWaterDailyList(pageNum,pageSize));
            return ResponseResult.buildSuccess(jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"获取每日大楼用水数据异常！");
        }
    }
    @PostMapping("/addHxscreenWaterDaily")
    public ResponseResult addHxscreenWaterDaily(@RequestBody HxscreenWaterDailyuse hxscreenWaterDailyuse){
        try {
            JSONObject jsonObject=new JSONObject();
            hxscreenThirdService.addWaterDaily(hxscreenWaterDailyuse);
            return ResponseResult.buildSuccess("成功添加数据！",jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"添加每日大楼用水数据异常");
        }
    }
    @PostMapping("/deleteHxscreenWaterDaily")
    public ResponseResult deleteHxscreenWaterDaily(@RequestBody HxscreenWaterDailyuse hxscreenWaterDailyuse){
        try {
            if (hxscreenWaterDailyuse.getId()==null){
                return ResponseResult.buildError(4003,"删除每日大楼用水数据失败，入参为空！");
            }
            JSONObject jsonObject=new JSONObject();
            hxscreenThirdService.deleteWaterDaily(hxscreenWaterDailyuse);
            return ResponseResult.buildSuccess("成功删除数据！",jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"删除每日大楼用水数据异常！");
        }
    }
    /**
     * hxscreen15逻辑控制 每月大楼用水 hxscreen_water_monthlyuse
     * */
    @PostMapping("/getHxscreenWaterMonthlyList")
    public ResponseResult getHxscreenWaterMonthlyList(@RequestBody PageData pageData){
        try {
            if (pageData==null){
                return ResponseResult.buildError(4003,"获取每月大楼用水数据失败，入参错误！");
            }
            Integer pageNum=pageData.getPageNum();
            Integer pageSize=pageData.getPageSize();
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("content",hxscreenThirdService.getWaterMonthlyList(pageNum,pageSize));
            return ResponseResult.buildSuccess(jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"获取每月大楼用水数据异常！");
        }
    }
    @PostMapping("/addHxscreenWaterMonthly")
    public ResponseResult addHxscreenWaterMonthly(@RequestBody HxscreenWaterMonthlyuse hxscreenWaterMonthlyuse){
        try {
            JSONObject jsonObject=new JSONObject();
            hxscreenThirdService.addWaterMonthly(hxscreenWaterMonthlyuse);
            return ResponseResult.buildSuccess("成功添加数据！",jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"添加每月大楼用水数据异常");
        }
    }
    @PostMapping("/deleteHxscreenWaterMonthly")
    public ResponseResult deleteHxscreenWaterMonthly(@RequestBody HxscreenWaterMonthlyuse hxscreenWaterMonthlyuse){
        try {
            if (hxscreenWaterMonthlyuse.getId()==null){
                return ResponseResult.buildError(4003,"删除每月大楼用水数据失败，入参为空！");
            }
            JSONObject jsonObject=new JSONObject();
            hxscreenThirdService.deleteWaterMonthly(hxscreenWaterMonthlyuse);
            return ResponseResult.buildSuccess("成功删除数据！",jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"删除每月大楼用水数据异常！");
        }
    }
}

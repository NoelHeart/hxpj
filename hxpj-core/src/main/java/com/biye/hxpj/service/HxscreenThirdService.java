package com.biye.hxpj.service;

import com.biye.hxpj.model.HxscreenWaterDailyuse;
import com.biye.hxpj.model.HxscreenWaterMonthlyuse;
import com.biye.hxpj.model.HxscreenWindow3;
import com.biye.hxpj.model.HxscreenWindow4;
import com.github.pagehelper.PageInfo;

/**
 * @program: hxpj
 * @description: 后四个
 * @author: LiLei
 * 3号窗口摄像头 hxscreen_window3、4号窗口摄像头 hxscreen_window4、每日大楼用水 hxscreen_water_dailyuse、每月大楼用水 hxscreen_water_monthlyuse
 **/
public interface HxscreenThirdService {

    PageInfo<HxscreenWindow3> getWindow3List(Integer pageNum,Integer pageSize);

    PageInfo<HxscreenWindow4> getWindow4List(Integer pageNum, Integer pageSize);

    PageInfo<HxscreenWaterDailyuse> getWaterDailyList(Integer pageNum, Integer pageSize);

    PageInfo<HxscreenWaterMonthlyuse> getWaterMonthlyList(Integer pageNum, Integer pageSize);

    int addWindow3(HxscreenWindow3 hxscreenWindow3);

    int addWindow4(HxscreenWindow4 hxscreenWindow4);

    int addWaterDaily(HxscreenWaterDailyuse hxscreenWaterDailyuse);

    int addWaterMonthly(HxscreenWaterMonthlyuse hxscreenWaterMonthlyuse);

    int deleteWindow3(HxscreenWindow3 hxscreenWindow3);

    int deleteWindow4(HxscreenWindow4 hxscreenWindow4);

    int deleteWaterDaily(HxscreenWaterDailyuse hxscreenWaterDailyuse);

    int deleteWaterMonthly(HxscreenWaterMonthlyuse hxscreenWaterMonthlyuse);

}

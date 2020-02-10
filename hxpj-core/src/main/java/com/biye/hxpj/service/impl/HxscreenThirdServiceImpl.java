package com.biye.hxpj.service.impl;

import com.biye.hxpj.mapper.HxscreenWaterDailyuseMapper;
import com.biye.hxpj.mapper.HxscreenWaterMonthlyuseMapper;
import com.biye.hxpj.mapper.HxscreenWindow3Mapper;
import com.biye.hxpj.mapper.HxscreenWindow4Mapper;
import com.biye.hxpj.model.HxscreenWaterDailyuse;
import com.biye.hxpj.model.HxscreenWaterMonthlyuse;
import com.biye.hxpj.model.HxscreenWindow3;
import com.biye.hxpj.model.HxscreenWindow4;
import com.biye.hxpj.service.HxscreenThirdService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @program: hxpj
 * @description: 后四个
 * @author: LiLei
 * 3号窗口摄像头 hxscreen_window3、4号窗口摄像头 hxscreen_window4、每日大楼用水 hxscreen_water_dailyuse、每月大楼用水 hxscreen_water_monthlyuse
 **/

@Service
public class HxscreenThirdServiceImpl implements HxscreenThirdService {
    @Resource
    HxscreenWaterDailyuseMapper hxscreenWaterDailyuseMapper;
    @Resource
    HxscreenWaterMonthlyuseMapper hxscreenWaterMonthlyuseMapper;
    @Resource
    HxscreenWindow3Mapper hxscreenWindow3Mapper;
    @Resource
    HxscreenWindow4Mapper hxscreenWindow4Mapper;


    @Override
    public PageInfo<HxscreenWindow3> getWindow3List(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<HxscreenWindow3> list=hxscreenWindow3Mapper.findAll();
        PageInfo<HxscreenWindow3> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public PageInfo<HxscreenWindow4> getWindow4List(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<HxscreenWindow4> list=hxscreenWindow4Mapper.findALL();
        PageInfo<HxscreenWindow4> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public PageInfo<HxscreenWaterDailyuse> getWaterDailyList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<HxscreenWaterDailyuse> list=hxscreenWaterDailyuseMapper.findAll();
        PageInfo<HxscreenWaterDailyuse> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public PageInfo<HxscreenWaterMonthlyuse> getWaterMonthlyList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<HxscreenWaterMonthlyuse> list=hxscreenWaterMonthlyuseMapper.findAll();
        PageInfo<HxscreenWaterMonthlyuse> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public int addWindow3(HxscreenWindow3 hxscreenWindow3) {
        return hxscreenWindow3Mapper.insertSelective(hxscreenWindow3);
    }

    @Override
    public int addWindow4(HxscreenWindow4 hxscreenWindow4) {
        return hxscreenWindow4Mapper.insertSelective(hxscreenWindow4);
    }

    @Override
    public int addWaterDaily(HxscreenWaterDailyuse hxscreenWaterDailyuse) {
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String updateTime=sdf.format(date);
        hxscreenWaterDailyuse.setUpdateTime(updateTime);
        return hxscreenWaterDailyuseMapper.insertSelective(hxscreenWaterDailyuse);
    }

    @Override
    public int addWaterMonthly(HxscreenWaterMonthlyuse hxscreenWaterMonthlyuse) {
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String updateTime=sdf.format(date);
        hxscreenWaterMonthlyuse.setUpdateTime(updateTime);
        return hxscreenWaterMonthlyuseMapper.insertSelective(hxscreenWaterMonthlyuse);
    }

    @Override
    public int deleteWindow3(HxscreenWindow3 hxscreenWindow3) {
        return hxscreenWindow3Mapper.deleteByPrimaryKey(hxscreenWindow3.getId());
    }

    @Override
    public int deleteWindow4(HxscreenWindow4 hxscreenWindow4) {
        return hxscreenWindow4Mapper.deleteByPrimaryKey(hxscreenWindow4.getId());
    }

    @Override
    public int deleteWaterDaily(HxscreenWaterDailyuse hxscreenWaterDailyuse) {
        return hxscreenWaterDailyuseMapper.deleteByPrimaryKey(hxscreenWaterDailyuse.getId());
    }

    @Override
    public int deleteWaterMonthly(HxscreenWaterMonthlyuse hxscreenWaterMonthlyuse) {
        return hxscreenWaterMonthlyuseMapper.deleteByPrimaryKey(hxscreenWaterMonthlyuse.getId());
    }
}

package com.biye.hxpj.service.impl;

import com.biye.hxpj.mapper.*;
import com.biye.hxpj.model.*;
import com.biye.hxpj.service.HxscreenFirstService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @program: hxpj
 * @description: 前六个页面
 * @author: LiLei
 * @create: 2019-04-28 19:08
 * hxscreen_screen_map:地图显示数据、hxscreen_screen1_1：智能设备情况、hxscreen_screen2_2：各大楼能耗饼状图
 * hxscreen_screen2_4_today：当天用电量折线图、hxscreen_screen2_3：近12月耗能柱形图、hxscreen_screen2_1：总能耗情况统计表格
 **/
@Service
public class HxscreenFirstServiceImpl implements HxscreenFirstService {
    @Resource
    HxscreenScreenMapMapper hxscreenScreenMapMapper;
    @Resource
    HxscreenScreen11Mapper hxscreenScreen11Mapper;
    @Resource
    HxscreenScreen22Mapper hxscreenScreen22Mapper;
    @Resource
    HxscreenScreen24TodayMapper hxscreenScreen24TodayMapper;
    @Resource
    HxscreenScreen23Mapper hxscreenScreen23Mapper;
    @Resource
    HxscreenScreen21Mapper hxscreenScreen21Mapper;

    @Override
    public PageInfo<HxscreenScreenMap> getHxscreenMapList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<HxscreenScreenMap> list=hxscreenScreenMapMapper.findAll();
        PageInfo<HxscreenScreenMap> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public PageInfo<HxscreenScreen11> getHxscreen11List(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<HxscreenScreen11> list=hxscreenScreen11Mapper.findAll();
        PageInfo<HxscreenScreen11> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public PageInfo<HxscreenScreen22> getHxscreen22List(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<HxscreenScreen22> list=hxscreenScreen22Mapper.findAll();
        PageInfo<HxscreenScreen22> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public PageInfo<HxscreenScreen24Today> getHxscreen24TodayList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<HxscreenScreen24Today> list=hxscreenScreen24TodayMapper.findAll();
        PageInfo<HxscreenScreen24Today> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public PageInfo<HxscreenScreen23> getHxscreen23List(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<HxscreenScreen23> list=hxscreenScreen23Mapper.findAll();
        PageInfo<HxscreenScreen23> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public PageInfo<HxscreenScreen21> getHxscreen21List(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<HxscreenScreen21> list=hxscreenScreen21Mapper.findAll();
        PageInfo<HxscreenScreen21> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public int addHxscreenMap(HxscreenScreenMap hxscreenScreenMap) {
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String updateTime=sdf.format(date);
        hxscreenScreenMap.setTimes(updateTime);
        return hxscreenScreenMapMapper.insertSelective(hxscreenScreenMap);
    }

    @Override
    public int addHxscreen11(HxscreenScreen11 hxscreenScreen11) {
        return hxscreenScreen11Mapper.insertSelective(hxscreenScreen11);
    }

    @Override
    public int addHxscreen22(HxscreenScreen22 hxscreenScreen22) {
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String updateTime=sdf.format(date);
        hxscreenScreen22.setTimes(updateTime);
        return hxscreenScreen22Mapper.insertSelective(hxscreenScreen22);
    }

    @Override
    public int addHxscreen24Today(HxscreenScreen24Today hxscreenScreen24Today) {
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String updateTime=sdf.format(date);
        hxscreenScreen24Today.setTimes(updateTime);
        return hxscreenScreen24TodayMapper.insertSelective(hxscreenScreen24Today);
    }

    @Override
    public int addHxscreen23(HxscreenScreen23 hxscreenScreen23) {
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM");
        String updateTime=sdf.format(date);
        hxscreenScreen23.setTimes(updateTime);
        return hxscreenScreen23Mapper.insertSelective(hxscreenScreen23);
    }

    @Override
    public int addHxscreen21(HxscreenScreen21 hxscreenScreen21) {
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String updateTime=sdf.format(date);
        hxscreenScreen21.setTimes(updateTime);
        return hxscreenScreen21Mapper.insertSelective(hxscreenScreen21);
    }

    @Override
    public int deleteHxscreenMap(HxscreenScreenMap hxscreenScreenMap) {
        return hxscreenScreenMapMapper.deleteByPrimaryKey(hxscreenScreenMap.getId());
    }

    @Override
    public int deleteHxscreen11(HxscreenScreen11 hxscreenScreen11) {
        return hxscreenScreen11Mapper.deleteByPrimaryKey(hxscreenScreen11.getId());
    }

    @Override
    public int deleteHxscreen22(HxscreenScreen22 hxscreenScreen22) {
        return hxscreenScreen22Mapper.deleteByPrimaryKey(hxscreenScreen22.getId());
    }

    @Override
    public int deleteHxscreen24Today(HxscreenScreen24Today hxscreenScreen24Today) {
        return hxscreenScreen24TodayMapper.deleteByPrimaryKey(hxscreenScreen24Today.getId());
    }

    @Override
    public int deleteHxscreen23(HxscreenScreen23 hxscreenScreen23) {
        return hxscreenScreen23Mapper.deleteByPrimaryKey(hxscreenScreen23.getId());
    }

    @Override
    public int deleteHxscreen21(HxscreenScreen21 hxscreenScreen21) {
        return hxscreenScreen21Mapper.deleteByPrimaryKey(hxscreenScreen21.getId());
    }
}

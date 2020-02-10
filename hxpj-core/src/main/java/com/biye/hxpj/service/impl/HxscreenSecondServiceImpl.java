package com.biye.hxpj.service.impl;

import com.biye.hxpj.mapper.*;
import com.biye.hxpj.model.*;
import com.biye.hxpj.service.HxscreenSecondService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @program: hxpj
 * @description: 后五个功能
 * @author: LiLei
 *前一天电量折线图：hxscreen_screen2_4_yester、收入与入住人数柱形图：hxscreen_screen1_2、摄像头列表：hxscreen_camera、
 *   1号窗口摄像头：hxscreen_window1、2号窗口摄像头：hxscreen_window2
 **/

@Service
public class HxscreenSecondServiceImpl implements HxscreenSecondService {
    @Resource
    HxscreenScreen24YesterMapper hxscreenScreen24YesterMapper;
    @Resource
    HxscreenScreen12Mapper hxscreenScreen12Mapper;
    @Resource
    HxscreenCameraMapper hxscreenCameraMapper;
    @Resource
    HxscreenWindow1Mapper hxscreenWindow1Mapper;
    @Resource
    HxscreenWindow2Mapper hxscreenWindow2Mapper;


    @Override
    public PageInfo<HxscreenScreen24Yester> getHxscreen24YesterList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<HxscreenScreen24Yester> list=hxscreenScreen24YesterMapper.findAll();
        PageInfo<HxscreenScreen24Yester> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public PageInfo<HxscreenScreen12> getHxscreen12List(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<HxscreenScreen12> list=hxscreenScreen12Mapper.findAll();
        PageInfo<HxscreenScreen12> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public PageInfo<HxscreenCamera> getHxscreenCameraList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<HxscreenCamera> list=hxscreenCameraMapper.findAll();
        PageInfo<HxscreenCamera> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public PageInfo<HxscreenWindow1> getHxscreenWindow1List(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<HxscreenWindow1> list=hxscreenWindow1Mapper.findAll();
        PageInfo<HxscreenWindow1> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public PageInfo<HxscreenWindow2> getHxscreenWindow2List(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<HxscreenWindow2> list=hxscreenWindow2Mapper.findAll();
        PageInfo<HxscreenWindow2> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public int addHxscreen24Yester(HxscreenScreen24Yester hxscreenScreen24Yester) {
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String updateTime=sdf.format(date);
        hxscreenScreen24Yester.setTimes(updateTime);
        return hxscreenScreen24YesterMapper.insertSelective(hxscreenScreen24Yester);
    }

    @Override
    public int addHxscreen12(HxscreenScreen12 hxscreenScreen12) {
        return hxscreenScreen12Mapper.insertSelective(hxscreenScreen12);
    }

    @Override
    public int addHxscreenCamera(HxscreenCamera hxscreenCamera) {
        return hxscreenCameraMapper.insertSelective(hxscreenCamera);
    }

    @Override
    public int addHxscreenWindow1(HxscreenWindow1 hxscreenWindow1) {
        return hxscreenWindow1Mapper.insertSelective(hxscreenWindow1);
    }

    @Override
    public int addHxscreenWindow2(HxscreenWindow2 hxscreenWindow2) {
        return hxscreenWindow2Mapper.insertSelective(hxscreenWindow2);
    }

    @Override
    public int deleteHxscreen24Yester(HxscreenScreen24Yester hxscreenScreen24Yester) {
        return hxscreenScreen24YesterMapper.deleteByPrimaryKey(hxscreenScreen24Yester.getId());
    }

    @Override
    public int deleteHxscreen12(HxscreenScreen12 hxscreenScreen12) {
        return hxscreenScreen12Mapper.deleteByPrimaryKey(hxscreenScreen12.getId());
    }

    @Override
    public int deleteHxscreenCamera(HxscreenCamera hxscreenCamera) {
        return hxscreenCameraMapper.deleteByPrimaryKey(hxscreenCamera.getCameraId());
    }

    @Override
    public int deleteHxscreenWindow1(HxscreenWindow1 hxscreenWindow1) {
        return hxscreenWindow1Mapper.deleteByPrimaryKey(hxscreenWindow1.getId());
    }

    @Override
    public int deleteHxscreenWindow2(HxscreenWindow2 hxscreenWindow2) {
        return hxscreenWindow2Mapper.deleteByPrimaryKey(hxscreenWindow2.getId());
    }
}

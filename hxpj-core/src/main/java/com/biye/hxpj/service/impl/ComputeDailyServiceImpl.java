package com.biye.hxpj.service.impl;

import com.biye.hxpj.mapper.*;
import com.biye.hxpj.model.*;
import com.biye.hxpj.service.ComputeDailyService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @program: hxpj
 * @description: 每日统计
 * @author: LiLei
 * @create: 2019-04-24 16:59
 **/

@Service
public class ComputeDailyServiceImpl implements ComputeDailyService {
    @Resource
    ComputeEmDailydevicerecordMapper computeEmDailydevicerecordMapper;
    @Resource
    ComputeWmDailydevicerecordMapper computeWmDailydevicerecordMapper;
    @Resource
    ComputeEmMonthlydevicerecordMapper computeEmMonthlydevicerecordMapper;
    @Resource
    ComputeWmMonthlydevicerecordMapper computeWmMonthlydevicerecordMapper;

    @Resource
    HoneycombEmApartmentroomMapper honeycombEmApartmentroomMapper;
    @Resource
    HoneycombWmApartmentroomMapper honeycombWmApartmentroomMapper;
    @Resource
    FirmApartmentroomMapper firmApartmentroomMapper;

    @Override
    public PageInfo<ComputeEmDailydevicerecord> getDailyEmRecordList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<ComputeEmDailydevicerecord> list=computeEmDailydevicerecordMapper.findAll();
        PageInfo<ComputeEmDailydevicerecord> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public PageInfo<ComputeWmDailydevicerecord> getDailyWmRecordList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<ComputeWmDailydevicerecord> list=computeWmDailydevicerecordMapper.findAll();
        PageInfo<ComputeWmDailydevicerecord> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public PageInfo<ComputeEmMonthlydevicerecord> getMonthlyEmRecordList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<ComputeEmMonthlydevicerecord> list=computeEmMonthlydevicerecordMapper.findAll();
        PageInfo<ComputeEmMonthlydevicerecord> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public PageInfo<ComputeWmMonthlydevicerecord> getMonthlyWmRecordList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<ComputeWmMonthlydevicerecord> list=computeWmMonthlydevicerecordMapper.findAll();
        PageInfo<ComputeWmMonthlydevicerecord> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public int addDailyEmRecord(ComputeEmDailydevicerecord computeEmDailydevicerecord) {
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
        String dateDay=sdf1.format(date);
        String updateTime=sdf.format(date);
        String deviceId=computeEmDailydevicerecord.getDevice();
        HoneycombEmApartmentroom honeycombEmApartmentroom=honeycombEmApartmentroomMapper.selectByDevice(deviceId);
        Long apartmentId=00L;
        Long roomId=600L;
        if (honeycombEmApartmentroom!=null){
            apartmentId=honeycombEmApartmentroom.getApartmentId();
            roomId=honeycombEmApartmentroom.getRoomId();
        }
        FirmApartmentroom firmApartmentroom=firmApartmentroomMapper.selectById(apartmentId,roomId);
        String firm="未分配";
        if (firmApartmentroom!=null){
            firm=firmApartmentroom.getFirm();
        }
        computeEmDailydevicerecord.setApartmentId(apartmentId);
        computeEmDailydevicerecord.setRoomId(roomId);
        computeEmDailydevicerecord.setFirmName(firm);
        computeEmDailydevicerecord.setUpdateTime(updateTime);
        computeEmDailydevicerecord.setDateDay(dateDay);
        return computeEmDailydevicerecordMapper.insertSelective(computeEmDailydevicerecord);
    }

    @Override
    public int addDailyWmRecord(ComputeWmDailydevicerecord computeWmDailydevicerecord) {
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
        String dateDay=sdf1.format(date);
        String updateTime=sdf.format(date);
        String deviceId=computeWmDailydevicerecord.getDevice();
        HoneycombWmApartmentroom wmApartmentroom=honeycombWmApartmentroomMapper.selectByDevice(deviceId);
        Long apartmentId=00L;
        Long roomId=600L;
        if (wmApartmentroom!=null){
            apartmentId=wmApartmentroom.getApartmentId();
            roomId=wmApartmentroom.getRoomId();
        }
        FirmApartmentroom firmApartmentroom=firmApartmentroomMapper.selectById(apartmentId,roomId);
        String firm="未分配";
        if (firmApartmentroom!=null){
            firm=firmApartmentroom.getFirm();
        }
        computeWmDailydevicerecord.setFirmName(firm);
        computeWmDailydevicerecord.setApartmentId(apartmentId);
        computeWmDailydevicerecord.setRoomId(roomId);
        computeWmDailydevicerecord.setDateDay(dateDay);
        computeWmDailydevicerecord.setUpdateTime(updateTime);
        return computeWmDailydevicerecordMapper.insertSelective(computeWmDailydevicerecord);
    }

    @Override
    public int addMonthlyEmRecord(ComputeEmMonthlydevicerecord computeEmMonthlydevicerecord) {
        String deviceId=computeEmMonthlydevicerecord.getDevice();
        HoneycombEmApartmentroom honeycombEmApartmentroom=honeycombEmApartmentroomMapper.selectByDevice(deviceId);
        Long apartmentId=00L;
        Long roomId=600L;
        if (honeycombEmApartmentroom!=null){
            apartmentId=honeycombEmApartmentroom.getApartmentId();
            roomId=honeycombEmApartmentroom.getRoomId();
        }
        FirmApartmentroom firmApartmentroom=firmApartmentroomMapper.selectById(apartmentId,roomId);
        String firm="未分配";
        if (firmApartmentroom!=null){
            firm=firmApartmentroom.getFirm();
        }
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM");
        String dateMonth=sdf1.format(date);
        String updateTime=sdf.format(date);
        computeEmMonthlydevicerecord.setApartmentId(apartmentId);
        computeEmMonthlydevicerecord.setRoomId(roomId);
        computeEmMonthlydevicerecord.setFirmName(firm);
        computeEmMonthlydevicerecord.setDateMonth(dateMonth);
        computeEmMonthlydevicerecord.setUpdateTime(updateTime);
        return computeEmMonthlydevicerecordMapper.insertSelective(computeEmMonthlydevicerecord);
    }

    @Override
    public int addMonthlyWmRecord(ComputeWmMonthlydevicerecord computeWmMonthlydevicerecord) {
        String deviceId=computeWmMonthlydevicerecord.getDevice();
        HoneycombWmApartmentroom wmApartmentroom=honeycombWmApartmentroomMapper.selectByDevice(deviceId);
        Long apartmentId=00L;
        Long roomId=600L;
        if (wmApartmentroom!=null){
            apartmentId=wmApartmentroom.getApartmentId();
            roomId=wmApartmentroom.getRoomId();
        }
        FirmApartmentroom firmApartmentroom=firmApartmentroomMapper.selectById(apartmentId,roomId);
        String firm="未分配";
        if (firmApartmentroom!=null){
            firm=firmApartmentroom.getFirm();
        }
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM");
        String dateMonth=sdf1.format(date);
        String updateTime=sdf.format(date);
        computeWmMonthlydevicerecord.setApartmentId(apartmentId);
        computeWmMonthlydevicerecord.setFirmName(firm);
        computeWmMonthlydevicerecord.setRoomId(roomId);
        computeWmMonthlydevicerecord.setDateMonth(dateMonth);
        computeWmMonthlydevicerecord.setUpdateTime(updateTime);
        return computeWmMonthlydevicerecordMapper.insertSelective(computeWmMonthlydevicerecord);
    }

    @Override
    public int updateDailyEmRecord(ComputeEmDailydevicerecord computeEmDailydevicerecord) {
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String updateTime=sdf.format(date);
        computeEmDailydevicerecord.setUpdateTime(updateTime);
        return computeEmDailydevicerecordMapper.updateByPrimaryKeySelective(computeEmDailydevicerecord);
    }

    @Override
    public int deleteDailyEmRecord(ComputeEmDailydevicerecord computeEmDailydevicerecord) {
        Long idd=computeEmDailydevicerecord.getId();
        return computeEmDailydevicerecordMapper.deleteByPrimaryKey(idd);
    }

    @Override
    public int deleteDailyWmRecord(ComputeWmDailydevicerecord computeWmDailydevicerecord) {
        Long iddd=computeWmDailydevicerecord.getId();
        return computeWmDailydevicerecordMapper.deleteByPrimaryKey(iddd);
    }

    @Override
    public int deleteMonthlyEmRecord(ComputeEmMonthlydevicerecord computeEmMonthlydevicerecord) {
        Long idd=computeEmMonthlydevicerecord.getId();
        return computeEmMonthlydevicerecordMapper.deleteByPrimaryKey(idd);
    }

    @Override
    public int deleteMonthlyWmRecord(ComputeWmMonthlydevicerecord computeWmMonthlydevicerecord) {
        Long idd=computeWmMonthlydevicerecord.getId();
        return computeWmMonthlydevicerecordMapper.deleteByPrimaryKey(idd);
    }
}

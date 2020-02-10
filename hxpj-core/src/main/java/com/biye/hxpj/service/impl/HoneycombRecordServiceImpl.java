package com.biye.hxpj.service.impl;

import com.biye.hxpj.mapper.*;
import com.biye.hxpj.model.*;
import com.biye.hxpj.service.HoneycombRecordService;
import com.biye.hxpj.service.HoneycombRoomerService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @program: hxpj
 * @description: 电表每小时记录、水表每日记录
 * @author: LiLei
 * @create: 2019-04-22 00:18
 **/
@Service
public class HoneycombRecordServiceImpl implements HoneycombRecordService {
    @Resource
    HoneycombEmrecordMapper honeycombEmrecordMapper;
    @Resource
    HoneycombWmrecordMapper honeycombWmrecordMapper;
    @Resource
    HoneycombEmApartmentroomMapper honeycombEmApartmentroomMapper;
    @Resource
    HoneycombWmApartmentroomMapper honeycombWmApartmentroomMapper;
    @Resource
    FirmApartmentroomMapper firmApartmentroomMapper;

    @Override
    public PageInfo<HoneycombEmrecord> getEmRecordList(Integer pageNum, Integer pageSize) {
        List<HoneycombEmrecord> list3=honeycombEmrecordMapper.findAll();
        PageHelper.startPage(pageNum,pageSize);
        List<HoneycombEmrecord> list1=honeycombEmrecordMapper.findAll();
        for (HoneycombEmrecord honeycombEmrecord : list1){
            String deviceId=honeycombEmrecord.getDeviceId();
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
            honeycombEmrecord.setApartmentId(apartmentId);
            honeycombEmrecord.setRoomId(roomId);
            honeycombEmrecord.setFirm(firm);
        }
        PageInfo<HoneycombEmrecord> pageInfo=new PageInfo<>(list1);
        pageInfo.setTotal(list3.size());
        return pageInfo;
    }

    @Override
    public PageInfo<HoneycombWmrecord> getWmRecordList(Integer pageNum, Integer pageSize) {
        List<HoneycombWmrecord> list3=honeycombWmrecordMapper.findAll();
        PageHelper.startPage(pageNum,pageSize);
        List<HoneycombWmrecord> list1=honeycombWmrecordMapper.findAll();
        for (HoneycombWmrecord wmRecord:list1){
            String deviceId=wmRecord.getDeviceId();
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
            wmRecord.setApartmentId(apartmentId);
            wmRecord.setRoomId(roomId);
            wmRecord.setFirm(firm);
        }
        PageInfo<HoneycombWmrecord> pageInfo=new PageInfo<>(list1);
        pageInfo.setTotal(list3.size());
        return pageInfo;
    }

    @Override
    public int addEmRecord(HoneycombEmrecord honeycombEmrecord) {
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String adddate=sdf.format(date);
        String updateTime="";
        honeycombEmrecord.setDataTime(adddate);
        honeycombEmrecord.setUpdateTime(updateTime);
        return honeycombEmrecordMapper.insertSelective(honeycombEmrecord);
    }

    @Override
    public int addWmRecord(HoneycombWmrecord honeycombWmrecord) {
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String createTime=sdf.format(date);
        String updateTime="";
        honeycombWmrecord.setUpdateTime(updateTime);
        honeycombWmrecord.setDataTime(createTime);
        return honeycombWmrecordMapper.insertSelective(honeycombWmrecord);
    }

    @Override
    public int updateEmRecord(HoneycombEmrecord honeycombEmrecord) {
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String updateTime=sdf.format(date);
        honeycombEmrecord.setUpdateTime(updateTime);
        return honeycombEmrecordMapper.updateByPrimaryKeySelective(honeycombEmrecord);
    }

    @Override
    public int updateWmRecord(HoneycombWmrecord honeycombWmrecord) {
        Date date=new Date();
        SimpleDateFormat sdf11=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String update=sdf11.format(date);
        honeycombWmrecord.setUpdateTime(update);
        return honeycombWmrecordMapper.updateByPrimaryKeySelective(honeycombWmrecord);
    }

    @Override
    public int deleteEmRecord(HoneycombEmrecord honeycombEmrecord) {
        return honeycombEmrecordMapper.deleteByPrimaryKey(honeycombEmrecord.getId());
    }

    @Override
    public int deleteWmRecord(HoneycombWmrecord honeycombWmrecord) {
        return honeycombWmrecordMapper.deleteByPrimaryKey(honeycombWmrecord.getId());
    }

    @Override
    public HoneycombEmrecord getAEmReord() {
        return honeycombEmrecordMapper.selectByPrimaryKey(1L);
    }
}

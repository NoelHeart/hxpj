package com.biye.hxpj.service.impl;

import com.biye.hxpj.mapper.FirmApartmentroomMapper;
import com.biye.hxpj.mapper.HoneycombEmApartmentroomMapper;
import com.biye.hxpj.mapper.HoneycombEventrecordMapper;
import com.biye.hxpj.mapper.HoneycombWmApartmentroomMapper;
import com.biye.hxpj.model.FirmApartmentroom;
import com.biye.hxpj.model.HoneycombEmApartmentroom;
import com.biye.hxpj.model.HoneycombEventrecord;
import com.biye.hxpj.service.HoneycombEventService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @program: hxpj
 * @description: HoneycombEventService
 * @author: LiLei
 * @create: 2019-04-23 13:47
 **/
@Service
public class HoneycombEventServiceImpl implements HoneycombEventService{
    @Resource
    HoneycombEventrecordMapper honeycombEventrecordMapper;
    @Resource
    HoneycombEmApartmentroomMapper honeycombEmApartmentroomMapper;
    @Resource
    FirmApartmentroomMapper firmApartmentroomMapper;

    @Override
    public PageInfo<HoneycombEventrecord> getEventList(Integer pageNum, Integer pageSize) {
        List<HoneycombEventrecord> list3=honeycombEventrecordMapper.findAll();
        PageHelper.startPage(pageNum,pageSize);
        List<HoneycombEventrecord> list=honeycombEventrecordMapper.findAll();
        for (HoneycombEventrecord eventrecord:list){
            String deviceId=eventrecord.getDeviceId();
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
            eventrecord.setApartmentId(apartmentId);
            eventrecord.setRoomId(roomId);
            eventrecord.setFirm(firm);
        }
        PageInfo<HoneycombEventrecord> pageInfo=new PageInfo<>(list);
        pageInfo.setTotal(list3.size());
        return pageInfo;
    }

    @Override
    public int addEvent(HoneycombEventrecord honeycombEventrecord){
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String addTime=sdf.format(date);
        String updateTime="";
        honeycombEventrecord.setDataTime(addTime);
        honeycombEventrecord.setUpdateTime(updateTime);
        return honeycombEventrecordMapper.insertSelective(honeycombEventrecord);
    }

    @Override
    public int updateEvent(HoneycombEventrecord honeycombEventrecord) {
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String updateTime=sdf.format(date);
        honeycombEventrecord.setUpdateTime(updateTime);
        return honeycombEventrecordMapper.updateByPrimaryKeySelective(honeycombEventrecord);
    }

    @Override
    public int deleteEvent(HoneycombEventrecord honeycombEventrecord) {
        Long id=honeycombEventrecord.getId();
        return honeycombEventrecordMapper.deleteByPrimaryKey(id);
    }
}

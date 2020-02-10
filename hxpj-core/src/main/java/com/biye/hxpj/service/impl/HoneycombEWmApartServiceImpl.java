package com.biye.hxpj.service.impl;

import com.biye.hxpj.mapper.HoneycombEmApartmentroomMapper;
import com.biye.hxpj.mapper.HoneycombWmApartmentroomMapper;
import com.biye.hxpj.model.HoneycombEmApartmentroom;
import com.biye.hxpj.model.HoneycombWmApartmentroom;
import com.biye.hxpj.service.HoneycombEWmApartService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: hxpj
 * @description: 水表电表部署
 * @author: LiLei
 * @create: 2019-04-21 12:16
 **/
@Service
public class HoneycombEWmApartServiceImpl implements HoneycombEWmApartService {

    @Resource
    HoneycombEmApartmentroomMapper honeycombEmApartmentroomMapper;
    @Resource
    HoneycombWmApartmentroomMapper honeycombWmApartmentroomMapper;


    @Override
    public PageInfo<HoneycombEmApartmentroom> getEmApartList(Integer page, Integer size, Long apartId,Long roomId) {
        PageHelper.startPage(page, size);
        List<HoneycombEmApartmentroom> honeycombEmApartmentroomList=honeycombEmApartmentroomMapper.findAllEmApart(apartId,roomId);
        PageInfo<HoneycombEmApartmentroom> pageInfo=new PageInfo<>(honeycombEmApartmentroomList);
        return pageInfo;
    }

    @Override
    public PageInfo<HoneycombWmApartmentroom> getWmApartList(Integer page, Integer size, Long apartId,Long roomId) {
        PageHelper.startPage(page, size);
        List<HoneycombWmApartmentroom> honeycombWmApartmentroomList=honeycombWmApartmentroomMapper.findAllWm(apartId,roomId);
        PageInfo<HoneycombWmApartmentroom> pageInfo=new PageInfo<>(honeycombWmApartmentroomList);
        return pageInfo;
    }

    @Override
    public int addEmApartmentroom(HoneycombEmApartmentroom honeycombEmApartmentroom) {
        return honeycombEmApartmentroomMapper.insertSelective(honeycombEmApartmentroom);
    }

    @Override
    public int addWmApartmentroom(HoneycombWmApartmentroom honeycombWmApartmentroom) {
        return honeycombWmApartmentroomMapper.insertSelective(honeycombWmApartmentroom);
    }

    @Override
    public int updateEmApart(HoneycombEmApartmentroom honeycombEmApartmentroom) {
        return honeycombEmApartmentroomMapper.updateByPrimaryKeySelective(honeycombEmApartmentroom);
    }

    @Override
    public int updateWmApart(HoneycombWmApartmentroom honeycombWmApartmentroom) {
        return honeycombWmApartmentroomMapper.updateByPrimaryKeySelective(honeycombWmApartmentroom);
    }

    @Override
    public int deleteEmApart(HoneycombEmApartmentroom honeycombEmApartmentroom) {
        return honeycombEmApartmentroomMapper.deleteByPrimaryKey(honeycombEmApartmentroom.getId());
    }

    @Override
    public int deleteWmApart(HoneycombWmApartmentroom honeycombWmApartmentroom) {
        return honeycombWmApartmentroomMapper.deleteByPrimaryKey(honeycombWmApartmentroom.getId());
    }

    @Override
    public HoneycombEmApartmentroom sleectEmByTwoId(Long apartmentId,Long roomId) {
        return honeycombEmApartmentroomMapper.selectByTwoId(apartmentId,roomId);
    }

    @Override
    public HoneycombWmApartmentroom sleectWmByTwoId(Long apartmentId,Long roomId) {
        return honeycombWmApartmentroomMapper.selectByTwoId(apartmentId,roomId);
    }

    @Override
    public HoneycombEmApartmentroom selectEmByDeviceId(String deviceId) {
        return honeycombEmApartmentroomMapper.selectByDevice(deviceId);
    }

    @Override
    public HoneycombWmApartmentroom selectWmByDeviceId(String deviceId) {
        return honeycombWmApartmentroomMapper.selectByDevice(deviceId);
    }
}

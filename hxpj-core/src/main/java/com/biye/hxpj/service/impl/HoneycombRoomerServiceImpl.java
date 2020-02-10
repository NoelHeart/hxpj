package com.biye.hxpj.service.impl;

import com.biye.hxpj.mapper.HoneycombPersonApartmentroomMapper;
import com.biye.hxpj.model.HoneycombPersonApartmentroom;
import com.biye.hxpj.service.HoneycombRoomerService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: hxpj
 * @description: 住户Service
 * @author: LiLei
 * @create: 2019-04-21 21:49
 **/
@Service
public class HoneycombRoomerServiceImpl implements HoneycombRoomerService {
    @Resource
    HoneycombPersonApartmentroomMapper honeycombPersonApartmentroomMapper;

    @Override
    public int addRoomer(HoneycombPersonApartmentroom honeycombPersonApartmentroom) {
        return honeycombPersonApartmentroomMapper.insertSelective(honeycombPersonApartmentroom);
    }

    @Override
    public int updateRoomer(HoneycombPersonApartmentroom honeycombPersonApartmentroom) {
        return honeycombPersonApartmentroomMapper.updateByPrimaryKeySelective(honeycombPersonApartmentroom);
    }

    @Override
    public int deleteRoomer(HoneycombPersonApartmentroom honeycombPersonApartmentroom) {
        Long idd=honeycombPersonApartmentroom.getId();
        return honeycombPersonApartmentroomMapper.deleteByPrimaryKey(idd);
    }

    @Override
    public PageInfo<HoneycombPersonApartmentroom> getRoomList(Integer pageNum, Integer pageSzie) {
        PageHelper.startPage(pageNum,pageSzie);
        List<HoneycombPersonApartmentroom> honeycombPersonApartmentroomList=honeycombPersonApartmentroomMapper.selectRoomList();
        PageInfo<HoneycombPersonApartmentroom> pageInfo=new PageInfo<>(honeycombPersonApartmentroomList);
        return pageInfo;
    }
}

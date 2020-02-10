package com.biye.hxpj.service.impl;

import com.biye.hxpj.mapper.FirmApartmentroomMapper;
import com.biye.hxpj.mapper.HoneycombFirmApartmentroomMapper;
import com.biye.hxpj.model.FirmApartmentroom;
import com.biye.hxpj.model.HoneycombFirmApartmentroom;
import com.biye.hxpj.service.HoneycombFirmApartmentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: hxpj
 * @description:
 * @author: LiLei
 * @create: 2019-04-19 17:40
 **/
@Service
public class HoneycombFirmApartmentServiceImpl implements HoneycombFirmApartmentService{
    @Resource
    private FirmApartmentroomMapper firmApartmentroomMapper;
    @Resource
    private HoneycombFirmApartmentroomMapper honeycombFirmApartmentroomMapper;
    @Override
    public PageInfo<FirmApartmentroom> findFirmApartmentroomList(int page, int size,String firm,Long apartmentId) {
        //开启分页插件，放在查询语句上面 帮助生成分页语句
        PageHelper.startPage(page, size);
        List<FirmApartmentroom> firmApartmentroomList=firmApartmentroomMapper.findAll(firm,apartmentId);
        //封装分页之后的数据  返回给客户端展示  PageInfo做了一些封装 作为一个类
        PageInfo<FirmApartmentroom> pageInfo=new PageInfo<>(firmApartmentroomList);
        return pageInfo;
    }

    @Override
    public int addFirmApartment(FirmApartmentroom firmApartmentroom) {
        Long apartmentId=firmApartmentroom.getApartmentId();
        Long roomId=firmApartmentroom.getRoomId();
        if (honeycombFirmApartmentroomMapper.selectByTwoId(apartmentId,roomId)==null){
            HoneycombFirmApartmentroom honeycombFirmApartmentroom=new HoneycombFirmApartmentroom();
            honeycombFirmApartmentroom.setApartmentId(apartmentId);
            honeycombFirmApartmentroom.setRoomId(roomId);
            honeycombFirmApartmentroomMapper.insertSelective(honeycombFirmApartmentroom);
        }
        return firmApartmentroomMapper.insertSelective(firmApartmentroom);
    }

    @Override
    public boolean isHaveFrim(Long apartmentId, Long roomId) {
        boolean issss=true;
        if (firmApartmentroomMapper.selectById(apartmentId,roomId)==null){
            issss=false;
        }
        return issss;
    }

    @Override
    public boolean isHaveApart(Long apartmentId, Long roomId) {
        boolean iss=true;
        if (honeycombFirmApartmentroomMapper.selectByTwoId(apartmentId,roomId)==null){
            iss=false;
        }
        return iss;
    }

    @Override
    public List<Long> findApartment() {
        return honeycombFirmApartmentroomMapper.findApartment();
    }

    @Override
    public int updateById(FirmApartmentroom firmApartmentroom) {
        return firmApartmentroomMapper.updateByPrimaryKeySelective(firmApartmentroom);
    }

    @Override
    public int deleteById(Long id) {
        return firmApartmentroomMapper.deleteByPrimaryKey(id);
    }
}

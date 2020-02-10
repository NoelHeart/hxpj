package com.biye.hxpj.service.impl;

import com.biye.hxpj.mapper.HoneycombElectricMeterMapper;
import com.biye.hxpj.mapper.HoneycombWaterMeterMapper;
import com.biye.hxpj.model.HoneycombElectricMeter;
import com.biye.hxpj.model.HoneycombWaterMeter;
import com.biye.hxpj.service.HoneycombMeterService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: hxpj
 * @description: 电表水表
 * @author: LiLei
 * @create: 2019-04-20 18:50
 **/
@Service
public class HoneycombMeterServiceImpl implements HoneycombMeterService{
    @Resource
    private HoneycombElectricMeterMapper honeycombElectricMeterMapper;
    @Resource
    private HoneycombWaterMeterMapper honeycombWaterMeterMapper;


    @Override
    public PageInfo<HoneycombElectricMeter> getElectricList(Integer pageNum, Integer pageSize,String deviceId) {
        //开启分页插件
        PageHelper.startPage(pageNum,pageSize);
        List<HoneycombElectricMeter> honeycombElectricMeterList=honeycombElectricMeterMapper.findAll(deviceId);
        PageInfo<HoneycombElectricMeter> pageInfo=new PageInfo<>(honeycombElectricMeterList);
        return pageInfo;
    }

    @Override
    public PageInfo<HoneycombWaterMeter> getWaterList(Integer pageNum, Integer pageSize,String deviceId) {
        PageHelper.startPage(pageNum,pageSize);
        List<HoneycombWaterMeter> honeycombWaterMeterList=honeycombWaterMeterMapper.findAll(deviceId);
        PageInfo<HoneycombWaterMeter> pageInfo=new PageInfo<>(honeycombWaterMeterList);
        return pageInfo;
    }

    @Override
    public boolean electricIsHave(HoneycombElectricMeter honeycombElectricMeter) {
        boolean isss=false;
        String deviceId=honeycombElectricMeter.getDeviceId();
        if(honeycombElectricMeterMapper.selectByPrimaryKey(deviceId)!=null){
            isss=true;
        }
        return isss;
    }

    @Override
    public boolean waterIsHave(HoneycombWaterMeter honeycombWaterMeter) {
        boolean isss=false;
        String deviceId=honeycombWaterMeter.getDeviceId();
        if(honeycombWaterMeterMapper.selectByPrimaryKey(deviceId)!=null){
            isss=true;
        }
        return isss;
    }

    @Override
    public int addElectric(HoneycombElectricMeter honeycombElectricMeter) {
        honeycombElectricMeter.setType("0");
        return honeycombElectricMeterMapper.insertSelective(honeycombElectricMeter);
    }

    @Override
    public int addWater(HoneycombWaterMeter honeycombWaterMeter) {
        honeycombWaterMeter.setType("1");
        return honeycombWaterMeterMapper.insert(honeycombWaterMeter);
    }

    @Override
    public int updateElectric(HoneycombElectricMeter honeycombElectricMeter) {
        return honeycombElectricMeterMapper.updateByPrimaryKeySelective(honeycombElectricMeter);
    }

    @Override
    public int updateWater(HoneycombWaterMeter honeycombWaterMeter) {
        return honeycombWaterMeterMapper.updateByPrimaryKeySelective(honeycombWaterMeter);
    }

    @Override
    public int deleteElectric(HoneycombElectricMeter honeycombElectricMeter) {
        return honeycombElectricMeterMapper.deleteByPrimaryKey(honeycombElectricMeter.getDeviceId());
    }

    @Override
    public int deleteWater(HoneycombWaterMeter honeycombWaterMeter) {
        return honeycombWaterMeterMapper.deleteByPrimaryKey(honeycombWaterMeter.getDeviceId());
    }

    @Override
    public List<HoneycombElectricMeter> findAllElect() {
        String deviceId=null;
        return honeycombElectricMeterMapper.findAll(deviceId);
    }

    @Override
    public List<HoneycombWaterMeter> findAllWater() {
        String deviceId=null;
        return honeycombWaterMeterMapper.findAll(deviceId);
    }
}

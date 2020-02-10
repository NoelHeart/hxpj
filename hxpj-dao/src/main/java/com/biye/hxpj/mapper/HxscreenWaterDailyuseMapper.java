package com.biye.hxpj.mapper;

import com.biye.hxpj.model.HxscreenWaterDailyuse;

import java.util.List;

public interface HxscreenWaterDailyuseMapper {

    List<HxscreenWaterDailyuse> findAll();

    int deleteByPrimaryKey(Long id);

    int insertSelective(HxscreenWaterDailyuse record);

    HxscreenWaterDailyuse selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(HxscreenWaterDailyuse record);
}
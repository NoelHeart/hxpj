package com.biye.hxpj.mapper;

import com.biye.hxpj.model.HxscreenWaterMonthlyuse;

import java.util.List;

public interface HxscreenWaterMonthlyuseMapper {

    List<HxscreenWaterMonthlyuse> findAll();

    int deleteByPrimaryKey(Integer id);

    int insertSelective(HxscreenWaterMonthlyuse record);

    HxscreenWaterMonthlyuse selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HxscreenWaterMonthlyuse record);
}
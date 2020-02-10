package com.biye.hxpj.mapper;

import com.biye.hxpj.model.HoneycombWaterMeter;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HoneycombWaterMeterMapper {

    List<HoneycombWaterMeter> findAll(@Param("deviceId") String deviceId);

    int deleteByPrimaryKey(String deviceId);

    int insert(HoneycombWaterMeter record);

    int insertSelective(HoneycombWaterMeter record);

    HoneycombWaterMeter selectByPrimaryKey(String deviceId);

    int updateByPrimaryKeySelective(HoneycombWaterMeter record);

    int updateByPrimaryKey(HoneycombWaterMeter record);
}
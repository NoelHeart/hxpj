package com.biye.hxpj.mapper;

import com.biye.hxpj.model.HoneycombElectricMeter;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HoneycombElectricMeterMapper {

    List<HoneycombElectricMeter> findAll(@Param("deviceId") String deviceId);

    int deleteByPrimaryKey(String deviceId);

    int insert(HoneycombElectricMeter record);

    int insertSelective(HoneycombElectricMeter record);

    HoneycombElectricMeter selectByPrimaryKey(String deviceId);

    int updateByPrimaryKeySelective(HoneycombElectricMeter record);

    int updateByPrimaryKey(HoneycombElectricMeter record);
}
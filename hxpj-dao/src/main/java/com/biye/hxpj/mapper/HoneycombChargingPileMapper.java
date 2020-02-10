package com.biye.hxpj.mapper;

import com.biye.hxpj.model.HoneycombChargingPile;

public interface HoneycombChargingPileMapper {
    int deleteByPrimaryKey(String deviceId);

    int insert(HoneycombChargingPile record);

    int insertSelective(HoneycombChargingPile record);

    HoneycombChargingPile selectByPrimaryKey(String deviceId);

    int updateByPrimaryKeySelective(HoneycombChargingPile record);

    int updateByPrimaryKey(HoneycombChargingPile record);
}
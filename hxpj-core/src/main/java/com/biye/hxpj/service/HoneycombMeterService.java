package com.biye.hxpj.service;

import com.biye.hxpj.model.HoneycombElectricMeter;
import com.biye.hxpj.model.HoneycombWaterMeter;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface HoneycombMeterService {

    PageInfo<HoneycombElectricMeter> getElectricList(Integer pageNum,Integer pageSize,String deviceId);

    PageInfo<HoneycombWaterMeter> getWaterList(Integer pageNum,Integer pageSize,String deviceId);

    boolean electricIsHave(HoneycombElectricMeter honeycombElectricMeter);

    boolean waterIsHave(HoneycombWaterMeter honeycombWaterMeter);

    int addElectric(HoneycombElectricMeter honeycombElectricMeter);

    int addWater(HoneycombWaterMeter honeycombWaterMeter);

    int updateElectric(HoneycombElectricMeter honeycombElectricMeter);

    int updateWater(HoneycombWaterMeter honeycombWaterMeter);

    int deleteElectric(HoneycombElectricMeter honeycombElectricMeter);

    int deleteWater(HoneycombWaterMeter honeycombWaterMeter);

    List<HoneycombElectricMeter> findAllElect();

    List<HoneycombWaterMeter> findAllWater();

}

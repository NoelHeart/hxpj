package com.biye.hxpj.mapper;

import com.biye.hxpj.model.TotalEmHour;

import java.util.List;

public interface TotalEmHourMapper {

    List<TotalEmHour> findAll();

    int deleteByPrimaryKey(Long id);

    int insertSelective(TotalEmHour record);

    TotalEmHour selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TotalEmHour record);

}
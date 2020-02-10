package com.biye.hxpj.mapper;

import com.biye.hxpj.model.TotalWmHour;

import java.util.List;

public interface TotalWmHourMapper {

    List<TotalWmHour> findAll();

    int deleteByPrimaryKey(Long id);

    int insertSelective(TotalWmHour record);

    TotalWmHour selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TotalWmHour record);
}
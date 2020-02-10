package com.biye.hxpj.mapper;

import com.biye.hxpj.model.ComputeWmDailydevicerecord;

import java.util.List;

public interface ComputeWmDailydevicerecordMapper {

    List<ComputeWmDailydevicerecord> findAll();

    int deleteByPrimaryKey(Long id);

    int insertSelective(ComputeWmDailydevicerecord record);

    int insertList(List<ComputeWmDailydevicerecord> records);

    ComputeWmDailydevicerecord selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ComputeWmDailydevicerecord record);

}
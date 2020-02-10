package com.biye.hxpj.mapper;

import com.biye.hxpj.model.ComputeWmMonthlydevicerecord;

import java.util.List;

public interface ComputeWmMonthlydevicerecordMapper {

    List<ComputeWmMonthlydevicerecord> findAll();

    int deleteByPrimaryKey(Long id);

    int insertSelective(ComputeWmMonthlydevicerecord record);

    int insertWmDList(List<ComputeWmMonthlydevicerecord> records);

    ComputeWmMonthlydevicerecord selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ComputeWmMonthlydevicerecord record);
}
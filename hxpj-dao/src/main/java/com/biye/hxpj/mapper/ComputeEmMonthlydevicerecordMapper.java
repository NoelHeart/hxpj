package com.biye.hxpj.mapper;

import com.biye.hxpj.model.ComputeEmMonthlydevicerecord;

import java.util.List;

public interface ComputeEmMonthlydevicerecordMapper {

    List<ComputeEmMonthlydevicerecord> findAll();

    int deleteByPrimaryKey(Long id);

    int insertSelective(ComputeEmMonthlydevicerecord record);

    int insertList(List<ComputeEmMonthlydevicerecord> records);

    ComputeEmMonthlydevicerecord selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ComputeEmMonthlydevicerecord record);

}
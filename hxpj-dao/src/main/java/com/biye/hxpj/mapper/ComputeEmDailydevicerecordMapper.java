package com.biye.hxpj.mapper;

import com.biye.hxpj.model.ComputeEmDailydevicerecord;

import java.util.List;

public interface ComputeEmDailydevicerecordMapper {

    List<ComputeEmDailydevicerecord> findAll();

    int deleteByPrimaryKey(Long id);

    int insertSelective(ComputeEmDailydevicerecord record);

    int insertList(List<ComputeEmDailydevicerecord> record);

    ComputeEmDailydevicerecord selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ComputeEmDailydevicerecord record);
}
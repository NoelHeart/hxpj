package com.biye.hxpj.mapper;

import com.biye.hxpj.model.ComputeWmMonthlyfirmrecord;

import java.util.List;

public interface ComputeWmMonthlyfirmrecordMapper {

    List<ComputeWmMonthlyfirmrecord> findAll();

    int deleteByPrimaryKey(Long id);

    int insertSelective(ComputeWmMonthlyfirmrecord record);

    int insertWmFirmList(List<ComputeWmMonthlyfirmrecord> records);

    ComputeWmMonthlyfirmrecord selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ComputeWmMonthlyfirmrecord record);

}
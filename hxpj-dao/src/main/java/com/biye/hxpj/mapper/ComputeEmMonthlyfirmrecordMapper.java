package com.biye.hxpj.mapper;

import com.biye.hxpj.model.ComputeEmMonthlyfirmrecord;

import java.util.List;

public interface ComputeEmMonthlyfirmrecordMapper {

    List<ComputeEmMonthlyfirmrecord> findAll();

    int deleteByPrimaryKey(Long id);

    int insertSelective(ComputeEmMonthlyfirmrecord record);

    int insertEmList(List<ComputeEmMonthlyfirmrecord> records);

    ComputeEmMonthlyfirmrecord selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ComputeEmMonthlyfirmrecord record);

}
package com.biye.hxpj.mapper;

import com.biye.hxpj.model.ComputeEmDailyfirmrecord;

import java.util.List;

public interface ComputeEmDailyfirmrecordMapper {

    List<ComputeEmDailyfirmrecord> findAll();

    int deleteByPrimaryKey(Long id);

    int insertSelective(ComputeEmDailyfirmrecord record);

    int insertList(List<ComputeEmDailyfirmrecord> records);

    ComputeEmDailyfirmrecord selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ComputeEmDailyfirmrecord record);
}
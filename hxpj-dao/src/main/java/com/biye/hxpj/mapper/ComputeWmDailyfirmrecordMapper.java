package com.biye.hxpj.mapper;

import com.biye.hxpj.model.ComputeWmDailyfirmrecord;

import java.util.List;

public interface ComputeWmDailyfirmrecordMapper {

    List<ComputeWmDailyfirmrecord> findAll();

    int deleteByPrimaryKey(Long id);

    int insertSelective(ComputeWmDailyfirmrecord record);

    int insertList(List<ComputeWmDailyfirmrecord> records);

    ComputeWmDailyfirmrecord selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ComputeWmDailyfirmrecord record);

}
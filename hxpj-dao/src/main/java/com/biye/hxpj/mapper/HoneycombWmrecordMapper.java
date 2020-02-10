package com.biye.hxpj.mapper;

import com.biye.hxpj.model.HoneycombWmrecord;

import java.util.List;

public interface HoneycombWmrecordMapper {

    List<HoneycombWmrecord> findAll();

    int deleteByPrimaryKey(Long id);

    int insertSelective(HoneycombWmrecord record);

    HoneycombWmrecord selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(HoneycombWmrecord record);
}
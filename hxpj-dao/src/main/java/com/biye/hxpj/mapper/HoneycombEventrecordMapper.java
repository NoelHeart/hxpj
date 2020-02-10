package com.biye.hxpj.mapper;

import com.biye.hxpj.model.HoneycombEventrecord;

import java.util.List;

public interface HoneycombEventrecordMapper {

    List<HoneycombEventrecord> findAll();

    int deleteByPrimaryKey(Long id);

    int insertSelective(HoneycombEventrecord record);

    HoneycombEventrecord selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(HoneycombEventrecord record);
}
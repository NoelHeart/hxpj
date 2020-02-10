package com.biye.hxpj.mapper;

import com.biye.hxpj.model.HoneycombEmrecord;

import java.util.List;

public interface HoneycombEmrecordMapper {

    List<HoneycombEmrecord> findAll();

    int deleteByPrimaryKey(Long id);

    int insertSelective(HoneycombEmrecord record);

    HoneycombEmrecord selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(HoneycombEmrecord record);
}
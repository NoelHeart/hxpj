package com.biye.hxpj.mapper;

import com.biye.hxpj.model.HxscreenScreen21;

import java.util.List;

public interface HxscreenScreen21Mapper {

    List<HxscreenScreen21> findAll();

    int deleteByPrimaryKey(Long id);

    int insertSelective(HxscreenScreen21 record);

    HxscreenScreen21 selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(HxscreenScreen21 record);

    HxscreenScreen21 selectLast();
}
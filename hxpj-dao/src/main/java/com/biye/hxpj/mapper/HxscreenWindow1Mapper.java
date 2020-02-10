package com.biye.hxpj.mapper;

import com.biye.hxpj.model.HxscreenWindow1;

import java.util.List;

public interface HxscreenWindow1Mapper {

    List<HxscreenWindow1> findAll();

    int deleteByPrimaryKey(Long id);

    int insertSelective(HxscreenWindow1 record);

    HxscreenWindow1 selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(HxscreenWindow1 record);
}
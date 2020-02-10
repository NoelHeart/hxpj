package com.biye.hxpj.mapper;

import com.biye.hxpj.model.HxscreenWindow2;

import java.util.List;

public interface HxscreenWindow2Mapper {

    List<HxscreenWindow2> findAll();

    int deleteByPrimaryKey(Long id);

    int insertSelective(HxscreenWindow2 record);

    HxscreenWindow2 selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(HxscreenWindow2 record);
}
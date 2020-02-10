package com.biye.hxpj.mapper;

import com.biye.hxpj.model.HxscreenWindow3;

import java.util.List;

public interface HxscreenWindow3Mapper {

    List<HxscreenWindow3> findAll();

    int deleteByPrimaryKey(Long id);

    int insertSelective(HxscreenWindow3 record);

    HxscreenWindow3 selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(HxscreenWindow3 record);
}
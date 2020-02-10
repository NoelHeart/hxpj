package com.biye.hxpj.mapper;

import com.biye.hxpj.model.HxscreenScreen23;

import java.util.List;

public interface HxscreenScreen23Mapper {

    List<HxscreenScreen23> findAll();

    int deleteByPrimaryKey(Long id);

    int insertSelective(HxscreenScreen23 record);

    HxscreenScreen23 selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(HxscreenScreen23 record);

}
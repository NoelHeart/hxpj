package com.biye.hxpj.mapper;

import com.biye.hxpj.model.HxscreenScreen11;

import java.util.List;

public interface HxscreenScreen11Mapper {

    List<HxscreenScreen11> findAll();

    int deleteByPrimaryKey(Long id);

    int insertSelective(HxscreenScreen11 record);

    HxscreenScreen11 selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(HxscreenScreen11 record);
}
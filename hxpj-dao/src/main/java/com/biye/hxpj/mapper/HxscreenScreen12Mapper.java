package com.biye.hxpj.mapper;

import com.biye.hxpj.model.HxscreenScreen12;

import java.util.List;

public interface HxscreenScreen12Mapper {

    List<HxscreenScreen12> findAll();

    int deleteByPrimaryKey(Long id);

    int insertSelective(HxscreenScreen12 record);

    HxscreenScreen12 selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(HxscreenScreen12 record);

    List<HxscreenScreen12> selectLastSix();
}
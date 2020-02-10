package com.biye.hxpj.mapper;

import com.biye.hxpj.model.HxscreenScreen24Today;

import java.util.List;

public interface HxscreenScreen24TodayMapper {

    List<HxscreenScreen24Today> findAll();

    int deleteByPrimaryKey(Long id);

    int insertSelective(HxscreenScreen24Today record);

    HxscreenScreen24Today selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(HxscreenScreen24Today record);
}
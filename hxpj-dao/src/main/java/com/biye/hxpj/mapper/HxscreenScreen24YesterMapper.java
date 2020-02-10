package com.biye.hxpj.mapper;

import com.biye.hxpj.model.HxscreenScreen24Yester;

import java.util.List;

public interface HxscreenScreen24YesterMapper {

    List<HxscreenScreen24Yester> findAll();

    int deleteByPrimaryKey(Long id);

    int insertSelective(HxscreenScreen24Yester record);

    HxscreenScreen24Yester selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(HxscreenScreen24Yester record);}
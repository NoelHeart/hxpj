package com.biye.hxpj.mapper;

import com.biye.hxpj.model.HxscreenScreenMap;

import java.util.List;

public interface HxscreenScreenMapMapper {

    List<HxscreenScreenMap> findAll();

    int deleteByPrimaryKey(Integer id);

    int insertSelective(HxscreenScreenMap record);

    HxscreenScreenMap selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HxscreenScreenMap record);
}
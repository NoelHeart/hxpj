package com.biye.hxpj.mapper;

import com.biye.hxpj.model.HxscreenWindow4;

import java.util.List;

public interface HxscreenWindow4Mapper {

    List<HxscreenWindow4> findALL();

    int deleteByPrimaryKey(Long id);

    int insertSelective(HxscreenWindow4 record);

    HxscreenWindow4 selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(HxscreenWindow4 record);
}
package com.biye.hxpj.mapper;

import com.biye.hxpj.model.HxscreenScreen22;

import java.util.List;

public interface HxscreenScreen22Mapper {

    List<HxscreenScreen22> findAll();

    int deleteByPrimaryKey(Long id);

    int insertSelective(HxscreenScreen22 record);

    HxscreenScreen22 selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(HxscreenScreen22 record);

    HxscreenScreen22 selectLast();
}
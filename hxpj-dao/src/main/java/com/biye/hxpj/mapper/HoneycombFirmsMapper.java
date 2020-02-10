package com.biye.hxpj.mapper;

import com.biye.hxpj.model.HoneycombFirms;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HoneycombFirmsMapper {
    int deleteByPrimaryKey(Long id);

    int insertSelective(HoneycombFirms record);

    HoneycombFirms selectByPrimaryKey(Long id);

    HoneycombFirms selectByName(String firmName);

    int updateByPrimaryKeySelective(HoneycombFirms record);

    int updateByPrimaryKey(HoneycombFirms record);

    List<HoneycombFirms> findAll(@Param(value = "firm") String firm);
}
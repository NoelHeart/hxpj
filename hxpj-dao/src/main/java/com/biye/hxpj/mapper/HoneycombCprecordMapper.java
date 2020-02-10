package com.biye.hxpj.mapper;

import com.biye.hxpj.model.HoneycombCprecord;

public interface HoneycombCprecordMapper {
    int deleteByPrimaryKey(Long id);

    int insert(HoneycombCprecord record);

    int insertSelective(HoneycombCprecord record);

    HoneycombCprecord selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(HoneycombCprecord record);

    int updateByPrimaryKey(HoneycombCprecord record);
}
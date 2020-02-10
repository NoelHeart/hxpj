package com.biye.hxpj.mapper;

import com.biye.hxpj.model.TotalEmDaily;

import java.util.List;

public interface TotalEmDailyMapper {

    List<TotalEmDaily> findAllEm();

    int deleteByPrimaryKey(Long id);

    int insertSelective(TotalEmDaily record);

    TotalEmDaily selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TotalEmDaily record);
}
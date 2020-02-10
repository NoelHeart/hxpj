package com.biye.hxpj.mapper;

import com.biye.hxpj.model.TotalWmDaily;

import java.util.List;

public interface TotalWmDailyMapper {

    List<TotalWmDaily> findAllWm();

    int deleteByPrimaryKey(Long id);

    int insertSelective(TotalWmDaily record);

    TotalWmDaily selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TotalWmDaily record);
}
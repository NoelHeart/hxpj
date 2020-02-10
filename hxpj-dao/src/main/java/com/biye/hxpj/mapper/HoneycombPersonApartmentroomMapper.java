package com.biye.hxpj.mapper;

import com.biye.hxpj.model.HoneycombPersonApartmentroom;

import java.util.List;

public interface HoneycombPersonApartmentroomMapper {
    int deleteByPrimaryKey(Long id);

    int insertSelective(HoneycombPersonApartmentroom record);

    HoneycombPersonApartmentroom selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(HoneycombPersonApartmentroom record);

    List<HoneycombPersonApartmentroom> selectRoomList();
}
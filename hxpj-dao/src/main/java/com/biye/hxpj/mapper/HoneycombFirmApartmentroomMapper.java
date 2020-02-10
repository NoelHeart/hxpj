package com.biye.hxpj.mapper;

import com.biye.hxpj.model.HoneycombFirmApartmentroom;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HoneycombFirmApartmentroomMapper {

    HoneycombFirmApartmentroom selectByTwoId(@Param("apartmentId") Long apartmentId, @Param("roomId") Long roomId);

    List<Long> findApartment();
    int deleteByPrimaryKey(Long id);

    int insert(HoneycombFirmApartmentroom record);

    int insertSelective(HoneycombFirmApartmentroom record);

    HoneycombFirmApartmentroom selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(HoneycombFirmApartmentroom record);

    int updateByPrimaryKey(HoneycombFirmApartmentroom record);
}
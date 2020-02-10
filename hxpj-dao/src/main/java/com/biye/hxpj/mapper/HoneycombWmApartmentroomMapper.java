package com.biye.hxpj.mapper;

import com.biye.hxpj.model.HoneycombWmApartmentroom;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HoneycombWmApartmentroomMapper {

    List<HoneycombWmApartmentroom> findAllWm(@Param("apartId") Long apartId, @Param("roomId") Long roomId);

    int deleteByPrimaryKey(Long id);

    int insertSelective(HoneycombWmApartmentroom record);

    HoneycombWmApartmentroom selectByPrimaryKey(Long id);

    HoneycombWmApartmentroom selectByTwoId(@Param("apartmentId") Long apartmentId, @Param("roomId") Long roomId);

    HoneycombWmApartmentroom selectByDevice(@Param("deviceId") String deviceId);

    int updateByPrimaryKeySelective(HoneycombWmApartmentroom record);
}
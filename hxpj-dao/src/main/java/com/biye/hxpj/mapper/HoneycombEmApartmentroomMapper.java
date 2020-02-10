package com.biye.hxpj.mapper;

import com.biye.hxpj.model.HoneycombEmApartmentroom;
import com.biye.hxpj.model.HoneycombWmApartmentroom;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HoneycombEmApartmentroomMapper {

    List<HoneycombEmApartmentroom> findAllEmApart(@Param("apartId") Long apartId, @Param("roomId") Long roomId);

    int deleteByPrimaryKey(Long id);

    int insertSelective(HoneycombEmApartmentroom record);

    HoneycombEmApartmentroom selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(HoneycombEmApartmentroom record);

    HoneycombEmApartmentroom selectByTwoId(@Param("apartmentId") Long apartmentId, @Param("roomId") Long roomId);

    HoneycombEmApartmentroom selectByDevice(@Param("deviceId") String deviceId);
}
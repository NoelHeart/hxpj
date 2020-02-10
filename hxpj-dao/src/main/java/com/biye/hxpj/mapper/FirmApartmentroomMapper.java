package com.biye.hxpj.mapper;

import com.biye.hxpj.model.FirmApartmentroom;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FirmApartmentroomMapper {

    List<FirmApartmentroom> findAll(@Param("firm") String firm, @Param("apartmentId") Long apartmentId);

    FirmApartmentroom selectById(@Param("apartmentId") Long apartmentId, @Param("roomId") Long roomId);

    int deleteByPrimaryKey(Long id);

    int insert(FirmApartmentroom record);

    int insertSelective(FirmApartmentroom record);

    FirmApartmentroom selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FirmApartmentroom record);

    int updateByPrimaryKey(FirmApartmentroom record);
}
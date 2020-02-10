package com.biye.hxpj.service;

import com.biye.hxpj.model.FirmApartmentroom;
import com.github.pagehelper.PageInfo;

import java.util.Date;
import java.util.List;

public interface HoneycombFirmApartmentService {

    PageInfo<FirmApartmentroom> findFirmApartmentroomList(int page,int size,String firm,Long apartmentId);

    int addFirmApartment(FirmApartmentroom firmApartmentroom);

    boolean isHaveFrim(Long apartmentId,Long roomId);

    boolean isHaveApart(Long apartmentId,Long roomId);

    List<Long> findApartment();

    int updateById(FirmApartmentroom firmApartmentroom);

    int deleteById(Long id);
}

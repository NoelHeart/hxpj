package com.biye.hxpj.service;

import com.biye.hxpj.model.HoneycombPersonApartmentroom;
import com.github.pagehelper.PageInfo;

public interface HoneycombRoomerService {

    int addRoomer(HoneycombPersonApartmentroom honeycombPersonApartmentroom);

    int updateRoomer(HoneycombPersonApartmentroom honeycombPersonApartmentroom);

    int deleteRoomer(HoneycombPersonApartmentroom honeycombPersonApartmentroom);

    PageInfo<HoneycombPersonApartmentroom> getRoomList(Integer pageNum,Integer pageSzie);
}

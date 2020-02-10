package com.biye.hxpj.service;

import com.biye.hxpj.model.HoneycombEmApartmentroom;
import com.biye.hxpj.model.HoneycombWmApartmentroom;
import com.github.pagehelper.PageInfo;

public interface HoneycombEWmApartService {

    int addEmApartmentroom(HoneycombEmApartmentroom honeycombEmApartmentroom);

    int addWmApartmentroom(HoneycombWmApartmentroom honeycombWmApartmentroom);

    HoneycombEmApartmentroom sleectEmByTwoId(Long apartmentId,Long roomId);

    HoneycombWmApartmentroom sleectWmByTwoId(Long apartmentId,Long roomId);

    HoneycombEmApartmentroom selectEmByDeviceId(String deviceId);

    HoneycombWmApartmentroom selectWmByDeviceId(String deviceId);

    PageInfo<HoneycombEmApartmentroom> getEmApartList(Integer page, Integer size,Long apartId,Long roomId);

    PageInfo<HoneycombWmApartmentroom> getWmApartList(Integer page, Integer size,Long apartId,Long roomId);

    int updateEmApart(HoneycombEmApartmentroom honeycombEmApartmentroom);

    int updateWmApart(HoneycombWmApartmentroom honeycombWmApartmentroom);

    int deleteEmApart(HoneycombEmApartmentroom honeycombEmApartmentroom);

    int deleteWmApart(HoneycombWmApartmentroom honeycombWmApartmentroom);
}

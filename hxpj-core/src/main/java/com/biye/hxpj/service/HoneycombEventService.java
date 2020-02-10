package com.biye.hxpj.service;

import com.biye.hxpj.model.HoneycombEventrecord;
import com.github.pagehelper.PageInfo;

public interface HoneycombEventService {

    int addEvent(HoneycombEventrecord honeycombEventrecord);

    int updateEvent(HoneycombEventrecord honeycombEventrecord);

    int deleteEvent(HoneycombEventrecord honeycombEventrecord);

    PageInfo<HoneycombEventrecord> getEventList(Integer pageNum,Integer pageSize);

}

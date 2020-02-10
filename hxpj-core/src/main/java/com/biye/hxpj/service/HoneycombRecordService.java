package com.biye.hxpj.service;

import com.biye.hxpj.model.HoneycombEmrecord;
import com.biye.hxpj.model.HoneycombWmrecord;
import com.github.pagehelper.PageInfo;

public interface HoneycombRecordService {

    int addEmRecord(HoneycombEmrecord honeycombEmrecord);

    int addWmRecord(HoneycombWmrecord honeycombWmrecord);

    int updateEmRecord(HoneycombEmrecord honeycombEmrecord);

    int updateWmRecord(HoneycombWmrecord honeycombWmrecord);

    int deleteEmRecord(HoneycombEmrecord honeycombEmrecord);

    int deleteWmRecord(HoneycombWmrecord honeycombWmrecord);

    PageInfo<HoneycombEmrecord> getEmRecordList(Integer pageNum,Integer pageSize);

    PageInfo<HoneycombWmrecord> getWmRecordList(Integer pageNum,Integer pageSize);

    HoneycombEmrecord getAEmReord();
}

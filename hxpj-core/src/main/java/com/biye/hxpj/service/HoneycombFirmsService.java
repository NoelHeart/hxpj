package com.biye.hxpj.service;

import com.biye.hxpj.model.HoneycombFirms;
import com.github.pagehelper.PageInfo;

import java.util.List;


public interface HoneycombFirmsService {

    PageInfo<HoneycombFirms> findFirmList(int page,int size,String firmName);

    int addFirm(HoneycombFirms honeycombFirms);

    HoneycombFirms findById(Long id);

    HoneycombFirms findByName(String firmName);

    List<HoneycombFirms> findAllFirm();

    int updateFirm(HoneycombFirms honeycombFirms);

    int deleteFirm(Long id);
}

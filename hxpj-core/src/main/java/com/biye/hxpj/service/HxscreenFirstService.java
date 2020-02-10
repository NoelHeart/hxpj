package com.biye.hxpj.service;

import com.biye.hxpj.model.*;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface HxscreenFirstService {

    PageInfo<HxscreenScreenMap> getHxscreenMapList(Integer pageNum, Integer pageSize);

    PageInfo<HxscreenScreen11> getHxscreen11List(Integer pageNum, Integer pageSize);

    PageInfo<HxscreenScreen22> getHxscreen22List(Integer pageNum, Integer pageSize);

    PageInfo<HxscreenScreen24Today> getHxscreen24TodayList(Integer pageNum, Integer pageSize);

    PageInfo<HxscreenScreen23> getHxscreen23List(Integer pageNum, Integer pageSize);

    PageInfo<HxscreenScreen21> getHxscreen21List(Integer pageNum, Integer pageSize);

    int addHxscreenMap(HxscreenScreenMap hxscreenScreenMap);

    int addHxscreen11(HxscreenScreen11 hxscreenScreen11);

    int addHxscreen22(HxscreenScreen22 hxscreenScreen22);

    int addHxscreen24Today(HxscreenScreen24Today hxscreenScreen24Today);

    int addHxscreen23(HxscreenScreen23 hxscreenScreen23);

    int addHxscreen21(HxscreenScreen21 hxscreenScreen21);

    int deleteHxscreenMap(HxscreenScreenMap hxscreenScreenMap);

    int deleteHxscreen11(HxscreenScreen11 hxscreenScreen11);

    int deleteHxscreen22(HxscreenScreen22 hxscreenScreen22);

    int deleteHxscreen24Today(HxscreenScreen24Today hxscreenScreen24Today);

    int deleteHxscreen23(HxscreenScreen23 hxscreenScreen23);

    int deleteHxscreen21(HxscreenScreen21 hxscreenScreen21);
}

package com.biye.hxpj.service;

import com.biye.hxpj.model.*;
import com.github.pagehelper.PageInfo;

public interface HxscreenSecondService {

    PageInfo<HxscreenScreen24Yester> getHxscreen24YesterList(Integer pageNum,Integer pageSize);

    PageInfo<HxscreenScreen12> getHxscreen12List(Integer pageNum, Integer pageSize);

    PageInfo<HxscreenCamera> getHxscreenCameraList(Integer pageNum, Integer pageSize);

    PageInfo<HxscreenWindow1> getHxscreenWindow1List(Integer pageNum, Integer pageSize);

    PageInfo<HxscreenWindow2> getHxscreenWindow2List(Integer pageNum, Integer pageSize);

    int addHxscreen24Yester(HxscreenScreen24Yester hxscreenScreen24Yester);

    int addHxscreen12(HxscreenScreen12 hxscreenScreen12);

    int addHxscreenCamera(HxscreenCamera hxscreenCamera);

    int addHxscreenWindow1(HxscreenWindow1 hxscreenWindow1);

    int addHxscreenWindow2(HxscreenWindow2 hxscreenWindow2);

    int deleteHxscreen24Yester(HxscreenScreen24Yester hxscreenScreen24Yester);

    int deleteHxscreen12(HxscreenScreen12 hxscreenScreen12);

    int deleteHxscreenCamera(HxscreenCamera hxscreenCamera);

    int deleteHxscreenWindow1(HxscreenWindow1 hxscreenWindow1);

    int deleteHxscreenWindow2(HxscreenWindow2 hxscreenWindow2);


}

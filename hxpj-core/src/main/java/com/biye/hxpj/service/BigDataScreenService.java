package com.biye.hxpj.service;

import com.biye.hxpj.model.HxscreenScreen12;
import com.biye.hxpj.model.HxscreenScreen21;
import com.biye.hxpj.model.HxscreenScreen22;

import java.util.List;

public interface BigDataScreenService {
    HxscreenScreen21 getHxscreenHaoNeng();
    List<HxscreenScreen12> getHxSscreenShouZhiList();
    HxscreenScreen22 getHxscreen22Last();
}

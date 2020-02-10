package com.biye.hxpj.service.impl;

import com.biye.hxpj.mapper.HxscreenScreen12Mapper;
import com.biye.hxpj.mapper.HxscreenScreen21Mapper;
import com.biye.hxpj.mapper.HxscreenScreen22Mapper;
import com.biye.hxpj.model.HxscreenScreen12;
import com.biye.hxpj.model.HxscreenScreen21;
import com.biye.hxpj.model.HxscreenScreen22;
import com.biye.hxpj.service.BigDataScreenService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * @program: hxpj
 * @description:
 * @author: LiLei
 * @create: 2019-05-26 15:14
 **/
@Service
public class BigDataScreenServiceImpl implements BigDataScreenService {
    /**
     * 总能耗情况
     * */
    @Resource
    HxscreenScreen21Mapper hxscreenScreen21Mapper;

    @Override
    public HxscreenScreen21 getHxscreenHaoNeng() {
        return hxscreenScreen21Mapper.selectLast();
    }
    /**
     * 收支情况
     * */
    @Resource
    HxscreenScreen12Mapper hxscreenScreen12Mapper;
    @Override
    public List<HxscreenScreen12> getHxSscreenShouZhiList() {
        List<HxscreenScreen12> hxscreenScreen12s=hxscreenScreen12Mapper.selectLastSix();
        Collections.reverse(hxscreenScreen12s);
        return hxscreenScreen12s;
    }
    /**
     * 各大楼能耗饼状图
     * */
    @Resource
    HxscreenScreen22Mapper hxscreenScreen22Mapper;
    @Override
    public HxscreenScreen22 getHxscreen22Last() {
        return hxscreenScreen22Mapper.selectLast();
    }
}

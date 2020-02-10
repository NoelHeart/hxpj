package com.biye.hxpj.service.impl;

import com.biye.hxpj.mapper.HoneycombFirmsMapper;
import com.biye.hxpj.model.HoneycombFirms;
import com.biye.hxpj.service.HoneycombFirmsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: hxpj
 * @description: HoneycombFirmsService
 * @author: LiLei
 * @create: 2019-04-14 23:27
 **/

@Service
public class HoneycombFirmsServiceImpl implements HoneycombFirmsService{
    @Resource
    private HoneycombFirmsMapper honeycombFirmsMapper;

    @Override
    public PageInfo<HoneycombFirms> findFirmList(int page, int size,String firmName) {
        //开启分页插件，放在查询语句上面 帮助生成分页语句
        PageHelper.startPage(page, size);
        List<HoneycombFirms> honeycombFirmsList=honeycombFirmsMapper.findAll(firmName);
        //封装分页之后的数据  返回给客户端展示  PageInfo做了一些封装 作为一个类
        PageInfo<HoneycombFirms> pageInfo=new PageInfo<>(honeycombFirmsList);
        return pageInfo;
    }

    @Override
    public int addFirm(HoneycombFirms honeycombFirms) {
        return honeycombFirmsMapper.insertSelective(honeycombFirms);
    }

    @Override
    public HoneycombFirms findById(Long id) {
        return honeycombFirmsMapper.selectByPrimaryKey(id);
    }

    @Override
    public HoneycombFirms findByName(String firmName) {
        return honeycombFirmsMapper.selectByName(firmName);
    }

    @Override
    public int updateFirm(HoneycombFirms honeycombFirms) {
        return honeycombFirmsMapper.updateByPrimaryKey(honeycombFirms);
    }

    @Override
    public int deleteFirm(Long id) {
        return honeycombFirmsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<HoneycombFirms> findAllFirm() {
        String firms=null;
        return honeycombFirmsMapper.findAll(firms);
    }
}

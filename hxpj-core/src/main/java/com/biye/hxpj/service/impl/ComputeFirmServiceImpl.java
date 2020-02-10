package com.biye.hxpj.service.impl;

import com.biye.hxpj.mapper.ComputeEmDailyfirmrecordMapper;
import com.biye.hxpj.mapper.ComputeEmMonthlyfirmrecordMapper;
import com.biye.hxpj.mapper.ComputeWmDailyfirmrecordMapper;
import com.biye.hxpj.mapper.ComputeWmMonthlyfirmrecordMapper;
import com.biye.hxpj.model.ComputeEmDailyfirmrecord;
import com.biye.hxpj.model.ComputeEmMonthlyfirmrecord;
import com.biye.hxpj.model.ComputeWmDailyfirmrecord;
import com.biye.hxpj.model.ComputeWmMonthlyfirmrecord;
import com.biye.hxpj.service.ComputeFirmService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @program: hxpj
 * @description: 业务计算：企业相关
 * @author: LiLei
 * @create: 2019-04-24 18:35
 **/
@Service
public class ComputeFirmServiceImpl implements ComputeFirmService {
    @Resource
    ComputeEmDailyfirmrecordMapper computeEmDailyfirmrecordMapper;
    @Resource
    ComputeEmMonthlyfirmrecordMapper computeEmMonthlyfirmrecordMapper;
    @Resource
    ComputeWmDailyfirmrecordMapper computeWmDailyfirmrecordMapper;
    @Resource
    ComputeWmMonthlyfirmrecordMapper computeWmMonthlyfirmrecordMapper;

    @Override
    public PageInfo<ComputeEmDailyfirmrecord> getEmFirmDailyList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<ComputeEmDailyfirmrecord> list=computeEmDailyfirmrecordMapper.findAll();
        PageInfo<ComputeEmDailyfirmrecord> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public PageInfo<ComputeEmMonthlyfirmrecord> getEmFirmMonthlyList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<ComputeEmMonthlyfirmrecord> list=computeEmMonthlyfirmrecordMapper.findAll();
        PageInfo<ComputeEmMonthlyfirmrecord> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public PageInfo<ComputeWmDailyfirmrecord> getWmFirmDailyList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<ComputeWmDailyfirmrecord> list=computeWmDailyfirmrecordMapper.findAll();
        PageInfo<ComputeWmDailyfirmrecord> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public PageInfo<ComputeWmMonthlyfirmrecord> getWmFirmMonthlyList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<ComputeWmMonthlyfirmrecord> list=computeWmMonthlyfirmrecordMapper.findAll();
        PageInfo<ComputeWmMonthlyfirmrecord> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public int addEmFirmDaily(ComputeEmDailyfirmrecord computeEmDailyfirmrecord) {
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
        String dateDay=sdf1.format(date);
        String updateTime=sdf.format(date);
        computeEmDailyfirmrecord.setDateDay(dateDay);
        computeEmDailyfirmrecord.setUpdateTime(updateTime);
        return computeEmDailyfirmrecordMapper.insertSelective(computeEmDailyfirmrecord);
    }

    @Override
    public int addEmFirmMonthly(ComputeEmMonthlyfirmrecord computeEmMonthlyfirmrecord) {
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM");
        String dateDay=sdf1.format(date);
        String updateTime=sdf.format(date);
        computeEmMonthlyfirmrecord.setDateMonth(dateDay);
        computeEmMonthlyfirmrecord.setUpdateTime(updateTime);
        return computeEmMonthlyfirmrecordMapper.insertSelective(computeEmMonthlyfirmrecord);
    }

    @Override
    public int addWmFirmDaily(ComputeWmDailyfirmrecord computeWmDailyfirmrecord) {
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
        String dateDay=sdf1.format(date);
        String updateTime=sdf.format(date);
        computeWmDailyfirmrecord.setDateDay(dateDay);
        computeWmDailyfirmrecord.setUpdateTime(updateTime);
        return computeWmDailyfirmrecordMapper.insertSelective(computeWmDailyfirmrecord);
    }

    @Override
    public int addWmFirmMonthly(ComputeWmMonthlyfirmrecord computeWmMonthlyfirmrecord) {
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM");
        String dateDay=sdf1.format(date);
        String updateTime=sdf.format(date);
        computeWmMonthlyfirmrecord.setDateMonth(dateDay);
        computeWmMonthlyfirmrecord.setUpdateTime(updateTime);
        return computeWmMonthlyfirmrecordMapper.insertSelective(computeWmMonthlyfirmrecord);
    }

    @Override
    public int deleteEmFirmDaily(ComputeEmDailyfirmrecord computeEmDailyfirmrecord) {
        Long idd=computeEmDailyfirmrecord.getId();
        return computeEmDailyfirmrecordMapper.deleteByPrimaryKey(idd);
    }

    @Override
    public int deleteEmFirmMonthly(ComputeEmMonthlyfirmrecord computeEmMonthlyfirmrecord) {
        Long idd=computeEmMonthlyfirmrecord.getId();
        return computeEmMonthlyfirmrecordMapper.deleteByPrimaryKey(idd);
    }

    @Override
    public int deleteWmFirmDaily(ComputeWmDailyfirmrecord computeWmDailyfirmrecord) {
        Long idd=computeWmDailyfirmrecord.getId();
        return computeWmDailyfirmrecordMapper.deleteByPrimaryKey(idd);
    }

    @Override
    public int deleteWmFirmMonthly(ComputeWmMonthlyfirmrecord computeWmMonthlyfirmrecord) {
        Long idd=computeWmMonthlyfirmrecord.getId();
        return computeWmMonthlyfirmrecordMapper.deleteByPrimaryKey(idd);
    }

    @Override
    public int updateEmFirmDaily(ComputeEmDailyfirmrecord computeEmDailyfirmrecord) {
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String updateTime=sdf.format(date);
        computeEmDailyfirmrecord.setUpdateTime(updateTime);
        return computeEmDailyfirmrecordMapper.updateByPrimaryKeySelective(computeEmDailyfirmrecord);
    }

    @Override
    public int updateEmFirmMonthly(ComputeEmMonthlyfirmrecord computeEmMonthlyfirmrecord) {
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String updateTime=sdf.format(date);
        computeEmMonthlyfirmrecord.setUpdateTime(updateTime);
        return computeEmMonthlyfirmrecordMapper.updateByPrimaryKeySelective(computeEmMonthlyfirmrecord);
    }

    @Override
    public int updateWmFirmDaily(ComputeWmDailyfirmrecord computeWmDailyfirmrecord) {
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String updateTime=sdf.format(date);
        computeWmDailyfirmrecord.setUpdateTime(updateTime);
        return computeWmDailyfirmrecordMapper.updateByPrimaryKeySelective(computeWmDailyfirmrecord);
    }

    @Override
    public int updateWmFirmMonthly(ComputeWmMonthlyfirmrecord computeWmMonthlyfirmrecord) {
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String updateTime=sdf.format(date);
        computeWmMonthlyfirmrecord.setUpdateTime(updateTime);
        return computeWmMonthlyfirmrecordMapper.updateByPrimaryKeySelective(computeWmMonthlyfirmrecord);
    }
}

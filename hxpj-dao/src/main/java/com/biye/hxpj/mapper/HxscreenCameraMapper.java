package com.biye.hxpj.mapper;

import com.biye.hxpj.model.HxscreenCamera;

import java.util.List;

public interface HxscreenCameraMapper {

    List<HxscreenCamera> findAll();

    int deleteByPrimaryKey(Long cameraId);

    int insertSelective(HxscreenCamera record);

    HxscreenCamera selectByPrimaryKey(Long cameraId);

    int updateByPrimaryKeySelective(HxscreenCamera record);
}
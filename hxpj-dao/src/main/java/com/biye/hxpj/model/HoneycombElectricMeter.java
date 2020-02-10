package com.biye.hxpj.model;

import lombok.Data;

@Data
public class HoneycombElectricMeter {
    //设备ID
    private String deviceId;
    //设备名称
    private String title;
    //设备类型：电表  0：电表   1：水表
    private String type;
}
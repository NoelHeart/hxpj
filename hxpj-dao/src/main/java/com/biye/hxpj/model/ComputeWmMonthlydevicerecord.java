package com.biye.hxpj.model;

import lombok.Data;

@Data
public class ComputeWmMonthlydevicerecord {
    private Long id;

    private String scale;

    private String updateTime;

    private String device;

    private Long apartmentId;

    private Long roomId;

    private String dateMonth;

    private String firmName;
}
package com.biye.hxpj.model;

import lombok.Data;

@Data
public class ComputeEmDailydevicerecord {
    private Long id;

    private String scale;

    private String updateTime;

    private String device;

    private Long apartmentId;

    private Long roomId;

    private String dateDay;

    private String firmName;
}
package com.biye.hxpj.model;

import lombok.Data;

@Data
public class HoneycombEmApartmentroom {
    private Long id;

    private Long apartmentId;

    private Long roomId;

    private String deviceId;

    private FirmApartmentroom firmApartmentroom;
}
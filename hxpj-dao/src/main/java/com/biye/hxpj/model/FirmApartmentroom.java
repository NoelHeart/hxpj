package com.biye.hxpj.model;

import lombok.Data;

@Data
public class FirmApartmentroom {
    private Long id;

    private Long apartmentId;

    private Long roomId;

    private String firm;
}
package com.biye.hxpj.model;

import lombok.Data;

@Data
public class HoneycombPersonApartmentroom {
    private Long id;

    private Long apartmentId;

    private Long roomId;

    private String roomer;

    private String phoneNumber;

    private FirmApartmentroom firmApartmentroom;
}
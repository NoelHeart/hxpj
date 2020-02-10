package com.biye.hxpj.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TotalEmDaily {
    private Long id;

    private String dataDay;

    private BigDecimal dataScale;
}
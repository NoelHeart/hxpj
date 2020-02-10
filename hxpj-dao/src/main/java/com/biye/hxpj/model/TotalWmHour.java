package com.biye.hxpj.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TotalWmHour {
    private Long id;

    private String dataHour;

    private BigDecimal dataScale;
}
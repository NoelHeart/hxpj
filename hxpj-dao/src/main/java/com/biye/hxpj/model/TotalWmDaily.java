package com.biye.hxpj.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TotalWmDaily {
    private Long id;

    private String dataDay;

    private BigDecimal dataScale;
}
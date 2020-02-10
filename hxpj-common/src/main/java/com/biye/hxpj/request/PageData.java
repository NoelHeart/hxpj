package com.biye.hxpj.request;

import lombok.Data;

/**
 * @program: hxpj
 * @description: pageHelper
 * @author: LiLei
 * @create: 2019-04-15 16:16
 **/
@Data
public class PageData {
    private Integer pageNum;
    private Integer pageSize;
    private String firm;
    private Long apartmentId;
    private Long roomId;
    private String mohuSelect;
    private Long mohuId;
}

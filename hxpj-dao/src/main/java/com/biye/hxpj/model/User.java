package com.biye.hxpj.model;


import lombok.Data;

import java.util.Date;


/**
 * @program: hxpj
 * @description: 用户类
 * @author: LiLei
 * @create: 2019-03-23 20:10
 **/

@Data
public class User {
    private Long userId;
    private String userAccount;
    private String passWord;
    private String email;
    private String name;
    private String phone;
    private String role;
}

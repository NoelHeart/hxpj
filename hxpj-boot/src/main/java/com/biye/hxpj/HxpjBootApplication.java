package com.biye.hxpj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @program: hxpj
 * @description:
 * @author: LiLei
 * @create: 2019-03-26 00:24
 **/
@MapperScan(basePackages = "com.biye.hxpj.mapper")
@EnableScheduling
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class HxpjBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(HxpjBootApplication.class, args);
    }
}

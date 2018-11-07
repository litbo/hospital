package com.litbo.hospital.lifemanage.bean;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class LifeManage {
    private String id;
    private String name;
    private Integer age;
    private String Date;
    private BigDecimal price;

    public LifeManage(String id, String name, Integer age, String date, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.age = age;
        Date = date;
        this.price = price;
    }
}

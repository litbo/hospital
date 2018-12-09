package com.litbo.hospital.user.vo;

import lombok.Data;

import java.util.List;

@Data
public class TreeVo {

    private String name;

    private String id;

    private boolean spread;

    private List<TreeVo> children;



}



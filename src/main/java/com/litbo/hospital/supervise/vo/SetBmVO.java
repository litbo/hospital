package com.litbo.hospital.supervise.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class SetBmVO implements Serializable {
    private String pbmId;    //新父科室
    private String[] obmIds;  //待处理的科室

}

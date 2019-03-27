package com.litbo.hospital.supervise.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class SetBmVO implements Serializable {
    private String pbmId;    //新父部门
    private String[] obmIds;  //待处理的部门

}

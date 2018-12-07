package com.litbo.hospital.security.bean;

import lombok.Data;

@Data
public class FwPjqlZjb {
    private Integer id;
    private Integer pjqlId;
    private Integer pjId;
    private Integer pjCount;
    public FwPjqlZjb(){

    }
    public FwPjqlZjb(Integer pjCount) {
        this.pjCount = pjCount;
    }
}

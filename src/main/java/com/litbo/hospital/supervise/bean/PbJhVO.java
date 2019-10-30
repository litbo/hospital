package com.litbo.hospital.supervise.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class PbJhVO {
    private String pbJhid;
    private String bmId;
    private String userId;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date pbDate;

    public PbJhVO() {
    }

    public PbJhVO(String pbJhid, String bmId, String userId, Date pbDate) {
        this.pbJhid = pbJhid;
        this.bmId = bmId;
        this.userId = userId;
        this.pbDate = pbDate;
    }
}

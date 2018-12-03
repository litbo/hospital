package com.litbo.hospital.security.bean;

import com.litbo.hospital.security.enums.EnumStatus;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
@Data
public class FwFp {
    private Integer id;

    private String fpDh;

    private BigDecimal fpPrice;

    private Date fpSdtime;

    private Integer fpStatus;

    private String userId;

    private Date fpCjTime;


}
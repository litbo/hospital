package com.litbo.hospital.security.enums;

import lombok.Getter;

public enum EnumBlsj implements CodeEnum{
    FW_BLSJ_SB(1,"设备"),
    FW_BLSJ_WZ(2,"报修受理"),
    ;
    @Getter
    private Integer code;
    @Getter
    private String message;
    EnumBlsj(Integer code, String message){
        this.code = code;
        this.message = message;
    }
}

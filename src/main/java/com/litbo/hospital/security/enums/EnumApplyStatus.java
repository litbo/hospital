package com.litbo.hospital.security.enums;

import lombok.Getter;

public enum EnumApplyStatus implements CodeEnum{
    WAIT_EXAMINE(0,"待审核"),
    APPLY_APPROVAL(1,"审核通过"),
    APPLY_REJECT(2,"审核拒绝");

    @Getter
    private Integer code;
    @Getter
    private String message;
    EnumApplyStatus(Integer code,String message){
        this.code = code;
        this.message = message;
    }
}

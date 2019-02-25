package com.litbo.hospital.common.task.enums;

import com.litbo.hospital.security.enums.CodeEnum;
import lombok.Getter;

public enum EnumProcess implements CodeEnum {
    WAIT_COMPLETED(0,"待完成"),
    COMPLETED(1,"已完成");
    @Getter
    private Integer code;
    @Getter
    private String message;
    EnumProcess(Integer code, String message){
        this.code = code;
        this.message = message;
    }
}

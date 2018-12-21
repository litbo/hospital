package com.litbo.hospital.supervise.enums;

import lombok.Getter;

public enum  ZdShZtEnumProcess {

    // 审核正常流程

    ZD_SHZT_KEMUBX(0,"编写"),
    ZD_SHZT_KSMUXG(1,"科室秘书编写"),
    ZD_SHZT_SYQXG(2,"试用期修改"),


    ZD_SHZT_KESH(3,"科长审核"),
    ZD_SHZT_CZSH(4,"处长审核"),
    ZD_SHZT_SY(5,"试用"),
    ZD_SHZT_BA(6,"备案");





    @Getter
    private Integer code;
    @Getter
    private String message;
    ZdShZtEnumProcess(Integer code,String message){
        this.code = code;
        this.message = message;
    }
}

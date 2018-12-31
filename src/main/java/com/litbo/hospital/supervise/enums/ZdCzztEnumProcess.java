package com.litbo.hospital.supervise.enums;

import lombok.Getter;

public enum ZdCzztEnumProcess {
//   操作状态 2 通过 1 不通过  0 待审核
    ZD__CZZT_DSH(0,"待审核"),
    ZD__CZZT__BTG(1,"不通过"),
    ZD__CZZT_TG(2,"通过");

    @Getter
    private Integer code;
    @Getter
    private String message;
    ZdCzztEnumProcess(Integer code, String message){
        this.code = code;
        this.message = message;
    }


}

package com.litbo.hospital.supervise.enums;

import lombok.Getter;

public enum  ZdztEnumProcess {
//    3 备案 2 试用 1 审核中 0 审核失败
    ZD__ZT_SHSB(0,"审核失败"),
    ZD__ZT_SHZ(1,"审核中"),
    ZD__ZT_SY(2,"试用"),
    ZD__ZT_BA(3,"备案"),
    ZD__ZT_YTY(4,"已停用");

    @Getter
    private Integer code;
    @Getter
    private String message;
    ZdztEnumProcess(Integer code,String message){
        this.code = code;
        this.message = message;
    }


}

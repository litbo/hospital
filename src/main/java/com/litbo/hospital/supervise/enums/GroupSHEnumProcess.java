package com.litbo.hospital.supervise.enums;

import lombok.Getter;

public enum GroupSHEnumProcess {
//   2 已通过 1 待审核 0 已退回
    Grouop_ZT_YTH("0","已退回"),
    Grouop__ZT_DSH("1","待审核"),
    Grouop__ZT_YTG("2","已通过");


    @Getter
    private String  code;
    @Getter
    private String message;
    GroupSHEnumProcess(String  code, String message){
        this.code = code;
        this.message = message;
    }


}

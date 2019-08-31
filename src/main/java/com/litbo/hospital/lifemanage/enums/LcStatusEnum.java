package com.litbo.hospital.lifemanage.enums;

import lombok.Getter;

/*流程状态*/
@Getter
public enum LcStatusEnum {
    BIANXIE(1, "编写"),
    SHENHE(2, "审核"),
    WANSHAN(3, "完善"),
    SYQXG(4, "试用期修改"),
    ZPJSQ(5, "再评价申请"),
    ZPJSH(6, "再评价审核");
    private Integer id;
    private String status;

    LcStatusEnum(Integer id, String status) {
        this.id = id;
        this.status = status;
    }
}


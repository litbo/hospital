package com.litbo.hospital.lifemanage.enums;

import lombok.Getter;

/*状态*/
@Getter
public enum ZtStatus {
    DAISHENHE(0, "应急预案待审核"),
    DAIWANSHAN(1, "应急预案待完善"),
    SHIYONGQI(2, "应急预案试用期");
    private Integer id;
    private String status;

    ZtStatus(Integer id, String status) {
        this.id = id;
        this.status = status;
    }
}

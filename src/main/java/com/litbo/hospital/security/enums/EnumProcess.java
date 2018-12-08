package com.litbo.hospital.security.enums;

import lombok.Getter;

public enum EnumProcess {
    FW_GZ_BX(1,"故障报修"),
    FW_BX_SL(2,"报修受理"),
    FW_ZZ_WB(3,"终止误报"),
    FW_GZ_JX(4,"故障检修"),
    FW_PJ_QL(5,"配件请领"),
    FW_PJ_QL_SH_TG(6,"配件请领审核通过"),
    FW_PJ_QL_SH_WTG(7,"配件请领审核未通过"),
    FW_YW_WX_SQ(8,"院外维修申请"),
    FW_YW_WX_SH(9,"院外维修审核"),
    FW_WX_WC_QR(10,"维修完成确认"),
    FW_BLSJ(11,"不良事件生成");
    @Getter
    private Integer code;
    @Getter
    private String message;
    EnumProcess(Integer code,String message){
        this.code = code;
        this.message = message;
    }
}

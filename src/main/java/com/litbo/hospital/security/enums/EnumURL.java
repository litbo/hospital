package com.litbo.hospital.security.enums;

import lombok.Getter;

public enum EnumURL{
    EXAMINE_APPLY("/admin/index/examine/examine-apply.html"),
    EXAMINE_SUSPICIOUS("/admin/index/examine/examine-suspicious.html"),
    EXAMINE_PURCHASE("/admin/index/examine/examine-purchase.html"),
    REPAIR_CONFIRM("/admin/index/examine/repair_confirm.html"),
    REPAIR_EXAMINE("/admin/index/examine/repair-examine.html");
    @Getter
    private String message;
    EnumURL(String message){
        this.message = message;
    }
}

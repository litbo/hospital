package com.litbo.hospital.lifemanage.enums;

/**
 * 处置方式Enum
 *
 * @author Administrator on 2018-12-29
 */
public enum ModeEnum {
    /**
     * 处置方式 对应的标识码和对应的处置方式信息
     */
    ONE(1, "报废"), TWO(2, "捐赠"), THREE(3, "调拨");

    /**
     * 处置码
     */
    private Integer code;
    /**
     * 处置方式信息
     */
    private String message;

    ModeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
    /**
     * 通过code获取对应的枚举实例
     *
     * @param code code
     * @return 枚举实例
     */
    public static ModeEnum getEnumByCode(Integer code) {
        for (ModeEnum simpleEnum : ModeEnum.values()) {
            if (code != null && code.equals(simpleEnum.code)) {
                return simpleEnum;
            }
        }
        return null;
    }

    /**
     * 通过code 获取对应的 message
     *
     * @param code code
     * @return message
     */
    public static String getMessageByCode(Integer code) {
        return getEnumByCode(code) != null ? getEnumByCode(code).message : null;
    }
}

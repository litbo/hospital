package com.litbo.hospital.lifemanage.enums;

/**
 * 状态枚举类
 *
 * @author Administrator on 2018-12-20
 */
public enum StateEnum {
    /**
     * 账实核对是否存在
     */
    CHECK_Y(1,"是"),CHECK_N(0,"否");

    /**
     * 处置码
     */
    private Integer code;
    /**
     * 处置方式信息
     */
    private String message;

    StateEnum(Integer code, String message) {
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
    public static StateEnum getEnumByCode(Integer code) {
        for (StateEnum simpleEnum : StateEnum.values()) {
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

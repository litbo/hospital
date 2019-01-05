package com.litbo.hospital.common.utils;

import com.litbo.hospital.security.enums.CodeEnum;

/**
 * @author zjc
 * @create 2019-01-05 9:17
 */
public class EnumUtils {

    public static <T extends CodeEnum> T getByCode(Class<T> enumClass,Integer code){
        for(T each:enumClass.getEnumConstants()){
            if(each.getCode() == code){
                return each;
            }
        }
        return null;
    }

}

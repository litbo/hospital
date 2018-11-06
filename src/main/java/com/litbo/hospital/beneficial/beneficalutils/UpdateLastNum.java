package com.litbo.hospital.beneficial.beneficalutils;

import org.apache.commons.lang3.StringUtils;

public class UpdateLastNum {
    /*
    * 修改字符串后两位
    * */
    public String uadateNum(String newStr, String c_code){

        int len = c_code.length();
        int updateLen = newStr.length();
        StringBuilder sb = new StringBuilder(c_code);
        if(StringUtils.isNotBlank(newStr)) {
            sb.replace(len - updateLen, len, newStr);
        }
        return sb.toString();
    }
}

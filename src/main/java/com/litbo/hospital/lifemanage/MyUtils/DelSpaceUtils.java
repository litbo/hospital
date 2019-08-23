package com.litbo.hospital.lifemanage.MyUtils;

import org.apache.commons.lang3.StringUtils;

public class DelSpaceUtils {
   public static String  deleteSpace(String str) {
        if (!StringUtils.isNotBlank(str)) {
            return "";
        }
       return  str.replaceAll(" ","");
    }
}

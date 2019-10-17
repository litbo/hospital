package com.litbo.hospital.lifemanage.MyUtils;

import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class String2DateUtil {
    public static Date StringtoDate(String str){
        if(StringUtils.isNotBlank(str)){
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date date = null;
            try {
                date = format.parse(str);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return date;
        }

        else{
            return null;
        }

    }
    public static Date StringtoDateSfm(String str){
        if(StringUtils.isNotBlank(str)){
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = null;
            try {
                date = format.parse(str);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return date;
        }

        else{
            return null;
        }

    }
}

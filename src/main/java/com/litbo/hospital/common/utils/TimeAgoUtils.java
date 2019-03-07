package com.litbo.hospital.common.utils;

import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Date;

/**
 * @author Administrator
 */
public class TimeAgoUtils {

    public static String format(Date date) {
        LocalDate today = LocalDate.now();

        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        LocalDate oldDay = localDateTime.toLocalDate();

        String result = "";
        //计算两个日期差值
        Period p = Period.between(oldDay, today);
        int year = p.getYears();
        int months = p.getMonths();
        int day = p.getDays();
        if (year > 0){
            result += (year + "年");
        }
        if (months > 0){
            result += (months + "个月");
        }
        if (day > 0){
            result += (day + "天");
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse("2014-15-07");
        System.out.println(format(date));
    }

}

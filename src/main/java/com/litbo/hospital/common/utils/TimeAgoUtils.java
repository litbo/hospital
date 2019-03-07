package com.litbo.hospital.common.utils;

import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 */
public class TimeAgoUtils {

    public static String compareTime(Date date) {
        LocalDate today = LocalDate.now();

        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        LocalDate oldDay = localDateTime.toLocalDate();

        String result = "";
        //计算两个日期差值
        Period p = Period.between(oldDay, today);
        int year = p.getYears();
        int month = p.getMonths();
        int day = p.getDays();
        if (year > 0){
            result += (year + "年");
        }
        if (month > 0){
            result += (month + "个月");
        }
        if (day > 0){
            result += (day + "天");
        }
        return result;
    }

    /**
     * 传的date与今天对比获取相差的年月日
     * @param date 日期
     * @return Map<String,Integer> key={year month day}
     */
    public static Map<String,Integer> compareTimeToMap(Date date) {
        LocalDate today = LocalDate.now();

        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        LocalDate oldDay = localDateTime.toLocalDate();

        Map<String,Integer> result = new HashMap<>(3);
        //计算两个日期差值
        Period p = Period.between(oldDay, today);
        int year = p.getYears();
        int month = p.getMonths();
        int day = p.getDays();
        if (year > 0){
            result.put("year",year);
        }
        if (month > 0){
            result.put("month",month);
        }
        if (day > 0){
            result.put("day",day);
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse("2014-15-07");
        System.out.println(compareTime(date));
    }

}

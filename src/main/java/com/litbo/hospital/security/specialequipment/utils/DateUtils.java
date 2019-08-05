package com.litbo.hospital.security.specialequipment.utils;

import org.apache.poi.ss.usermodel.DateUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateUtils {


//    public LocalDate DateAddUseMonth(LocalDate localDate,int addMonth){
//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        int year = localDate.getYear();
//        int month = localDate.getMonthValue();
//        int day = localDate.getDayOfMonth();
//        String monthString = String.valueOf(month);;
//        String dayString = String.valueOf(day);
//        String yearString = String.valueOf(year);
//        if( (month + addMonth) <= 12 ){
//            month = month + addMonth ;
//        }else {
//            month = month + addMonth - 12;
//            year++;
//            yearString = String.valueOf(year);
//        }
//        if(month < 10){
//            monthString = "0" + String.valueOf(month);
//        }else{
//            monthString = String.valueOf(month);
//        }
//        if(day < 10){
//            dayString = "0" + String.valueOf(day);
//        }else {
//            dayString = String.valueOf(day);
//        }
//        String newDate = yearString + "-" + monthString + "-" + dayString;
//        return LocalDate.parse(newDate, dateTimeFormatter);
//
//    }

    private static SimpleDateFormat simpleDateFormat = null;

    //增加月份
    public static Date DateAddUseMonth(Date date,int addMonth){

        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        date = org.apache.commons.lang3.time.DateUtils.addMonths(date,addMonth);
        String format = simpleDateFormat.format(date);
        try {
            return simpleDateFormat.parse(format);
        } catch (ParseException e) {
            e.printStackTrace();
            return new Date();
        }

    }
    //获取当前按yyyy-MM-dd
    public static Date getCurrentDate(){
        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = simpleDateFormat.format(new Date());
        try {
            return simpleDateFormat.parse(format);
        } catch (ParseException e) {
            e.printStackTrace();
            return new Date();
        }
    }




}

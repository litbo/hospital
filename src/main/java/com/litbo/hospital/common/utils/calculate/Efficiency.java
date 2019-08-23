package com.litbo.hospital.common.utils.calculate;

import java.text.NumberFormat;

/**
 * description: 计算效率
 * @Author: jz
 * @Date: 2019/7/5 16:30
 */
public  class Efficiency {

    public static String result(String fenZi,String fenMu){

        NumberFormat per = NumberFormat.getPercentInstance();

        if (fenZi==null||fenZi.isEmpty()){
            fenZi = "0";
        }
        if (!fenMu.isEmpty()&&!"0".equals(fenMu)&&!fenMu.equals("")){

            Double aDouble = Double.valueOf(fenZi);
            Double aDouble1 = Double.valueOf(fenMu);
            Double end = aDouble/aDouble1*100;
            return  String.format("%.2f",end);
        }
        throw new RuntimeException("请检查传入的参数");
    }

    public static String results(String fenZi,String fenMu){
        if (fenZi==null||fenZi.isEmpty()){
            fenZi = "0";
        }
        if (!fenMu.isEmpty()&&!fenMu.equals("0")&&!fenMu.equals("")){
            Double aDouble = Double.valueOf(fenZi);
            Double aDouble1 = Double.valueOf(fenMu);
            Double end = (aDouble/3600)/aDouble1;
            return  String.format("%.2f",end);
        }
        throw new RuntimeException("请检查传入的参数");
    }

}

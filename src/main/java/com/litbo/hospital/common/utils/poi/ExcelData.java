package com.litbo.hospital.common.utils.poi;

import lombok.Data;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
public class ExcelData implements Serializable {
    private static final long serialVersionUID = 4444017239100620999L;
    // 表头
    private List<String> titles;
    // 数据
    private List<List<Object>> rows;
    // 页签名称
    private String name;
    //返回信息
    private String message="成功";
    //状态
    public ExcelData(){
    }
    /**
     * 导出数据时调用此构造方法
     * @param titles   表头
     * @param list     list数据（example List<user>）
     * @param name      sheet名字
     */
    public ExcelData(List<String> titles,List<Object> list,String name){
        this.titles = titles;
        this.name = name;
        this.rows = beanToList(list);
    }

    private boolean status=true;
    public  List<List<Object>> beanToList(List<Object> Objects){
        List<List<Object>> res = new ArrayList();
        for (Object o : Objects){
            List valueList = new ArrayList();
            String[] fieldNames = getFiledName(o);
            for(int j=0 ; j<fieldNames.length ; j++){
                String name = fieldNames[j];    //获取属性的名字
                Object value = getFieldValueByName(name,o);
                valueList.add(value);
            }
            res.add(valueList);
        }
        return res;
    }
    /**
     * 获取属性名数组
     * */
    public  String[] getFiledName(Object o){
        Field[] fields=o.getClass().getDeclaredFields();
        String[] fieldNames=new String[fields.length];
        for(int i=0;i<fields.length;i++){
            fieldNames[i]=fields[i].getName();
        }
        return fieldNames;
    }
    /* 根据属性名获取属性值
     * */
    private  Object getFieldValueByName(String fieldName, Object o) {
        try {
            String firstLetter = fieldName.substring(0, 1).toUpperCase();
            String getter = "get" + firstLetter + fieldName.substring(1);//拼接get方法
            Method method = o.getClass().getMethod(getter, new Class[]{});
            Object value = method.invoke(o, new Object[] {});
            return value;
        } catch (Exception e) {
            return null;
        }

    }


}

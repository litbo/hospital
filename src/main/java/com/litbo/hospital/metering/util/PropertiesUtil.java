package com.litbo.hospital.metering.util;

import java.io.*;
import java.util.Properties;

/**
 * @Author: 樊小铭
 * Date: 2019/8/11 17:24
 * @Version:
 * @Description:
 */
public class PropertiesUtil {

    private static Properties propertiesUtil = new Properties();

    private static FileInputStream in = null;
    private static FileOutputStream out = null;
    private static String fileUrl = "C:\\hospitalConfigFile\\";
    private static String fileName = "dossierTimeDate.properties";

    private PropertiesUtil(){

    }
    public static String getPropertie(String key){
        try {
            // 打开配置文件，如果文件不存在就创建文件
            File file = new File(fileUrl+fileName);
            if(!file.exists()){
                File dir = new File(fileUrl);
                if(!dir.exists()){
                    dir.mkdirs();
                }
                file.createNewFile();
            }

            in = new FileInputStream(file);
            propertiesUtil.load(in);
            return propertiesUtil.getProperty(key);
        } catch (IOException e) {
            System.out.println("C:\\hospitalConfigFile\\dossierTimeDate.properties配置文件创建失败！");
            e.printStackTrace();
        }finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    public static int setPropertie(String key,String value){
        try {
            // 打开配置文件，如果文件不存在就创建文件
            File file = new File(fileUrl+fileName);
            if(!file.exists()){
                File dir = new File(fileUrl);
                if(!dir.exists()){
                    dir.mkdirs();
                }
                file.createNewFile();
            }
            out = new FileOutputStream(file);

            propertiesUtil.setProperty(key,value);
            propertiesUtil.store(out,null);
            return 1;
        } catch (IOException e) {
            System.out.println("档案管理的配置文件读取异常！请检查`D:\\hospitalConfigFile\\dossierTimeDate.properties`配置文件");
            e.printStackTrace();
        }finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }


}

package com.litbo.hospital.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
//@Component
public class StartListener implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("limit.log")));
            StringBuffer result = new StringBuffer();
            String s = null;
            while((s = bufferedReader.readLine())!=null){
                result.append(s);
            }

            String pkey = "litbo";
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            kgen.init(128, new SecureRandom(pkey.getBytes()));
            SecretKey secretKey = kgen.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
            Cipher cipher = Cipher.getInstance("AES");// 创建密码器

            //解密
            cipher.init(Cipher.DECRYPT_MODE, key);// 初始化解密器
            byte[] decryptFrom = parseHexStr2Byte(result.toString().substring(0,32));
            byte[] result1 = cipher.doFinal(decryptFrom);


            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHH");
            SimpleDateFormat mm = new SimpleDateFormat("mm");
            String m = mm.format(date);
            int a = Integer.parseInt(m);
            int b = (a/10)*10;
            String password = formatter.format(date)+new Integer(b).toString();
            String p = new String(result1);
            System.out.println(p+"   "+password+"   "+p.equals(password)+"------------------哈哈哈");
            if(!p.equals(password)){
                System.out.println("------------------哈哈哈");
                event.getApplicationContext().getAutowireCapableBeanFactory().
                        destroyBean(event.getApplicationContext().
                                getBean("org.springframework.boot.context." +
                                        "properties.ConversionServiceDeducer$Factory"));
                event.getApplicationContext().getAutowireCapableBeanFactory().
                        destroyBean(event.getApplicationContext().
                                getBean("org.apache.ibatis.session.defaults.DefaultSqlSessionFactory"));
            }
        }catch (Exception e){
            event.getApplicationContext().getAutowireCapableBeanFactory().
                    destroyBean(event.getApplicationContext().
                            getBean("org.springframework.boot.context." +
                                    "properties.ConversionServiceDeducer$Factory"));
            event.getApplicationContext().getAutowireCapableBeanFactory().
                    destroyBean(event.getApplicationContext().
                            getBean("org.apache.ibatis.session.defaults.DefaultSqlSessionFactory"));
            log.error("未授权");
        }

    }
    static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1)
            return null;
        byte[] result = new byte[hexStr.length() / 2];
        for (int i = 0; i < hexStr.length() / 2; i++) {
            int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
            int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }

}

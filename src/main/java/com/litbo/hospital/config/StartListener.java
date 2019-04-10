package com.litbo.hospital.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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
            while((s = bufferedReader.readLine())!=null){//使用readLine方法，一次读一行
                result.append(s);
            }
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHH");
            SimpleDateFormat mm = new SimpleDateFormat("mm");
            String m = mm.format(date);
            int a = Integer.parseInt(m);
            int b = (a/10)*10;
            String password = formatter.format(date)+new Integer(b).toString();
            String encodeStr=DigestUtils.md5Hex(password);
            if(!encodeStr.equals(result.toString().substring(0,32))){
                event.getApplicationContext().getAutowireCapableBeanFactory().
                        destroyBean(event.getApplicationContext().
                                getBean("org.springframework.boot.context." +
                                        "properties.ConversionServiceDeducer$Factory"));
                event.getApplicationContext().getAutowireCapableBeanFactory().
                        destroyBean(event.getApplicationContext().
                                getBean("org.apache.ibatis.session.defaults.DefaultSqlSessionFactory"));
            }
        }catch (IOException e){
            log.error("未授权");
        }

    }
}

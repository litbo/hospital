package com.litbo.hospital.security.specialequipment.utils;

import com.litbo.hospital.security.specialequipment.dao.GenerateIdDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class GenerateId {

    @Autowired
    private GenerateIdDao getGenerateIdDao;

    private static GenerateIdDao generateIdDao;

    @PostConstruct
    public void init(){
        GenerateId.generateIdDao = getGenerateIdDao;
    }


    public static String getIdByIDAndTime(String dbName,String userId){
        String endId = generateIdDao.getEndId(dbName,userId);
        int id = 0;

        if(endId != null&&endId.length()>=6){
            String ids = endId.substring(6, endId.length());
            id = Integer.parseInt(ids);
        }
        return getTime()+new DecimalFormat("000000").format(id+1);
    }

    public static String getTime() {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyyMM");
        String time = dateFormat.format(date);
        return time;
    }


}

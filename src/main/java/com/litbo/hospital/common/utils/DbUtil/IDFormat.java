package com.litbo.hospital.common.utils.DbUtil;

import com.litbo.hospital.common.dao.DbIdDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zjc
 * @create 2018-11-29 14:25
 * id生成
 */
public class IDFormat {

    @Autowired
    private static DbIdDao dbIdDao;

    /**
     * 根据流水号和当前时间生成id
     * @return
     */
    public static String getIdByIDAndTime(String dbName,String userId){
        String endId = dbIdDao.getEndId(dbName,userId);
        String id = endId.substring(6, endId.length() - 1);
        return getTime()+id+1;
    }


    public static String getTime() {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyyMM");
        String time = dateFormat.format(date);
        return time;
    }

}

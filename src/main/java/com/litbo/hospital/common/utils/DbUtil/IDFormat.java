package com.litbo.hospital.common.utils.DbUtil;

import com.litbo.hospital.common.dao.DbIdDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zjc
 * @create 2018-11-29 14:25
 * id生成
 */
@Component
public class IDFormat {

    @Autowired
    private DbIdDao dbIdDaoTmp;

    private static DbIdDao dbIdDao;

    @PostConstruct
    public void init(){
        IDFormat.dbIdDao=dbIdDaoTmp;
    }

    /**
     * 根据流水号和当前时间生成id
     * @return
     */
    public static String getIdByIDAndTime(String dbName,String userId){
        String endId = dbIdDao.getEndId(dbName,userId);
        int id = 0;
        System.out.println(endId);
        if(endId != null&&endId.length()>=6){
            String ids = endId.substring(6, endId.length());
            id = Integer.parseInt(ids);
        }
        return getTime()+new DecimalFormat("000000").format(id+1);
    }


    /*预案编号生成专用*/
    public  static String getIdByIDAndTime2(String dbName,String userId){
        String endId = dbIdDao.getEndId(dbName,userId);
        int id = 0;
        if(endId != null&&endId.length()>=6){
            String ids = endId.substring(12, endId.length());
            id = Integer.parseInt(ids);
        }
        return getTime()+new DecimalFormat("000000").format(id+1);
    }


    /*操作规程编号生成专用*/
    public  static String getIdByIDAndTime3(String dbName,String userId){
        String endId = dbIdDao.getEndId(dbName,userId);
        int id = 0;
        if(endId != null&&endId.length()>=6){
            String ids = endId.substring(13, endId.length());
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

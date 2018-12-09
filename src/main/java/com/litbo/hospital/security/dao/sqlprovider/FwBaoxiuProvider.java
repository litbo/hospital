package com.litbo.hospital.security.dao.sqlprovider;

import org.apache.ibatis.jdbc.SQL;

/**
 * @author zjc
 * @create 2018-12-04 17:05
 */
public class FwBaoxiuProvider {

    public String listFwBaoxiu(){
        return new SQL(){
            {
                SELECT("*");
                FROM("fw_baoxiu");
                /*if()*/
            }
        }.toString();
    }

    /*public String updateFwBaoxiuStatus(){
        return new SQL(){
            {
                UPDATE("fw_baoxiu");
                SET()
            }
        }.toString();
    }*/
}

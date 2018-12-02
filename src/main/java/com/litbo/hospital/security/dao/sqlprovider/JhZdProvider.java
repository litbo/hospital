package com.litbo.hospital.security.dao.sqlprovider;

import org.apache.ibatis.jdbc.SQL;

/**
 * @author zjc
 * @create 2018-11-30 16:00
 */
public class JhZdProvider {

    public String findList(String createdate,String jhName){
        return new SQL(){
            {
                SELECT("*");
                FROM("jh_zd");
                if(createdate != null){
                    WHERE("jh_kstime>#{createdate}");
                }
                if(jhName != null){
                    WHERE("jh_name=#{jhName}");
                }
            }

        }.toString();
    }
}

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
                SELECT("jh.jh_name,\n" +
                        "jh.px_addr,\n" +
                        "jh.jh_pxlx,\n" +
                        "jh.jh_pxxz,\n" +
                        "jh.jh_kstime,\n" +
                        "jh.jh_jstime,\n" +
                        "jh.user_id as userXm,\n" +
                        "jh.id,\n" +
                        "jh.user_id");
                FROM("jh_zd as jh");
                if(createdate != null){
                    WHERE("jh_kstime>#{createdate}");
                }
                if(jhName != null){
                    WHERE("jh_name like '%'+#{jhName}+'%'");
                }
            }

        }.toString();
    }

    public String findListByKsTime(String createdate,String jhName){
        return new SQL(){
            {
                SELECT("jh.jh_name,\n" +
                        "jh.px_addr,\n" +
                        "jh.jh_pxlx,\n" +
                        "jh.jh_pxxz,\n" +
                        "jh.jh_kstime,\n" +
                        "jh.jh_jstime,\n" +
                        "jh.user_id as userXm,\n" +
                        "jh.id,\n" +
                        "jh.user_id");
                FROM("jh_zd as jh");
                WHERE("jh.jh_kstime > (select GETDATE())");
                if(createdate != null){
                    WHERE("jh_kstime>#{createdate}");
                }
                if(jhName != null){
                    WHERE("jh_name like %+#{jhName}+%");
                }
            }

        }.toString();
    }

    public String findListByJsTime(String createdate,String jhName){
        return new SQL(){
            {
                SELECT("jh.jh_name,\n" +
                        "jh.px_addr,\n" +
                        "jh.jh_pxlx,\n" +
                        "jh.jh_pxxz,\n" +
                        "jh.jh_kstime,\n" +
                        "jh.jh_jstime,\n" +
                        "jh.user_id as userXm,\n" +
                        "jh.id,\n" +
                        "jh.user_id");
                FROM("jh_zd as jh");
                WHERE("jh.jh_jstime < (select GETDATE())");
                if(createdate != null){
                    WHERE("jh_kstime>#{createdate}");
                }
                if(jhName != null){
                    WHERE("jh_name like %+#{jhName}+%");
                }
            }

        }.toString();
    }
}

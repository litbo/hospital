package com.litbo.hospital.security.dao.sqlprovider;
import org.apache.ibatis.jdbc.SQL;


public class FwPjzdSqlProvider {
    public String listFwPjzd(String pjSzm, String pjfl){
        return new SQL(){
            {
                SELECT("*");
                FROM("fw_pjzd");
                if (pjSzm!=null) {
                    WHERE("pj_szm like '%'+#{pjSzm}+'%'");
                }
                if (pjfl!=null){
                    WHERE("pjfl like '%'+#{pjfl}+'%'");
                }
            }
        }.toString();
    }
}

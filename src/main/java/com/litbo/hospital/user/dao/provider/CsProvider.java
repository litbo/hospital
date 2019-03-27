package com.litbo.hospital.user.dao.provider;


public class CsProvider {

        public String listCsByX(String sbcsName, String s){
        StringBuffer sql = new StringBuffer("select * from eq_cs where 1=1" );
        if(s!=null)  sql.append(" and sb_cslb_id = #{s}");
        if(sbcsName!=null) sql.append(" and sbcs_name like  '%'+#{sbcsName}+'%'");
        return sql.toString();
    }
}

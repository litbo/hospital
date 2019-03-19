package com.litbo.hospital.user.dao.provider;

import com.litbo.hospital.user.bean.EqZjly;
import org.apache.ibatis.jdbc.SQL;

public class DictProvider {

    public String selectZjlyByX(EqZjly eqZjly) {
        return new SQL(){{
            SELECT("zjly_id,zjly_name");
            FROM("eq_zjly");
            if(eqZjly.getZjlyId()!= null){
                WHERE("zjly_Id = #{zjlyId}");
            }
            if(eqZjly.getZjlyName()!=null){
                WHERE("zjly_Name = #{zjlyName}");
            }
        }}.toString();
    }
    public String listDictByTName(String tName) {
        StringBuffer sql =new StringBuffer();
        if("s_jg".equals(tName))sql.append("SELECT jg_id as dictId ,jg as dictName FROM s_jg");
        if("s_mz".equals(tName))sql.append("SELECT mz_id as dictId , mz as dictName FROM s_mz");
        if("s_xllb".equals(tName))sql.append("SELECT xllb_id as dictId , xllb as dictName FROM s_xllb");
        if("s_sex".equals(tName))sql.append("SELECT sex_id as dictId , sex as dictName FROM s_sex");
        if("s_gb".equals(tName))sql.append("SELECT gb_id as dictId , gb as dictName FROM s_gb");
        if("s_zwlb".equals(tName))sql.append("SELECT zwlb_id as dictId , zwlb as dictName FROM s_zwlb");
        if("s_zzmm".equals(tName))sql.append("SELECT zzmm_id as dictId , zzmm as dictName FROM s_zzmm");

        return sql.toString();
    }
}

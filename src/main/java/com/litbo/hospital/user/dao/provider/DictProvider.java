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
        if("eq_cslb".equals(tName))sql.append("SELECT eq_cslb_id as dictId ,eq_cslb_name as dictName FROM eq_cslb");
        if("eq_cxfl".equals(tName))sql.append("SELECT eq_cxfl_id as dictId ,eq_cxfl_name as dictName FROM eq_cxfl");
        if("eq_gzlb".equals(tName))sql.append("SELECT gzlb_id as dictId ,gzlb_name as dictName FROM eq_gzlb");
        if("eq_jldw".equals(tName))sql.append("SELECT eq_jldw_id as dictId ,eq_jldw_name as dictName FROM eq_jldw");
        if("eq_qdfs".equals(tName))sql.append("SELECT qdfs_id as dictId ,qdfs_name as dictName FROM eq_qdfs");
        if("eq_zjly".equals(tName))sql.append("SELECT zjly_id as dictId ,zjly_name as dictName FROM eq_zjly");
        if("eq_syxz".equals(tName))sql.append("SELECT syxz_id as dictId ,syxz_name as dictName FROM eq_syxz");
        return sql.toString();
    }
    public String addDictByTName(String tName,String dictName, String sdictId,Integer dictId) {
        StringBuffer sql =new StringBuffer();
        if("s_jg".equals(tName))sql.append("insert into s_jg(jg,jg_id) values(#{dictName} ,#{sdictId})");
        if("s_mz".equals(tName))sql.append("insert into s_mz(mz,mz_id) values(#{dictName} ,#{dictId})");
        if("s_xllb".equals(tName))sql.append("insert into s_xllb(xllb,xllb_id) values(#{dictName} ,#{sdictId})");
        if("s_sex".equals(tName))sql.append("insert into s_sex(sex,sex_id) values(#{dictName} ,#{sdictId})");
        if("s_gb".equals(tName))sql.append("insert into s_gb(gb,gb_id) values(#{dictName} ,#{sdictId})");
        if("s_zwlb".equals(tName))sql.append("insert into s_zwlb(zwlb,zwlb_id) values(#{dictName} ,#{sdictId})");
        if("s_zzmm".equals(tName))sql.append("insert into s_zzmm(zzmm,zzmm_id) values(#{dictName} ,#{sdictId})");
        if("eq_cslb".equals(tName))sql.append("insert into eq_cslb(eq_cslb_name,eq_cslb_id) values(#{dictName} ,#{sdictId})");
        if("eq_cxfl".equals(tName))sql.append("insert into eq_cxfl(eq_cxfl_name,eq_cxfl_id) values(#{dictName} ,#{sdictId})");
        if("eq_gzlb".equals(tName))sql.append("insert into eq_gzlb(gzlb_name,gzlb_id) values(#{dictName} ,#{dictId})");
        if("eq_jldw".equals(tName))sql.append("insert into eq_jldw(eq_jldw_name,eq_jldw_id) values(#{dictName} ,#{sdictId})");
        if("eq_qdfs".equals(tName))sql.append("insert into eq_qdfs(qdfs_name,qdfs_id) values(#{dictName} ,#{dictId})");
        if("eq_zjly".equals(tName))sql.append("insert into eq_zjly(zjly_name,zjly_id) values(#{dictName} ,#{dictId})");
        if("eq_syxz".equals(tName))sql.append("insert into eq_syxz(syxz_name,syxz_id) values(#{dictName} ,#{dictId})");

        return sql.toString();
    }


    public String getLastIdByTName(String tName) {
        StringBuffer sql =new StringBuffer();
        if("s_jg".equals(tName))sql.append("select top 1 jg_id  as sId FROM s_jg  ORDER BY abs( jg_id ) desc");
        if("s_mz".equals(tName))sql.append("select top 1 mz_id as id FROM s_mz  ORDER BY abs( mz_id ) desc");
        if("s_xllb".equals(tName))sql.append("select top 1 xllb_id as sId FROM s_xllb  ORDER BY abs( xllb_id ) desc");
        if("s_sex".equals(tName))sql.append("select top 1 sex_id as sId FROM s_sex  ORDER BY abs( sex_id ) desc");
        if("s_gb".equals(tName))sql.append("select top 1 gb_id  as sId FROM s_gb  ORDER BY abs( gb_id ) desc");
        if("s_zwlb".equals(tName))sql.append("select top 1 zwlb_id as sId FROM s_zwlb  ORDER BY abs( zwlb_id ) desc");
        if("s_zzmm".equals(tName))sql.append("select top 1 zzmm_id as sId FROM s_zzmm  ORDER BY abs( zzmm_id ) desc");
        if("eq_cslb".equals(tName))sql.append("select top 1 eq_cslb_id as sId FROM eq_cslb  ORDER BY abs( eq_cslb_id ) desc");
        if("eq_cxfl".equals(tName))sql.append("select top 1 eq_cxfl_id as sId FROM eq_cxfl  ORDER BY abs( eq_cxfl_id ) desc");
        if("eq_gzlb".equals(tName))sql.append("select top 1 gzlb_id  as id FROM eq_gzlb  ORDER BY abs( gzlb_id ) desc");
        if("eq_jldw".equals(tName))sql.append("select top 1 eq_jldw_id as sId FROM eq_jldw  ORDER BY abs( eq_jldw_id ) desc");
        if("eq_qdfs".equals(tName))sql.append("select top 1 qdfs_id  as id FROM eq_qdfs  ORDER BY abs( qdfs_id ) desc");
        if("eq_zjly".equals(tName))sql.append("select top 1 zjly_id as id FROM eq_zjly  ORDER BY abs( zjly_id ) desc");
        if("eq_syxz".equals(tName))sql.append("select top 1 syxz_id as id  FROM eq_syxz  ORDER BY abs( syxz_id ) desc");

        return sql.toString();
    }
}

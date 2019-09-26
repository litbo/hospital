package com.litbo.hospital.user.dao.provider;

import com.litbo.hospital.user.bean.EqZjly;
import com.litbo.hospital.user.vo.DictVo;
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
        if("s_jg".equals(tName))sql.append("SELECT jg_id as dictId ,jg as dictName ,b_name as bName FROM s_jg");
        if("s_mz".equals(tName))sql.append("SELECT mz_id as dictId , mz as dictName ,b_name as bName FROM s_mz");
        if("s_xllb".equals(tName))sql.append("SELECT xllb_id as dictId , xllb as dictName ,b_name as bName FROM s_xllb");
        if("s_sex".equals(tName))sql.append("SELECT sex_id as dictId , sex as dictName ,b_name as bName FROM s_sex");
        if("s_gb".equals(tName))sql.append("SELECT gb_id as dictId , gb as dictName ,b_name as bName FROM s_gb");
        if("s_zwlb".equals(tName))sql.append("SELECT zwlb_id as dictId , zwlb as dictName ,b_name as bName FROM s_zwlb");
        if("s_zzmm".equals(tName))sql.append("SELECT zzmm_id as dictId , zzmm as dictName ,b_name as bName FROM s_zzmm");
        if("eq_cslb".equals(tName))sql.append("SELECT eq_cslb_id as dictId ,eq_cslb_name as dictName ,b_name as bName FROM eq_cslb");
        if("eq_cxfl".equals(tName))sql.append("SELECT eq_cxfl_id as dictId ,eq_cxfl_name as dictName ,b_name as bName FROM eq_cxfl");
        if("eq_gzlb".equals(tName))sql.append("SELECT gzlb_id as dictId ,gzlb_name as dictName ,b_name as bName FROM eq_gzlb");
        if("eq_jldw".equals(tName))sql.append("SELECT eq_jldw_id as dictId ,eq_jldw_name as dictName ,b_name as bName FROM eq_jldw");
        if("eq_qdfs".equals(tName))sql.append("SELECT qdfs_id as dictId ,qdfs_name as dictName ,b_name as bName FROM eq_qdfs");
        if("eq_zjly".equals(tName))sql.append("SELECT zjly_id as dictId ,zjly_name as dictName ,b_name as bName FROM eq_zjly");
        if("eq_syxz".equals(tName))sql.append("SELECT syxz_id as dictId ,syxz_name as dictName ,b_name as bName FROM eq_syxz");
        return sql.toString();
    }
    public String addDictByTName(String tName,String dictName, String sdictId,Integer dictId) {
        StringBuffer sql =new StringBuffer();
        if("s_jg".equals(tName))sql.append("insert into s_jg(jg,jg_id,b_name) values(#{dictName} ,#{sdictId},#{tName})");
        if("s_mz".equals(tName))sql.append("insert into s_mz(mz,mz_id,b_name) values(#{dictName} ,#{dictId},#{tName})");
        if("s_xllb".equals(tName))sql.append("insert into s_xllb(xllb,xllb_id,b_name) values(#{dictName} ,#{sdictId},#{tName})");
        if("s_sex".equals(tName))sql.append("insert into s_sex(sex,sex_id,b_name) values(#{dictName} ,#{sdictId},#{tName})");
        if("s_gb".equals(tName))sql.append("insert into s_gb(gb,gb_id,b_name) values(#{dictName} ,#{sdictId},#{tName})");
        if("s_zwlb".equals(tName))sql.append("insert into s_zwlb(zwlb,zwlb_id,b_name) values(#{dictName} ,#{sdictId},#{tName})");
        if("s_zzmm".equals(tName))sql.append("insert into s_zzmm(zzmm,zzmm_id,b_name) values(#{dictName} ,#{sdictId},#{tName})");
        if("eq_cslb".equals(tName))sql.append("insert into eq_cslb(eq_cslb_name,eq_cslb_id,b_name) values(#{dictName} ,#{sdictId},#{tName})");
        if("eq_cxfl".equals(tName))sql.append("insert into eq_cxfl(eq_cxfl_name,eq_cxfl_id,b_name) values(#{dictName} ,#{sdictId},#{tName})");
        if("eq_gzlb".equals(tName))sql.append("insert into eq_gzlb(gzlb_name,gzlb_id,b_name) values(#{dictName} ,#{dictId},#{tName})");
        if("eq_jldw".equals(tName))sql.append("insert into eq_jldw(eq_jldw_name,eq_jldw_id,b_name) values(#{dictName} ,#{sdictId},#{tName})");
        if("eq_qdfs".equals(tName))sql.append("insert into eq_qdfs(qdfs_name,qdfs_id,b_name) values(#{dictName} ,#{dictId},#{tName})");
        if("eq_zjly".equals(tName))sql.append("insert into eq_zjly(zjly_name,zjly_id,b_name) values(#{dictName} ,#{dictId},#{tName})");
        if("eq_syxz".equals(tName))sql.append("insert into eq_syxz(syxz_name,syxz_id,b_name) values(#{dictName} ,#{dictId},#{tName})");

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


    public String delByTNameAndId(DictVo dictVo) {

        SQL sql = null;
        String dictId = dictVo.getDictId();

        switch (dictVo.getBName()) {
            case "s_jg": {
                sql = new SQL() {
                    {
                        DELETE_FROM("s_jg");
                        WHERE("jg_id = #{dictId}");
                    }
                };
            }break;
            case "s_mz": {
                sql =  new SQL() {
                    {
                        DELETE_FROM("s_mz");
                        WHERE("mz_id = #{dictId}");
                    }
                };
            }break;
            case "s_xllb": {
                sql =  new SQL() {
                    {
                        DELETE_FROM("s_xllb");
                        WHERE("xllb_id = #{dictId}");
                    }
                };
            }break;
            case "s_sex": {
                sql =  new SQL() {
                    {
                        DELETE_FROM("s_sex");
                        WHERE("sex_id = #{dictId}");
                    }
                };
            }break;
            case "s_gb": {
                sql =  new SQL() {
                    {
                        DELETE_FROM("s_gb");
                        WHERE("gb_id = #{dictId}");
                    }
                };
            }break;
            case "s_zwlb": {
                sql =  new SQL() {
                    {
                        DELETE_FROM("s_zwlb");
                        WHERE("zwlb_id = #{dictId}");
                    }
                };
            }break;
            case "s_zzmm": {
                sql =  new SQL() {
                    {
                        DELETE_FROM("s_zzmm");
                        WHERE("zzmm_id = #{dictId}");
                    }
                };
            }break;
            case "eq_cslb": {
                sql =  new SQL() {
                    {
                        DELETE_FROM("eq_cslb");
                        WHERE("eq_cslb_id = #{dictId}");
                    }
                };
            }break;
            case "eq_cxfl": {
                sql =  new SQL() {
                    {
                        DELETE_FROM("eq_cxfl");
                        WHERE("eq_cxfl_id = #{dictId}");
                    }
                };
            }break;
            case "eq_gzlb": {
                sql =  new SQL() {
                    {
                        DELETE_FROM("eq_gzlb");
                        WHERE("gzlb_id = #{dictId}");
                    }
                };
            }break;
            case "eq_jldw": {
                sql =  new SQL() {
                    {
                        DELETE_FROM("eq_jldw");
                        WHERE("eq_jldw_id = #{dictId}");
                    }
                };
            }break;
            case "eq_qdfs": {
                sql =  new SQL() {
                    {
                        DELETE_FROM("eq_qdfs");
                        WHERE("qdfs_id = #{dictId}");
                    }
                };
            }break;
            case "eq_zjly": {
                sql =  new SQL() {
                    {
                        DELETE_FROM("eq_zjly");
                        WHERE("zjly_id = #{dictId}");
                    }
                };
            }break;
            case "eq_syxz": {
                sql =  new SQL() {
                    {
                        DELETE_FROM("eq_syxz");
                        WHERE("syxz_id = #{dictId}");
                    }
                };
            }

        }

        System.out.println(sql.toString());
        return sql.toString();

//        StringBuffer sql =new StringBuffer();
//        if("s_jg".equals(dictVo.getBName()))sql.append("Delete FROM s_jg where jg_id = #{dictId}");
//        if("s_mz".equals(dictVo.getBName()))sql.append("Delete FROM s_mz where mz_id = #{dictId} ");
//        if("s_xllb".equals(dictVo.getBName()))sql.append("Delete FROM s_xllb where xllb_id = #{dictId}  ");
//        if("s_sex".equals(dictVo.getBName()))sql.append("Delete FROM s_sex where sex_id = #{dictId}  ");
//        if("s_gb".equals(dictVo.getBName()))sql.append("Delete FROM s_gb where gb_id = #{dictId}  ");
//        if("s_zwlb".equals(dictVo.getBName()))sql.append("Delete FROM s_zwlb where zwlb_id = #{dictId}  ");
//        if("s_zzmm".equals(dictVo.getBName()))sql.append("Delete FROM s_zzmm where zzmm_id = #{dictId}  ");
//        if("eq_cslb".equals(dictVo.getBName()))sql.append("Delete FROM eq_cslb where eq_cslb_id = #{dictId}  ");
//        if("eq_cxfl".equals(dictVo.getBName()))sql.append("Delete FROM eq_cxfl where eq_cxfl_id = #{dictId}  ");
//        if("eq_gzlb".equals(dictVo.getBName()))sql.append("Delete FROM eq_gzlb where gzlb_id = #{dictId}  ");
//        if("eq_jldw".equals(dictVo.getBName()))sql.append("Delete FROM eq_jldw where eq_jldw_id = #{dictId} ");
//        if("eq_qdfs".equals(dictVo.getBName()))sql.append("Delete FROM eq_qdfs where qdfs_id = #{dictId} ");
//        if("eq_zjly".equals(dictVo.getBName()))sql.append("Delete FROM eq_zjly where zjly_id = #{dictId} ");
//        if("eq_syxz".equals(dictVo.getBName()))sql.append("Delete FROM eq_syxz where syxz_id = #{dictId} ");
//        System.out.println("sql:"+sql);
//        return sql.toString();
    }


    public String getByTNameAndId(String tName,String id) {
        StringBuffer sql =new StringBuffer();
        if("s_jg".equals(tName))sql.append("SELECT jg_id as dictId ,jg as dictName ,b_name as bName FROM s_jg where jg_id =#{id}");
        if("s_mz".equals(tName))sql.append("SELECT mz_id as dictId , mz as dictName ,b_name as bName FROM s_mz where mz_id =#{id}");
        if("s_xllb".equals(tName))sql.append("SELECT xllb_id as dictId , xllb as dictName ,b_name as bName FROM s_xllb where xllb_id =#{id}");
        if("s_sex".equals(tName))sql.append("SELECT sex_id as dictId , sex as dictName ,b_name as bName FROM s_sex where sex_id =#{id}");
        if("s_gb".equals(tName))sql.append("SELECT gb_id as dictId , gb as dictName ,b_name as bName FROM s_gb where gb_id =#{id}");
        if("s_zwlb".equals(tName))sql.append("SELECT zwlb_id as dictId , zwlb as dictName ,b_name as bName FROM s_zwlb where zwlb_id =#{id}");
        if("s_zzmm".equals(tName))sql.append("SELECT zzmm_id as dictId , zzmm as dictName ,b_name as bName FROM s_zzmm where zzmm_id =#{id}");
        if("eq_cslb".equals(tName))sql.append("SELECT eq_cslb_id as dictId ,eq_cslb_name as dictName ,b_name as bName FROM eq_cslb where eq_cslb_id =#{id}");
        if("eq_cxfl".equals(tName))sql.append("SELECT eq_cxfl_id as dictId ,eq_cxfl_name as dictName ,b_name as bName FROM eq_cxfl where eq_cxfl_id =#{id}");
        if("eq_gzlb".equals(tName))sql.append("SELECT gzlb_id as dictId ,gzlb_name as dictName ,b_name as bName FROM eq_gzlb where gzlb_id =#{id}");
        if("eq_jldw".equals(tName))sql.append("SELECT eq_jldw_id as dictId ,eq_jldw_name as dictName ,b_name as bName FROM eq_jldw where eq_jldw_id =#{id}");
        if("eq_qdfs".equals(tName))sql.append("SELECT qdfs_id as dictId ,qdfs_name as dictName ,b_name as bName FROM eq_qdfs where qdfs_id =#{id}");
        if("eq_zjly".equals(tName))sql.append("SELECT zjly_id as dictId ,zjly_name as dictName ,b_name as bName FROM eq_zjly where zjly_id =#{id}");
        if("eq_syxz".equals(tName))sql.append("SELECT syxz_id as dictId ,syxz_name as dictName ,b_name as bName FROM eq_syxz where syxz_id =#{id}");
        return sql.toString();
    }
}

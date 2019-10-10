package com.litbo.hospital.user.dao.provider;

import com.litbo.hospital.user.bean.SysGg;

public class GgProvider {

    public String addGg(SysGg gg){
        String sql = " insert into sys_gg ( gglx_id, bm_id, \n" +
                "      kssj, jssj, ngr, ngsj, \n" +
                "      status, ggbt, ggnr\n" +
                "      )\n" +
                "    values (#{gglxId,jdbcType=INTEGER}, #{bmId,jdbcType=CHAR}, \n" +
                "      #{kssj,jdbcType=DATE}, #{jssj,jdbcType=DATE}, #{ngr,jdbcType=VARCHAR}, #{ngsj,jdbcType=DATE}, \n" +
                "      #{status,jdbcType=INTEGER}, #{ggbt,jdbcType=LONGVARCHAR}, #{ggnr,jdbcType=LONGVARCHAR}\n" +
                "      )";
        return sql;
    }

    public String listShowGgs(){
        String sql ="SELECT\n" +
                "g.id,\n" +
                "g.kssj,\n" +
                "g.jssj,\n" +
                "g.ggbt,\n" +
                "g.ngr,\n" +
                "g.ngsj,\n" +
                "g.ggnr,\n" +
                "g.status,\n" +
                "x.gglx_name,\n" +
                "b.bm_name\n" +
                "FROM\n" +
                "dbo.sys_gg AS g\n" +
                "LEFT JOIN dbo.sys_gglx AS x ON g.gglx_id= x.gglx_id\n" +
                "LEFT JOIN dbo.s_bm AS b ON g.bm_id= b.bm_id";
        return  sql;
    }
    public String listGgDesc(){
        String sql ="SELECT\n" +
                "g.id,\n" +
                "g.kssj,\n" +
                "g.jssj,\n" +
                "g.ggbt,\n" +
                "g.ngr,\n" +
                "g.ngsj,\n" +
                "g.ggnr,\n" +
                "g.status,\n" +
                "x.gglx_name,\n" +
                "b.bm_name\n" +
                "FROM\n" +
                "dbo.sys_gg AS g\n" +
                "LEFT JOIN dbo.sys_gglx AS x ON g.gglx_id= x.gglx_id\n" +
                "LEFT JOIN dbo.s_bm AS b ON g.bm_id= b.bm_id " +
                " order by g.ngsj desc";
        return  sql;
    }

    public String listWaits(){
        String sql ="SELECT\n" +
                "g.id,\n" +
                "g.kssj,\n" +
                "g.jssj,\n" +
                "g.ggbt,\n" +
                "g.ngr,\n" +
                "g.ngsj,\n" +
                "g.ggnr,\n" +
                "g.status,\n" +
                "x.gglx_name,\n" +
                "b.bm_name\n" +
                "FROM\n" +
                "dbo.sys_gg AS g\n" +
                "LEFT JOIN dbo.sys_gglx AS x ON g.gglx_id= x.gglx_id\n" +
                "LEFT JOIN dbo.s_bm AS b ON g.bm_id= b.bm_id" +
                " where status = 0";
        return  sql;
    }

    public String getGgById(Integer id){
        String sql ="SELECT\n" +
                "g.id,\n" +
                "g.kssj,\n" +
                "g.jssj,\n" +
                "g.ggbt,\n" +
                "g.ngr,\n" +
                "g.ngsj,\n" +
                "g.ggnr,\n" +
                "g.status,\n" +
                "x.gglx_name,\n" +
                "b.bm_name\n" +
                "FROM\n" +
                "dbo.sys_gg AS g\n" +
                "LEFT JOIN dbo.sys_gglx AS x ON g.gglx_id= x.gglx_id\n" +
                "LEFT JOIN dbo.s_bm AS b ON g.bm_id= b.bm_id " +
                "where g.id = #{id}";
        return  sql;
    }
}

package com.litbo.hospital.beneficial.dao.provider;

import com.litbo.hospital.beneficial.bean.BSbcwBean;

public class GxsrProvider {

    public String insertSr(BSbcwBean bSbcwBean){

        String SQL="insert into b_sbcw(a_id,eq_id,ks_id,km_sj,km_num,km_name,km_value,km_cjdm,bm_name,eq_name,qjlc)\n" +
                "values (#{aId,jdbcType=INTEGER}," +
                "#{eqId,jdbcType=INTEGER}," +
                "#{ksId,jdbcType=INTEGER}," +
                "#{kmSj,jdbcType=Date}," +
                "#{kmNum,jdbcType=VARCHAR}," +
                "#{kmName,jdbcType=VARCHAR}," +
                "#{kmValue,jdbcType=DECIMAL})"+
                "#{kmCjdm,jdbcType=VARCHAR}," +
                "#{bmName,jdbcType=VARCHAR}," +
                "#{eqName,jdbcType=VARCHAR}," +
                "#{qjlc,jdbcType=INTEGER}";

        return  SQL;
    }

    public String showSbSr(Integer aId){

        String SQL="SELECT "+
                "dbo.b_sbcw.bm_name AS bmName, "+
                "dbo.b_sbcw.eq_name AS eqName, "+
                "dbo.b_sbcw.km_sj AS kmSj, " +
                "dbo.b_sbcw.qjlc AS qjlc, "+
                "dbo.b_sbcw.km_name AS kmName, "+
                "dbo.b_sbcw.km_value AS kmValue "+

        "FROM "+
        "dbo.b_sbcw "+
        "WHERE "+
        "dbo.b_sbcw.a_id= #{aId}";

        return  SQL;
    }

}

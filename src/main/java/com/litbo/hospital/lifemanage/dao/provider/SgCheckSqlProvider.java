package com.litbo.hospital.lifemanage.dao.provider;

import com.litbo.hospital.lifemanage.bean.SgCheck;
import org.apache.ibatis.jdbc.SQL;

public class SgCheckSqlProvider {

    /**
     *
     * @mbg.generated 2018-12-29
     */
    public String insertSelective(SgCheck record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("sg_check");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=VARCHAR}");
        }
        
        if (record.getEqId() != null) {
            sql.VALUES("eq_id", "#{eqId,jdbcType=VARCHAR}");
        }
        
        if (record.getDate() != null) {
            sql.VALUES("date", "#{date,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUserId() != null) {
            sql.VALUES("user_id", "#{userId,jdbcType=VARCHAR}");
        }
        
        if (record.getChecks() != null) {
            sql.VALUES("checks", "#{checks,jdbcType=CHAR}");
        }

        if (record.getPlanId() != null) {
            sql.VALUES("plan_id", "#{planId,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    /**
     *
     * @mbg.generated 2018-12-29
     */
    public String updateByPrimaryKeySelective(SgCheck record) {
        SQL sql = new SQL();
        sql.UPDATE("sg_check");
        
        if (record.getEqId() != null) {
            sql.SET("eq_id = #{eqId,jdbcType=VARCHAR}");
        }
        
        if (record.getDate() != null) {
            sql.SET("date = #{date,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUserId() != null) {
            sql.SET("user_id = #{userId,jdbcType=VARCHAR}");
        }
        
        if (record.getChecks() != null) {
            sql.SET("checks = #{checks,jdbcType=CHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=VARCHAR}");
        
        return sql.toString();
    }
}
package com.litbo.hospital.lifemanage.dao.provider;

import com.litbo.hospital.lifemanage.bean.SgPlan;
import org.apache.ibatis.jdbc.SQL;

public class SgPlanSqlProvider {

    /**
     *
     * @mbg.generated 2018-12-29
     */
    public String insertSelective(SgPlan record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("sg_plan");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=VARCHAR}");
        }
        
        if (record.getUserId() != null) {
            sql.VALUES("user_id", "#{userId,jdbcType=VARCHAR}");
        }
        
        if (record.getBmId() != null) {
            sql.VALUES("bm_id", "#{bmId,jdbcType=VARCHAR}");
        }
        
        if (record.getPlanName() != null) {
            sql.VALUES("plan_name", "#{planName,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    /**
     *
     * @mbg.generated 2018-12-29
     */
    public String updateByPrimaryKeySelective(SgPlan record) {
        SQL sql = new SQL();
        sql.UPDATE("sg_plan");
        
        if (record.getUserId() != null) {
            sql.SET("user_id = #{userId,jdbcType=VARCHAR}");
        }
        
        if (record.getBmId() != null) {
            sql.SET("bm_id = #{bmId,jdbcType=VARCHAR}");
        }
        
        if (record.getPlanName() != null) {
            sql.SET("plan_name = #{planName,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=VARCHAR}");
        
        return sql.toString();
    }
}
package com.litbo.hospital.lifemanage.dao.provider;

import com.litbo.hospital.lifemanage.bean.SgCheck;
import com.litbo.hospital.lifemanage.enums.StateEnum;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

public class SgCheckSqlProvider {

    /**
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

    public String getListByX(String check, String checkDate, String checkUser, String planDate, String planUser) {
        return new SQL() {{
            SELECT("dbo.sg_check.id,\n" +
                    "dbo.eq_info.eq_sbbh,\n" +
                    "dbo.eq_info.eq_name,\n" +
                    "dbo.eq_info.eq_gg,\n" +
                    "dbo.eq_info.eq_xh,\n" +
                    "dbo.sg_plan.user_id AS planUser,\n" +
                    "dbo.s_bm.bm_name,\n" +
                    "dbo.sg_plan.plan_date AS planDate,\n" +
                    "dbo.sg_check.[date],\n" +
                    "dbo.sg_check.user_id AS checkUser,\n" +
                    "dbo.sg_check.checks\n");
            FROM("dbo.sg_check\n" +
                    "INNER JOIN dbo.eq_info ON dbo.sg_check.eq_id = dbo.eq_info.eq_id\n" +
                    "INNER JOIN dbo.sg_plan ON dbo.sg_check.plan_id = dbo.sg_plan.id\n" +
                    "INNER JOIN dbo.s_bm ON dbo.sg_plan.bm_id = dbo.s_bm.bm_id");
            if (StringUtils.isNotBlank(check)){
                if (StateEnum.CHECK_Y_OR_N.getMessage().equals(check)){
                    WHERE("dbo.sg_check.checks IS NULL");
                }else{
                    WHERE("dbo.sg_check.checks = #{check,jdbcType=VARCHAR}");
                }
            }
            if (StringUtils.isNotBlank(checkDate)){
                WHERE(" YEAR(dbo.sg_check.[date]) = YEAR(#{checkDate,jdbcType=VARCHAR}) AND MONTH(dbo.sg_check.[date]) = MONTH(#{checkDate,jdbcType=VARCHAR}) AND DAY(dbo.sg_check.[date]) = DAY(#{checkDate,jdbcType=VARCHAR})");
            }
            if (StringUtils.isNotBlank(checkUser)){
                WHERE(" dbo.sg_check.user_id = #{checkUser,jdbcType=VARCHAR}");
            }
            if (StringUtils.isNotBlank(planDate)){
                WHERE(" YEAR(dbo.sg_plan.plan_date) = YEAR(#{planDate,jdbcType=VARCHAR}) AND MONTH(dbo.sg_plan.plan_date) = MONTH(#{planDate,jdbcType=VARCHAR}) AND DAY(dbo.sg_plan.plan_date) = DAY(#{planDate,jdbcType=VARCHAR})");
            }
            if (StringUtils.isNotBlank(planUser)){
                WHERE(" dbo.sg_plan.user_id = #{planUser,jdbcType=VARCHAR}");
            }
            WHERE("dbo.sg_check.user_id IS NOT NULL");

        }}.toString();
    }
}
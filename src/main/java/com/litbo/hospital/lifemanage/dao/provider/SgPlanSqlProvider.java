package com.litbo.hospital.lifemanage.dao.provider;

import com.litbo.hospital.lifemanage.bean.SgPlan;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class SgPlanSqlProvider {

    /**
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

    /**
     * 查询计划列表
     *
     * @param planName 计划名称
     * @param planDate 制定时间
     * @param userId   制定人
     * @return sql
     */
//    @Autowired
    public String selectPlan(@Param("planName") String planName, @Param("planDate") Date planDate, @Param("userId") List<String> userId) {
        SQL sql = new SQL();
        sql.SELECT("sg_plan.id,sg_plan.bm_id as bmId, s_emp.user_xm as userId, s_bm.bm_name as bmName, sg_plan.plan_name,sg_plan.plan_date");
        sql.FROM("sg_plan");
        sql.INNER_JOIN("s_bm ON sg_plan.bm_id = s_bm.bm_id INNER JOIN s_emp ON sg_plan.user_id = s_emp.user_id ");
        if (StringUtils.isNotBlank(planName)) {
            sql.WHERE("dbo.sg_plan.plan_name like #{planName,jdbcType=VARCHAR}");
        }
        if (planDate != null) {
            sql.WHERE("YEAR(dbo.sg_plan.plan_date) = YEAR(#{planDate,jdbcType=TIMESTAMP}) AND MONTH(dbo.sg_plan.plan_date) = MONTH(#{planDate,jdbcType=TIMESTAMP}) AND DAY(dbo.sg_plan.plan_date) = DAY(#{planDate,jdbcType=TIMESTAMP})");
        }
        if (userId != null && userId.size() > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < userId.size(); i++) {
                sb.append("'").append(userId.get(i)).append("'");
                if (userId.size() != (i + 1)) {
                    sb.append(",");
                }
            }
            sql.WHERE("dbo.sg_plan.user_id IN (" + sb.toString() + ")");
        }
        sql.ORDER_BY("sg_plan.plan_date DESC");
        return sql.toString();
    }
}
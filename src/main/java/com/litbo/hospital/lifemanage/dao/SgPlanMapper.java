package com.litbo.hospital.lifemanage.dao;

import com.litbo.hospital.lifemanage.bean.SgPlan;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.Date;
import java.util.List;

@Mapper
public interface SgPlanMapper {

    /**
     * 计划制定
     *
     * @param record 计划内容
     * @return 添加记录数
     */
    @Insert({
            "insert into sg_plan (id, user_id, ",
            "bm_id, plan_name, plan_date)",
            "values (#{id,jdbcType=VARCHAR}, #{userId,jdbcType=VARCHAR}, ",
            "#{bmId,jdbcType=VARCHAR}, #{planName,jdbcType=VARCHAR}, #{planDate,jdbcType=TIMESTAMP})"
    })
    int insert(SgPlan record);

    /**
     * 查询
     *
     * @param id 主键
     * @return 查询信息
     */
    @Select({
            "select",
            "id, user_id, bm_id, plan_name",
            "from sg_plan",
            "where id = #{id,jdbcType=VARCHAR}"
    })
    @ConstructorArgs({
            @Arg(column = "id", javaType = String.class, jdbcType = JdbcType.VARCHAR, id = true),
            @Arg(column = "user_id", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "bm_id", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "plan_name", javaType = String.class, jdbcType = JdbcType.VARCHAR)
    })
    SgPlan selectByPrimaryKey(String id);

    /**
     * 查询计划列表
     *
     * @param planName 计划名称
     * @param planDate 制定时间
     * @param userId   制定人
     * @return List<SgPlan>
     */
    @Select("<script>" +
            "select sg_plan.id, s_emp.user_xm as userId, s_bm.bm_name as bmId, sg_plan.plan_name,sg_plan.plan_date \n" +
            "from sg_plan\n" +
            "INNER JOIN s_bm ON sg_plan.bm_id = s_bm.bm_id \n" +
            "INNER JOIN s_emp ON sg_plan.user_id = s_emp.user_id \n" +
            "<where>" +
            "<if test=\"planName != null\"> dbo.sg_plan.plan_name = #{planName,jdbcType=VARCHAR} </if>" +
            "<if test=\"planDate != null\"> AND YEAR(dbo.sg_plan.plan_date) = YEAR(#{planDate,jdbcType=TIMESTAMP}) AND MONTH(dbo.sg_plan.plan_date) = MONTH(#{planDate,jdbcType=TIMESTAMP}) AND DAY(dbo.sg_plan.plan_date) = DAY(#{planDate,jdbcType=TIMESTAMP}) </if>" +
            "<if test=\"userId != null\"> AND dbo.sg_plan.user_id = #{userId,jdbcType=VARCHAR} </if>" +
            "</where>" +
            " order by dbo.sg_plan.plan_date desc" +
            "</script>")
    List<SgPlan> selectPlan(@Param("planName") String planName, @Param("planDate") Date planDate, @Param("userId") String userId);

    /**
     * 根据部门id查询设备id
     * @param bmId 部门id
     * @return 设备id列表
     */
    @Select("SELECT\n" +
            "dbo.eq_info.eq_id\n" +
            "FROM\n" +
            "dbo.eq_info\n" +
            "WHERE\n" +
            "dbo.eq_info.eq_bmid = #{bmId,jdbcType=VARCHAR}")
    List<String> getEqIdByBmId(String bmId);
}
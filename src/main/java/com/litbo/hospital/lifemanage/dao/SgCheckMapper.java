package com.litbo.hospital.lifemanage.dao;

import com.litbo.hospital.lifemanage.bean.SgCheck;
import com.litbo.hospital.lifemanage.bean.vo.SgCheckListVO;
import com.litbo.hospital.lifemanage.bean.vo.SgCheckVO;
import com.litbo.hospital.lifemanage.dao.provider.SgCheckSqlProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.Date;
import java.util.List;

/**
 * 账实核对Mapper
 */
@Mapper
public interface SgCheckMapper {

    /**
     * 添加内容不为空的核对信息
     *
     * @param record 核对信息
     * @return 添加记录数
     */
    @InsertProvider(type = SgCheckSqlProvider.class, method = "insertSelective")
    int insertSelective(SgCheck record);

    /**
     * 通过主键查询核对信息
     *
     * @param id 主键
     * @return 核对信息
     */
    @Select({
            "select",
            "id, eq_id, date, user_id, checks",
            "from sg_check",
            "where id = #{id,jdbcType=VARCHAR}"
    })
    @ConstructorArgs({
            @Arg(column = "id", javaType = String.class, jdbcType = JdbcType.VARCHAR, id = true),
            @Arg(column = "eq_id", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "date", javaType = Date.class, jdbcType = JdbcType.TIMESTAMP),
            @Arg(column = "user_id", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "checks", javaType = String.class, jdbcType = JdbcType.CHAR)
    })
    SgCheck selectByPrimaryKey(String id);

    /**
     * 通过主键更新不为空的核对信息
     *
     * @param record 核对信息
     * @return 更新条数
     */
    @UpdateProvider(type = SgCheckSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SgCheck record);

    /**
     * 计划下的所有待核对的设备列表
     *
     * @param planId 计划id
     * @return List<SgCheck>
     */
    @Select("SELECT\n" +
            "dbo.sg_check.id,\n" +
            "dbo.eq_info.eq_sbbh,\n" +
            "dbo.eq_info.eq_name,\n" +
            "dbo.eq_info.eq_gg,\n" +
            "dbo.eq_info.eq_xh,\n" +
            "dbo.sg_check.[date],\n" +
            "dbo.sg_check.user_id,\n" +
            "dbo.sg_check.checks\n" +
            "FROM\n" +
            "dbo.eq_info\n" +
            "INNER JOIN dbo.sg_check ON dbo.eq_info.eq_id = dbo.sg_check.eq_id\n" +
            "WHERE\n" +
            "dbo.sg_check.plan_id = #{planId,jdbcType=VARCHAR}")
    List<SgCheckVO> getListByPlanId(String planId);

    /**
     * 核对对比
     *
     * @param check     是否存在
     * @param checkDate 审核日期
     * @param checkUser 审核人
     * @param planDate  制定日期
     * @param planUser  制定人
     * @return List<SgCheckListVO>
     */
    @Select("<script>" +
            "SELECT\n" +
            "dbo.sg_check.id,\n" +
            "dbo.eq_info.eq_sbbh,\n" +
            "dbo.eq_info.eq_name,\n" +
            "dbo.eq_info.eq_gg,\n" +
            "dbo.eq_info.eq_xh,\n" +
            "dbo.sg_plan.user_id AS planUser,\n" +
            "dbo.s_bm.bm_name,\n" +
            "dbo.sg_plan.plan_date AS planDate,\n" +
            "dbo.sg_check.[date],\n" +
            "dbo.sg_check.user_id AS checkUser,\n" +
            "dbo.sg_check.checks\n" +
            "FROM\n" +
            "dbo.sg_check\n" +
            "INNER JOIN dbo.eq_info ON dbo.sg_check.eq_id = dbo.eq_info.eq_id\n" +
            "INNER JOIN dbo.sg_plan ON dbo.sg_check.plan_id = dbo.sg_plan.id\n" +
            "INNER JOIN dbo.s_bm ON dbo.sg_plan.bm_id = dbo.s_bm.bm_id" +
            "<where>" +
            "<if test=\"check != null\"> dbo.sg_check.checks = #{check,jdbcType=VARCHAR} </if>" +
            "<if test=\"checkDate != null\"> AND YEAR(dbo.sg_check.[date]) = YEAR(#{checkDate,jdbcType=TIMESTAMP}) AND MONTH(dbo.sg_check.[date]) = MONTH(#{checkDate,jdbcType=TIMESTAMP}) AND DAY(dbo.sg_check.[date]) = DAY(#{checkDate,jdbcType=TIMESTAMP}) </if>" +
            "<if test=\"checkUser != null\"> AND dbo.sg_check.user_id = #{checkUser,jdbcType=VARCHAR} </if>" +
            "<if test=\"planDate != null\">  AND YEAR(dbo.sg_plan.plan_date) = YEAR(#{planDate,jdbcType=TIMESTAMP}) AND MONTH(dbo.sg_plan.plan_date) = MONTH(#{planDate,jdbcType=TIMESTAMP}) AND DAY(dbo.sg_plan.plan_date) = DAY(#{planDate,jdbcType=TIMESTAMP}) </if>" +
            "<if test=\"planUser != null\"> AND dbo.sg_plan.user_id = #{planUser,jdbcType=VARCHAR} </if>" +
            "</where>" +
            "</script>")
    List<SgCheckListVO> getListByX(@Param("check") String check,@Param("checkDate") Date checkDate,@Param("checkUser") String checkUser,@Param("planDate") Date planDate,@Param("planUser") String planUser);
}
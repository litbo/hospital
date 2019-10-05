package com.litbo.hospital.lifemanage.dao;

import com.litbo.hospital.lifemanage.bean.SgPlan;
import com.litbo.hospital.lifemanage.dao.provider.SgPlanSqlProvider;
import org.apache.ibatis.annotations.*;

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
//    @ConstructorArgs({
//            @Arg(column = "id", javaType = String.class, jdbcType = JdbcType.VARCHAR, id = true),
//            @Arg(column = "user_id", javaType = String.class, jdbcType = JdbcType.VARCHAR),
//            @Arg(column = "bm_id", javaType = String.class, jdbcType = JdbcType.VARCHAR),
//            @Arg(column = "plan_name", javaType = String.class, jdbcType = JdbcType.VARCHAR)
//    })
    SgPlan selectByPrimaryKey(String id);

    /**
     * 查询计划列表
     *
     * @param planName 计划名称
     * @param planDate 制定时间
     * @param userId   制定人
     * @return List<SgPlan>
     */
    @SelectProvider(type = SgPlanSqlProvider.class, method = "selectPlan")
    List<SgPlan> selectPlan(@Param("planName") String planName, @Param("planDate") Date planDate, @Param("userId") List<String> userId);


    /**
     * 根据科室id查询设备id
     * @param bmId 科室id
     * @return 设备id列表
     */
    @Select("SELECT\n" +
            "dbo.eq_info.eq_id\n" +
            "FROM\n" +
            "dbo.eq_info\n" +
            "WHERE\n" +
            "dbo.eq_info.eq_bmid = #{bmId,jdbcType=VARCHAR} AND dbo.eq_info.eq_sbbh IS NOT NULL")
    List<String> getEqIdByBmId(String bmId);

    /**
     * 查询所有的计划名字
     * @return
     */
    @Select("select plan_name from sg_plan")
    List<String> getplanName();

    /**
     * 根据计划名称查询计划id
     * @return
     */
    @Select("select id from sg_plan where plan_name = #{planName,jdbcType=VARCHAR}")
    String selectIdByName(String planName);

}
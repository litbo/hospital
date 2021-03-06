package com.litbo.hospital.security.inspectionplan.dao;

import com.litbo.hospital.security.inspectionplan.bean.InspEqPlan;
import com.litbo.hospital.security.inspectionplan.bean.vo.InspEqPlanChange;
import com.litbo.hospital.security.inspectionplan.bean.vo.InspEquipmentVo;
import com.litbo.hospital.security.inspectionplan.bean.vo.InspPlanSelectVo;
import com.litbo.hospital.security.inspectionplan.bean.vo.InspPlanSelectVo1;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 巡检计划管理 【 增、删、改、查】Dao
 *
 * @author 10366 2019-08-09 10:48
 **/
@Mapper
public interface InspectionManageDao {



    @Select("SELECT TOP 1 insp_pl_sprare3\n" +
            "FROM z_inspection_eq_plan\n" +
            "WHERE insp_pl_id = #{inspPlId}")
    String selectInspPlSpare3(String inspPlId);
    @Select("SELECT TOP 1 insp_pl_planner\n\n" +
            "FROM z_inspection_eq_plan\n" +
            "WHERE insp_pl_id = #{inspPlId}")
    String selectInspPlPlanner(String inspPlId);
    @Select("SELECT s.user_xm\n" +
            "FROM s_emp as s\n" +
            "WHERE s.user_id = #{userId}")
    String selectUserNameById(@Param("userId")String userId);

    /**
     * 功能描述: 巡检计划制定完成后清除选定的设备项
     *
     * @Param:
     * @Return: int
     * @Author: ZYJ
     * @Date: 2019/8/5 0005 14:15
     */
    @Update("UPDATE eq_info\n" +
            "SET eq_pl_selection = '0'\n" +
            "WHERE eq_pl_selection = '1'")
    int updateSelectionToZero();

    /**
     * 功能描述: 查询设备Vo根据ID
     *
     * @Param: eqSbbh
     * @Return: List<InspEquipmentVo>
     * @Author: ZYJ
     * @Date: 2019/8/21 0021 18:18
     */
    @Select("SELECT eq.eq_sbbh, eq.eq_name, eq.eq_xh, b.bm_name \n" +
            "FROM eq_info AS eq, s_bm AS b \n" +
            "WHERE eq.eq_bmid = b.bm_id \n" +
            "and eq.eq_sbbh = #{eqSbbh}")
    InspEquipmentVo selectEqVoById(@Param("eqSbbh")String eqSbbh);
    /**
     * 功能描述: 查询巡检计划标准的名字
     *
     * @Param: inspPlStandardId
     * @Return:  String
     * @Author: ZYJ
     * @Date: 2019/8/19 0019 8:25
     */
    @Select("SELECT z.insp_pl_standard_name\n" +
            "FROM z_insp_pl_standard as z\n" +
            "WHERE z.insp_pl_standard_id = #{inspPlStandardId}")
    String selectStandardNameById(@Param("inspPlStandardId")String inspPlStandardId);
    /**
     * 功能描述: 查询巡检计划标准的描述
     *
     * @Param: inspPlStandardId
     * @Return:  String
     * @Author: ZYJ
     * @Date: 2019/8/19 0019 8:25
     */
    @Select("SELECT z.insp_pl_standard_description\n" +
            "FROM z_insp_pl_standard as z\n" +
            "WHERE z.insp_pl_standard_id = #{inspPlStandardId}")
    String selectStandardDescriptionById(@Param("inspPlStandardId")String inspPlStandardId);
    /**
     * 功能描述: 更改选定状态根据设备编号
     *
     * @Param: eqSbbh
     * @Return: void
     * @Author: ZYJ
     * @Date: 2019/8/21 0021 0:22
     */
    @Update("UPDATE eq_info\n" +
            "SET eq_pl_selection = '1'\n" +
            "WHERE eq_sbbh = #{eqSbbh}")
    void updateEqSelectionBySbbh(@Param("eqSbbh")String eqSbbh);
    /**
     * 功能描述:根据巡检计划Id查询巡检计划信息
     *
     * @Param: inspPlId
     * @Return: List<InspEqPlan>
     * @Author: ZYJ
     * @Date: 2019/8/14 0014 15:25
     */
    @Select("<script>SELECT * \n" +
            "FROM z_inspection_eq_plan as z\n" +
            "WHERE 1=1 \n" +
            "<if test=\"inspPlId != null and inspPlId !='' \">\n" +
            "and z.insp_pl_id = #{inspPlId}\n" +
            "</if></script>")
    List<InspEqPlan> selectInspPlanById(@Param("inspPlId")String inspPlId);

    /**
     * 功能描述: 查询巡检计划列表
     *
     * @Param:
     * @Return:
     * @Author: ZYJ
     * @Date: 2019/8/13 0013 16:03
     */
    @Select("SELECT DISTINCT insp_pl_id,insp_pl_name, insp_pl_create_time, \n" +
            "insp_pl_planner, insp_pl_auditor, insp_pl_status\n" +
            "FROM z_inspection_eq_plan ")
    List<InspPlanSelectVo> selectAllInspPlanVo();

    /**
     * 功能描述: 查询巡检计划列表
     *
     * @Param:
     * @Return:
     * @Author: ZYJ
     * @Date: 2019/8/13 0013 16:03
     */
    @Select("SELECT DISTINCT insp_pl_id,insp_pl_name, insp_pl_last_time, insp_pl_plan_execute_time, \n" +
            "insp_pl_planner, insp_pl_auditor, insp_pl_status\n" +
            "FROM z_inspection_eq_plan \n" +
            "where insp_pl_status = 3")
    List<InspPlanSelectVo1> selectAllResultInspPlanVo();

    /**
     * 功能描述: 查询巡检计划列表
     *
     * @Param: inspPlName inspPlPlanner inspPlAuditor inspPlStatus
     * @Return:
     * @Author: ZYJ
     * @Date: 2019/8/13 0013 16:03
     */
    @Select("<script>SELECT DISTINCT insp_pl_id,insp_pl_name, insp_pl_create_time, \n" +
            "insp_pl_planner, insp_pl_auditor, insp_pl_status\n" +
            "FROM z_inspection_eq_plan as z\n" +
            "WHERE 1=1 \n" +
            "<if test=\"inspPlName != null and inspPlName !='' \">\n" +
            "and z.insp_pl_name like concat( '%', #{inspPlName},'%')\n" +
            "</if>\n" +
            "<if test=\"inspPlPlanner != null and inspPlPlanner !='' \">\n" +
            "and z.insp_pl_sprare3 like concat( '%', #{inspPlPlanner},'%')\n" +
            "</if>\n" +
            "<if test=\"inspPlAuditor != null and inspPlAuditor !='' \">\n" +
            "and z.insp_pl_sprare4 like concat( '%', #{inspPlAuditor},'%')\n" +
            "</if>\n" +
            "<if test=\"inspPlStatus != null and inspPlStatus !='' \">\n" +
            "and z.insp_pl_status = #{inspPlStatus} \n" +
            "</if></script>")
    List<InspPlanSelectVo> selectInspPlanVo(@Param("inspPlName") String inspPlName, @Param("inspPlPlanner") String inspPlPlanner,
                                            @Param("inspPlAuditor") String inspPlAuditor, @Param("inspPlStatus") String inspPlStatus);

    /**
     * 功能描述: 查询巡检计划列表
     *
     * @Param: inspPlName inspPlPlanner inspPlAuditor inspPlStatus
     * @Return:
     * @Author: ZYJ
     * @Date: 2019/8/13 0013 16:03
     */
    @Select("<script>SELECT DISTINCT insp_pl_id,insp_pl_name, insp_pl_last_time, insp_pl_plan_execute_time, \n" +
            "insp_pl_planner, insp_pl_auditor, insp_pl_status\n" +
            "FROM z_inspection_eq_plan as z\n" +
            "WHERE 1=1 \n" +
            "and insp_pl_status = 3 \n" +
            "<if test=\"inspPlName != null and inspPlName !='' \">\n" +
            "and z.insp_pl_name like concat( '%', #{inspPlName},'%')\n" +
            "</if>\n" +
            "<if test=\"inspPlPlanner != null and inspPlPlanner !='' \">\n" +
            "and z.insp_pl_sprare3 like concat( '%', #{inspPlPlanner},'%')\n" +
            "</if>\n" +
            "<if test=\"inspPlAuditor != null and inspPlAuditor !='' \">\n" +
            "and z.insp_pl_sprare4 like concat( '%', #{inspPlAuditor},'%')\n" +
            "</if>\n" +
            "<if test=\"inspPlStatus != null and inspPlStatus !='' \">\n" +
            "and z.insp_pl_status = #{inspPlStatus} \n" +
            "</if></script>")
    List<InspPlanSelectVo1> selectResultInspPlanVo(@Param("inspPlName") String inspPlName, @Param("inspPlPlanner") String inspPlPlanner,
                                            @Param("inspPlAuditor") String inspPlAuditor, @Param("inspPlStatus") String inspPlStatus);


    /**
     * 功能描述: 查询巡检计划列表
     *
     * @Param:
     * @Return:
     * @Author: ZYJ
     * @Date: 2019/8/13 0013 16:03
     */
    @Select("SELECT DISTINCT insp_pl_id,insp_pl_name, insp_pl_create_time, \n" +
            "insp_pl_planner, insp_pl_auditor, insp_pl_status\n" +
            "FROM z_inspection_eq_plan \n" +
            "where insp_pl_status in(1, 4) ")
    List<InspPlanSelectVo> selectAllApproveInspPlanVo();
    /**
     * 功能描述: 查询巡检计划列表
     *
     * @Param: inspPlName inspPlPlanner inspPlAuditor inspPlStatus
     * @Return:
     * @Author: ZYJ
     * @Date: 2019/8/13 0013 16:03
     */
    @Select("<script>SELECT DISTINCT insp_pl_id,insp_pl_name, insp_pl_create_time, \n" +
            "insp_pl_planner, insp_pl_auditor, insp_pl_status\n" +
            "FROM z_inspection_eq_plan as z\n" +
            "WHERE 1=1 \n" +
            "and insp_pl_status in(1, 4)\n" +
            "<if test=\"inspPlName != null and inspPlName !='' \">\n" +
            "and z.insp_pl_name like concat( '%', #{inspPlName},'%')\n" +
            "</if>\n" +
            "<if test=\"inspPlPlanner != null and inspPlPlanner !='' \">\n" +
            "and z.insp_pl_planner like concat( '%', #{inspPlPlanner},'%')\n" +
            "</if>\n" +
            "<if test=\"inspPlAuditor != null and inspPlAuditor !='' \">\n" +
            "and z.insp_pl_auditor like concat( '%', #{inspPlAuditor},'%')\n" +
            "</if>\n" +
            "<if test=\"inspPlStatus != null and inspPlStatus !='' \">\n" +
            "and z.insp_pl_status = #{inspPlStatus} \n" +
            "</if></script>")
    List<InspPlanSelectVo> selectApproveInspPlanVo(@Param("inspPlName") String inspPlName, @Param("inspPlPlanner") String inspPlPlanner,
                                            @Param("inspPlAuditor") String inspPlAuditor, @Param("inspPlStatus") String inspPlStatus);

    /**
     * 功能描述: 插入巡检计划表
     *
     * @Param: inspPlanVo
     * @Return: void
     * @Author: ZYJ
     * @Date: 2019/8/13 0013 10:22
     */
    @Insert("<script>insert into z_inspection_eq_plan\n" +
            "    <trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\">\n" +
            "      <if test=\"inspPlId != null\">\n" +
            "        insp_pl_id,\n" +
            "      </if>\n" +
            "      <if test=\"inspPlEqSbbh != null\">\n" +
            "        insp_pl_eq_sbbh,\n" +
            "      </if>\n" +
            "      <if test=\"inspPlName != null\">\n" +
            "        insp_pl_name,\n" +
            "      </if>\n" +
            "      <if test=\"inspPlCreateTime != null\">\n" +
            "        insp_pl_create_time,\n" +
            "      </if>\n" +
            "      <if test=\"inspPlPlanner != null\">\n" +
            "        insp_pl_planner,\n" +
            "      </if>\n" +
            "      <if test=\"inspPlAuditor != null\">\n" +
            "        insp_pl_auditor,\n" +
            "      </if>\n" +
            "      <if test=\"inspPlNote != null\">\n" +
            "        insp_pl_note,\n" +
            "      </if>\n" +
            "      <if test=\"inspPlStatus != null\">\n" +
            "        insp_pl_status,\n" +
            "      </if>\n" +
            "      <if test=\"inspPlExecutorType != null\">\n" +
            "        insp_pl_executor_type,\n" +
            "      </if>\n" +
            "      <if test=\"inspPlType != null\">\n" +
            "        insp_pl_type,\n" +
            "      </if>\n" +
            "      <if test=\"inspPlPeriod != null\">\n" +
            "        insp_pl_period,\n" +
            "      </if>\n" +
            "      <if test=\"inspPlPeriodicUnit != null\">\n" +
            "        insp_pl_periodic_unit,\n" +
            "      </if>\n" +
            "      <if test=\"inspPlLastTime != null\">\n" +
            "        insp_pl_last_time,\n" +
            "      </if>\n" +
            "      <if test=\"inspPlChangeReason != null\">\n" +
            "        insp_pl_change_reason,\n" +
            "      </if>\n" +
            "      <if test=\"inspPlPlanExecuteTime != null\">\n" +
            "        insp_pl_plan_execute_time,\n" +
            "      </if>\n" +
            "      <if test=\"inspPlEqStandards != null\">\n" +
            "        insp_pl_eq_standards,\n" +
            "      </if>\n" +
            "      <if test=\"inspPlSprare1 != null\">\n" +
            "        insp_pl_sprare1,\n" +
            "      </if>\n" +
            "      <if test=\"inspPlSprare2 != null\">\n" +
            "        insp_pl_sprare2,\n" +
            "      </if>\n" +
            "      <if test=\"inspPlSprare3 != null\">\n" +
            "        insp_pl_sprare3,\n" +
            "      </if>\n" +
            "      <if test=\"inspPlSprare4 != null\">\n" +
            "        insp_pl_sprare4,\n" +
            "      </if>\n" +
            "      <if test=\"inspPlSprare5 != null\">\n" +
            "        insp_pl_sprare5,\n" +
            "      </if>\n" +
            "    </trim>\n" +
            "    <trim prefix=\"values (\" suffix=\")\" suffixOverrides=\",\">\n" +
            "      <if test=\"inspPlId != null\">\n" +
            "        #{inspPlId,jdbcType=VARCHAR},\n" +
            "      </if>\n" +
            "      <if test=\"inspPlEqSbbh != null\">\n" +
            "        #{inspPlEqSbbh,jdbcType=VARCHAR},\n" +
            "      </if>\n" +
            "      <if test=\"inspPlName != null\">\n" +
            "        #{inspPlName,jdbcType=VARCHAR},\n" +
            "      </if>\n" +
            "      <if test=\"inspPlCreateTime != null\">\n" +
            "        #{inspPlCreateTime,jdbcType=DATE},\n" +
            "      </if>\n" +
            "      <if test=\"inspPlPlanner != null\">\n" +
            "        #{inspPlPlanner,jdbcType=VARCHAR},\n" +
            "      </if>\n" +
            "      <if test=\"inspPlAuditor != null\">\n" +
            "        #{inspPlAuditor,jdbcType=VARCHAR},\n" +
            "      </if>\n" +
            "      <if test=\"inspPlNote != null\">\n" +
            "        #{inspPlNote,jdbcType=VARCHAR},\n" +
            "      </if>\n" +
            "      <if test=\"inspPlStatus != null\">\n" +
            "        #{inspPlStatus,jdbcType=VARCHAR},\n" +
            "      </if>\n" +
            "      <if test=\"inspPlExecutorType != null\">\n" +
            "        #{inspPlExecutorType,jdbcType=VARCHAR},\n" +
            "      </if>\n" +
            "      <if test=\"inspPlType != null\">\n" +
            "        #{inspPlType,jdbcType=VARCHAR},\n" +
            "      </if>\n" +
            "      <if test=\"inspPlPeriod != null\">\n" +
            "        #{inspPlPeriod,jdbcType=VARCHAR},\n" +
            "      </if>\n" +
            "      <if test=\"inspPlPeriodicUnit != null\">\n" +
            "        #{inspPlPeriodicUnit,jdbcType=INTEGER},\n" +
            "      </if>\n" +
            "      <if test=\"inspPlLastTime != null\">\n" +
            "        #{inspPlLastTime,jdbcType=DATE},\n" +
            "      </if>\n" +
            "      <if test=\"inspPlChangeReason != null\">\n" +
            "        #{inspPlChangeReason,jdbcType=VARCHAR},\n" +
            "      </if>\n" +
            "      <if test=\"inspPlPlanExecuteTime != null\">\n" +
            "        #{inspPlPlanExecuteTime,jdbcType=DATE},\n" +
            "      </if>\n" +
            "      <if test=\"inspPlEqStandards != null\">\n" +
            "        #{inspPlEqStandards,jdbcType=VARCHAR},\n" +
            "      </if>\n" +
            "      <if test=\"inspPlSprare1 != null\">\n" +
            "        #{inspPlSprare1,jdbcType=VARCHAR},\n" +
            "      </if>\n" +
            "      <if test=\"inspPlSprare2 != null\">\n" +
            "        #{inspPlSprare2,jdbcType=VARCHAR},\n" +
            "      </if>\n" +
            "      <if test=\"inspPlSprare3 != null\">\n" +
            "        #{inspPlSprare3,jdbcType=VARCHAR},\n" +
            "      </if>\n" +
            "      <if test=\"inspPlSprare4 != null\">\n" +
            "        #{inspPlSprare4,jdbcType=VARCHAR},\n" +
            "      </if>\n" +
            "      <if test=\"inspPlSprare5 != null\">\n" +
            "        #{inspPlSprare5,jdbcType=VARCHAR},\n" +
            "      </if>\n" +
            "    </trim></script>")
    void insertInspPlan(InspEqPlan inspEqPlan);


    /**
     * 功能描述: 根据巡检计划id删除巡检计划
     *
     * @Param: inspPlId
     * @Return: int
     * @Author: ZYJ
     * @Date: 2019/8/9 0009 13:35
     */
    @Delete("delete from z_inspection_eq_plan\n" +
            "where insp_pl_id = #{inspPlId,jdbcType=VARCHAR}")
    int deleteInspPlByPlId(@Param("inspPlId") String inspPlId);

    /**
     * 功能描述: 根据巡检计划id 巡检计划中的其它巡检
     *
     * @Param: inspPlId
     * @Return: int
     * @Author: ZYJ
     * @Date: 2019/8/9 0009 13:35
     */
    @Delete("delete from z_inspection_eq_plan\n" +
            "where insp_pl_type = 0 and insp_pl_id = #{inspPlId,jdbcType=VARCHAR}")
    int deleteInspPlByType(@Param("inspPlId") String inspPlId);

    /**
     * 功能描述: 同意审批
     *
     * @Param:
     * @Return:
     * @Author: ZYJ
     * @Date: 2019/8/9 0009 15:23
     */
    @Update("<script>UPDATE z_inspection_eq_plan\n" +
            "SET insp_pl_status = 3\n" +
            "WHERE 1 = 1 and insp_pl_status = 1\n" +
            "<if test=\"inspPlId != null and inspPlId !=''\">\n" +
            "and insp_pl_id like concat( '%', #{inspPlId}, '%')\n" +
            "</if></script>")
    void approvedForInspection(@Param("inspPlId") String inspPlId);

    /**
     * 功能描述: 拒绝审批
     *
     * @Param:
     * @Return:
     * @Author: ZYJ
     * @Date: 2019/8/9 0009 15:23
     */
    @Update("<script>UPDATE z_inspection_eq_plan\n" +
            "SET insp_pl_status = 2\n" +
            "WHERE 1 = 1 and insp_pl_status = 1\n" +
            "<if test=\"inspPlId != null and inspPlId !=''\">\n" +
            "and insp_pl_id like concat( '%', #{inspPlId}, '%')\n" +
            "</if></script>")
    void rejectedFroInspection(@Param("inspPlId") String inspPlId);


    /**
     * 功能描述: 变更提交后计划状态 status => 4
     *
     * @Param:
     * @Return:
     * @Author: ZYJ
     * @Date: 2019/8/9 0009 15:23
     */
    @Update("<script>UPDATE z_inspection_eq_plan\n" +
            "SET insp_pl_status = 4\n" +
            "WHERE 1 = 1 and insp_pl_status in(0, 2, 3)\n" +
            "<if test=\"inspPlId != null and inspPlId !=''\">\n" +
            "and insp_pl_id like concat( '%', #{inspPlId}, '%')\n" +
            "</if></script>")
    void updatePlus(@Param("inspPlId") String inspPlId);

    /**
     * 功能描述: 查询记录是否存在
     *
     * @Param: inspPlId
     * @Return: String
     * @Author: ZYJ
     * @Date: 2019/8/20 0020 12:49
     */
    @Select("SELECT TOP 1 z.insp_pl_change_auditor\n" +
            "FROM z_inspection_eq_plan_change AS z\n" +
            "WHERE z.insp_pl_id = #{inspPlId}\n" +
            "ORDER BY z.insp_pl_change_id DESC")
    String selectRecordIsNot(@Param("inspPlId")String inspPlId);

    @Select("SELECT TOP 1 z.insp_pl_change_id\n" +
            "FROM z_inspection_eq_plan_change AS z\n" +
            "WHERE z.insp_pl_id = #{inspPlId}\n" +
            "ORDER BY z.insp_pl_change_id DESC")
    String selectRecordChangeId(@Param("inspPlId")String inspPlId);

    /**
     * 功能描述: 变更记录第一步插入
     *
     * @Param:
     * @Return:
     * @Author: ZYJ
     * @Date: 2019/8/11 0011 13:53
     */
    @Insert("<script>insert into z_inspection_eq_plan_change\n" +
            "    <trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\">\n" +
            "      <if test=\"inspPlChangeId != null\">\n" +
            "        insp_pl_change_id,\n" +
            "      </if>\n" +
            "      <if test=\"inspPlId != null\">\n" +
            "        insp_pl_id,\n" +
            "      </if>\n" +
            "      <if test=\"inspPlChangeChangePerson != null\">\n" +
            "        insp_pl_change_change_person,\n" +
            "      </if>\n" +
            "      <if test=\"inspPlChangeTime != null\">\n" +
            "        insp_pl_change_time,\n" +
            "      </if>\n" +
            "      <if test=\"inspPlChangeReason != null\">\n" +
            "        insp_pl_change_reason,\n" +
            "      </if>\n" +
            "    </trim>\n" +
            "    <trim prefix=\"values (\" suffix=\")\" suffixOverrides=\",\">\n" +
            "      <if test=\"inspPlChangeId != null\">\n" +
            "        #{inspPlChangeId,jdbcType=VARCHAR},\n" +
            "      </if>\n" +
            "      <if test=\"inspPlId != null\">\n" +
            "        #{inspPlId,jdbcType=VARCHAR},\n" +
            "      </if>\n" +
            "      <if test=\"inspPlChangeChangePerson != null\">\n" +
            "        #{inspPlChangeChangePerson,jdbcType=VARCHAR},\n" +
            "      </if>\n" +
            "      <if test=\"inspPlChangeTime != null\">\n" +
            "        #{inspPlChangeTime,jdbcType=DATE},\n" +
            "      </if>\n" +
            "      <if test=\"inspPlChangeReason != null\">\n" +
            "        #{inspPlChangeReason,jdbcType=VARCHAR},\n" +
            "      </if>\n" +
            "</trim></script>")
    int insertChangeRecord1(@Param("inspPlChangeId")String inspPlChangeId, @Param("inspPlId")String inspPlId,
                            @Param("inspPlChangeChangePerson")String inspPlChangeChangePerson, @Param("inspPlChangeTime")String inspPlChangeTime,
                            @Param("inspPlChangeReason")String inspPlChangeReason);
    /**
     * 功能描述: 变更记录第一步更改
     *
     * @Param:
     * @Return:
     * @Author: ZYJ
     * @Date: 2019/8/11 0011 13:53
     */
    @Insert("<script>update z_inspection_eq_plan_change\n" +
            "    set insp_pl_id = #{inspPlId,jdbcType=VARCHAR},\n" +
            "      insp_pl_change_change_person = #{inspPlChangeChangePerson,jdbcType=VARCHAR},\n" +
            "      insp_pl_change_time = #{inspPlChangeTime,jdbcType=DATE},\n" +
            "      insp_pl_change_reason = #{inspPlChangeReason,jdbcType=VARCHAR},\n" +
            "    where insp_pl_change_id = #{inspPlChangeId,jdbcType=VARCHAR}</script>")
    int updateChangeRecord1(@Param("inspPlChangeId")String inspPlChangeId, @Param("inspPlId")String inspPlId,
                            @Param("inspPlChangeChangePerson")String inspPlChangeChangePerson, @Param("inspPlChangeTime")String inspPlChangeTime,
                            @Param("inspPlChangeReason")String inspPlChangeReason);

    /**
     * 功能描述: 变更记录第二步获取插入记录的位置id
     *
     * @Param:
     * @Return:
     * @Author: ZYJ
     * @Date: 2019/8/11 0011 14:24
     */
    @Select("select top 1 insp_pl_change_id \n" +
            "from z_inspection_eq_plan_change \n" +
            "WHERE insp_pl_id = #{inspPlId}\n" +
            "order by insp_pl_change_id desc")
    int selectChangeRecordPlanId(@Param("inspPlId")String inspPlId);

    /**
     * 功能描述: 变更记录第三步根据插入记录的位置id 更新审批信息
     *
     * @Param: [inspPlId, inspPlChangeAuditor, inspPlChangeExamineTime, inspPlChangeExamineOpinion]
     * @Return: int
     * @Author: ZYJ
     * @Date: 2019/8/11 0011 14:43
     */
    @Update("<script>update z_inspection_eq_plan_change\n" +
            "   <set>\n" +
            "      <if test=\"inspPlChangeAuditor != null\">\n" +
            "        insp_pl_change_auditor = #{inspPlChangeAuditor,jdbcType=VARCHAR},\n" +
            "      </if>\n" +
            "      <if test=\"inspPlChangeExamineTime != null\">\n" +
            "        Insp_pl_change_examine_time = #{inspPlChangeExamineTime,jdbcType=DATE},\n" +
            "      </if>\n" +
            "      <if test=\"inspPlChangeExamineOpinion != null\">\n" +
            "        Insp_pl_change_examine_opinion = #{inspPlChangeExamineOpinion,jdbcType=VARCHAR},\n" +
            "      </if>\n" +
            "   </set>\n" +
            "where insp_pl_change_id = #{inspPlChangeId,jdbcType=VARCHAR}</script>")
    int updateChangeRecord2(@Param("inspPlId")String inspPlId, @Param("inspPlChangeAuditor")String inspPlChangeAuditor,
                            @Param("inspPlChangeExamineTime")String inspPlChangeExamineTime, @Param("inspPlChangeExamineOpinion")String inspPlChangeExamineOpinion);


    /**
     * 功能描述: 查询所有此计划的变更记录
     *
     * @Param: inspPlId
     * @Return:  List<InspEqPlanChange>
     * @Author: ZYJ
     * @Date: 2019/8/20 0020 12:25
     */
    @Select("SELECT *\n" +
            "FROM z_inspection_eq_plan_change AS z\n" +
            "WHERE z.insp_pl_id = #{inspPlId}\n" +
            "ORDER BY z.insp_pl_change_time DESC")
    List<InspEqPlanChange> selectAllChangeById(@Param("inspPlId")String inspPlId);




}

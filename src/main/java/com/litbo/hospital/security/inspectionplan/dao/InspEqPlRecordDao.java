package com.litbo.hospital.security.inspectionplan.dao;

import com.litbo.hospital.security.inspectionplan.bean.InspEqPlanRecord;
import com.litbo.hospital.security.inspectionplan.bean.vo.RecordSelectVo.EquipmentVo;
import com.litbo.hospital.security.inspectionplan.bean.vo.RecordSelectVo.InspSelectPlanEqStandardsVo;
import com.litbo.hospital.security.inspectionplan.bean.vo.RecordSelectVo.InspSelectVo;
import com.litbo.hospital.security.inspectionplan.bean.vo.RecordSelectVo.PLanAndNowExecuteRecordVo;
import com.litbo.hospital.security.inspectionplan.bean.vo.SelectRecordVo;
import com.litbo.hospital.security.inspectionplan.bean.vo.UserVo1;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

/**
 * @author 10366 2019-08-26 23:12
 **/
@Mapper
public interface InspEqPlRecordDao {



    /**
     * 功能描述: 查询签字照片路径
     *
     * @Param: eqSbbh
     * @Return: String
     * @Author: ZYJ
     * @Date: 2019/8/26 0026 23:36
     */
    @Select("SELECT e.qzzp\n" +
            "FROM eq_info AS eq, s_bm AS b, s_emp AS e\n" +
            "WHERE eq.eq_bmid = b.bm_id\n" +
            "AND b.user_id = e.user_id\n" +
            "and eq.eq_sbbh = #{eqSbbh}")
    String selectQzzpBySbbh(@Param("eqSbbh")String eqSbbh);

    @Select("<script>SELECT DISTINCT insp_pl_id, insp_pl_executor_time, spare1, spare2\n" +
            "FROM z_inspection_eq_plan_record\n" +
            "<where>\n" +
            "<if test=\"inspPlId != null and inspPlId !='' \">\n" +
            "AND insp_pl_id = #{inspPlId}\n" +
            "</if>\n" +
            "<if test=\"endTime1 != null\">\n" +
            " and insp_pl_executor_time &lt;=#{endTime1, jdbcType=DATE} \n" +
            "</if>\n" +
            "<if test=\"beginTime1 != null\">\n" +
            "and insp_pl_executor_time &gt;= #{beginTime1, jdbcType=DATE}\n" +
            "</if>\n" +
            "<if test=\"endTime2 != null\">\n" +
            " and spare1 &lt;=#{endTime2, jdbcType=DATE} \n" +
            "</if>\n" +
            "<if test=\"beginTime2 != null\">\n" +
            "and spare1 &gt;= #{beginTime2, jdbcType=DATE}\n" +
            "</if>\n" +
            "</where></script>")
    List<PLanAndNowExecuteRecordVo> selectPLanAndNowExecuteRecordVoByCondition(@Param("inspPlId")String inspPlId,@Param("beginTime1")Date beginTime1,
                                                                               @Param("endTime1")Date endTime1, @Param("beginTime2")Date beginTime2,
                                                                               @Param("endTime2")Date endTime2);
    /**
     * 功能描述: 查询 往日此巡检计划的巡检记录
     *
     * @Param:
     * @Return:
     * @Author: ZYJ
     * @Date: 2019/8/31 0031 10:13
     */
    @Select("SELECT DISTINCT insp_pl_id, insp_pl_executor_time, spare1, spare2\n" +
            "FROM z_inspection_eq_plan_record\n" +
            "WHERE insp_pl_id = #{inspPlId}")
    List<PLanAndNowExecuteRecordVo> selectPLanAndNowExecuteRecordVoById(@Param("inspPlId")String inspPlId);

    /**
     * 功能描述: 查询巡检计划 计划执行时间
     *
     * @Param:
     * @Return:
     * @Author: ZYJ
     * @Date: 2019/8/31 0031 9:44
     */
    @Select("SELECT TOP 1 insp_pl_plan_execute_time\n" +
            "FROM z_inspection_eq_plan\n" +
            "WHERE insp_pl_id = #{inspPlId}")
    Date selectPlanExecuteTimeById(@Param("inspPlId")String inspPlId);

    /**
     * 功能描述: 巡检完毕，其他巡检类型的变为停用状态
     *
     * @Param:
     * @Return:
     * @Author: ZYJ
     * @Date: 2019/8/31 0031 9:35
     */
    @Update("UPDATE z_inspection_eq_plan\n" +
            "SET insp_pl_status = '0'\n" +
            "WHERE insp_pl_id = #{inspPlId}")
    void updateInspStatusById(@Param("inspPlId")String inspPlId);

    /**
     * 功能描述: 查询此计划类型是否为其它巡检
     *
     * @Param:
     * @Return:
     * @Author: ZYJ
     * @Date: 2019/8/31 0031 9:29
     */
    @Select("SELECT TOP 1 insp_pl_type\n" +
            "FROM z_inspection_eq_plan\n" +
            "WHERE insp_pl_id = #{inspPlId}")
    String selectInspTypeById(@Param("inspPlId")String inspPlId);

    /**
     * 功能描述: 查询人员签字
     *
     * @Param:
     * @Return: List<UserVo>
     * @Author: ZYJ
     * @Date: 2019/8/4 0004 9:29
     */
    @Select("SELECT e.user_id, e.user_xm, b.bm_name, e.qzzp\n" +
            "FROM s_bm AS b, s_emp AS e\n" +
            "WHERE e.bm_id = b.bm_id")
    List<UserVo1> selectAllUser();
    @Select("<script>" +
            "SELECT e.user_id, e.user_xm, b.bm_name, e.qzzp\n" +
            "FROM s_bm AS b, s_emp AS e\n" +
            "WHERE 1 = 1 and e.bm_id = b.bm_id\n" +
            "<if test=\"userId != null and userId !='' \">\n" +
            "and e.user_id like concat( '%', #{userId},'%')\n" +
            "</if>" +
            "<if test=\"userXm != null and userXm !='' \">\n" +
            "and e.user_xm like concat( '%', #{userXm},'%')\n" +
            "</if>" +
            "<if test=\"bmName != null and bmName !='' \">\n" +
            "and b.bm_name like concat( '%', #{bmName},'%')\n" +
            "</if>" +
            "</script>")
    List<UserVo1> selectUserByUserVo(@Param("userId") String userId,
                                     @Param("userXm") String userXm,
                                     @Param("bmName") String bmName);

    @Update("UPDATE z_inspection_eq_plan\n" +
            "SET insp_pl_plan_execute_time = #{inspPlPlanExecuteTime}\n" +
            "WHERE insp_pl_id = #{inspPlId}")
    void updatePlanTime(@Param("inspPlId")String inspPlId,
                            @Param("inspPlPlanExecuteTime")String inspPlPlanExecuteTime);
    @Select("SELECT TOP 1 insp_pl_periodic_unit\n" +
            "FROM z_inspection_eq_plan\n" +
            "WHERE insp_pl_id = #{inspPlId}")
    int selectPeriodUnit(String inspPlId);
    @Select("SELECT TOP 1 insp_pl_period\n" +
            "FROM z_inspection_eq_plan\n" +
            "WHERE insp_pl_id = #{inspPlId}")
    String selectPeriod(String inspPlId);

    /**
     * 功能描述: 更新巡检计划时间
     *
     * @Param: inspPlId
     * @Return:
     * @Author: ZYJ
     * @Date: 2019/8/29 0029 16:58
     */
    @Update("UPDATE z_inspection_eq_plan\n" +
            "SET insp_pl_last_time = #{inspPlLastTime}\n" +
            "WHERE insp_pl_id = #{inspPlId}")
    void updateLastInspTime(@Param("inspPlId")String inspPlId,
                            @Param("inspPlLastTime")String inspPlLastTime);

    /**
     * 功能描述: 删除其它巡检
     *
     * @Param: inspPlId
     * @Return:
     * @Author: ZYJ
     * @Date: 2019/8/29 0029 16:58
     */
    @Delete("<script>DELETE \n" +
            "FROM z_inspection_eq_plan\n" +
            "<where> insp_pl_type = '0'\n" +
            "<if test=\"inspPlId != null and inspPlId !='' \">\n" +
            "AND insp_pl_id = #{inspPlId}\n" +
            "</if></where></script>")
    void deleteOtherInspPlan(@Param("inspPlId")String inspPlId);

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
     * 功能描述: 根据记录id查询巡检记录
     *
     * @Param: inspReId
     * @Return:
     * @Author: ZYJ
     * @Date: 2019/8/28 0028 10:22
     */
    @Select("SELECT *\n" +
            "FROM z_inspection_eq_plan_record\n" +
            "WHERE insp_re_id = #{inspReId}")
    InspEqPlanRecord selectInspRecordByRecordId(@Param("inspReId")String inspReId);
    /**
     * 功能描述: 查看录入结果 根据 条件
     *
     * @Param:
     * @Return:
     * @Author: ZYJ
     * @Date: 2019/8/28 0028 0:09
     */
    @Select("<script>SELECT z.insp_re_id, zz.insp_pl_name, z.eq_sbbh, eq.eq_name, b.bm_name, z.insp_pl_executor_time\n" +
            "FROM z_inspection_eq_plan_record AS z, z_inspection_eq_plan AS zz, eq_info AS eq, s_bm AS b \n" +
            "<where>\n" +
            "z.eq_sbbh = eq.eq_sbbh\n" +
            "AND eq.eq_bmid = b.bm_id\n" +
            "AND z.insp_pl_id = zz.insp_pl_id\n" +
            "AND z.eq_sbbh = zz.insp_pl_eq_sbbh\n" +
            "<if test=\"bmName != null and bmName !='' \">\n" +
            "AND b.bm_name like concat( '%', #{bmName},'%')\n" +
            "</if>\n" +
            "<if test=\"inspPlName!= null and inspPlName !='' \">\n" +
            "AND zz.insp_pl_name like concat( '%', #{inspPlName},'%')\n" +
            "</if>\n" +
            "<if test=\"eqName!= null and eqName !='' \">\n" +
            "AND eq.eq_name like concat( '%', #{eqName},'%')\n" +
            "</if>\n" +
            "<if test=\"endTime != null\">\n" +
            "and z.insp_pl_executor_time &lt;=#{endTime, jdbcType=DATE} \n" +
            "</if>\n" +
            "<if test=\"beginTime != null\">\n" +
            "and z.insp_pl_executor_time &gt;= #{beginTime, jdbcType=DATE} \n" +
            "</if>\n" +
            "</where></script>\n")
    List<SelectRecordVo> selectRecordVoByCondition(@Param("inspPlName")String inspPlName, @Param("eqName")String eqName,
                                                   @Param("bmName")String bmName, @Param("beginTime")Date beginTime,
                                                   @Param("endTime") Date endTime);

    /**
     * 功能描述: 查看录入结果
     *
     * @Param:
     * @Return:
     * @Author: ZYJ
     * @Date: 2019/8/28 0028 0:09
     */
    @Select("SELECT z.insp_re_id, zz.insp_pl_name, z.eq_sbbh,  eq.eq_name, b.bm_name, z.insp_pl_executor_time\n" +
            "FROM z_inspection_eq_plan_record AS z, z_inspection_eq_plan AS zz, eq_info AS eq, s_bm AS b\n" +
            "WHERE z.eq_sbbh = eq.eq_sbbh\n" +
            "AND eq.eq_bmid = b.bm_id\n" +
            "AND z.insp_pl_id = zz.insp_pl_id\n" +
            "AND z.eq_sbbh = zz.insp_pl_eq_sbbh\n" +
            "order by z.insp_pl_executor_time desc")
    List<SelectRecordVo> selectRecordVo();

    /**
     * 功能描述: 插入巡检记录
     *
     * @Param: inspEqPlanRecord
     * @Return:
     * @Author: ZYJ
     * @Date: 2019/8/27 0027 9:28
     */
    @Insert("<script>insert into z_inspection_eq_plan_record\n" +
            "    <trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\">\n" +
            "      <if test=\"inspReId != null\">\n" +
            "        insp_re_id,\n" +
            "      </if>\n" +
            "      <if test=\"inspPlId != null\">\n" +
            "        insp_pl_id,\n" +
            "      </if>\n" +
            "      <if test=\"eqSbbh != null\">\n" +
            "        eq_sbbh,\n" +
            "      </if>\n" +
            "      <if test=\"inspPlStandardIds != null\">\n" +
            "        insp_pl_standard_ids,\n" +
            "      </if>\n" +
            "      <if test=\"inspPlStandardResults != null\">\n" +
            "        insp_pl_standard_results,\n" +
            "      </if>\n" +
            "      <if test=\"inspPlOtherProblem != null\">\n" +
            "        insp_pl_other_problem,\n" +
            "      </if>\n" +
            "      <if test=\"inspPlExecutor != null\">\n" +
            "        insp_pl_executor,\n" +
            "      </if>\n" +
            "      <if test=\"inspPlExecutorTime != null\">\n" +
            "        insp_pl_executor_time,\n" +
            "      </if>\n" +
            "      <if test=\"inspPlBmQz != null\">\n" +
            "        insp_pl_bm_qz,\n" +
            "      </if>\n" +
            "      <if test=\"spare1 != null\">\n" +
            "        spare1,\n" +
            "      </if>\n" +
            "      <if test=\"spare2 != null\">\n" +
            "        spare2,\n" +
            "      </if>\n" +
            "      <if test=\"spare3 != null\">\n" +
            "        spare3,\n" +
            "      </if>\n" +
            "      <if test=\"spare4 != null\">\n" +
            "        spare4,\n" +
            "      </if>\n" +
            "      <if test=\"spare5 != null\">\n" +
            "        spare5,\n" +
            "      </if>\n" +
            "      <if test=\"inspPlPeople != null\">\n" +
            "        insp_pl_people,\n" +
            "      </if>\n" +
            "    </trim>\n" +
            "    <trim prefix=\"values (\" suffix=\")\" suffixOverrides=\",\">\n" +
            "      <if test=\"inspReId != null\">\n" +
            "        #{inspReId,jdbcType=VARCHAR},\n" +
            "      </if>\n" +
            "      <if test=\"inspPlId != null\">\n" +
            "        #{inspPlId,jdbcType=VARCHAR},\n" +
            "      </if>\n" +
            "      <if test=\"eqSbbh != null\">\n" +
            "        #{eqSbbh,jdbcType=VARCHAR},\n" +
            "      </if>\n" +
            "      <if test=\"inspPlStandardIds != null\">\n" +
            "        #{inspPlStandardIds,jdbcType=VARCHAR},\n" +
            "      </if>\n" +
            "      <if test=\"inspPlStandardResults != null\">\n" +
            "        #{inspPlStandardResults,jdbcType=VARCHAR},\n" +
            "      </if>\n" +
            "      <if test=\"inspPlOtherProblem != null\">\n" +
            "        #{inspPlOtherProblem,jdbcType=VARCHAR},\n" +
            "      </if>\n" +
            "      <if test=\"inspPlExecutor != null\">\n" +
            "        #{inspPlExecutor,jdbcType=VARCHAR},\n" +
            "      </if>\n" +
            "      <if test=\"inspPlExecutorTime != null\">\n" +
            "        #{inspPlExecutorTime,jdbcType=DATE},\n" +
            "      </if>\n" +
            "      <if test=\"inspPlBmQz != null\">\n" +
            "        #{inspPlBmQz,jdbcType=VARCHAR},\n" +
            "      </if>\n" +
            "      <if test=\"spare1 != null\">\n" +
            "        #{spare1,jdbcType=VARCHAR},\n" +
            "      </if>\n" +
            "      <if test=\"spare2 != null\">\n" +
            "        #{spare2,jdbcType=VARCHAR},\n" +
            "      </if>\n" +
            "      <if test=\"spare3 != null\">\n" +
            "        #{spare3,jdbcType=VARCHAR},\n" +
            "      </if>\n" +
            "      <if test=\"spare4 != null\">\n" +
            "        #{spare4,jdbcType=VARCHAR},\n" +
            "      </if>\n" +
            "      <if test=\"spare5 != null\">\n" +
            "        #{spare5,jdbcType=VARCHAR},\n" +
            "      </if>\n" +
            "      <if test=\"inspPlPeople != null\">\n" +
            "        #{inspPlPeople,jdbcType=LONGVARCHAR},\n" +
            "      </if>\n" +
            "    </trim></script>")
    void insertInspPlRecord(InspEqPlanRecord inspEqPlanRecord);

    /**
     * 功能描述:
     *
     * @Param: inspPlStandardId
     * @Return: InspSelectPlanEqStandardsVo
     * @Author: ZYJ
     * @Date: 2019/8/27 0027 0:44
     */
    @Select("SELECT insp_pl_standard_id, insp_pl_standard_name\n" +
            "FROM z_insp_pl_standard\n" +
            "WHERE insp_pl_standard_id = #{inspPlStandardId}")
    InspSelectPlanEqStandardsVo selectStandardById(@Param("inspPlStandardId") String inspPlStandardId);

    /**
     * 功能描述:
     *
     * @Param: eqSbbh
     * @Return: EquipmentVo
     * @Author: ZYJ
     * @Date: 2019/8/27 0027 0:32
     */
    @Select("SELECT eq_sbbh, eq_name, bm_name, eq_xh\n" +
            "FROM eq_info, s_bm\n" +
            "WHERE eq_info.eq_bmid = s_bm.bm_id\n" +
            "AND eq_sbbh = #{eqSbbh}")
    EquipmentVo selectEqById(@Param("eqSbbh") String eqSbbh);

    /**
     * 功能描述: 结果录入查询巡检计划
     *
     * @Param: inspPlId
     * @Return: List<InspSelectVo>
     * @Author: ZYJ
     * @Date: 2019/8/27 0027 0:19
     */
    @Select("SELECT insp_pl_id, insp_pl_name, insp_pl_create_time, insp_pl_eq_sbbh, insp_pl_eq_standards\n" +
            "FROM z_inspection_eq_plan\n" +
            "WHERE insp_pl_id = #{inspPlId}")
    List<InspSelectVo> selectInspPlById(@Param("inspPlId") String inspPlId);



    @Select("SELECT s.user_xm\n" +
            "FROM s_emp as s\n" +
            "WHERE s.user_id = #{userId}")
    String selectUserNameById(@Param("userId")String userId);

}

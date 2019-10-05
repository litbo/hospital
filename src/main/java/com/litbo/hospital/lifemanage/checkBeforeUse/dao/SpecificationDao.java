package com.litbo.hospital.lifemanage.checkBeforeUse.dao;

import com.litbo.hospital.lifemanage.checkBeforeUse.vo.*;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Mapper
public interface SpecificationDao {




    @Select("SELECT\n" +
            "dbo.s_emp.user_id,\n" +
            "dbo.s_emp.bm_id,\n" +
            "dbo.s_bm.bm_name,\n" +
            "dbo.s_emp.user_xm\n" +
            "\n" +
            "FROM\n" +
            "\tdbo.s_emp,\n" +
            "\tdbo.s_bm\n" +
            "WHERE\n" +
            "\tdbo.s_emp.bm_id = dbo.s_bm.bm_id\n")
    List<UserVo> searchUsers();

    @Select("<script>" +
            "SELECT\n" +
            "        dbo.s_emp.user_id,\n" +
            "        dbo.s_emp.bm_id,\n" +
            "        dbo.s_emp.user_xm,\n" +
            "        dbo.s_bm.bm_name\n" +
            "    FROM\n" +
            "        dbo.s_bm,\n" +
            "        dbo.s_emp\n" +
            "    WHERE\n" +
            "        dbo.s_bm.bm_id = dbo.s_emp.bm_id\n" +
            "    <if test=\"userXm!=null\">\n" +
            "        and dbo.s_emp.user_xm like CONCAT('%',#{userXm},'%') \n" +
            "    </if>\n" +
            "</script>")
    List<UserVo> searchAppointUsers(UserVo userVo);

    @Select("SELECT\n" +
            "      dbo.eq_info.eq_sbbh,\n" +
            "      dbo.eq_info.eq_name,\n" +
            "      dbo.eq_info.eq_pym,\n" +
            "      dbo.s_bm.bm_id,\n" +
            "      dbo.s_bm.bm_name,\n" +
            "      dbo.eq_info.eq_id,\n" +
            "      dbo.eq_info.eq_xh,\n" +
            "      dbo.eq_info.eq_gg,\n" +
            "      dbo.eq_info.sbcs_id_scs,\n" +
            "      dbo.eq_info.eq_pp,\n" +
            "      dbo.eq_info.eq_tzlb\n" +
            "    FROM\n" +
            "      dbo.s_bm,\n" +
            "      dbo.eq_info\n" +
            "    WHERE\n" +
            "      dbo.s_bm.bm_id = dbo.eq_info.eq_bmid")
    List<EqInfoVO2> searchAllEqInfo();

    @Select("<script>" +
            "SELECT\n" +
            "      dbo.eq_info.eq_sbbh,\n" +
            "      dbo.eq_info.eq_name,\n" +
            "      dbo.eq_info.eq_pym,\n" +
            "      dbo.s_bm.bm_id,\n" +
            "      dbo.s_bm.bm_name,\n" +
            "      dbo.eq_info.eq_id,\n" +
            "      dbo.eq_info.eq_xh,\n" +
            "      dbo.eq_info.eq_gg,\n" +
            "      dbo.eq_info.sbcs_id_scs,\n" +
            "      dbo.eq_info.eq_pp,\n" +
            "      dbo.eq_info.eq_tzlb\n" +
            "    FROM\n" +
            "      dbo.s_bm,\n" +
            "      dbo.eq_info\n" +
            "    WHERE\n" +
            "      dbo.s_bm.bm_id = dbo.eq_info.eq_bmid\n" +
            "    " +
            "        <if test=\"eqSbbh != null\">\n" +
            "            and dbo.eq_info.eq_sbbh like CONCAT('%',#{eqSbbh},'%')\n" +
            "        </if>\n" +
            "        <if test=\"eqName != null\">\n" +
            "            and dbo.eq_info.eq_name like CONCAT('%',#{eqName},'%')\n" +
            "        </if>\n" +
            "        <if test=\"eqPym != null\">\n" +
            "            and dbo.eq_info.eq_pym like CONCAT('%',#{eqPym},'%')\n" +
            "        </if>\n" +
            "        <if test=\"bmName != null\">\n" +
            "            and dbo.s_bm.bm_name like CONCAT('%',#{bmName},'%')\n" +
            "        </if>" +
            "   " +
            "</script>")
    List<EqInfoVO2> searchAppointEqInfos(EqInfoVO2 eqInfoVO2);

    @Select("<script>" +
            "SELECT\n" +
            "      dbo.eq_info.eq_sbbh,\n" +
            "      dbo.eq_info.eq_name,\n" +
            "      dbo.eq_info.eq_pym,\n" +
            "      dbo.s_bm.bm_id,\n" +
            "      dbo.s_bm.bm_name,\n" +
            "      dbo.eq_info.eq_id,\n" +
            "      dbo.eq_info.eq_xh,\n" +
            "      dbo.eq_info.eq_gg,\n" +
            "      dbo.eq_info.eq_pp,\n" +
            "      dbo.eq_info.sbcs_id_scs,\n" +
            "      dbo.eq_info.eq_tzlb\n" +
            "    FROM\n" +
            "      dbo.s_bm,\n" +
            "      dbo.eq_info\n" +
            "    WHERE\n" +
            "      dbo.s_bm.bm_id = dbo.eq_info.eq_bmid\n" +
            "      and dbo.eq_info.eq_sbbh = #{sbbh}" +
            "   " +
            "</script>")
    EqInfoVO2 searchEqInfosBySbbh(String sbbh);


    @Insert("INSERT INTO standards (\n" +
            "      standard_name,\n" +
            "      equipment_number,\n" +
            "      applicable_equipment,\n" +
            "      designer_number,\n" +
            "      reviewer_number,\n" +
            "      DATE,\n" +
            "      cycle\n" +
            "    )\n" +
            "    VALUES\n" +
            "    (\n" +
            "        #{standardName},\n" +
            "        #{equipmentNumber},\n" +
            "        #{applicableEquipment},\n" +
            "        #{designerNumber},\n" +
            "        #{reviewerNumber},\n" +
            "        #{date,jdbcType=DATE},\n" +
            "        #{cycle}\n" +
            "    )")
    Integer saveStandard(SaveStandardVO saveStandardVO);

    @Select("SELECT\n" +
            "\tTOP 1 dbo.standards.standard_id\n" +
            "FROM\n" +
            "\tdbo.standards\n" +
            "ORDER BY\n" +
            "\tdbo.standards.standard_id DESC")
    Integer searchTheLastStandard();

    @Insert("<script>" +
            "INSERT INTO standard_project (\n" +
            "      standard_id,\n" +
            "      operation_id,\n" +
            "      project_id\n" +
            "    )\n" +
            "    VALUES\n" +
            "    <foreach collection=\"list\" item=\"item\" separator=\",\">\n" +
            "      (\n" +
            "       #{standardId},\n" +
            "       #{item.operationId},\n" +
            "       #{item.projectId}\n" +
            "      )\n" +
            "    </foreach>" +
            "</script>")
    Integer saveStandardProject(Integer standardId, List<SaveStandardProjectVO> list);

    @Select("<script>" +
            "SELECT\n" +
            "      dbo.standards.standard_id,\n" +
            "      dbo.standards.standard_name,\n" +
            "      dbo.standards.equipment_number,\n" +
            "      dbo.standards.applicable_equipment,\n" +
            "      dbo.standards.designer_number,\n" +
            "      dbo.standards.reviewer_number,\n" +
            "      dbo.eq_info.sbcs_id_scs,\n" +
            "      dbo.standards.[date],\n" +
            "      dbo.standards.[cycle_date]," +
            "      dbo.s_emp.user_xm AS designer_name,\n" +
            "      a.user_xm AS reviewer_name,\n" +
            "      dbo.eq_info.eq_name AS equipmentName,\n" +
            "      dbo.standards.cycle,\n" +
            "      dbo.standards.result\n" +
            "    FROM\n" +
            "      dbo.standards,\n" +
            "      dbo.s_emp,\n" +
            "      (SELECT * FROM s_emp) AS a,\n" +
            "      dbo.eq_info\n" +
            "    WHERE\n" +
            "      dbo.standards.designer_number = dbo.s_emp.user_id\n" +
            "      AND dbo.standards.reviewer_number = a.user_id\n" +
            "      AND dbo.standards.equipment_number = dbo.eq_info.eq_sbbh\n" +
            "      <if test=\"result != null\">\n" +
            "      AND dbo.standards.result = #{result}\n" +
            "      </if>" +
            "</script>")
    List<SearchStandardVO> searchAllStandards(@Param("result") Integer result);

    @Select("SELECT\n" +
            "\tdbo.standard_project.operation_id,\n" +
            "\tdbo.standard_project.project_id,\n" +
            "\tdbo.standard_inspection.type_id,\n" +
            "\tdbo.standard_inspection.type_name,\n" +
            "\tdbo.standard_inspection.project_name,\n" +
            "\tdbo.project_inspection_operation.operation_name\n" +
            "\n" +
            "FROM\n" +
            "\tdbo.standard_inspection,\n" +
            "\tdbo.standard_project,\n" +
            "\tdbo.project_inspection_operation\n" +
            "WHERE\n" +
            "dbo.standard_project.operation_id = dbo.project_inspection_operation.operation_id AND\n" +
            "dbo.standard_project.project_id = dbo.standard_inspection.project_id AND\n" +
            "dbo.standard_project.standard_id = #{standardId}\n")
    List<SearchStandardProjectVO> searchAllProject(Integer standardId);

    @Select("SELECT\n" +
            "\tdbo.standards.standard_id,\n" +
            "\tdbo.standards.standard_name,\n" +
            "\tdbo.standards.equipment_number,\n" +
            "\tdbo.standards.applicable_equipment,\n" +
            "\tdbo.standards.designer_number,\n" +
            "\tdbo.standards.reviewer_number,\n" +
            "\tdbo.standards.[date],\n" +
            "\tdbo.s_emp.user_xm AS designer_name,\n" +
            "\ta.user_xm AS reviewer_name,\n" +
            "\tdbo.eq_info.eq_name AS equipmentName,\n" +
            "\tdbo.standards.cycle,\n" +
            "\tdbo.standards.result\n" +
            "FROM\n" +
            "\tdbo.standards,\n" +
            "\tdbo.s_emp,\n" +
            "\t(SELECT * FROM s_emp) AS a,\n" +
            "\tdbo.eq_info\n" +
            "WHERE\n" +
            "\tdbo.standards.designer_number = dbo.s_emp.user_id\n" +
            "AND dbo.standards.reviewer_number = a.user_id\n" +
            "AND dbo.standards.equipment_number = dbo.eq_info.eq_sbbh\n" +
            "AND dbo.standards.standard_id = #{standardId}")
    SearchStandardVO searchStandard(Integer standardId);

    @Update("UPDATE dbo.standards\n" +
            "SET result = #{result}\n" +
            "WHERE\n" +
            "\tstandard_id = #{standardId}")
    Integer updateStandardResult(Integer standardId,Integer result);

    @Update("UPDATE dbo.standards\n" +
            "SET cycle_date = GETDATE() + 1\n" +
            "WHERE\n" +
            "\tstandard_id = #{standardId}")
    Integer updateStandardCycleDateTrue(Integer standardId);

    @Update("UPDATE dbo.standards\n" +
            "SET cycle_date = null\n" +
            "WHERE\n" +
            "\tstandard_id = #{standardId}")
    Integer updateStandardCycleDateFalse(Integer standardId);


    @Insert("<script>" +
            "INSERT INTO task_buffer (\n" +
            "      equipment_number,\n" +
            "      standard_name,\n" +
            "      operation_id,\n" +
            "      project_id,\n" +
            "      standard_id,\n" +
            "      start_date\n" +
            "      )\n" +
            "    VALUES\n" +
            "\t<foreach collection=\"list\" item=\"item\" separator=\",\">\n" +
            "      (\n" +
            "      #{item.equipmentNumber},\n" +
            "      #{item.standardName},\n" +
            "      #{item.operationId},\n" +
            "      #{item.projectId},\n" +
            "      #{item.standardId},\n" +
            "      GETDATE()\n" +
            "      )\n" +
            "    </foreach>" +
            "</script>")
    Integer saveTaskBuffers(List<SaveTaskBufferVO> saveTaskBufferVOS);


    @Delete("DELETE\n" +
            "FROM\n" +
            "\tdbo.task_buffer\n" +
            "WHERE\n" +
            "\tstandard_id = #{standardId}")
    Integer deleteTaskBufferByStandardId(Integer standardId);


    @Select("SELECT\n" +
            "dbo.task_buffer.equipment_number,\n" +
            "dbo.task_buffer.standard_name,\n" +
            "dbo.task_buffer.operation_id,\n" +
            "dbo.task_buffer.project_id,\n" +
            "dbo.task_buffer.standard_id,\n" +
            "dbo.task_buffer.start_date\n" +
            "\n" +
            "FROM\n" +
            "dbo.task_buffer\n" +
            "WHERE\n" +
            "dbo.task_buffer.standard_id = #{standardId}\n")
    List<SaveTaskBufferVO> searchTaskBufferByStandardId(Integer standardId);

    @Insert("<script>" +
            "INSERT INTO standard_task (\n" +
            "      equipment_number,\n" +
            "      standard_name,\n" +
            "      operation_id,\n" +
            "      project_id,\n" +
            "      standard_id,\n" +
            "      [date]\n" +
            "      )\n" +
            "    VALUES\n" +
            "\t<foreach collection=\"list\" item=\"item\" separator=\",\">\n" +
            "      (\n" +
            "      #{item.equipmentNumber},\n" +
            "      #{item.standardName},\n" +
            "      #{item.operationId},\n" +
            "      #{item.projectId},\n" +
            "      #{item.standardId},\n" +
            "      GETDATE()\n" +
            "      )\n" +
            "    </foreach>" +
            "</script>")
    Integer saveStandardTask(List<SaveTaskBufferVO> saveTaskBufferVOS);

    @Select("UPDATE standards\n" +
            "SET cycle_date = #{nextCycleDate}\n" +
            "where \n" +
            "standard_id = #{standardId}")
    Integer updateStandardCycleDate(Integer standardId, Date nextCycleDate);

    @Select("SELECT\n" +
            "dbo.eq_info.eq_sbbh,\n" +
            "dbo.standard_task.task_id,\n" +
            "dbo.standard_task.standard_name,\n" +
            "dbo.standard_task.task_result,\n" +
            "dbo.standard_task.operation_id,\n" +
            "dbo.standard_task.project_id,\n" +
            "dbo.standard_task.standard_id,\n" +
            "dbo.eq_info.eq_name,\n" +
            "dbo.standard_task.[date],\n" +
            "dbo.standard_inspection.project_name,\n" +
            "dbo.standard_inspection.type_name,\n" +
            "dbo.project_inspection_operation.operation_name,\n" +
            "dbo.eq_info.eq_bmid,\n" +
            "dbo.s_bm.bm_name,\n" +
            "dbo.standard_task.[operation_date],\n" +
            "dbo.standard_task.operator_number\n" +
            "\n" +
            "FROM\n" +
            "\tdbo.standard_task,\n" +
            "\tdbo.eq_info,\n" +
            "\tdbo.standard_inspection,\n" +
            "\tdbo.project_inspection_operation,\n" +
            "\tdbo.s_bm\n" +
            "WHERE\n" +
            "\tdbo.standard_task.equipment_number = dbo.eq_info.eq_sbbh\n" +
            "AND datediff(\n" +
            "\tday,\n" +
            "\tdbo.standard_task.[date],\n" +
            "\tGETDATE()\n" +
            ") = 0\n" +
            "AND dbo.standard_task.project_id = dbo.standard_inspection.project_id\n" +
            "AND dbo.standard_task.task_result IS NULL\n" +
            "AND dbo.standard_task.operation_id = dbo.project_inspection_operation.operation_id\n" +
            "AND dbo.eq_info.eq_bmid = dbo.s_bm.bm_id\n")
    List<SearchStandardTaskVO> searchTodayUnfinishedStandardTask();

    @Select("SELECT\n" +
            "dbo.eq_info.eq_sbbh,\n" +
            "dbo.standard_task.task_id,\n" +
            "dbo.standard_task.standard_name,\n" +
            "dbo.standard_task.task_result,\n" +
            "dbo.standard_task.operation_id,\n" +
            "dbo.standard_task.project_id,\n" +
            "dbo.standard_task.standard_id,\n" +
            "dbo.eq_info.eq_name,\n" +
            "dbo.standard_task.[date],\n" +
            "dbo.standard_inspection.project_name,\n" +
            "dbo.standard_inspection.type_name,\n" +
            "dbo.project_inspection_operation.operation_name,\n" +
            "dbo.eq_info.eq_bmid,\n" +
            "dbo.s_bm.bm_name,\n" +
            "dbo.standard_task.[operation_date],\n" +
            "dbo.standard_task.operator_number\n" +
            "\n" +
            "FROM\n" +
            "\tdbo.standard_task,\n" +
            "\tdbo.eq_info,\n" +
            "\tdbo.standard_inspection,\n" +
            "\tdbo.project_inspection_operation,\n" +
            "\tdbo.s_bm\n" +
            "WHERE\n" +
            "\tdbo.standard_task.equipment_number = dbo.eq_info.eq_sbbh\n" +
            "AND datediff(\n" +
            "\tday,\n" +
            "\tdbo.standard_task.[date],\n" +
            "\tGETDATE()\n" +
            ") = 0\n" +
            "AND dbo.standard_task.project_id = dbo.standard_inspection.project_id\n" +
            "AND dbo.standard_task.task_result IS NULL\n" +
            "AND dbo.standard_task.operation_id = dbo.project_inspection_operation.operation_id\n" +
            "AND dbo.eq_info.eq_bmid = dbo.s_bm.bm_id\n" +
            "AND dbo.eq_info.eq_sbbh = #{eqSbbh}")
    List<SearchStandardTaskVO> searchTodayUnfinishedStandardTaskByEqSbbh(String eqSbbh);

    @Select("SELECT\n" +
            "\tdbo.eq_info.eq_sbbh,\n" +
            "\tdbo.standard_task.task_id,\n" +
            "\tdbo.standard_task.standard_name,\n" +
            "\tdbo.standard_task.task_result,\n" +
            "\tdbo.standard_task.operation_id,\n" +
            "\tdbo.standard_task.project_id,\n" +
            "\tdbo.standard_task.standard_id,\n" +
            "\tdbo.eq_info.eq_name,\n" +
            "\tdbo.standard_task.[date],\n" +
            "\tdbo.standard_inspection.project_name,\n" +
            "\tdbo.standard_inspection.type_name,\n" +
            "\tdbo.project_inspection_operation.operation_name,\n" +
            "\tdbo.eq_info.eq_bmid,\n" +
            "\tdbo.s_bm.bm_name,\n" +
            "\tdbo.standard_task.operator_number,\n" +
            "\tdbo.standard_task.[operation_date],\n" +
            "\tdbo.s_emp.user_xm\n" +
            "FROM\n" +
            "\tdbo.standard_task,\n" +
            "\tdbo.eq_info,\n" +
            "\tdbo.standard_inspection,\n" +
            "\tdbo.project_inspection_operation,\n" +
            "\tdbo.s_bm,\n" +
            "\tdbo.s_emp\n" +
            "WHERE\n" +
            "\tdbo.standard_task.equipment_number = dbo.eq_info.eq_sbbh\n" +
            "AND datediff(\n" +
            "\tDAY,\n" +
            "\tdbo.standard_task.[date],\n" +
            "\tGETDATE()\n" +
            ") = 0\n" +
            "AND dbo.standard_task.project_id = dbo.standard_inspection.project_id\n" +
            "AND dbo.standard_task.task_result IS NOT NULL\n" +
            "AND dbo.standard_task.operation_id = dbo.project_inspection_operation.operation_id\n" +
            "AND dbo.eq_info.eq_bmid = dbo.s_bm.bm_id\n" +
            "AND dbo.standard_task.operator_number = dbo.s_emp.user_id")
    List<SearchStandardTaskVO> searchTodayFinishedStandardTask();


    @Select("SELECT\n" +
            "\tdbo.eq_info.eq_sbbh,\n" +
            "\tdbo.standard_task.task_id,\n" +
            "\tdbo.standard_task.standard_name,\n" +
            "\tdbo.standard_task.task_result,\n" +
            "\tdbo.standard_task.operation_id,\n" +
            "\tdbo.standard_task.project_id,\n" +
            "\tdbo.standard_task.standard_id,\n" +
            "\tdbo.eq_info.eq_name,\n" +
            "\tdbo.standard_task.[date],\n" +
            "\tdbo.standard_inspection.project_name,\n" +
            "\tdbo.standard_inspection.type_name,\n" +
            "\tdbo.project_inspection_operation.operation_name,\n" +
            "\tdbo.eq_info.eq_bmid,\n" +
            "\tdbo.s_bm.bm_name,\n" +
            "\tdbo.standard_task.operator_number,\n" +
            "\tdbo.standard_task.[operation_date],\n" +
            "\tdbo.s_emp.user_xm\n" +
            "FROM\n" +
            "\tdbo.standard_task,\n" +
            "\tdbo.eq_info,\n" +
            "\tdbo.standard_inspection,\n" +
            "\tdbo.project_inspection_operation,\n" +
            "\tdbo.s_bm,\n" +
            "\tdbo.s_emp\n" +
            "WHERE\n" +
            "\tdbo.standard_task.equipment_number = dbo.eq_info.eq_sbbh\n" +
            "AND datediff(\n" +
            "\tDAY,\n" +
            "\tdbo.standard_task.[date],\n" +
            "\tGETDATE()\n" +
            ") = 0\n" +
            "AND dbo.standard_task.project_id = dbo.standard_inspection.project_id\n" +
            "AND dbo.standard_task.task_result IS NOT NULL\n" +
            "AND dbo.standard_task.operation_id = dbo.project_inspection_operation.operation_id\n" +
            "AND dbo.eq_info.eq_bmid = dbo.s_bm.bm_id\n" +
            "AND dbo.standard_task.operator_number = dbo.s_emp.user_id\n" +
            "AND dbo.eq_info.eq_sbbh = #{eqSbbh}")
    List<SearchStandardTaskVO> searchTodayFinishedStandardTaskByEqSbbh(String eqSbbh);

    @Update("UPDATE standard_task\n" +
            "SET task_result = #{ taskResult }, operation_date = GETDATE(),\n" +
            " operator_number = #{ operatorNumber }\n" +
            "WHERE\n" +
            "\ttask_id = #{ taskId }\n" +
            "AND datediff(\n" +
            "\tDAY,\n" +
            "\tdbo.standard_task.[date],\n" +
            "\tGETDATE ()\n" +
            ") = 0")
    Integer updateStandardTaskResult(Integer taskId, Integer taskResult, String operatorNumber);



    @Select("<script>" +
            "SELECT\n" +
            "\tdbo.eq_info.eq_sbbh,\n" +
            "\tdbo.standard_task.task_id,\n" +
            "\tdbo.standard_task.standard_name,\n" +
            "\tdbo.standard_task.task_result,\n" +
            "\tdbo.standard_task.operation_id,\n" +
            "\tdbo.standard_task.project_id,\n" +
            "\tdbo.standard_task.standard_id,\n" +
            "\tdbo.eq_info.eq_name,\n" +
            "\tdbo.standard_task.[date],\n" +
            "\tdbo.standard_inspection.project_name,\n" +
            "\tdbo.standard_inspection.type_name,\n" +
            "\tdbo.project_inspection_operation.operation_name,\n" +
            "\tdbo.eq_info.eq_bmid,\n" +
            "\tdbo.s_bm.bm_name,\n" +
            "\tdbo.standard_task.[operation_date],\n" +
            "\tdbo.standard_task.operator_number\n" +
            "\n" +
            "    FROM\n" +
            "        dbo.standard_task,\n" +
            "        dbo.eq_info,\n" +
            "        dbo.standard_inspection,\n" +
            "        dbo.project_inspection_operation,\n" +
            "        dbo.s_bm\n" +
            "    WHERE\n" +
            "    dbo.standard_task.equipment_number = dbo.eq_info.eq_sbbh AND\n" +
            "    datediff(\n" +
            "        DAY,\n" +
            "        dbo.standard_task.[date],\n" +
            "        GETDATE()\n" +
            "    ) = 0 AND\n" +
            "    dbo.standard_task.project_id = dbo.standard_inspection.project_id AND\n" +
            "    dbo.standard_task.operation_id = dbo.project_inspection_operation.operation_id AND\n" +
            "    dbo.eq_info.eq_bmid = dbo.s_bm.bm_id\n" +
            "    <if test=\"standardId != null\">\n" +
            "    AND dbo.standard_task.standard_id = #{standardId}\n" +
            "    </if>\n" +
            "    <if test=\"bmId != null and bmId != ''\">\n" +
            "        AND dbo.s_bm.bm_id LIKE CONCAT('%',#{bmId},'%')\n" +
            "    </if>\n" +
            "    <if test=\"eqName != null and eqName != ''\">\n" +
            "    AND dbo.eq_info.eq_name LIKE CONCAT('%',#{eqName},'%')\n" +
            "    </if>\n" +
            "    <if test=\"eqSbbh != null and eqSbbh != ''\">\n" +
            "    AND dbo.eq_info.eq_sbbh LIKE CONCAT('%',#{eqSbbh},'%')\n" +
            "    </if>\n" +
            "    <choose>\n" +
            "        <when test=\"result == 1\">\n" +
            "            AND dbo.standard_task.task_result IS NOT NULL\n" +
            "        </when>\n" +
            "        <otherwise>\n" +
            "            AND dbo.standard_task.task_result IS NULL\n" +
            "        </otherwise>\n" +
            "    </choose>" +
            "</script>")
    List<SearchStandardTaskVO> searchAppointStandardTasks(Integer standardId, String bmId, String eqName, String eqSbbh,Integer result);


    @Select("<script>" +
            "SELECT\n" +
            "\tdbo.eq_info.eq_sbbh,\n" +
            "\tdbo.standard_task.task_id,\n" +
            "\tdbo.standard_task.standard_name,\n" +
            "\tdbo.standard_task.task_result,\n" +
            "\tdbo.standard_task.operation_id,\n" +
            "\tdbo.standard_task.project_id,\n" +
            "\tdbo.standard_task.standard_id,\n" +
            "\tdbo.eq_info.eq_name,\n" +
            "\tdbo.standard_task.[date],\n" +
            "\tdbo.standard_inspection.project_name,\n" +
            "\tdbo.standard_inspection.type_name,\n" +
            "\tdbo.project_inspection_operation.operation_name,\n" +
            "\tdbo.eq_info.eq_bmid,\n" +
            "\tdbo.s_bm.bm_name,\n" +
            "\tdbo.standard_task.[operation_date],\n" +
            "\tdbo.standard_task.operator_number,\n" +
            "\tdbo.s_emp.user_xm\n" +
            "\n" +
            "    FROM\n" +
            "        dbo.standard_task,\n" +
            "        dbo.eq_info,\n" +
            "        dbo.standard_inspection,\n" +
            "        dbo.project_inspection_operation,\n" +
            "        dbo.s_emp,\n" +
            "        dbo.s_bm\n" +
            "    WHERE\n" +
            "    dbo.standard_task.equipment_number = dbo.eq_info.eq_sbbh AND\n" +
            "    dbo.standard_task.operator_number = dbo.s_emp.user_id AND" +
            "    datediff(\n" +
            "        DAY,\n" +
            "        dbo.standard_task.[date],\n" +
            "        GETDATE()\n" +
            "    ) = 0 AND\n" +
            "    dbo.standard_task.project_id = dbo.standard_inspection.project_id AND\n" +
            "    dbo.standard_task.operation_id = dbo.project_inspection_operation.operation_id AND\n" +
            "    dbo.eq_info.eq_bmid = dbo.s_bm.bm_id\n" +
            "    <if test=\"standardId != null\">\n" +
            "    AND dbo.standard_task.standard_id = #{standardId}\n" +
            "    </if>\n" +
            "    <if test=\"bmId != null and bmId != ''\">\n" +
            "        AND dbo.s_bm.bm_id LIKE CONCAT('%',#{bmId},'%')\n" +
            "    </if>\n" +
            "    <if test=\"eqName != null and eqName != ''\">\n" +
            "    AND dbo.eq_info.eq_name LIKE CONCAT('%',#{eqName},'%')\n" +
            "    </if>\n" +
            "    <if test=\"eqSbbh != null and eqSbbh != ''\">\n" +
            "    AND dbo.eq_info.eq_sbbh LIKE CONCAT('%',#{eqSbbh},'%')\n" +
            "    </if>\n" +
            "    <choose>\n" +
            "        <when test=\"result == 1\">\n" +
            "            AND dbo.standard_task.task_result IS NOT NULL\n" +
            "        </when>\n" +
            "        <otherwise>\n" +
            "            AND dbo.standard_task.task_result IS NULL\n" +
            "        </otherwise>\n" +
            "    </choose>" +
            "</script>")
    List<SearchStandardTaskVO> searchAppointFinishedStandardTasks(Integer standardId, String bmId, String eqName, String eqSbbh,Integer result);

    @Select("SELECT\n" +
            "dbo.standards.applicable_equipment,\n" +
            "dbo.eq_info.eq_gg,\n" +
            "dbo.eq_info.eq_xh,\n" +
            "dbo.eq_info.sbcs_id_scs,\n" +
            "dbo.eq_info.eq_sbbh\n" +
            "\n" +
            "FROM\n" +
            "dbo.eq_info ,\n" +
            "dbo.standards\n" +
            "WHERE\n" +
            "dbo.eq_info.eq_sbbh = dbo.standards.equipment_number\n")
    List<SearchStandardEqVo> searchAllStandardEqVos();

    @Select("SELECT DISTINCT\n" +
            "dbo.eq_info.eq_name,\n" +
            "dbo.eq_info.eq_sbbh,\n" +
            "dbo.s_bm.bm_name,\n" +
            "dbo.s_bm.bm_id,\n" +
            "dbo.eq_info.eq_gg,\n" +
            "dbo.eq_info.eq_xh,\n" +
            "dbo.eq_info.eq_pp\n" +
            "\n" +
            "FROM\n" +
            "dbo.eq_info ,\n" +
            "dbo.standard_task ,\n" +
            "dbo.s_bm\n" +
            "WHERE\n" +
            "dbo.eq_info.eq_sbbh = dbo.standard_task.equipment_number AND\n" +
            "dbo.eq_info.eq_bmid = dbo.s_bm.bm_id AND\n" +
            "    datediff(\n" +
            "        DAY,\n" +
            "        dbo.standard_task.[date],\n" +
            "        GETDATE()\n" +
            "    ) = 0 AND\n" +
            "dbo.s_bm.bm_id = #{bmId} AND\n" +
            "dbo.standard_task.task_result IS NULL\n")
    List<TaskEqVo> searchUnFinishedTaskEqs(String bmId);

    @Select("SELECT DISTINCT\n" +
            "dbo.eq_info.eq_name,\n" +
            "dbo.eq_info.eq_sbbh,\n" +
            "dbo.s_bm.bm_name,\n" +
            "dbo.s_bm.bm_id,\n" +
            "dbo.eq_info.eq_gg,\n" +
            "dbo.eq_info.eq_xh,\n" +
            "dbo.eq_info.eq_pp\n" +
            "\n" +
            "FROM\n" +
            "dbo.eq_info ,\n" +
            "dbo.standard_task ,\n" +
            "dbo.s_bm\n" +
            "WHERE\n" +
            "dbo.eq_info.eq_sbbh = dbo.standard_task.equipment_number AND\n" +
            "dbo.eq_info.eq_bmid = dbo.s_bm.bm_id AND\n" +
            "    datediff(\n" +
            "        DAY,\n" +
            "        dbo.standard_task.[date],\n" +
            "        GETDATE()\n" +
            "    ) = 0 AND\n" +
            "dbo.s_bm.bm_id = #{bmId} AND\n" +
            "dbo.standard_task.task_result IS NOT NULL\n")
    List<TaskEqVo> searchFinishedTaskEqs(String bmId);

    @Select("SELECT\n" +
            "\tdbo.eq_info.eq_sbbh,\n" +
            "\tdbo.standard_task.task_id,\n" +
            "\tdbo.standard_task.standard_name,\n" +
            "\tdbo.standard_task.task_result,\n" +
            "\tdbo.standard_task.operation_id,\n" +
            "\tdbo.standard_task.project_id,\n" +
            "\tdbo.standard_task.standard_id,\n" +
            "\tdbo.eq_info.eq_name,\n" +
            "\tdbo.standard_task.[date],\n" +
            "\tdbo.standard_inspection.project_name,\n" +
            "\tdbo.standard_inspection.type_name,\n" +
            "\tdbo.project_inspection_operation.operation_name,\n" +
            "\tdbo.eq_info.eq_bmid,\n" +
            "\tdbo.s_bm.bm_name,\n" +
            "\tdbo.standard_task.[operation_date],\n" +
            "\tdbo.standard_task.operator_number,\n" +
            "\tdbo.s_emp.user_xm\n" +
            "\n" +
            "    FROM\n" +
            "        dbo.standard_task,\n" +
            "        dbo.eq_info,\n" +
            "        dbo.standard_inspection,\n" +
            "        dbo.project_inspection_operation,\n" +
            "        dbo.s_emp,\n" +
            "        dbo.s_bm\n" +
            "    WHERE\n" +
            "    dbo.standard_task.equipment_number = dbo.eq_info.eq_sbbh AND\n" +
            "    dbo.standard_task.operator_number = dbo.s_emp.user_id AND" +
            "    datediff(\n" +
            "        DAY,\n" +
            "        dbo.standard_task.[date],\n" +
            "        GETDATE()\n" +
            "    ) = 0 AND\n" +
            "    dbo.standard_task.project_id = dbo.standard_inspection.project_id AND\n" +
            "    dbo.standard_task.operation_id = dbo.project_inspection_operation.operation_id AND\n" +
            "    dbo.eq_info.eq_bmid = dbo.s_bm.bm_id AND\n" +
            "    dbo.standard_task.equipment_number = #{eqSbbh}\n")
    List<SearchStandardTaskVO> searchEqTask(String eqSbbh);


    @Select("SELECT DISTINCT\n" +
            "dbo.s_bm.bm_id,\n" +
            "dbo.s_bm.bm_name\n" +
            "\n" +
            "FROM\n" +
            "dbo.standard_task,\n" +
            "dbo.s_bm ,\n" +
            "dbo.eq_info\n" +
            "WHERE\n" +
            "dbo.standard_task.equipment_number = dbo.eq_info.eq_sbbh AND\n" +
            "dbo.eq_info.eq_bmid = dbo.s_bm.bm_id AND\n" +
            "DATEDIFF(DAY, standard_task.[date], GETDATE()-1) = 0\n")
    List<BmTaskEqVO> searchAllTaskBm();


    @Select("SELECT\n" +
            "Count(DISTINCT dbo.eq_info.eq_name)\n" +
            "\n" +
            "FROM\n" +
            "dbo.standard_task ,\n" +
            "dbo.s_bm ,\n" +
            "dbo.eq_info\n" +
            "WHERE\n" +
            "dbo.standard_task.equipment_number = dbo.eq_info.eq_sbbh AND\n" +
            "dbo.eq_info.eq_bmid = dbo.s_bm.bm_id AND\n" +
            "DATEDIFF(DAY, standard_task.[date], #{date}) = 0 AND\n" +
            "dbo.s_bm.bm_id = #{bmId}\n" +
            "GROUP BY\n" +
            "dbo.s_bm.bm_name\n")
    Integer searchEqTotal(String bmId, LocalDate date);

    @Select("SELECT\n" +
            "Count(DISTINCT dbo.eq_info.eq_name)\n" +
            "\n" +
            "FROM\n" +
            "dbo.standard_task ,\n" +
            "dbo.s_bm ,\n" +
            "dbo.eq_info\n" +
            "WHERE\n" +
            "dbo.standard_task.equipment_number = dbo.eq_info.eq_sbbh AND\n" +
            "dbo.eq_info.eq_bmid = dbo.s_bm.bm_id AND\n" +
            "DATEDIFF(DAY, standard_task.[date], #{date}) = 0 AND\n" +
            "dbo.standard_task.task_result IS NULL AND\n" +
            "dbo.s_bm.bm_id = #{bmId}\n" +
            "GROUP BY\n" +
            "dbo.s_bm.bm_name\n")
    Integer searchNotDoneEqTotal(String bmId,LocalDate date);
}

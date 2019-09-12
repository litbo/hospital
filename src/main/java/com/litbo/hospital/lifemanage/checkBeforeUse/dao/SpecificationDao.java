package com.litbo.hospital.lifemanage.checkBeforeUse.dao;

import com.litbo.hospital.lifemanage.checkBeforeUse.vo.*;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface SpecificationDao {




    @Select("SELECT\n" +
            "dbo.s_emp.user_id,\n" +
            "dbo.s_emp.bm_id,\n" +
            "dbo.s_bm.bm_name\n" +
            "\n" +
            "FROM\n" +
            "dbo.s_emp ,\n" +
            "dbo.s_bm\n" +
            "WHERE\n" +
            "dbo.s_emp.bm_id = dbo.s_bm.bm_id\n")
    List<UserVo> searchUsers();

    @Select("<script>" +
            "SELECT\n" +
            "        dbo.s_emp.user_id,\n" +
            "        dbo.s_emp.user_xm,\n" +
            "        dbo.s_bm.bm_name\n" +
            "    FROM\n" +
            "        dbo.s_bm,\n" +
            "        dbo.s_emp\n" +
            "    WHERE\n" +
            "        dbo.s_bm.bm_id = dbo.s_emp.bm_id\n" +
            "    <if test=\"userXm!=null\">\n" +
            "        and dbo.s_emp.user_xm = #{userXm}\n" +
            "    </if>\n" +
            "</script>")
    List<UserVo> searchAppointUsers(UserVo userVo);

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
            "      dbo.eq_info.eq_tzlb\n" +
            "    FROM\n" +
            "      dbo.s_bm,\n" +
            "      dbo.eq_info\n" +
            "    WHERE\n" +
            "      dbo.s_bm.bm_id = dbo.eq_info.eq_bmid\n" +
            "    " +
            "        <if test=\"eqSbbh != null\">\n" +
            "            and dbo.eq_info.eq_sbbh = #{eqSbbh}\n" +
            "        </if>\n" +
            "        <if test=\"eqName != null\">\n" +
            "            and dbo.eq_info.eq_name = #{eqName}\n" +
            "        </if>\n" +
            "        <if test=\"pym != null\">\n" +
            "            and dbo.eq_info.eq_pym = #{pym}\n" +
            "        </if>\n" +
            "        <if test=\"bmName != null\">\n" +
            "            and dbo.s_bm.bm_name = #{bmName}\n" +
            "        </if>" +
            "   " +
            "</script>")
    List<EqInfoVO2> searchAppointEqInfos(EqInfoVO2 eqInfoVO2);


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
            "      dbo.standards.[date],\n" +
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
            "AND dbo.standards.standard_id = 7")
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

}

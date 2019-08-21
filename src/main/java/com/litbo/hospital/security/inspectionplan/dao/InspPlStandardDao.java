package com.litbo.hospital.security.inspectionplan.dao;

import com.litbo.hospital.security.inspectionplan.bean.InspEqStandard;
import com.litbo.hospital.security.inspectionplan.bean.example.InspEqStandardExample;
import org.apache.ibatis.annotations.*;

import java.util.List;


/**
 * 巡检计划标准dao
 *
 * @author 10366 2019-07-31 17:22
 **/
@Mapper
public interface InspPlStandardDao {

    /**
     * 查询巡检计划标准根据Id
     * @param
     * @return int
     */
    @Select("<script>select\n"+
            "    insp_pl_standard_id, insp_pl_standard_name, insp_pl_standard_description \n" +
            "    from z_insp_pl_standard\n"+
            "WHERE 1 = 1 \n" +
            "<if test=\"inspPlStandardId != null and inspPlStandardId !=''\">\n" +
            "and insp_pl_standard_id like concat( '%', #{inspPlStandardId}, '%')\n" +
            "</if></script>" )
    InspEqStandard selectStandardById(@Param("inspPlStandardId")String inspPlStandardId);

    /**
     * 功能描述: 添加巡检计划标准
     *
     * @Param: InspEqStandardVo
     * @Return: int
     * @Author: ZYJ
     * @Date: 2019/8/1 0001 9:25
     */
    @Insert("<script>insert into z_insp_pl_standard\n" +
            "    <trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\">\n" +
            "      <if test=\"inspPlStandardId != null\">\n" +
            "        insp_pl_standard_id,\n" +
            "      </if>\n" +
            "      <if test=\"inspPlStandardName != null\">\n" +
            "        insp_pl_standard_name,\n" +
            "      </if>\n" +
            "      <if test=\"inspPlStandardDescriprion != null\">\n" +
            "        insp_pl_standard_description,\n" +
            "      </if>\n" +
            "    </trim>\n" +
            "    <trim prefix=\"values (\" suffix=\")\" suffixOverrides=\",\">\n" +
            "      <if test=\"inspPlStandardId != null\">\n" +
            "        #{inspPlStandardId,jdbcType=VARCHAR},\n" +
            "      </if>\n" +
            "      <if test=\"inspPlStandardName != null\">\n" +
            "        #{inspPlStandardName,jdbcType=VARCHAR},\n" +
            "      </if>\n" +
            "      <if test=\"inspPlStandardDescriprion != null\">\n" +
            "        #{inspPlStandardDescriprion,jdbcType=LONGVARCHAR},\n" +
            "      </if>\n" +
            "    </trim></script>")
    int insertInspStandard(@Param("inspPlStandardId")String inspPlStandardId,
                           @Param("inspPlStandardName")String inspPlStandardName,
                           @Param("inspPlStandardDescriprion")String inspPlStandardDescriprion);

    /**
     * 功能描述: 删除巡检计划标准
     *
     * @Param: inspStandardId
     * @Return: int
     * @Author: ZYJ
     * @Date: 2019/8/1 0001 9:51
     */
    @Delete("delete from z_insp_pl_standard\n" +
            "where insp_pl_standard_id = #{inspPlStandardId,jdbcType=VARCHAR}")
    int deleteInspStandard(@Param("inspPlStandardId") String inspPlStandardId);

    /**
     * 功能描述: 修改巡检计划标准
     *
     * @Param: inspEqStandard
     * @Return: int
     * @Author: ZYJ
     * @Date: 2019/8/1 0001 10:06
     */
    @Update("<script>update z_insp_pl_standard\n" +
            "    <set>\n" +
            "      <if test=\"inspPlStandardName != null\">\n" +
            "        insp_pl_standard_name = #{inspPlStandardName,jdbcType=VARCHAR},\n" +
            "      </if>\n" +
            "      <if test=\"inspPlStandardDescriprion != null\">\n" +
            "        insp_pl_standard_description = #{inspPlStandardDescriprion,jdbcType=LONGVARCHAR},\n" +
            "      </if>\n" +
            "    </set>\n" +
            "    where insp_pl_standard_id = #{inspPlStandardId,jdbcType=VARCHAR}</script>")
    int updateInspStandard(@Param("inspPlStandardName")String inspPlStandardName,
                           @Param("inspPlStandardDescriprion")String inspPlStandardDescriprion,
                           @Param("inspPlStandardId")String inspPlStandardId);


    /**
     * 功能描述:
     *
     * @Param:
     * @Return:
     * @Author: ZYJ
     * @Date: 2019/8/1 0001 14:34
     */
    @Select("<script>select\n"+
            "    insp_pl_standard_id, insp_pl_standard_name, insp_pl_standard_description \n" +
            "    from z_insp_pl_standard\n"+
            "WHERE 1 = 1 \n" +
            "<if test=\"inspPlStandardName != null and inspPlStandardName !=''\">\n" +
            "and insp_pl_standard_name like concat( '%', #{inspPlStandardName}, '%')\n" +
            "</if></script>" )
    List<InspEqStandard> selectInspEqStandard(@Param("inspPlStandardName") String inspPlStandardName);

    @Select("select\n"+
            "    insp_pl_standard_id, insp_pl_standard_name, insp_pl_standard_description \n" +
            "    from z_insp_pl_standard")
    List<InspEqStandard> selectAllInspEqStandard();


}

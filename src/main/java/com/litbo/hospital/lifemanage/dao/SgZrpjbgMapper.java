package com.litbo.hospital.lifemanage.dao;

import com.litbo.hospital.lifemanage.bean.SgZrpjbg;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * 准入评价报告表Mapper类
 */
@Mapper
public interface SgZrpjbgMapper {

    /**
     * 添加准入评价报告信息
     *
     * @param sgZrpjbg 准入评价报告
     */
    @Insert("insert into sg_zrpjbg (pjbg_id, pjbg_dw, pjbg_zbxm, \n" +
            "      pjbg_bmfzr, pjbg_zbdw, pjbg_rq, \n" +
            "      extend_one, extend_two, sg_id)\n" +
            "values (#{pjbgId,jdbcType=VARCHAR}, #{pjbgDw,jdbcType=VARCHAR}, #{pjbgZbxm,jdbcType=VARCHAR}, \n" +
            "      #{pjbgBmfzr,jdbcType=VARCHAR}, #{pjbgZbdw,jdbcType=VARCHAR}, #{pjbgRq,jdbcType=TIMESTAMP}, \n" +
            "      #{extendOne,jdbcType=VARCHAR}, #{extendTwo,jdbcType=VARCHAR},#{sgId,jdbcType=VARCHAR})")
    int insertSgZrpjbg(SgZrpjbg sgZrpjbg);

    /**
     * 根据查到准入评价报告id 更新准入评价报告表信息
     *
     * @param sgZrpjbg 准入评价报告信息
     * @return 更新条数
     */
    @Update("UPDATE sg_zrpjbg \n" +
            "SET pjbg_dw = #{pjbgDw,jdbcType=VARCHAR}, \n" +
            "   pjbg_zbxm = #{pjbgZbxm,jdbcType=VARCHAR}, \n" +
            "   pjbg_bmfzr = #{pjbgBmfzr,jdbcType=VARCHAR},  \n" +
            "   pjbg_zbdw = #{pjbgZbdw,jdbcType=VARCHAR},  \n" +
            "   pjbg_rq = #{pjbgRq,jdbcType=VARCHAR},  \n" +
            "   extend_one = #{extendOne,jdbcType=VARCHAR},  \n" +
            "   extend_two = #{extendTwo,jdbcType=VARCHAR} \n" +
            "WHERE pjbg_id = #{pjbgId,jdbcType=VARCHAR}")
    int updateSgZrpjbgById(SgZrpjbg sgZrpjbg);

    /**
     * 根据申购单id查询准入评价报告信息
     *
     * @param sgInfoId 申购单id
     * @return 评价报告信息
     */
    @Select(" select pjbg_id, " +
            "   pjbg_dw, " +
            "   pjbg_zbxm, " +
            "   pjbg_bmfzr, " +
            "   pjbg_zbdw, " +
            "   pjbg_rq, " +
            "   extend_one, " +
            "   extend_two," +
            "   sg_id" +
            " from sg_zrpjbg " +
            " where sg_id = #{sgInfoId,jdbcType=VARCHAR}")
    SgZrpjbg selectSgZrpjbgBySgInfoId(String sgInfoId);
}
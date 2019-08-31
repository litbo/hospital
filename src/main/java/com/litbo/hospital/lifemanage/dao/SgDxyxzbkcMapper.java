package com.litbo.hospital.lifemanage.dao;

import com.litbo.hospital.lifemanage.bean.SgDxyxzbkc;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * 大型医学装备考察报告表Mapper接口
 */
@Mapper
public interface SgDxyxzbkcMapper {
    /**
     * 添加或更新大型医学装备考察报告信息
     *
     * @param sgDxyxzbkc 大型医学装备考察报告信息
     * @return 添加记录数
     */
    @Insert("insert into sg_dxyxzbkc (dxzb_id, dxzb_sj, extend_one, \n" +
            "      extend_two, dxzb_ddnr, dxzb_yj, sg_id \n" +
            "      )\n" +
            "    values (#{dxzbId,jdbcType=VARCHAR}, #{dxzbSj,jdbcType=TIMESTAMP}, #{extendOne,jdbcType=VARCHAR}, \n" +
            "      #{extendTwo,jdbcType=VARCHAR}, #{dxzbDdnr,jdbcType=LONGVARCHAR}, #{dxzbYj,jdbcType=LONGVARCHAR},\n" +
            "      #{sgId,jdbcType=VARCHAR})")
    int insertSgDxyxzbkc(SgDxyxzbkc sgDxyxzbkc);

    /**
     * 根据主键更新大型医学装备考察报告表信息
     * @param sgDxyxzbkc 大型医学装备考察报告表信息
     * @return 更新记录数
     */
    @Update(" update sg_dxyxzbkc\n" +
            " set dxzb_sj = #{dxzbSj,jdbcType=TIMESTAMP},\n" +
            "   extend_one = #{extendOne,jdbcType=VARCHAR},\n" +
            "   extend_two = #{extendTwo,jdbcType=VARCHAR},\n" +
            "   dxzb_ddnr = #{dxzbDdnr,jdbcType=LONGVARCHAR},\n" +
            "   dxzb_yj = #{dxzbYj,jdbcType=LONGVARCHAR}\n" +
            " where dxzb_id = #{dxzbId,jdbcType=VARCHAR}")
    int updateSgZrpjbgById(SgDxyxzbkc sgDxyxzbkc);

    /**
     * 根据申购单id查询大型医学装备考察报告表信息
     * @param sgInfoId 申购单id
     * @return 型医学装备考察报告表信息
     */
    @Select("select dxzb_id, dxzb_sj, extend_one, extend_two, dxzb_ddnr, dxzb_yj, sg_id \n" +
            "from sg_dxyxzbkc \n" +
            "where sg_id = #{sgInfoId,jdbcType=VARCHAR}")
    SgDxyxzbkc selectSgDxyxzbkcBySgInfoId(String sgInfoId);
}
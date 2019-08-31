package com.litbo.hospital.lifemanage.dao;

import com.litbo.hospital.lifemanage.bean.SgLzfxxhbj;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * 论证分析参考型号及报价表Mapper接口
 */
@Mapper
public interface SgLzfxxhbjMapper {
    /**
     * 添加论证分析参考型号及报价
     * @param sgLzfxxhbj 论证分析参考型号及报价信息
     */
    @Insert("insert into sg_lzfxxhbj (xhbj_id, lzfx_id, sbcs_id, \n" +
            "      xhbj_xh, xhbj_bj, extend_one, \n" +
            "      extend_two, xhbj_jszb)\n" +
            "    values (#{xhbjId,jdbcType=VARCHAR}, #{lzfxId,jdbcType=VARCHAR}, #{sbcsId,jdbcType=INTEGER}, \n" +
            "      #{xhbjXh,jdbcType=VARCHAR}, #{xhbjBj,jdbcType=DECIMAL}, #{extendOne,jdbcType=VARCHAR}, \n" +
            "      #{extendTwo,jdbcType=VARCHAR}, #{xhbjJszb,jdbcType=LONGVARCHAR})")
    int insertSgLzfxxhbj(SgLzfxxhbj sgLzfxxhbj);
}
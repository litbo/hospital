package com.litbo.hospital.lifemanage.dao;

import com.litbo.hospital.lifemanage.bean.SgLzfx;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * 论证分析表Mapper接口
 */
@Mapper
public interface SgLzfxMapper {

    /**
     * 添加论证分析信息
     *
     * @param sgLzfx 论证分析信息
     */
    @Insert("insert into sg_lzfx (lzfx_id, sg_id, lzfx_yldqz, \n" +
            "      lzfx_zjqz, extend_one, extend_two, \n" +
            "      lzfx_lcyqpj, lzfx_jscs, lzfx_shfk, \n" +
            "      lzfx_jspg, lzfx_xxly, lzfx_zjzyj, \n" +
            "      lzfx_yldyj)\n" +
            "    values (#{lzfxId,jdbcType=VARCHAR}, #{sgId,jdbcType=VARCHAR}, #{lzfxYldqz,jdbcType=VARCHAR}, \n" +
            "      #{lzfxZjqz,jdbcType=VARCHAR}, #{extendOne,jdbcType=VARCHAR}, #{extendTwo,jdbcType=VARCHAR}, \n" +
            "      #{lzfxLcyqpj,jdbcType=LONGVARCHAR}, #{lzfxJscs,jdbcType=LONGVARCHAR}, #{lzfxShfk,jdbcType=LONGVARCHAR}, \n" +
            "      #{lzfxJspg,jdbcType=LONGVARCHAR}, #{lzfxXxly,jdbcType=LONGVARCHAR}, #{lzfxZjzyj,jdbcType=LONGVARCHAR}, \n" +
            "      #{lzfxYldyj,jdbcType=LONGVARCHAR})")
    int insertSgLzfx(SgLzfx sgLzfx);
}
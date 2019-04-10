package com.litbo.hospital.lifemanage.dao;

import com.litbo.hospital.lifemanage.bean.SgLzfx;
import com.litbo.hospital.lifemanage.bean.SgLzfxxhbj;
import com.litbo.hospital.lifemanage.bean.vo.SgLzfxVO;
import org.apache.ibatis.annotations.*;

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

    /**
     * 查看论证分析详情
     *
     * @param sgInfoId 申购单id
     * @return SgLzfxVO
     */
    @Results({
            @Result(column = "lzfx_lcyqpj", property = "lzfxLcyqpj"),
            @Result(column = "lzfx_jscs", property = "lzfxJscs"),
            @Result(column = "lzfx_shfk", property = "lzfxShfk"),
            @Result(column = "lzfx_jspg", property = "lzfxJspg"),
            @Result(column = "lzfx_xxly", property = "lzfxXxly"),
            @Result(column = "lzfx_zjzyj", property = "lzfxZjzyj"),
            @Result(column = "lzfx_yldyj", property = "lzfxYldyj"),
            @Result(column = "lzfx_yldqz", property = "lzfxYldqz"),
            @Result(column = "lzfx_zjqz", property = "lzfxZjqz"),
            @Result(column = "bh", property = "bh"),
            @Result(column = "lzfx_id", property = "xhbjs",
                    many = @Many(
                            select = "com.litbo.hospital.lifemanage.dao.SgLzfxMapper.selectSgLzfxxhbj"
                    )
            )
    })
    @Select("SELECT\n" +
            "dbo.sg_lzfx.lzfx_id,\n" +
            "dbo.sg_lzfx.lzfx_lcyqpj,\n" +
            "dbo.sg_lzfx.lzfx_jscs,\n" +
            "dbo.sg_lzfx.lzfx_shfk,\n" +
            "dbo.sg_lzfx.lzfx_jspg,\n" +
            "dbo.sg_lzfx.lzfx_xxly,\n" +
            "dbo.sg_lzfx.lzfx_zjzyj,\n" +
            "dbo.sg_lzfx.lzfx_yldyj,\n" +
            "dbo.sg_lzfx.lzfx_yldqz,\n" +
            "dbo.sg_lzfx.lzfx_zjqz,\n" +
            "dbo.sg_info.bh\n" +
            "FROM\n" +
            "dbo.sg_lzfx\n" +
            "INNER JOIN dbo.sg_info ON dbo.sg_lzfx.sg_id = dbo.sg_info.id\n" +
            "LEFT JOIN dbo.sg_lzfxxhbj ON dbo.sg_lzfx.lzfx_id = dbo.sg_lzfxxhbj.lzfx_id\n" +
            "LEFT JOIN dbo.eq_cs ON dbo.sg_lzfxxhbj.sbcs_id = dbo.eq_cs.sbcs_id\n" +
            "WHERE\n" +
            "dbo.sg_info.id = #{sgInfoId,jdbcType=VARCHAR}")
    SgLzfxVO selectSgLzfx(String sgInfoId);

    @Select("select dbo.sg_lzfxxhbj.xhbj_xh, dbo.sg_lzfxxhbj.xhbj_bj, dbo.eq_cs.sbcs_name\n" +
            "from dbo.sg_lzfxxhbj \n" +
            "LEFT JOIN dbo.eq_cs ON dbo.sg_lzfxxhbj.sbcs_id = dbo.eq_cs.sbcs_id\n" +
            "WHERE lzfx_id = #{lzfxId,jdbcType=VARCHAR}\n")
    SgLzfxxhbj selectSgLzfxxhbj(String lzfxId);
}
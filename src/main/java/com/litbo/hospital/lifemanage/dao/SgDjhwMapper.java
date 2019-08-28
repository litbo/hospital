package com.litbo.hospital.lifemanage.dao;

import com.litbo.hospital.lifemanage.bean.SgDjhw;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

/**
 * 登记货物表Mapper接口
 */

@Mapper
public interface SgDjhwMapper {

    /**
     * 添加登记货物信息
     *
     * @param sgDjhw 登记货物信息
     * @return 添加记录数
     */
    /*如果全部到货添加进登记货物表，否则进记录表*/
    @Insert("insert into sg_djhw (djhw_id, dhdj_id, sg_id, \n" +
            "      djhw_dw, djhw_bzxh, djhw_pp, \n" +
            "      djhw_xnsb, djhw_gg, djhw_xh, \n" +
            "      djhw_sl, djhw_gys, djhw_bz, \n" +
            "      djhw_tj, djhw_bsbq, djhw_hwjz, \n" +
            "      djhw_sccj, djhw_zl, djhw_ysbs, \n" +
            "      user_id, djhw_jssj, djhw_htid, \n" +
            "      djhw_bzwg, djhw_bzimgurls)\n" +
            "    values (#{djhwId,jdbcType=VARCHAR}, #{dhdjId,jdbcType=VARCHAR}, #{sgId,jdbcType=VARCHAR}, \n" +
            "      #{djhwDw,jdbcType=VARCHAR}, #{djhwBzxh,jdbcType=VARCHAR}, #{djhwPp,jdbcType=VARCHAR}, \n" +
            "      #{djhwXnsb,jdbcType=VARCHAR}, #{djhwGg,jdbcType=VARCHAR}, #{djhwXh,jdbcType=VARCHAR}, \n" +
            "      #{djhwSl,jdbcType=INTEGER}, #{djhwGys,jdbcType=VARCHAR}, #{djhwBz,jdbcType=VARCHAR}, \n" +
            "      #{djhwTj,jdbcType=VARCHAR}, #{djhwBsbq,jdbcType=VARCHAR}, #{djhwHwjz,jdbcType=DECIMAL}, \n" +
            "      #{djhwSccj,jdbcType=VARCHAR}, #{djhwZl,jdbcType=VARCHAR}, #{djhwYsbs,jdbcType=VARCHAR}, \n" +
            "      #{userId,jdbcType=VARCHAR}, #{djhwJssj,jdbcType=DATE}, #{djhwHtid,jdbcType=VARCHAR}, \n" +
            "      #{djhwBzwg,jdbcType=VARCHAR}, #{djhwBzimgurls,jdbcType=VARCHAR})\n")
    int insertDjhw(SgDjhw sgDjhw);

    @Insert("insert into sg_djhw_log (djhw_id, dhdj_id, sg_id, \n" +
            "      djhw_dw, djhw_bzxh, djhw_pp, \n" +
            "      djhw_xnsb, djhw_gg, djhw_xh, \n" +
            "      djhw_sl, djhw_gys, djhw_bz, \n" +
            "      djhw_tj, djhw_bsbq, djhw_hwjz, \n" +
            "      djhw_sccj, djhw_zl, djhw_ysbs, \n" +
            "      user_id, djhw_jssj, djhw_htid, \n" +
            "      djhw_bzwg, djhw_bzimgurls)\n" +
            "    values (#{djhwId,jdbcType=VARCHAR}, #{dhdjId,jdbcType=VARCHAR}, #{sgId,jdbcType=VARCHAR}, \n" +
            "      #{djhwDw,jdbcType=VARCHAR}, #{djhwBzxh,jdbcType=VARCHAR}, #{djhwPp,jdbcType=VARCHAR}, \n" +
            "      #{djhwXnsb,jdbcType=VARCHAR}, #{djhwGg,jdbcType=VARCHAR}, #{djhwXh,jdbcType=VARCHAR}, \n" +
            "      #{djhwSl,jdbcType=INTEGER}, #{djhwGys,jdbcType=VARCHAR}, #{djhwBz,jdbcType=VARCHAR}, \n" +
            "      #{djhwTj,jdbcType=VARCHAR}, #{djhwBsbq,jdbcType=VARCHAR}, #{djhwHwjz,jdbcType=DECIMAL}, \n" +
            "      #{djhwSccj,jdbcType=VARCHAR}, #{djhwZl,jdbcType=VARCHAR}, #{djhwYsbs,jdbcType=VARCHAR}, \n" +
            "      #{userId,jdbcType=VARCHAR}, #{djhwJssj,jdbcType=DATE}, #{djhwHtid,jdbcType=VARCHAR}, \n" +
            "      #{djhwBzwg,jdbcType=VARCHAR}, #{djhwBzimgurls,jdbcType=VARCHAR})\n")
    int insertDjhwLog(SgDjhw sgDjhw);

    /**
     * 科室接收
     *
     * @param djhwId 登记货物id
     * @param userId 登陆人id
     * @param date   科室接收时间
     * @return 修改记录数
     */

    @Update("UPDATE sg_djhw SET \n" +
            " user_id = #{userId,jdbcType=VARCHAR},\n" +
            " djhw_jssj = #{date,jdbcType=TIMESTAMP}" +
            " WHERE djhw_id = #{djhwId,jdbcType=VARCHAR} ")
    int updateSgDhdjKsjs(@Param("djhwId") String djhwId, @Param("userId") String userId, @Param("date") Date date);

    /**
     * 科室接收货物详情信息
     * @param djhwId 到货登记id
     * @return SgDjhw
     */

    @Select("SELECT\n" +
            "dbo.sg_djhw.djhw_id,\n" +
            "dbo.sg_djhw.djhw_dw,\n" +
            "dbo.sg_djhw.djhw_bzxh,\n" +
            "dbo.sg_djhw.djhw_pp,\n" +
            "dbo.sg_djhw.djhw_xnsb,\n" +
            "dbo.sg_djhw.djhw_gg,\n" +
            "dbo.sg_djhw.djhw_xh,\n" +
            "dbo.sg_djhw.djhw_sl,\n" +
            "dbo.sg_djhw.djhw_gys,\n" +
            "dbo.sg_djhw.djhw_bz,\n" +
            "dbo.sg_djhw.djhw_tj,\n" +
            "dbo.sg_djhw.djhw_bsbq,\n" +
            "dbo.sg_djhw.djhw_hwjz,\n" +
            "dbo.sg_djhw.djhw_sccj,\n" +
            "dbo.sg_djhw.djhw_zl,\n" +
            "dbo.sg_djhw.djhw_ysbs\n" +
            "FROM \n" +
            "dbo.sg_dhdj\n" +
            "INNER JOIN dbo.sg_djhw ON dbo.sg_dhdj.dhdj_id = dbo.sg_djhw.dhdj_id\n" +
            "WHERE dbo.sg_djhw.djhw_id = #{djhwId,jdbcType=VARCHAR}")
    List<SgDjhw> selectSgDhdjDetails(String djhwId);


    /*根据合同编号查询登记货物里面的货物*/
    @Select("select * from dbo.sg_djhw_log where djhw_htid = #{htid}")
    List<SgDjhw> selectSgDjhwLogByHtid(String htid);
     /*根据登记货物编号查询登记货物记录里面的货物*/
    @Select("select * from dbo.sg_djhw_log where dhdj_id = #{dhdjid}")
    List<SgDjhw> selectSgDjhwLogByDhdjid(String dhdjid);
    /*根据登记货物编号查询登记货物里面的货物*/
    @Select("select * from dbo.sg_djhw where dhdj_id = #{dhdjid}")
    List<SgDjhw> selectSgDjhwByDhdjid(String dhdjid);
    /*根据记录表登记货物的djhw_id查询合同号*/
    @Select("select djhw_htid from sg_djhw_log where djhw_id=#{djhwid}")
     String selectHtIdByDjhwJlid(String djhwid);
}
package com.litbo.hospital.lifemanage.dao;

import com.litbo.hospital.lifemanage.bean.SgYs;
import com.litbo.hospital.lifemanage.bean.vo.SgYsListVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 商务/临床/技术验收表Mapper类
 */
@Mapper
public interface SgYsMapper {
    /**
     * 需验收设备列表
     *
     * @return List<SgYsListVO>
     */
    @Select("SELECT\n" +
            "dbo.sg_djhw.sg_id,\n" +
            "dbo.sg_djhw.djhw_xnsb,\n" +
            "dbo.sg_djhw.djhw_gg,\n" +
            "dbo.sg_djhw.djhw_xh,\n" +
            "dbo.sg_djhw.djhw_sl,\n" +
            "dbo.sg_dhdj.ht_id,\n" +
            "dbo.sg_dhdj.dhsj\n" +
            "FROM\n" +
            "dbo.sg_djhw\n" +
            "INNER JOIN dbo.sg_dhdj ON dbo.sg_djhw.dhdj_id = dbo.sg_dhdj.dhdj_id\n" +
            "WHERE\n" +
            "dbo.sg_djhw.user_id IS NOT NULL AND\n" +
            "dbo.sg_djhw.sg_id NOT IN (SELECT dbo.sg_ys.sg_id FROM dbo.sg_ys)\n" +
            "ORDER BY dbo.sg_dhdj.dhsj DESC")
    List<SgYsListVO> sgYsList();

    /**
     * 添加验收信息
     *
     * @param sgYs 验收信息
     * @return 添加记录数
     */
    @Insert("insert into sg_ys (ys_id, ys_dabh, ht_id,sg_id, \n" +
            "      ys_zzshjg, ys_zzshr, ys_zxd, \n" +
            "      ys_sms, ys_czsc, ys_wxsc, ys_qtjszl, \n" +
            "      ys_cphgzm, ys_bxk, ys_3crz, ys_jlqjrz, \n" +
            "      ys_bgd, ys_jyjyzm, ys_isgfxqx, \n" +
            "      ys_bzbs, ys_bq, ys_gfxsms, ys_hgzm, \n" +
            "      ys_qtcl, ys_syks, ys_sbxh, \n" +
            "      ys_gb, ys_sccs, ys_cd, \n" +
            "      ys_scrq, ys_dj, ys_xlh, \n" +
            "      ys_fjmcxh, ys_fjxlh, ys_ysgcs, \n" +
            "      ys_csgcs, ys_lxdh, ys_xgsxn, \n" +
            "      ys_ysrq, ys_syksfzr, ys_glsyr, \n" +
            "      ys_ksfzr, ys_ysjg, ys_ysqrsj, \n" +
            "      ys_qysj, ys_istg, ys_thh, \n" +
            "      ys_thsj, ys_syqkyj, ys_ysjl, \n" +
            "      ys_czgc, ys_zysx, ys_byzd, \n" +
            "      ys_cpjj, ys_zlkz, ys_thyy\n" +
            "      )\n" +
            "    values (#{ysId,jdbcType=VARCHAR}, #{ysDabh,jdbcType=VARCHAR}, #{htId,jdbcType=VARCHAR},#{sgId,jdbcType=VARCHAR}, \n" +
            "      #{ysZzshjg,jdbcType=CHAR}, #{ysZzshr,jdbcType=VARCHAR}, #{ysZxd,jdbcType=VARCHAR}, \n" +
            "      #{ysSms,jdbcType=CHAR}, #{ysCzsc,jdbcType=CHAR}, #{ysWxsc,jdbcType=CHAR}, #{ysQtjszl,jdbcType=CHAR}, \n" +
            "      #{ysCphgzm,jdbcType=CHAR}, #{ysBxk,jdbcType=CHAR}, #{ys3crz,jdbcType=CHAR}, #{ysJlqjrz,jdbcType=CHAR}, \n" +
            "      #{ysBgd,jdbcType=CHAR}, #{ysJyjyzm,jdbcType=CHAR}, #{ysIsgfxqx,jdbcType=CHAR}, \n" +
            "      #{ysBzbs,jdbcType=CHAR}, #{ysBq,jdbcType=CHAR}, #{ysGfxsms,jdbcType=CHAR}, #{ysHgzm,jdbcType=CHAR}, \n" +
            "      #{ysQtcl,jdbcType=CHAR}, #{ysSyks,jdbcType=VARCHAR}, #{ysSbxh,jdbcType=VARCHAR}, \n" +
            "      #{ysGb,jdbcType=VARCHAR}, #{ysSccs,jdbcType=VARCHAR}, #{ysCd,jdbcType=VARCHAR}, \n" +
            "      #{ysScrq,jdbcType=TIMESTAMP}, #{ysDj,jdbcType=DECIMAL}, #{ysXlh,jdbcType=VARCHAR}, \n" +
            "      #{ysFjmcxh,jdbcType=VARCHAR}, #{ysFjxlh,jdbcType=VARCHAR}, #{ysYsgcs,jdbcType=VARCHAR}, \n" +
            "      #{ysCsgcs,jdbcType=VARCHAR}, #{ysLxdh,jdbcType=VARCHAR}, #{ysXgsxn,jdbcType=VARCHAR}, \n" +
            "      #{ysYsrq,jdbcType=TIMESTAMP}, #{ysSyksfzr,jdbcType=VARCHAR}, #{ysGlsyr,jdbcType=VARCHAR}, \n" +
            "      #{ysKsfzr,jdbcType=VARCHAR}, #{ysYsjg,jdbcType=VARCHAR}, #{ysYsqrsj,jdbcType=TIMESTAMP}, \n" +
            "      #{ysQysj,jdbcType=TIMESTAMP}, #{ysIstg,jdbcType=CHAR}, #{ysThh,jdbcType=CHAR}, \n" +
            "      #{ysThsj,jdbcType=TIMESTAMP}, #{ysSyqkyj,jdbcType=LONGVARCHAR}, #{ysYsjl,jdbcType=LONGVARCHAR}, \n" +
            "      #{ysCzgc,jdbcType=LONGVARCHAR}, #{ysZysx,jdbcType=LONGVARCHAR}, #{ysByzd,jdbcType=LONGVARCHAR}, \n" +
            "      #{ysCpjj,jdbcType=LONGVARCHAR}, #{ysZlkz,jdbcType=LONGVARCHAR}, #{ysThyy,jdbcType=LONGVARCHAR}\n" +
            "      )")
    int insertSgYs(SgYs sgYs);
}
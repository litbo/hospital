package com.litbo.hospital.lifemanage.dao.MyMapper;


import com.litbo.hospital.lifemanage.bean.SgYs;
import com.litbo.hospital.lifemanage.bean.vo.MyVO.SgHzYsVO;
import com.litbo.hospital.lifemanage.bean.vo.MyVO.SgJsYsVO;
import com.litbo.hospital.lifemanage.bean.vo.MyVO.SgLcYsVO;
import com.litbo.hospital.lifemanage.bean.vo.MyVO.SgSwYsVO;
import com.litbo.hospital.lifemanage.bean.vo.SgYsListVO;
import com.litbo.hospital.lifemanage.dao.provider.MyProvider.SgYsProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@SuppressWarnings("ALL")
@Mapper
public interface SgYsMapper2 {
    /**
     * 本科室待商务验收设备查询
     *
     * @return List<SgYsListVO>
     */

    @Select("<script>" +
            " select sg_djhw.djhw_id,sg_djhw.sg_id,\n" +
            " sg_djhw.djhw_xnsb,sg_djhw.djhw_gg,\n" +
            " sg_djhw.djhw_xh,sg_djhw.djhw_sl,\n" +
            " sg_dhdj.ht_id,sg_dhdj.dhsj\n" +
            " from sg_djhw " +
            " INNER JOIN dbo.sg_dhdj " +
            " ON dbo.sg_djhw.dhdj_id = dbo.sg_dhdj.dhdj_id\n" +
            " INNER JOIN sg_info on sg_info.id=sg_djhw.sg_id \n" +
            " inner join s_bm on s_bm.bm_id=sg_info.bm_id\n" +
            " where s_bm.bm_id=#{ksid}\n" +
            " and dbo.sg_djhw.djhw_id not in" +
            " ( select dbo.sg_ys.djhw_id  from  sg_ys " +
            " where dbo.sg_ys.djhw_id !='' and dbo.sg_ys.djhw_id is not null)" +
            " <if test=\" htid != null and htid!=''\">" +
            " and sg_dhdj.ht_id like CONCAT('%',#{htid},'%') " +
            " </if>" +
            " ORDER BY dbo.sg_dhdj.dhsj DESC" +
            " </script>")
    List<SgYsListVO> sgWaitSwYsList(@Param("ksid") String ksid,
                                    @Param("htid") String htid);

    /**插入商务验收情况*/
    @Insert("insert into sg_ys (ys_id,ys_dabh,ht_id,sg_id,ys_zzshjg,ys_zzshr,ys_zxd,ys_sms,ys_czsc," +
            " ys_wxsc,ys_qtjszl,ys_cphgzm,ys_bxk," +
            " ys_3crz,ys_jlqjrz,ys_bgd,ys_jyjyzm,ys_isgfxqx,ys_bzbs," +
            " ys_bq,ys_gfxsms,ys_hgzm,ys_qtcl,djhw_id,ys_sfzj) " +
            " values (#{ysId,jdbcType=VARCHAR},#{ysDabh},#{htId},#{sgId},#{ysZzshjg},#{ysZzshr},#{ysZxd},#{ysSms},#{ysCzsc}," +
            " #{ysWxsc},#{ysQtjszl},#{ysCphgzm},#{ysBxk}," +
            " #{ys3crz},#{ysJlqjrz},#{ysBgd},#{ysJyjyzm},#{ysIsgfxqx},#{ysBzbs},#{ysBq},#{ysGfxsms},#{ysHgzm}," +
            " #{ysQtcl},#{djhwId},#{ysSfzj})")
    int insertSw(SgSwYsVO sw);

    /**本科室待技术验收设备查询*/
    @Select("<script>" +
            "select sg_ys.ys_id, sg_djhw.djhw_id,sg_djhw.sg_id,\n" +
            "sg_djhw.djhw_xnsb,sg_djhw.djhw_gg,\n" +
            "sg_djhw.djhw_xh,sg_djhw.djhw_sl,\n" +
            "sg_dhdj.ht_id,sg_dhdj.dhsj\n" +
            "from sg_djhw INNER JOIN dbo.sg_dhdj\n" +
            " ON dbo.sg_djhw.dhdj_id = dbo.sg_dhdj.dhdj_id\n" +
            "INNER JOIN sg_info on sg_info.id=sg_djhw.sg_id \n" +
            "INNER JOIN sg_ys on sg_ys.djhw_id=sg_djhw.djhw_id\n" +
            "inner join s_bm on s_bm.bm_id=sg_info.bm_id\n" +
            "where s_bm.bm_id=#{ksid}\n" +
            "and sg_ys.ys_ysgcs =''\n" +
            "<if test=\" htid != null and htid!=''\">" +
            "and sg_dhdj.ht_id like CONCAT('%',#{htid},'%') " +
            "</if>" +
            "or sg_ys.ys_csgcs =''\n" +
            "or sg_ys.ys_glsyr=''\n" +
            "or sg_ys.ys_ksfzr=''\n" +
            "or sg_ys.ys_ysgcs is  null\n" +
            "or sg_ys.ys_csgcs is  null\n" +
            "or sg_ys.ys_glsyr is  null\n" +
            "or sg_ys.ys_ksfzr is  null\n" +
            "ORDER BY dbo.sg_dhdj.dhsj DESC" +
            "</script>")
    List<SgYsListVO> sgWaitJsYsList(@Param("ksid") String ksid,
                                    @Param("htid") String htid);

    /**插入技术验收情况*/
    @Update("update sg_ys set ys_syks=#{ysSyks,jdbcType=VARCHAR},ys_sbxh=#{ysSbxh,jdbcType=VARCHAR}" +
            ",ys_gb=#{ysGb,jdbcType=VARCHAR},ys_sccs=#{ysSccs,jdbcType=VARCHAR},ys_cd=#{ysCd,jdbcType=VARCHAR}," +
            " ys_scrq=#{ysScrq,jdbcType=DATE}," +
            "ys_dj=#{ysDj,jdbcType=VARCHAR},ys_xlh=#{ysXlh,jdbcType=VARCHAR},ys_fjmcxh=#{ysFjmcxh,jdbcType=VARCHAR}," +
            "ys_fjxlh=#{ysFjxlh,jdbcType=VARCHAR}" +
            ",ys_ysgcs=#{ysYsgcs,jdbcType=VARCHAR},ys_csgcs=#{ysCsgcs,jdbcType=VARCHAR},ys_lxdh=#{ysLxdh,jdbcType=VARCHAR},ys_xgsxn=#{ysXgsxn,jdbcType=VARCHAR}," +
            "ys_ysrq=#{ysYsrq,jdbcType=DATE},ys_syksfzr=#{ysSyksfzr},ys_ksfzr=#{ysKsfzr}," +
            "ys_ysjl=#{ysYsjl,jdbcType=VARCHAR},ys_glsyr=#{ysGlsyr,jdbcType=VARCHAR} where ys_id=#{ysId}")
    int insertJs(SgJsYsVO js);

    /*本科室待临床验收设备查询*/
    @Select("<script>" +
            "select sg_ys.ys_id, sg_djhw.djhw_id,sg_djhw.sg_id,\n" +
            "sg_djhw.djhw_xnsb,sg_djhw.djhw_gg,\n" +
            "sg_djhw.djhw_xh,sg_djhw.djhw_sl,\n" +
            "sg_dhdj.ht_id,sg_dhdj.dhsj\n" +
            "from sg_djhw INNER JOIN dbo.sg_dhdj\n" +
            " ON dbo.sg_djhw.dhdj_id = dbo.sg_dhdj.dhdj_id\n" +
            "INNER JOIN sg_info on sg_info.id=sg_djhw.sg_id \n" +
            "INNER JOIN sg_ys on sg_ys.djhw_id=sg_djhw.djhw_id\n" +
            "inner join s_bm on s_bm.bm_id=sg_info.bm_id\n" +
            "where s_bm.bm_id=#{ksid}\n" +
            "and sg_ys.ys_syqkyj is null\n " +
//            "or sg_ys.ys_syqkyj like ''\n" +
            "<if test=\" htid != null and htid!=''\">" +
            "and sg_dhdj.ht_id like CONCAT('%',#{htid},'%') " +
            "</if>" +
            "and sg_ys.ys_ysgcs !='' \n" +
            "and sg_ys.ys_csgcs !=''\n" +
            "and sg_ys.ys_glsyr !=''\n" +
            "and sg_ys.ys_ksfzr !=''\n" +
            "and sg_ys.ys_ysgcs is not null\n" +
            "and sg_ys.ys_csgcs is not null\n" +
            "and sg_ys.ys_glsyr is not null\n" +
            "and sg_ys.ys_ksfzr is not null\n" +
            "ORDER BY dbo.sg_dhdj.dhsj DESC" +
            "</script>")
    List<SgYsListVO> sgWaitLcYsList(@Param("ksid") String ksid,
                                    @Param("htid") String htid);

    /*插入临床验收情况*/
    @Update("update  sg_ys set ys_syqkyj=#{ysSyqkyj,jdbcType=VARCHAR} where ys_id=#{ysId}")
    int insertLc(SgLcYsVO lc);

    /*本科室待验收汇总设备查询*/
    @Select("<script>" +
            "select sg_ys.ys_id, sg_djhw.djhw_id,sg_djhw.sg_id,\n" +
            "sg_djhw.djhw_xnsb,sg_djhw.djhw_gg,\n" +
            "sg_djhw.djhw_xh,sg_djhw.djhw_sl,\n" +
            "sg_dhdj.ht_id,sg_dhdj.dhsj\n" +
            "from sg_djhw INNER JOIN dbo.sg_dhdj\n" +
            " ON dbo.sg_djhw.dhdj_id = dbo.sg_dhdj.dhdj_id\n" +
            "INNER JOIN sg_info on sg_info.id=sg_djhw.sg_id \n" +
            "INNER JOIN sg_ys on sg_ys.djhw_id=sg_djhw.djhw_id\n" +
            "inner join s_bm on s_bm.bm_id=sg_info.bm_id\n" +
            "where s_bm.bm_id=#{ksid}\n" +
            "<if test=\" htid != null and htid!=''\">" +
            "and sg_dhdj.ht_id like CONCAT('%',#{htid},'%') " +
            "</if>" +
            "and sg_ys.ys_ysjg is null\n" +
            "and sg_ys.ys_ysqrsj is null\n" +
            "and sg_ys.ys_syqkyj is not null\n" +
            "and sg_ys.ys_syqkyj not like ''\n" +
            "and sg_ys.ys_ysgcs !='' \n" +
            "and sg_ys.ys_csgcs !=''\n" +
            "and sg_ys.ys_glsyr !=''\n" +
            "and sg_ys.ys_ksfzr !=''\n" +
            "and sg_ys.ys_ysgcs is not null\n" +
            "and sg_ys.ys_csgcs is not null\n" +
            "and sg_ys.ys_glsyr is not null\n" +
            "and sg_ys.ys_ksfzr is not null\n" +
            "ORDER BY dbo.sg_dhdj.dhsj DESC" +
            "</script>")
    List<SgYsListVO> sgWaitHzYsList(@Param("ksid") String ksid,
                                    @Param("htid") String htid);

    /*插入验收情况汇总*/
    @Update("update  sg_ys" +
            " set ys_ysjg=#{ysYsjg,jdbcType=VARCHAR}," +
            " ys_ysqrsj=#{ysYsqrsj,jdbcType=DATE},ys_qysj=#{ysQysj,jdbcType=DATE}," +
            "ys_czgc=#{ysCzgc},ys_zysx=#{ysZysx},ys_byzd=#{ysByzd},ys_cpjj=#{ysCpjj},ys_zlkz=#{ysZlkz}," +
            "ys_istg=#{ysIstg,jdbcType=VARCHAR}," +
            " ys_thh=#{ysThh,jdbcType=VARCHAR},ys_thsj=#{ysThsj,jdbcType=DATE},ys_thyy=#{ysThyy,jdbcType=VARCHAR}" +
            " where ys_id=#{ysId}")
    int insertHz(SgHzYsVO hz);

    /* *//*根据主键查询验收记录详情*/
    @SelectProvider(type = SgYsProvider.class, method = "selectByPrimaryKey")
    SgYs selectByPrimaryKey(String ysId);

    /*查看本科室所有商务验收记录*/
    @Select("<script>" +
            "select sg_ys.ys_id, sg_djhw.djhw_id,sg_djhw.sg_id,\n" +
            "sg_djhw.djhw_xnsb,sg_djhw.djhw_gg,\n" +
            "sg_djhw.djhw_xh,sg_djhw.djhw_sl,\n" +
            "sg_dhdj.ht_id,sg_dhdj.dhsj\n" +
            "from sg_djhw INNER JOIN dbo.sg_dhdj\n" +
            " ON dbo.sg_djhw.dhdj_id = dbo.sg_dhdj.dhdj_id\n" +
            "INNER JOIN sg_info on sg_info.id=sg_djhw.sg_id \n" +
            "INNER JOIN sg_ys on sg_ys.djhw_id=sg_djhw.djhw_id\n" +
            "inner join s_bm on s_bm.bm_id=sg_info.bm_id\n" +
            "where s_bm.bm_id=#{ksid}\n" +
            "and sg_ys.ys_zzshr !=''\n" +
            "and sg_ys.ys_zzshr is not null\n" +
            "<if test=\" htid != null and htid!=''\">" +
            "and sg_dhdj.ht_id like CONCAT('%',#{htid},'%') " +
            "</if>" +
            "<if test=\" xnsb != null and xnsb!=''\">" +
            "and sg_djhw.djhw_xnsb like CONCAT('%',#{xnsb},'%') " +
            "</if>" +
            "ORDER BY dbo.sg_dhdj.dhsj DESC" +
            "</script>")
    List<SgYsListVO> sgBenBmSwYsList(@Param("ksid") String ksid,
                                     @Param("htid") String htid,
                                     @Param("xnsb") String xnsb);

    /**查看本科室所有技术验收记录*/
    @Select("<script>" +
            "select sg_ys.ys_id, sg_djhw.djhw_id,sg_djhw.sg_id,\n" +
            "sg_djhw.djhw_xnsb,sg_djhw.djhw_gg,\n" +
            "sg_djhw.djhw_xh,sg_djhw.djhw_sl,\n" +
            "sg_dhdj.ht_id,sg_dhdj.dhsj\n" +
            "from sg_djhw INNER JOIN dbo.sg_dhdj\n" +
            " ON dbo.sg_djhw.dhdj_id = dbo.sg_dhdj.dhdj_id\n" +
            "INNER JOIN sg_info on sg_info.id=sg_djhw.sg_id \n" +
            "INNER JOIN sg_ys on sg_ys.djhw_id=sg_djhw.djhw_id\n" +
            "inner join s_bm on s_bm.bm_id=sg_info.bm_id\n" +
            "where s_bm.bm_id=#{ksid}\n" +
            "and sg_ys.ys_ysgcs !=''\n" +
            "and sg_ys.ys_ysgcs is not null\n" +
            "<if test=\" htid != null and htid!=''\">" +
            "and sg_dhdj.ht_id like CONCAT('%',#{htid},'%') " +
            "</if>" +
            "<if test=\" xnsb != null and xnsb!=''\">" +
            "and sg_djhw.djhw_xnsb like CONCAT('%',#{xnsb},'%') " +
            "</if>" +
            "ORDER BY dbo.sg_dhdj.dhsj DESC" +
            "</script>")
    List<SgYsListVO> sgBenBmJsYsList(@Param("ksid") String ksid,
                                     @Param("htid") String htid,
                                     @Param("xnsb") String xnsb);

    /**查看本科室所有临床验收记录*/
    @Select("<script>" +
            "select sg_ys.ys_id, sg_djhw.djhw_id,sg_djhw.sg_id,\n" +
            "sg_djhw.djhw_xnsb,sg_djhw.djhw_gg,\n" +
            "sg_djhw.djhw_xh,sg_djhw.djhw_sl,\n" +
            "sg_dhdj.ht_id,sg_dhdj.dhsj\n" +
            "from sg_djhw INNER JOIN dbo.sg_dhdj\n" +
            " ON dbo.sg_djhw.dhdj_id = dbo.sg_dhdj.dhdj_id\n" +
            "INNER JOIN sg_info on sg_info.id=sg_djhw.sg_id \n" +
            "INNER JOIN sg_ys on sg_ys.djhw_id=sg_djhw.djhw_id\n" +
            "inner join s_bm on s_bm.bm_id=sg_info.bm_id\n" +
            "where s_bm.bm_id=#{ksid}\n" +
            "and sg_ys.ys_syqkyj is not null\n " +
            "and sg_ys.ys_syqkyj not like ''\n" +
            "<if test=\" htid != null and htid!=''\">" +
            "and sg_dhdj.ht_id like CONCAT('%',#{htid},'%') " +
            "</if>" +
            "<if test=\" xnsb != null and xnsb!=''\">" +
            "and sg_djhw.djhw_xnsb like CONCAT('%',#{xnsb},'%') " +
            "</if>" +
            "ORDER BY dbo.sg_dhdj.dhsj DESC" +
            "</script>")
    List<SgYsListVO> sgBenBmLcYsList(@Param("ksid") String ksid,
                                     @Param("htid") String htid,
                                     @Param("xnsb") String xnsb);

    /**查看本科室所有汇总验收记录*/
    @Select("<script>" +
            "select sg_ys.ys_id, sg_djhw.djhw_id,sg_djhw.sg_id,\n" +
            "sg_djhw.djhw_xnsb,sg_djhw.djhw_gg,\n" +
            "sg_djhw.djhw_xh,sg_djhw.djhw_sl,\n" +
            "sg_dhdj.ht_id,sg_dhdj.dhsj\n" +
            "from sg_djhw INNER JOIN dbo.sg_dhdj\n" +
            " ON dbo.sg_djhw.dhdj_id = dbo.sg_dhdj.dhdj_id\n" +
            "INNER JOIN sg_info on sg_info.id=sg_djhw.sg_id \n" +
            "INNER JOIN sg_ys on sg_ys.djhw_id=sg_djhw.djhw_id\n" +
            "inner join s_bm on s_bm.bm_id=sg_info.bm_id\n" +
            "where s_bm.bm_id=#{ksid}\n" +
            "and sg_ys.ys_ysjg is not null\n " +
            "and sg_ys.ys_ysjg not like ''\n" +
            "and sg_ys.ys_ysqrsj is not null\n" +
            "<if test=\" htid != null and htid!=''\">" +
            "and sg_dhdj.ht_id like CONCAT('%',#{htid},'%') " +
            "</if>" +
            "<if test=\" xnsb != null and xnsb!=''\">" +
            "and sg_djhw.djhw_xnsb like CONCAT('%',#{xnsb},'%') " +
            "</if>" +
            "ORDER BY dbo.sg_dhdj.dhsj DESC" +
            "</script>")
    List<SgYsListVO> sgBenBmHzYsList(@Param("ksid") String ksid,
                                     @Param("htid") String htid,
                                     @Param("xnsb") String xnsb);

    /*查看所有验收记录*/

    @Select("<script>" +
            " SELECT s_bm.bm_id,s_bm.bm_name,sg_ys.ys_id,sg_djhw.djhw_id,sg_dhdj.ht_id,sg_djhw.sg_id,sg_djhw.djhw_xnsb\n" +
            "  ,sg_djhw.djhw_gg,sg_djhw.djhw_xh,sg_djhw.djhw_sl,sg_dhdj.dhsj\n" +
            "  from sg_ys \n" +
            "   INNER JOIN sg_djhw on sg_ys.djhw_id=sg_djhw.djhw_id\n" +
            "   INNER JOIN sg_dhdj on sg_dhdj.dhdj_id=sg_djhw.dhdj_id\n" +
            "    INNER JOIN  sg_info on sg_djhw.sg_id=sg_info.id\n" +
            "  inner join s_bm on s_bm.bm_id is not null \n" +
            " where sg_info.bm_id = s_bm.bm_id" +
            "<if test=\" htid != null and htid!=''\">" +
            "and sg_dhdj.ht_id like CONCAT('%',#{htid},'%') " +
            "</if>" +
            "<if test=\" bmid != null and bmid!=''\">" +
            "and sg_dhdj.ht_id like CONCAT('%',#{htid},'%') " +
            "</if>" +
            " ORDER BY sg_dhdj.dhsj DESC" +
            "</script>")
    List<SgYsListVO> selectAllYsJl(@Param("htid") String htid, @Param("bmid") String bmid);

    /**查询所有科室的科室id和科室名字*/
    @Select("select bm_id,bm_name from s_bm")
    List<Map<String, String>> selectAllBmIdAndName();


}
package com.litbo.hospital.lifemanage.dao.MyMapper;


import com.litbo.hospital.lifemanage.bean.MyBean.CzGc;
import com.litbo.hospital.lifemanage.bean.vo.MyVO.CzGcShowEqVO;
import com.litbo.hospital.lifemanage.bean.vo.MyVO.CzGcVO;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface CzGcMapper {

    /*查询所有待审核操作规程*/
    @Select("<script>" +
            "select id,cz_gc_mc,cz_gc_lb,cz_gc_zys,cz_gc_bbh,cz_gc_ngr,cz_gc_ngrq\n" +
            "from cz_gc\n" +
            "<where>" +
            " ((cz_gc_shr is null and cz_gc_shrq is null)\n" +
            "or\n" +
            " (cz_gc_zpjsqr is not null and  cz_gc_zpj_sqrq is " +
            " not null and cz_gc_zpj_shr is null and cz_gc_zpj_shjg is null " +
            " and cz_gc_shr is not null and cz_gc_shrq is not null))\n" +
            "<if test=\"bh != null and bh !='' \">" +
            " and id like CONCAT('%',#{bh},'%')\n" +
            "</if>" +
            "<if test=\" mc!=null and mc!='' \">" +
            " and cz_gc_mc like CONCAT('%',#{mc},'%')\n" +
            "</if>" +
            "<if test=\"ngr!=null and ngr!='' \">" +
            " and cz_gc_ngr like CONCAT('%',#{ngr},'%')\n" +
            "</if>" +
            "<if test=\"qssj!=null \">" +
            " and cz_gc_ngrq &gt;=#{qssj}\n" +
            "</if>" +
            "<if test=\"jssj!=null \">" +
            " and cz_gc_ngrq &lt;=#{jssj}\n" +
            "</if>" +
            "</where>" +
            "</script>")
    List<CzGc> AllDshCzgc(@Param("bh") String bh, @Param("mc") String mc, @Param("ngr") String ngr, @Param("qssj") Date qssj, @Param("jssj") Date jssj);

    /*操作规程录入*/
    @Insert("  insert into cz_gc (id, eq_sbbh, cz_gc_mc, \n" +
            "      gc_url, cz_gc_nr, cz_gc_ngr, \n" +
            "      cz_gc_ngrq, cz_gc_shr, cz_gc_shrq, \n" +
            "      cz_gc_shyj, cz_gc_lb, cz_gc_zys, \n" +
            "      bm_id, cz_gc_bbh, cz_gc_zpjsqr, \n" +
            "      cz_gc_zpj_sqrq, cz_gc_zpj_shr, cz_gc_sxrq, \n" +
            "      cz_gc_zt, cz_gc_zps_shrq, cz_gc_zpjyy, \n" +
            "      cz_gc_zpj_shjg, cz_gc_nrdxg, cz_gc_zysdxg, \n" +
            "      cz_gc_bbhdxg, cz_gc_syts, cz_gc_bakssj, \n" +
            "      cz_gc_qykssj, cz_gc_zpj_shyj)\n" +
            "    values (#{id,jdbcType=VARCHAR}, #{eqSbbh,jdbcType=VARCHAR}, #{czGcMc,jdbcType=VARCHAR}, \n" +
            "      #{gcUrl,jdbcType=VARCHAR}, #{czGcNr,jdbcType=VARCHAR}, #{czGcNgr,jdbcType=VARCHAR}, \n" +
            "      #{czGcNgrq,jdbcType=DATE}, #{czGcShr,jdbcType=VARCHAR}, #{czGcShrq,jdbcType=DATE}, \n" +
            "      #{czGcShyj,jdbcType=VARCHAR}, #{czGcLb,jdbcType=VARCHAR}, #{czGcZys,jdbcType=VARCHAR}, \n" +
            "      #{bmId,jdbcType=VARCHAR}, #{czGcBbh,jdbcType=VARCHAR}, #{czGcZpjsqr,jdbcType=VARCHAR}, \n" +
            "      #{czGcZpjSqrq,jdbcType=DATE}, #{czGcZpjShr,jdbcType=VARCHAR}, #{czGcSxrq,jdbcType=DATE}, \n" +
            "      #{czGcZt,jdbcType=VARCHAR}, #{czGcZpsShrq,jdbcType=DATE}, #{czGcZpjyy,jdbcType=VARCHAR}, \n" +
            "      #{czGcZpjShjg,jdbcType=VARCHAR}, #{czGcNrdxg,jdbcType=VARCHAR}, #{czGcZysdxg,jdbcType=VARCHAR}, \n" +
            "      #{czGcBbhdxg,jdbcType=VARCHAR}, #{czGcSyts,jdbcType=INTEGER}, #{czGcBakssj,jdbcType=DATE}, \n" +
            "      #{czGcQykssj,jdbcType=DATE}, #{czGcZpjShyj,jdbcType=LONGVARCHAR})")
    int insertCzgc(CzGc gc);

    /*修改*/
    @Update(" update cz_gc\n" +
            "    set eq_sbbh = #{eqSbbh,jdbcType=VARCHAR},\n" +
            "      cz_gc_mc = #{czGcMc,jdbcType=VARCHAR},\n" +
            "      gc_url = #{gcUrl,jdbcType=VARCHAR},\n" +
            "      cz_gc_nr = #{czGcNr,jdbcType=VARCHAR},\n" +
            "      cz_gc_ngr = #{czGcNgr,jdbcType=VARCHAR},\n" +
            "      cz_gc_ngrq = #{czGcNgrq,jdbcType=DATE},\n" +
            "      cz_gc_shr = #{czGcShr,jdbcType=VARCHAR},\n" +
            "      cz_gc_shrq = #{czGcShrq,jdbcType=DATE},\n" +
            "      cz_gc_shyj = #{czGcShyj,jdbcType=VARCHAR},\n" +
            "      cz_gc_lb = #{czGcLb,jdbcType=VARCHAR},\n" +
            "      cz_gc_zys = #{czGcZys,jdbcType=VARCHAR},\n" +
            "      bm_id = #{bmId,jdbcType=VARCHAR},\n" +
            "      cz_gc_bbh = #{czGcBbh,jdbcType=VARCHAR},\n" +
            "      cz_gc_zpjsqr = #{czGcZpjsqr,jdbcType=VARCHAR},\n" +
            "      cz_gc_zpj_sqrq = #{czGcZpjSqrq,jdbcType=DATE},\n" +
            "      cz_gc_zpj_shr = #{czGcZpjShr,jdbcType=VARCHAR},\n" +
            "      cz_gc_sxrq = #{czGcSxrq,jdbcType=DATE},\n" +
            "      cz_gc_zt = #{czGcZt,jdbcType=VARCHAR},\n" +
            "      cz_gc_zps_shrq = #{czGcZpsShrq,jdbcType=DATE},\n" +
            "      cz_gc_zpjyy = #{czGcZpjyy,jdbcType=VARCHAR},\n" +
            "      cz_gc_zpj_shjg = #{czGcZpjShjg,jdbcType=VARCHAR},\n" +
            "      cz_gc_nrdxg = #{czGcNrdxg,jdbcType=VARCHAR},\n" +
            "      cz_gc_zysdxg = #{czGcZysdxg,jdbcType=VARCHAR},\n" +
            "      cz_gc_bbhdxg = #{czGcBbhdxg,jdbcType=VARCHAR},\n" +
            "      cz_gc_zpj_shyj = #{czGcZpjShyj,jdbcType=VARCHAR}"+
            "      cz_gc_syts = #{czGcSyts,jdbcType=INTEGER},\n" +
            "      cz_gc_bakssj = #{czGcBakssj,jdbcType=DATE},\n" +
            "      cz_gc_qykssj = #{czGcQykssj,jdbcType=DATE}\n" +
            "    where id = #{id,jdbcType=VARCHAR}")
    int updateOneCzgc(CzGc gc);

    /*弃用*/
    @Update("update cz_gc set cz_gc_zt ='0' where id=#{id}")
    int updateCzgcZt(String id);

    /*统计查询*/
    @Select("<script>" +
            "select cz_gc_zt,id,cz_gc_mc,cz_gc_ngr,cz_gc_shr,cz_gc_shrq,cz_gc_zpjjd from cz_gc\n" +
            "<where>" +
            " cz_gc_shr is not null and cz_gc_shrq is not null\n"+
            "<if test=\" zt!=null and zt!='' \">" +
            " and cz_gc_zt=#{zt}\n"+
            "</if>" +
            "<if test=\"qssj !=null\">" +
            "and cz_gc_shrq &gt;= #{qssj}\n " +
            "</if>" +
            "<if test=\"jssj!=null\">" +
            "and cz_gc_shrq &lt;= #{jssj}\n " +
            "</if>" +
            "<if test=\"bh != null and bh!=''\">" +
            "and id like CONCAT('%',#{bh},'%')\n " +
            "</if>" +
            "<if test=\"mc!=null and mc!=''\">" +
            "and cz_gc_mc like CONCAT('%',#{mc},'%')\n " +
            "</if>" +
            "</where>" +
            "</script>")
    List<CzGc> Tjcx(@Param("zt") String zt, @Param("qssj") Date qssj, @Param("jssj") Date jssj, @Param("bh") String bh, @Param("mc") String mc);

    /*查看单条操作规程详情*/
    @Select("select * from cz_gc where id=#{id}")
    CzGcVO selectOneCzgc(String id);

    /*根据设备编号查询设备信息*/
    @Select("select e.eq_sbbh,ep.eq_pm_name,e.eq_name,e.eq_pp,e.eq_gg,e.eq_xh\n" +
            "from eq_info e inner join eq_pm ep on\n" +
            "e.eq_pm_id=ep.eq_pm_id where e.eq_sbbh=#{sbbh} ")
    CzGcShowEqVO selectEqBySbbh(String sbbh);

    /*选择设备*/
    @Select("<script>" +
            "select e.eq_sbbh,ep.eq_pm_name,e.eq_name,e.eq_pp,e.eq_gg,e.eq_xh\n" +
            "from eq_info e inner join eq_pm ep on\n" +
            "e.eq_pm_id=ep.eq_pm_id\n" +
            "<if test=\" eqName!=null and eqName!='' \">" +
            " where eqName like CONCAT('%',#{eqName},'%')\n" +
            "</if>" +
            "</script> ")
    List<CzGcShowEqVO> selectAllEqInfo(@Param("eqName") String eqName);


}
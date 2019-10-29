package com.litbo.hospital.security.dao;

import com.litbo.hospital.security.vo.*;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PxDao {

//    @Results(
//            @Result(property = "eqName",column = "eq_pm_name")
//    )
    @Select("SELECT eq_id,eq_name,eq_zcbh,eq_sbbh FROM eq_info")
    List<YyPxJhFzVo> getYypxNr();

    @Select("SELECT bm_id AS bmId,bm_name AS pxks FROM dbo.s_bm")
    List<KsFzVo> getYypxKsNr();

    @Select("SELECT y.id,e.eq_name,y.pxnrlb,y.pxlx,y.pxfs,s.bm_name AS pxks,\n" +
            "            y.kstime,y.jstime FROM jh_yypx AS y\n" +
            "            JOIN s_bm AS s ON y.ks_id = s.bm_id\t\t\t\t\t\n" +
            "            JOIN eq_info AS e ON e.eq_id=y.eq_id")
    List<ListYyPxJhVo> findAllYyJh();


//    @Select("SELECT y.id,y.pxnrlb,y.pxlx,y.pxfs,s.bm_name AS pxks,\n" +
//            "            y.kstime,y.jstime FROM jh_yypx AS y\n" +
//            "            JOIN s_bm AS s ON y.ks_id = s.bm_id\n")
//    List<ListYyPxJhVo> findAllYyJh();

    @Insert("INSERT INTO jh_zd (id,jh_name,zbdw,jh_kstime,jh_jstime,jh_pxlx,jh_pxxz,jh_pxnrlb,\n" +
            "user_id,px_addr, \n" +
            "px_nr,jh_pxbh)\n" +
            "VALUES (#{id,jdbcType=VARCHAR},#{jhName,jdbcType=VARCHAR},#{zbdw,jdbcType=VARCHAR}, \n" +
            "#{jhKstime},#{jhJstime},#{jhPxlx,jdbcType=VARCHAR}, \n" +
            "#{jhPxxz,jdbcType=VARCHAR}, #{jhPxnrlb,jdbcType=VARCHAR},\n" +
            "#{userId,jdbcType=VARCHAR},#{pxAddr,jdbcType=VARCHAR}, \n" +
            "#{pxNr,jdbcType=VARCHAR}" +
            ",#{jhPxbh,jdbcType=VARCHAR})")
    Integer addRypxjh(RyPxJhVo ryPxJhVo);

    @Insert("INSERT INTO jh_yypx (id,eq_id,eq_zcbh,eq_sbbh,pxbh,pxfs,pxlx" +
            ",ks_id,pxnrlb,pxnr,kstime,jstime)\n" +
            "VALUES (#{id,jdbcType=VARCHAR},#{eqId},#{eqZcbh},\n" +
            "#{eqSbbh},#{pxbh},#{pxfs},\n" +
            "#{pxlx},#{ksId},#{pxnrlb},\n" +
            "#{pxnr}," +
            "#{kstime},#{jstime})")
    Integer addYypxjh(YyPxJhVo yyPxJhVo);
}

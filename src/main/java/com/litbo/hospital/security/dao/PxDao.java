package com.litbo.hospital.security.dao;

import com.litbo.hospital.security.vo.*;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PxDao {

    @Select("SELECT i.eq_id,e.eq_pm_name,i.eq_zcbh,i.eq_sbbh from eq_pm AS e JOIN eq_info AS i ON e.eq_pm_id=i.eq_pm_id")
    @Results(
            @Result(property = "eqName",column = "eq_pm_name")
    )
    List<YyPxJhFzVo> getYypxNr();

    @Select("SELECT bm_id as bmId,bm_name AS pxks FROM dbo.s_bm")
    List<BmVo> getYypxKsNr();

    @Select("SELECT y.id,e.eq_pm_name,y.pxlx,y.pxfs,s.bm_name," +
            "y.kstime,y.jstime FROM jh_yypx AS y " +
            "INNER JOIN s_bm AS s ON y.ks_id = s.bm_id " +
            "INNER JOIN eq_info AS e ON y.eq_id = e.e.eq_pm_id")
    List<ListYyVo> findAllYyJh();

    @Insert("INSERT INTO jh_zd (jh_name,zbdw,jh_kstime,jh_jstime,jh_pxlx,\n" +
            "jh_pxxz, jh_pxnrlb, \n" +
            "user_id,px_addr, \n" +
            "px_nr,jh_pxbh)\n" +
            "VALUES (#{jhName}, #{zbdw}, \n" +
            "#{jhKstime}, #{jhJstime},#{jhPxlx}, \n" +
            "#{jhPxxz}, #{jhPxnrlb},\n" +
            "#{userId}, #{pxAddr}, \n" +
            "#{pxNr}]" +
            ",#{jhPxbh})")
    Integer addRypxjh(RyPxJhVo ryPxJhVo);

    @Insert("INSERT INTO jh_yypx (eq_name, eq_zcbh,eq_sbbh,pxbh,pxfs,pxlx" +
            ",pxks,pxnr,kstime,jstime)\n" +
            "VALUES (#{eqName}, #{eqZcbh}, \n" +
            "#{eqSbbh}, #{pxbh},#{pxfs}, \n" +
            "#{pxlx}, #{pxks},\n" +
            "#{pxnr}, \n" +
            "#{kstime},#{jstime})")
    Integer addYypxjh(YyPxJhVo yyPxJhVo);
}

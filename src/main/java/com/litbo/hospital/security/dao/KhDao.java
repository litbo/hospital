package com.litbo.hospital.security.dao;


import com.litbo.hospital.security.vo.*;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface KhDao {

    @Select("SELECT bm_name,user_id AS userId,user_name AS userName FROM jh_tjry WHERE jh_id = #{id} " +
            "AND user_name NOT IN (SELECT user_name FROM jh_khlr WHERE jh_id = #{id})")
    List<KhVo> kh(@Param("id") String id);

    @Insert({
            "INSERT INTO dbo.jh_lv(id,pxl,khhgl,jh_id) " +
                    "VALUES(#{id},#{pxl},#{khhgl},#{jh_id})"
    })
    void insertLv(@Param("id") String id,@Param("khhgl") String khhgl,@Param("pxl") String pxl,@Param("jh_id") String jh_id);

    @Update({"<script>",
            "UPDATE dbo.jh_lv",
            "  <set>",
            "    <if test='pxl != null'>pxl=#{pxl},</if>",
            "    <if test='khhgl != null'>khhgl=#{khhgl}</if>",
            "  </set>",
            "  WHERE jh_id=#{jh_id}",
            "</script>"})
    void updateLv(@Param("pxl") String pxl,@Param("khhgl") String khhgl,@Param("jh_id") String jh_id);

    @Select( "SELECT pxl,khhgl FROM dbo.jh_lv WHERE jh_id = #{jh_id}")
    LvJcVos getPxlAndKhl(String jh_id);

    @Insert({
            "INSERT INTO jh_khlr(id,bm_name,user_name,pxjg,llcj,sjcz,khjg,pxry,ksry,khry,pjyj,jh_id)" +
             "VALUES(#{id,jdbcType=VARCHAR},#{bmName,jdbcType=VARCHAR},#{userName,jdbcType=VARCHAR},#{pxjg,jdbcType=VARCHAR}," +
                    "#{llcj,jdbcType=VARCHAR},#{sjcz,jdbcType=VARCHAR},#{khjg,jdbcType=VARCHAR}" +
                    ",#{pxry,jdbcType=VARCHAR},#{ksry,jdbcType=VARCHAR},#{khry,jdbcType=VARCHAR}," +
                    "#{pjyj,jdbcType=VARCHAR},#{jhId,jdbcType=VARCHAR})"
    })
    boolean khBc(KhZxinxiVo ks);

    @Select({
            "SELECT \n" +
            "  SUM(CASE khjg WHEN '合格' THEN 1 ELSE 0 END) AS \"jige\"    \n" +
            "FROM dbo.jh_khlr WHERE jh_id=#{id}"
    })
    ListJiGeVo findByKhjgJg(String id);

    @Select({
            "SELECT \n" +
            "   SUM(CASE pxjg WHEN '是' THEN 1 ELSE 0 END) AS \"canjia\"    \n" +
            "FROM dbo.jh_khlr WHERE jh_id=#{id}"
    })
    ListCanJiaVo findByPxjgIs(String id);

    @Select({
            "SELECT count(user_name) AS sumRen FROM dbo.jh_tjry " +
            "WHERE jh_id=#{id}"
    })
    ListSumRenVo findsumRen(String id);

    @Select({
            "SELECT y.id,e.eq_name AS eqName,y.pxnrlb,y.pxlx,y.pxfs,l.pxl,l.khhgl\n" +
            "FROM jh_yypx AS y \n" +
            "INNER JOIN jh_lv AS l ON y.id=l.jh_id\n" +
            "INNER JOIN eq_info AS e ON y.eq_id=e.eq_id\n" +
            "WHERE l.pxl IS NOT NULL AND l.khhgl IS NOT NULL"
    })
    List<ListCheckLvVos> findInfo();

    @Select({
        "SELECT \n" +
                "     SUM(CASE khjg WHEN '合格' THEN 1 ELSE 0 END) AS 'HgNum',\n" +
                "\t\t SUM(CASE pxjg WHEN '是' THEN 1 ELSE 0 END) AS 'SdNum',\n" +
                "\t\t SUM(CASE pxjg WHEN '否' THEN 1 ELSE 0 END) AS 'WdNum',\n" +
                "\t\t SUM(CASE pxjg WHEN '否' THEN 1 ELSE 0 END) + SUM(CASE pxjg WHEN '是' THEN 1 ELSE 0 END) AS 'YdNum'\n" +
          "FROM dbo.jh_khlr WHERE jh_id = #{id}"
    })
    NumVos getNum(String id);

    @Select({"SELECT bm_name,user_name FROM dbo.jh_tjry WHERE jh_id = #{id}"})
    List<RenYuanVo> getYdRen(@Param("id") String id);

    @Select({
            "SELECT bm_name,user_name FROM jh_khlr WHERE khjg = '合格' AND jh_id=#{id}"
    })
    List<RenYuanVo> getHgRen(@Param("id") String id);

    @Select({
            "SELECT bm_name,user_name FROM jh_khlr WHERE pxjg = '是' AND jh_id=#{id}"
    })
    List<RenYuanVo> getSdRen(@Param("id") String id);

    @Select({
            "SELECT bm_name,user_name FROM jh_khlr WHERE pxjg != '是' AND jh_id=#{id}"
    })
    List<RenYuanVo> getWdRen(@Param("id") String id);

    @Select({
            "SELECT bm_name,user_name FROM jh_khlr WHERE khjg = '及格' AND jh_id=#{id}"
    })
    List<RenYuanVo> getKhTgRen(@Param("id") String id);
}

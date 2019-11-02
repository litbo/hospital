package com.litbo.hospital.security.dao;

import com.litbo.hospital.security.vo.*;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PxDelAndSelDao {

    @Delete("<script>DELETE FROM jh_yypx WHERE id IN <foreach item='item' index='index' " +
            "collection='array' open='(' separator=',' close=')'>" +
            "#{item}</foreach></script>")
    Integer DelYyjh(String [] strs);

    @Select("SELECT y.id,e.eq_name,y.pxnrlb,y.pxlx,y.pxfs,s.bm_name AS pxks,\n" +
            "            y.kstime,y.jstime FROM jh_yypx AS y\n" +
            "            JOIN s_bm AS s ON y.ks_id = s.bm_id\t\t\t\t\t\n" +
            "            JOIN eq_info AS e ON e.eq_id=y.eq_id WHERE e.eq_name LIKE '%${name}%'")
    List<ListYyPxJhVo> selYyJh(@Param("name") String name);

    @Select("SELECT e.user_id,e.user_xm AS userName,s.bm_name\n" +
            "FROM dbo.s_emp AS e INNER JOIN dbo.s_bm AS s ON e.bm_id=s.bm_id " +
            "WHERE e.user_id NOT IN (SELECT user_id FROM dbo.jh_tjry WHERE jh_id = #{id})")
    List<EmpVo> getRyBtNr(@Param("id") String id);

    @Insert("INSERT INTO jh_tjry(tjry_id,user_name,bm_name,user_id,jh_id) VALUES (#{tjryId,jdbcType=VARCHAR}," +
            "#{userName,jdbcType=VARCHAR},#{bmName,jdbcType=VARCHAR},#{userId,jdbcType=INTEGER},#{jhId,jdbcType=VARCHAR})")
    Integer insertRy(TjRyVo tjRyVo);

    @Select("SELECT bm_name AS bmName,user_id AS userId,user_name AS userName FROM jh_tjry")
    List<TjRyVo> selectRy();

//    @Select("SELECT DISTINCT user_id AS userId,bm_name AS bmName,user_name AS userName " +
//            "FROM jh_tjry WHERE jh_id = #{id}")
//    List<TjRyVo> findAllRy(@Param("id") String id);

    @Select({"SELECT DISTINCT j.user_id AS userId,j.bm_name AS bmName,\n" +
            " j.user_name AS userName FROM jh_tjry AS j\n" +
            " WHERE jh_id = #{id}"})
    List<XqZsVo> findAllRy(@Param("id") String id);

    @Select({
            "SELECT e.eq_name,j.kstime AS kstime,j.jstime AS jstime FROM jh_yypx AS j \n" +
                    "INNER JOIN eq_info AS e ON j.eq_id = e.eq_id \n" +
                    "WHERE id = #{id}"
    })
    DsVo findN(@Param("id") String id);

    @Select("SELECT e.user_id,e.user_xm AS userName,s.bm_name\n" +
            "FROM dbo.s_emp AS e INNER JOIN dbo.s_bm AS s ON e.bm_id=s.bm_id " +
            "WHERE e.user_id NOT IN (SELECT user_id FROM dbo.jh_tjry WHERE jh_id = #{id}) " +
            "AND s.bm_name LIKE '%${rName}%'")
    List<TjRyVo> selByName(@Param("rName") String rName,@Param("id") String id);

}
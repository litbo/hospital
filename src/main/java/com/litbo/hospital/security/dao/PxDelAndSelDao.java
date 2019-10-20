package com.litbo.hospital.security.dao;

import com.litbo.hospital.security.vo.EmpVo;
import com.litbo.hospital.security.vo.ListRyPxJhVo;
import com.litbo.hospital.security.vo.ListYyVo;
import com.litbo.hospital.security.vo.TjRyVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PxDelAndSelDao {
    @Delete("<script>DELETE FROM jh_yypx WHERE id IN <foreach item='item' index='index' " +
            "collection='array' open='(' separator=',' close=')'>" +
            "#{item}</foreach></script>")
    Integer DelRyjh();

    @Delete("<script>DELETE FROM jh_zd WHERE id IN <foreach item='item' index='index' " +
            "collection='array' open='(' separator=',' close=')'>" +
            "#{item}</foreach></script>")
    Integer DelYyjh();

    @Select("SELECT id,jh_name AS jhName,px_addr AS pxAddr," +
            "jh_pxlx AS jhPxlx,jh_pxxz AS jhPxxz,user_id AS userId" +
            ",jh_kstime AS jhKstime,jh_jstime AS jhJstime FROM dbo.jh_zd WHERE jh_name LIKE '%${name}%'")
    List<ListRyPxJhVo> selRyjh(@Param("name") String name);

    @Select("SELECT y.id,e.eq_name,y.pxnrlb,y.pxlx,y.pxfs,s.bm_name,\n" +
            "            y.kstime,y.jstime FROM jh_yypx AS y\n" +
            "            JOIN s_bm AS s ON y.ks_id = s.bm_id\t\t\t\t\t\n" +
            "            JOIN eq_info AS e ON e.eq_id=y.eq_id WHERE e.eq_name LIKE '%${eqName}%'")
    List<ListYyVo> selYyJh(@Param("eqName") String eqName);

    @Select("SELECT e.user_id,e.user_xm AS userName,s.bm_name\n" +
            "FROM dbo.s_emp AS e INNER JOIN dbo.s_bm AS s ON e.bm_id=s.bm_id")
    List<EmpVo> getRyBtNr();

    @Insert("INSERT INTO jh_tjry(tjry_id,user_name,bm_name,user_id) VALUES (#{tjryId,jdbcType=VARCHAR}," +
            "#{userName,jdbcType=VARCHAR},#{bmName,jdbcType=VARCHAR},#{userId,jdbcType=INTEGER})")
    Integer insertRy(TjRyVo tjRyVo);

    @Select("SELECT bm_name AS bmName,user_id AS userId,user_name AS userName FROM jh_tjry")
    List<TjRyVo> selectRy();

}
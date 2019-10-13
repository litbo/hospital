package com.litbo.hospital.security.dao;

import com.litbo.hospital.security.vo.BmVo;
import com.litbo.hospital.security.vo.RyPxJhVo;
import com.litbo.hospital.security.vo.YyPxJhVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PxDao {

    @Select("SELECT e.eq_pm_name,i.eq_zcbh,i.eq_sbbh from eq_pm AS e JOIN eq_info AS i ON e.eq_pm_id=i.eq_pm_id")
    @Results(
            @Result(property = "eqName",column = "eq_pm_name")
    )
    List<YyPxJhVo> getYypxNr();

    @Select("SELECT bm_id,bm_name FROM dbo.s_bm")
    List<BmVo> getYypxKsNr();

    @Insert("INSERT INTO jh_zd (jh_name, zbdw,jh_kstime, jh_jstime, jh_pxlx, \n" +
            "      jh_pxxz, jh_pxnrlb, \n" +
            "      user_id,px_addr, \n" +
            "      px_nr)\n" +
            "    VALUES (#{jhName,jdbcType=VARCHAR}, #{zbdw,jdbcType=VARCHAR}, \n" +
            "      #{jhKstime2,jdbcType=DATE}, #{jhJstime2,jdbcType=DATE},#{jhPxlx,jdbcType=VARCHAR}, \n" +
            "      #{jhPxxz,jdbcType=VARCHAR}, #{jhPxnrlb,jdbcType=VARCHAR},\n" +
            "      #{userId,jdbcType=VARCHAR}, #{pxAddr,jdbcType=VARCHAR}, \n" +
            "      #{pxNr,jdbcType=VARCHAR})")
    Integer addYypxjh(RyPxJhVo ryPxJhVo);
}

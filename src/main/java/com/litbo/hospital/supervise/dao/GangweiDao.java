package com.litbo.hospital.supervise.dao;

import com.litbo.hospital.supervise.bean.SGangwei;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GangweiDao {
    @Select("select gw_id, gw_name, user_id, create_time, doc_url, gw_level, gw_zz from s_gangwei")
    List<SGangwei> getGws();

    @Insert("insert into s_gangwei (gw_id, gw_name, user_id, \n" +
            "      create_time, doc_url, gw_level, \n" +
            "      gw_zz)\n" +
            "    values (#{gwId,jdbcType=INTEGER}, #{gwName,jdbcType=VARCHAR}, #{userId,jdbcType=VARCHAR}, \n" +
            "      #{createTime,jdbcType=TIMESTAMP}, #{docUrl,jdbcType=VARCHAR}, #{gwLevel,jdbcType=CHAR}, \n" +
            "      #{gwZz,jdbcType=LONGVARCHAR})")
    void saveGw(SGangwei gw);

    @Delete("delete from s_gangwei where gw_id = #{gw_id}")
    void deleteGwByGwId(String gw_id);
    @Select("select gw_id, gw_name, user_id, create_time, doc_url, gw_level, gw_zz from s_gangwei where gw_id=#{gw_id}")
    SGangwei getGwsByGwId(String gw_id);

    @Update("update s_gangwei\n" +
            "    set gw_name = #{gwName,jdbcType=VARCHAR},\n" +
            "      user_id = #{userId,jdbcType=VARCHAR},\n" +
            "      create_time = #{createTime,jdbcType=TIMESTAMP},\n" +
            "      doc_url = #{docUrl,jdbcType=VARCHAR},\n" +
            "      gw_level = #{gwLevel,jdbcType=CHAR},\n" +
            "      gw_zz = #{gwZz,jdbcType=LONGVARCHAR}\n" +
            "    where gw_id = #{gwId,jdbcType=INTEGER}")
    void updateGw(SGangwei gw);
}

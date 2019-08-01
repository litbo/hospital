package com.litbo.hospital.security.dao;

import com.litbo.hospital.security.bean.FwLcjl;
import com.litbo.hospital.security.vo.FwLcjlVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface FwLcjlDao {
    @Insert("    insert into fw_lcjl ( user_id, creat_time, " +
            "      bx_id, lc)" +
            "    values ( #{userId,jdbcType=VARCHAR}, #{creatTime,jdbcType=TIMESTAMP}, " +
            "      #{bxId,jdbcType=VARCHAR}, #{lc,jdbcType=VARCHAR})")
    int insertFwLcjl(FwLcjl lcjl);


    @Select("SELECT\n" +
            "\temp.user_xm,\n" +
            "\tlc.creat_time,\n" +
            "\tlc.lc \n" +
            "FROM\n" +
            "\tdbo.fw_lcjl AS lc,\n" +
            "\tdbo.s_emp AS emp \n" +
            "WHERE\n" +
            "\tlc.user_id = emp.user_id \n" +
            "\tAND lc.bx_id = #{fwId}")
    List<FwLcjlVo> getLcjlByFwId(String fwId);

}

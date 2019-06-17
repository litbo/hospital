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
            "emp.user_xm,\n" +
            "lc.creat_time,\n" +
            "lc.lc\n" +
            "FROM\n" +
            "dbo.fw_lcjl AS lc ,\n" +
            "dbo.s_emp AS emp\n" +
            "WHERE\n" +
            "lc.user_id = emp.user_id AND\n" +
            "lc.bx_id = #{fwId}\n" +
            "\n")
    List<FwLcjlVo> getLcjlByFwId(String fwId);

}

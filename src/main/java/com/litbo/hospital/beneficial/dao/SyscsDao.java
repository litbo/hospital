package com.litbo.hospital.beneficial.dao;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface SyscsDao {

    @Insert("update b_syscs set sys_kjjzr=#{kjjzr} where a_id=1")
    Integer updateKjjzr(@Param("kjjzr") Integer kjjzr);

    @Insert("update b_syscs set sys_ylfx=#{ylfx} where a_id=1")
    Integer insertYlfx(@Param("ylfx") float ylfx);

}

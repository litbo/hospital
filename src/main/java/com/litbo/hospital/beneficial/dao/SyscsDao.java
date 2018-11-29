package com.litbo.hospital.beneficial.dao;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SyscsDao {

    @Insert("insert into B_Syscs(Sys_kjjzr) values(#{kjjzr})")
    Integer insertKjjzr(@Param("kjjzr") Integer kjjzr);

    @Insert("insert into B_Syscs(Sys_ylfx) values(#{ylfx})")
    Integer insertYlfx(@Param("ylfx") float ylfx);

}

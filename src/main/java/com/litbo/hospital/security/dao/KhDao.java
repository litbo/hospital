package com.litbo.hospital.security.dao;


import com.litbo.hospital.security.vo.KhVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface KhDao {

    @Select("SELECT user_id AS userId,user_name AS userName FROM jh_tjry WHERE jh_id = #{id} " +
            "AND username NOT IN (SELECT user_name FROM jh_khlr WHERE jh_id = #{id})")
    List<KhVo> kh(@Param("id") String id);

    @Insert("INSERT INTO jh_khlr VALUES()")
    void khBc();

}

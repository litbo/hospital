package com.litbo.hospital.user.dao;

import com.litbo.hospital.user.bean.SUser;
import org.apache.ibatis.annotations.*;


@Mapper
public interface UserDao {

    @Select("SELECT * FROM s_user WHERE user_name=#{userName}")
    SUser getUserByUsername(@Param(value = "userName") String username);
    @Insert("insert into s_user (user_id, user_name, user_pwd, bz) " +
            "  values (#{userId,jdbcType=VARCHAR}, #{userName,jdbcType=VARCHAR}, #{userPwd,jdbcType=VARCHAR},#{bz,jdbcType=LONGVARCHAR})")
    Integer addUser(SUser u);

    @Update("update s_user " +
            "set  user_pwd = #{userPwd,jdbcType=VARCHAR}" +
            " where user_id = #{userId}")
    Integer updatePwd(@Param("userId") String userId,@Param("userPwd") String userPwd);

}

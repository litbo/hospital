package com.litbo.hospital.user.dao;

import com.litbo.hospital.user.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface UserDao {

    @Select("SELECT * FROM s_user WHERE user_name=#{userName}")
    User getUserByUsername(@Param(value = "userName") String username);
}

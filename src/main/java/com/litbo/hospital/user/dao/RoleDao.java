package com.litbo.hospital.user.dao;

import com.litbo.hospital.user.bean.Role;
import com.litbo.hospital.user.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface RoleDao {
    @Select("SELECT\n" +
            "u.user_name,\n" +
            "r.role_id,\n" +
            "r.role_name,\n" +
            "u.user_id\n" +
            "FROM\n" +
            "dbo.s_user AS u\n" +
            "INNER JOIN dbo.s_user_role AS ur ON u.user_id= ur.user_id\n" +
            "INNER JOIN dbo.s_role AS r ON r.role_id= ur.role_id\n" +
            "WHERE\n" +
            "u.user_name = #{userName}")
    List<Role> getRoleByUsername(String username);
}

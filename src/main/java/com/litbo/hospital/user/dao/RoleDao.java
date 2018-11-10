package com.litbo.hospital.user.dao;

import com.litbo.hospital.user.bean.Role;
import com.litbo.hospital.user.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface RoleDao {

    List<Role> getRoleByUsername(String username);
}

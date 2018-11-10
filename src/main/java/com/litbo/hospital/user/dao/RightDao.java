package com.litbo.hospital.user.dao;

import com.litbo.hospital.user.bean.Right;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface RightDao {

    List<Right> getRightsByRolename(String roleName);
}

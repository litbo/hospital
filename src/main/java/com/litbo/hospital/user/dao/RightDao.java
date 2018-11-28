package com.litbo.hospital.user.dao;

import com.litbo.hospital.user.bean.Right;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface RightDao {

    @Select("SELECT ri.*,r.* " +
            "FROM s_right AS ri " +
            "INNER JOIN s_role_right AS rr " +
            "ON ri.right_id =rr.right_id " +
            "INNER JOIN s_role AS r " +
            "ON r.role_id =rr.role_id " +
            "WHERE r.role_name =#{roleName}")
    List<Right> getRightsByRolename(String roleName);
}

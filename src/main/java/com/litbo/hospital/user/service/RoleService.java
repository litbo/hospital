package com.litbo.hospital.user.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.user.bean.SRole;
import com.litbo.hospital.user.vo.SelectUserVo;
import com.litbo.hospital.user.vo.UserVo;
import org.springframework.stereotype.Service;

import java.util.List;


public interface RoleService {

    List<SRole> getRoleByUsername(String username);

    Integer addRole(SRole role);

    Integer setRole(String userId, String roleId);




    PageInfo listUser(int pageNum, int pageSize);



    PageInfo listUserByX(SelectUserVo selectUserVo, int pageNum, int pageSize);

    PageInfo listRoles( int pageNum, int pageSize);
}

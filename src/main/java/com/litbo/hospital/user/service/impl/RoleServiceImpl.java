package com.litbo.hospital.user.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.user.bean.SRole;
import com.litbo.hospital.user.dao.RoleDao;
import com.litbo.hospital.user.service.RoleService;
import com.litbo.hospital.user.vo.SelectUserVo;
import com.litbo.hospital.user.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;
    @Override
    public List<SRole> getRoleByUsername(String username) {
        return roleDao.getRoleByUsername(username);
    }

    @Override
    public Integer addRole(SRole role) {
        String roleId = String.valueOf(Integer.parseInt(roleDao.getLastId())+1);
        role.setRoleId(roleId);
        return roleDao.addRole(role);
    }

    @Override
    public Integer setRole(String userId, String roleId) {
        if(roleDao.setRole(userId,roleId)>0 && roleDao.setStatus(userId)>0){
            return 1;
        }
        return -1;
    }


    @Override
    public PageInfo listUser(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo(roleDao.ListUser());

    }



    @Override
    public PageInfo listUserByX(SelectUserVo selectUserVo, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);

        return new PageInfo(roleDao.listUserByX(selectUserVo));
    }

    @Override
    public List<SRole> listRoles() {
        return roleDao.listRoles();
    }

}

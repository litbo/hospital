package com.litbo.hospital.user.service;

import com.litbo.hospital.user.bean.SRight;
import com.litbo.hospital.user.vo.SetRightVo;
import io.swagger.models.auth.In;

import java.util.List;


public interface RightService {

    List<SRight> getRightsByRolename(String roleName);


    Integer setRights(String rightId, String roleId);


    Integer countByRoleId(String roleId);

    void deletaByRoleId(String roleId);
}

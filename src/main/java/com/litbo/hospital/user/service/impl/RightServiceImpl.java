package com.litbo.hospital.user.service.impl;

import com.litbo.hospital.user.bean.SRight;
import com.litbo.hospital.user.dao.RightDao;
import com.litbo.hospital.user.service.RightService;
import com.litbo.hospital.user.vo.RightTreeSetValueVo;
import com.litbo.hospital.user.vo.RightTreeVo;
import com.litbo.hospital.user.vo.SetRightVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RightServiceImpl implements RightService {

    @Autowired
    private RightDao rightDao;
    @Override
    public List<SRight> getRightsByRolename(String roleName) {
        return rightDao.getRightsByRolename(roleName);
    }

    @Override
    public Integer setRights(String rightId, String roleId) {

            return rightDao.addRights(rightId,roleId);
    }


    @Override
    public Integer countByRoleId(String roleId) {
        return rightDao.countRole(roleId);
    }

    @Override
    public void deletaByRoleId(String roleId) {
        rightDao.deletaByRoleId(roleId);
    }

    @Override
    public List<RightTreeVo> listRightByRId(String roleId) {

        List tree = new ArrayList();
        //遍历全部tree数据 tree1
        List<RightTreeVo> tree1 = rightDao.listRightTree();

        //遍历角色对应数据tree2
        List<RightTreeVo> tree2 = rightDao.listRightTreeVoByRId(roleId);

        //遍历角色对应数据并赋默认值 checked=true tree3
        List<RightTreeSetValueVo> tree3 = rightDao.listRightTreeVoByRId1(roleId);
        //tree1-tree2
        tree1.removeAll(tree2);

        tree.addAll(tree1);
        tree.addAll(tree3);
        return tree;

    }


}

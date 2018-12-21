package com.litbo.hospital.supervise.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.supervise.bean.SGroup;
import com.litbo.hospital.supervise.bean.SGroupUser;
import com.litbo.hospital.supervise.dao.GroupDao;
import com.litbo.hospital.supervise.enums.GroupSHEnumProcess;
import com.litbo.hospital.supervise.service.GroupService;
import com.litbo.hospital.supervise.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class GroupServiceImpl implements GroupService {
    @Autowired
    private GroupDao groupDao;
    @Override
    public PageInfo getGroups(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<SGroup> date = groupDao.getGroups();
        return new PageInfo(date);
    }

    @Override
    public PageInfo getSelectGroups(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<SGroupSelectVO> date = groupDao.getSelectGroups();
        return new PageInfo(date);
    }

    @Override
    public SGroup getGroupById(int pageNum, int pageSize, String group_id) {
        PageHelper.startPage(pageNum,pageSize);
        SGroup date = groupDao.getGroupById(group_id);
        return date;
    }

    @Override
    public void submitGroups(GroupInsertDetailVO groupInsertDetailVO) {
        // 设置审核状态
        groupInsertDetailVO.getGroup().setShFlag(GroupSHEnumProcess.Grouop__ZT_DSH.getCode());
        groupDao.saveGroup(groupInsertDetailVO.getGroup());

        List<SGroupUser> users = groupInsertDetailVO.getUsers();
//        for(SGroupUser user:users){
//            groupDao.saveGroupUser(user);
//        }
        for (SGroupUser user:users){
            if(groupDao.getGroupUserByGuId(user.getGuId())!=null){   //能获取到  更新
                groupDao.updateGroupUser(user);
            }else{
                groupDao.saveGroupUser(user);
            }
        }

    }

    @Override
    public SGroup getDshGroupByShr(String shrId) {

        return groupDao.getDshGroupByShr(shrId);
    }

    @Override
    public GroupSelectDetailVO getGroupDetailByGId(String gid) {
        GroupSelectDetailVO vo = new GroupSelectDetailVO();
        //科室团队
        SGroupSelectVO  group = groupDao.getGroupSelectByGId(gid);
        //科室成员
        List<GroupUserSelectVO> users = groupDao.getGroupUserSelectByGId(gid);
        vo.setGroupSelectVO(group);
        vo.setUserSelectVOS(users);
        return vo;
    }

    @Override
    public void shrShGroup(GroupInsertDetailVO groupInsertDetailVO) {
        SGroup group = groupInsertDetailVO.getGroup();
        //设置审核时间
        group.setShTime(new Date());
        groupDao.updateShGroup(group);
        List<SGroupUser> users = groupInsertDetailVO.getUsers();
        for (SGroupUser user:users){
            if(groupDao.getGroupUserByGuId(user.getGuId())!=null){   //能获取到  更新
                groupDao.updateGroupUser(user);
            }else{
                groupDao.saveGroupUser(user);
            }
        }

    }

    @Override
    public PageInfo getYTHGroup(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<SGroup> groups = groupDao.getYTHGroup();
        return new PageInfo(groups);
    }
}

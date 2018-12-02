package com.litbo.hospital.supervise.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.lifemanage.bean.SgCkcssb;
import com.litbo.hospital.supervise.bean.SGroup;
import com.litbo.hospital.supervise.dao.GroupDao;
import com.litbo.hospital.supervise.service.GroupService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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
    public SGroup getGroupById(int pageNum, int pageSize, String group_id) {
        PageHelper.startPage(pageNum,pageSize);
        SGroup date = groupDao.getGroupById(group_id);
        return date;
    }
}

package com.litbo.hospital.supervise.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.supervise.bean.SEmp;
import com.litbo.hospital.supervise.dao.BmGroupDao;
import com.litbo.hospital.supervise.service.BmGroupService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BmGroupServiceImpl implements BmGroupService {

    @Autowired
    private BmGroupDao bmGroupDao;
    @Override
    public PageInfo getBmGroupMembers(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<SEmp> date =  bmGroupDao.getBmGroupMembers();
        return new PageInfo(date);
    }

    @Override
    public PageInfo getBmGroupMembersByBmId(int pageNum, int pageSize, String bm_id) {
        PageHelper.startPage(pageNum,pageSize);
        List<SEmp> date =  bmGroupDao.getBmGroupMembersByBmId(bm_id);
        return new PageInfo(date);
    }
}

package com.litbo.hospital.supervise.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.supervise.bean.SGroup;

public interface GroupService {
    PageInfo getGroups(int pageNum, int pageSize);

    SGroup getGroupById(int pageNum, int pageSize, String group_id);
}

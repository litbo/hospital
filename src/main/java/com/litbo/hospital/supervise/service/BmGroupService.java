package com.litbo.hospital.supervise.service;

import com.github.pagehelper.PageInfo;

public interface BmGroupService {
    //获取科室成员
    PageInfo getBmGroupMembers(int pageNum, int pageSize);
    //通过科室id获取科室成员
    PageInfo getBmGroupMembersByBmId(int pageNum, int pageSize, String bm_id);
}

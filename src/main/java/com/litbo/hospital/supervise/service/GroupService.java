package com.litbo.hospital.supervise.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.supervise.bean.SGroup;
import com.litbo.hospital.supervise.vo.GroupInsertDetailVO;
import com.litbo.hospital.supervise.vo.GroupSelectDetailVO;

public interface GroupService {
    PageInfo getGroups(int pageNum, int pageSize);
    PageInfo getSelectGroups(int pageNum, int pageSize);
    SGroup getGroupById(int pageNum, int pageSize, String group_id);
    // 提交科室管理团队信息
    void submitGroups(GroupInsertDetailVO groupInsertDetailVO);
    //通过审核人id获取待审核的部门
    SGroup getDshGroupByShr(String shrId);
    // 通过管理团队id获取管理团队详细信息
    GroupSelectDetailVO getGroupDetailByGId(String gid);
    // 审核人审核提交
    void shrShGroup(GroupInsertDetailVO groupInsertDetailVO);
    //获取已退回的管理队伍
    PageInfo getYTHGroup(int pageNum, int pageSize);


}

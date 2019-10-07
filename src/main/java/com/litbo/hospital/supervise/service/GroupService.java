package com.litbo.hospital.supervise.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.supervise.bean.SGroup;
import com.litbo.hospital.supervise.vo.GroupInsertDetailVO;
import com.litbo.hospital.supervise.vo.GroupSelectDetailVO;

public interface GroupService {
    PageInfo getGroups(int pageNum, int pageSize);
    //获取科室详细信息
    PageInfo getSelectGroups(int pageNum, int pageSize);
    //获取科室详细信息通过审核标识
    public PageInfo getSelectGroupsByShCode(int pageNum, int pageSize,String shCode);
    //获取科室详细信息通过科室名称和团队名称
    public PageInfo getSelectGroupsByBmNameAndGNameAndShCode(int pageNum, int pageSize,String bmName,String groupName,String shCode);
    SGroup getGroupById(int pageNum, int pageSize, String group_id);
    // 提交科室管理团队信息
    void submitGroups(GroupInsertDetailVO groupInsertDetailVO);
    //通过审核人id获取待审核的科室
    SGroup getDshGroupByShr(String shrId);
    // 通过管理团队id获取管理团队详细信息
    GroupSelectDetailVO getGroupDetailByGId(String gid);
    // 审核人审核提交
    void shrShGroup(GroupInsertDetailVO groupInsertDetailVO);
    //获取已退回的管理队伍
    PageInfo getYTHGroup(int pageNum, int pageSize);
    //通过创建人获得已退回的团队信息
    PageInfo getYTHGroupByCId(int pageNum, int pageSize, String createId);
    //获得所有管理科室的基本详情信息
    PageInfo getGroupsMSGDetail(int pageNum, int pageSize);
    //获得管理科室的基本详情信息通过科室名称
    PageInfo getGroupsMSGDetailByBmName(int pageNum, int pageSize, String bmName);
    //获得未成立管理团队的科室
    PageInfo listWclGroupBm(int pageNum, int pageSize);
    //通过岗位名称获取每个队伍相对应的人员信息
    PageInfo listPreEmps(int pageNum, int pageSize, String gwName);
    //通过岗位名称人员姓名科室名称联合模糊获取每个队伍相对应的人员信息
    PageInfo listPreEmpsByBmNameAndGwName(int pageNum, int pageSize, String gwName, String userXm, String bmName);

    PageInfo getEstablishJd(int pageNum, int pageSize,String tdName,String bmName);

    void reSubmitGroups(GroupInsertDetailVO groupInsertDetailVO);
}

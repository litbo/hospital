package com.litbo.hospital.supervise.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.supervise.bean.SBm;
import com.litbo.hospital.supervise.bean.SGroup;
import com.litbo.hospital.supervise.bean.SGroupUser;
import com.litbo.hospital.supervise.dao.GroupDao;
import com.litbo.hospital.supervise.enums.GroupSHEnumProcess;
import com.litbo.hospital.supervise.service.GroupService;
import com.litbo.hospital.supervise.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public PageInfo getSelectGroupsByShCode(int pageNum, int pageSize,String shCode) {
        PageHelper.startPage(pageNum,pageSize);
        List<SGroupSelectVO> date = groupDao.getSelectGroupsByShCode(shCode);
        return new PageInfo(date);
    }

    @Override
    public PageInfo getSelectGroupsByBmNameAndGNameAndShCode(int pageNum, int pageSize,String bmName,String groupName,String shCode) {
        PageHelper.startPage(pageNum,pageSize);
        List<SGroupSelectVO> date = groupDao.getSelectGroupsByBmNameAndGNameAndShCode(bmName,groupName,shCode);
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
        SGroup group = new SGroup();
        group.setGroupId(groupInsertDetailVO.getGroupId());
        group.setBmId(groupInsertDetailVO.getBmId());
        group.setGroupName(groupInsertDetailVO.getGroupName());
        group.setCreateTime(new Date());
        group.setUserId1(groupInsertDetailVO.getUserId1());
        group.setUserId2(groupInsertDetailVO.getUserId2());
        group.setShFlag(GroupSHEnumProcess.Grouop__ZT_DSH.getCode());
        if(groupInsertDetailVO.getGroupId()!=null){
            groupDao.updateGroup(group);
        }else{
            groupDao.saveGroup(group);
        }

        List<SGroupUser> users = groupInsertDetailVO.getUsers();

        groupDao.deleteUsersByGid(group.getGroupId());
        for (SGroupUser user:users){
            user.setGroupId(group.getGroupId());
            groupDao.saveGroupUser(user);
        }

    }

    @Override
    public void reSubmitGroups(GroupInsertDetailVO groupInsertDetailVO) {
        // 设置审核状态
        SGroup group = new SGroup();
        group.setGroupId(groupInsertDetailVO.getGroupId());
        group.setBmId(groupInsertDetailVO.getBmId());
        group.setGroupName(groupInsertDetailVO.getGroupName());
        group.setCreateTime(new Date());
        group.setUserId1(groupInsertDetailVO.getUserId1());
        group.setUserId2(groupInsertDetailVO.getUserId2());
        group.setShFlag(GroupSHEnumProcess.Grouop__ZT_DSH.getCode());
        groupDao.saveGroup(group);

        List<SGroupUser> users = groupInsertDetailVO.getUsers();

        groupDao.deleteUsersByGid(group.getGroupId());
        for (SGroupUser user:users){
            user.setGroupId(group.getGroupId());
            groupDao.saveGroupUser(user);
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
        vo.setGroupId(group.getGroupId());
        vo.setBmName(group.getBmName());
        vo.setBmId(group.getBmId());
        vo.setGroupName(group.getGroupName());
        vo.setUserId1(group.getUserId1());
        vo.setUserName1(group.getUserName1());
        vo.setCreateTime(group.getCreateTime());
        vo.setUserId2(group.getUserId2());
        vo.setUserName2(group.getUserName2());
        vo.setUserSelectVOS(users);
        return vo;
    }

    @Override
    public void shrShGroup(GroupInsertDetailVO groupInsertDetailVO) {
        SGroup group = new SGroup();
        group.setGroupId(groupInsertDetailVO.getGroupId());
        group.setBmId(groupInsertDetailVO.getBmId());
        group.setGroupName(groupInsertDetailVO.getGroupName());
        group.setUserId1(groupInsertDetailVO.getUserId1());
        group.setUserId2(groupInsertDetailVO.getUserId2());
        group.setShFlag(groupInsertDetailVO.getShFlag());
        group.setShTime(groupInsertDetailVO.getShTime());
        group.setShYj(groupInsertDetailVO.getShYj());
        //设置审核时间
        group.setShTime(new Date());
        groupDao.updateShGroup(group);
        List<SGroupUser> users = groupInsertDetailVO.getUsers();

        groupDao.deleteUsersByGid(group.getGroupId());
        for (SGroupUser user:users){
            user.setGroupId(group.getGroupId());
            groupDao.saveGroupUser(user);
        }
    }

    @Override
    public PageInfo getYTHGroup(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<SGroup> groups = groupDao.getYTHGroup();
        return new PageInfo(groups);
    }

    @Override
    public PageInfo getYTHGroupByCId(int pageNum, int pageSize, String createId) {
        PageHelper.startPage(pageNum,pageSize);
        List<SGroup> groups = groupDao.getYTHGroupByCId(createId);
        return new PageInfo(groups);
    }

    @Override
    public PageInfo getGroupsMSGDetail(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<GroupMSGDetailVO> msgDetails = new ArrayList<>();
        List<SGroupSelectVO> selectGroups = groupDao.getSelectGroups();

        for(SGroupSelectVO selectGroup:selectGroups){
            Integer groupId = selectGroup.getGroupId();  //团队id
            GroupMSGDetailVO msgDetailVO = new GroupMSGDetailVO();
            msgDetailVO.setBmName(selectGroup.getBmName());   // 设置部门名

//    使用部门医学装备管理小组组长             组长
//    使用部门医学装备管理小组副组长          副组长
//    使用部门质量安全管理人员	           质安管理人员
//    使用部门资产管理员                   资产管理人员
//    使用部门计量员                       计量管理人员
//    使用部门监测联络员                    监测联络员
//    使用部门质检员                       质控管理人员

            //获得组长    根据id查人员和岗位       select emp.user_xm,gw.gw_name from s_group_users users  INNER JOIN s_emp emp on (users.user_id=emp.user_id) INNER JOIN s_gangwei gw ON (users.gw_id=gw.gw_id) WHERE gw.gw_name='使用部门质量安全管理人员'
            List<String> zzs = groupDao.getEmpXMByGIdAndGWXm(groupId, "使用部门医学装备管理小组组长");
            msgDetailVO.setZzs(ListToArrStr(zzs));
            //获得副组长
            List<String> fzzs = groupDao.getEmpXMByGIdAndGWXm(groupId,"使用部门医学装备管理小组副组长");
            msgDetailVO.setFzzs(ListToArrStr(fzzs));

            //获得质安管理人员
            List<String> zagls = groupDao.getEmpXMByGIdAndGWXm(groupId,"使用部门质量安全管理人员");
            msgDetailVO.setZagls(ListToArrStr(zagls));

            //获得资产管理人员
            List<String> zcgls = groupDao.getEmpXMByGIdAndGWXm(groupId,"使用部门资产管理员");
            msgDetailVO.setZcgls(ListToArrStr(zcgls));

            //获得计量管理人员
            List<String> jzgls = groupDao.getEmpXMByGIdAndGWXm(groupId,"使用部门计量员");
            msgDetailVO.setJlgls(ListToArrStr(jzgls));

            //获得监测联络员
            List<String> jclls = groupDao.getEmpXMByGIdAndGWXm(groupId,"使用部门监测联络员");
            msgDetailVO.setJclls(ListToArrStr(jclls));

            //获得质控管理人员
            List<String> zkgls = groupDao.getEmpXMByGIdAndGWXm(groupId,"使用部门质检员");
            msgDetailVO.setZkgls(ListToArrStr(zkgls));
            msgDetails.add(msgDetailVO);
        }


        return new PageInfo(msgDetails);
    }

    @Override
    public PageInfo getGroupsMSGDetailByBmName(int pageNum, int pageSize, String bmName) {
        PageHelper.startPage(pageNum,pageSize);
        List<GroupMSGDetailVO> msgDetails = new ArrayList<>();
        List<SGroupSelectVO> selectGroups = groupDao.getSelectGroups();

        for(SGroupSelectVO selectGroup:selectGroups){
            Integer groupId = selectGroup.getGroupId();  //团队id
            if(selectGroup.getBmName().indexOf(bmName)==-1){
                continue;
            }
            GroupMSGDetailVO msgDetailVO = new GroupMSGDetailVO();
            msgDetailVO.setBmName(selectGroup.getBmName());   // 设置部门名

//    使用部门医学装备管理小组组长             组长
//    使用部门医学装备管理小组副组长          副组长
//    使用部门质量安全管理人员	           质安管理人员
//    使用部门资产管理员                   资产管理人员
//    使用部门计量员                       计量管理人员
//    使用部门监测联络员                    监测联络员
//    使用部门质检员                       质控管理人员

            //获得组长    根据id查人员和岗位       select emp.user_xm,gw.gw_name from s_group_users users  INNER JOIN s_emp emp on (users.user_id=emp.user_id) INNER JOIN s_gangwei gw ON (users.gw_id=gw.gw_id) WHERE gw.gw_name='使用部门质量安全管理人员'
            List<String> zzs = groupDao.getEmpXMByGIdAndGWXm(groupId, "使用部门医学装备管理小组组长");
            msgDetailVO.setZzs(ListToArrStr(zzs));
            //获得副组长
            List<String> fzzs = groupDao.getEmpXMByGIdAndGWXm(groupId,"使用部门医学装备管理小组副组长");
            msgDetailVO.setFzzs(ListToArrStr(fzzs));

            //获得质安管理人员
            List<String> zagls = groupDao.getEmpXMByGIdAndGWXm(groupId,"使用部门质量安全管理人员");
            msgDetailVO.setZagls(ListToArrStr(zagls));

            //获得资产管理人员
            List<String> zcgls = groupDao.getEmpXMByGIdAndGWXm(groupId,"使用部门资产管理员");
            msgDetailVO.setZcgls(ListToArrStr(zcgls));

            //获得计量管理人员
            List<String> jzgls = groupDao.getEmpXMByGIdAndGWXm(groupId,"使用部门计量员");
            msgDetailVO.setJlgls(ListToArrStr(jzgls));

            //获得监测联络员
            List<String> jclls = groupDao.getEmpXMByGIdAndGWXm(groupId,"使用部门监测联络员");
            msgDetailVO.setJclls(ListToArrStr(jclls));

            //获得质控管理人员
            List<String> zkgls = groupDao.getEmpXMByGIdAndGWXm(groupId,"使用部门质检员");
            msgDetailVO.setZkgls(ListToArrStr(zkgls));
            msgDetails.add(msgDetailVO);
        }


        return new PageInfo(msgDetails);
    }

    private String[] ListToArrStr(List<String> ll ){
        String[] ss = new String[ll.size()];
        String[] result = ll.toArray(ss);
        return result;
    }

    @Override
    public PageInfo listWclGroupBm(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<SBm> bms = groupDao.listWclGroupBm();
        return new PageInfo(bms);
    }

    @Override
    public PageInfo listPreEmps(int pageNum, int pageSize, String gwName) {
        PageHelper.startPage(pageNum,pageSize);
        List<GroupPerCateGoryUserMSGDetailVO> details = groupDao.listPreEmps(gwName);
        return new PageInfo(details);
    }

    @Override
    public PageInfo listPreEmpsByBmNameAndGwName(int pageNum, int pageSize, String gwName, String userXm, String bmName) {
        PageHelper.startPage(pageNum,pageSize);
        List<GroupPerCateGoryUserMSGDetailVO> details = groupDao.listPreEmpsByBmNameAndGwName(gwName,userXm,bmName);
        return new PageInfo(details);
    }

    @Override
    public PageInfo getEstablishJd(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<GroupKSJDVO> groupKSJDVOS = groupDao.getEstablishJd();
        for(GroupKSJDVO groupKSJDVO:groupKSJDVOS){
            String status = groupKSJDVO.getStatus();

            if(status.equals("1")){
                groupKSJDVO.setStatus("成立");
            }else if (status.equals("2")){
                groupKSJDVO.setStatus("审核通过");
            }else{
                groupKSJDVO.setStatus("已退回");
            }
        }
        return new PageInfo(groupKSJDVOS);
    }
}

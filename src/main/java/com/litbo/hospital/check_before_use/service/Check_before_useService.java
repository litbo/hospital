package com.litbo.hospital.check_before_use.service;

import com.litbo.hospital.check_before_use.pojo.CheckBeforeUseProject;
import com.litbo.hospital.check_before_use.vo.EqInfoCheckBeforeUseVo;
import com.litbo.hospital.user.bean.EqInfo;

import java.util.List;
import java.util.PrimitiveIterator;

/**
 * @Author: 樊小铭
 * Date: 2019/9/4 20:51
 * @Version:
 * @Description:
 */
public interface Check_before_useService {

    // 查看设备
    List<EqInfoCheckBeforeUseVo> seeEqMessage(String eqNum,String bmName,String eqName);

    // 查看所有的项目名称
    List<String> seeAllType(String type);



    // 添加项目
    int addProject(CheckBeforeUseProject project);

    int deleteProject(int id);




}

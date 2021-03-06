package com.litbo.hospital.security.inspectionplan.service;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.security.inspectionplan.bean.InspEqPlan;
import com.litbo.hospital.security.inspectionplan.bean.vo.InspPlanSelectVo;
import com.litbo.hospital.security.inspectionplan.bean.vo.InspPlanSelectVo1;
import com.litbo.hospital.security.inspectionplan.bean.vo.InspPlanVo;
import com.litbo.hospital.security.inspectionplan.bean.vo.SelectVo.InspPlanVo1;

import java.util.ArrayList;
import java.util.List;

/**
 * 巡检计划管理 【 增、删、改、查】Service
 *
 * @author 10366 2019-08-09 10:45
 **/
public interface InspectionManageService {


    /**
     * 功能描述: 更改巡检计划信息
     *
     * @Param:
     * @Return:
     * @Author: ZYJ
     * @Date: 2019/8/18 0018 18:44
     */
    int updateInspPlan(InspPlanVo inspPlanVo, String userId);


    /**
     * 功能描述: 变更设备选定情况
     *
     * @Param: ArrayList<InspEqPlan>
     * @Return: void
     * @Author: ZYJ
     * @Date: 2019/8/21 0021 0:15
     */
    void changeEqSelection(List<InspEqPlan> inspEqPlans);

    /**
     * 功能描述:根据巡检计划Id查询巡检计划信息
     *
     * @Param: inspPlId
     * @Return: List<InspEqPlan>
     * @Author: ZYJ
     * @Date: 2019/8/14 0014 15:25
     */
    InspPlanVo1 selectInspPlanById(String inspPlId);

    /**
     * 功能描述: 查询巡检计划列表
     *
     * @Param:
     * @Return:
     * @Author: ZYJ
     * @Date: 2019/8/13 0013 16:03
     */
    PageInfo<InspPlanSelectVo> selectAllInspPlanVo(int pageNum, int pageSize);
    /**
     * 功能描述: 查询巡检计划列表
     *
     * @Param:
     * @Return:
     * @Author: ZYJ
     * @Date: 2019/8/13 0013 16:03
     */
    PageInfo<InspPlanSelectVo1> selectAllResultInspPlanVo(int pageNum, int pageSize);

    /**
     * 功能描述: 查询巡检计划列表
     *
     * @Param: inspPlName inspPlPlanner inspPlAuditor inspPlStatus
     * @Return:
     * @Author: ZYJ
     * @Date: 2019/8/13 0013 16:03
     */
    PageInfo<InspPlanSelectVo> selectInspPlanVo(int pageNum, int pageSize,
                                                String inspPlName, String inspPlPlanner,
                                                String inspPlAuditor, String inspPlStatus);/**
     /**
     * 功能描述: 查询巡检计划列表
     *
     * @Param: inspPlName inspPlPlanner inspPlAuditor inspPlStatus
     * @Return:
     * @Author: ZYJ
     * @Date: 2019/8/13 0013 16:03
     */
    PageInfo<InspPlanSelectVo1> selectResultInspPlanVo(int pageNum, int pageSize,
                                                String inspPlName, String inspPlPlanner,
                                                String inspPlAuditor, String inspPlStatus);
    /**
     * 功能描述: 查询巡检计划列表
     *
     *
     * @Param:
     * @Return:
     * @Author: ZYJ
     * @Date: 2019/8/13 0013 16:03
     */
    PageInfo<InspPlanSelectVo> selectAllApproveInspPlanVo(int pageNum, int pageSize);

    /**
     * 功能描述: 查询巡检计划列表
     *
     * @Param: inspPlName inspPlPlanner inspPlAuditor inspPlStatus
     * @Return:
     * @Author: ZYJ
     * @Date: 2019/8/13 0013 16:03
     */
    PageInfo<InspPlanSelectVo> selectApproveInspPlanVo(int pageNum, int pageSize,
                                                String inspPlName, String inspPlPlanner,
                                                String inspPlAuditor, String inspPlStatus);

    /**
     * 功能描述: 添加巡检计划
     *
     * @Param: inspPlanVo
     * @Return: int
     * @Author: ZYJ
     * @Date: 2019/8/12 0012 19:16
     */
    int addInspPlan(InspPlanVo inspPlanVo, String planner, String inspPlSpare3);

    /**
     * 功能描述: 根据巡检计划id删除巡检计划
     *
     * @Param: inspPlId
     * @Return: int
     * @Author: ZYJ
     * @Date: 2019/8/9 0009 13:35
     */
    int deleteInspPlByPlId(String inspPlId);

    /**
     * 功能描述: 根据巡检计划id 巡检计划中的其它巡检
     *
     * @Param: inspPlId
     * @Return: int
     * @Author: ZYJ
     * @Date: 2019/8/9 0009 13:35
     */
    int deleteInspPlByPlType(String inspPlId);

    /**
     * 功能描述: 同意审批
     *
     * @Param:
     * @Return:
     * @Author: ZYJ
     * @Date: 2019/8/9 0009 15:23
     */
    int approvedForInspection(String[] inspPlIds);

    /**
     * 功能描述: 拒绝审批
     *
     * @Param:
     * @Return:
     * @Author: ZYJ
     * @Date: 2019/8/9 0009 15:23
     */
    int rejectedForInspection(String[] inspPlIds);

    /**
     * 功能描述: 变更提交后 status => 4
     *
     * @Param:
     * @Return:
     * @Author: ZYJ
     * @Date: 2019/8/9 0009 15:23
     */
    void updatePlus(String inspPlId);


}

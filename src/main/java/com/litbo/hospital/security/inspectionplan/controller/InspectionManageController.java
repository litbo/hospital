package com.litbo.hospital.security.inspectionplan.controller;


import com.litbo.hospital.result.Result;
import com.litbo.hospital.security.inspectionplan.bean.vo.ApproveInspection;
import com.litbo.hospital.security.inspectionplan.bean.vo.InspPlanVo;
import com.litbo.hospital.security.inspectionplan.service.InspectionManageService;
import com.litbo.hospital.user.vo.LiveEmpVo;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *  巡检计划管理 【 增、删、改、查】Controller
 *
 * @author 10366 2019-08-09 10:42
 *
 **/
@RestController
@RequestMapping("/inspection/inspPl")
public class InspectionManageController {

    @Autowired
    private InspectionManageService
            inspectionManageService;


    /**
     * 功能描述: 更改巡检计划信息
     *
     * @Param: InspPlanVo11
     * @Return: void
     * @Author: ZYJ
     * @Date: 2019/8/18 0018 18:44
     */
    @PostMapping("/updateInspPlan")
    public Result updateInspPlan(@RequestBody InspPlanVo inspPlanVo){
        LiveEmpVo sEmp = (LiveEmpVo) SecurityUtils.getSubject().getSession().getAttribute("emp");
        String userId = sEmp.getUserId();
        return Result.success(inspectionManageService.updateInspPlan(inspPlanVo, userId));
    }

    /**
     * 功能描述:根据巡检计划Id查询巡检计划信息
     *
     * @Param: inspPlId
     * @Return: List<InspEqPlan>
     * @Author: ZYJ
     * @Date: 2019/8/14 0014 15:25
     */
    @PostMapping("selectInspPlanById")
    public Result selectInspPlanById(@RequestParam("inspPlId") String inspPlId){
        return Result.success(inspectionManageService.selectInspPlanById(inspPlId));
    }

    /**
     * 功能描述: 查询巡检计划列表
     *
     * @Param:
     * @Return:
     * @Author: ZYJ
     * @Date: 2019/8/13 0013 16:03
     */
    @GetMapping("/selectAllInspPlanVo")
    public Result selectAllInspPlanVo(@RequestParam(required = false,defaultValue = "10") Integer pageSize,
                                      @RequestParam(required = false,defaultValue = "1") Integer pageNum){
        return Result.success(inspectionManageService.selectAllInspPlanVo(pageNum, pageSize));
    }

    /**
     * 功能描述: 查询结果录入巡检计划列表
     *
     * @Param:
     * @Return:
     * @Author: ZYJ
     * @Date: 2019/8/13 0013 16:03
     */
    @GetMapping("/selectResultAllInspPlanVo")
    public Result selectResultAllInspPlanVo(@RequestParam(required = false,defaultValue = "10") Integer pageSize,
                                      @RequestParam(required = false,defaultValue = "1") Integer pageNum){
        return Result.success(inspectionManageService.selectAllResultInspPlanVo(pageNum, pageSize));
    }

    /**
     * 功能描述: 查询巡检计划列表
     *
     * @Param: inspPlName inspPlPlanner inspPlAuditor inspPlStatus
     * @Return:
     * @Author: ZYJ
     * @Date: 2019/8/13 0013 16:03
     */
    @PostMapping("/selectInspPlanVo")
    public Result selectInspPlanVo(@RequestParam(required = false,defaultValue = "10") Integer pageSize,
                                   @RequestParam(required = false,defaultValue = "1") Integer pageNum,
                                   @RequestParam("inspPlName") String inspPlName,@RequestParam("inspPlPlanner") String inspPlPlanner,
                                   @RequestParam("inspPlAuditor") String inspPlAuditor,@RequestParam("inspPlStatus") String inspPlStatus){
        return Result.success(inspectionManageService.selectInspPlanVo(pageNum, pageSize, inspPlName, inspPlPlanner, inspPlAuditor, inspPlStatus));
    }

    /**
     * 功能描述: 查询结果录入巡检计划列表
     *
     * @Param: inspPlName inspPlPlanner inspPlAuditor inspPlStatus
     * @Return:
     * @Author: ZYJ
     * @Date: 2019/8/13 0013 16:03
     */
    @PostMapping("/selectResultInspPlanVo")
    public Result selectResultInspPlanVo(@RequestParam(required = false,defaultValue = "10") Integer pageSize,
                                   @RequestParam(required = false,defaultValue = "1") Integer pageNum,
                                   @RequestParam("inspPlName") String inspPlName,@RequestParam("inspPlPlanner") String inspPlPlanner,
                                   @RequestParam("inspPlAuditor") String inspPlAuditor,@RequestParam("inspPlStatus") String inspPlStatus){
        return Result.success(inspectionManageService.selectResultInspPlanVo(pageNum, pageSize, inspPlName, inspPlPlanner, inspPlAuditor, inspPlStatus));
    }

    /**
     * 功能描述: 查询巡检计划列表
     *
     * @Param:
     * @Return:
     * @Author: ZYJ
     * @Date: 2019/8/13 0013 16:03
     */
    @GetMapping("/selectApproveAllInspPlanVo")
    public Result selectApproveAllInspPlanVo(@RequestParam(required = false,defaultValue = "10") Integer pageSize,
                                      @RequestParam(required = false,defaultValue = "1") Integer pageNum){
        return Result.success(inspectionManageService.selectAllApproveInspPlanVo(pageNum, pageSize));
    }

    /**
     * 功能描述: 查询巡检计划列表
     *
     * @Param: inspPlName inspPlPlanner inspPlAuditor inspPlStatus
     * @Return:
     * @Author: ZYJ
     * @Date: 2019/8/13 0013 16:03
     */
    @PostMapping("/selectApproveInspPlanVo")
    public Result selectApproveInspPlanVo(@RequestParam(required = false,defaultValue = "10") Integer pageSize,
                                   @RequestParam(required = false,defaultValue = "1") Integer pageNum,
                                   @RequestParam("inspPlName") String inspPlName,@RequestParam("inspPlPlanner") String inspPlPlanner,
                                   @RequestParam("inspPlAuditor") String inspPlAuditor,@RequestParam("inspPlStatus") String inspPlStatus){
        return Result.success(inspectionManageService.selectApproveInspPlanVo(pageNum, pageSize, inspPlName, inspPlPlanner, inspPlAuditor, inspPlStatus));
    }

    /**
     * 功能描述: 添加巡检计划
     *
     * @Param: inspPlanVo
     * @Return: int
     * @Author: ZYJ
     * @Date: 2019/8/12 0012 19:16
     */
    @PostMapping("/addInspPlan")
    public Result addInspPlan(@RequestBody InspPlanVo inspPlanVo) {
        LiveEmpVo sEmp = (LiveEmpVo) SecurityUtils.getSubject().getSession().getAttribute("emp");
        inspectionManageService.addInspPlan(inspPlanVo, sEmp.getUserId(), sEmp.getUserXm());
        return Result.success();
    }


    /**
     * 功能描述: 根据巡检计划id删除巡检计划
     *
     * @Param: inspPlId
     * @Return: int
     * @Author: ZYJ
     * @Date: 2019/8/9 0009 13:35
     */
    @RequestMapping("/deleteInspPlByPlId")
    public Result deleteInspPlByPlId(@RequestBody String[] inspPlIds){
        for (String inspPlId : inspPlIds) {
            inspectionManageService.deleteInspPlByPlId(inspPlId);
        }
        return Result.success();
    }

    /**
     * 功能描述: 根据巡检计划id 巡检计划中的其它巡检
     *
     * @Param: inspPlId
     * @Return: int
     * @Author: ZYJ
     * @Date: 2019/8/9 0009 13:35
     */
    @RequestMapping("/deleteInspPlByPlType")
    public int deleteInspPlByPlType(@RequestParam("inspPlId") String inspPlId){
        return inspectionManageService.deleteInspPlByPlType(inspPlId);
    }

    /**
     * 功能描述: 批量同意审批
     *
     * @Param: inspPlIds
     * @Return: Result
     * @Author: ZYJ
     * @Date: 2019/8/9 0009 15:23
     */
    @RequestMapping("/approvedForInspection")
    public Result approvedForInspection(@RequestBody ApproveInspection approveInspection){
        String[] inspPlIds = approveInspection.getInspPlIds();
        return Result.success(inspectionManageService.approvedForInspection(inspPlIds));
    }

    /**
     * 功能描述: 批量同意审批
     *
     * @Param: inspPlIds
     * @Return: Result
     * @Author: ZYJ
     * @Date: 2019/8/9 0009 15:23
     */
    @RequestMapping("/rejectedForInspection")
    public Result rejectedForInspection(@RequestBody ApproveInspection approveInspection){
        String[] inspPlIds = approveInspection.getInspPlIds();
        return Result.success(inspectionManageService.rejectedForInspection(inspPlIds));
    }







}

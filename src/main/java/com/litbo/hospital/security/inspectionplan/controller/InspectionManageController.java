package com.litbo.hospital.security.inspectionplan.controller;


import com.litbo.hospital.result.Result;
import com.litbo.hospital.security.inspectionplan.bean.vo.InspPlanVo;
import com.litbo.hospital.security.inspectionplan.service.InspectionManageService;
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
     * 功能描述: 添加巡检计划
     *
     * @Param: inspPlanVo
     * @Return: int
     * @Author: ZYJ
     * @Date: 2019/8/12 0012 19:16
     */
    @PostMapping("/addInspPlan")
    public Result addInspPlan(@RequestBody InspPlanVo inspPlanVo) {
        inspectionManageService.addInspPlan(inspPlanVo);
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
    public int deleteInspPlByPlId(@RequestParam("inspPlId") String inspPlId){
        return inspectionManageService.deleteInspPlByPlId(inspPlId);
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
    public Result approvedForInspection(@RequestBody String[] inspPlIds){
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
    public Result rejectedForInspection(@RequestBody String[] inspPlIds){
        return Result.success(inspectionManageService.rejectedForInspection(inspPlIds));
    }







}

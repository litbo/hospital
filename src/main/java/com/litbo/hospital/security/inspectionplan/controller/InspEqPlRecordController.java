package com.litbo.hospital.security.inspectionplan.controller;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.security.inspectionplan.bean.vo.RecordSelectVo.InspEqPlRecordVo;
import com.litbo.hospital.security.inspectionplan.bean.vo.RecordSelectVo.PLanAndNowExecuteRecordVo;
import com.litbo.hospital.security.inspectionplan.service.InspEqPlRecordService;
import com.litbo.hospital.user.vo.LiveEmpVo;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 *
 *
 * @author 10366 2019-08-26 22:47
 **/

@RestController
@RequestMapping("/inspection/inspPlRecord")
public class InspEqPlRecordController {

    @Autowired
    private InspEqPlRecordService
            inspEqPlRecordService;



    @GetMapping("/selectAllUser")
    public Result selectAllUser(@RequestParam(required = false,defaultValue = "10") Integer pageSize,
                                @RequestParam(required = false,defaultValue = "1") Integer pageNum){
        return Result.success(inspEqPlRecordService.selectAllUser(pageNum, pageSize));
    }
    @GetMapping("/selectUserByUserVo")
    public Result selectUserByUserVo(@RequestParam(required = false,defaultValue = "10") Integer pageSize,
                                @RequestParam(required = false,defaultValue = "1") Integer pageNum,
                                     @RequestParam("userId")String userId, @RequestParam("userXm")String userXm,
                                     @RequestParam("bmName")String bmName){
        return Result.success(inspEqPlRecordService.selectUserByUserVo(pageNum, pageSize, userId, userXm, bmName));
    }

    /**
     * 功能描述: 查询 往日此巡检计划的巡检记录
     *
     * @Param:
     * @Return:
     * @Author: ZYJ
     * @Date: 2019/8/31 0031 10:13
     */
    @PostMapping("selectPLanAndNowExecuteRecordVoByCondition")
    public Result selectPLanAndNowExecuteRecordVoByCondition(@RequestParam(required = false,defaultValue = "10") Integer pageSize,
                                                             @RequestParam(required = false,defaultValue = "1") Integer pageNum,
                                                             @RequestParam("inspPlId")String inspPlId, @RequestParam("beginTime1")String beginTime1,
                                                             @RequestParam("endTime1")String endTime1, @RequestParam("beginTime2")String beginTime2,
                                                             @RequestParam("endTime2")String endTime2){
        return Result.success(inspEqPlRecordService.selectPLanAndNowExecuteRecordVoByCondition(pageNum, pageSize, inspPlId, beginTime1,endTime1, beginTime2, endTime2));
    }

    /**
     * 功能描述: 查询 往日此巡检计划的巡检记录
     *
     * @Param:
     * @Return:
     * @Author: ZYJ
     * @Date: 2019/8/31 0031 10:13
     */
    @PostMapping("selectPLanAndNowExecuteRecordVoById")
    public Result selectPLanAndNowExecuteRecordVoById(@RequestParam(required = false,defaultValue = "10") Integer pageSize,
                                                      @RequestParam(required = false,defaultValue = "1") Integer pageNum,
                                                      @RequestParam("inspPlId")String inspPlId){
        return Result.success(inspEqPlRecordService.selectPLanAndNowExecuteRecordVoById(pageNum, pageSize, inspPlId));
    }

    /**
     * 功能描述: 根据记录id查询巡检记录
     *
     * @Param: inspReId
     * @Return:
     * @Author: ZYJ
     * @Date: 2019/8/28 0028 10:22
     */
    @PostMapping("selectRecordByRecordId")
    public Result selectRecordByRecordId(@RequestParam("inspReId")String inspReId){
        return Result.success(inspEqPlRecordService.selectRecordByRecordId(inspReId));
    }

    /**
     * 功能描述: 查看录入结果根据Vo
     *
     * @Param:
     * @Return:
     * @Author: ZYJ
     * @Date: 2019/8/28 0028 0:09
     */
    @PostMapping("selectRecordVoByCondition")
    public Result selectRecordVoByCondition(@RequestParam(required = false,defaultValue = "10") Integer pageSize,
                                            @RequestParam(required = false,defaultValue = "1") Integer pageNum,
                                            @RequestParam("inspPlName")String inspPlName, @RequestParam("eqName")String eqName,
                                            @RequestParam("bmName")String bmName, @RequestParam("beginTime")String beginTime,
                                            @RequestParam("endTime")String endTime){
        return Result.success(inspEqPlRecordService.selectRecordVoByCondition(pageNum, pageSize, inspPlName, eqName, bmName, beginTime, endTime));
    }

    /**
     * 功能描述: 查看录入结果Vo
     *
     * @Param:
     * @Return:
     * @Author: ZYJ
     * @Date: 2019/8/28 0028 0:09
     */
    @GetMapping("selectRecordVo")
    public Result selectRecordVo(@RequestParam(required = false,defaultValue = "10") Integer pageSize,
                                 @RequestParam(required = false,defaultValue = "1") Integer pageNum){
        return Result.success(inspEqPlRecordService.selectRecordVo(pageNum, pageSize));
    }

    /**
     * 功能描述: 结果录入  查询巡检计划
     *
     * @Param: inspPlId
     * @Return:
     * @Author: ZYJ
     * @Date: 2019/8/27 0027 0:19
     */
    @RequestMapping("/selectInspPlById")
    public Result selectInspPlById(@RequestParam("inspPlId")String inspPlId){
        return Result.success(inspEqPlRecordService.selectInspPlById(inspPlId));
    }

    /**
     * 功能描述: 保存巡检计划
     *
     * @Param: InspEqPlanRecord
     * @Return:
     * @Author: ZYJ
     * @Date: 2019/8/27 0027 8:44
     */
    @RequestMapping("/insertInspRecord")
    public Result insertInspRecord(@RequestBody InspEqPlRecordVo inspEqPlRecordVo){
        LiveEmpVo sEmp = (LiveEmpVo) SecurityUtils.getSubject().getSession().getAttribute("emp");
        inspEqPlRecordService.insertInspRecord(inspEqPlRecordVo, sEmp.getUserId());
        return Result.success();
    }


}

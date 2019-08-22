package com.litbo.hospital.security.inspectionplan.controller;

import com.litbo.hospital.result.Result;
import com.litbo.hospital.security.inspectionplan.service.InspPlDrawUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 巡检计划制定相关的功能
 *
 * @author 10366 2019-08-03 17:47
 **/
@RestController
@RequestMapping("/inspection/otherfunction")
public class InspPlDrawUpController {

    @Autowired
    private InspPlDrawUpService
            inspPlDrawUpService;



    /**
     * 功能描述: 查询副处长以上的人员
     *
     * @Param:  pageNum, pageSize
     * @Return: Result
     * @Author: ZYJ
     * @Date: 2019/8/3 0003 18:09
     */
    @GetMapping("/selectFuchuVos")
    public Result selectFuchuVos(@RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                 @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize){
        return Result.success(inspPlDrawUpService.selectFuchuVos(pageNum, pageSize));
    }
    
    /**
     * 功能描述: 查询副处长以上的人员 根据 name
     * 
     * @Param: pageNum, pageSize, name
     * @Return: Result
     * @Author: ZYJ
     * @Date: 2019/8/4 0004 8:56
     */
    @PostMapping("/selectFuchuVosByName")
    public Result selectFuchuVosByName(@RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                       @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                       @RequestParam(name = "userXm")String userXm){
        return Result.success(inspPlDrawUpService.selectFuchuVosByName(pageNum, pageSize, userXm));
    }

    /**
     * 功能描述: 查询巡检计划制定人
     *
     * @Param:
     * @Return: Result
     * @Author: ZYJ
     * @Date: 2019/8/4 0004 9:29
     */
    @GetMapping("/selectAllUser")
    public Result selectAllUser(@RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize){
        return Result.success(inspPlDrawUpService.selectAllUser(pageNum, pageSize));
    }
    /**
     * 功能描述: 查询巡检计划制定人条件查询
     *
     * @Param: userId userXm bmName
     * @Return: Result
     * @Author: ZYJ
     * @Date: 2019/8/4 0004 9:34
     */
    @PostMapping("/selectUserByUserVo")
    public Result selectUserByUserVo(@RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                     @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                     @RequestParam("userId")String userId, @RequestParam("userXm")String userXm,
                                     @RequestParam("bmName")String bmName){
        return Result.success(inspPlDrawUpService.selectUserByUserVo(pageNum, pageSize, userId, userXm, bmName));
    }

    /**
     * 功能描述: 查询所有在此计划未选中设备
     *
     * @Param:
     * @Return: Result
     * @Author: ZYJ
     * @Date: 2019/8/4 0004 10:18
     */
    @GetMapping("/selectAllNotSelectionEq")
    public Result selectAllNotSelectionEq(@RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                          @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize){
        return Result.success(inspPlDrawUpService.selectAllNotSelectionEq(pageNum, pageSize));
    }
    /**
     * 功能描述: 查询所有在此计划未选中设备根据eqVo
     *
     * @Param: eqsbbh eqname eqxh bmName
     * @Return: Result
     * @Author: ZYJ
     * @Date: 2019/8/5 0005 8:59
     */
    @PostMapping("/selectAllNotSelectionEqByEqVo")
    public Result selectAllNotSelectionEqByEqVo(@RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                                @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                                @RequestParam("eqSbbh")String eqSbbh, @RequestParam("eqName")String eqName,
                                                @RequestParam("eqXh")String eqXh, @RequestParam("bmName")String bmName){
        return Result.success(inspPlDrawUpService.selectAllNotSelectionEqByEqVo(pageNum, pageSize, eqSbbh, eqName, eqXh, bmName));
    }
    /**
     * 功能描述: 查询所有在此计划选中设备
     *
     * @Param:
     * @Return: Result
     * @Author: ZYJ
     * @Date: 2019/8/4 0004 10:18
     */
    @GetMapping("/selectAllSelectionEq")
    public Result selectAllSelectionEq(@RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                          @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize){
        return Result.success(inspPlDrawUpService.selectAllSelectionEq(pageNum, pageSize));
    }
    /**
     * 功能描述: 查询所有在此计划未选中设备根据eqVo
     *
     * @Param: eqsbbh eqname eqxh bmName
     * @Return: Result
     * @Author: ZYJ
     * @Date: 2019/8/5 0005 8:59
     */
    @PostMapping("/selectAllSelectionEqByEqVo")
    public Result selectAllSelectionEqByEqVo(@RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                                @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                                @RequestParam("eqSbbh")String eqSbbh, @RequestParam("eqName")String eqName,
                                                @RequestParam("eqXh")String eqXh, @RequestParam("bmName")String bmName){
        return Result.success(inspPlDrawUpService.selectAllSelectionEqByEqVo(pageNum, pageSize, eqSbbh, eqName, eqXh, bmName));
    }
    /**
     * 功能描述: 巡检计划制定完成后清除选定的设备项
     *
     * @Param:
     * @Return: int
     * @Author: ZYJ
     * @Date: 2019/8/5 0005 14:15
     */
    @GetMapping("/updateSelectionToZero")
    public Result updateSelectionToZero(){
        return Result.success(inspPlDrawUpService.updateSelectionToZero());
    }

    /**
     *
     * @param eqSbbhs
     * @return
     */
    @PostMapping("/updateEqSbbh")
    public Result updateEqSbbh(@RequestBody String[] eqSbbhs){
        for (String eqSbbh : eqSbbhs) {
            inspPlDrawUpService.updateEqSbbh(eqSbbh);
        }
        return Result.success();
    }
    @PostMapping("/updateEqSbbh1")
    public Result updateEqSbbh1(@RequestBody String[] eqSbbhs){
        for (String eqSbbh : eqSbbhs) {
            inspPlDrawUpService.updateEqSbbh1(eqSbbh);
        }
        return Result.success();
    }


}

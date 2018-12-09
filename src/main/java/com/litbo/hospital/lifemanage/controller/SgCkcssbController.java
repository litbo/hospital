package com.litbo.hospital.lifemanage.controller;

import com.litbo.hospital.lifemanage.bean.SgCkcssb;
import com.litbo.hospital.lifemanage.service.SgCkcssbService;
import com.litbo.hospital.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 参考厂商设备表Controller
 */
@Api(value = "参考厂商设备表Controller", tags = {"参考厂商设备表相关业务的接口"})
@RestController
@RequestMapping("/lifeManage")
public class SgCkcssbController {

    @Autowired
    private SgCkcssbService sgCkcssbService;

    /**
     * 添加参考厂商设备表信息
     *
     * @param sgCkcssb 厂商设备表实体类
     * @return Result 添加厂商设备信息成功/添加厂商设备信息失败
     */
    @ApiOperation(value = "添加参考厂商设备表信息", notes = "添加参考厂商设备表信息业务")
    @PostMapping("/insertSgCkcssb")
    public Result insertSgCkcssb(@RequestBody SgCkcssb sgCkcssb) {
        sgCkcssbService.insertSgCkcssb(sgCkcssb);
        return Result.success();
    }

    /**
     * 根据申购单id查询所有厂商设备表信息
     *
     * @return List<SgCkcssb> 查询的信息
     */
    @GetMapping("selectSgCkcssbBySgInfoId")
    public Result selectSgCkcssbBySgInfoId(@RequestParam(name = "SgInfoId") String sgInfoId) {
        return Result.success(sgCkcssbService.selectSgCkcssbBySgInfoId(sgInfoId));
    }

    /**
     * 根据主键删除参考厂商设备信息
     *
     * @param sgCkcssbId 参考厂商设备id
     * @return Result
     */
    @GetMapping("deleteSgCkcssbById")
    public Result deleteSgCkcssbById(@RequestParam(name = "sgCkcssbId") String sgCkcssbId) {
        sgCkcssbService.deleteSgCkcssbById(sgCkcssbId);
        return Result.success();
    }

}
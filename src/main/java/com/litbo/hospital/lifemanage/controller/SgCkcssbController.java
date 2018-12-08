package com.litbo.hospital.lifemanage.controller;

import com.github.pagehelper.PageHelper;
import com.litbo.hospital.lifemanage.bean.SgCkcssb;
import com.litbo.hospital.lifemanage.service.SgCkcssbService;
import com.litbo.hospital.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 参考厂商设备表Controller
 */
@RestController
@RequestMapping("/lifeManage")
public class SgCkcssbController {
    @Autowired
    private SgCkcssbService sgCkcssbService;

    /**
     * 分页查询所有厂商设备表信息
     *
     * @return Result 查询的信息
     */
    @GetMapping("/selectSgCkcssbs")
    public Result selectSgCkcssbs(
            @RequestParam(required = false, name = "pageSize", defaultValue = "10") int pageSize,
            @RequestParam(required = false, name = "pageNum", defaultValue = "1") int pageNum
    ) {
        PageHelper.startPage(pageNum, pageSize);
        List<SgCkcssb> sgCkcssbs = sgCkcssbService.selectSgCkcssbs();
        System.out.println(sgCkcssbs);
        return Result.success(sgCkcssbs);
    }

    /**
     * 添加厂商设备表信息
     *
     * @param sgCkcssb 厂商设备表实体类
     * @return Result 添加厂商设备信息成功/添加厂商设备信息失败
     */
    @PostMapping("/insertSgCkcssb")
    public Result insertSgCkcssb(@RequestBody SgCkcssb sgCkcssb) {
        boolean insert = sgCkcssbService.insertSgCkcssb(sgCkcssb);
        if (insert) {
            return Result.success();
        } else {
            return Result.error("添加厂商设备信息失败");
        }

    }
}
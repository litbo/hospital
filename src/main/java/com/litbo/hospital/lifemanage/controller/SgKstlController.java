package com.litbo.hospital.lifemanage.controller;

import com.litbo.hospital.lifemanage.bean.vo.SgKstlVO;
import com.litbo.hospital.lifemanage.service.SgKstlService;
import com.litbo.hospital.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 科室讨论表Controller
 */
@RestController
@RequestMapping("/lifeManage")
public class SgKstlController {
    @Autowired
    private SgKstlService sgKstlService;

    /**
     * 添加科室讨论信息
     *
     * @param sgKstlVO  科室讨论信息
     * @return 添加科室讨论信息成功/添加科室讨论信息失败
     */
    @PostMapping("/insertSgKstl")
    public Result insertSgKstl(@RequestBody SgKstlVO sgKstlVO) {
        boolean result = sgKstlService.insertSgKstl(sgKstlVO);
        if (result) {
            return Result.success();
        } else {
            return Result.error("添加信息错误");
        }
    }

    /**
     * 显示部门下的所有讨论的设备
     *
     * @param userId    登陆人id
     * @param eqPmName 设备名称
     * @param eqPmJc   设备简称
     * @param pageNum  页数
     * @param pageSize 每页显示记录数
     * @return SgKstlAddSgInfoVO
     */
    @PostMapping("/selectSgKstlSbs")
    public Result selectSgKstlSbs(@RequestParam(name = "userId") String userId,
                                  @RequestParam(required = false, name = "eqPmName") String eqPmName,
                                  @RequestParam(required = false, name = "eqPmJc") String eqPmJc,
                                  @RequestParam(required = false, name = "pageNum", defaultValue = "1") Integer pageNum,
                                  @RequestParam(required = false, name = "pageSize", defaultValue = "10") Integer pageSize) {
        return Result.success(sgKstlService.selectSgKstlSbs(userId, eqPmName, eqPmJc, pageNum, pageSize));
    }

}

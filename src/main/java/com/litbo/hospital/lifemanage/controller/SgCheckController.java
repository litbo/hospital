package com.litbo.hospital.lifemanage.controller;

import com.litbo.hospital.lifemanage.service.SgCheckService;
import com.litbo.hospital.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 账实核对Controller
 *
 * @author Administrator on 2018-12-29
 */
@RestController
@RequestMapping("/lifeManage")
public class SgCheckController {
    @Autowired
    private SgCheckService sgCheckService;

    @PostMapping("/selectSgCheck")
    public Result selectSgCheck(@RequestParam(name = "planId") String planId,
                                @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        return Result.success(sgCheckService.selectSgCheck(planId, pageNum, pageSize));
    }

    /**
     * 添加账实核对信息
     *
     * @param ids    核对表id
     * @param userId 核对人id
     * @param check  核对是否存在 0不存在 1存在
     * @return Result
     */
    @PostMapping("/updateSgCheckByIds")
    public Result updateSgCheckByIds(@RequestParam(name = "ids") List<String> ids,
                                     @RequestParam(name = "userId") String userId,
                                     @RequestParam(name = "check") String check) {
        sgCheckService.updateSgCheckByIds(ids, userId, check);
        return Result.success();
    }

    /**
     * 核对对比
     *
     * @param check     是否存在
     * @param checkDate 审核日期
     * @param checkUser 审核人
     * @param planDate  制定日期
     * @param planUser  制定人
     * @param pageNum   当前页数
     * @param pageSize  每页显示的记录数
     * @return Result
     */
    @PostMapping("/selectSgCheckList")
    public Result selectSgCheckList(@RequestParam(name = "check",required = false) String check,
                                    @RequestParam(name = "checkDate",required = false) String checkDate,
                                    @RequestParam(name = "checkUser",required = false) String checkUser,
                                    @RequestParam(name = "planDate",required = false) String planDate,
                                    @RequestParam(name = "planUser",required = false) String planUser,
                                    @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                    @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        return Result.success(sgCheckService.selectSgCheckList(check,checkDate,checkUser,planDate,planUser,pageNum,pageSize));
    }

}

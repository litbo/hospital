package com.litbo.hospital.lifemanage.controller;

import com.litbo.hospital.lifemanage.bean.vo.SgDhdjVO;
import com.litbo.hospital.lifemanage.service.SgDhdjService;
import com.litbo.hospital.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 到货登记表Controller
 *
 * @author 马
 */
@RestController
@RequestMapping("/lifeManage")
public class SgDhdjController {
    @Autowired
    private SgDhdjService sgDhdjService;

    /**
     * 添加到货登记信息
     *
     * @param sgDhdjVO 到货登记信息
     * @return Result
     */
    @PostMapping("insertSgDhdj")
    public Result insertSgDhdj(@RequestBody SgDhdjVO sgDhdjVO) {
        sgDhdjService.insertSgDhdj(sgDhdjVO);
        return Result.success();
    }

    /**
     * 查询科室接收的货物
     *
     * @param userId   当前用户id
     * @param pageNum  当前页数
     * @param pageSize 每页显示的记录数
     * @return Result
     */
    @PostMapping("selectDjhwKsjs")
    public Result selectDjhwKsjs(@RequestParam(name = "userId") String userId,
                                 @RequestParam(name = "pageNum", defaultValue = "1", required = false) Integer pageNum,
                                 @RequestParam(name = "pageSize", defaultValue = "10", required = false) Integer pageSize) {
        return Result.success(sgDhdjService.selectDjhwKsjs(userId, pageNum, pageSize));
    }

    /**
     * 科室接收
     *
     * @param djhwId 登记货物id
     * @param userId 登陆人id
     * @return Result
     */
    @PostMapping("updateSgDhdjKsjs")
    public Result updateSgDhdjKsjs(@RequestParam(name = "djhwId")String djhwId,@RequestParam(name = "userId") String userId) {
        sgDhdjService.updateSgDhdjKsjs(djhwId, userId);
        return Result.success();
    }

    /**
     * 科室接收货物详情信息
     *
     * @param djhwId 到货登记id
     * @return Result
     */
    @PostMapping("selectSgDhdjDetails")
    public Result selectSgDhdjDetails(@RequestParam(name = "djhwId") String djhwId) {
        return Result.success(sgDhdjService.selectSgDhdjDetails(djhwId));
    }
}

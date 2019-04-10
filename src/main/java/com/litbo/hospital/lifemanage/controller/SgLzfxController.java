package com.litbo.hospital.lifemanage.controller;

import com.litbo.hospital.lifemanage.bean.vo.SgLzfxVO;
import com.litbo.hospital.lifemanage.service.SgLzfxService;
import com.litbo.hospital.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 论证分析表Controller
 */
@RestController
@RequestMapping("/lifeManage")
public class SgLzfxController {
    @Autowired
    SgLzfxService sgLzfxService;

    /**
     * 添加论证分析信息
     *
     * @param sgLzfxVOs 论证分析信息
     * @return Result
     */
    @PostMapping("/insertSgLzfx")
    public Result insertSgLzfx(@RequestBody SgLzfxVO sgLzfxVOs) {
        sgLzfxService.insertSgLzfx(sgLzfxVOs);
        return Result.success();
    }

    /**
     * 查看论证分析信息
     * @param sgInfoId 申购单id
     * @return Result
     */
    @PostMapping("/selectSgLzfx")
    public Result selectSgLzfx(String sgInfoId) {
        return Result.success(sgLzfxService.selectSgLzfx(sgInfoId));
    }
}

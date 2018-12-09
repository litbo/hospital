package com.litbo.hospital.lifemanage.controller;

import com.litbo.hospital.lifemanage.bean.SgZrpjbg;
import com.litbo.hospital.lifemanage.service.SgZrpjbgService;
import com.litbo.hospital.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 准入评价报告表Controller
 */
@RestController
@RequestMapping("/lifeManage")
public class SgZrpjbgController {
    @Autowired
    private SgZrpjbgService sgZrpjbgService;

    /**
     * 添加准入评价报告信息
     *
     * @param sgZrpjbg 准入评价报告
     */
    @PostMapping("insertSgZrpjbg")
    public Result insertSgZrpjbg(@RequestBody SgZrpjbg sgZrpjbg){
        sgZrpjbgService.insertSgZrpjbg(sgZrpjbg);
        return Result.success();
    }

}

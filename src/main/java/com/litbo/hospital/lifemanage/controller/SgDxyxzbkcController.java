package com.litbo.hospital.lifemanage.controller;

import com.litbo.hospital.lifemanage.bean.SgDxyxzbkc;
import com.litbo.hospital.lifemanage.service.SgDxyxzbkcService;
import com.litbo.hospital.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 大型医学装备考察报告表Controller
 */
@RestController
@RequestMapping("/lifeManage")
public class SgDxyxzbkcController {
    @Autowired
    SgDxyxzbkcService sgDxyxzbkcService;

    @PostMapping("insertSgDxyxzbkc")
    public Result insertSgDxyxzbkc(SgDxyxzbkc sgDxyxzbkc){

        return Result.success();
    }

}

package com.litbo.hospital.lifemanage.controller.MyController;

import com.litbo.hospital.result.Result;
import com.litbo.hospital.user.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lifeManage")
public class HtCommonController {
    @Autowired
    private DictService service;
    @GetMapping("/getAlljldw")
    public Result getAlljldw(){
        return Result.success( service.listJldw());
    }
}

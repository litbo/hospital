package com.litbo.hospital.security.controller;

import com.litbo.hospital.result.Result;
import com.litbo.hospital.security.bean.FwShouli;
import com.litbo.hospital.security.service.FwShouLiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zjc
 * @create 2018-12-06 9:36
 */
@RestController
@RequestMapping("/shouli")
public class FwShouLiController {

    @Autowired
    private FwShouLiService fwShouLiService;

    @PostMapping("/addShouli")
    public Result addShouli(FwShouli fwShouli){
        try {
            fwShouLiService.addShouli(fwShouli);
            return Result.success();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("添加失败");
        }
    }
}

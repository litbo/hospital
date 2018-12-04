package com.litbo.hospital.security.controller;

import com.litbo.hospital.result.Result;
import com.litbo.hospital.security.bean.FwBaoxiu;
import com.litbo.hospital.security.service.FwBaoxiuService;
import com.litbo.hospital.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author zjc
 * @create 2018-12-03 11:29
 */
@RestController
@RequestMapping("/baoxiu")
public class FwBaoxiuController {

    @Autowired
    private FwBaoxiuService fwBaoxiuService;

    @Autowired
    private UserService userService;

    @PostMapping("/addBaoxiu")
    public Result addBaoxiu(FwBaoxiu fwBaoxiu){
        try {
            fwBaoxiuService.addBaoxiu(fwBaoxiu);
            return Result.success();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error();
        }
    }

    @GetMapping("/updateBaoxiuStatus")
    public Result updateBaoxiuStatus(String id,Integer baoxiuStatus){
        try {
            fwBaoxiuService.updateBaoxiuStatusById(id,baoxiuStatus);
            return Result.success();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error();
        }
    }
}

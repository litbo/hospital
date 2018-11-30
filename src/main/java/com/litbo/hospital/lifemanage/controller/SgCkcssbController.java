package com.litbo.hospital.lifemanage.controller;

import com.litbo.hospital.lifemanage.bean.SgCkcssb;
import com.litbo.hospital.lifemanage.dao.SgCkcssbMapper;
import com.litbo.hospital.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/lifeManage")
public class SgCkcssbController {
    @Autowired
    SgCkcssbMapper sgCkcssbMapper;
    @GetMapping("/selectSgCkcssbs")
    public Result selectSgCkcssbs(){
        List<SgCkcssb> sgCkcssbs = sgCkcssbMapper.selectSgCkcssbs();
        System.out.println(sgCkcssbs);
        return Result.success(sgCkcssbs);
    }
    @PostMapping("/insertSgCkcssb")
    public Result insertSgCkcssb(SgCkcssb sgCkcssb){
        int insert = sgCkcssbMapper.insert(sgCkcssb);
        System.out.println(insert);
        if (insert == 1){
            return Result.success();
        }else {
            return Result.error("添加信息失败");
        }

    }
}

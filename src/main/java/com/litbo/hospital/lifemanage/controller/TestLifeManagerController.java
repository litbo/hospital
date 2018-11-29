package com.litbo.hospital.lifemanage.controller;

import com.litbo.hospital.lifemanage.bean.SgCkcssb;
import com.litbo.hospital.lifemanage.dao.SgCkcssbMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/lifeManage")
public class TestLifeManagerController {
    @Autowired
    SgCkcssbMapper sgCkcssbMapper;
    @GetMapping("/pdf")
    public String test(){
        List<SgCkcssb> sgCkcssbs = sgCkcssbMapper.selectSgCkcssbsById(1);
        System.out.println(sgCkcssbs);
        return "成功";
    }
}

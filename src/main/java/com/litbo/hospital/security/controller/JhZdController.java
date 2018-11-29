package com.litbo.hospital.security.controller;

import com.litbo.hospital.result.Result;
import com.litbo.hospital.security.bean.JhZd;
import com.litbo.hospital.security.service.JhZdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zjc
 * @create 2018-11-29 15:02
 */
@RestController
@RequestMapping("/JhZd")
public class JhZdController {

    @Autowired
    private JhZdService jhZdService;

    @PostMapping("/add")
    public Result addJhZd(JhZd jhZd){
        Result result = jhZdService.addJhZd(jhZd);
        return result;
    }
}

package com.litbo.hospital.lifemanage.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lifemanage")
public class TestController {
    @PostMapping("/test")
    public String test(){
        return "测试";
    }
}

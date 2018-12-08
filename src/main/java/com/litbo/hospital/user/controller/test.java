package com.litbo.hospital.user.controller;

import com.litbo.hospital.result.Result;
import com.litbo.hospital.user.bean.*;
import com.litbo.hospital.user.dao.DictDao;
import com.litbo.hospital.user.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("/a")
public class test {

    @RequestMapping("")
    public String  a(){
         return"public_info";
    }
}

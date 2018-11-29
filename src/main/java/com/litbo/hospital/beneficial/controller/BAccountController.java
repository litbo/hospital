package com.litbo.hospital.beneficial.controller;


import com.litbo.hospital.beneficial.service.BAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 *会计科目的增删改查
 * */

@RestController
public class BAccountController {

    @Autowired
    private BAccountService bAccountService;

    @RequestMapping("/benefical/account/insert")
    public int insertAccount(String fkmName){
        return bAccountService.insertAccount(fkmName);
    }

}

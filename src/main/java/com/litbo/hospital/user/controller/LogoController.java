package com.litbo.hospital.user.controller;

import com.litbo.hospital.result.Result;
import com.litbo.hospital.user.bean.SysLogo;
import com.litbo.hospital.user.service.LogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/logo")
public class LogoController {
    @Autowired
    private LogoService logoService;

    @RequestMapping("/setLogo")
    public Result setLogo(@RequestParam("file") MultipartFile multipartFile,SysLogo logo){
        if(logoService.setLogo(logo,multipartFile)>0){
            return Result.success();
        }
        return Result.error();
    }
    @RequestMapping("/setBbtt")
    public Result setBbtt(@RequestParam("file") MultipartFile multipartFile,SysLogo logo){
        if(logoService.setBbtt(logo,multipartFile)>0){
            return Result.success();
        }
        return Result.error();
    }
    @RequestMapping("/setSbbqtt")
    public Result setSbbqtt(@RequestParam("file") MultipartFile multipartFile,SysLogo logo){
        if(logoService.setSbbqtt(logo,multipartFile)>0){
            return Result.success();
        }
        return Result.error();
    }
}

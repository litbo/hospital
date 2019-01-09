package com.litbo.hospital.user.controller;

import com.litbo.hospital.beneficial.service.SyscsService;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.user.bean.SysDxm;
import com.litbo.hospital.user.bean.SysWjbb;
import com.litbo.hospital.user.bean.SysZxsj;
import com.litbo.hospital.user.dao.SysDao;
import com.litbo.hospital.user.service.SysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
*
*  系统设置
* @author : ljl
**/
@RestController
@RequestMapping("/sys")
public class SysController {

    @Autowired
    private SysService sysService;
    @Autowired
    private SysDao sysDao;

    //文件版本设置
    @RequestMapping("/setWjbb")
    public Result setWjbb(SysWjbb wjbb){

        if(sysService.setWjbb(wjbb)>0){
            return Result.success();
        }
        return Result.error();
    }
    @RequestMapping("/getWjbb")
    public Result getWjbb(){

       return Result.success(sysDao.getWjbb());
    }

    //短信猫设置
    @RequestMapping("/setDxm")
    public Result setDxm(SysDxm dxm){
        if( sysService.setDxm(dxm)>0){
            return Result.success();
        }else {
            return Result.error();
        }
    }
    @RequestMapping("/getDxm")
    public Result getDxm(){
        SysDxm sysDxm =  sysDao.getDxm();
        return Result.success(sysDxm);
    }
    //作息时间设置
    @RequestMapping("/setZxsj")
    public Result setZxsj(SysZxsj zxsj){
        if(sysService.setZxsj(zxsj)>0){
            return Result.success();
        }else {
            return Result.error();
        }
    }

/*    @RequestMapping("/test")
    public Result test(){
        String bname = "eq_info";
        return  Result.success(sysDao.count(bname));
    }*/


}

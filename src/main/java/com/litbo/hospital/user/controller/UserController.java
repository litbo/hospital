package com.litbo.hospital.user.controller;


import com.litbo.hospital.result.Result;
import com.litbo.hospital.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;
    @RequestMapping("/setUser")
    public Result setUser(String userId){

        if(userService.setUser(userId)>0){
            return Result.success();
        }
        return Result.error();
    }
    @RequestMapping("/updatePwd")
    public Result updatePwd(String userId,String userPwd){
        if(userService.updatePwd(userId,userPwd)>0){
            return  Result.success();
        }
        return Result.error();
    }

    //批量设置为用户
    @PostMapping("/setUsers")
    public Result setUsers(@RequestBody List<String> ids){
        for (String id : ids) {
            if(userService.setUser(id)<0){
                return Result.error(id);
            }
        }

        return Result.success();
    }

    //通过用户名查询用户信息
    @RequestMapping("getUserById")
    public Result getUserById(String userId){

       return Result.success(userService.getUserById(userId)) ;
    }

}

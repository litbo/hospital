package com.litbo.hospital.user.controller;

import com.litbo.hospital.result.Result;
import com.litbo.hospital.user.bean.SRole;
import com.litbo.hospital.user.service.RoleService;
import com.litbo.hospital.user.vo.SelectUserVo;
import com.litbo.hospital.user.vo.SetRolesVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    //添加角色
    @RequestMapping("/addRole")
    public Result addRole(SRole role){
        if(roleService.addRole(role)>0){
            return Result.success();
        }
        return Result.error();
    }
    //为用户设置角色
    @RequestMapping("/setRole")
    public Result setRole(String userId,String roleId){

        if(roleService.setRole(userId,roleId)>0){
            return Result.success();
        }
        return Result.error();
    }

    //批量设置角色
    @RequestMapping("/setRoles")

    public Result setRoles(@RequestBody SetRolesVo setRolesVo){
        List<String> userIds = setRolesVo.getUserIds();
        for (String userId : userIds) {
            if(roleService.setRole(userId,setRolesVo.getRoleId())<=0) {
                return Result.error(userId);
            }
        }
        return Result.success();
    }
    //查询所有用户基本信息
    @RequestMapping("/listUsers")
    public Result listUsers(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                             @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize){
        return Result.success(roleService.listUser(pageNum,pageSize));
    }



    @RequestMapping("/listUserByX")
    public Result listUserByX(SelectUserVo selectUserVo,@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                              @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize){

        return Result.success(roleService.listUserByX(selectUserVo,pageNum,pageSize));
    }

    //查询所有角色数据
    @RequestMapping("/listRoles")
    public Result listRoles(){
        return Result.success(roleService.listRoles());
    }

}

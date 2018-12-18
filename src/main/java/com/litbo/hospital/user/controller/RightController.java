package com.litbo.hospital.user.controller;

import com.litbo.hospital.result.Result;
import com.litbo.hospital.user.dao.RightDao;
import com.litbo.hospital.user.service.RightService;
import com.litbo.hospital.user.vo.SetRightVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/right")
public class RightController {

    @Autowired
    private RightService rightService;

    //为角色设置权限
    @PostMapping("/setRights")
    public Result setRights(@RequestBody SetRightVo setRightVo) {
        List<String> rightIds = setRightVo.getRightIds();

        //先判断数据库中是否已经为该角色设置权限
        //如果是先删除再增加
        if (rightService.countByRoleId(setRightVo.getRoleId()) > 0) {
            rightService.deletaByRoleId(setRightVo.getRoleId());
        }

        //循环添加
        for (String rightId : rightIds) {
            if (rightService.setRights(rightId, setRightVo.getRoleId()) < 0) {
                return Result.error();
            }
        }
        return Result.success();
    }

    //根据角色Id查权限
}

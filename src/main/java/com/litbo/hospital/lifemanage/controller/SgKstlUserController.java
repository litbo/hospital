package com.litbo.hospital.lifemanage.controller;

import com.litbo.hospital.lifemanage.service.SgKstlUserService;
import com.litbo.hospital.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 科室讨论会议人员关联表Controller
 */
@RestController
@RequestMapping("/lifeManage")
public class SgKstlUserController {
    @Autowired
    SgKstlUserService sgKstlUserService;

    /**
     * 添加科室讨论人员信息批量添加
     *
     * @param kstlId  科室讨论的ID
     * @param usersId 参加讨论的人员集合
     * @return 添加关联信息成功/添加关联信息失败
     */
    @PostMapping("/insertSgKstlUser")
    public Result insertSgKstlUser(@RequestParam(name = "kstlId") String kstlId,@RequestParam(name = "usersId") List<String> usersId){
        boolean integer = sgKstlUserService.insertSgKstlUser(kstlId, usersId);
        if (integer){
            return Result.success();
        }else {
            return Result.error("添加科室讨论人员信息失败");
        }
    }
}

package com.litbo.hospital.attendanceAndScheduling.attendance.controller;

import com.litbo.hospital.attendanceAndScheduling.attendance.service.AttendanceService;
import com.litbo.hospital.attendanceAndScheduling.attendance.vo.SignVo;
import com.litbo.hospital.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: 樊小铭
 * Date: 2019/10/4 13:52
 * @Version:
 * @Description:
 */
@RestController
@RequestMapping("AttendanceController")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;


    /**
     * 展示本部门所有人员
     * @param bmId 部门id
     * @param name 员工姓名
     * @return
     */
    @RequestMapping("/getSelfStaff.do")
    public Result getSelfStaff(@RequestParam(name = "bmId" , defaultValue = "") String bmId,
                               @RequestParam(name = "name" , defaultValue = "") String name){
        if(bmId.equals("")){
            bmId = null;
        }

        if(name.equals("")){
            name = null;
        }

        List list = attendanceService.getSelfStaff(bmId,name);

        return Result.success(list);
    }


    /**
     * 签到、签退、迟到、早退、加班
     * @param signVo
     * @return
     */
    @RequestMapping("/sign.do")
    public Result sign(@RequestBody SignVo signVo){
        int result = attendanceService.sing(signVo);
        return Result.success("完成");
    }


//
//    @RequestMapping("/countSing")
//    public Result countSign(@RequestParam(name = "bmId" , defaultValue = "") String bmId,
//                            @RequestParam(name = "name" , defaultValue = "") String name){
//        if(bmId.equals("")){
//            bmId = null;
//        }
//
//        if(name.equals("")){
//            name = null;
//        }
//
//
//    }


}

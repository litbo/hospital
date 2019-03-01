package com.litbo.hospital.supervise.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.supervise.bean.SEmp;
import com.litbo.hospital.supervise.service.EmpService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/kwgl/empgl")
@Api(tags = "人员管理")
public class EmpController {
    @Autowired
    private EmpService empService;


    @RequestMapping("/listSelectEmpsCols")
    public Result listSelectEmpsCols(@RequestParam(required = false) String key) {
        JSONArray myJsonArray = null;
        if ("checkbox".equals(key)){
            String jsonMessage = "[{'type': 'checkbox'}, " +
                    "{field: 'userId', title: '人员ID'}, " +
                    "{field: 'userXm', title: '人员姓名'}]";
            myJsonArray = JSONObject.parseArray(jsonMessage);
        }else if ("radio".equals(key)){
            String jsonMessage = "[{'type': 'radio'}, " +
                    "{field: 'userId', title: '人员ID'}, " +
                    "{field: 'userXm', title: '人员姓名'}]";
            myJsonArray = JSONObject.parseArray(jsonMessage);
        }
        PageInfo date = new PageInfo(myJsonArray);
        return Result.success(date);
    }

    //获取Emp基本信息
    @GetMapping("/listSelectEmps")
    public Result listSelectEmps(@RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
                                 @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize) {
        PageInfo info = empService.listSelectEmps(pageNum, pageSize);
        return Result.success(info);
    }

    @GetMapping("/listSelectEmpBybmIdAndUserId")
    public Result listSelectEmps(@RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
                                 @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize,
                                 String bmId, String userId) {
        PageInfo info = empService.listSelectEmpBybmIdAndUserId(pageNum, pageSize, bmId, userId);
        return Result.success(info);
    }


    @GetMapping("/listEmpsByBmId")
    public Result getEmpsByBmId(@RequestParam String bmId) {
        List<SEmp> emps = empService.getEmpsByBmId(bmId);
        return Result.success(emps);
    }

    @PostMapping("/saveEmp")
    public Result saveEmp(@RequestBody SEmp emp) {
        empService.saveEmp(emp);
        return Result.success();
    }

    @GetMapping("/deleteEmpByUserId")
    public Result deleteEmpByUserId(@RequestParam String empId) {
        empService.deleteEmpByUserId(empId);
        return Result.success();
    }

    @GetMapping("/listEmpByBmId")
    public Result listEmpByBmId(@RequestParam String bmId) {
        List<SEmp> emps = empService.listEmpByBmId(bmId);
        return Result.success(emps);
    }

    @GetMapping("/listGcsEmp")
    public Result listGcsEmp() {
        List<SEmp> emps = empService.getWxEmps();
        return Result.success(emps);
    }

    //获取登陆人的同部门伙伴信息  只包括userId和userXm
    @RequestMapping("/listPartnerByUserId")
    public Result listPartnerByUserId(
            @RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize,
            @RequestParam(required = false) String key, HttpServletRequest request) {
        String userId = "1";
//        userId=(String) request.getSession().getAttribute("username");
        PageInfo<SEmp> emps = empService.listPartnerByUserId(userId,pageNum,pageSize);
        return Result.success(emps);
    }

}

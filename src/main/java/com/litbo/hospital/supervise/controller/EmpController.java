package com.litbo.hospital.supervise.controller;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.supervise.bean.SEmp;
import com.litbo.hospital.supervise.service.EmpService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kwgl/empgl")
@Api(tags = "人员管理")
public class EmpController {
    @Autowired
    private EmpService empService;


    //获取Emp基本信息
    @GetMapping("/listSelectEmps")
    public Result listSelectEmps(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                                 @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize){
        PageInfo info  =  empService.listSelectEmps(pageNum,pageSize);
        return Result.success(info);
    }


    @GetMapping("listEmpsByBmId")
    public Result getEmpsByBmId(@RequestParam String bmId){
        List<SEmp> emps =  empService.getEmpsByBmId(bmId);
        return Result.success(emps);
    }
    @PostMapping("saveEmp")
    public Result saveEmp(@RequestBody SEmp emp){
        empService.saveEmp(emp);
        return Result.success();
    }
    @GetMapping("deleteEmpByUserId")
    public Result deleteEmpByUserId(@RequestParam String empId){
        empService.deleteEmpByUserId(empId);
        return Result.success();
    }

    @GetMapping("/listEmpByBmId")
    public Result listEmpByBmId(@RequestParam String bmId){
        List<SEmp> emps = empService.listEmpByBmId(bmId);
        return Result.success(emps);
    }



}

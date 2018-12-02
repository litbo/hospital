package com.litbo.hospital.security.controller;

import com.litbo.hospital.result.Result;
import com.litbo.hospital.security.bean.JhRylr;
import com.litbo.hospital.security.bean.JhZd;
import com.litbo.hospital.security.service.JhRyLrService;
import com.litbo.hospital.security.service.JhZdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zjc
 * @create 2018-11-29 15:02
 * 计划
 */
@RestController
@RequestMapping("/Jh")
public class JhController {

    @Autowired
    private JhZdService jhZdService;

    @Autowired
    private JhRyLrService jhRyLrService;

    @PostMapping("/jhAdd")
    public Result addJhZd(@RequestBody JhZd jhZd){
        Result result = jhZdService.addJhZd(jhZd);
        return result;
    }

    @GetMapping("/jhList")
    public Result getAllJhZd(@RequestParam(required = false,defaultValue = "1") Integer pageNum,
                             @RequestParam(required = false,defaultValue = "10") Integer pageSize,
                             @RequestParam(required = false) String createdate, @RequestParam(value = "jhName",required = false) String jhName){

        Result result = jhZdService.listJhZd(pageNum, pageSize,createdate,jhName);
        return result;
    }

    /**
     * 批量添加人员计划
     * @param list
     * @return
     */
    @PostMapping("/addJhRyList")
    public Result addJhRyLr(@RequestBody  List<JhRylr> list){
        try {
            jhRyLrService.addJhRyLrList(list);
            return Result.success();
        }catch (Exception e){
            e.printStackTrace();
            return Result.error("添加失败");
        }

    }

    @PostMapping("/addOrUpdateJhRy")
    public Result addOrUpdateJhRyLr(JhRylr jhRylr){
        try {
            jhRyLrService.addOrUpdateJhRyLr(jhRylr);
            return Result.success();
        }catch (Exception e){
            e.printStackTrace();
            return Result.error("添加失败");
        }
    }

    /**
     * 根据计划查询人员
     * @param jhId
     * @return
     */
    @GetMapping("/getJhRyListByJhId")
    public Result getJhRyListByJhId(Integer jhId){
        try {
            List<JhRylr> jhrys = jhRyLrService.findJhRyLrByJhId(jhId);
            /**
             * 待封装数据
             */
            return Result.success(jhrys);
        } catch (Exception e) {
            e.printStackTrace();
            return  Result.error("查询失败");
        }
    }

    @GetMapping("/findJhRyLrByEmpId")
    public Result findJhRyLrByEmpId(String empId){
        try {
            List<JhRylr> jhRyLrByEmpId = jhRyLrService.findJhRyLrByEmpId(empId);
            /**
             * 待封装数据
             */
            return Result.success(jhRyLrByEmpId);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("查询失败");
        }
    }


}

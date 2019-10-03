package com.litbo.hospital.lifemanage.check.controller;

import cn.hutool.json.JSONObject;
import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.litbo.hospital.lifemanage.check.pojo.Plan;
import com.litbo.hospital.lifemanage.check.service.PlanService;
import com.litbo.hospital.result.Result;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Check")
@ResponseBody
public class PlanController {
    //下达计划

//    @Autowired
    public Plan plan;

    @Autowired
    private PlanService planService;

    @RequestMapping("/planWork")
    public Result planWork(@RequestBody Plan plan){

        try{
            if (plan != null){
                String bumen[] = null;
                bumen = plan.getBm_id().split(","); //前台传入多选框部门时 转为带逗号的字符串数组
                for (int i=0 ; i<bumen.length; i++){
                    plan.setBm_id(bumen[i]);
                    planService.insertPlan1(plan);
                }
            }else {
                System.out.println("传入参数为空");
            }


        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.success();
    }

    @Test
    public void test(){
        String args = "a,b,c";
//        System.out.println(args.split(","));

        String str [] = null;
        str = args.split(",");
//        System.out.println(str.toString());
        for (String a : str){
            System.out.println(a);
        }

    }
}

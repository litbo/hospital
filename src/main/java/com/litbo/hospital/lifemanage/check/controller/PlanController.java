package com.litbo.hospital.lifemanage.check.controller;


import com.litbo.hospital.lifemanage.check.pojo.Plan;
import com.litbo.hospital.lifemanage.check.service.PlanService;
import com.litbo.hospital.result.Result;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller()
@RequestMapping("/Check")
public class PlanController {
    //下达计划

    public Plan plan;


    public PlanService planService;

    @RequestMapping("/planWork")
    public Result planWork(Plan plan){
        System.out.println("-----------------------------");
        System.out.println("-----------------------------");
        try{
        this.plan = plan;
        String bumen[] = null;
        bumen = plan.getBm_id().split(","); //前台传入多选框部门时 转为带逗号的字符串数组
        for (int i=0 ; i<bumen.length; i++){
            this.plan.setBm_id(bumen[i]);
            System.out.println(bumen[i]);
        }
        planService.insertPlan1(this.plan);

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

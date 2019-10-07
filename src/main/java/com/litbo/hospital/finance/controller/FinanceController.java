package com.litbo.hospital.finance.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.finance.pojo.Finance;
import com.litbo.hospital.finance.service.FinanceService;
import com.litbo.hospital.metering.vo.PageVo;
import com.litbo.hospital.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: 樊小铭
 * Date: 2019/10/7 17:07
 * @Version:
 * @Description:
 */
@RestController
@RequestMapping("/Finance")
public class FinanceController {

    @Autowired
    private FinanceService financeService;


    /**
     * 添加计划
     * @param finance
     * @return
     */
    @RequestMapping("/addFinance.do")
    public Result addFinance(Finance finance){
        System.out.println(finance);
        int result = financeService.addFinance(finance);
        if(result == 0 ){
            return Result.success("添加失败！");
        }
        return Result.success("添加成功！");
    }


    /**
     * 查询所有计划购买的信息
     * @param name 计划名称
     * @param status 投资状态
     * @param pageNum 页码
     * @param pageSize 每页数据量
     * @return
     */
    @RequestMapping("/allFinance.do")
    public PageVo allFinance(@RequestParam(name = "name" , defaultValue = "") String name,
                             @RequestParam(name = "status" , defaultValue = "") String status ,
                             @RequestParam(name = "pageNum" , defaultValue = "1") Integer pageNum ,
                             @RequestParam(name = "pageSize" , defaultValue = "15") Integer pageSize){

        if(name.equals("")){
            name = null;
        }

        if(status.equals("")){
            status = null;
        }

        PageHelper.startPage(pageNum,pageSize);
        List<Finance> list = financeService.allFinance(name,status);

        PageInfo info = new PageInfo(list);

        PageVo vo = new PageVo();
        if(!list.isEmpty()){
            vo.setCode(0);
            vo.setMsg("success");
            vo.setData(vo.new DataEntity((int) info.getTotal(),list));
            return vo;
        }

        vo.setMsg("没有查询到信息");
        vo.setCode(0);
        vo.setData(vo.new DataEntity((int) info.getTotal(),list));
        return vo;

    }





}

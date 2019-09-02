package com.litbo.hospital.beneficial.controller;

import com.litbo.hospital.beneficial.service.CountIncomeService;
import com.litbo.hospital.beneficial.vo.CountIncomeVO;
import com.litbo.hospital.common.utils.calculate.HandleData;
import com.litbo.hospital.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * description: 统计收入
 * @Author: jz
 * @date 2019/7/26 16:51
 */
@RestController
@RequestMapping("/beneficial/import")
public class CountIncomeController {

    @Autowired
    private CountIncomeService countIncomeService;

    public <T> T result(List<CountIncomeVO> list1, List<CountIncomeVO> list2){
        return (T) HandleData.result(list1,list2);
    }


    private int insertHis(){
        List<CountIncomeVO> list = result(countIncomeService.selectHis(),countIncomeService.selectHis());
        if (list.isEmpty()){
            System.out.println("His系统中没有更新数据");
            return -1;
        }else {
            return countIncomeService.insertSbcw(list);
        }
    }

    private int insertPacs(){
        List<CountIncomeVO> list = result(countIncomeService.selectPacs(),countIncomeService.selectPacs());
        if (list.isEmpty()){
            System.out.println("Pacs系统中没有更新数据");
            return -1;
        }else {
            return countIncomeService.insertSbcw(list);
        }
    }

    private int insertSss(){
        List<CountIncomeVO> list = result(countIncomeService.selectSss(),countIncomeService.selectSss());
        if (list.isEmpty()){
            System.out.println("Sss系统中没有更新数据");
            return -1;
        }else {
            return countIncomeService.insertSbcw(list);
        }
    }


    /**
     * 每天凌晨两点导入上一天
     * his、pacs、手术室系统收入数据
     */
    @Scheduled(cron = "0 0 2 * * ?")
    public void timingCountIncome(){
        List<CountIncomeVO> hisList = countIncomeService.timingSelectHis();
        countIncomeService.insertSbcw(hisList);
        List<CountIncomeVO> pacsList = countIncomeService.timingSelectPacs();
        countIncomeService.insertSbcw(pacsList);
        List<CountIncomeVO> sssList = countIncomeService.timingSelectSss();
        countIncomeService.insertSbcw(sssList);
    }


    @RequestMapping(value = "/countIncome",method = RequestMethod.POST)
    public Result countIncome(){
        if ((insertHis()>=0)&&(insertPacs()>=0)&&(insertSss()>=0)){
            return Result.success();
        }else {
            return Result.error();
        }
    }

}

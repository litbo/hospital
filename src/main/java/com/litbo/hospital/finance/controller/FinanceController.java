package com.litbo.hospital.finance.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.finance.pojo.Finance;
import com.litbo.hospital.finance.pojo.FinanceAndEq;
import com.litbo.hospital.finance.service.FinanceService;
import com.litbo.hospital.finance.vo.DeleteVo;
import com.litbo.hospital.finance.vo.FinanceEqVo;
import com.litbo.hospital.finance.vo.FinanceVo;
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
        int result = financeService.addFinance(finance);
        if(result == 0 ){
            return Result.success("添加失败！");
        }
        return Result.success("添加成功！");
    }


    /**
     * 删除
     * @param vo
     * @return
     */
    @RequestMapping("/delProject.do")
    public Result delProject(@RequestBody DeleteVo vo){
        List<String> ids = vo.getIds();
        for(String id : ids){
            financeService.delFinance(id);
        }
        return Result.success();
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

    /**
     * 查看信息
     * @param id
     * @return
     */
    @RequestMapping("/getMessage.do")
    public Result getMessage(String id){
        FinanceVo vo = financeService.getMessage(id);
        return Result.success(vo);
    }

    /**
     * 投资
     * @param id 项目id
     * @param checkPerson 审核人
     * @param amountAdvance  意见
     * @return
     */
    @RequestMapping("/touZi.do")
    public Result touZi(@RequestParam(name = "id" , defaultValue = "") String id ,
                        @RequestParam(name = "checkPerson" , defaultValue = "") String checkPerson ,
                        @RequestParam(name = "amountAdvance" , defaultValue = "") String amountAdvance){
        financeService.touZi(id , checkPerson ,amountAdvance);
        return Result.success();
    }


    /**
     * 关联设备及投资方案
     * @param eq
     * @return
     */
    @RequestMapping("/guanLian.do")
    public Result guanLian(FinanceAndEq eq){
        return Result.success(financeService.getFiance(eq));
    }





    /**
     * 查看已经关联过的设备信息以及投资方案信息
     * @param eqNum  设备编号
     * @param eqName 设备名称
     * @param name  名称
     * @param bmName 部门名称
     * @param pageSize  每页数据量
     * @param pageSize 页码
     * @return
     */
    @RequestMapping("/seeGuanLian.do")
    public PageVo seeGuanLian(@RequestParam(name = "eqNum" , defaultValue = "") String eqNum ,
                              @RequestParam(name = "eqName" , defaultValue = "") String eqName ,
                              @RequestParam(name = "name" , defaultValue = "") String name ,
                              @RequestParam(name = "bmName" , defaultValue = "") String bmName ,
                              @RequestParam(name = "pageNum" , defaultValue = "1") int pageNum ,
                              @RequestParam(name = "pageSize" , defaultValue = "15")int pageSize){
        if(eqName.equals("")){
            eqName = null;
        }

        if(eqNum.equals("")){
            eqNum = null;
        }

        if (name.equals("")){
            name = null;
        }

        if(bmName.equals("")){
            bmName = null;
        }

        PageHelper.startPage(pageNum,pageSize);
        List<FinanceEqVo> vo = financeService.getGuanLian(eqNum, eqName, name, bmName);

        PageInfo info = new PageInfo(vo);

        PageVo pageVo = new PageVo();

        if(vo.isEmpty()){
            pageVo.setMsg("没有查询到设备信息");
            pageVo.setCode(0);
            pageVo.setData(pageVo.new DataEntity((int) info.getTotal(),vo));
            return pageVo;
        }

        pageVo.setCode(0);
        pageVo.setMsg("success");
        pageVo.setData(pageVo.new DataEntity((int) info.getTotal(),vo));
        return pageVo;
    }





}

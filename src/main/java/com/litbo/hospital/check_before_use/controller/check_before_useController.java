package com.litbo.hospital.check_before_use.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.check_before_use.pojo.CheckBeforeUseProject;
import com.litbo.hospital.check_before_use.service.Check_before_useService;
import com.litbo.hospital.check_before_use.vo.EqInfoCheckBeforeUseVo;
import com.litbo.hospital.metering.vo.PageVo;
import com.litbo.hospital.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * @Author: 樊小铭
 * Date: 2019/9/4 20:54
 * @Version:
 * @Description:
 */
@RestController
@RequestMapping("/beforeUse")
public class check_before_useController {

    @Autowired
    private Check_before_useService check_before_useService;


    /**
     * 查看设备信息
     * @param eqNum 编号
     * @param bmName 部门
     * @param eqName 名称
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @RequestMapping("/getEQMessage.do")
    public PageVo getEQMessage(@RequestParam(name = "eqNum",defaultValue = "") String eqNum,
                               @RequestParam(name = "bmName",defaultValue = "")String bmName ,
                               @RequestParam(name = "eqName",defaultValue = "")String eqName,
                               @RequestParam(name = "pageIndex" , defaultValue = "1")int pageIndex,
                               @RequestParam(name = "pageSize" , defaultValue = "15")int pageSize){

        if(eqNum.equals("")){
            eqNum = null;
        }

        if(eqName.equals("")){
            eqName = null;
        }

        if(bmName.equals(""))
        {
            bmName = null;
        }


        PageVo vo = new PageVo();
        PageHelper.startPage(pageIndex,pageSize);
        List<EqInfoCheckBeforeUseVo> eqInfoList = check_before_useService.seeEqMessage(eqNum, bmName, eqName);

        PageInfo info = new PageInfo(eqInfoList);
        if(!eqInfoList.isEmpty()){
            vo.setCode(0);
            vo.setMsg("success");
            vo.setData(vo.new DataEntity((int) info.getTotal(),eqInfoList));
            return vo;
        }
        vo.setMsg("没有查询到设备信息");
        vo.setCode(0);
        vo.setData(vo.new DataEntity((int) info.getTotal(),eqInfoList));
        return vo;
    }


    /**
     * 查看所有的项目名称
     * @return
     */
    @RequestMapping("/seeAllType.do")
    public Result seeAllType(String type){
        List types = check_before_useService.seeAllType(type);
        if(types.isEmpty()){
            return Result.success("未查询到数据");
        }
        return Result.success(types);
    }



    /**
     * 添加项目
     * @param project 项目
     * @return
     */
    @RequestMapping("/addProject.do")
    public Result addProject(CheckBeforeUseProject project){
        int result = check_before_useService.addProject(project);
        if(result == 0){
            return Result.success("添加失败");
        }
        return Result.success(result);
    }

    /**
     * 删除项目
     * @param id
     * @return
     */
    @RequestMapping("/deleteMaintenanceProject.do")
    public Result deleteMaintenanceProject(int id){
        int result = check_before_useService.deleteProject(id);
        if(result == 0){
            return Result.success("添加失败");
        }
        return Result.success(result);
    }



}

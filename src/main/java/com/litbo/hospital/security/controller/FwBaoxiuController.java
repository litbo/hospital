package com.litbo.hospital.security.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.security.bean.FwBaoxiu;
import com.litbo.hospital.security.service.FwBaoxiuService;
import com.litbo.hospital.security.vo.FwBaoxiuIndexVo;
import com.litbo.hospital.security.vo.FwBxLcVo;
import com.litbo.hospital.security.vo.RepairInfoVo;
import com.litbo.hospital.user.vo.LiveEmpVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresGuest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author zjc
 * @create 2018-12-03 11:29
 * 报修
 */
@RestController
@RequestMapping("/baoxiu")
public class FwBaoxiuController {

    @Autowired
    private FwBaoxiuService
            fwBaoxiuService;

    @GetMapping("/bxlc")
    public Result bxlc(){
        try {
            LiveEmpVo sEmp = (LiveEmpVo)SecurityUtils.getSubject().getSession().getAttribute("emp");
            String userId = sEmp.getUserId();
            FwBxLcVo bxLcVo = fwBaoxiuService.getBxLcVo(userId);
            return Result.success(bxLcVo);
        }catch (Exception e){
            e.printStackTrace();
            return Result.error("读取信息失败");
        }
    }

    @GetMapping("/bxlcTable")
    public Result bxlcTable(@RequestParam(required = false,defaultValue = "10") Integer pageSize,
                            @RequestParam(required = false,defaultValue = "1") Integer pageNum,
                            @RequestParam(required = false) String date, @RequestParam(required = false) String eqName
                            , @RequestParam(required = false) Integer bxStatus){
        try {
            LiveEmpVo sEmp = (LiveEmpVo)SecurityUtils.getSubject().getSession().getAttribute("emp");
            String userId = sEmp.getUserId();
            PageInfo pageInfo = fwBaoxiuService.getBxLcTable(userId, pageSize, pageNum,date,eqName,bxStatus);
            return Result.success(pageInfo);
        }catch (Exception e){
            e.printStackTrace();
            return Result.error("读取信息失败");
        }
    }

    @RequiresGuest
    @GetMapping("/wxInfo")
    public Result wxInfoIndexVo(){
        RepairInfoVo repairInfoVo = fwBaoxiuService.wxInfoIndex();
        return Result.success(repairInfoVo);
    }

    @GetMapping("/baoxiuRw")
    public Result baoxiuRw(@RequestParam(required = false,defaultValue = "10") Integer pageSize,
                           @RequestParam(required = false,defaultValue = "1") Integer pageNum){
        try {
            LiveEmpVo sEmp = (LiveEmpVo)SecurityUtils.getSubject().getSession().getAttribute("emp");
            String userId = sEmp.getUserId();
            String roleName = (String) SecurityUtils.getSubject().getSession().getAttribute("rolename");

            PageInfo pageInfo = fwBaoxiuService.baoxiuRw(userId, pageNum, pageSize, roleName);
            return Result.success(pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("读取信息失败");
        }
    }

    /**
     * 设备
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/baoxiuEq")
    public Result baoxiuEq(@RequestParam(required = false,defaultValue = "1") Integer pageNum,
                           @RequestParam(required = false,defaultValue = "10") Integer pageSize,
                           @RequestParam(required = false) String bmName, @RequestParam(required = false) String eqName){
        try {
            LiveEmpVo sEmp = (LiveEmpVo)SecurityUtils.getSubject().getSession().getAttribute("emp");
            String userId = sEmp.getUserId();
            System.out.println(eqName);
            PageInfo pageInfo = fwBaoxiuService.getBaoxiuEq(userId, pageSize, pageNum,bmName,eqName);
            return Result.success(pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("读取信息错误");
        }
    }

    /**
     * 报修页面 初始化
     * @param eqId
     * @return
     */
    @GetMapping("/baoxiuIndex")
    public Result baoxiuIndex(String eqId){
//        SecurityUtils.getSubject().getSession().getAttribute("");
        try {
            LiveEmpVo sEmp = (LiveEmpVo) SecurityUtils.getSubject().getSession().getAttribute("emp");
            String userId = sEmp.getUserId();
            FwBaoxiuIndexVo baoxiuIndexVo = fwBaoxiuService.baoxiuIndex(eqId, userId);
            return Result.success(baoxiuIndexVo);
        }
        catch (Exception e) {
            e.printStackTrace();
            return Result.error("返回数据失败");
        }
    }

    /**
     * 添加报修单
     * @param fwBaoxiu
     * @return
     */
    @PostMapping("/addBaoxiu")
    public Result addBaoxiu(FwBaoxiu fwBaoxiu){
        try {
            int i = fwBaoxiuService.addBaoxiu(fwBaoxiu);
            if(i == 1){
                return Result.success();
            }else {
                return Result.error("该设备不在可用状态");
            }

        } catch (Exception e) {
            e.printStackTrace();
            return Result.error();
        }
    }

    /**
     * 更改状态
     * @param id
     * @param baoxiuStatus
     * @return
     */
    @GetMapping("/updateBaoxiuStatus")
    public Result updateBaoxiuStatus(String id,Integer baoxiuStatus){
        try {
            fwBaoxiuService.updateBaoxiuStatusById(id,baoxiuStatus);
            return Result.success();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error();
        }
    }

    @RequestMapping(value = "listWx",method = RequestMethod.POST)
    public Result listWx(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                         @RequestParam(value = "pageSize" ,required = false,defaultValue="10")int pageSize){
        PageInfo pageInfo = fwBaoxiuService.listWx(pageNum,pageSize);
        return Result.success(pageInfo);
    }

    @RequestMapping(value = "listWxTitles",method = RequestMethod.POST)
    public Result listWxTitles(){
        String title ="[{'type': 'radio'}, "+
                "{field: 'fpDh', title: '维修单号'},"+
                "{field: 'eqName', title: '配件名称'},"+
                "{field: 'eqGg', title: '规格'},"+
                "{field: 'eqXh', title: '型号'},"+
                "{field: 'wxfCjrgf', title: '费用'},"+
                "{field: 'bmName', title: '部门'}"+
                "]";
        return Result.success(JSON.parseArray(title));
    }
}

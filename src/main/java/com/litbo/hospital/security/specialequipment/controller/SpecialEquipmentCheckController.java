package com.litbo.hospital.security.specialequipment.controller;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.security.specialequipment.bean.SpecialEquipment;
import com.litbo.hospital.security.specialequipment.bean.vo.DeleteSpeqsVo;
import com.litbo.hospital.security.specialequipment.service.SpecialEquipmentCheckService;
import com.litbo.hospital.user.vo.LiveEmpVo;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/specialEqCheck")
public class SpecialEquipmentCheckController {

    @Autowired
    private SpecialEquipmentCheckService
            specialEquipmentCheckService;

    //同意送检申请
    @PostMapping("/applicationForInspection")
    public Result applicationForInspection(@RequestBody DeleteSpeqsVo deleteSpeqsVo) {

        try {
            String[] speqIds = deleteSpeqsVo.getSpeqIds();
            LiveEmpVo sEmp = (LiveEmpVo) SecurityUtils.getSubject().getSession().getAttribute("emp");
            specialEquipmentCheckService.applicationForInspection(speqIds, sEmp);
            return Result.success(speqIds.length);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("读取信息错误");
        }

    }


    //查询所有特种设备检测申请信息
    @GetMapping("/selectSpecialEquipmentCheckVoBy0")
    public Result selectSpecialEquipmentCheckVoBy0(@RequestParam(required = false,defaultValue = "10") Integer pageSize,
                                                @RequestParam(required = false,defaultValue = "1") Integer pageNum){
        try {
            PageInfo pageInfo = specialEquipmentCheckService.selectSpecialEquipmentCheckVoBy0(pageNum, pageSize);
            return Result.success(pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("读取信息错误");
        }
    }
    //查询所有特种设备检测申请信息name 科室 生产商
    @PostMapping("/selectSpecialEquipmentCheckVoByNameAndBmIdAndScsBy0")
    public Result selectSpecialEquipmentCheckVoByNameAndBmIdAndScsBy0(@RequestParam(required = false,defaultValue = "10") Integer pageSize,
                                                                     @RequestParam(required = false,defaultValue = "1") Integer pageNum,
                                                                      @RequestParam("speqBh") String speqBh,
                                                                     @RequestParam("speqName") String speqName,
                                                                     @RequestParam("bmId") String bmId,
                                                                     @RequestParam("speqScs") String speqScs){
        try {
            PageInfo pageInfo = specialEquipmentCheckService.selectSpecialEquipmentCheckVoByNameAndBmIdAndScsBy0(pageNum, pageSize,speqBh, speqName, bmId, speqScs);
            return Result.success(pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("读取信息错误");
        }
    }


    //查询所有特种设备检测待审批信息
    @GetMapping("/selectSpecialEquipmentCheckVoBy1")
    public Result selectSpecialEquipmentCheckVoBy1(@RequestParam(required = false,defaultValue = "10") Integer pageSize,
                                                @RequestParam(required = false,defaultValue = "1") Integer pageNum){
        try {
            PageInfo pageInfo = specialEquipmentCheckService.selectSpecialEquipmentCheckVoBy1(pageNum, pageSize);
            return Result.success(pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("读取信息错误");
        }
    }
    //查询所有特种设备检测申请信息name 科室 生产商
    @PostMapping("/selectSpecialEquipmentCheckVoByNameAndBmIdAndScsBy1")
    public Result selectSpecialEquipmentCheckVoByNameAndBmIdAndScsBy1(@RequestParam(required = false,defaultValue = "10") Integer pageSize,
                                                                   @RequestParam(required = false,defaultValue = "1") Integer pageNum,
                                                                   @RequestParam("speqBh") String speqBh,
                                                                   @RequestParam("speqName") String speqName,
                                                                   @RequestParam("bmId") String bmId,
                                                                   @RequestParam("speqScs") String speqScs){
        try {
            PageInfo pageInfo = specialEquipmentCheckService.selectSpecialEquipmentCheckVoByNameAndBmIdAndScsBy1(pageNum, pageSize, speqBh, speqName, bmId, speqScs);
            return Result.success(pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("读取信息错误");
        }
    }

    //同意送检审批
    @PostMapping("/applicationForApprove")
    public Result applicationForApprove(@RequestBody DeleteSpeqsVo deleteSpeqsVo) {

        try {
            String[] speqIds = deleteSpeqsVo.getSpeqIds();
            LiveEmpVo sEmp = (LiveEmpVo) SecurityUtils.getSubject().getSession().getAttribute("emp");
            specialEquipmentCheckService.applicationForApprove(speqIds, sEmp);
            return Result.success(speqIds.length);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("读取信息错误");
        }

    }


    //查询所有特种设备待录入结果
    @GetMapping("/selectSpecialEquipmentCheckVoBy2")
    public Result selectSpecialEquipmentCheckVoBy2(@RequestParam(required = false,defaultValue = "10") Integer pageSize,
                                                   @RequestParam(required = false,defaultValue = "1") Integer pageNum){
        try {
            PageInfo pageInfo = specialEquipmentCheckService.selectSpecialEquipmentCheckVoBy2(pageNum, pageSize);
            return Result.success(pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("读取信息错误");
        }
    }
    //查询所有特种设备检测申请信息name 科室 生产商
    @PostMapping("/selectSpecialEquipmentCheckVoByNameAndBmIdAndScsBy2")
    public Result selectSpecialEquipmentCheckVoByNameAndBmIdAndScsBy2(@RequestParam(required = false,defaultValue = "10") Integer pageSize,
                                                                      @RequestParam(required = false, defaultValue = "1") Integer pageNum,
                                                                      @RequestParam("speqBh") String speqBh,
                                                                      @RequestParam("speqName") String speqName,
                                                                      @RequestParam("bmId") String bmId,
                                                                      @RequestParam("speqScs") String speqScs){
        try {
            PageInfo pageInfo = specialEquipmentCheckService.selectSpecialEquipmentCheckVoByNameAndBmIdAndScsBy2(pageNum, pageSize, speqBh, speqName, bmId, speqScs);
            return Result.success(pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("读取信息错误");
        }
    }
    //特种设备结果录入第一步更改数据
    //特种设备结果录入第二步记录到记录表中
    @PostMapping("/inspectionResultInput")
    public Result inspectionResultInput(@RequestBody SpecialEquipment specialEquipment){
        try {
            int i = specialEquipmentCheckService.inspectionResultInput(specialEquipment);
            return Result.success(i);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("读取信息错误");
        }
    }






}

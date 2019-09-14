package com.litbo.hospital.lifemanage.checkBeforeUse.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.lifemanage.checkBeforeUse.service.SpecificationService;
import com.litbo.hospital.lifemanage.checkBeforeUse.vo.SaveStandardProjectVO;
import com.litbo.hospital.lifemanage.checkBeforeUse.vo.SaveStandardVO;
import com.litbo.hospital.lifemanage.checkBeforeUse.vo.SearchStandardVO;
import com.litbo.hospital.result.Result;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lifeManager")
public class SpecificationController {

    @Autowired
    private SpecificationService specificationService;


    /**
     * 查找所有设备
     * @return 所有设备信息
     */
    @GetMapping("getEqInfos")
    public Result getEqInfos(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                             @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize){
        return Result.success(specificationService.searchEqInfos(pageNum,pageSize));
    }


    @GetMapping("eqInfosTitle")
    public Result eqInfosTitle(){
        String title ="[{'type': 'radio'}, "+
                "{field: 'bmName', title: '部门名称'},"+
                "{field: 'eqId', title: '设备id'},"+
                "{field: 'eqName', title: '设备名称'},"+
                "{field: 'eqSbbh', title: '设备编号'},"+
                "{field: 'eqZcbh', title: '资产编号'},"+
                "{field: 'eqGg', title: '设备规格'},"+
                "{field: 'eqXh', title: '设备型号'},"+
                "{field: 'eqQysj', title: '启用时间'},"+
                "{field: 'eqPp', title: '品牌'}"+
                "]";
        return Result.success(JSON.parseArray(title));
    }


    @GetMapping("getUsers")
    public Result getUsers(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                           @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize){
        return Result.success(specificationService.searchUsers(pageNum,pageSize));
    }


    @GetMapping("getAppointUsers")
    public Result geAppointUsers(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                                 @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize,
                                 String name){
        return Result.success(specificationService.searchAppointUsers(pageNum,pageSize,name));
    }


    @GetMapping("getAppointEqInfos")
    public Result getAppointEqInfos(Integer pageNum, Integer pageSize,
                                    @RequestParam(required = false,value = "eqSbbh") String sbbh,
                                    @RequestParam(required = false,value = "eqName") String eqName,
                                    @RequestParam(required = false,value = "eqPym") String eqPym,
                                    @RequestParam(required = false,value = "bmName") String bmName){

        return Result.success(specificationService.searchAppointEqInfos(pageNum,pageSize,sbbh,eqName,eqPym,bmName));
    }


    @PostMapping("saveStandard")
    public Result saveStandard(@RequestBody SaveStandardVO saveStandardVO){


        System.out.println(saveStandardVO);

        Integer standardId = specificationService.saveStandard(saveStandardVO);


        List<SaveStandardProjectVO> list = saveStandardVO.getList();


        if (!list.isEmpty()) {
            Integer s = specificationService.saveStandardProject(standardId, list);
        }

        return Result.success("success");
    }


    @GetMapping("searchAllStandards")
    public Result searchAllStandards(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                                     @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize,
                                     @RequestParam(required = false,value = "result") Integer result){
        PageInfo<SearchStandardVO> pageInfo = specificationService.searchAllStandards(pageNum,pageSize,result);
        return Result.success(pageInfo);
    }


    @GetMapping("getStandard")
    public Result searchStandard(Integer standardId){
        SearchStandardVO standardVO = specificationService.searchStandard(standardId);
        return Result.success(standardVO);
    }

    @PostMapping("saveStandardResult")
    public Result saveStandardResult(Integer standardId,Integer result){
        String r = specificationService.updateStandardResult(standardId,result);
        return Result.success(r);
    }

















}

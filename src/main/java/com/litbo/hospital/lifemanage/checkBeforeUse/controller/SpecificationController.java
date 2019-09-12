package com.litbo.hospital.lifemanage.checkBeforeUse.controller;

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
    public Result getEqInfos(Integer pageNum, Integer pageSize){
        return Result.success(specificationService.searchEqInfos(pageNum,pageSize));
    }


    @GetMapping("getUsers")
    public Result getUsers(Integer pageNum, Integer pageSize){
        return Result.success(specificationService.searchUsers(pageNum,pageSize));
    }


    @GetMapping("getAppointUsers")
    public Result geAppointUsers(Integer pageNum,Integer pageSize,String name){
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
    public Result searchAllStandards(Integer pageNum,Integer pageSize,@RequestParam(required = false,value = "result") Integer result){
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

package com.litbo.hospital.supervise.controller;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.supervise.bean.SBm;
import com.litbo.hospital.supervise.bean.SGroup;
import com.litbo.hospital.supervise.service.BmService;
import com.litbo.hospital.supervise.service.GroupService;
import com.litbo.hospital.supervise.vo.GroupInsertDetailVO;
import com.litbo.hospital.supervise.vo.GroupReadyForSubmitVO;
import com.litbo.hospital.supervise.vo.GroupSelectDetailVO;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sybm/ksgl")
@Api(tags = "科室团队管理")
public class GroupController {

    @Autowired
    private GroupService groupService;

    @Autowired
    private BmService bmService;

    @GetMapping("/listGroups")
    public Result getGroups(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                            @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize){
        PageInfo pageInfo = groupService.getGroups(pageNum,pageSize);
        return Result.success(pageInfo);
    }

    @GetMapping("/listSelectGroups")
    public Result getSelectGroups(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                            @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize){
        PageInfo pageInfo = groupService.getSelectGroups(pageNum,pageSize);
        return Result.success(pageInfo);
    }

    @GetMapping("/getGroupById")
    public Result getGroupById(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                               @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize,
                               @RequestParam String group_id){
        SGroup date = groupService.getGroupById(pageNum, pageSize, group_id);
        return Result.success(date);
    }

    @GetMapping("/readyForSubmit")
    public Result readyForSubmit(){
        // 获取所有部门
        List<SBm> bmList = bmService.getYZBmList();
        //  审核人准备
        GroupReadyForSubmitVO submitVO = new GroupReadyForSubmitVO();
        submitVO.setBms(bmList);
        return Result.success(submitVO);
    }


    @PostMapping("/submitGroups")
    public Result submitGroups(@RequestBody GroupInsertDetailVO groupInsertDetailVO){

        groupService.submitGroups(groupInsertDetailVO);
        return Result.success();
    }

    @GetMapping("/getDshGroupByShr")
    public Result getDshGroupByShr(@RequestParam String shrId){

        SGroup sGroup = groupService.getDshGroupByShr(shrId);
        return Result.success(sGroup);
    }

    @GetMapping("/getGroupDetailByGId")
    public Result getGroupDetailByGId(@RequestParam String gid){

        GroupSelectDetailVO vo = groupService.getGroupDetailByGId(gid);
        return Result.success(vo);
    }


    @PostMapping("/shrShGroup")
    public Result shrShGroup(@RequestBody GroupInsertDetailVO groupInsertDetailVO){

        groupService.shrShGroup(groupInsertDetailVO);
        return Result.success();
    }
    @GetMapping("/getYTHGroup")
    public Result getYTHGroup(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                              @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize){

        PageInfo date =  groupService.getYTHGroup(pageNum,pageSize);
        return Result.success(date);
    }



}

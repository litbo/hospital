package com.litbo.hospital.supervise.controller;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.supervise.service.BmGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/supervise/bmgroup")
public class BmGroupController {
    @Autowired
    private BmGroupService bmGroupService;

    @GetMapping("/ListBmGroupMembers")
    @ResponseBody
    public Result getBmGroupMembers(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                                    @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize){
        PageInfo pageInfo = bmGroupService.getBmGroupMembers(pageNum,pageSize);
        return Result.success(pageInfo);
    }

    @GetMapping("/ListBmGroupMembersByBmId")
    @ResponseBody
    public Result getBmGroupMembersByBmId(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                                    @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize,
                                          @RequestParam String bm_id){
        PageInfo pageInfo = bmGroupService.getBmGroupMembersByBmId(pageNum,pageSize,bm_id);
        return Result.success(pageInfo);
    }
}

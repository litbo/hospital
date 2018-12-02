package com.litbo.hospital.supervise.controller;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.supervise.bean.SGroup;
import com.litbo.hospital.supervise.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/supervise/group")
public class SGruopController {
    @Autowired
    private GroupService groupService;

    @GetMapping("/ListGroups")
    @ResponseBody
    public Result getGroups(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                                    @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize){
        PageInfo pageInfo = groupService.getGroups(pageNum,pageSize);
        return Result.success(pageInfo);
    }

    @GetMapping("/GetGroupById")
    @ResponseBody
    public Result getGroupById(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                                    @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize,
                                @RequestParam String group_id){
        SGroup date = groupService.getGroupById(pageNum, pageSize, group_id);
        return Result.success(date);
    }
}

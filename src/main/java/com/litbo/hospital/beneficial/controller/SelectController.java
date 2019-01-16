package com.litbo.hospital.beneficial.controller;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.supervise.service.BmService;
import com.litbo.hospital.user.service.EqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/benefical/select")
public class SelectController {

    @Autowired
    EqService es;

    @Autowired
    private BmService bmService;


    @RequestMapping(value = "/listSelect")
    public Result listSelect(@RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
                                @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize,
                                String key) {
        if(key.equals("eq")) {
            PageInfo date = es.listShowEqs(pageNum, pageSize);
            return Result.success(date);
        }
        if(key.equals("bm")) {
            PageInfo date = bmService.getBmList(pageNum,pageSize);
            return Result.success(date);
        }
        else
            return null;
    }

    @RequestMapping(value = "/listSelectCols")
    public Result listSelectCols(@RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
                                @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize,
                                String key) {
        if(key.equals("eq")) {
            PageInfo date = es.listShowEqs(pageNum, pageSize);
            return Result.success(date);
        }
        if(key.equals("bm")) {

            String jsonMessage = "[{'type': 'radio'}, "+"{field: 'bmName', title: '科室名称'}]";
            JSONArray myJsonArray = JSONObject.parseArray(jsonMessage);
            PageInfo date = new PageInfo(myJsonArray);
            return Result.success(date);
        }
        else
            return null;
    }
}

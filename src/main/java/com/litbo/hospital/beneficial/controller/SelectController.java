package com.litbo.hospital.beneficial.controller;


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
    public Result listCbAccount(@RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
                                @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize,
                                String key) {
        if(key.equals("eq")) {
            return Result.success(es.listShowEqs(pageNum, pageSize));
        }
        if(key.equals("bm")) {
            return Result.success(bmService.getBmList(pageNum,pageSize));
        }
        else
            return null;
    }
}

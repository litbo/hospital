package com.litbo.hospital.beneficial.controller;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.beneficial.service.BAccountService;
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

    @Autowired
    private BAccountService bAccountService;


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
        if(key.equals("cbkm")) {
            PageInfo date = bAccountService.listCbAccount(pageNum,pageSize);
            return Result.success(date);
        }
        if(key.equals("srkm")) {
            PageInfo date = bAccountService.listSrAccount(pageNum,pageSize);
            return Result.success(date);
        }
        else
            return null;
    }

    @RequestMapping(value = "/listSelectCols")
    public Result listSelectCols(@RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
                                @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize,
                                String key) {
        if(key.equals("bm")) {
            String jsonMessage = "[{'type': 'radio'}, "+"{field: 'bmName', title: '科室名称'}]";
            JSONArray myJsonArray = JSONObject.parseArray(jsonMessage);
            PageInfo date = new PageInfo(myJsonArray);
            return Result.success(date);
        }
        if(key.equals("eq")) {

            /*
            * "eqId": 10000,
                "eqSbbh": "181268031101310000",
                "eqName": "设备名称",
                "eqZcbh": "11111",
                "eqPmName": null,
                "eqGg": "测试规格1",
                "eqXh": "测试型号1",
                "bmName": "管理部门",
                "eqQysj": "2017-06-04T16:00:00.000+0000",
                "eqSyzt": "在用"
            * */
            String jsonMessage = "[{'type': 'radio'}, "+
                    "{field: 'eqSbbh', title: '设备编号'},"+
                    "{field: 'eqName', title: '设备名称'},"+
                    "{field: 'eqXh', title: '型号'},"+
                    "{field: 'eqGg', title: '规格'},"+
                    "{field: 'bmName', title: '所属科室'},"+
                    "{field: 'bmSyzt', title: '使用状态'},"+
                    "]";

            JSONArray myJsonArray = JSONObject.parseArray(jsonMessage);
            PageInfo date = new PageInfo(myJsonArray);
            return Result.success(date);
        }

        if(key.equals("cbkm")) {
            String jsonMessage = "[{'type': 'radio'}, " + "{field: 'kmName', title: '科目名称'}"+"{field: 'kmNum', title: '科目编号'}]";
            JSONArray myJsonArray = JSONObject.parseArray(jsonMessage);
            PageInfo date = new PageInfo(myJsonArray);
            return Result.success(date);
        }

        if(key.equals("srkm")) {
            String jsonMessage = "[{'type': 'radio'}, " + "{field: 'kmName', title: '科目名称'}"+"{field: 'kmNum', title: '科目编号'}]";
            JSONArray myJsonArray = JSONObject.parseArray(jsonMessage);
            PageInfo date = new PageInfo(myJsonArray);
            return Result.success(date);
        }
        else
            return null;
    }
}

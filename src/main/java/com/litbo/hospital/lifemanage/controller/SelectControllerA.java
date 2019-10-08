package com.litbo.hospital.lifemanage.controller;
import com.litbo.hospital.lifemanage.service.SelectService;
import com.litbo.hospital.result.Result;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/checkInfo")
public class SelectControllerA {
    @Autowired
    private SelectService selectService;
    @ResponseBody
    @RequestMapping("/existInfo") //已盘
    public Result existInfoController(@RequestParam("pdJhid")String pdJhid,
                                 @RequestParam("bmId") String bmId
            ,@RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum
            ,@RequestParam(value = "pageSize",defaultValue = "15")Integer pageSize){
        return Result.success(selectService.selectAll(pdJhid,bmId,pageNum,pageSize));
    }

    @ResponseBody
    @RequestMapping("/notExist")//盘亏的
    public Result noteExistController(@RequestParam("pdJhid")String pdJhid,
                                      @RequestParam("bmId") String bmId
            ,@RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum
            ,@RequestParam(value = "pageSize",defaultValue = "15")Integer pageSize){

        return Result.success(selectService.selectNot(pdJhid,bmId,pageNum,pageSize));

    }
    @ResponseBody
    @RequestMapping("/allList")//盘点所有的
    public Result allListController(@RequestParam("pdJhid")String pdJhid,
                                      @RequestParam("bmId") String bmId
            ,@RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum
            ,@RequestParam(value = "pageSize",defaultValue = "15")Integer pageSize){

        return Result.success(selectService.allList(pdJhid,bmId,pageNum,pageSize));

    }
    @ResponseBody
    @RequestMapping("/selectLess")//盘盈的
    public Result selectLessController(@RequestParam("pdJhid")String pdJhid,
                                    @RequestParam("bmId") String bmId
            ,@RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum
            ,@RequestParam(value = "pageSize",defaultValue = "15")Integer pageSize){

        return Result.success(selectService.selectLess(pdJhid,bmId,pageNum,pageSize));

    }

}

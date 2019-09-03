package com.litbo.hospital.efficiency.configratio.controller;

import com.litbo.hospital.efficiency.configratio.bean.FunctionUsingBean;
import com.litbo.hospital.efficiency.configratio.service.FunctionUsingService;
import com.litbo.hospital.efficiency.configratio.vo.DeleteVO;
import com.litbo.hospital.efficiency.configratio.vo.FunctionUsingRatioVO;
import com.litbo.hospital.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * description: 功能利用率
 * @author: sz
 * @date: 2019/8/29 13:05
 */
@RestController
@RequestMapping("/config/ratio")
public class FunctionUsingController {

    @Autowired
    private FunctionUsingService usingService;

    private Integer integer;

    @RequestMapping(value = "/addUsing",method = RequestMethod.POST)
    public Result addUsing(FunctionUsingBean usingBean){
        if (usingService.addFunctionUsing(usingBean)>0){
            return Result.success();
        }else {
            return Result.error();
        }
    }

    @RequestMapping(value = "/showUsing",method = RequestMethod.GET)
    public Result showUsing(@RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
                            @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize){
        return Result.success(usingService.showUsing(pageNum, pageSize));
    }

    @RequestMapping(value = "/showUsingById",method = RequestMethod.POST)
    public void showUsingById(@RequestParam Integer id){
        integer = id;
    }

    @RequestMapping(value = "/returnUsing",method = RequestMethod.POST)
    public Result returnUsing(){
        return Result.success(usingService.showUsingById(integer));
    }

    @RequestMapping(value = "/updateUsing",method = RequestMethod.POST)
    public Result updateUsing(FunctionUsingRatioVO usingRatioVO){
        usingRatioVO.setId(integer);
        if (usingService.updateUsing(usingRatioVO)>0){
            return Result.success("已更改成功");
        }else {
            return Result.error("修改失败");
        }
    }


    @RequestMapping(value = "/deleteUsing",method = RequestMethod.DELETE)
    public Result deleteUsing(@RequestBody DeleteVO deleteVO){
        if (deleteVO.getIds()!=null){
            Integer integer= usingService.deleteUsing(deleteVO.getIds());
            if (integer>0){
                return Result.success("已删除"+integer+"个设备");
            }else {
                return Result.error("请选中需要删除的设备");
            }
        }else {
            return Result.error();
        }
    }

}

package com.litbo.hospital.efficiency.configratio.controller;

import com.litbo.hospital.efficiency.configratio.bean.FunctionUsingBean;
import com.litbo.hospital.efficiency.configratio.service.FunctionUsingService;
import com.litbo.hospital.efficiency.configratio.vo.FunctionUsingRatioVO;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.supervise.vo.GangweiDeleteVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    @RequestMapping(value = "/addUsing",method = RequestMethod.POST)
    public Result addUsing(FunctionUsingBean usingBean){
        return Result.success(usingService.addFunctionUsing(usingBean));
    }

    @RequestMapping(value = "/showUsing",method = RequestMethod.GET)
    public Result showUsing(@RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
                            @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize){
        return Result.success(usingService.showUsing(pageNum, pageSize));
    }

    @RequestMapping(value = "/showUsingById",method = RequestMethod.POST)
    public Result showUsingById(@RequestParam Integer id){
        System.out.println("++++++++++");
        System.out.println(id);
        return Result.success(usingService.showUsingById(id));

    }

    @RequestMapping(value = "/updateUsing",method = RequestMethod.POST)
    public Result updateUsing(FunctionUsingRatioVO usingRatioVO){
        if (usingService.updateUsing(usingRatioVO)>0){
            return Result.success("已更改成功");
        }else {
            return Result.error("修改失败");
        }
    }


    @RequestMapping(value = "/deleteUsing",method = RequestMethod.DELETE)
    public Result deleteUsing(@RequestBody GangweiDeleteVO gangweiDeleteVO){
        String[] ids = gangweiDeleteVO.getGwIds();
        int k = ids.length;
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            int i1 = Integer.parseInt(ids[i]);
            integers.add(i1);
        }

        Integer integer= usingService.deleteUsing(integers);


        if (integer>0){
            return Result.success("已删除"+integer+"个设备");
        }else {
            return Result.error("请选中需要删除的设备");
        }
    }

}

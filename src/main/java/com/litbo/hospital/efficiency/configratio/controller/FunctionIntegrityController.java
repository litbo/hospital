package com.litbo.hospital.efficiency.configratio.controller;

import com.litbo.hospital.efficiency.configratio.bean.FunctionIntegrityBean;
import com.litbo.hospital.efficiency.configratio.service.FunctionIntegrityService;
import com.litbo.hospital.efficiency.configratio.vo.DeleteVO;
import com.litbo.hospital.efficiency.configratio.vo.FunctionIntegrityRatioVO;
import com.litbo.hospital.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * description: 功能完好率
 * @author: sz
 * @date: 2019/8/29 13:08
 */
@RestController
@RequestMapping("/config/ratio")
public class FunctionIntegrityController {

    @Autowired
    private FunctionIntegrityService integrityService;

    private Integer integer;

    @RequestMapping(value = "/addIntegrity",method = RequestMethod.POST)
    public Result addIntegrity(FunctionIntegrityBean integrityBean){
        return Result.success(integrityService.addFunctionIntegrity(integrityBean));
    }

    @RequestMapping(value = "/showIntegrity",method = RequestMethod.GET)
    public Result showIntegrity(@RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
                                @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize){
        return Result.success(integrityService.showIntegrity(pageNum, pageSize));
    }

    @RequestMapping(value = "/showIntegrityById",method = RequestMethod.POST)
    public void showIntegrityById(Integer id){
        integer = id;
    }

    @RequestMapping(value = "/returnIntegrity",method = RequestMethod.POST)
    public Result returnIntegrity(){
        return Result.success(integrityService.showIntegrityById(integer));
    }

    @RequestMapping(value = "/updateIntegrity",method = RequestMethod.POST)
    public Result updateIntegrity(FunctionIntegrityRatioVO integrityRatioVO){
        if (integrityService.updateIntegrity(integrityRatioVO)>0){
            return Result.success("已更改成功");
        }else {
            return Result.error("修改失败");
        }
    }

    @RequestMapping(value = "/deleteIntegrity",method = RequestMethod.POST)
    public Result deleteIntegrity(@RequestBody DeleteVO deleteVO){
        if (deleteVO.getIds()!=null){
            Integer integer = integrityService.deleteIntegrity(deleteVO.getIds());
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

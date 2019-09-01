package com.litbo.hospital.efficiency.configratio.controller;

import com.litbo.hospital.efficiency.configratio.bean.ForecastBean;
import com.litbo.hospital.efficiency.configratio.service.ForecastService;
import com.litbo.hospital.efficiency.configratio.vo.DeleteVO;
import com.litbo.hospital.efficiency.configratio.vo.ForecastRatioVO;
import com.litbo.hospital.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * description: 功能预测率
 * @author: sz
 * @date: 2019/8/29 13:10
 */
@RestController
@RequestMapping("/config/ratio")
public class ForecastController {


    @Autowired
    private ForecastService forecastService;

    private Integer integer;

    @RequestMapping(value = "/addForecast",method = RequestMethod.POST)
    public Result addForecast(ForecastBean forecastBean){
        if (forecastService.addForecast(forecastBean)>0){
            return Result.success();
        }else {
            return Result.error();
        }
    }

    @RequestMapping(value = "/showForecast",method = RequestMethod.GET)
    public Result showForecast(@RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
                               @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize){
        return Result.success(forecastService.showForecast(pageNum, pageSize));
    }

    @RequestMapping(value = "/showForecastById",method = RequestMethod.POST)
    public void showForecastById(Integer id){
        integer = id;

    }

    @RequestMapping(value = "/returnForecast",method = RequestMethod.POST)
    public Result returnForecast(){
        return Result.success(forecastService.showForecastById(integer));
    }

    @RequestMapping(value = "/updateForecast",method = RequestMethod.POST)
    public Result updateForecast(ForecastRatioVO forecastRatioVO){
        if (forecastService.updateForecast(forecastRatioVO)>0){
            return Result.success("已更改成功");
        }else {
            return Result.error("修改失败");
        }
    }

    @RequestMapping(value = "/deleteForecast",method = RequestMethod.DELETE)
    public Result deleteForecast(@RequestBody DeleteVO deleteVO){
        if (deleteVO.getIds()!=null){
            Integer integer = forecastService.deleteForecast(deleteVO.getIds());
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

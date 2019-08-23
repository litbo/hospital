package com.litbo.hospital.efficiency.controller;

import com.litbo.hospital.efficiency.service.EfficiencyLevelService;
import com.litbo.hospital.efficiency.vo.EfficiencyLevelVO;
import com.litbo.hospital.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * description: 效率等级
 * @author: sz
 * @date: 2019/8/6 9:29
 */
@RestController
@RequestMapping("/level/show")
public class EfficiencyLevelController {

    @Autowired
    private EfficiencyLevelService levelService;

    @RequestMapping("/selectLevel")
    public Result selectLevel(@RequestParam(value = "pageNum",required = false,defaultValue = "1") int pageNum,
                              @RequestParam(value = "pageSize",required = false,defaultValue = "10") int pageSize){

        return Result.success(levelService.selectLevel(pageNum, pageSize));
    }

    @RequestMapping("/selectLevelByCon")
    public Result selectLevelByCon(@RequestParam(value = "pageNum",required = false,defaultValue = "1") int pageNum,
                                   @RequestParam(value = "pageSize",required = false,defaultValue = "10") int pageSize,
                                   @RequestBody EfficiencyLevelVO vo){

        return Result.success(levelService.selectLevelByCon(pageNum, pageSize, vo));
    }


}

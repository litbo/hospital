package com.litbo.hospital.efficiency.controller;

import com.litbo.hospital.efficiency.service.OpenService;
import com.litbo.hospital.efficiency.vo.OpenVO;
import com.litbo.hospital.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * description:开机率的Controller层
 * @Author: jz
 * @Date: 2019/8/1 10:40
 */

@RestController
@RequestMapping("/kpi/open")
public class OpenController {

    @Autowired
    private OpenService openService;

    @RequestMapping("/selectOpen")
    public Result selectOpen(@RequestParam(value = "pageNum",required = false,defaultValue = "1") int pageNum,
                             @RequestParam(value = "pageSize",required = false,defaultValue = "10") int pageSize){
        return Result.success(openService.selectOpen(pageNum, pageSize));
    }

    @RequestMapping("/selectOpenByCon")
    public Result selectOpenByCon(@RequestParam(value = "pageNum",required = false,defaultValue = "1") int pageNum,
                                  @RequestParam(value = "pageSize",required = false,defaultValue = "10") int pageSize,
                                  @RequestBody OpenVO openVO){

        return Result.success(openService.selectOpenByCon(pageNum, pageSize, openVO));
    }

}

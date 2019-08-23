package com.litbo.hospital.efficiency.controller;

import com.litbo.hospital.efficiency.service.IdlingService;
import com.litbo.hospital.efficiency.vo.IdlingVO;
import com.litbo.hospital.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * description: 空转率Controller
 * @Author: jz
 * date: 2019/8/1 16:28
 */
@RestController
@RequestMapping(value = "/kpi/idling")
public class IdlingController {

    @Autowired
    private IdlingService idlingService;

    @RequestMapping("/selectIdling")
    public Result selectIdling(@RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
                               @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize) {
        return Result.success(idlingService.selectIdling(pageNum, pageSize));
    }

    @RequestMapping("/selectIdlingByCon")
    public Result selectIdlingByCon(@RequestParam(value = "pageNUm", required = false, defaultValue = "1") int pageNum,
                                    @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize,
                                    @RequestBody IdlingVO idlingVO) {
        return Result.success(idlingService.selectIdlingByCon(pageNum, pageSize, idlingVO));
    }

}

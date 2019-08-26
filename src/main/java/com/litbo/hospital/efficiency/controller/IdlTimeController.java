package com.litbo.hospital.efficiency.controller;

import com.litbo.hospital.common.utils.calculate.HandleData;
import com.litbo.hospital.efficiency.service.IdlTimeService;
import com.litbo.hospital.efficiency.vo.IdlTimeVO;
import com.litbo.hospital.efficiency.vo.SearchVO;
import com.litbo.hospital.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * description: 工作日平均闲置时间
 * @Author: jz
 * @Date: 2019/8/2 12:28
 */
@RestController
@RequestMapping("/kpi/idling")
public class IdlTimeController {

    @Autowired
    private IdlTimeService idlTimeService;

    @RequestMapping("/selectIdlTime")
    public Result selectIdlTime(@RequestParam(value = "pageNum",required = false,defaultValue = "1") int pageNum,
                                @RequestParam(value = "pageSize",required = false,defaultValue = "10") int pageSize){
        return Result.success(idlTimeService.selectIdlTime(pageNum, pageSize));
    }

    @RequestMapping("/selectIdlTimeByCon")
    public Result selectIdlTimeByCon(@RequestParam(value = "pageNum",required = false,defaultValue = "1") int pageNum,
                                     @RequestParam(value = "pageSize",required = false,defaultValue = "10") int pageSize,
                                     SearchVO searchVO){

        if (searchVO.getStartSTime()!=null){
            String[] strings = HandleData.splitTime(searchVO.getStartSTime());
            searchVO.setStartSTime(strings[0]);
            searchVO.setEndSTime(strings[1]);
        }

        return Result.success(idlTimeService.selectIdlTimeByCon(pageNum, pageSize, searchVO));
    }

}

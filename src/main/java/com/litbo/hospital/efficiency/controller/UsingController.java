package com.litbo.hospital.efficiency.controller;


import com.litbo.hospital.common.utils.calculate.HandleData;
import com.litbo.hospital.efficiency.service.UsingService;
import com.litbo.hospital.efficiency.vo.SearchVO;
import com.litbo.hospital.efficiency.vo.UsingVO;
import com.litbo.hospital.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * description:机时利用率Controller
 * @Author: jz
 * @Date: 2019/8/1 17:13
 */

@RestController
@RequestMapping("/kpi/using")
public class UsingController {

    @Autowired
    private UsingService usingService;

    @RequestMapping("/selectUsing")
    public Result selectUsing(@RequestParam(value = "pageNum",required = false,defaultValue = "1") int pageNum,
                              @RequestParam(value = "pageSize",required = false,defaultValue = "10") int pageSize){

        return Result.success(usingService.selectUsing(pageNum, pageSize));
    }

    @RequestMapping("/selectUsingByCon")
    public Result selectUsingByCon(@RequestParam(value = "pageNum",required = false,defaultValue = "1") int pageNum,
                                   @RequestParam(value = "pageSize",required = false,defaultValue = "10")  int pageSize,
                                   SearchVO searchVO){
        if (searchVO.getStartSTime()!=null){
            String[] strings = HandleData.splitTime(searchVO.getStartSTime());
            searchVO.setStartSTime(strings[0]);
            searchVO.setEndSTime(strings[1]);
        }
        return Result.success(usingService.selectUsingByCon(pageNum, pageSize, searchVO));
    }

}

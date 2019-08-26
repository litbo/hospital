package com.litbo.hospital.efficiency.controller;

import com.litbo.hospital.common.utils.calculate.HandleData;
import com.litbo.hospital.efficiency.service.OpenService;
import com.litbo.hospital.efficiency.vo.OpenVO;
import com.litbo.hospital.efficiency.vo.SearchVO;
import com.litbo.hospital.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.Date;

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

    /**@RequestMapping("/selectOpenByCon")
    public Result selectOpenByCon(@RequestParam(value = "pageNum",required = false,defaultValue = "1") int pageNum,
                                  @RequestParam(value = "pageSize",required = false,defaultValue = "10") int pageSize,
                                  @RequestParam(value = "Time",required = false) String time,
                                  @RequestParam(value = "bmName",required = false) String bmName,
                                  @RequestParam(value = "eqName",required = false) String eqName) throws ParseException {

        System.out.println(time);
        System.out.println(bmName);
        System.out.println(eqName);
        OpenVO openVO = new OpenVO();
        System.out.println(time);
        if (time!=null){
            String[] strings = HandleData.splitTime(time);
            openVO.setStartSTime(HandleData.turnDate(strings[0]));
            openVO.setEndSTime(HandleData.turnDate(strings[1]));
        }
        openVO.setBmSName(bmName);
        openVO.setEqSName(eqName);
        System.out.println(openVO);
        return Result.success(openService.selectOpenByCon(pageNum, pageSize, openVO));
    }*/

    @RequestMapping("/selectOpenByCon")
    public Result selectOpenByCon(@RequestParam(value = "pageNum",required = false,defaultValue = "1") int pageNum,
                                  @RequestParam(value = "pageSize",required = false,defaultValue = "10") int pageSize,
                                  SearchVO searchVO) {
        searchVO = HandleData.handleSearch(searchVO);
        if (searchVO.getStartSTime()!=null){
            String[] strings = HandleData.splitTime(searchVO.getStartSTime());
            searchVO.setStartSTime(strings[0]);
            searchVO.setEndSTime(strings[1]);
        }
        return Result.success(openService.selectOpenByCon(pageNum, pageSize, searchVO));
    }

}

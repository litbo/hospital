package com.litbo.hospital.efficiency.controller;

import com.litbo.hospital.common.utils.calculate.HandleData;
import com.litbo.hospital.efficiency.service.OpenService;
import com.litbo.hospital.efficiency.vo.OpenVO;
import com.litbo.hospital.efficiency.vo.SearchVO;
import com.litbo.hospital.result.Result;
import org.apache.commons.lang3.StringUtils;
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
    

    @RequestMapping("/selectOpenByCon")
    public Result selectOpenByCon(@RequestParam(value = "pageNum",required = false,defaultValue = "1") int pageNum,
                                  @RequestParam(value = "pageSize",required = false,defaultValue = "10") int pageSize,
                                  SearchVO searchVO,String select) {
        searchVO = HandleData.handleSearch(searchVO);
        if(StringUtils.isNotBlank(select)){
            searchVO.setBmSName(select);
        }
        if (searchVO.getStartSTime()!=null){
            String[] strings = HandleData.splitTime(searchVO.getStartSTime());
            searchVO.setStartSTime(strings[0]);
            searchVO.setEndSTime(strings[1]);
        }
        return Result.success(openService.selectOpenByCon(pageNum, pageSize, searchVO));
    }

}

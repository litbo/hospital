package com.litbo.hospital.efficiency.controller;


import com.litbo.hospital.common.utils.calculate.HandleData;
import com.litbo.hospital.efficiency.service.IntegrityService;
import com.litbo.hospital.efficiency.vo.IntegrityVO;
import com.litbo.hospital.efficiency.vo.SearchVO;
import com.litbo.hospital.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *   设备完好率Controller层
 *   @Author: jz
 *   @Date: 2019/7/31 16:59
 */

@RestController
@RequestMapping("/kpi/integrity")
public class IntegrityController {

    @Autowired
    private IntegrityService integrityService;
    /**
    *   查询所有的设备的完好率
    * */
    @RequestMapping("/selectIntegrity")
    public Result selectIntegrity(@RequestParam(value = "pageNum",required = false,defaultValue = "1") int pageNum,
                                  @RequestParam(value = "pageSize",required = false,defaultValue = "10") int pageSize){
        return Result.success(integrityService.selectIntegrity(pageNum, pageSize));
    }

    /**
    *   按条件查询设备的完好率
    * */
    @RequestMapping("/selectIntegrityByCon")
    public Result selectIntegrityByCon(@RequestParam(value = "pageNum",required = false,defaultValue = "1") int pageNum,
                                       @RequestParam(value = "pageSize",required = false,defaultValue = "10") int pageSize,
                                       SearchVO searchVO){

        searchVO = HandleData.handleSearch(searchVO);
        if (searchVO.getStartSTime()!=null){
            String[] strings = HandleData.splitTime(searchVO.getStartSTime());
            searchVO.setStartSTime(strings[0]);
            searchVO.setEndSTime(strings[1]);
        }
        return Result.success(integrityService.selectIntegrityByCon(pageNum, pageSize, searchVO));
    }

}

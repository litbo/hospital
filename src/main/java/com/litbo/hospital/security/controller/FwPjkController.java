package com.litbo.hospital.security.controller;

import com.litbo.hospital.result.CodeMsg;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.security.service.FwPjkService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("security/pjk")
@Slf4j
public class FwPjkController {
    @Autowired
    private FwPjkService pjkService;
    @ApiOperation(value = "查询配件库")
    @RequestMapping(value = "listFwPjk",method = RequestMethod.GET)
    public Result listFwPjk(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                            @RequestParam(value = "pageSize" ,required = false,defaultValue="10")int pageSize,
                            @RequestParam(value = "pjSzm",required = false)String pjSzm){
        try {
            return Result.success(pjkService.listFwPjk(pageNum,pageSize,pjSzm));
        }catch (Exception e){
            log.error("listFwPjk参数错误 pjSzm={}",pjSzm);
            return Result.error(CodeMsg.SERVER_ERROR);
        }

    }
}

package com.litbo.hospital.security.controller;

import com.litbo.hospital.result.CodeMsg;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.security.service.FwPjqlService;
import com.litbo.hospital.security.vo.InsertFwPjqlVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("security/fw")
public class FwPjqlController {
    @Autowired
    private FwPjqlService pjqlService;
    @RequestMapping(value = "insertFwPjql",method = RequestMethod.POST)
    public Result insertFwPjql(@RequestBody InsertFwPjqlVo fwPjqlVo){
        try {
            int res = pjqlService.insertFwPjql(fwPjqlVo);
            if(res==1){
                return Result.success();
            }else {
                return Result.error(CodeMsg.PARAM_ERROR);
            }
        }catch (Exception e){
            return Result.error(CodeMsg.SERVER_ERROR);
        }
    }
}

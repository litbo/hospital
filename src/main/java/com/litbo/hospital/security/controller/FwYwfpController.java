package com.litbo.hospital.security.controller;

import com.litbo.hospital.result.CodeMsg;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.security.bean.FwYwfp;
import com.litbo.hospital.security.service.FwYwfpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("security/ywFp")
@Slf4j
public class FwYwfpController {
    @Autowired
    private FwYwfpService fwYwfpService;
    @RequestMapping(value = "insertFwYwFp",method = RequestMethod.POST)
    public Result insertFwYwFp(FwYwfp fwYwfp){
        int res = fwYwfpService.insertFwYwFp(fwYwfp);
        try {
            if(res > 0 ){
                return Result.success();
            }else {
                return Result.error(CodeMsg.PARAM_ERROR);
            }
        }catch (Exception e){
            log.error("异常信息",e.getMessage());
            return Result.error(CodeMsg.SERVER_ERROR);
        }
    }
}

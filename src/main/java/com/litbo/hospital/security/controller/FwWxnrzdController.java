package com.litbo.hospital.security.controller;

import com.litbo.hospital.result.CodeMsg;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.security.service.FwWxnrzdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("security/fw")
public class FwWxnrzdController {
    @Autowired
    private FwWxnrzdService wxnrzdService;
    @RequestMapping("selectFwWxnrzd")
    public Result selectFwWxnrzd(@RequestParam(value = "parentId",defaultValue = "0") int parentId){
        try {
            return Result.success(wxnrzdService.selectFwWxnrzd(parentId));
        }catch (Exception e){
            return Result.error(CodeMsg.SERVER_ERROR);
        }

    }
}

package com.litbo.hospital.security.controller;

import com.litbo.hospital.result.CodeMsg;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.security.service.FwWxnrzdService;
import com.litbo.hospital.security.vo.WxnrzdIndexVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("security/wxnr")
@Api(value = "security/wxnr" ,description = "维修内容字典")
public class FwWxnrzdController {
    @Autowired
    private FwWxnrzdService wxnrzdService;
    @ApiOperation(value = "级联查询维修内容")
    @RequestMapping(value = "selectFwWxnrzd",method = RequestMethod.GET)
    public Result selectFwWxnrzd(@RequestParam(value = "parentId",defaultValue = "0") int parentId
                                 ){
        try {
            return Result.success(wxnrzdService.selectFwWxnrzd(parentId));
        }catch (Exception e){
            return Result.error(CodeMsg.SERVER_ERROR);
        }

    }

    @GetMapping("/wxnrZdIndex")
    public Result wxnrZdIndex(@RequestParam(required = false,defaultValue = "1") Integer gzyyId ,
                              @RequestParam(required = false,defaultValue = "6") Integer gzmxId){
        try {
            WxnrzdIndexVo wxnrzdIndexVo = wxnrzdService.wxnrZdIndex(gzyyId, gzmxId);
            return Result.success(wxnrzdIndexVo);
        }catch (Exception e){
            e.printStackTrace();
            return Result.error("加载数据异常");
        }

    }
}

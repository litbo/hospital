package com.litbo.hospital.supervise.controller;

import com.litbo.hospital.result.Result;
import com.litbo.hospital.supervise.service.WxhfService;
import com.litbo.hospital.supervise.vo.WxhfReadyResouceVO;
import com.litbo.hospital.supervise.vo.WxrBmInsertVO;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kwgl/glbm")
@Api(tags = "维修划分")
public class WxhfController {
    @Autowired
    private WxhfService wxhfService;

    @GetMapping("/readyForHf")
    public Result readyForHf(){
        WxhfReadyResouceVO wxhfReadyResouceVO =   wxhfService.getWxhfReadyResouceVO();
        return Result.success(wxhfReadyResouceVO);
    }

    @PostMapping("/wxrBmHf")
    public Result wxrBmHf(@RequestBody WxrBmInsertVO wxrBmInsertVO){
        wxhfService.wxrBmHf(wxrBmInsertVO);
        return Result.success();
    }

    @PostMapping("/wxrBmXcHf")
    public Result wxrBmXcHf(@RequestBody String[] bms){
        wxhfService.wxrBmXcHf(bms);
        return Result.success();
    }

}

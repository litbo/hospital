package com.litbo.hospital.supervise.controller;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.supervise.service.WxhfService;
import com.litbo.hospital.supervise.vo.*;
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

    @PostMapping("/gcsBmHf")
    public Result wxrBmHf(@RequestBody WxrBmInsertVO wxrBmInsertVO){

        for (String bmId : wxrBmInsertVO.getBmIds()){
            Boolean isxzd = wxhfService.isxzd(wxrBmInsertVO.getUserId(), bmId);
            if (isxzd){
                return Result.error(99,"请勿重复划分！");
            }
        }
        wxhfService.wxrBmHf(wxrBmInsertVO);
        return Result.success();
    }

    @PostMapping("/gcsBmXcHf")
    public Result wxrBmXcHf(@RequestBody WxhfDeteleVO wxhfDeteleVO){
        wxhfService.wxrBmXcHf(wxhfDeteleVO.getGbIds());
        return Result.success();
    }

    @GetMapping("/getGcsBmMSG")
    public Result getGcsBmMSG(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                              @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize){    //s_gcs_bm
        PageInfo pageInfo = wxhfService.getGcsBmMSG(pageNum,pageSize);
        return Result.success(pageInfo);
    }

    @GetMapping("/getGcsBmMSGByGcsNameAndBmName")
    public Result getGcsBmMSGByGcsNameAndBmName(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                              @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize,String userXm,String bmName){    //s_gcs_bm
        PageInfo pageInfo = wxhfService.getGcsBmMSGByGcsNameAndBmName(pageNum,pageSize,userXm,bmName);
        return Result.success(pageInfo);
    }



    @GetMapping("/getBmGcsEqByX")
    public Result getBmGcsEqByX(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                                @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize,
                                BmGcsEqSelectXVO xvo){    //s_gcs_bm
        PageInfo pageInfo = wxhfService.getBmGcsEqByX(pageNum,pageSize,xvo);
        return Result.success(pageInfo);
    }



    @GetMapping("/getWxbmGcsEqMSG")
    public Result getWxbmGcsEqMSG(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                                  @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize){
        PageInfo pageInfo  = wxhfService.getWxbmGcsEqMSG(pageNum,pageSize);
        return Result.success(pageInfo);
    }

    //维修科室下的工程师对应的设备的划分
    @PostMapping("/wxBmGcsEqHf")
    public Result wxBmGcsEqHf(@RequestBody WxBmGcsEqInsertVO wxBmGcsEqInsertVO){
        wxhfService.wxBmGcsEqHf(wxBmGcsEqInsertVO);
        return Result.success();
    }

    @PostMapping("/wxBmGcsEqXcHf")
    public Result wxBmGcsEqXcHf(@RequestBody WxhfDeteleVO wxhfDeteleVO){
        wxhfService.wxBmGcsEqXcHf(wxhfDeteleVO.getBgIds());
        return Result.success();
    }

}

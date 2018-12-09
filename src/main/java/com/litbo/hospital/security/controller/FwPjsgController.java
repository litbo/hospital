package com.litbo.hospital.security.controller;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.result.CodeMsg;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.security.bean.FwPjsg;
import com.litbo.hospital.security.enums.EnumApplyStatus;
import com.litbo.hospital.security.service.FwPjsgService;
import com.litbo.hospital.security.vo.InsertFwPjsgVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("security/pjsg")
@Api(value = "security/pjsg" ,description = "配件申购操作")
public class FwPjsgController {
    @Autowired
    private FwPjsgService pjsgService;
    @ApiOperation(value = "插入配件申购")
    @RequestMapping(value = "insertFwPjsg",method = RequestMethod.POST)
    public Result insertFwPjsg(@RequestBody InsertFwPjsgVo fwPjsgVo){
        try {
            int res = pjsgService.insertFwPjsg(fwPjsgVo);
            if(res>0)
                return Result.success();
            else
                return Result.error(CodeMsg.PARAM_ERROR);
        }catch (Exception e){
            return Result.error(CodeMsg.SERVER_ERROR);
        }
    }
    @ApiOperation(value = "根据用户查询所有待审核的申购")
    @RequestMapping(value = "listFwPjsgByUserWaitExamine",method = RequestMethod.GET)
    public Result listFwPjsgByUserWaitExamine(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                                   @RequestParam(value = "pageSize" ,required = false,defaultValue="10")int pageSize){
        //Todo 修改session的name
//        String currentUserId = (String) SecurityUtils.getSubject().getSession().getAttribute("currentUserId");
        String currentUserId = "2";
        FwPjsg pjsg = new FwPjsg();
        pjsg.setUserId2(currentUserId);
        pjsg.setSgStatus(EnumApplyStatus.WAIT_EXAMINE.getCode());//查询待审核的配件请领
        PageInfo pageInfo = pjsgService.listFwPjsg(pjsg,pageNum,pageSize);
        return Result.success(pageInfo);
    }

    @ApiOperation(value = "根据用户查询所有审核成功的申购")
    @RequestMapping(value = "listFwPjsgByUserApplyApproval",method = RequestMethod.GET)
    public Result listFwPjsgByUserApplyApproval(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                                   @RequestParam(value = "pageSize" ,required = false,defaultValue="10")int pageSize){
        //Todo 修改session的name
//      String currentUserId = (String) SecurityUtils.getSubject().getSession().getAttribute("currentUserId");
        String currentUserId = "2";
        FwPjsg pjsg = new FwPjsg();
        pjsg.setUserId2(currentUserId);
        pjsg.setSgStatus(EnumApplyStatus.APPLY_APPROVAL.getCode());//查询审核通过的配件请领
        PageInfo pageInfo = pjsgService.listFwPjsg(pjsg,pageNum,pageSize);
        return Result.success(pageInfo);
    }
    @ApiOperation("同意或者拒绝申购")
    @RequestMapping(value = "updateFwPjsgStatus",method = RequestMethod.POST)
    public Result updateFwPjsgStatus(Integer sgStatus,Integer id){
        try {
            if(id!=null&&sgStatus!=null&&(sgStatus == EnumApplyStatus.APPLY_APPROVAL.getCode()||sgStatus == EnumApplyStatus.APPLY_REJECT.getCode())){
                //Todo 修改session的name
                //      String currentUserId = (String) SecurityUtils.getSubject().getSession().getAttribute("currentUserId");
                String currentUserId = "2";
                int res = pjsgService.updateFwPjsgStatus(sgStatus,currentUserId,id);
                if(res == 1){
                    return Result.success(res);
                }else {
                    return Result.error(CodeMsg.PARAM_ERROR);
                }

            }else {
                return Result.error(CodeMsg.PARAM_ERROR);
            }
        }catch (Exception e){
            return Result.error(CodeMsg.PARAM_ERROR);
        }

    }
}

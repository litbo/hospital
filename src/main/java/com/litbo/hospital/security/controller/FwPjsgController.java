package com.litbo.hospital.security.controller;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.result.CodeMsg;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.security.bean.FwPjsg;
import com.litbo.hospital.security.enums.EnumApplyStatus;
import com.litbo.hospital.security.service.FwPjsgService;
import com.litbo.hospital.security.vo.ExaminePjsgVO;
import com.litbo.hospital.security.vo.InsertFwPjsgVo;
import com.litbo.hospital.user.vo.LiveEmpVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("security/pjsg")
@Slf4j
@Api(value = "security/pjsg" ,description = "配件申购操作")
public class FwPjsgController {
    @Autowired
    private FwPjsgService pjsgService;
    @ApiOperation(value = "插入配件申购")
    @RequestMapping(value = "insertFwPjsg",method = RequestMethod.POST)
    public Result insertFwPjsg(@RequestBody InsertFwPjsgVo fwPjsgVo){
        if(fwPjsgVo.getFwPjsgZjbs().size()<=0)
            return Result.error(CodeMsg.PARAM_ERROR);
        try {
            //TODO 已修改
            LiveEmpVo sEmp = (LiveEmpVo)SecurityUtils.getSubject().getSession().getAttribute("emp");
            String userId = sEmp.getUserId();
            fwPjsgVo.getFwPjsg().setUserId1(userId);
            int res = pjsgService.insertFwPjsg(fwPjsgVo);
            if(res>0)
                return Result.success();
            else
                return Result.error(CodeMsg.PARAM_ERROR);
        }catch (Exception e){
            log.error("异常信息",e.getMessage());
            return Result.error(CodeMsg.SERVER_ERROR);
        }
    }
    @ApiOperation(value = "根据用户查询所有待审核的申购")
    @RequestMapping(value = "listFwPjsgByUserWaitExamine",method = RequestMethod.GET)
    public Result listFwPjsgByUserWaitExamine(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                                   @RequestParam(value = "pageSize" ,required = false,defaultValue="10")int pageSize){
        //Todo 已修改 修改session的name
//        String currentUserId = (String) SecurityUtils.getSubject().getSession().getAttribute("currentUserId");
        LiveEmpVo sEmp = (LiveEmpVo)SecurityUtils.getSubject().getSession().getAttribute("emp");
        String currentUserId = sEmp.getUserId();
        FwPjsg pjsg = new FwPjsg();
        pjsg.setUserId2(currentUserId);
        pjsg.setSgStatus(EnumApplyStatus.WAIT_EXAMINE.getCode());//查询待审核的配件请领
        PageInfo pageInfo = pjsgService.listFwPjsg(pjsg,pageNum,pageSize);
        return Result.success(pageInfo);
    }

    @ApiOperation(value = "查询所有审核成功的申购")
    @RequestMapping(value = "listFwPjsgByUserApplyApproval",method = RequestMethod.GET)
    public Result listFwPjsgByUserApplyApproval(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                                   @RequestParam(value = "pageSize" ,required = false,defaultValue="10")int pageSize){
        //Todo 已修改（等待测试）修改session的name
        LiveEmpVo sEmp = (LiveEmpVo)SecurityUtils.getSubject().getSession().getAttribute("emp");
        String qrrId = sEmp.getUserId();

        FwPjsg pjsg = new FwPjsg();
        pjsg.setUserId2(qrrId);
        pjsg.setSgStatus(EnumApplyStatus.APPLY_APPROVAL.getCode());//查询审核通过的配件请领
        PageInfo pageInfo = pjsgService.listFwPjsg(pjsg,pageNum,pageSize);
        return Result.success(pageInfo);
    }
    @ApiOperation("入库查询")
    @RequestMapping(value = "listFwPjsgZjb",method = RequestMethod.GET)
    public Result listFwPjsgZjb(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                                @RequestParam(value = "pageSize" ,required = false,defaultValue="10")int pageSize,
                                @RequestParam(required = false,defaultValue = "1990-01-01") String pjRkTimeStart,
                                @RequestParam(required = false,defaultValue = "2999-12-31") String pjRkTimeEnd,
                                @RequestParam(required = false) String pjName){
        try{
            PageInfo pageInfo = pjsgService.listFwPjsgZjb(pageNum,pageSize,pjRkTimeStart,pjRkTimeEnd,pjName);
            return Result.success(pageInfo);
        }catch (Exception e){
            log.error("异常信息",e.getMessage());
            return Result.error(CodeMsg.SERVER_ERROR);

        }


    }


    @ApiOperation("同意或者拒绝申购")
    @RequestMapping(value = "updateFwPjsgStatus",method = RequestMethod.POST)
    public Result updateFwPjsgStatus(Integer sgStatus,Integer id,Integer taskId){
        try {
            if(id!=null&&sgStatus!=null&&(sgStatus == EnumApplyStatus.APPLY_APPROVAL.getCode()||sgStatus == EnumApplyStatus.APPLY_REJECT.getCode())){
                //Todo 已修改 修改session的name
                LiveEmpVo sEmp = (LiveEmpVo)SecurityUtils.getSubject().getSession().getAttribute("emp");
                String currentUserId = sEmp.getUserId();
                int res = pjsgService.updateFwPjsgStatus(sgStatus,currentUserId,id,taskId);
                if(res == 1){
                    return Result.success(res);
                }else {
                    return Result.error(CodeMsg.PARAM_ERROR);
                }

            }else {
                log.error("异常信息",id,sgStatus,id,taskId);
                return Result.error(CodeMsg.PARAM_ERROR);
            }
        }catch (Exception e){
            log.error("异常信息",e.getMessage(),sgStatus,id,taskId);
            return Result.error(CodeMsg.PARAM_ERROR);
        }

    }
    @RequestMapping(value = "selectFwPjsgById",method = RequestMethod.GET)
    public Result selectFwPjsgById(@RequestParam(defaultValue = "26") Integer id,@RequestParam(value = "taskId",required = false) Integer taskId){
        ExaminePjsgVO vo = pjsgService.selectFwPjsgById(id,taskId);
        return Result.success(vo);
    }
}

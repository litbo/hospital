package com.litbo.hospital.security.controller;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.result.CodeMsg;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.security.bean.FwFp;
import com.litbo.hospital.security.enums.EnumApplyStatus;
import com.litbo.hospital.security.enums.EnumProcess;
import com.litbo.hospital.security.service.FwFpService;
import com.litbo.hospital.security.vo.SelectFwFpByIdVo;
import com.litbo.hospital.supervise.bean.SEmp;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("security/fp")
public class FwFpController {
    @Autowired
    private FwFpService fpService;
    @RequestMapping(value = "listFwFpByWaitExamine",method = RequestMethod.GET)
    public Result listFwFpByWaitExamine(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                           @RequestParam(value = "pageSize" ,required = false,defaultValue="10")int pageSize,
                                        @RequestParam(required = false) String fpHm,
                                        @RequestParam(required = false)String eqName,@RequestParam(required = false)String wxDh){
        PageInfo pageInfo = fpService.listFwFpByWaitExamine(pageNum,pageSize, fpHm, eqName, wxDh);
        return Result.success(pageInfo);
    }
    @RequestMapping(value = "listFwFpByApplyApproval",method = RequestMethod.GET)
    public Result listFwFpByApplyApproval(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                                        @RequestParam(value = "pageSize" ,required = false,defaultValue="10")int pageSize,
                                        @RequestParam(required = false) String fpHm,
                                        @RequestParam(required = false)String eqName,@RequestParam(required = false)String wxDh){
        PageInfo pageInfo = fpService.listFwFpByApplyApproval(pageNum,pageSize, fpHm, eqName, wxDh);
        return Result.success(pageInfo);
    }
    @RequestMapping(value = "insertFwFp",method = RequestMethod.POST)
    public Result insertFwFp( FwFp fp){
        //TODO 已修改
        SEmp sEmp = (SEmp)SecurityUtils.getSubject().getSession().getAttribute("emp");
        String djrId = sEmp.getUserId();
        fp.setFpShrId(djrId);
//        fp.setFpSdTime(new Date());
        fp.setFpStatus(EnumApplyStatus.WAIT_EXAMINE.getCode());
        Integer res = fpService.insertFwFp(fp);
        if(res==1){
            return Result.success();
        }else{
            return Result.error(CodeMsg.SERVER_ERROR);
        }

    }
    //审核发票
    @RequestMapping(value = "updateFwFpStatus",method = RequestMethod.POST)
    public Result updateFwFpStatus(FwFp fp){

        fp.setFpShTime(new Date());
        fp.setFpStatus(EnumApplyStatus.APPLY_APPROVAL.getCode());
        //TODO 已修改 此处配件请领人从session中获取，并存入fp表中
        SEmp sEmp = (SEmp)SecurityUtils.getSubject().getSession().getAttribute("emp");
        String userId = sEmp.getUserId();
        fp.setFpShrId(userId);
        int res  = fpService.updateFwFp(fp);
        if(res==1){
            return Result.success();
        }else{
            return Result.error(CodeMsg.SERVER_ERROR);
        }
    }
    @RequestMapping(value = "selectFwFpById",method = RequestMethod.GET)
    public Result selectFwFpById(Integer id){
        SelectFwFpByIdVo fp = fpService.selectFwFpById(id);
        if(fp!=null)
            return Result.success(fp);
        else
            return Result.error("查询不到数据");
    }
}

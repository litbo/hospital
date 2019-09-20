package com.litbo.hospital.security.controller;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.result.CodeMsg;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.security.bean.FwFp;
import com.litbo.hospital.security.enums.EnumApplyStatus;
import com.litbo.hospital.security.service.FwFpService;
import com.litbo.hospital.security.vo.SelectFwFpByIdVo;
import com.litbo.hospital.user.vo.LiveEmpVo;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
@Slf4j
@RestController
@RequestMapping("security/fp")
public class FwFpController {
    @Autowired
    private FwFpService fpService;

    /**
     * 等待审核
     * @param pageNum
     * @param pageSize
     * @param fpHm 发票号码
     * @param eqName 设备名称
     * @param wxDh 维修单号
     * @return
     */
    @RequestMapping(value = "listFwFpByWaitExamine",method = RequestMethod.GET)
    public Result listFwFpByWaitExamine(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                           @RequestParam(value = "pageSize" ,required = false,defaultValue="10")int pageSize,
                                        @RequestParam(required = false) String fpHm,
                                        @RequestParam(required = false)String eqName,@RequestParam(required = false)String wxDh){
        PageInfo pageInfo = fpService.listFwFpByWaitExamine(pageNum,pageSize, fpHm, eqName, wxDh);

        return Result.success(pageInfo);
    }

    /**
     * 已审核
     * @param pageNum
     * @param pageSize
     * @param fpHm
     * @param eqName
     * @param wxDh
     * @return
     */
    @RequestMapping(value = "listFwFpByApplyApproval",method = RequestMethod.GET)
    public Result listFwFpByApplyApproval(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                                        @RequestParam(value = "pageSize" ,required = false,defaultValue="10")int pageSize,
                                        @RequestParam(required = false) String fpHm,
                                        @RequestParam(required = false)String eqName,@RequestParam(required = false)String wxDh){
        PageInfo pageInfo = fpService.listFwFpByApplyApproval(pageNum,pageSize, fpHm, eqName, wxDh);
        return Result.success(pageInfo);
    }

    /**
     * 插入发票
     * @param fp
     * @return
     */
    @ApiOperation(value = "插入发票信息")
    @RequestMapping(value = "insertFwFp",method = RequestMethod.POST)
    public Result insertFwFp( FwFp fp){
        //TODO 已修改
        LiveEmpVo sEmp = (LiveEmpVo)SecurityUtils.getSubject().getSession().getAttribute("emp");
        String djrId = sEmp.getUserId();
        fp.setUserId(djrId);
//        fp.setFpSdTime(new Date());
        fp.setFpStatus(EnumApplyStatus.WAIT_EXAMINE.getCode());
        Integer res = fpService.insertFwFp(fp);
        if(res==1){
            return Result.success();
        }else{
            log.error("insertFwFp参数错误 FwFp={}",fp);
            return Result.error(CodeMsg.SERVER_ERROR);
        }

    }


    /**
     * 审核发票
     * @param fp
     * @return
     */
    @ApiOperation(value = "更新发票审核信息")
    @RequestMapping(value = "updateFwFpStatus",method = RequestMethod.POST)
    public Result updateFwFpStatus(FwFp fp){

        fp.setFpShTime(new Date());
        fp.setFpStatus(EnumApplyStatus.APPLY_APPROVAL.getCode());
        //TODO 已修改 此处配件请领人从session中获取，并存入fp表中
        LiveEmpVo sEmp = (LiveEmpVo)SecurityUtils.getSubject().getSession().getAttribute("emp");
        String userId = sEmp.getUserId();
        fp.setFpShrId(userId);
        int res  = fpService.updateFwFp(fp);
        if(res==1){
            return Result.success();
        }else{
            log.error("updateFwFpStatus参数错误 FwFp={}",fp);
            return Result.error(CodeMsg.SERVER_ERROR);
        }
    }

    /**
     * 通过id查询发票
     * @param id
     * @return
     */
    @ApiOperation(value = "通过id查询发票")
    @RequestMapping(value = "selectFwFpById",method = RequestMethod.GET)
    public Result selectFwFpById(Integer id){
        SelectFwFpByIdVo fp = fpService.selectFwFpById(id);
        if(fp!=null)
            return Result.success(fp);
        else{
            log.error("selectFwFpById参数错误 id={}",id);
            return Result.error("查询不到数据");
        }

    }
}

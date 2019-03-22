package com.litbo.hospital.security.controller;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.result.CodeMsg;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.security.bean.FwPjck;
import com.litbo.hospital.security.enums.EnumApplyStatus;
import com.litbo.hospital.security.service.FwPjqlService;
import com.litbo.hospital.security.vo.ExaminePjqlVO;
import com.litbo.hospital.security.vo.InsertFwPjqlVo;
import com.litbo.hospital.supervise.bean.SEmp;
import io.swagger.annotations.*;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("security/pjql")
@Api(value = "security/pjql" ,description = "配件请领操作")
public class FwPjqlController {
    @Autowired
    private FwPjqlService pjqlService;



    @ApiOperation(value = "配件请领")
    @RequestMapping(value = "insertFwPjql",method = RequestMethod.POST)
    public Result insertFwPjql(@RequestBody InsertFwPjqlVo fwPjqlVo){
        if(fwPjqlVo.getFwPjqlZjbs().size()<=0)
            return Result.error(CodeMsg.PARAM_ERROR);
        try {
            //TODO 已修改 此处配件请领人从session中获取，并存入Pjql表中
            SEmp sEmp = (SEmp)SecurityUtils.getSubject().getSession().getAttribute("emp");
            String qlrId = sEmp.getUserId();
            fwPjqlVo.getFwPjql().setQlrId(qlrId);
            int res = pjqlService.insertFwPjql(fwPjqlVo);
            if(res>0){
                return Result.success();
            }else {
                return Result.error(CodeMsg.PARAM_ERROR);
            }
        }catch (Exception e){
            e.printStackTrace();
            return Result.error(CodeMsg.SERVER_ERROR);
        }
    }


    @ApiOperation(value = "确认人对请领进行审核")
    @RequestMapping(value = "updateFwPjqlStatus",method = RequestMethod.POST)
    public Result updateFwPjqlStatus(Integer status,  Integer id,  String shyy,Integer taskId){
        if(status != null && (status==EnumApplyStatus.APPLY_APPROVAL.getCode() || status==EnumApplyStatus.APPLY_REJECT.getCode())){
            try {
                //TODO 已修改 此处确认人从session中获取，并存入Pjql表中
                SEmp sEmp = (SEmp)SecurityUtils.getSubject().getSession().getAttribute("emp");
                String qrrId = sEmp.getUserId();
                int res = pjqlService.updateFwPjqlSqStatus(status,id,qrrId,shyy,taskId);
                if(res >0){
                    return Result.success();
                }else if(res == -1){
                    return Result.error("配件库存不足，请检查配件库存");
                }else {
                    return Result.error(CodeMsg.PARAM_ERROR);
                }
            }catch (Exception e){
                e.printStackTrace();
                return Result.error(CodeMsg.PARAM_ERROR);
            }

        }else {
            return Result.error(CodeMsg.PARAM_ERROR);
        }
    }
    @ApiOperation("出库查询")
    @RequestMapping(value = "listFwPjqlZjb",method = RequestMethod.GET)
    public Result listFwPjsgZjb(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                                @RequestParam(value = "pageSize" ,required = false,defaultValue="10")int pageSize,
                                @RequestParam(required = false,defaultValue = "1990-01-01") String pjRkTimeStart,
                                @RequestParam(required = false,defaultValue = "2999-12-31") String pjRkTimeEnd,
                                @RequestParam(required = false) String pjName){
        try {
            PageInfo pageInfo = pjqlService.listFwPjqlZjb(pageNum,pageSize,pjRkTimeStart,pjRkTimeEnd,pjName);
            return Result.success(pageInfo);
        }catch (Exception e){
            e.printStackTrace();
            return Result.error(CodeMsg.SERVER_ERROR);
        }

    }
    @RequestMapping(value = "selectFwPjqlById",method = RequestMethod.GET)
    public Result selectFwPjqlById(Integer id,Integer taskId){
        ExaminePjqlVO vo = pjqlService.selectFwPjqlById(id);
        return Result.success(vo);
    }
}

package com.litbo.hospital.security.controller;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.result.CodeMsg;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.security.bean.FwPjck;
import com.litbo.hospital.security.enums.EnumApplyStatus;
import com.litbo.hospital.security.service.FwPjqlService;
import com.litbo.hospital.security.vo.InsertFwPjqlVo;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("security/pjql")
@Api(value = "security/pjql" ,description = "配件请领操作")
public class FwPjqlController {
    @Autowired
    private FwPjqlService pjqlService;
    @ApiOperation(value = "请领后存入数据库")
    @RequestMapping(value = "insertFwPjql",method = RequestMethod.POST)
    public Result insertFwPjql(@RequestBody InsertFwPjqlVo fwPjqlVo){
        try {
            //TODO 此处配件请领人从session中获取，并存入Pjql表中
            String qrrId = "2";
            int res = pjqlService.insertFwPjql(fwPjqlVo);
            if(res>0){
                return Result.success();
            }else {
                return Result.error(CodeMsg.PARAM_ERROR);
            }
        }catch (Exception e){
            return Result.error(CodeMsg.SERVER_ERROR);
        }
    }
    @ApiOperation(value = "确认人对请领进行审核")
    @RequestMapping(value = "updateSqStatus",method = RequestMethod.POST)
    @ApiImplicitParams({ @ApiImplicitParam(name = "status" ,value = "是否同意（1 同意）  （2 拒绝）",required = true),
            @ApiImplicitParam(name = "id" ,value = "请领表id",required = true),
            @ApiImplicitParam(name = "shyy" ,value = "审核原因",required = true)})
    public Result updateSqStatus(Integer status,  Integer id,  String shyy){
        if(status != null && (status==EnumApplyStatus.APPLY_APPROVAL.getCode() || status==EnumApplyStatus.APPLY_REJECT.getCode())){
            try {
                //TODO 此处确认人从session中获取，并存入Pjql表中
                String qrrId = "2";
                int res = pjqlService.updateFwPjqlSqStatus(status,id,qrrId,shyy);
                if(res >0){
                    return Result.success();
                }else if(res == -1){
                    return Result.error("配件库存不足，请检查配件库存");
                }else {
                    return Result.error(CodeMsg.PARAM_ERROR);
                }
            }catch (Exception e){
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
        PageInfo pageInfo = pjqlService.listFwPjqlZjb(pageNum,pageSize,pjRkTimeStart,pjRkTimeEnd,pjName);
        return Result.success(pageInfo);
    }
}

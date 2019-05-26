package com.litbo.hospital.security.controller;

import com.litbo.hospital.result.CodeMsg;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.security.bean.FwBlsj;
import com.litbo.hospital.security.enums.EnumApplyStatus;
import com.litbo.hospital.security.service.FwBlsjService;
import com.litbo.hospital.user.vo.LiveEmpVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("security/blsj")
public class FwBlsjController {
//    Logger logger = LoggerFactory.getLogger(FwBlsjController.class);
    @Autowired
    private FwBlsjService blsjService;
    @RequestMapping(value = "insertFwBlsj",method = RequestMethod.POST)
    public Result insertFwBlsj(@RequestBody FwBlsj blsj){
        LiveEmpVo sEmp = (LiveEmpVo)SecurityUtils.getSubject().getSession().getAttribute("emp");
        try {
            if(blsjService.insertFwBlsj(blsj,sEmp)>0)
                return Result.success();
            else
                return Result.error();
        }catch (Exception e){
            log.error("insertFwBlsj参数错误 FwBlsj={}",blsj);
            e.printStackTrace();
            return Result.error(CodeMsg.SERVER_ERROR);
        }

    }
    @RequestMapping(value = "updateFwBlsjStatus",method = RequestMethod.POST)
    public Result updateFwBlsjStatus(Integer status,  Integer id,  Integer taskId){
        try {
            if(status != null && (status==EnumApplyStatus.APPLY_APPROVAL.getCode() || status==EnumApplyStatus.APPLY_REJECT.getCode())){
                int res = blsjService.updateFwBlsjStatus( status,   id,   taskId);
                if(res>0){
                    return Result.success();
                }else {
                    return Result.error(CodeMsg.PARAM_ERROR);
                }
            }else {
                return Result.error(CodeMsg.PARAM_ERROR);
            }
        }catch (Exception e){
            e.printStackTrace();
            return Result.error(CodeMsg.SERVER_ERROR);
        }



    }
    @RequestMapping(value = "listFwBlsj",method = RequestMethod.GET)
    public Result listFwBlsj(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                                   @RequestParam(value = "pageSize" ,required = false,defaultValue="10")int pageSize,
                             @RequestParam(required = false) String cpmc, @RequestParam(required = false)String bgrXm){
        return  Result.success(blsjService.listFwBlsj(pageNum,pageSize,cpmc,bgrXm));
    }
    @RequestMapping(value = "listFwBlsjWaitExamine",method = RequestMethod.GET)
    public Result listFwBlsjWaitExamine(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                             @RequestParam(value = "pageSize" ,required = false,defaultValue="10")int pageSize,
                            @RequestParam(required = false) String cpmc, @RequestParam(required = false)String bgrXm){
//                             @RequestParam(required = false)String sbcsName, @RequestParam(required = false)String bgmc){
        return  Result.success(blsjService.listFwBlsjWaitExamine(pageNum,pageSize,cpmc,bgrXm));
    }

    @RequestMapping(value = "selectFwBlsjById",method = RequestMethod.GET)
    public Result selectFwBlsjById(Integer id) {
        try {
            FwBlsj fwBlsj = blsjService.selectFwBlsjById(id);
            if (fwBlsj != null)
                return Result.success(fwBlsj);
            else
                return Result.error(CodeMsg.PARAM_ERROR);
        } catch (Exception e) {
            log.error("selectFwBlsjById参数错误 id={}",id);
            return Result.error(CodeMsg.SERVER_ERROR);
        }
    }

}

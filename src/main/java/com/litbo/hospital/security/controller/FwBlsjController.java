package com.litbo.hospital.security.controller;

import com.litbo.hospital.result.CodeMsg;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.security.bean.FwBlsj;
import com.litbo.hospital.security.service.FwBlsjService;
import com.litbo.hospital.security.vo.SelectFwBlsjById;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
@RequestMapping("security/blsj")
public class FwBlsjController {
//    Logger logger = LoggerFactory.getLogger(FwBlsjController.class);
    @Autowired
    private FwBlsjService blsjService;
    @RequestMapping(value = "insertFwBlsj",method = RequestMethod.POST)
    public Result insertFwBlsj(FwBlsj blsj){
        try {
            if(blsjService.insertFwBlsj(blsj)>0)
                return Result.success();
            else
                return Result.error();
        }catch (Exception e){
            log.error("insertFwBlsj参数错误 FwBlsj={}",blsj);
            return Result.error(CodeMsg.SERVER_ERROR);
        }

    }

    @RequestMapping(value = "listFwBlsj",method = RequestMethod.GET)
    public Result listFwBlsj(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                                   @RequestParam(value = "pageSize" ,required = false,defaultValue="10")int pageSize,
                             @RequestParam(required = false) String sjxz, @RequestParam(required = false)String bmName,
                             @RequestParam(required = false)String sbcsName, @RequestParam(required = false)String bgmc){
        return  Result.success(blsjService.listFwBlsj(pageNum,pageSize, sjxz, bmName, sbcsName, bgmc));
    }

    @RequestMapping(value = "selectFwBlsjById",method = RequestMethod.GET)
    public Result selectFwBlsjById(Integer id) {
        try {
            SelectFwBlsjById fwBlsjById = blsjService.selectFwBlsjById(id);
            if (fwBlsjById != null)
                return Result.success(fwBlsjById);
            else
                return Result.error(CodeMsg.PARAM_ERROR);
        } catch (Exception e) {
            log.error("selectFwBlsjById参数错误 id={}",id);
            return Result.error(CodeMsg.SERVER_ERROR);
        }
    }

}

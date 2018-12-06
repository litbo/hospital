package com.litbo.hospital.security.controller;
import com.litbo.hospital.result.CodeMsg;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.security.bean.FwBlsj;
import com.litbo.hospital.security.bean.FwPjzd;
import com.litbo.hospital.security.service.FwBlsjService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("security/fw")
public class FwBlsjController {
    @Autowired
    private FwBlsjService blsjService;
    @RequestMapping("insertFwBlsj")
    public Result insertFwBlsj(FwBlsj blsj){
            return Result.success(blsjService.insertFwBlsj(blsj));
    }



    @RequestMapping(value = "listFwBlsj",method = RequestMethod.GET)
    public Result listFwBlsj(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                                   @RequestParam(value = "pageSize" ,required = false,defaultValue="10")int pageSize){
        return  Result.success(blsjService.listFwBlsj(pageNum,pageSize));
    }

}

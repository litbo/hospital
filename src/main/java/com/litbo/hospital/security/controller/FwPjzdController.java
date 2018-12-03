package com.litbo.hospital.security.controller;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.security.bean.FwPjzd;
import com.litbo.hospital.security.enums.EnumStatus;
import com.litbo.hospital.security.service.FwPjzdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("security/fw")
public class FwPjzdController {
    @Autowired
    private FwPjzdService pjzdService;




    @RequestMapping("/insertFwPjzd")
    public Result insertFwPjzd(@RequestBody FwPjzd pjzd){
        return Result.success(pjzdService.insertFwPjzd(pjzd));
    }
    @RequestMapping("/listFwPjzd")
    public Result listFwPjzd(@RequestParam(value = "pjSzm",required = false) String pjSzm,
                              @RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                              @RequestParam(value = "pageSize" ,required = false,defaultValue="10")int pageSize,
                              @RequestParam(value = "pjfl" ,required = false) String pjfl){
        return Result.success(pjzdService.listFwPjzd( pjSzm, pageNum, pageSize, pjfl));
    }


}

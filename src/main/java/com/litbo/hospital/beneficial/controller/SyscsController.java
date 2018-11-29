package com.litbo.hospital.beneficial.controller;

import com.litbo.hospital.beneficial.service.SyscsService;
import com.litbo.hospital.result.CodeMsg;
import com.litbo.hospital.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class SyscsController {

    @Autowired
    private SyscsService syscsService;

    /*
    * 设置会计结账日
    * */
    @RequestMapping(value = "/benefical/syscs/insertKjjzr")
    public Result insertKjjzr(Integer kjjzr){

        Map<String, Object> dataMap = new HashMap<String, Object>();

        /*
        * 会计结账日只能是1-30之间的数字
        * */
        try {
            if((kjjzr>30)||(kjjzr<1)){
                return Result.error(CodeMsg.SERVER_ERROR);
            }
            syscsService.InsertKjjzr(kjjzr);
        }catch (Exception e){
                Result.error(CodeMsg.SERVER_ERROR);
        }
        dataMap.put("kjjzr", kjjzr);
        Result result = Result.success(dataMap);
        return result;
    }

    /*
    * 设置风险基金提取与收入的比例
    * */
    @RequestMapping(value = "/benefical/syscs/insertYlfx")
    public Result insertYlfx(float ylfx){

        Map<String, Object> dataMap = new HashMap<String, Object>();

        /*
        * 按规定，此比例应在1%-3%之间
        * */
        try {
            if((ylfx>0.03)||(ylfx<0.01)){
                return Result.error(CodeMsg.SERVER_ERROR);
            }
           // syscsService.InsertKjjzr(ylfx);
        }catch (Exception e){
            Result.error(CodeMsg.SERVER_ERROR);
        }
        dataMap.put("ylfx", ylfx);
        Result result = Result.success(dataMap);
        return result;
    }
}

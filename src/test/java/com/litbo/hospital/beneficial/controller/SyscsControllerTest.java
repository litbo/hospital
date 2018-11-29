package com.litbo.hospital.beneficial.controller;

import com.litbo.hospital.result.CodeMsg;
import com.litbo.hospital.result.Result;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class SyscsControllerTest {

    @Test
    public void insertKjjzr() {
        Integer kjjzr = 31;
        Map<String, Object> dataMap = new HashMap<String, Object>();

        try {
            if((kjjzr>30)||(kjjzr<1)){
              //  return Result.error(CodeMsg.SERVER_ERROR);
                System.out.println(Result.error(CodeMsg.SERVER_ERROR));
            }
            //syscsService.InsertKjjzr(kjjzr);
        }catch (Exception e){
            Result.error(CodeMsg.SERVER_ERROR);
        }
        dataMap.put("kjjzr", kjjzr);
        Result result = Result.success(dataMap);
        System.out.println(result);
    }

    @Test
    public void insertYlfx() {
    }
}
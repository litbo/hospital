package com.litbo.hospital.beneficial.controller;

import com.litbo.hospital.beneficial.service.SyscsService;
import com.litbo.hospital.result.CodeMsg;
import com.litbo.hospital.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/benefical")
public class SyscsController {

    @Autowired
    private SyscsService syscsService;

    /*
     * 设置会计结账日
     * */
    @RequestMapping(value = "/updateKjjzr")

    public Result updateKjjzr(Integer kjjzr) {
        try {
            Integer res = syscsService.UpdateKjjzr(kjjzr);
            if (res == 1) {
                return Result.success(null);
            } else {
                return Result.error(CodeMsg.SERVER_ERROR);
            }
        } catch (Exception e) {
            return Result.error(CodeMsg.SERVER_ERROR);
        }
    }


    /*
     * 设置风险基金提取与收入的比例
     * */
    @RequestMapping(value = "/updateYlfx")
    public Result updateYlfx(String ylfx) {
        float ylfxBaifen = new Float(ylfx.substring(0, ylfx.indexOf("%"))) / 100;
        try {
            Integer res = syscsService.UpdateYlfx(ylfxBaifen);
            if (res == 1) {
                return Result.success(null);
            } else {
                return Result.error(CodeMsg.SERVER_ERROR);
            }
        } catch (Exception e) {
            return Result.error(CodeMsg.SERVER_ERROR);
        }
    }
}

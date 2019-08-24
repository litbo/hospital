package com.litbo.hospital.lifemanage.controller;

import com.litbo.hospital.lifemanage.bean.vo.SgPdVO;
import com.litbo.hospital.lifemanage.service.SgPdSeverice;
import com.litbo.hospital.result.Result;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lifeManage")
@Api(tags = "离线盘点")
public class SgPdController {
    @Autowired
    private SgPdSeverice sgPdService;

    /**
     * 插入盘点扫描到的所有编号
     *
     * @param record
     */
    @PostMapping("/insertSgPdId")
    public Result insertSgPd(@RequestBody SgPdVO record) {
        return Result.success(sgPdService.insertPdId(record));
    }

    /**
     * 返回盘点数据的状态
     * @param
     * @return
     */
    @GetMapping("/selectAllData")
    public Result selectAllData(@RequestParam String pdJhid) {
        return Result.success(sgPdService.selectAllData(pdJhid));
    }

}

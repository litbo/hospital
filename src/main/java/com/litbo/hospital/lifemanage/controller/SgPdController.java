package com.litbo.hospital.lifemanage.controller;

import com.alibaba.fastjson.JSON;
import com.litbo.hospital.lifemanage.bean.vo.SgPdVO;
import com.litbo.hospital.lifemanage.service.SgPdSeverice;
import com.litbo.hospital.result.Result;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/lifeManage")
@Api(tags = "离线盘点")
public class SgPdController {
    @Autowired
    private SgPdSeverice sgPdService;

    /**
     * 上传盘点数据
     * @param multipartFile
     * @return
     * @throws IOException
     */
    @PostMapping("/uploadPd")
    public Result uploadPdScan(MultipartFile multipartFile) throws IOException {
        if (!multipartFile.isEmpty()) {
            SgPdVO sgPdVO;
            byte[] bytes = multipartFile.getBytes();
            String s = new String(bytes, 0, bytes.length);
            System.out.println(s);
            sgPdVO = JSON.parseObject(s, SgPdVO.class);
            return Result.success(sgPdService.insertPdId(sgPdVO));
        } else {
            return Result.error("这是一个空文件");
        }
    }

    /**
     * 插入盘点扫描到的所有编号
     *
     * @param record
     */
    @PostMapping("/insertSgPdId")
    public Result insertSgPd(@RequestBody SgPdVO record) {
        return Result.success(sgPdService.insertJhCz(record));
    }

    /**
     * 返回盘点数据的状态
     *
     * @param
     * @return
     */
    @GetMapping("/selectAllData")
    public Result selectAllData(@RequestParam String pdJhid) {
        return Result.success(sgPdService.selectAllData(pdJhid));
    }

}

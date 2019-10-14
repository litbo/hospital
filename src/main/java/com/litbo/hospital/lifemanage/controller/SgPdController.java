package com.litbo.hospital.lifemanage.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.lifemanage.bean.vo.SgPdVO;
import com.litbo.hospital.lifemanage.service.SgPdSeverice;
import com.litbo.hospital.metering.vo.PageVo;
import com.litbo.hospital.result.Result;
import io.swagger.annotations.Api;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/lifeManage")
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
    @PostMapping(value = "/uploadPd")
//    @RequestMapping(value = "/uploadPd")
    @ResponseBody
    public Result uploadPdScan(@RequestParam("bmId")String bmId,@RequestParam("multipartFile") MultipartFile multipartFile,@RequestParam String pdJhid) {

        try {
            if (!multipartFile.isEmpty()) {
                SgPdVO sgPdVO;
                byte[] bytes = multipartFile.getBytes();
                String s = new String(bytes, 0, bytes.length);
//                System.out.println(s);
                sgPdVO = JSON.parseObject(s, SgPdVO.class);
                sgPdService.insertPdId(sgPdVO,pdJhid);
                try{
                    sgPdService.insetStatus(pdJhid,bmId);
                }catch (Exception e){
                    e.printStackTrace();
                }
                return Result.success();
            } else {
                return Result.error("这是一个空文件");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Result.success();


    }

    @ResponseBody
    @RequestMapping("/insertStatus")// 插入所有状态数据
    public Result insertStatusController(@RequestParam("pdJhid")String pdJhid,
                                       @RequestParam("bmId") String bmId){


//        System.out.println("88888888888");
        sgPdService.insetStatus(pdJhid,bmId);

        return Result.success();
    }



}

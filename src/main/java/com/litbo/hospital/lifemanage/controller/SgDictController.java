package com.litbo.hospital.lifemanage.controller;

import com.litbo.hospital.lifemanage.bean.SgDict;
import com.litbo.hospital.lifemanage.service.SgDictService;
import com.litbo.hospital.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * SgDictController 申购字典Controller
 *
 * @author Administrator on 2018-12-11
 */
@RestController
@RequestMapping("/lifeManage")
public class SgDictController {
    @Autowired
    private SgDictService sgDictService;

    /**
     * 查询申购字典信息
     * @return Result
     */
    @PostMapping("selectSgDict")
    public Result selectSgDict(){
        return Result.success(sgDictService.selectSgDict());
    }

    /**
     * 添加申购字典信息
     * @param sgDict 字典信息
     * @return Result
     */
    @PostMapping("updateSgDict")
    public Result updateSgDict(@RequestBody SgDict sgDict){
        sgDictService.updateSgDict(sgDict);
        return Result.success();
    }
}

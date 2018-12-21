package com.litbo.hospital.lifemanage.controller;

import com.litbo.hospital.lifemanage.bean.vo.SgDxyxzbkcVO;
import com.litbo.hospital.lifemanage.service.SgDxyxzbkcService;
import com.litbo.hospital.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 大型医学装备考察报告表Controller
 */
@RestController
@RequestMapping("/lifeManage")
public class SgDxyxzbkcController {
    @Autowired
    private SgDxyxzbkcService sgDxyxzbkcService;

    /**
     * 添加或更新大型医学装备考察报告信息
     *
     * @param sgDxyxzbkcVO 大型医学装备考察报告信息
     * @return Result
     */
    @PostMapping("insertSgDxyxzbkc")
    public Result insertSgDxyxzbkc(@RequestBody SgDxyxzbkcVO sgDxyxzbkcVO) {
        sgDxyxzbkcService.insertOrUpdateSgDxyxzbkc(sgDxyxzbkcVO);
        return Result.success();
    }

    /**
     * 根据申购单id查询大型医学装备考察报告信息
     *
     * @param sgInfoId 根据申购单id
     * @return SgDxyxzbkcVO
     */
    @PostMapping("selectSgDxyxzbkc")
    public Result selectSgDxyxzbkc(@RequestParam("sgInfoId") String sgInfoId) {
        SgDxyxzbkcVO sgDxyxzbkcVO = sgDxyxzbkcService.selectSgDxyxzbkc(sgInfoId);
        if(sgDxyxzbkcVO != null){
            return Result.success(sgDxyxzbkcVO);
        }else{
            return Result.success();
        }
    }

}

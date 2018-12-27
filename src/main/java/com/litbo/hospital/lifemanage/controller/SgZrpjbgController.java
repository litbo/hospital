package com.litbo.hospital.lifemanage.controller;

import com.litbo.hospital.lifemanage.bean.SgZrpjbg;
import com.litbo.hospital.lifemanage.service.SgZrpjbgService;
import com.litbo.hospital.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 准入评价报告表Controller
 */
@RestController
@RequestMapping("/lifeManage")
public class SgZrpjbgController {
    @Autowired
    private SgZrpjbgService sgZrpjbgService;

    /**
     * 添加准入评价报告信息
     *
     * @param sgZrpjbg 准入评价报告
     */
    @PostMapping("/insertSgZrpjbg")
    public Result insertSgZrpjbg(SgZrpjbg sgZrpjbg){
        sgZrpjbgService.insertOrUpdateSgZrpjbg(sgZrpjbg);
        return Result.success();
    }

    /**
     * 根据申购单id查询准入评价报告信息
     * @param sgInfoId 申购单id
     * @return Result 评价报告信息
     */
    @PostMapping("/selectSgZrpjbgBySgInfoId")
    public Result selectSgZrpjbgBySgInfoId(@RequestParam("sgInfoId")String sgInfoId){
        SgZrpjbg sgZrpjbg = sgZrpjbgService.selectSgZrpjbgBySgInfoId(sgInfoId);
        if(sgZrpjbg != null){
            return Result.success(sgZrpjbg);
        }else{
            return Result.success();
        }
    }

}

package com.litbo.hospital.security.controller;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.security.bean.FwWeixiu;
import com.litbo.hospital.security.bean.FwWxqs;
import com.litbo.hospital.security.service.FwWeixiuService;
import com.litbo.hospital.security.vo.WeixiuIndexVo;
import com.litbo.hospital.security.vo.WxqrIndex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author zjc
 * @create 2018-12-06 13:08
 */
@RestController
@RequestMapping("/fwWeixiu")
public class FwWeixiuController {

    @Autowired
    private FwWeixiuService fwWeixiuService;

    @GetMapping("/wxqsIndex")
    public Result wxqsIndex(String fwId){
        try {
            WxqrIndex wxqrIndex = fwWeixiuService.wxqsIndex(fwId);
            return Result.success(wxqrIndex);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("加载数据失败");
        }
    }

    @GetMapping("/weixiuIndex")
    public Result weixiuIndex(String fwId){
        try {
            WeixiuIndexVo weixiuIndexVo = fwWeixiuService.weixiuIndex(fwId);
            return Result.success(weixiuIndexVo);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("加载数据失败");
        }
    }

    /**
     *直接维修,配件清零，院外维修
     * @param fwWeixiu
     * @return
     */
    @PostMapping("/addFwWeixiu")
    public Result addFwWeixiu(FwWeixiu fwWeixiu){
        try {
            String userId = "1615925039";
            fwWeixiuService.addFwWeixiu(fwWeixiu,userId);
            return  Result.success();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("添加失败");
        }

    }

    /**
     * 维修确认
     * @param fwWxqs
     * @return
     */
            @PostMapping("/addFwWxqs")
    public Result addFwWxqs(FwWxqs fwWxqs){
        try {
            String userId = "1";
            fwWeixiuService.addFwWxqs(fwWxqs,userId);
            return  Result.success();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("添加失败");
        }
    }

    @GetMapping("/updateWxsh")
    public Result updateWxsh(String fwId){
        try {
            String userId = "1";
            fwWeixiuService.updateFwWxqs(userId,fwId);
            return Result.success();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("审核失败");
        }
    }


}

package com.litbo.hospital.security.controller;

import com.litbo.hospital.result.Result;
import com.litbo.hospital.security.bean.FwWeixiu;
import com.litbo.hospital.security.bean.FwYwwx;
import com.litbo.hospital.security.service.FwWeixiuService;
import com.litbo.hospital.security.vo.*;
import com.litbo.hospital.user.vo.LiveEmpVo;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author zjc
 * @create 2018-12-06 13:08
 */
@RestController
@RequestMapping("/fwWeixiu")
public class FwWeixiuController {

    @Autowired
    private FwWeixiuService fwWeixiuService;

    @PostMapping("/wxtz")
    public Result wxtz(){
        return Result.success();
    }

    @GetMapping("/wxqsShIndexVo")
    public Result wxqsShIndexVo(String id){
        try {
            LiveEmpVo sEmp = (LiveEmpVo)SecurityUtils.getSubject().getSession().getAttribute("emp");
            String userId = sEmp.getUserId();
            System.out.println(id);
            FwWxqsShIndexVo fwWxqsShIndexVo = fwWeixiuService.wxqsShIndexVo(userId, id);
            return Result.success(fwWxqsShIndexVo);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("数据异常");
        }
    }


    /**
     * 维修确认页面
     * @param id
     * @return
     */
    @GetMapping("/wxqsIndexVo")
    public Result wxqsIndexVo(String id){
        try {
            LiveEmpVo sEmp = (LiveEmpVo)SecurityUtils.getSubject().getSession().getAttribute("emp");
            String userId = sEmp.getUserId();
            //System.out.println(id);
            FwWxqrIndexVo fwWxqrIndexVo = fwWeixiuService.wxqrIndexVo(userId, id);
            return Result.success(fwWxqrIndexVo);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("数据异常");
        }
    }

    @GetMapping("/jumpPj")
    public Result jumpPj(String fwId){
        try {
            LiveEmpVo sEmp = (LiveEmpVo)SecurityUtils.getSubject().getSession().getAttribute("emp");
            String userId = sEmp.getUserId();
            int i = fwWeixiuService.jumpPj(userId, fwId);
            if(i == 0){
                Result.error("操作不合法");
            }
            return Result.success();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("数据异常");
        }

    }

    @GetMapping("/jumpYwwx")
    public Result jumpYwwx(FwYwwx fwYwwx){
        try {
            LiveEmpVo sEmp = (LiveEmpVo) SecurityUtils.getSubject().getSession().getAttribute("emp");
            String userId = sEmp.getUserId();
            int i = fwWeixiuService.jumpYwwx(fwYwwx);
            if(i == 0){
                return Result.error("操作不合法");
            }
            if (i > 0) {
                return Result.success();
            }  else {
                return Result.error("院外维修异常");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("数据异常");
        }

    }

    @PostMapping("/jumpWx")
    public Result jumpWx(FwWeixiu fwWeixiu){
        try {
            LiveEmpVo sEmp = (LiveEmpVo)SecurityUtils.getSubject().getSession().getAttribute("emp");
            String userId = sEmp.getUserId();
            int i = fwWeixiuService.addFwWeixiu(fwWeixiu, userId);
            if(i == 0){
                return Result.error("操作不合法");
            }
            return Result.success();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("数据异常");
        }

    }


    @GetMapping("/pjqlWxIndex")
    public Result pjqlWxIndex(String wxrId){
        try {
            String wxrName = fwWeixiuService.pjqlWxIndex(wxrId);
            HashMap<String, String> map = new HashMap<>();
            map.put("wxrName",wxrName);
            System.out.println(map);
            return Result.success(map);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("数据返回异常");
        }
    }

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
            LiveEmpVo sEmp = (LiveEmpVo)SecurityUtils.getSubject().getSession().getAttribute("emp");
            String userId = sEmp.getUserId();
            /*过时
            WeixiuIndexVo weixiuIndexVo = fwWeixiuService.weixiuIndex(fwId);*/
            FwWeiXiuIndexVo fwWeiXiuIndexVo = fwWeixiuService.weixiuIndexVo(fwId, userId);
            return Result.success(fwWeiXiuIndexVo);
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
            LiveEmpVo sEmp = (LiveEmpVo)SecurityUtils.getSubject().getSession().getAttribute("emp");
            String userId = sEmp.getUserId();
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
    public Result addFwWxqs(FwWxqsVo fwWxqs){
        try {
            LiveEmpVo sEmp = (LiveEmpVo)SecurityUtils.getSubject().getSession().getAttribute("emp");
            String userId = sEmp.getUserId();

            fwWeixiuService.addFwWxqs(fwWxqs,userId);
            return  Result.success();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("添加失败");
        }
    }

    @PostMapping("/updateWxsh")
    public Result updateWxsh(String fwId,Integer taskId){
        try {
            LiveEmpVo sEmp = (LiveEmpVo)SecurityUtils.getSubject().getSession().getAttribute("emp");
            String userId = sEmp.getUserId();
            fwWeixiuService.updateFwWxqs(userId,fwId,taskId);
            return Result.success();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("审核失败");
        }
    }


}

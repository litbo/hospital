package com.litbo.hospital.security.controller;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.security.bean.FwWxf;
import com.litbo.hospital.security.service.FwWxfService;
import com.litbo.hospital.security.vo.FwIdSelectVo;
import com.litbo.hospital.security.vo.FwWxfIndexVo;
import com.litbo.hospital.security.vo.FwWxfShIndexVo;
import com.litbo.hospital.security.vo.WxfListVo;
import com.litbo.hospital.user.vo.LiveEmpVo;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author zjc
 * @create 2018-12-09 9:47
 */
@RestController
@RequestMapping("/wxf")
public class FwWxfController {

    @Autowired
    private FwWxfService fwWxfService;

    @GetMapping("/wxfSh")
    public Result wxfSh(Integer id , String wxfSpyj, Date wxfSptime){

        try {
            int i = fwWxfService.updateWxf(id, wxfSpyj, wxfSptime);
            if(i>0){
                return Result.success(i);
            }else {
                return Result.error("修改失败1");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("修改失败2");
        }

    }

    /**
     * 维修费审核主页面
     * @param id
     * @return
     */
    @GetMapping("/wxfShIndex")
    public Result wxfShIndex(Integer id){
        try {
            LiveEmpVo sEmp = (LiveEmpVo)SecurityUtils.getSubject().getSession().getAttribute("emp");
            String userId = sEmp.getUserId();
            FwWxfShIndexVo wxfShIndexVo = fwWxfService.wxfShIndex(id, userId);
            return Result.success(wxfShIndexVo);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("查询数据失败");
        }
    }

    @GetMapping("/wxfList")
    public Result wxfList(@RequestParam(required = false,defaultValue = "10") Integer pageSize,
                          @RequestParam(required = false,defaultValue = "1") Integer pageNum,
                          @RequestParam(required = false) String fwId,@RequestParam(required = false) String eqName){
        try {
            LiveEmpVo sEmp = (LiveEmpVo)SecurityUtils.getSubject().getSession().getAttribute("emp");
            String userId = sEmp.getUserId();
            PageInfo<WxfListVo> pageInfo = fwWxfService.WxfList(userId, pageNum, pageSize,fwId,eqName);
            return Result.success(pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("读取数据失败");
        }
    }

    /**
     * 维修费审核主页面{过时}
     * @param
     * @return
     */
    /*@GetMapping("/wxfShIndex")
    public Result wxfShIndex(Integer id){
        try {
            WxfIndexVo wxfIndexVo = fwWxfService.wxfShIndex(id);
            return Result.success(wxfIndexVo);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("读取信息失败");
        }
    }*/

    @GetMapping("/wxfGetEq")
    public Result wxfGetEq(){
        try {
            LiveEmpVo sEmp = (LiveEmpVo)SecurityUtils.getSubject().getSession().getAttribute("emp");
            String userId = sEmp.getUserId();
            List<FwIdSelectVo> list = fwWxfService.wxfGetEq(userId);
            return Result.success(list);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("读取信息失败");
        }
    }

    /**
     * 维修费申请主页面
     * @param fwId
     * @return
     */
    @GetMapping("/wxfIndex")
    public Result wxfIndex(String fwId){
        LiveEmpVo sEmp = (LiveEmpVo)SecurityUtils.getSubject().getSession().getAttribute("emp");
        String userId = sEmp.getUserId();
        /**
         * SecurityUtils.getSubject().getSession().getAttribute();
         */
        try {
            FwWxfIndexVo wxfIndexVo = fwWxfService.fwWxfIndex(fwId, userId);
            return Result.success(wxfIndexVo);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("读取信息失败");
        }
    }

    /**
     * 维修费申请添加
     * @param fwWxf
     * @return
     */
    @PostMapping("/addWxf")
    public Result addWxf(FwWxf fwWxf){
        try {
            fwWxfService.addFwWxf(fwWxf);
            return Result.success();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("添加失败");
        }
    }

    @PostMapping("/updateWxf")
    public Result updateWxf(int status,String spyj,String fwId){
        try {
            //session获取
            LiveEmpVo sEmp = (LiveEmpVo)SecurityUtils.getSubject().getSession().getAttribute("emp");
            String userId = sEmp.getUserId();
            fwWxfService.updateFwWxf(userId,status,spyj,fwId);
            return Result.success();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("审核失败");
        }
    }

}

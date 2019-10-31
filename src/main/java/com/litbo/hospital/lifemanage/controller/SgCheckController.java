package com.litbo.hospital.lifemanage.controller;

import com.litbo.hospital.lifemanage.bean.SelectVO;
import com.litbo.hospital.lifemanage.bean.SgCheck;
import com.litbo.hospital.lifemanage.bean.SgPdZt;
import com.litbo.hospital.lifemanage.bean.vo.ListIdsVO;
import com.litbo.hospital.lifemanage.bean.vo.SgCheckVO;
import com.litbo.hospital.lifemanage.dao.SelectMapper;
import com.litbo.hospital.lifemanage.dao.SgCheckMapper;
import com.litbo.hospital.lifemanage.service.SgCheckService;
import com.litbo.hospital.lifemanage.service.SgPdSeverice;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.user.service.EqService;
import com.litbo.hospital.user.vo.EqInfoVo;
import com.litbo.hospital.user.vo.LiveEmpVo;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 账实核对Controller
 *
 * @author Administrator on 2018-12-29
 */
@RestController
@RequestMapping("/lifeManage")
public class SgCheckController {
    @Autowired
    private SgCheckService sgCheckService;
    @Autowired
    EqService es;

    @Autowired
    SelectMapper selectMapper;
    @Autowired
    SgCheckMapper sgCheckMapper;
    @Autowired
    SgPdSeverice sgPdService;
    /**
     * 计划查询账实核对信息
     *
     * @param planId   计划id
     * @param pageNum  当前页数
     * @param pageSize 每页显示记录数
     * @return Result
     */
    @PostMapping("/selectSgCheck")
    @ResponseBody
    public Result selectSgCheck(@RequestParam(name = "planId") String planId,
                                @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        return Result.success(sgCheckService.selectSgCheck(planId, pageNum, pageSize));
    }

    /**
     * 添加账实核对信息  审核存在
     *
     * @param ids 核对表id
     * @return Result
     */
    @RequestMapping("/updateSgCheckYByIds")
    @ResponseBody
    public Result updateSgCheckYByIds(@RequestBody ListIdsVO ids) {
        System.out.println(ids);
        try{
//            System.out.println(ids.getIds());
            //获取登陆人id
//            LiveEmpVo emp = (LiveEmpVo) session.getAttribute("emp");

            LiveEmpVo emp = (LiveEmpVo) SecurityUtils.getSubject().getSession().getAttribute("emp");
            sgCheckService.updateSgCheckByIds(ids.getIds(), emp.getUserId(), "1");

        }catch (Exception e){
            e.printStackTrace();
        }

        return Result.success();
    }

    /**
     * 添加账实核对信息 审核不存在
     *
     * @param id 核对表id
     * @return Result
     */
    @RequestMapping("/updateSgCheckNByIds")
    public Result updateSgCheckNByIds(@RequestBody ListIdsVO id) {
        //获取登陆人id
        LiveEmpVo emp = (LiveEmpVo) SecurityUtils.getSubject().getSession().getAttribute("emp");
        sgCheckService.updateSgCheckByIds(id.getIds(), emp.getUserId(), "0");
        return Result.success();
    }

    /**
     * 核对对比
     *
     * @param planId    计划id
     * @param check     是否存在
     * @param checkDate 审核日期
     * @param checkUser 审核人
     * @param planDate  制定日期
     * @param planUser  制定人
     * @param pageNum   当前页数
     * @param pageSize  每页显示的记录数
     * @return Result
     */
    @PostMapping("/selectSgCheckList")
    public Result selectSgCheckList(@RequestParam(name = "planId") String planId,
                                    @RequestParam(name = "check", required = false) String check,
                                    @RequestParam(name = "checkDate", required = false) String checkDate,
                                    @RequestParam(name = "checkUser", required = false) String checkUser,
                                    @RequestParam(name = "planDate", required = false) String planDate,
                                    @RequestParam(name = "planUser", required = false) String planUser,
                                    @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                    @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
//        System.out.println("aaaaaaaa");
//        System.out.println("aaaaaaaa");
//        System.out.println("aaaaaaaa");
        return Result.success(sgCheckService.selectSgCheckList(planId, check, checkDate, checkUser, planDate, planUser, pageNum, pageSize));
    }

    /*
    * @Param planId 需要修改计划plan_id为planId
    * @Param eqId  设备录入表的设备id  eqId
    * */
//    @RequestMapping("addOther")//盘亏录入
//    public Result addOther(SgCheck sgChcck){
//        sgCheckService.addOther(sgChcck);
//        return  Result.success();
//    }
    @RequestMapping(value = "/addEq")
    public Result addEq(@RequestBody EqInfoVo eqInfo) {
        String planId = eqInfo.getPlanId();
        if (es.addEq(eqInfo) > 0) {
            SgCheck sgChcck = new SgCheck();
            sgChcck.setEqId(eqInfo.getEqId());
            sgChcck.setPlanId(planId);
            sgCheckService.addOther(sgChcck);
            System.out.println(eqInfo.getEqSbbh());

//            List<SelectVO> adllDate3 = selectMapper.listCheckDate(eqInfo.getEqBmid());

//            sgPdService.insetStatus(pdJhid,bmId);
            try{
                String eqName = selectMapper.listBmName(eqInfo.getEqId());
                SgPdZt sgPdZt = new SgPdZt();
                sgPdZt.setPdJhid(eqInfo.getPlanId());
                sgPdZt.setBmName(eqName);
                sgPdZt.setEqSbbh(eqInfo.getEqZcbh());
                sgPdZt.setEqName(eqInfo.getEqName());
                sgPdZt.setPdZt("盘亏");
                selectMapper.insertZt(sgPdZt);
            }catch (Exception e){
                e.printStackTrace();
            }


        }

            return Result.success();
    }

    @RequestMapping("/findListByEqName")
    @ResponseBody
    public Result findByEqNameController(@RequestParam(name = "planId") String planId,
                                @RequestParam("eqName") String eqName,
                                @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        return Result.success(sgCheckService.findListByEqName(planId, eqName, pageNum,pageSize));
    }
}

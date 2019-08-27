package com.litbo.hospital.lifemanage.controller.MyController;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.lifemanage.MyUtils.String2DateUtil;
import com.litbo.hospital.lifemanage.bean.vo.MyVO.YjyaZdVO;
import com.litbo.hospital.lifemanage.dao.MyMapper.YjyaZdMapper;
import com.litbo.hospital.lifemanage.service.MyService.YjyaZdService;
import com.litbo.hospital.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/*应急预案制定*/
@RestController
@RequestMapping("/lifeManage")
public class YjyaZdController {

    @Autowired
    private YjyaZdService service;
    @Autowired
    private YjyaZdMapper mapper;

    /*
     * 方法功能描述: 应急预案制定的增加
     * @Param: vo[YjyaZdVO]
     * @Return: com.litbo.hospital.result.Result
     * @Description:
     * @Author: NCH
     */

    @PostMapping("/insertYjyaZd")
    public Result insertYjyaZd(@RequestBody YjyaZdVO vo) {
        /*LiveEmpVo sEmp = (LiveEmpVo) SecurityUtils.getSubject().getSession().getAttribute("emp");
        vo.setYjyaFbbm(sEmp.getBmId());
        vo.setYjyaNgr(sEmp.getUserXm());*/
        int i = service.insertYjyaZd(vo);
        if (i == 1) {
            return Result.success(i);
        } else {
            return Result.error("请求失败");
        }
    }

    /*/**
     * 方法功能描述: 普通应急预案制定的修改
     * @Param: vo[YjyaZdVO]
     * @Return: com.litbo.hospital.result.Result
     * @Description:
     * @Author: NCH
     */
    @PostMapping("/updateYjyaZd")
    public Result updateYjyaZd(@RequestBody YjyaZdVO vo) {
        int i = service.updateYjyaZd(vo);
        if (i == 1) {
            return Result.success();
        } else {
            return Result.error("请求失败");
        }
    }

    /*/**
     * 方法功能描述: 应急预案审核后跳的url
     * @Param: vo[YjyaZdVO]
     * @Return: com.litbo.hospital.result.Result
     * @Description:
     * @Author: NCH
     */
    @PostMapping("/updateSysjYjyaZd")
    public Result updateSysjYjyaZd(@RequestBody YjyaZdVO vo) {
        int i = service.updateShYjyaZd(vo);
        if (i == 1) {
            return Result.success();
        } else {
            return Result.error("请求失败");
        }
    }

    /*/**
     * 方法功能描述: 应急预案所有待审核的查询
     * @Param: 预案编号，名称，拟稿人。查询起始时间。查询结束时间
     * @Return: com.litbo.hospital.result.Result
     * @Description:
     * @Author: NCH
     */
    @PostMapping("/selectAllSh")
    public Result selectAllSh(@RequestParam(required = false,defaultValue = "1",name = "pageNum")Integer pageNum,
                              @RequestParam(required = false,defaultValue = "1",name = "pageSize")Integer pageSize,
                              @RequestParam(required = false,name = "bh")String bh,
                              @RequestParam(required = false,name = "mc")String mc,
                              @RequestParam(required = false,name = "ngr")String ngr,
                              @RequestParam(required = false,name = "qssj")String qssj,
                              @RequestParam(required = false,name = "jssj")String jssj
                              ) {
        Date qs = String2DateUtil.StringtoDate(qssj);
        Date js = String2DateUtil.StringtoDate(qssj);
        PageInfo<YjyaZdVO> info = service.selectAllSh(pageNum,pageSize,bh,mc,ngr,qs,js);
        return Result.success(info);

    }


    /*/**
     * 方法功能描述: 修改单个预案状态
     * @Param: bh[String]预案编号   ，zt[String]预案状态
     * @Return: com.litbo.hospital.result.Result
     * @Description:
     * @Author: NCH
     */
    @PostMapping("/updateYaStatu")
    public Result updateYaStatu(@RequestParam(name = "bh") String bh, @RequestParam (name = "zt") String zt) {
        int i = mapper.updateYaStatus(bh, zt);
        if (i == 1) {
            return Result.success();
        } else {
            return Result.error("请求失败");
        }
    }





}

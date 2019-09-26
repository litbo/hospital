package com.litbo.hospital.lifemanage.controller;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.lifemanage.bean.vo.MachineAccountVO;
import com.litbo.hospital.lifemanage.service.EquipmentAccountService;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.user.vo.LiveEmpVo;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 电子台账Controller
 *
 * @author Administrator on 2018-12-16
 */


@RestController
@RequestMapping("/lifeManage")
public class EquipmentAccountController {
    @Autowired
    private EquipmentAccountService equipmentAccountService;

    /**
     * 电子台账列表
     *
     * @param category            购置类别
     * @param state               状态
     * @param departmentId        部门id
     * @param equipmentPinyinCode 设备拼音码
     * @param departmentCoding    院内编码
     * @param equipmentNumber     设备编码
     * @param pageNum             当前页数
     * @param pageSize            每页显示的条数
     * @return PageInfo<MachineAccountVO>
     */
    @RequestMapping("/selectEquipmentAccount")

    public Result selectEquipmentAccount(
            @RequestParam(name = "category", required = false) String category,
            @RequestParam(name = "state", required = false) String state,
            @RequestParam(name = "tzlb", required = false) String tzlb,
            @RequestParam(name = "departmentId", required = false) String departmentId,
            @RequestParam(name = "equipmentPinyinCode", required = false) String equipmentPinyinCode,
            @RequestParam(name = "departmentCoding", required = false) String departmentCoding,
            @RequestParam(name = "equipmentNumber", required = false) String equipmentNumber,
            @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        LiveEmpVo sEmp = (LiveEmpVo) SecurityUtils.getSubject().getSession().getAttribute("emp");

        PageInfo<MachineAccountVO> info = equipmentAccountService.selectEquipmentAccount(category, state, tzlb, sEmp.getBmId(), equipmentPinyinCode, departmentCoding, equipmentNumber, pageNum, pageSize);
        return Result.success(info);
    }

    /**
     * 科室设备综合查询
     *
     * @param state               状态
     * @param equipmentPinyinCode 设备拼音码
     * @param departmentCoding    院内编码
     * @param eqCxflId            设备分类Id
     * @param tgbmId              托管部门id
     * @param bmId                使用部门
     * @param eqQysjLower         启用时间下限
     * @param eqQysjUpper         启用时间上限
     * @param eqCgrqLower         采购日期下限
     * @param eqCgrqUpper         采购日期上限
     * @param eqPriceLower        设备价格下限
     * @param eqPriceUpper        设备价格上限
     * @param eqBxqx              是否过保 0/1 过保/在保
     * @param pageNum             当前页数
     * @param pageSize            每页显示的条数
     * @return PageInfo
     */
    @PostMapping("/selectKsEq")
    public Result selectKsEq(
            @RequestParam(name = "state", required = false) String state,
            @RequestParam(name = "equipmentPinyinCode", required = false) String equipmentPinyinCode,
            @RequestParam(name = "departmentCoding", required = false) String departmentCoding,
            @RequestParam(name = "eqCxflId", required = false) String eqCxflId,
            @RequestParam(name = "tgbmId", required = false) String tgbmId,
            @RequestParam(name = "bmId", required = false) String bmId,
            @RequestParam(name = "eqQysjLower", required = false) String eqQysjLower,
            @RequestParam(name = "eqQysjUpper", required = false) String eqQysjUpper,
            @RequestParam(name = "eqCgrqLower", required = false) String eqCgrqLower,
            @RequestParam(name = "eqCgrqUpper", required = false) String eqCgrqUpper,
            @RequestParam(name = "eqPriceLower", required = false) String eqPriceLower,
            @RequestParam(name = "eqPriceUpper", required = false) String eqPriceUpper,
            @RequestParam(name = "eqBxqx", required = false) String eqBxqx,
            @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        return Result.success(equipmentAccountService.selectKsEq(tgbmId, bmId, eqQysjLower, eqQysjUpper, eqCgrqLower, eqCgrqUpper, eqPriceLower, eqPriceUpper, state, equipmentPinyinCode, departmentCoding, eqCxflId, eqBxqx, pageNum, pageSize));
    }

    /**
     * 设备卡详情
     *
     * @param eqSbbh 设备编号
     * @return Result
     */


    @RequestMapping("/selectEqCardShow")
    public Result selectEqCardShow(@RequestParam(name = "eqSbbh") String eqSbbh) {
        return Result.success(equipmentAccountService.selectEqCardShow(eqSbbh));
    }

}

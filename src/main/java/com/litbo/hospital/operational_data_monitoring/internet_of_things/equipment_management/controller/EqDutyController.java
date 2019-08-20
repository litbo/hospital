package com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.controller;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.common.utils.DbUtil.IDFormat;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.VO.EqDutyVO;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.VO.EqMacIds;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.VO.EqOvertimeVO;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.VO.SearchVO;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.bean.ApprovedWorkingHours;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.bean.EqDutyTab;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.bean.EqOvertimeTab;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.service.ApprovedWorkingHoursService;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.service.EqDutyTabService;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.service.EqOvertimeTabService;
import com.litbo.hospital.result.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.controller
 * @Author: looli
 * @CreateTime: 2019-07-31 13:58
 * @Description: todo
 */
@RestController
@RequestMapping("/duty")
public class EqDutyController {

    @Autowired
    private EqDutyTabService eqDutyTabService;
    @Autowired
    private EqOvertimeTabService eqOvertimeTabService;
    @Autowired
    private ApprovedWorkingHoursService approvedWorkingHoursService;
    /**
     *  显示设备值班信息
     *  根据条件查找
     * @param pageNum
     * @param pageSize
     * @param searchVO
     * @return
     */
    @RequestMapping("/show")
    public Result show(@RequestParam(required = false,defaultValue = "1") Integer pageNum,
                       @RequestParam(required = false,defaultValue = "10") Integer pageSize,
                       SearchVO searchVO){
//        System.out.println(searchVO);
        System.out.println(searchVO);
        if (searchVO.getEqSbbh()!=null){
            if ("".equals(searchVO.getEqSbbh())){
                searchVO.setEqSbbh(null);
            }
        }
        if (searchVO.getBmId()!=null){
            if ("".equals(searchVO.getBmId())){
                searchVO.setBmId(null);
            }
        }
        if (searchVO.getEqPym()!=null){
            if ("".equals(searchVO.getEqPym())){
                searchVO.setEqPym(null);
            }
        }
        PageInfo pageInfo = eqDutyTabService.selectAll(pageNum, pageSize,searchVO);
        return Result.success(pageInfo);
    }

    /**
     * 根据值班排班信息id查看值班详细信息
     * @param id
     * @return
     */
    @RequestMapping("/showOne")
    public Result showOne(String id){
        EqDutyVO eqDutyVO = eqDutyTabService.showOne(id);
        return Result.success(eqDutyVO);
    }

    /**
     * 保存设备值班信息
     * @param eqDutyVO
     * @return
     */
    @RequestMapping("/save")
    public Result save(@RequestBody EqDutyVO eqDutyVO){
        String idByIDAndTime = eqDutyVO.getMacId();
        //添加设备值班信息
        EqDutyTab eqDutyTab = new EqDutyTab();
        BeanUtils.copyProperties(eqDutyVO,eqDutyTab);
        eqDutyTab.setEqMacId(idByIDAndTime);
        eqDutyTab.setId(IDFormat.getIdByIDAndTime("eq_duty_tab","id"));
        System.out.println(eqDutyTab);
        eqDutyTab.setDtype(eqDutyVO.getCdtypeName());
        eqDutyTabService.save(eqDutyTab);
        //添加设备加班信息
        EqOvertimeTab eqOvertimeTab = new EqOvertimeTab();
        BeanUtils.copyProperties(eqDutyVO,eqDutyTab);
        eqOvertimeTab.setEqMacId(idByIDAndTime);
        eqOvertimeTab.setId(IDFormat.getIdByIDAndTime("eq_overtime_tab","id"));
        System.out.println(eqOvertimeTab);
        eqOvertimeTabService.save(eqOvertimeTab);
        //添加设备核定工时设置
        ApprovedWorkingHours approvedWorkingHours = new ApprovedWorkingHours();
        BeanUtils.copyProperties(eqDutyVO,eqDutyTab);
        approvedWorkingHours.setId(IDFormat.getIdByIDAndTime("approved_working_hours","id"));
        approvedWorkingHours.setEqMacId(idByIDAndTime);
        System.out.println(approvedWorkingHours);
        approvedWorkingHoursService.save(approvedWorkingHours);
        return Result.success();
    }
    /**
     * 修改设备值班信息
     * @param eqDutyVO
     * @return
     */
    @RequestMapping("/update")
    public Result update(@RequestBody EqDutyVO eqDutyVO){
        String idByIDAndTime = eqDutyVO.getMacId();
        //添加设备值班信息
        EqDutyTab eqDutyTab = new EqDutyTab();
        BeanUtils.copyProperties(eqDutyVO,eqDutyTab);
        eqDutyTab.setEqMacId(idByIDAndTime);
        eqDutyTab.setDtype(eqDutyVO.getCdtypeName());
        eqDutyTabService.update(eqDutyTab);

        //添加设备加班信息
        EqOvertimeTab eqOvertimeTab = new EqOvertimeTab();
        BeanUtils.copyProperties(eqDutyVO,eqOvertimeTab);
        eqOvertimeTab.setEqMacId(idByIDAndTime);
        eqOvertimeTabService.update(eqOvertimeTab);
        //添加设备核定工时设置
        ApprovedWorkingHours approvedWorkingHours = new ApprovedWorkingHours();
        BeanUtils.copyProperties(eqDutyVO,eqDutyTab);
        approvedWorkingHours.setEqMacId(idByIDAndTime);
        approvedWorkingHoursService.update(approvedWorkingHours);
        return Result.success();
    }

    /**
     * 删除一个
     * @param eqMacId
     * @return
     */
    @RequestMapping("/delete")
    public Result delete(String eqMacId){
        eqDutyTabService.deleteByEqMacId(eqMacId);
        return Result.success();
    }

    /**
     * 批量删除
     * @param eqMacIds
     * @return
     */
    @RequestMapping(value = "/deletes",method = RequestMethod.POST)
    public Result deletes(@RequestBody EqMacIds eqMacIds){
        eqDutyTabService.deleteByEqMacIds(eqMacIds.getEqMacIds());
        return Result.success();
    }
}

package com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.controller;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.common.utils.DbUtil.IDFormat;
import com.litbo.hospital.lifemanage.bean.vo.MyVO.DeleteHtsByIdsVO;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.dao.DeviceparameterDAO;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.VO.EqInfoVO;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.VO.EqMacVO;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.VO.TD;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.bean.ApprovedWorkingHours;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.bean.EqDutyTab;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.bean.EqOvertimeTab;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.service.ApprovedWorkingHoursService;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.service.DeviceparameterService;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.service.EqDutyTabService;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.service.EqOvertimeTabService;
import com.litbo.hospital.operational_data_monitoring.software_interface.vo.DeviceparameterVO;
import com.litbo.hospital.result.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.VO.SearchVO;

import java.util.List;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.controller
 * @Author: looli
 * @CreateTime: 2019-07-30 17:27
 * @Description: 设备参数设置
 */
@RestController
@RequestMapping("/deviceparameter")
public class DeviceparameterController {

    @Autowired
    private DeviceparameterService service;
    @Autowired
    private EqDutyTabService eqDutyTabService;
    @Autowired
    private EqOvertimeTabService eqOvertimeTabService;
    @Autowired
    private ApprovedWorkingHoursService approvedWorkingHoursService;
    @Autowired
    private DeviceparameterDAO dao;
    /**
     * 显示设备联网信息
     * @param pageSize
     * @param pageNum
     * @return
     */
    @RequestMapping("/show")
    public Result showEqNetWork(@RequestParam(required = false,defaultValue = "1") Integer pageNum,
                                @RequestParam(required = false,defaultValue = "10") Integer pageSize,
                                SearchVO searchVO){
//        System.out.println(searchVO);
        /**
         * 排除前端信息传递空字符串的影响
         */
        if(StringUtils.isBlank(searchVO.getMachineNumber())){
            searchVO.setMachineNumber(null);
        }
        if(StringUtils.isBlank(searchVO.getEqZcbh())){
            searchVO.setEqZcbh(null);
        }
        if (searchVO.getBmId() != null){
            if ("".equals(searchVO.getBmId())){
                searchVO.setBmId(null);
            }
        }
        if (searchVO.getEqSbbh() != null){
            if ("".equals(searchVO.getEqSbbh())){
                searchVO.setEqSbbh(null);
            }
        }
        if (searchVO.getMacid() != null){
            if ("".equals(searchVO.getMacid())){
                searchVO.setMacid(null);
            }
        }
        /**
         * 分页查询设备 设备参数设置表  设备联网表的联合信息
         */
        PageInfo pageInfo = service.showEqNetWork(pageNum, pageSize,searchVO);
        return Result.success(pageInfo);
    }

    /**
     * 根据ip 和 联网仪编号  显示设备信息
     * @param eqMacVO
     * @return 返回一条需要编辑的信息
     */
    @RequestMapping("/showOne")
    public Result showOne(EqMacVO eqMacVO){
        DeviceparameterVO deviceparameterVO = service.showOne(eqMacVO);
        return Result.success(deviceparameterVO);
    }

    @RequestMapping("/deleByLwyId")
    public Result showOne(@RequestBody DeleteHtsByIdsVO vo){
        String[] ids = vo.getIds();
        for (int i = 0; i < ids.length; i++) {
            int bh = dao.deleteLwxByLwxBh(ids[i]);
            if(bh==1){
                dao.deletLwxByLwxBh2(ids[i]);
            }
        }
        return Result.success();
    }


    /**
     * 根据联网仪编号删除一条记录
     * 如果没有联网仪编号，则不删除
     * 如果有联网仪编号，则删除
     * 删除一条记录，删除设备参数设置与设备关联信息和设备联网表中的对应数据
     * @param searchVO
     * @return code = 0 成功
     */
    @RequestMapping("/delete")
    public Result deleteOne(SearchVO searchVO){
        try{
            service.deleteByMacId(searchVO);
            return Result.success();
        }catch (Exception e){
            return Result.error();
        }
    }

    /**
     *  和单个删除一样,只不过是删除
     * @param td
     * @return
     */
    @RequestMapping(value = "/deletes",method = RequestMethod.POST)
    public Result delete(@RequestBody TD td){
        service.deletes(td.getMacIds());
        return Result.success();
    }


    /**
     * 保存设置
     * 修改设备参数表设备编号对应设备编号
     * 新增或修改设备联网表
     * if   联网表id存在 修改
     *      联网表id不存在 新建
     * @param deviceparameterVO
     * @return
     */
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Result save(@RequestBody DeviceparameterVO deviceparameterVO){
        //更新
        if (deviceparameterVO.getMacID() != null && !"".equals(deviceparameterVO.getMacID())){
            service.update(deviceparameterVO);
        }else {//新建
            String idByIDAndTime = IDFormat.getIdByIDAndTime("eq_mac_tab", "Macid");
            deviceparameterVO.setMacID(idByIDAndTime);
            service.save(deviceparameterVO);
            //添加设备值班信息
            EqDutyTab eqDutyTab = new EqDutyTab();
            eqDutyTab.setEqMacId(deviceparameterVO.getMacID());
            eqDutyTab.setId(IDFormat.getIdByIDAndTime("eq_duty_tab","id"));
            eqDutyTabService.save(eqDutyTab);
            //添加设备加班信息
            EqOvertimeTab eqOvertimeTab = new EqOvertimeTab();
            eqOvertimeTab.setEqMacId(deviceparameterVO.getMacID());
            eqOvertimeTab.setId(IDFormat.getIdByIDAndTime("eq_overtime_tab","id"));
            eqOvertimeTabService.save(eqOvertimeTab);
            //添加设备核定工时设置
            ApprovedWorkingHours approvedWorkingHours = new ApprovedWorkingHours();
            approvedWorkingHours.setId(IDFormat.getIdByIDAndTime("approved_working_hours","id"));
            approvedWorkingHours.setEqMacId(deviceparameterVO.getMacID());
            approvedWorkingHoursService.save(approvedWorkingHours);
        }
        return Result.success(5,"");
    }

    /**
     * 查询未绑定值班排班信息的设备信息
     * @param pageNum
     * @param pageSize
     * @param searchVO
     * @return 返回未安排值班的设备的信息
     */
    @RequestMapping("/showNoDutyEq")
    public Result showNoDutyEq(@RequestParam(required = false,defaultValue = "1") Integer pageNum,
                               @RequestParam(required = false,defaultValue = "10") Integer pageSize,
                               SearchVO searchVO){
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
        if (searchVO.getMacid()!=null){
            if ("".equals(searchVO.getMacid())){
                searchVO.setMacid(null);
            }
        }
        PageInfo pageInfo = service.showNoDutyEq(pageNum,pageSize,searchVO);
        return Result.success(pageInfo);
    }
}

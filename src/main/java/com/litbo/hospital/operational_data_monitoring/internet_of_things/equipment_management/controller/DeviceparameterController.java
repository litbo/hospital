package com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.controller;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.VO.EqMacVO;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.service.DeviceparameterService;
import com.litbo.hospital.operational_data_monitoring.software_interface.vo.DeviceparameterVO;
import com.litbo.hospital.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.VO.SearchVO;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.controller
 * @Author: looli
 * @CreateTime: 2019-07-30 17:27
 * @Description: todo
 */
@RestController
@RequestMapping("/deviceparameter")
public class DeviceparameterController {

    @Autowired
    private DeviceparameterService service;

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
        /**
         * 排除前端信息传递空字符串的影响
         */
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
        System.out.println(eqMacVO);
        DeviceparameterVO deviceparameterVO = service.showOne(eqMacVO);
        return Result.success(deviceparameterVO);
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
        System.out.println(searchVO);
        try{
            service.deleteByMacId(searchVO);
            return Result.success();
        }catch (Exception e){
            return Result.error();
        }
    }
}

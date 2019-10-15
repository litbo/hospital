package com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.common.utils.DbUtil.IDFormat;
import com.litbo.hospital.lifemanage.bean.vo.MyVO.EqTjsqVO;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.VO.EqMacVO;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.bean.Deviceparameter;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.bean.EqMacTab;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.dao.*;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.service.DeviceparameterService;
import com.litbo.hospital.operational_data_monitoring.software_interface.vo.DeviceparameterVO;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.VO.SearchVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.service.impl
 * @Author: looli
 * @CreateTime: 2019-07-30 17:26
 * @Description: todo
 */
@Service
public class DeviceparameterServiceImpl implements DeviceparameterService {



    @Autowired
    private DeviceparameterDAO dao;
    @Autowired
    private EqMacTabDAO eqMacTabDAO;

    @Autowired
    private EqDutyTabDAO eqDutyTabDAO;
    @Autowired
    private EqOvertimeTabDAO overtimeTabDAO;
    @Autowired
    private ApprovedWorkingHoursDAO approvedWorkingHoursDAO;

    @Override
    public PageInfo showEqNetWork(Integer pageNum, Integer pageSize, SearchVO searchVO) {
        PageHelper.startPage(pageNum,pageSize);
        List<DeviceparameterVO> vos = dao.selectAll(searchVO);
        HashSet h = new HashSet(vos);
        vos.clear();
        vos.addAll(h);
        vos.forEach(item->{
            if(StringUtils.isBlank(item.getEqGg())){
                item.setEqGg("");
            }
            if(StringUtils.isBlank(item.getEqXh())){
                item.setEqXh("");
            }
            item.setEqGgXh(item.getEqGg()+" "+item.getEqXh());
        });
        return new PageInfo(vos);
    }


    @Override
    public DeviceparameterVO showOne(EqMacVO eqMacVO) {
        return dao.selectOne(eqMacVO);
    }

    @Override
    public void deleteByMacId(SearchVO searchVO) {
        /**
         * 如果macid和设备编号都不为空，则进行删除和修改，否则直接跳过
         */
        if (searchVO.getMacid()!=null||!"".equals(searchVO.getMacid())){
            dao.delete(searchVO.getMacid());
            //删除设备值班信息
            eqDutyTabDAO.delete(searchVO.getMacid());
            //删除设备核定工时信息
            approvedWorkingHoursDAO.delete(searchVO.getMacid());
            //删除设备加班信息
            overtimeTabDAO.delete(searchVO.getMacid());
        }
        if (searchVO.getEqSbbh()!=null||!"".equals(searchVO.getEqSbbh())){
            dao.update(searchVO.getEqSbbh());
        }
    }

    @Override
    public void deletes(String[] macIds){
        dao.updates(macIds);
        eqDutyTabDAO.deletes(macIds);
        overtimeTabDAO.deletes2(macIds);
        approvedWorkingHoursDAO.deletes(macIds);
        dao.deletes(macIds);
    }

    /**
     * 新建关联信息
     * @param deviceparameterVO
     */
    @Override
    public void save(DeviceparameterVO deviceparameterVO) {
        //1.参数设置表设置设备编号（和修改一样）
        dao.updateDeviceCode(deviceparameterVO);
        //2.设备联网表插入数据 生成id,macid 保存设备id，科室id,联网仪ip,有无pacs,有无工作量记录，记录规则，pacs设备编号
        EqMacTab eqMacTab = copyEqMacTab(deviceparameterVO);
        eqMacTab.setId(IDFormat.getIdByIDAndTime("eq_mac_tab","id"));
        eqMacTab.setMacid(deviceparameterVO.getMacID());
        eqMacTabDAO.save(eqMacTab);
    }

    /**
     * 修改关联信息
     * @param deviceparameterVO
     */
    @Override
    public void update(DeviceparameterVO deviceparameterVO) {
        //1.参数设置表修改设备编号
        dao.updateDeviceCode(deviceparameterVO);
        //2.设备参数表修改数据 id,macid不变 其他按需修改
        EqMacTab eqMacTab = copyEqMacTab(deviceparameterVO);
        eqMacTabDAO.update(eqMacTab);
    }

    @Override
    public PageInfo showNoDutyEq(Integer pageNum, Integer pageSize, SearchVO searchVO) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo(dao.selectNoDutyEq(searchVO));
    }

    @Override
    public int updateOneLwxByLwyBh(Deviceparameter deviceparameter) {
        Deviceparameter oldlwy = dao.showOneLwxByLwyBh(deviceparameter.getMachineNumber());
        BeanUtil.copyProperties(deviceparameter, oldlwy, true,
                CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));
        int i = dao.updateOneLwxByLwyBh(oldlwy);
        return i;
    }

    /**
     * 将一个对象中的值赋值到另一个对象
     * @param deviceparameterVO
     * @return
     */
    public EqMacTab copyEqMacTab(DeviceparameterVO deviceparameterVO){
        EqMacTab eqMacTab = new EqMacTab();
        eqMacTab.setMacid(deviceparameterVO.getMacID());
        eqMacTab.setEquid(deviceparameterVO.getEqId());
        eqMacTab.setMacip(deviceparameterVO.getEndPointIp());
        eqMacTab.setPmacid(deviceparameterVO.getPmacid());
        eqMacTab.setMacrule(deviceparameterVO.getMacrule());
        eqMacTab.setHasworkbox(deviceparameterVO.getHasworkbox());
        eqMacTab.setHaspacs(deviceparameterVO.getHaspacs());
        eqMacTab.setDeptid(deviceparameterVO.getEqBmid());
        return eqMacTab;
    }
}

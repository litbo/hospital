package com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.common.utils.DbUtil.IDFormat;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.VO.EqDutyVO;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.VO.EqOvertimeVO;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.VO.SearchVO;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.bean.ApprovedWorkingHours;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.bean.EqDutyTab;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.bean.EqOvertimeTab;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.dao.ApprovedWorkingHoursDAO;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.dao.EqDutyTabDAO;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.dao.EqOvertimeTabDAO;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.service.EqDutyTabService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.service.impl
 * @Author: looli
 * @CreateTime: 2019-07-22 14:12
 * @Description: todo
 */
@Service
@Transactional
public class EqDutyTabServiceImpl implements EqDutyTabService {

    @Autowired
    private EqDutyTabDAO eqDutyTabDAO;
    @Autowired
    private EqOvertimeTabDAO overtimeTabDAO;
    @Autowired
    private ApprovedWorkingHoursDAO approvedWorkingHoursDAO;

    @Override
    public void save(EqDutyTab eqDutyTab) {
        eqDutyTabDAO.save(eqDutyTab);
    }

    /**
     * 根据id删除
     * @param id
     */
    @Override
    public void delete(String id) {
        eqDutyTabDAO.delete(id);
    }

    /**
     * 批量删除
     * @param ids
     */
    @Override
    public void deletes(List<String> ids) {
        eqDutyTabDAO.deleteByIds(ids);
    }

    /**
     * 查询所有设备值班情况
     * @return
     */
    @Override
    public PageInfo selectAll(Integer pageNum, Integer pageSize ,SearchVO searchVO) {
        PageHelper.startPage(pageNum,pageSize);
//        return new PageInfo(eqDutyTabDAO.selectAll());
        return new PageInfo(eqDutyTabDAO.selectAllBy(searchVO));
    }

    @Override
    public EqDutyVO showOne(String id) {
        return eqDutyTabDAO.selectById(id);
    }

    /**
     * 根据条件显示设备值班情况
     * @param pageNum
     * @param pageSize
     * @param searchVO
     * @return
     */
    @Override
    public PageInfo showEqDutyBy(Integer pageNum, Integer pageSize, SearchVO searchVO) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo(eqDutyTabDAO.selectAllBy(searchVO));
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Override
    public EqDutyVO getById(String id) {
        return eqDutyTabDAO.selectById(id);
    }

    @Override
    public void update(EqDutyTab eqDutyTab) {
        eqDutyTabDAO.update(eqDutyTab);
    }

    /**
     * 新建设备值班信息
     * @param eqDutyVO
     */
    @Override
    public void saveEqDuty(EqDutyVO eqDutyVO) {
        /**
         * 三个表的保存对象
         */
        EqDutyTab eqDutyTab = new EqDutyTab();
        BeanUtils.copyProperties(eqDutyVO,eqDutyTab);
        eqDutyTab.setEqMacId(eqDutyVO.getEqMacId());
        eqDutyTab.setId(IDFormat.getIdByIDAndTime("eq_duty_tab","id"));
        EqOvertimeTab eqOvertimeTab = new EqOvertimeTab();
        BeanUtils.copyProperties(eqDutyVO,eqOvertimeTab);
        eqOvertimeTab.setEqMacId(eqDutyVO.getEqMacId());
        eqOvertimeTab.setId(IDFormat.getIdByIDAndTime("eq_overtime_tab","id"));
        ApprovedWorkingHours approvedWorkingHours = new ApprovedWorkingHours();
        BeanUtils.copyProperties(eqDutyVO,approvedWorkingHours);
        approvedWorkingHours.setEqMacId(eqDutyVO.getEqMacId());
        approvedWorkingHours.setId(IDFormat.getIdByIDAndTime("approved_working_hours","id"));
        //更新设备值班信息
        eqDutyTabDAO.save(eqDutyTab);
        //更新设备加班信息
        overtimeTabDAO.save(eqOvertimeTab);
        //更新设备核定工时信息
        approvedWorkingHoursDAO.save(approvedWorkingHours);
    }

    /**
     * 更新
     * @param eqDutyVO
     */
    @Override
    public void updateEqDuty(EqDutyVO eqDutyVO) {
        /**
         * 三个表的保存对象
         */
        EqDutyTab eqDutyTab = new EqDutyTab();
        BeanUtils.copyProperties(eqDutyVO,eqDutyTab);
        EqOvertimeVO eqOvertimeVO = new EqOvertimeVO();
        BeanUtils.copyProperties(eqDutyVO,eqOvertimeVO);
        ApprovedWorkingHours approvedWorkingHours = new ApprovedWorkingHours();
        BeanUtils.copyProperties(approvedWorkingHours,eqDutyTab);
        //更新设备值班信息
        eqDutyTabDAO.update2(eqDutyTab);
        //更新设备加班信息
        overtimeTabDAO.update2(eqOvertimeVO);
        //更新设备核定工时信息
        approvedWorkingHoursDAO.update2(approvedWorkingHours);
    }

    @Override
    public void deleteByEqMacId(String eqMacId) {
        eqDutyTabDAO.delete2(eqMacId);
        overtimeTabDAO.delete(eqMacId);
        approvedWorkingHoursDAO.delete(eqMacId);
    }

    @Override
    public void deleteByEqMacIds(String[] eqMacIds) {
        eqDutyTabDAO.deletes(eqMacIds);
        overtimeTabDAO.deletes2(eqMacIds);
        approvedWorkingHoursDAO.deletes(eqMacIds);
    }

}

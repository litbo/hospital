package com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.VO.SearchVO;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.bean.EqMacTab;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.dao.ApprovedWorkingHoursDAO;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.dao.EqDutyTabDAO;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.dao.EqMacTabDAO;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.dao.EqOvertimeTabDAO;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.service.EqMacTabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.service.impl
 * @Author: looli
 * @CreateTime: 2019-07-22 12:54
 * @Description: 设备联网设置业务层操作接口实现
 */
@Service
@Transactional
public class EqMacTabServiceImpl implements EqMacTabService {

    @Autowired
    private EqMacTabDAO eqMacTabDAO;
    @Autowired
    private EqOvertimeTabDAO eqOvertimeTabDAO;
    @Autowired
    private EqDutyTabDAO eqDutyTabDAO;
    @Autowired
    private ApprovedWorkingHoursDAO approvedWorkingHoursDAO;

    /**
     * 新建，保存设备联网信息
     * @param eqMacTab
     */
    @Override
    public void save(EqMacTab eqMacTab) {
        eqMacTabDAO.save(eqMacTab);
//        //加班表
//        //生成
//        EqOvertimeTab eqOvertimeTab = new EqOvertimeTab();
//        eqOvertimeTab.setId("2");
//        eqOvertimeTab.setEqMacId(eqMacTab.getId());
//        eqOvertimeTabDAO.save(eqOvertimeTab);
//        //值班表
//        EqDutyTab eqDutyTab = new EqDutyTab();
//        //生成
//        eqDutyTab.setId("2");
//        eqDutyTab.setEqMacId(eqMacTab.getId());
//        eqDutyTabDAO.save(eqDutyTab);
//        //核定工时表
//        ApprovedWorkingHours approvedWorkingHours = new ApprovedWorkingHours();
//        approvedWorkingHours.setId("2");
//        approvedWorkingHours.setEqMacId(eqMacTab.getId());
//        approvedWorkingHoursDAO.save(approvedWorkingHours);

    }
    /**
     * 根据条件查看所有设备联网设置表数据
     * @param pageNum
     * @param pageSize
     * @param searchVO
     * @return
     */
    @Override
    public PageInfo showEqMacListBy(Integer pageNum, Integer pageSize, SearchVO searchVO) {
//        System.out.println(searchVO);
        /**开启分页*/
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo(eqMacTabDAO.selectAllBy(searchVO));
    }

    /**
     * 显示设备联网信息
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo showEqMacList(Integer pageNum,Integer pageSize) {
        /**开启分页*/
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo(eqMacTabDAO.selectAll());
    }

    /**
     * 根据id删除数据
     * @param id
     */
    @Override
    public void delete(String id) {
        eqMacTabDAO.deleteById(id);
    }
    /**
     * 根据id删除数据
     * @param ids
     */
    @Override
    public void deletes(List<String> ids) {
        eqMacTabDAO.deleteByIds(ids);
    }

    @Override
    public void update(EqMacTab eqMacTab) {
        eqMacTabDAO.update(eqMacTab);
    }


}

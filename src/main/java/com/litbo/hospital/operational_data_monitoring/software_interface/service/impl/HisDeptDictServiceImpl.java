package com.litbo.hospital.operational_data_monitoring.software_interface.service.impl;

import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.VO.BmVO;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.dao.BmDAO;
import com.litbo.hospital.operational_data_monitoring.software_interface.bean.DeparHisSss;
import com.litbo.hospital.operational_data_monitoring.software_interface.bean.HisDeptDict;
import com.litbo.hospital.operational_data_monitoring.software_interface.dao.DeparHisSssDAO;
import com.litbo.hospital.operational_data_monitoring.software_interface.dao.HisDeptDictDAO;
import com.litbo.hospital.operational_data_monitoring.software_interface.service.HisDeptDictService;
import com.litbo.hospital.operational_data_monitoring.software_interface.vo.DepartmentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.operational_data_monitoring.software_interface.service.impl
 * @Author: looli
 * @CreateTime: 2019-07-31 14:37
 * @Description: todo
 */
@Service
public class HisDeptDictServiceImpl implements HisDeptDictService {
    @Autowired
    private HisDeptDictDAO dao;
    @Autowired
    private DeparHisSssDAO deparHisSssDAO;
    @Autowired
    private BmDAO bmDAO;

    /**
     * 删除之前的数据
     */
    @Override
    public void delete() {
        dao.delete();
        deparHisSssDAO.delete();
    }

    /**
     * 自动匹配科室
     */
    @Override
    public void match() {
        List<HisDeptDict> hisDeptDicts = dao.selectAll();
        List<BmVO> bmVOS = bmDAO.selectAll();
        for (HisDeptDict hisDeptDict
                :hisDeptDicts) {
            for (BmVO d :
                    bmVOS) {
                    if (hisDeptDict.getDeptName().equals(d.getBmName())){
                        DeparHisSss deparHisSss = new DeparHisSss();
                        deparHisSss.setDeptid(d.getBmId());
                        deparHisSss.setHisDeptid(hisDeptDict.getDeptNo());
                        deparHisSssDAO.save(deparHisSss);
                    }
                }
            }
    }

}

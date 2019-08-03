package com.litbo.hospital.operational_data_monitoring.software_interface.service.impl;

import com.litbo.hospital.operational_data_monitoring.software_interface.bean.EqYzTab;
import com.litbo.hospital.operational_data_monitoring.software_interface.dao.EqYzTabDAO;
import com.litbo.hospital.operational_data_monitoring.software_interface.service.EqYzTabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.operational_data_monitoring.software_interface.service.impl
 * @Author: looli
 * @CreateTime: 2019-07-27 15:39
 * @Description: todo
 */
@Service
public class EqYzTabServiceImpl implements EqYzTabService {
    @Autowired
    private EqYzTabDAO eqYzTabDAO;
    @Override
    public void save(List<EqYzTab> eqYzTabList) {
        eqYzTabDAO.save(eqYzTabList);
    }

    @Override
    public void delete() {
        eqYzTabDAO.delete();
    }
}

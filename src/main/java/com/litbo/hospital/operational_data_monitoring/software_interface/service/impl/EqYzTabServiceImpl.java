package com.litbo.hospital.operational_data_monitoring.software_interface.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.operational_data_monitoring.software_interface.bean.EqYzTab;
import com.litbo.hospital.operational_data_monitoring.software_interface.dao.EqYzTabDAO;
import com.litbo.hospital.operational_data_monitoring.software_interface.service.EqYzTabService;
import com.litbo.hospital.operational_data_monitoring.software_interface.vo.EqXm;
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

    @Override
    public void delete(List<EqYzTab> eqYzTabList) {
        eqYzTabDAO.delete2(eqYzTabList);
    }

    @Override
    public PageInfo show(Integer pageNum, Integer pageSize, EqXm eqXm) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo(eqYzTabDAO.show(eqXm));
    }

    @Override
    public void update(EqXm eqXm) {
        eqYzTabDAO.update(eqXm);
    }

    /**
     * 根据id删除关联信息
     * @param id
     */
    @Override
    public void deleteOne(String id) {
        eqYzTabDAO.deleteOne(id);
    }

    @Override
    public void deletes(String[] ids) {
        eqYzTabDAO.deletes(ids);
    }


}

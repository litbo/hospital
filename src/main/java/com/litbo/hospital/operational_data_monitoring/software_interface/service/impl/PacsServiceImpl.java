package com.litbo.hospital.operational_data_monitoring.software_interface.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.operational_data_monitoring.software_interface.bean.EqPacs;
import com.litbo.hospital.operational_data_monitoring.software_interface.bean.PacsTab;
import com.litbo.hospital.operational_data_monitoring.software_interface.dao.EqPacsDAO;
import com.litbo.hospital.operational_data_monitoring.software_interface.dao.PacsTabDAO;
import com.litbo.hospital.operational_data_monitoring.software_interface.service.PacsService;
import com.litbo.hospital.operational_data_monitoring.software_interface.vo.EqPacsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.operational_data_monitoring.software_interface.service.impl
 * @Author: looli
 * @CreateTime: 2019-08-01 12:09
 * @Description: todo
 */
@Service
public class PacsServiceImpl implements PacsService {
    @Autowired
    private PacsTabDAO pacsTabDAO;
    @Autowired
    private EqPacsDAO pacsDAO;

    @Override
    public void delete() {
        pacsTabDAO.delete();
        pacsDAO.delete();
    }

    @Override
    public void saves(List<PacsTab> pacsTabList) {
        pacsTabDAO.saves(pacsTabList);
    }

    @Override
    public void save(EqPacs eqPacs) {
        pacsDAO.save(eqPacs);
    }

    @Override
    public PageInfo showEqPacs(Integer pageNum, Integer pageSize,String pacsId) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo(pacsDAO.selectAll(pacsId));
    }

    @Override
    public int isHas(String eqid) {
        int i = pacsDAO.selectOne(eqid);
        return i;
    }

    @Override
    public void deleteOne(String pacsId) {
        pacsDAO.deleteOne(pacsId);
    }

    @Override
    public void deleteOne2(String eqId) {
        pacsDAO.deleteOne2(eqId);
    }
}

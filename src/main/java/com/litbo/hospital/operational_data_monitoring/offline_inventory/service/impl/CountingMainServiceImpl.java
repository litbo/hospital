//package com.litbo.hospital.operational_data_monitoring.offline_inventory.service.impl;
//
//import com.github.pagehelper.PageHelper;
//import com.github.pagehelper.PageInfo;
//import com.litbo.hospital.operational_data_monitoring.offline_inventory.bean.CountingMainTable;
//import com.litbo.hospital.operational_data_monitoring.offline_inventory.dao.CountingMainDAO;
//import com.litbo.hospital.operational_data_monitoring.offline_inventory.service.CountingMainService;
//import com.litbo.hospital.operational_data_monitoring.offline_inventory.vo.SearchVO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
///**
// * @BelongsProject: hospital
// * @BelongsPackage: com.litbo.hospital.operational_data_monitoring.offline_inventory.service.impl
// * @Author: looli
// * @CreateTime: 2019-08-04 14:32
// * @Description: todo
// */
//@Service
//public class CountingMainServiceImpl implements CountingMainService {
//    @Autowired
//    private CountingMainDAO dao;
//    @Override
//    public PageInfo show(Integer pageNum,
//                         Integer pageSize,
//                         SearchVO searchVO) {
//        PageHelper.startPage(pageNum,pageSize);
//        return new PageInfo(dao.select(searchVO));
//    }
//}

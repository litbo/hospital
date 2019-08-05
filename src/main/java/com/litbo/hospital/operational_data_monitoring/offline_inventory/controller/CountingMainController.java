//package com.litbo.hospital.operational_data_monitoring.offline_inventory.controller;
//
//import com.github.pagehelper.PageInfo;
//import com.litbo.hospital.operational_data_monitoring.offline_inventory.bean.CountingMainTable;
//import com.litbo.hospital.operational_data_monitoring.offline_inventory.service.CountingMainService;
//import com.litbo.hospital.operational_data_monitoring.offline_inventory.vo.SearchVO;
//import com.litbo.hospital.result.Result;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
///**
// * @BelongsProject: hospital
// * @BelongsPackage: com.litbo.hospital.operational_data_monitoring.offline_inventory.controller
// * @Author: looli
// * @CreateTime: 2019-08-04 14:27
// * @Description: todo
// */
//@RestController
//@RequestMapping("/countingmain")
//public class CountingMainController {
//
//    @Autowired
//    private CountingMainService service;
//
//    /**
//     *显示盘点任务
//     *查询盘点任务
//     * @param searchVO
//     * @return
//     */
//    @RequestMapping("/show")
//    public Result show(@RequestParam(required = false,defaultValue = "10") Integer pageSize,
//                       @RequestParam(required = false,defaultValue = "1") Integer pageNum,
//                       SearchVO searchVO){
//        System.out.println(searchVO);
//        PageInfo show = service.show(pageNum, pageSize, searchVO);
//        return Result.success(show);
//    }
//
//}

package com.litbo.hospital.operational_data_monitoring.software_interface.controller;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.operational_data_monitoring.software_interface.service.DeparHisSssService;
import com.litbo.hospital.operational_data_monitoring.software_interface.service.SssSflbService;
import com.litbo.hospital.operational_data_monitoring.software_interface.vo.SearchVO;
import com.litbo.hospital.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.operational_data_monitoring.software_interface.controller
 * @Author: looli
 * @CreateTime: 2019-07-28 09:37
 * @Description: 手术表收费明细
 */
@RestController
@RequestMapping("/surgery")
public class SurgerySfmxController {
    @Autowired
    private SssSflbService sssSflbService;
    @Autowired
    private DeparHisSssService sssService;

    /**
     * 获取当前日期前一天的手术室收费明细
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("/showSurgeryDetail")
    public Result showSurgeryDetail(@RequestParam(required = false,defaultValue = "10") Integer pageSize,
                                    @RequestParam(required = false,defaultValue = "1") Integer pageNum,
                                    SearchVO searchVO){
        if (searchVO.getBeginTime() == null ){
            //获取当前时间前一天,并转换为字符串
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DATE, -1);
            String yesterday = new SimpleDateFormat( "yyyy-MM-dd").format(cal.getTime());
            //封装日期
            searchVO.setBeginTime(yesterday);
            PageInfo pageInfo = sssSflbService.showSssSflbByTime(pageNum, pageSize, searchVO);
            return Result.success(pageInfo);
        }else {
            if (searchVO.getPatientType().equals("")){
                searchVO.setPatientType(null);
            }
            if (searchVO.getPatientId().equals("")){
                searchVO.setPatientId(null);
            }
            PageInfo pageInfo = sssSflbService.showSssSflbByTime(pageNum, pageSize, searchVO);
            return Result.success(pageInfo);
        }
    }


//    @RequestMapping("/showPacsDetailBy")
//    public Result showPacsDetailBy(@RequestParam(required = false,defaultValue = "10") Integer pageSize,
//                                   @RequestParam(required = false,defaultValue = "1") Integer pageNum,
//                                   @RequestBody SearchVO searchVO){
//        System.out.println(searchVO);
//        if (!searchVO.getBeginTime().equals("") && searchVO != null){
//            PageInfo pageInfo = sssSflbService.showSssSflbByTime(pageNum, pageSize, searchVO);
//            return Result.success(pageInfo);
//        }else {
//            //获取当前时间前一天,并转换为字符串
//            Calendar cal = Calendar.getInstance();
//            cal.add(Calendar.DATE, -1);
//            String yesterday = new SimpleDateFormat( "yyyy-MM-dd").format(cal.getTime());
//            //封装日期
//            SearchVO searchVO2 = new SearchVO();
//            searchVO.setBeginTime(yesterday);
//            PageInfo pageInfo = sssSflbService.showSssSflbByTime(pageNum, pageSize, searchVO2);
//            return Result.success(pageInfo);
//        }
//
//    }

    /**
     * 获取手术科室信息
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("/showSurgery")
    public Result showSurgery(@RequestParam(required = false,defaultValue = "10") Integer pageSize,
                              @RequestParam(required = false,defaultValue = "1") Integer pageNum,
                              @RequestParam(required = false) String name){
        if (name == null || name.equals("")){
            PageInfo pageInfo = sssService.showDepartment(pageNum, pageSize);
            return Result.success(pageInfo);
        }else {
            PageInfo pageInfo = sssService.showDepartmentByName(pageNum, pageSize,name);
            return Result.success(pageInfo);
        }
    }

//    /**
//     * 根据手术科室名模糊查询手术科室信息
//     * @param pageNum
//     * @param pageSize
//     * @param name
//     * @return
//     */
//    @RequestMapping("/showSurgeryBy")
//    public Result showSurgery(@RequestParam(required = false,defaultValue = "10") Integer pageSize,
//                              @RequestParam(required = false,defaultValue = "1") Integer pageNum,
//                              @RequestParam String name){
//        PageInfo pageInfo = sssService.showDepartmentByName(pageNum, pageSize,name);
//        return Result.success(pageInfo);
//    }


}

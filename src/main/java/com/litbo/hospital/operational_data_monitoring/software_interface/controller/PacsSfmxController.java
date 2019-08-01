package com.litbo.hospital.operational_data_monitoring.software_interface.controller;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.operational_data_monitoring.software_interface.bean.PacsSflb;
import com.litbo.hospital.operational_data_monitoring.software_interface.service.PacsSflbService;
import com.litbo.hospital.operational_data_monitoring.software_interface.vo.SearchVO;
import com.litbo.hospital.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.operational_data_monitoring.software_interface.controller
 * @Author: looli
 * @CreateTime: 2019-07-28 09:45
 * @Description: PACS收费明细
 */
@RestController
@RequestMapping("/pacs")
public class PacsSfmxController {
    @Autowired
    private PacsSflbService sflbService;

    @RequestMapping(value = "/showPacsDetail")
    public Result showPacsDetail(@RequestParam(required = false,defaultValue = "10") Integer pageSize,
                                 @RequestParam(required = false,defaultValue = "1") Integer pageNum,
                                 SearchVO searchVO){

        if (searchVO.getBeginTime() == null ){
            //获取当前时间前一天,并转换为字符串
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DATE, -1);
            String yesterday = new SimpleDateFormat( "yyyy-MM-dd").format(cal.getTime());
            //封装日期
            searchVO.setBeginTime(yesterday);
            PageInfo pageInfo = sflbService.showPacsSflbByTime(pageNum, pageSize, searchVO);
            return Result.success(pageInfo);
        }else {
            if (searchVO.getPatientType().equals("")){
                searchVO.setPatientType(null);
            }
            if (searchVO.getPatientId().equals("")){
                searchVO.setPatientId(null);
            }
            if (searchVO.getPacsId().equals("")){
                searchVO.setPacsId(null);
            }
            PageInfo pageInfo = sflbService.showPacsSflbByTime(pageNum, pageSize, searchVO);
            return Result.success(pageInfo);
        }
    }

//    @PostMapping("/showPacsDetail")
//    public Result showPacsDetailBy(@RequestParam(required = false,defaultValue = "10") Integer pageSize,
//                                   @RequestParam(required = false,defaultValue = "1") Integer pageNum,
//                                   @RequestBody @RequestParam(required = false) SearchVO searchVO){
//        System.out.println(searchVO);
//        if ( searchVO != null){
//            if (searchVO.getBeginTime().equals("")||searchVO.getBeginTime()==null){
//                //获取当前时间前一天,并转换为字符串
//                Calendar cal = Calendar.getInstance();
//                cal.add(Calendar.DATE, -1);
//                String yesterday = new SimpleDateFormat( "yyyy-MM-dd").format(cal.getTime());
//                //封装日期
//                SearchVO searchVO2 = new SearchVO();
//                searchVO2.setBeginTime(yesterday);
//                PageInfo pageInfo = sflbService.showPacsSflbByTime(pageNum, pageSize, searchVO2);
//                return Result.success(pageInfo);
//            }else {
//                PageInfo pageInfo = sflbService.showPacsSflbByTime(pageNum, pageSize, searchVO);
//                return Result.success(pageInfo);
//            }
//        }else {
//            //获取当前时间前一天,并转换为字符串
//            Calendar cal = Calendar.getInstance();
//            cal.add(Calendar.DATE, -1);
//            String yesterday = new SimpleDateFormat( "yyyy-MM-dd").format(cal.getTime());
//            //封装日期
//            SearchVO searchVO2 = new SearchVO();
//            searchVO2.setBeginTime(yesterday);
//            PageInfo pageInfo = sflbService.showPacsSflbByTime(pageNum, pageSize, searchVO2);
//            return Result.success(pageInfo);
//        }
//
//    }

//    @RequestMapping("/showPacsDetail")
//    @ResponseBody
//    public Result showPacsDetailBy(@RequestParam(required = false,defaultValue = "10") Integer pageSize,
//                                   @RequestParam(required = false,defaultValue = "1") Integer pageNum,
//                                   SearchVO searchVO){
//            System.out.println(searchVO);
//            if (searchVO.getBeginTime().equals("")||searchVO.getBeginTime()==null){
//                //获取当前时间前一天,并转换为字符串
//                Calendar cal = Calendar.getInstance();
//                cal.add(Calendar.DATE, -1);
//                String yesterday = new SimpleDateFormat( "yyyy-MM-dd").format(cal.getTime());
//                //封装日期
//                SearchVO searchVO2 = new SearchVO();
//                searchVO2.setBeginTime(yesterday);
//                PageInfo pageInfo = sflbService.showPacsSflbByTime(pageNum, pageSize, searchVO2);
//                return Result.success(pageInfo);
//            }else {
//                PageInfo pageInfo = sflbService.showPacsSflbByTime(pageNum, pageSize, searchVO);
//                return Result.success(pageInfo);
//            }
//    }
}

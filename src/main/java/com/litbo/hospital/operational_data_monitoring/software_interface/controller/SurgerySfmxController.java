package com.litbo.hospital.operational_data_monitoring.software_interface.controller;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.operational_data_monitoring.software_interface.bean.HisDeptDict;
import com.litbo.hospital.operational_data_monitoring.software_interface.dao.HisDeptDictDAO;
import com.litbo.hospital.operational_data_monitoring.software_interface.mapper.HisDeptDictMapper;
import com.litbo.hospital.operational_data_monitoring.software_interface.service.DeparHisSssService;
import com.litbo.hospital.operational_data_monitoring.software_interface.service.HisDeptDictService;
import com.litbo.hospital.operational_data_monitoring.software_interface.service.SssSflbService;
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

    @Autowired
    private HisDeptDictService deptDictService;

    @Autowired
    private HisDeptDictMapper mapper;
    @Autowired
    private HisDeptDictDAO dao;


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
            PageInfo pageInfo = sssService.showAll(pageNum, pageSize);
            return Result.success(pageInfo);
        }else {
            PageInfo pageInfo = sssService.showAllBy(pageNum, pageSize,name);
            return Result.success(pageInfo);
        }
    }

    /**
     * 重新导入数据
     */
    @RequestMapping("/importData")
    public Result importData(){
        //删除之前的数据
        deptDictService.delete();
        /**
         * 查询his系统科室数据并导入系统
         */
        List<HisDeptDict> hisDeptDictList = mapper.selectAll();
        int batchCount =500;
        int batchLastIndex = batchCount - 1;
        for (int index = 0; index < hisDeptDictList.size() - 1;) {
            if (batchLastIndex > hisDeptDictList.size() - 1) {
                batchLastIndex = hisDeptDictList.size() - 1;
                dao.saves(hisDeptDictList.subList(index, batchLastIndex + 1));
                break;// 数据插入完毕,退出循环
            } else {
                dao.saves(hisDeptDictList.subList(index, batchLastIndex + 1));
                index = batchLastIndex + 1;// 设置下一批下标
                batchLastIndex = index + (batchCount - 1);
            }
        }
        deptDictService.match();
        return Result.success();
    }
}

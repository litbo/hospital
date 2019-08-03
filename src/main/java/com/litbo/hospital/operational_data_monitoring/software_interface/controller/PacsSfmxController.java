package com.litbo.hospital.operational_data_monitoring.software_interface.controller;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.operational_data_monitoring.software_interface.bean.EqInfo;
import com.litbo.hospital.operational_data_monitoring.software_interface.bean.PacsTab;
import com.litbo.hospital.operational_data_monitoring.software_interface.mapper.PacsTabMapper;
import com.litbo.hospital.operational_data_monitoring.software_interface.service.PacsService;
import com.litbo.hospital.operational_data_monitoring.software_interface.service.PacsSflbService;
import com.litbo.hospital.operational_data_monitoring.software_interface.vo.EqXmVO;
import com.litbo.hospital.operational_data_monitoring.software_interface.vo.SearchVO;
import com.litbo.hospital.operational_data_monitoring.software_interface.vo.XmVO;
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
    @Autowired
    private PacsService pacsService;
    @Autowired
    private PacsTabMapper mapper;

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

    /**
     * 重新导入pacs设备信息
     * @return
     */
    @RequestMapping("/importData")
    public Result importData(){
        //删除之前的数据
        pacsService.delete();
        List<PacsTab> pacsTabs = mapper.selectAll();
        int batchCount =1000;
        int batchLastIndex = batchCount - 1;
        for (int index = 0; index < pacsTabs.size() - 1;) {
            if (batchLastIndex > pacsTabs.size() - 1) {
                batchLastIndex = pacsTabs.size() - 1;
                pacsService.saves(pacsTabs.subList(index, batchLastIndex + 1));
                break;// 数据插入完毕,退出循环
            } else {
                pacsService.saves(pacsTabs.subList(index, batchLastIndex + 1));
                // 设置下一批下标
                index = batchLastIndex + 1;
                batchLastIndex = index + (batchCount - 1);
            }
        }
        return Result.success();
    }

    /**
     * 查看pacs设备
     * @return
     */
    @RequestMapping("/show")
    public Result showPacs(@RequestParam(required = false,defaultValue = "10") Integer pageSize,
                           @RequestParam(required = false,defaultValue = "1") Integer pageNum,
                           @RequestParam(required = false,defaultValue = "") String pacsId){
        if (pacsId.equals("")){
            PageInfo pageInfo = pacsService.showEqPacs(pageNum, pageSize,null);
            return Result.success(pageInfo);
        }else {
            PageInfo pageInfo = pacsService.showEqPacs(pageNum, pageSize,pacsId);
            return Result.success(pageInfo);
        }
    }

    /**
     * pacs与eq做关联
     */
    @RequestMapping("/save")
    public Result save(@RequestBody EqXmVO eqXmVO){
        for (XmVO xmVO:
            eqXmVO.getXmList()) {
            for (EqInfo eq:
                 eqXmVO.getEqList()) {

            }
        }


        return Result.success();
    }
}

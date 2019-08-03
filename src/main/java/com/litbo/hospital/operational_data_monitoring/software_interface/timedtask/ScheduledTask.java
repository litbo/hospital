package com.litbo.hospital.operational_data_monitoring.software_interface.timedtask;

import com.litbo.hospital.operational_data_monitoring.software_interface.bean.HisSflb;
import com.litbo.hospital.operational_data_monitoring.software_interface.bean.HisUserDict;
import com.litbo.hospital.operational_data_monitoring.software_interface.bean.PacsSflb;
import com.litbo.hospital.operational_data_monitoring.software_interface.bean.SssSflb;
import com.litbo.hospital.operational_data_monitoring.software_interface.dao.HisSflbDAO;
import com.litbo.hospital.operational_data_monitoring.software_interface.dao.HisUserDictDAO;
import com.litbo.hospital.operational_data_monitoring.software_interface.dao.PacsSflbDAO;
import com.litbo.hospital.operational_data_monitoring.software_interface.dao.SssSflbDAO;
import com.litbo.hospital.operational_data_monitoring.software_interface.mapper.HisSflbMapper;
import com.litbo.hospital.operational_data_monitoring.software_interface.mapper.HisUserDictMapper;
import com.litbo.hospital.operational_data_monitoring.software_interface.mapper.PacsSflbMapper;
import com.litbo.hospital.operational_data_monitoring.software_interface.mapper.SssSflbMapper;
import com.litbo.hospital.operational_data_monitoring.software_interface.vo.HISCycle;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.operational_data_monitoring.software_interface.timedtask
 * @Author: looli
 * @CreateTime: 2019-07-29 09:01
 * @Description: todo
 */
@Configuration
@Component
@EnableScheduling
@Transactional
public class ScheduledTask {
    /**
     * his
     */
   @Autowired
   private HisSflbMapper hisMapper;
   @Autowired
   private HisSflbDAO hisDAO;
    /**
     * 导入pacs
     */
    @Autowired
    private PacsSflbMapper pacsSflbMapper;
    @Autowired
    private PacsSflbDAO pacsSflbDAO;
    /**
     * 导入手术室
     */
    @Autowired
    private SssSflbMapper sssSflbMapper;
    @Autowired
    private SssSflbDAO sssSflbDAO;

    /**
     * 导入员工信息
     */
    @Autowired
    private HisUserDictDAO dao;
    @Autowired
    private HisUserDictMapper mapper;


    /**
     * 设置定时任务
     */
    public void sayHello(){
        //导入his
        importHis();
        //导入pacs
        importPacs();
        //导入手术收费明细
        importSurgery();
        //导入员工信息
        importUser();
    }

    /**
     * 导入his
     */
    public void importHis(){
        /**
         * 设置时间
         */
        HISCycle hisCycle = new HISCycle();
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = dateFormat.format(date);
        hisCycle.setEndTime(format);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        //周期查询
//        Config one = configMapper.findOne(1);
//        Integer zq = new Integer(one.getCycle());
        cal.set(Calendar.DATE, cal.get(Calendar.DATE) - 1);
        String yesterday = dateFormat.format(cal.getTime());
        hisCycle.setBeginTime(yesterday);
        List<HisSflb> hisSflbList = hisMapper.selectByTime(hisCycle);
        int batchCount =120;
        int batchLastIndex = batchCount - 1;
        for (int index = 0; index < hisSflbList.size() - 1;) {
            if (batchLastIndex > hisSflbList.size() - 1) {
                batchLastIndex = hisSflbList.size() - 1;
                hisDAO.saves(hisSflbList.subList(index, batchLastIndex + 1));
                break;// 数据插入完毕,退出循环
            } else {
                hisDAO.saves(hisSflbList.subList(index, batchLastIndex + 1));
                // 设置下一批下标
                index = batchLastIndex + 1;
                batchLastIndex = index + (batchCount - 1);
            }
        }
    }

    /**
     * 导入pacs
     */
    public void importPacs(){
        /**
         * 设置时间
         */
        HISCycle hisCycle = new HISCycle();
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = dateFormat.format(date);
        hisCycle.setEndTime(format);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        //周期查询
//        Config one = configMapper.findOne(1);
//        Integer zq = new Integer(one.getCycle());
        cal.set(Calendar.DATE, cal.get(Calendar.DATE) - 1);
        String yesterday = dateFormat.format(cal.getTime());
        hisCycle.setBeginTime(yesterday);
        List<PacsSflb> pacsSflbList = pacsSflbMapper.selectPacsByTime(hisCycle);
        int batchCount =70;
        int batchLastIndex = batchCount - 1;
        for (int index = 0; index < pacsSflbList.size() - 1;) {
            if (batchLastIndex > pacsSflbList.size() - 1) {
                batchLastIndex = pacsSflbList.size() - 1;
                pacsSflbDAO.savePacsSflbs(pacsSflbList.subList(index, batchLastIndex + 1));
                break;// 数据插入完毕,退出循环
            } else {
                pacsSflbDAO.savePacsSflbs(pacsSflbList.subList(index, batchLastIndex + 1));
                // 设置下一批下标
                index = batchLastIndex + 1;
                batchLastIndex = index + (batchCount - 1);
            }
        }
    }


    /**
     * 导入his
     */
    public void importSurgery(){
        /**
         * 设置时间
         */
        HISCycle hisCycle = new HISCycle();
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = dateFormat.format(date);
        hisCycle.setEndTime(format);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        //周期查询
//        Config one = configMapper.findOne(1);
//        Integer zq = new Integer(one.getCycle());
        cal.set(Calendar.DATE, cal.get(Calendar.DATE) - 1);
        String yesterday = dateFormat.format(cal.getTime());
        hisCycle.setBeginTime(yesterday);
        List<SssSflb> sssSflbList = sssSflbMapper.selectByTime(hisCycle);
        int batchCount =90;
        int batchLastIndex = batchCount - 1;
        for (int index = 0; index < sssSflbList.size() - 1;) {
            if (batchLastIndex > sssSflbList.size() - 1) {
                batchLastIndex = sssSflbList.size() - 1;
                sssSflbDAO.saves(sssSflbList.subList(index, batchLastIndex + 1));
                break;// 数据插入完毕,退出循环
            } else {
                sssSflbDAO.saves(sssSflbList.subList(index, batchLastIndex + 1));
                // 设置下一批下标
                index = batchLastIndex + 1;
                batchLastIndex = index + (batchCount - 1);
            }
        }
    }

    /**
     * 导入部门员工信息
     */
    public void importUser(){
        List<HisUserDict> PacsSflb = mapper.selectAll();
        int batchCount =200;
        int batchLastIndex = batchCount - 1;
        for (int index = 0; index < PacsSflb.size() - 1;) {
            if (batchLastIndex > PacsSflb.size() - 1) {
                batchLastIndex = PacsSflb.size() - 1;
                dao.saves(PacsSflb.subList(index, batchLastIndex + 1));
                break;// 数据插入完毕,退出循环
            } else {
                dao.saves(PacsSflb.subList(index, batchLastIndex + 1));
                // 设置下一批下标
                index = batchLastIndex + 1;
                batchLastIndex = index + (batchCount - 1);
            }
        }

    }
}

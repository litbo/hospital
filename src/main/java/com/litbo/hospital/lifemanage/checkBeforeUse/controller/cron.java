package com.litbo.hospital.lifemanage.checkBeforeUse.controller;

import com.litbo.hospital.lifemanage.checkBeforeUse.dao.SpecificationDao;
import com.litbo.hospital.lifemanage.checkBeforeUse.vo.SaveTaskBufferVO;
import com.litbo.hospital.lifemanage.checkBeforeUse.vo.SearchStandardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;


@Component
public class cron {




    /**用前检查dao*/
    @Autowired
    private SpecificationDao specificationDao;

    @Scheduled(cron = "0 00 00 ? * *")
    public void checkBeforeUseTask(){

        System.out.println("start cron" + new Date());
        //查询所有通过审核的规范
        List<SearchStandardVO> searchAllStandards = specificationDao.searchAllStandards(1);
        System.out.println(searchAllStandards);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String today = simpleDateFormat.format(new Date());
        Calendar calendar = new GregorianCalendar();

        //遍历规范
        searchAllStandards.forEach(searchStandardVO -> {
            Integer i;
            Date date = searchStandardVO.getCycleDate();
            String cycleDate = simpleDateFormat.format(date);
            System.out.println(cycleDate);
            System.out.println(today);
            boolean equals = cycleDate.equals(today);
            System.out.println(equals);
            if (equals){
                try {
                    calendar.setTime(simpleDateFormat.parse(cycleDate));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                calendar.add(Calendar.DATE,searchStandardVO.getCycle());
                Date nextCycleDate = calendar.getTime();
                i = specificationDao.updateStandardCycleDate(searchStandardVO.getStandardId(),nextCycleDate);
                List<SaveTaskBufferVO> saveTaskBufferVOS = specificationDao.searchTaskBufferByStandardId(searchStandardVO.getStandardId());
                System.out.println(saveTaskBufferVOS);
                i = specificationDao.saveStandardTask(saveTaskBufferVOS);
            }
        });
    }
}

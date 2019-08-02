package com.litbo.hospital.operational_data_monitoring.software_interface.timedtask;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.operational_data_monitoring.software_interface.timedtask
 * @Author: looli
 * @CreateTime: 2019-07-29 09:07
 * @Description: todo
 */

import com.litbo.hospital.operational_data_monitoring.software_interface.vo.TimeVO;
import com.litbo.hospital.result.Result;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 功能：定时产查询数据库，并更新任务
 */
@Configuration
@EnableScheduling
@RestController
@RequestMapping("/scheduleRefresh")
public class ScheduleRefreshService {

    @Autowired
    private ConfigMapper configMapper;

    @Resource(name = "jobDetail")
    private JobDetail jobDetail;

    @Resource(name = "jobTrigger")
    private CronTrigger cronTrigger;

    @Resource(name = "scheduler")
    private Scheduler scheduler;


    /**
     * looli 需要修改
     * 手动调用执行：
     */
    @RequestMapping("/updateCron")
    public Result scheduleUpdateCronTrigger(TimeVO timeVO) throws SchedulerException {
        //拼接得到新的cron
        String searchCron = "0 ";
        searchCron = searchCron + timeVO.getMinutes()+" ";
        searchCron = searchCron + timeVO.getHours()+" ";
        searchCron = searchCron + "* * ?";
        //System.out.println(searchCron);
        CronTrigger trigger = (CronTrigger) scheduler.getTrigger(cronTrigger.getKey());
        //当前Trigger使用的cron
        String currentCron = trigger.getCronExpression();
//        System.out.println(currentCron);
        //从数据库查询出来的
//        String searchCron = configMapper.findOne(1).getCron();
//        System.out.println(searchCron);
        if (currentCron.equals(searchCron)) {
            // 如果当前使用的cron表达式和从数据库中查询出来的cron表达式一致，则不刷新任务
            return Result.success();
        } else {
            //表达式调度构建器
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(searchCron);
            //按新的cronExpression表达式重新构建trigger
            trigger = (CronTrigger) scheduler.getTrigger(cronTrigger.getKey());
            trigger = trigger.getTriggerBuilder().withIdentity(cronTrigger.getKey()).withSchedule(scheduleBuilder).build();
            // 按新的trigger重新设置job执行
            scheduler.rescheduleJob(cronTrigger.getKey(), trigger);
            currentCron = searchCron;
            Config config = new Config();
            config.setCron(searchCron);
            config.setTime(timeVO.getHours()+":"+timeVO.getMinutes());
            configMapper.save(config);
            return Result.success();
        }
    }

}
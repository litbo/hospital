package com.litbo.hospital.operational_data_monitoring.software_interface.timedtask;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.operational_data_monitoring.software_interface.timedtask
 * @Author: looli
 * @CreateTime: 2019-07-29 09:08
 * @Description: todo
 */
public interface ConfigMapper {
    /**
     * 查询定时任务设置
     * @param id
     * @return
     */
    @Select("select * from config where id = #{id}")
    Config findOne(Integer id);

    /**
     * 保存定时任务设置
     * @param configTask
     */
    @Update("update config set " +
            "cron = #{cron},cycle = #{cycle},time = #{time} where id = #{id})")
    void save(Config configTask);
}

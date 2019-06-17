package com.litbo.hospital.common.task.dao;

import com.litbo.hospital.common.task.bean.Task;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface TaskDao {
    @Insert("insert into task(action_name,work_name,creat_time,status,url,jsr_id,other) values(#{actionName},#{workName},#{creatTime},#{status},#{url},#{jsrId},#{other})")
    int insertTask(Task task);
    @Select("select * from task where jsr_id = #{userId} and status = 0 ORDER BY creat_time DESC")
    List<Task> listTaskByUserId(@Param("userId") String userId);
    @Update("update task set status = 1 where task_id = #{taskId}")
    int updateTaskById(@Param("taskId") Integer taskId);
    @Select("select creat_time from task where task_id = #{taskId}")
    Date selectCreateTimeByTaskId(Integer taskId);
    @Select("select * from task where datediff([second],creat_time,#{creatTime})=0")
    List<Task> selectTaskListByCreatTime(Date creatTime);
    @Select("select * from task where task_id = #{taskId}")
    Task getTaskById(Integer taskId);
}

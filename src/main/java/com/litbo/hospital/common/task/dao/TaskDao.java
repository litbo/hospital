package com.litbo.hospital.common.task.dao;

import com.litbo.hospital.common.task.bean.Task;
import com.litbo.hospital.common.task.enums.EnumProcess;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TaskDao {
    @Insert("insert into task(fbr_name,work_name,creat_time,status,url,jsr_id,other) values(fbrName,workName,creatTime,status,url,jsrId,other)")
    int insertTask(Task task);
    @Select("select * from task where jsr_id = #{userId} and status = 0 ORDER BY creat_time DESC")
    List<Task> listTaskByUserId(@Param("userId") String userId);
    @Update("update task set status = 1 where id = #{id}")
    int updateTaskById(Integer id);
}

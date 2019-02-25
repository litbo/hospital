package com.litbo.hospital.common.task.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.common.task.bean.Task;
public interface TaskService {
    int insertTask(Task task);
    PageInfo listTaskByUserId(String userId, int pageNum, int pageSize);
    int updateTaskById(Integer id);
}

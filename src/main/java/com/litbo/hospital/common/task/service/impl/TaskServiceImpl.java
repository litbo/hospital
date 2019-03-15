package com.litbo.hospital.common.task.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.common.task.bean.Task;
import com.litbo.hospital.common.task.dao.TaskDao;
import com.litbo.hospital.common.task.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskDao taskDao;
    @Override
    public int insertTask(Task task) {
        return taskDao.insertTask(task);
    }

    @Override
    public PageInfo listTaskByUserId(String userId, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Task> res = taskDao.listTaskByUserId(userId);
        for (Task task:res) {
            task.setUrl(task.getUrl()+"?id="+task.getOther()+"&taskId="+task.getTaskId());
        }
        return new PageInfo(res);
    }

    @Override
    public int updateTaskById(Integer id) {
        return taskDao.updateTaskById(id);
    }
}

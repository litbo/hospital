package com.litbo.hospital.common.task.controller;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.common.task.bean.Task;
import com.litbo.hospital.common.task.service.TaskService;
import com.litbo.hospital.result.CodeMsg;
import com.litbo.hospital.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {
    @Autowired
    private TaskService taskService;
    @RequestMapping(value = "insertTask",method = RequestMethod.POST)
    public Result insertTask(Task task){
        taskService.insertTask(task);
        return Result.success();
    }
    @RequestMapping(value = "listTaskByUserId",method = RequestMethod.GET)
    public Result listTaskByUserId(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                                   @RequestParam(value = "pageSize" ,required = false,defaultValue="10")int pageSize){
        String userId = "1615925039";
        //TODO
        PageInfo pageInfo = taskService.listTaskByUserId(userId,pageNum,pageSize);
        return Result.success(pageInfo);
    }
    @RequestMapping(value = "updateTaskById",method = RequestMethod.POST)
    public Result updateTaskById(Integer id){
        int res = taskService.updateTaskById(id);
        try {
            if(res > 0){
                return Result.success();
            }else {
                return Result.error(CodeMsg.SERVER_ERROR);
            }
        }catch (Exception e){
            return Result.error(CodeMsg.SERVER_ERROR);
        }
    }


}

package com.litbo.hospital.lifemanage.controller.MyController;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.lifemanage.bean.MyBean.MbLr;
import com.litbo.hospital.lifemanage.service.MyService.MbLrService;
import com.litbo.hospital.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*模板录入*/
@RestController
@RequestMapping("/lifeManage")
public class MbLrController {
    @Autowired
    private MbLrService service;




    /*/**
     * 方法功能描述:
     * @Param: [mb]
     * @Return: com.litbo.hospital.result.Result
     * @Description:
     * @Author: NCH
     * @Date: 2019/08/23 下午 11:39
     */
    @PostMapping("/insertMbLr")
    public Result ListEqInfo(@RequestBody MbLr mb) {
        int i = service.insertMbLr(mb);
        if(i==1){
            return Result.success();
        }
        else{
            return Result.error("添加模板失败");
        }
    }

    /*/**
     * 方法功能描述:  查询或根据模板名称查询模板
     * @Param: mbmc[String]  模板名称
     * @Return: com.litbo.hospital.result.Result
     * @Description:
     * @Author: NCH
     * @Date: 2019/08/23 下午 11:40
     */

    @PostMapping("/selectAllMb")
    public Result selectAllMb(@RequestParam(required = false,name = "mbmc") String mbmc) {
        PageInfo<MbLr> info = service.selectAllMb(mbmc);
        return Result.success(info);

    }

    /*/**
     * 方法功能描述: 根据模板主键id查询一条模板
     * @Param: id[String] 模板id
     * @Return: com.litbo.hospital.result.Result
     * @Description:
     * @Author: NCH
     * @Date: 2019/08/23 下午 11:43
     */
    @PostMapping("/selectOneMb")
    public Result selectOneMb(String id) {
        MbLr lr = service.selectOneMb(id);
        return Result.success(lr);

    }

    /*/**
     * 方法功能描述: 根据模板主键id修改一条模板
     * @Param: mb[MbLr] 模板
     * @Return: com.litbo.hospital.result.Result
     * @Description:
     * @Author: NCH
     * @Date: 2019/08/23 下午 11:43
     */

    @PostMapping("/updateMb")
    public Result updateMb(@RequestBody MbLr mb) {
        int i = service.updateMb(mb);
        if(i==1){
            return Result.success();
        }
        else{
            return Result.error("修改模板失败");
        }

    }

    /*/**
     * 方法功能描述: 根据模板主键id集合删除一条模板
     * @Param: ids[List] id的集合
     * @Return: com.litbo.hospital.result.Result
     * @Description:
     * @Author: NCH
     * @Date: 2019/08/23 下午 11:43
     */

    @PostMapping("/deleteMbByid")
    public Result deleteMbByid(@RequestBody List<String> ids) {
       boolean yes=true;
       int i=1;
        for (String id : ids) {
             i= service.deleteMbByid(id);
            if(i==0)
            {
                yes=false;
                break;
            }
        }

        if(yes){
            return Result.success();
        }
        else{
            return Result.error("删除模板失败");
        }

    }
}

package com.litbo.hospital.lifemanage.controller.MyController;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.lifemanage.bean.MyBean.CzGcMb;
import com.litbo.hospital.lifemanage.service.MyService.CzGcMbService;
import com.litbo.hospital.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lifeManage")
public class CzGcMbController {
    @Autowired
    private CzGcMbService service;

    /*查询所有或条件查询操作规程模板*/
    @RequestMapping("/selectCzGcMb")
    public Result selectCzGcMb(
            @RequestParam(required = false, name = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(required = false, name = "pageSize", defaultValue = "10") Integer pageSize,
            @RequestParam(required = false, name = "mbmc") String mbmc) {
        PageInfo<CzGcMb> info = service.AllCzGzMb(pageNum, pageSize, mbmc);
        return Result.success(info);
    }

    /*主键查询单条操作规程模板*/
    @PostMapping("/selectOneCzGcMb")
    public Result selectOneCzGcMb(
            @RequestParam(name = "id") String id) {
        CzGcMb czGcMb = service.selectOneMbByPrimaryKey(id);
        return Result.success(czGcMb);
    }


    /*录入操作规程模板*/
    @PostMapping("/insertCzGcMb")
    public Result insertCzGcMb(@RequestBody CzGcMb mb) {
        int i = service.insertMb(mb);
        if (i == 1) {
            return Result.success(i);
        } else {
            return Result.error();
        }
    }


}

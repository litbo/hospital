package com.litbo.hospital.lifemanage.controller.MyController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.lifemanage.bean.MyBean.Gzxx;
import com.litbo.hospital.lifemanage.dao.MyMapper.GzxxMapper;
import com.litbo.hospital.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/lifeManage")
public class GzxxController {
    @Autowired
    private GzxxMapper mapper;

    @RequestMapping("/allgzxx")
    public Result allgzxx(
            @RequestParam(required = false,defaultValue = "10",name = "pageSize")
            Integer pageSize,@RequestParam(required = false,defaultValue = "1",name = "pageNum")
            Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        List<Gzxx> list = mapper.selectAllczxx();
        return Result.success(new PageInfo<>(list));
    }
}

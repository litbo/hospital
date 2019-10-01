package com.litbo.hospital.lifemanage.check.service.Imp;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.lifemanage.check.mapper.CheckMaper;
import com.litbo.hospital.lifemanage.check.pojo.Check;
import com.litbo.hospital.lifemanage.check.service.CheckService;
import com.litbo.hospital.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CheckServiceImp implements CheckService {


    public CheckMaper checkMaper;
    @Override
    public PageInfo<Check> getCheck(String plan_id, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(checkMaper.getCheck(plan_id));
    }

    public Result updateStatus(List<String> ids, String userId, String check){
         return checkMaper.updateStatus(ids,userId,check);
    }



}

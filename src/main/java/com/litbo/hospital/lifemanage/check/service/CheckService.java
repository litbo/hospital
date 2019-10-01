package com.litbo.hospital.lifemanage.check.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.lifemanage.check.pojo.Check;
import com.litbo.hospital.result.Result;


import java.util.List;

public interface CheckService {

    PageInfo<Check> getCheck(String plan_id, Integer pageNum, Integer pageSize);
    public Result updateStatus(List<String> ids, String userId, String check);
}

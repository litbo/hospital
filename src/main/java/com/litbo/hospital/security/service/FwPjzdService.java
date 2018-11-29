package com.litbo.hospital.security.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.security.bean.FwPjzd;

import java.util.List;

public interface FwPjzdService {
    PageInfo listFwPjzd(int pageNum, int pageSize);
    int insertFwPjzd(FwPjzd pjzd);
}

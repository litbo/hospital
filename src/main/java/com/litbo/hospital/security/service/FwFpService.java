package com.litbo.hospital.security.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.security.bean.FwFp;

public interface FwFpService {
    PageInfo listFwFpByWaitExamine();

    Integer insertFwFp(FwFp fp);
}

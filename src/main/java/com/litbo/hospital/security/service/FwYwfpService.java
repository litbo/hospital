package com.litbo.hospital.security.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.security.bean.FwYwfp;

public interface FwYwfpService {
    int insertFwYwFp(FwYwfp fwYwfp);

    PageInfo listFwYwFp(int pageNum, int pageSize, String fpHm, String eqName, String wxDh);
}

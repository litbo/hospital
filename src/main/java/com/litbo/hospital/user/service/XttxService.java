package com.litbo.hospital.user.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.user.bean.SysTxcl;
import com.litbo.hospital.user.bean.SysTxlb;

public interface XttxService {
    Integer addTxlb(SysTxlb sysTxlb);

    Integer addTxcl(SysTxcl sysTxcl);

    PageInfo listTxlb(int pageNum, int pageSize);

    PageInfo listTxcl(int pageNum, int pageSize);
}

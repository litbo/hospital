package com.litbo.hospital.beneficial.service;

import com.github.pagehelper.PageInfo;

public interface BAccountService {

    PageInfo listCbAccount(int pageNum, int pageSize);

    PageInfo listSrAccount(int pageNum, int pageSize);


}

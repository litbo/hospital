package com.litbo.hospital.user.service;

import com.github.pagehelper.PageInfo;

public interface CsService {

    PageInfo listScs(int pageNum, int pageSize);

    PageInfo listWxs(int pageNum, int pageSize);

    PageInfo listGys(int pageNum, int pageSize);

    PageInfo listScsByX(int pageNum, int pageSize, String sbcsName);

    PageInfo listWxsByX(int pageNum, int pageSize, String sbcsName);

    PageInfo listGysByX(int pageNum, int pageSize, String sbcsName);
}

package com.litbo.hospital.security.service;

import com.github.pagehelper.PageInfo;

public interface FwPjkService {
    PageInfo listFwPjk(int pageNum, int pageSize, String pjSzm);

}

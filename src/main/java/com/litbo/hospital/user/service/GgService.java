package com.litbo.hospital.user.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.user.bean.SysGg;

public interface GgService {
    int addGg(SysGg gg);

    PageInfo listShowGgs(int pageNum, int pageSize);

    int checkGg(Integer id);
}

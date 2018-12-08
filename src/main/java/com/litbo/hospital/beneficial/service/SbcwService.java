package com.litbo.hospital.beneficial.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.beneficial.vo.CbMhVo;

public interface SbcwService {
    PageInfo listZjcb(int pageNum, int pageSize);

    PageInfo listZjcbByX(int pageNum, int pageSize, CbMhVo cbMhVo);

    PageInfo listJjcb(int pageNum, int pageSize);

    PageInfo listJjcbByX(int pageNum, int pageSize, CbMhVo cbMhVo);

    PageInfo listSr(int pageNum, int pageSize);

    PageInfo listSrByX(int pageNum, int pageSize, CbMhVo cbMhVo);

    PageInfo listXyFx(int pageNum, int pageSize);

    PageInfo listXyFxByX(int pageNum, int pageSize, CbMhVo cbMhVo);
}

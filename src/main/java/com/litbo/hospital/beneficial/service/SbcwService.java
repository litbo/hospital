package com.litbo.hospital.beneficial.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.beneficial.vo.CbMhVo;

import java.util.List;

public interface SbcwService {
    PageInfo listZjcb(int pageNum, int pageSize);

    PageInfo listZjcbByX(int pageNum, int pageSize, CbMhVo cbMhVo);

    PageInfo listJjcb(int pageNum, int pageSize);

    PageInfo listJjcbByX(int pageNum, int pageSize, CbMhVo cbMhVo);

    PageInfo listSr(int pageNum, int pageSize);

    PageInfo listSrByX(int pageNum, int pageSize, CbMhVo cbMhVo);

    PageInfo listXyFx(int pageNum, int pageSize);

    PageInfo listXyFxByX(int pageNum, int pageSize, CbMhVo cbMhVo);

    PageInfo listXyPj(int pageNum, int pageSize);

    PageInfo listXyPjByX(int pageNum, int pageSize, CbMhVo cbMhVo);

    List listZjcbByXExport(CbMhVo cbMhVo);

    List listJjcbByXExport(CbMhVo cbMhVo);

    List listSrByXExport(CbMhVo cbMhVo);

    List listXyFxByXExport(CbMhVo cbMhVo);

    List listXyPjByXExport(CbMhVo cbMhVo);
}

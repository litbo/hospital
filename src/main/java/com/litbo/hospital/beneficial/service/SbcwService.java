package com.litbo.hospital.beneficial.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.beneficial.vo.CbMhVo;
import com.litbo.hospital.beneficial.vo.SrVo;
import com.litbo.hospital.beneficial.vo.XyFxVo;

import java.util.Date;
import java.util.List;

public interface SbcwService {
    PageInfo listZjcb(int pageNum, int pageSize, Date kssj, Date jssj);

    PageInfo listZjcbByX(int pageNum, int pageSize, CbMhVo cbMhVo);

    PageInfo listJjcb(int pageNum, int pageSize,Date qs,Date js);

    PageInfo listJjcbByX(int pageNum, int pageSize, CbMhVo cbMhVo);

    PageInfo listSr(int pageNum, int pageSize,Date qs,Date js);
    List<SrVo> SrBobiao(Date qs,Date js);
    PageInfo listSrByX(int pageNum, int pageSize, CbMhVo cbMhVo);

    PageInfo listXyFx(int pageNum, int pageSize,Date qs,Date js);
    List<XyFxVo> XyfxBaobiao(Date qs,Date js);
    PageInfo listXyFxByX(int pageNum, int pageSize, CbMhVo cbMhVo);

    PageInfo listXyPj(int pageNum, int pageSize,Date qs,Date js);

    PageInfo listXyPjByX(int pageNum, int pageSize, CbMhVo cbMhVo);

    List listZjcbByXExport(CbMhVo cbMhVo);

    List listJjcbByXExport(CbMhVo cbMhVo);

    List listSrByXExport(CbMhVo cbMhVo);

    List listXyFxByXExport(CbMhVo cbMhVo);

    List listXyPjByXExport(CbMhVo cbMhVo);
}

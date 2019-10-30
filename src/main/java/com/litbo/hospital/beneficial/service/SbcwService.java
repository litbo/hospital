package com.litbo.hospital.beneficial.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.beneficial.vo.CbMhVo;
import com.litbo.hospital.beneficial.vo.SrVo;
import com.litbo.hospital.beneficial.vo.XyFxVo;
import com.litbo.hospital.beneficial.vo.XyPjVo;

import java.util.Date;
import java.util.List;

public interface SbcwService {
    PageInfo listZjcb(int pageNum, int pageSize, Date kssj, Date jssj,String bmName,String eqName);

    PageInfo listZjcbByX(int pageNum, int pageSize, CbMhVo cbMhVo);

    PageInfo listJjcb(int pageNum, int pageSize,Date qs,Date js,String bmName,String eqName);

    PageInfo listJjcbByX(int pageNum, int pageSize, CbMhVo cbMhVo);

    PageInfo listSr(int pageNum, int pageSize,Date qs,Date js,String bmName,String eqName);
    List<SrVo> SrBobiao(Date qs,Date js,String bmName,String eqName);
    PageInfo listSrByX(int pageNum, int pageSize, CbMhVo cbMhVo);

    PageInfo listXyFx(int pageNum, int pageSize,Date qs,Date js,String bmName,String eqName);
    List<XyPjVo> NewXyfxBaobiao(Date qs, Date js, String bmName, String eqSName);
    PageInfo listXyFxByX(int pageNum, int pageSize, CbMhVo cbMhVo);

    PageInfo listXyPj(int pageNum, int pageSize,Date qs,Date js,String bmName,String eqName);

    PageInfo listXyPjByX(int pageNum, int pageSize, CbMhVo cbMhVo);

    List listZjcbByXExport(CbMhVo cbMhVo);

    List listJjcbByXExport(CbMhVo cbMhVo);

    List listSrByXExport(CbMhVo cbMhVo);

    List listXyFxByXExport(CbMhVo cbMhVo);

    List listXyPjByXExport(CbMhVo cbMhVo);
}

package com.litbo.hospital.beneficial.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.beneficial.vo.CbMhVo;

import java.util.List;

public interface CbxySzService {
    PageInfo listCbxySz(int pageNum, int pageSize);

    PageInfo listCbxySzByX(int pageNum, int pageSize, CbMhVo cbMhVo);

    List listCbxySzByXExport(CbMhVo cbMhVo);

    PageInfo selectCbkmByEqId(int pageNum, int pageSize, Integer eqId);

    List selectCbkmByEqIdExport(Integer eqId);

    PageInfo listSrSz(int pageNum, int pageSize);

    PageInfo listSrSzByX(int pageNum, int pageSize, CbMhVo cbMhVo);

    List listSrSzByXExport(CbMhVo cbMhVo);

    PageInfo selectSrkmByEqId(int pageNum, int pageSize, Integer eqId);

    List selectSrkmByEqIdExport(Integer eqId);
}

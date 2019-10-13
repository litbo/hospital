package com.litbo.hospital.security.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.security.vo.BmVo;
import com.litbo.hospital.security.vo.RyPxJhVo;

import java.util.List;

public interface PxService {
    PageInfo getYypxNr(int pageNum,int pageSize);

    List<BmVo> getYypxKsNr(int pageNum, int pageSize);

    Integer addYypxjh(RyPxJhVo ryPxJhVo);
}

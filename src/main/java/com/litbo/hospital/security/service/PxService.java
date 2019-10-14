package com.litbo.hospital.security.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.security.vo.BmVo;
import com.litbo.hospital.security.vo.RyPxJhVo;
import com.litbo.hospital.security.vo.YyPxJhVo;

import java.util.List;

public interface PxService {
    PageInfo getYypxNr(int pageNum,int pageSize);

    List<BmVo> getYypxKsNr(int pageNum, int pageSize);

    Integer addRypxjh(RyPxJhVo ryPxJhVo);

    Integer addYypxjh(YyPxJhVo yyPxJhVo);

    PageInfo findAllYyJh(int pageNum,int pageSize);


}

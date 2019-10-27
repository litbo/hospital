package com.litbo.hospital.security.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.security.vo.KsFzVo;
import com.litbo.hospital.security.vo.RyPxJhVo;
import com.litbo.hospital.security.vo.YyPxJhVo;

import java.util.List;

public interface KhService {

    PageInfo kh(int pageNum,int pageSize,String id);

    void khBc();

}

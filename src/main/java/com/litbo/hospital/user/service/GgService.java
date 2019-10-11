package com.litbo.hospital.user.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.user.bean.SysGg;
import com.litbo.hospital.user.vo.SysGgVo;

import java.util.List;

public interface GgService {
    int addGg(SysGg gg);

    PageInfo listShowGgs(int pageNum, int pageSize);

    Integer checkGg(Integer id);

    PageInfo getGgByBname(int pageNum, int pageSize,String bName);

    PageInfo listWaits(int pageNum, int pageSize);

    Integer addGglb(String gglxName);

    PageInfo listGgDesc(int pageNum, int pageSize);

    Integer delGg(Integer[] ids);

}

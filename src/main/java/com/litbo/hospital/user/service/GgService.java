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

    Integer delSjzd(Integer[] ids);

    PageInfo listChGg(int pageNum, int pageSize,String name);

    PageInfo listWaits(int pageNum, int pageSize);

    Integer addGglb(String gglxName);

    PageInfo listGgDesc(int pageNum, int pageSize);

    PageInfo listShowGglxs(int pageNum, int pageSize);

    Integer delGg(Integer[] ids);

}

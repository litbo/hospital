package com.litbo.hospital.security.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.security.bean.FwPjzd;
import com.litbo.hospital.security.vo.SelectFwPjzdVo;

import java.util.List;

public interface FwPjzdService {

    int insertFwPjzd(FwPjzd pjzd);

    PageInfo listFwPjzd(String pjSzm,int pageNum,int pageSize,String pjfl);

    List listFwPjzdExport(String pjSzm, String pjfl);

    SelectFwPjzdVo selectFwPjzdById(Integer id);

    Integer deleteFwPjzdById(Integer id);

    Integer updateFwPjzd(FwPjzd pjzd);
}

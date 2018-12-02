package com.litbo.hospital.user.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.user.bean.EqInfo;
import com.litbo.hospital.user.vo.EqShowVo;
import com.litbo.hospital.user.vo.EqVo;
import com.litbo.hospital.user.vo.SelectVo;

import java.util.List;

public interface EqService {


    List<EqVo> getAllEq();

    PageInfo listShowEqs(int pageNum, int pageSize);

    int addEq(EqInfo eqInfo);

    PageInfo listEqByX(int pageNum, int pageSize, SelectVo selectVo);
}

package com.litbo.hospital.security.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.security.vo.EmpVo;
import com.litbo.hospital.security.vo.TjRyVo;

import java.util.List;

public interface PxDelAndSelService {

    Integer DelRyjh(int pageNum,int pageSize);

    Integer DelYyjh(int pageNum,int pageSize);

    PageInfo selRyjh(int pageNum,int pageSize,String name);


    List<EmpVo> getRyBtNr(int pageNum,int pageSize);


    PageInfo selYyjh(int pageNum,int pageSize,String eqName);

    Integer insertRy(TjRyVo tjRyVo);

    List<TjRyVo> selectRy(int pageNum,int pageSize);
}

package com.litbo.hospital.security.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.security.vo.EmpVo;
import com.litbo.hospital.security.vo.TjRyVo;

import java.util.List;

public interface PxDelAndSelService {
    PageInfo selXxRy(String id);

    Integer DelRyjh(String [] strs);

    Integer DelYyjh(String [] strs);

    PageInfo selRyjh(int pageNum,int pageSize,String name);

    List<EmpVo> getRyBtNr(int pageNum,int pageSize);

    PageInfo selByName(int pageNum,int pageSize,String rName);

    PageInfo selYyjh(int pageNum,int pageSize,String name);

    Integer insertRy(TjRyVo tjRyVo);

    List<TjRyVo> selectRy(int pageNum,int pageSize);

    PageInfo findAllRy(int pageNum,int pageSize);

}

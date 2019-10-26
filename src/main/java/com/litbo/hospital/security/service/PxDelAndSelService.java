package com.litbo.hospital.security.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.security.vo.EmpVo;
import com.litbo.hospital.security.vo.RyIdVo;
import com.litbo.hospital.security.vo.TjRyVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PxDelAndSelService {

    Integer DelYyjh(String [] strs);

    List<EmpVo> getRyBtNr(int pageNum,int pageSize,String id);

    PageInfo selByName(int pageNum,int pageSize,@Param("rName") String rName,@Param("id") String id);

    PageInfo selYyjh(int pageNum,int pageSize,String name);

    Integer insertRy(@Param("tjRyVo") TjRyVo tjRyVo,@Param("id") String id);

    List<TjRyVo> selectRy(int pageNum,int pageSize);

    PageInfo findAllRy(int pageNum,int pageSize,String id);

    PageInfo kh(int pageNum,int pageSize,String id);

    List<RyIdVo> findUserId();
}

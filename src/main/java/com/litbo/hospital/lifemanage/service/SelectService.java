package com.litbo.hospital.lifemanage.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.lifemanage.bean.*;
import com.litbo.hospital.lifemanage.dao.SelectMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface SelectService {

    PageInfo<SelectVO> selectAll(@Param("pdJhid")String pdJhid,
                                 @Param("bmId") String bmId
            , @Param("pageNum")Integer pageNum
            , @Param("pageSize")Integer pageSize);

    PageInfo<SelectVO>  selectNot(String pdJhid, String bmId, Integer pageNum, Integer pageSize);
    PageInfo<SelectVO>  allList(String pdJhid, String bmId, Integer pageNum, Integer pageSize);
     PageInfo<SelectVO> selectLess(@Param("pdJhid")String pdJhid,
                                   @Param("bmId") String bmId,
                                   @Param("pageNum")Integer pageNum
                                , @Param("pageSize")Integer pageSize);

    PageInfo<SgPdZt>  findInfo(String pdJhid, String eqName, Integer pageNum, Integer pageSize);
    PageInfo<SgPdZt>  findYipan(String pdJhid, String eqName, Integer pageNum, Integer pageSize);
    PageInfo<SgPdZt>  findPanying(String pdJhid, String eqName, Integer pageNum, Integer pageSize);
    PageInfo<SgPdZt> findPankui(String pdJhid, String eqName, Integer pageNum, Integer pageSize);

    PageInfo<ListNum> listNum(String pdJhid ,Integer pageNum, Integer pageSize);

}

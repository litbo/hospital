package com.litbo.hospital.lifemanage.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.lifemanage.bean.PdResult;
import com.litbo.hospital.lifemanage.bean.SelectVO;
import com.litbo.hospital.lifemanage.bean.SgPd;
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
}

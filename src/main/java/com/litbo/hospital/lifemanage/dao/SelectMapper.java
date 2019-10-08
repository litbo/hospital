package com.litbo.hospital.lifemanage.dao;

import com.litbo.hospital.lifemanage.bean.SelectVO;
import com.litbo.hospital.lifemanage.bean.vo.SgCheckVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SelectMapper {

   SelectVO listAllDate(String pdScanId);//扫描的设备id
    String getBmName(String bmId);
//    String getBmId(String planId);

    List<SelectVO> listCheckDate(String bmId);
}


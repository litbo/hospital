package com.litbo.hospital.lifemanage.dao;

import com.litbo.hospital.lifemanage.bean.ListNum;
import com.litbo.hospital.lifemanage.bean.SelectVO;
import com.litbo.hospital.lifemanage.bean.SgPd;
import com.litbo.hospital.lifemanage.bean.SgPdZt;
import com.litbo.hospital.lifemanage.bean.vo.SgCheckVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
public interface SelectMapper {

    List<SelectVO> listAllDate(String pdScanId);//扫描的设备id
    String getBmName(String bmId);
//    String getBmId(String planId);

    String listBmName(String id);
    List<SgPd> selectAllScan(String pdJhid);
    List<SelectVO> listCheckDate(String bmId);

    void insertZt(SgPdZt sgPdZt);

    void updateZt( SgPdZt sgPdZt);
    List<SgPdZt> findInfo(@Param("pdJhid") String pdJhid,@Param("eqName") String eqName);
    List<SgPdZt> findYipan(@Param("pdJhid") String pdJhid,@Param("eqName") String eqName);
    List<SgPdZt> findPanying(@Param("pdJhid") String pdJhid,@Param("eqName") String eqName);
    List<SgPdZt> findPankui(@Param("pdJhid") String pdJhid,@Param("eqName") String eqName);

    ListNum getListNum(String planId);

}


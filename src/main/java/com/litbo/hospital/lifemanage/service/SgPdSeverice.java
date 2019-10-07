package com.litbo.hospital.lifemanage.service;

import com.litbo.hospital.lifemanage.bean.vo.SgPdVO;

import java.util.List;
import java.util.Map;

public interface SgPdSeverice {

    /**
     * 插入盘点扫描到的所有编号
     * @param
     */
    int insertPdId(SgPdVO record,String pdJhid);

    int insertJhCz(SgPdVO record);

    Map<String, List> selectAllData(String jhId);
}

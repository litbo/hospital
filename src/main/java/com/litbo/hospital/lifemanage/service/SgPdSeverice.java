package com.litbo.hospital.lifemanage.service;

import com.litbo.hospital.lifemanage.bean.vo.SgPdVO;

import java.util.List;

public interface SgPdSeverice {

    /**
     * 插入盘点扫描到的所有编号
     * @param
     */
    int insertPdId(SgPdVO record);

    List selectAllData(String jhId);
}

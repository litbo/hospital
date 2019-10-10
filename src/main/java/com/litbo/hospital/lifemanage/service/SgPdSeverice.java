package com.litbo.hospital.lifemanage.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.lifemanage.bean.SelectVO;
import com.litbo.hospital.lifemanage.bean.vo.SgPdVO;

import java.util.List;
import java.util.Map;

public interface SgPdSeverice {

    /**
     * 插入盘点扫描到的所有编号
     * @param
     */
    int insertPdId(SgPdVO record,String pdJhid);

//    int insertJhCz(SgPdVO record);

    void insetStatus(String pdJhid, String bmId);

//    Object selectAllData(String pdJhid);
}

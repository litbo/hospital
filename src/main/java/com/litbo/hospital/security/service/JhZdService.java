package com.litbo.hospital.security.service;

import com.litbo.hospital.result.Result;
import com.litbo.hospital.security.bean.JhRylr;
import com.litbo.hospital.security.bean.JhZd;

/**
 * @author zjc
 * @create 2018-11-29 14:34
 * 计划制定service
 */
public interface JhZdService {

    //添加计划制定
    public Result addJhZd(JhZd jhZd);

    //计划查询
    public Result listJhZd(int pageNum, int pageSize, String createdate, String jhName);

    /**
     * 计划人员录入
     * @param jhRylr 计划人员录入
     * @param userIds 人员
     */
    public void addJhRyLr(JhRylr jhRylr, String[] userIds);
    
}

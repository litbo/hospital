package com.litbo.hospital.security.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.security.bean.JhZd;
import com.litbo.hospital.supervise.vo.JhEmpVo;

/**
 * @author zjc
 * @create 2018-11-29 14:34
 * 计划制定service
 */
public interface JhZdService {

    //人员列表
    public PageInfo<JhEmpVo> jhryList(Integer pageNum, Integer pageSize);

    //添加计划制定
    public Result addJhZd(JhZd jhZd);

    //计划查询
    public Result listJhZd(int pageNum, int pageSize, String createdate, String jhName);

    //计划人员列表录入初始化
    public Result jhrylrListIndex(int pageNum, int pageSize, String createdate, String jhName);

    /**
     * 计划录入初始化
     * @param id
     * @return
     */
    public JhZd jhrylrIndex(Integer id);

}

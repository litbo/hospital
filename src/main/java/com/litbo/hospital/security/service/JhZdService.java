package com.litbo.hospital.security.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.security.bean.JhZd;
import com.litbo.hospital.security.vo.JhKhVo;
import com.litbo.hospital.security.vo.JhRyCjLr;
import com.litbo.hospital.supervise.vo.JhEmpVo;

/**
 * @author zjc
 * @create 2018-11-29 14:34
 * 计划制定service
 */
public interface JhZdService {

    //成绩录入
    public void updateJhCj(JhRyCjLr jhRyCjLr);

    //计划考核
    public JhKhVo jhkhIndex(Integer jhId);

    //人员列表
    public PageInfo<JhEmpVo> jhryList(Integer pageNum, Integer pageSize, String userId, String userXm);

    //添加计划制定
    public Result addJhZd(JhZd jhZd);

    //计划查询
    public PageInfo listJhZd(int pageNum, int pageSize);

    //计划人员列表录入初始化
    public Result jhrylrListIndex(int pageNum, int pageSize, String createdate, String jhName);

    //计划人员列表考核初始化
    public Result jhryKhListIndex(int pageNum, int pageSize, String createdate, String jhName);

    /**
     * 计划录入初始化
     * @param id
     * @return
     */
    public JhZd jhrylrIndex(Integer id);

}

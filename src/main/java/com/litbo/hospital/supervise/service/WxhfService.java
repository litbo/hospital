package com.litbo.hospital.supervise.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.supervise.vo.BmGcsEqSelectXVO;
import com.litbo.hospital.supervise.vo.WxBmGcsEqInsertVO;
import com.litbo.hospital.supervise.vo.WxhfReadyResouceVO;
import com.litbo.hospital.supervise.vo.WxrBmInsertVO;

public interface WxhfService {
    //信息准备
    WxhfReadyResouceVO getWxhfReadyResouceVO();
    //维修人对科室划分
    void wxrBmHf(WxrBmInsertVO wxrBmInsertVO);
    //清除维修人对科室划分
    void wxrBmXcHf(String[] gbids);
    //获取工程师科室划分信息
    PageInfo getGcsBmMSG(int pageNum, int pageSize);
    //获取工程师科室划分信息通过工程师名和科室名称
    PageInfo getGcsBmMSGByGcsNameAndBmName(int pageNum, int pageSize, String userXm, String bmName);

    //获取维修科室工程师划分信息
    PageInfo getWxbmGcsEqMSG();
    //维修科室下的工程师对应的设备的划分
    void wxBmGcsEqHf(WxBmGcsEqInsertVO wxBmGcsEqInsertVO);
    //清除维修科室下工程师对设备划分
    void wxBmGcsEqXcHf(String[] bgids);
    //获取科室工程师设备通过模糊查询
    PageInfo getBmGcsEqByX(int pageNum, int pageSize, BmGcsEqSelectXVO xvo);

    Boolean isxzd(String userId,String bmId);
}

package com.litbo.hospital.supervise.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.supervise.bean.SBm;
import com.litbo.hospital.supervise.vo.BmSelectVO;
import com.litbo.hospital.supervise.vo.SetBmVO;

public interface BmService {
    //返回所有部门
    PageInfo getBmList(int pageNum, int pageSize);
    //保存部门
    void saveBm(SBm bm);
    //根据父节点查部门
    PageInfo getBmListByPid(int pageNum, int pageSize, String pid);
    //根据id查部门
    SBm getBmByOid(String id);
    //模糊查詢
    PageInfo getBmListByX(int pageNum, int pageSize, BmSelectVO selectVo);
    //通过部门id刪除
    void removeBmByOid(String oid);
    //判断部门是否为子节点
    boolean isZJD(String oid);
    //判断部门们是否为子节点
    boolean isAllZJD(String[] bm_ids);
    //设置部门归属
    void setBmsBeto(SetBmVO bmVO);
    void setBmBeto(String obm_id, String new_pbm_id );


    //通过父布门递归删除
//    void removeBmByPid(String pid);
}

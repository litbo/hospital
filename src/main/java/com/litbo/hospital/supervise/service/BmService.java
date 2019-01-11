package com.litbo.hospital.supervise.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.supervise.bean.SBm;
import com.litbo.hospital.supervise.vo.BmSelectVO;
import com.litbo.hospital.supervise.vo.SetBmVO;
import java.util.List;

public interface BmService {
    //返回所有部门
    PageInfo getBmList(int pageNum, int pageSize);
    //返回所有虚部门
    PageInfo getXBmList(int pageNum, int pageSize);
    //返回所有叶子部门
    PageInfo getYZBmList(int pageNum, int pageSize);
    //返回所有虚部门
    List<SBm> getXBmList();
    //返回所有叶子部门
    List<SBm> getYZBmList();
    //返回所有管理部门
    PageInfo getGLBmList(int pageNum, int pageSize);
    //返回所有维修部门
    List<SBm> getWxBmList();
    //保存部门
    void saveBm(SBm bm);
    //根据父节点查部门
    PageInfo getBmListByPid(int pageNum, int pageSize, String pid);
    //根据oid查部门
    SBm getBmByOid(String id);
    //根据id查部门
    SBm getBmByBmId(String bmid);
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
    //设置为维修部门
    void setWxbm(List<String> obmid, int wxFlag);
    //获取所有维修部门
    List<SBm> getWxBms();
    //获取所有非维修部门
    List<SBm> getFwxBms();
    //获取所有非维修部门
    PageInfo getFwxBms(int pageNum, int pageSize);
    //获取所有非维修部门通过部门名
    PageInfo listFWXBmByBmName(int pageNum, int pageSize, String bmName);

    //通过父布门递归删除
//    void removeBmByPid(String pid);
}

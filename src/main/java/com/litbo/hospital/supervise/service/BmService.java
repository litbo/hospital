package com.litbo.hospital.supervise.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.supervise.bean.SBm;
import com.litbo.hospital.supervise.vo.BmSelectVO;

public interface BmService {
    //返回所有部门
    PageInfo getBmList(int pageNum, int pageSize);
    //保存部门
    void saveBm(SBm bm);
    //根据父节点查部门
    PageInfo getBmListByPid(int pageNum, int pageSize, String pid);
    //根据id查部门
    SBm getBmListById(String id);
    //模糊查詢
    PageInfo getBmListByX(int pageNum, int pageSize, BmSelectVO selectVo);
    //刪除
    void removeBm(String bm_id);

}

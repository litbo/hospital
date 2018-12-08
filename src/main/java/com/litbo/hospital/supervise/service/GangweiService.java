package com.litbo.hospital.supervise.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.supervise.bean.SGangwei;

public interface GangweiService {

    //添加岗位
    void saveGw(SGangwei gw);
    //通过岗位id删除岗位
    void deleteGwByGwId(String gw_id);
    //获取所有岗位
    PageInfo getGws(int pageNum, int pageSize);
    //通过岗位id获取岗位信息
    SGangwei getGwsByGwId(int pageNum, int pageSize, String gw_id);
    //修改岗位信息
    void updateGw(SGangwei gw);
}

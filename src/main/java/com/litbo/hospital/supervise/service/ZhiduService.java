package com.litbo.hospital.supervise.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.supervise.bean.SZhidu;

public interface ZhiduService {
    //获取所有制度
    PageInfo getZds(int pageNum, int pageSize);
    //加入制度
    void saveZd(SZhidu zd);
    //删除制度
    void deteleZd(int zd_id);
    //修改制度
    void updateZd(SZhidu zd);
    //制度编写后提交
    void submit(SZhidu zd, String shr_id);
}

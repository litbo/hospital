package com.litbo.hospital.lifemanage.service.MyService;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.lifemanage.bean.MyBean.CzGcMb;

public interface CzGcMbService {
    /*增加*/
    int insertMb(CzGcMb mb);

    /*根据主键查询模板*/
    CzGcMb selectOneMbByPrimaryKey(String id);
    /*全查或条件查询模板列表*/
    PageInfo <CzGcMb> AllCzGzMb(Integer pageNum, Integer pageSize, String mbmc);
}

package com.litbo.hospital.lifemanage.service.MyService;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.lifemanage.bean.MyBean.CzGc;
import com.litbo.hospital.lifemanage.bean.vo.MyVO.CzGcVO;

import java.util.Date;

public interface CzGcService {

    /*查询所有待审核操作规程*/
    PageInfo<CzGc> AllDshCzgc(Integer pageNum, Integer pageSize, String bh, String mc, String ngr, Date qssj, Date jssj);


    /*操作规程录入*/
    int insertCzgc(CzGc gc);

    /*审核后修改*/
    int ShAfterUpdate(CzGc gc);
    /*普通修改*/
    int updateOneCzgc(CzGc gc);

    /*弃用*/
    int updateCzgcZt(String id);

    /*统计查询*/
    PageInfo<CzGc> Tjcx(Integer pageNum, Integer pageSize, String zt, Date qssj, Date jssj, String bh, String mc);

    /*查看单条操作规程详情*/
    CzGcVO selectOneCzgc(String id);
}

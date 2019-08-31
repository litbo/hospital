package com.litbo.hospital.lifemanage.service.MyService;

import com.litbo.hospital.lifemanage.bean.vo.MyVO.EqTjKaoPingZongVO;

public interface EqTjKaoPingService {

    /*根据调剂申请id查询所有装备调出编号,只查询已经送达的调配单*/
    EqTjKaoPingZongVO getAllZongKaoPing(String sqtjid);


}

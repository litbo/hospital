package com.litbo.hospital.supervise.service;

import com.litbo.hospital.supervise.vo.WxhfReadyResouceVO;
import com.litbo.hospital.supervise.vo.WxrBmInsertVO;

public interface WxhfService {
    //信息准备
    WxhfReadyResouceVO getWxhfReadyResouceVO();
    //维修人对部门划分
    void wxrBmHf(WxrBmInsertVO wxrBmInsertVO);
    //清除维修人对部门划分
    void wxrBmXcHf(String[] bms);
}

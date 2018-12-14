package com.litbo.hospital.security.service;

import com.litbo.hospital.security.bean.FwWeixiu;
import com.litbo.hospital.security.bean.FwWxqs;

/**
 * @author zjc
 * @create 2018-12-06 13:03
 */
public interface FwWeixiuService {

    /**
     * 添加维修
     * @param fwWeixiu
     * @param userId
     */
    public void addFwWeixiu(FwWeixiu fwWeixiu,String userId);

    /**
     * 添加维修确认
     * @param fwWxqs
     */
    public void addFwWxqs(FwWxqs fwWxqs,String userId);

    /**
     * 维修审核
     * @param userId
     */
    public void updateFwWxqs(String userId,String fwId);

}

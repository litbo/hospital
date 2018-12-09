package com.litbo.hospital.security.service;

import com.litbo.hospital.security.bean.FwShouli;

/**
 * @author zjc
 * @create 2018-12-06 9:27
 * 受理
 */
public interface FwShouLiService {

    /**
     * 保修单受理
     * @param fwShouli
     */
    public void addShouli(FwShouli fwShouli);
}

package com.litbo.hospital.lifemanage.service;

import java.util.List;

/**
 * 讨论申购设备关联表Service接口
 */
public interface SgTlPmService {
    /**
     * 申购设备关联信息批量添加
     *
     * @param kstlId  科室讨论的ID
     * @param pmId 设备品名ID
     * @return 是否插入数据成功
     */
    boolean insertSgTlPm(String kstlId, List<Integer> pmId);
}

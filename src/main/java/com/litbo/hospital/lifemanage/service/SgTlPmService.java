package com.litbo.hospital.lifemanage.service;

import java.util.Date;
import java.util.List;

/**
 * 讨论申购设备关联表Service接口
 */
public interface SgTlPmService {
    /**
     * 申购设备关联信息批量添加
     *
     * @param kstlId 科室讨论的ID
     * @param pmId   设备品名ID
     * @param kstlSj 科室讨论时间
     * @return 是否插入数据成功
     */
    boolean insertSgTlPm(String kstlId, List<Integer> pmId, Date kstlSj);

    /**
     * 通过科室讨论ID查询讨论的品名ID
     *
     * @param kstlId 科室讨论ID
     * @return 同一个讨论的所有品名ID
     */
    List<Integer> selectSgTlPmPmIdsByTlId(String kstlId);
}

package com.litbo.hospital.lifemanage.service;

import com.litbo.hospital.lifemanage.bean.SgKstl;

import java.util.List;

/**
 * 科室讨论表Service接口
 */
public interface SgKstlService {
    /**
     * 添加科室讨论信息
     *
     * @param sgKstl  科室讨论实体对象
     * @param usersId 参加讨论的人员集合
     * @param pmId    设备品名ID
     * @return 添加是否成功
     */
    boolean insertSgKstl(SgKstl sgKstl, List<String> usersId, List<Integer> pmId);
}

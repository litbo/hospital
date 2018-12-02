package com.litbo.hospital.lifemanage.service;

import java.util.List;

/**
 * 科室讨论会议人员关联表Service接口
 */
public interface SgKstlUserService {
    /**
     * 添加科室讨论人员信息批量添加
     *
     * @param kstlId  科室讨论的ID
     * @param usersId 参加讨论的人员集合
     * @return 添加是否成功
     */
    boolean insertSgKstlUser(String kstlId,List<String> usersId);
}

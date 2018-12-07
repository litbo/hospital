package com.litbo.hospital.lifemanage.bean;

import lombok.Data;

/**
 * 科室讨论会议人员关联表实体类
 */
@Data
public class SgKstlUser {
    /**
     * 科室讨论id
     */
    private String kstlId;
    /**
     * 员工表id
     */
    private String userId;

}
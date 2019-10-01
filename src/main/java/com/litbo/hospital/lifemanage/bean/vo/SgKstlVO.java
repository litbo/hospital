package com.litbo.hospital.lifemanage.bean.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.litbo.hospital.lifemanage.bean.SgKstlUser;
import com.litbo.hospital.user.bean.EqPm;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 科室讨论表实体类
 */
@Data

public class SgKstlVO implements Serializable {
    /**
     * 登陆人id
     */
    private String userId;
    /**
     * 科室讨论主键id
     */
    private String kstlId;
    /**
     * 记录人id关联员工表id
     */
    private String userIdJl;
    /**
     * 科室id关联科室表id
     */
    private String bmId;
    /**
     * 科室讨论时间
     */
    @JsonFormat(pattern = "yyyy-M-d",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-M-d")
    private Date kstlTime;
    /**
     * 地点
     */
    private String kstlAddr;
    /**
     * 意见
     */
    private String kstlYj;
    /**
     * 内容
     */
    private String kstlContent;
    /**
     * 扩展一
     */
    private String extendOne;
    /**
     * 扩展二
     */
    private String extendTwo;
    /**
     * 科室讨论参与人员
     */
    List<SgKstlUser> usersId;
    /**
     * 讨论的品名列表
     */
    List<EqPm> pmsId;
}
package com.litbo.hospital.lifemanage.bean.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.litbo.hospital.supervise.bean.SEmp;
import com.litbo.hospital.user.bean.EqPm;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * SgKstlToVO 返回科室讨论信息VO
 *
 * @author Administrator on 2019-04-03
 */
@Data
public class SgKstlToVO {
    /**
     * 记录人名字 关联员工表id
     */
    private String userNameJl;
    /**
     * 部门名称 关联部门表id
     */
    private String bmName;
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
     * 科室讨论参与人员
     */
    List<SEmp> usersName;
    /**
     * 讨论的品名列表
     */
    List<EqPm> pmsId;
}

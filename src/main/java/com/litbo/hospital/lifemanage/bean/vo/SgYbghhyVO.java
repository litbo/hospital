package com.litbo.hospital.lifemanage.bean.vo;

import lombok.Data;

import java.util.Date;

/**
 * 院办公会会议信息表实体类
 */
@Data
public class SgYbghhyVO {
    /**
     * 申购单id
     */
    private String sgId;
    /**
     * 参会人员
     */
    private String ybghhyChry;
    /**
     * 书记员
     */
    private String ybghhySjy;
    /**
     * 时间
     */
    private Date ybghhySj;
    /**
     * 地点
     */
    private String ybghhyDd;
    /**
     * 内容
     */
    private String ybghhyNr;
    /**
     * 审核信息
     */
    private ShVO shVO;
}
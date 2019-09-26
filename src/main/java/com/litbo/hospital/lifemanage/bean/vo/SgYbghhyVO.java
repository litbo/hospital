package com.litbo.hospital.lifemanage.bean.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
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
     * 审核人
     */
    private String shr;
    /**
     * 是否通过审核
     */
    private String issh;
    /**
     * 审核时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date shsj;
    /**
     * 审核意见
     */
    private String shyj;
    /**
     * 审核状态
     */
    private String zt;
    /**
     * 审核申购单列表
     */
    private List<String> ids;
}
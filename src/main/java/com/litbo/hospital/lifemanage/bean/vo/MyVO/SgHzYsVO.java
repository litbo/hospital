package com.litbo.hospital.lifemanage.bean.vo.MyVO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class SgHzYsVO {

    /*验收主键*/
    private String ysId;
    /**
     * 验收结果
     */
    private String ysYsjg;
    /**
     * 验收确认时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date ysYsqrsj;
    /**
     * 启用时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date ysQysj;
    /**
     * 操作规程
     */
    private String ysCzgc;
    /**
     * 注意事项
     */
    private String ysZysx;
    /**
     * 保养制度
     */
    private String ysByzd;
    /**
     * 产品禁忌
     */
    private String ysCpjj;
    /**
     * 质量控制
     */
    private String ysZlkz;
    /**
     * 是否通过验收
     */
    private String ysIstg;
    /**
     * 是否退换货
     */
    private String ysThh;
    /**
     * 退换货时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date ysThsj;

    /**
     * 退换原因
     */
    private String ysThyy;
}

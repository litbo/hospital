package com.litbo.hospital.lifemanage.checkBeforeUse.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class SaveStandardVO {

    /**规范id*/
    private Integer standardId;
    /**规范名称*/
    private String standardName;
    /**设备编号*/
    private String equipmentNumber;
    /**适用设备*/
    private String applicableEquipment;
    /**制定人编号*/
    private String designerNumber;
    /**审核人编号*/
    private String reviewerNumber;
    /**周期*/
    private Integer cycle;
    /**审核结果*/
    private Integer result;
    /**制定日期*/
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date date;
    /**项目列表*/
    private List<SaveStandardProjectVO> list = new ArrayList<>();
}

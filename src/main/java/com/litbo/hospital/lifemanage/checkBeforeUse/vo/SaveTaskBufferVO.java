package com.litbo.hospital.lifemanage.checkBeforeUse.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class SaveTaskBufferVO {

    /**设备编号*/
    private String equipmentNumber;

    /**规范名称*/
    private String standardName;

    /**开始日期*/
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date startDate;

    /**操作id*/
    private String operationId;

    /**项目id*/
    private String projectId;

    /**规范id*/
    private Integer standardId;


}

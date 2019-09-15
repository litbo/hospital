package com.litbo.hospital.lifemanage.checkBeforeUse.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
public class SearchStandardVO {
    private Integer standardId;

    private String standardName;

    private String equipmentNumber;

    private String equipmentName;

    private String applicableEquipment;

    private String designerNumber;

    private String designerName;

    private String reviewerName;

    private String reviewerNumber;

    private Integer cycle;

    private Integer result;


    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date date;

    private List<SearchStandardProjectVO> list;
}

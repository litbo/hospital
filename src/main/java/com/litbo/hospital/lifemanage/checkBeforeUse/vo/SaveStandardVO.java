package com.litbo.hospital.lifemanage.checkBeforeUse.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class SaveStandardVO {

    private Integer standardId;

    private String standardName;

    private String equipmentNumber;

    private String applicableEquipment;

    private String designerNumber;

    private String reviewerNumber;

    private Integer cycle;

    private Integer result;


    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date date;

    private List<SaveStandardProjectVO> list = new ArrayList<>();
}

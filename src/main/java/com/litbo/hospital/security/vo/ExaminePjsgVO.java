package com.litbo.hospital.security.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;
@Data
public class ExaminePjsgVO {
    private Integer id;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date pjRkTime;

    private String userXm;
    private String sgYy;
    private  String sgSqsx;
    private List<PjsgZjbExamineVO> pjsgZjbs;
}

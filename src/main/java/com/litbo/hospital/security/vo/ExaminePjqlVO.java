package com.litbo.hospital.security.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;
@Data
public class ExaminePjqlVO {
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date qlTime;
    private String qlyy;
    private String userXm;
    List<PjqlZjbExamineVO> pjqlZjbs;
}

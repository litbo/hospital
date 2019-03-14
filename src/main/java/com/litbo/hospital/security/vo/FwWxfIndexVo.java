package com.litbo.hospital.security.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * @author zjc
 * @create 2019-03-11 22:48
 */
@Data
public class FwWxfIndexVo {

    private String fwId;

    private String eqName;

    private String userXm; //申请人姓名

    private String user1Id; //审核人

    private String bmName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:ss:mm")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:ss:mm")
    private Date bxTime;

    private List<PjqlZjbExamineVO> pjList;
}

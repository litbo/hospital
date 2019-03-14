package com.litbo.hospital.security.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * @author zjc
 * @create 2019-03-12 22:02
 */

@Data
public class FwWxfShIndexVo {

    private Integer id;

    private String fwId;

    private String eqName;

    private String userXm;//申请人姓名

    //private String user2Id; //申请人

    private String bmName;

    private String shrName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:ss:mm")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:ss:mm")
    private Date wxfSqtime;

    private Double wxfRgf;

    private Double wxfCjrgf;

    private List<PjqlZjbExamineVO> pjList;
}

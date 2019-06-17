package com.litbo.hospital.security.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * @author zjc
 * @create 2019-06-17 22:25
 */
@Data
public class FwBxLcVo {

    private String fwId;

    private String eqName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date bxTime;

    private List<FwLcjlVo> fwLcjlList;

}

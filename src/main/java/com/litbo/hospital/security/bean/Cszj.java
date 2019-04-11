package com.litbo.hospital.security.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class Cszj {
    private Integer cszjId;
    private Integer sbcsId;
    private String cszjName;
    private String cszjBh;
    private String cszjFzdw;
    private String cszjZjlx;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fzDate;

    private Integer yxqDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date bgDate;
    private String bgNr;
    private String imgUrl;
}

package com.litbo.hospital.lifemanage.bean.vo.MyVO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/*展示所有的调剂申请*/
@Data
public class EqTjShowVO {
    public EqTjShowVO(String bmName,  Date tjQssj, Date tjJssj,String tjSfyl,String tjSfqbsl) {
        this.bmName = bmName;
        this.tjQssj = tjQssj;
        this.tjJssj = tjJssj;
        this.tjSfyl=tjSfyl;
        this.tjSfqbsl=tjSfqbsl;
    }

    public EqTjShowVO() {
    }

    /*主键*/
    private String id;


    /*调剂科室名字*/
    private String bmName;



    /*负责人*/
    private String tjDrjbr;


    /*设备名称*/
    private String tjZbmc;

    /*设备数量*/
    private Integer sbsl;
    /*查询时候的起始时间*/
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date tjQssj;

    /*查询时候的结束时间*/
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date tjJssj;

    /*申请时间*/
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date tjSqsj;

    /*性质(是否演练，仅调剂使用)*/
    private String tjSfyl;

    private String tjSqlx;

    /*是否全部受理*/
    private String tjSfqbsl;
}

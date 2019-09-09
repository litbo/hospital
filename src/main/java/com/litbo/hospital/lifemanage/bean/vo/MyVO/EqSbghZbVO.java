package com.litbo.hospital.lifemanage.bean.vo.MyVO;

import lombok.Data;

@Data
public class EqSbghZbVO {
    private String id;
    private String eqName;
    private String eqGg;
    private String eqXh;
    private String eqSbbh;
    private String tjjjDrks;
    private String dcksName;
    private String tjjjDcks;
    private String drksName;
    /*是否归还，仅调剂交接查看是否归还时候使用*/
    private int sfgh;
}

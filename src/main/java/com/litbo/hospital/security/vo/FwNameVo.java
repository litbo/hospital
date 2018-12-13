package com.litbo.hospital.security.vo;

import lombok.Data;

/**
 * @author zjc
 * @create 2018-12-13 10:31
 */
@Data
public class FwNameVo {

    private String eqName; //报修设备名称

    private String eqId; //设备id

    private String userXm; //用户姓名

    private String userId;  //用户id

    private String obmId; //报修部门id

    private String bmName; //报修部门名字
}

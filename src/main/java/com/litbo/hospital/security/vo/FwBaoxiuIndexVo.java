package com.litbo.hospital.security.vo;

import lombok.Data;

/**
 * @author zjc
 * @create 2018-12-09 14:48
 * 受理主页面
 */
@Data
public class FwBaoxiuIndexVo {

    private String eqName; //报修设备名称

    private String eqId; //设备id

    private String userXm; //报修人姓名

    private String userId;  //用户id

    private String tel; //用户电话

    private String obmId; //报修部门id

    private String bmName; //报修部门名字

    private String bmTel; //报修科室电话

}

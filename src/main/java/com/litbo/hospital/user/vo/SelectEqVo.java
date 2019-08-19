package com.litbo.hospital.user.vo;

import lombok.Data;

/**
 * 用作模糊查询的参数
 *  在set方法中直接加上模糊查询的标识符
 *  @version :
 * * @author : ljl
**/
@Data
public class SelectEqVo {

    private String bmName;

    private String eqPym;
    private String eqSbbh;
    private String eqZcbh;
    private String bmId;



}

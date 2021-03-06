package com.litbo.hospital.lifemanage.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 参考厂商设备表实体类
 */
@Data
@ApiModel(value = "参考厂商设备",description = "参考厂商设备实体")
public class SgCkcssb {

    @ApiModelProperty(value = "参考厂商设备主键",name = "ckcssbId",dataType = "String")
    private String ckcssbId;

    @ApiModelProperty(value = "申购单id",name = "sgId", dataType = "String", required = true)
    private String sgId;

    @ApiModelProperty(value = "设备厂商id",name = "sbcsId", dataType = "Integer", required = true)
    private String sbcsId;

    @ApiModelProperty(value = "设备厂商名字",name = "sbcsName", dataType = "String", required = true)
    private String scsName;

    @ApiModelProperty(value = "型号",name = "ckcssbXh", dataType = "String", required = true)
    private String ckcssbXh;

    @ApiModelProperty(value = "规格",name = "ckcssbGg", dataType = "String", required = true)
    private String ckcssbGg;

    @ApiModelProperty(value = "数量",name = "sbcsId", dataType = "Integer", required = true)
    private Integer ckcssbSl;

    @ApiModelProperty(value = "估价",name = "sbcsId", dataType = "BigDecimal", required = true)
    private BigDecimal ckcssbGj;

    @ApiModelProperty(value = "国别",name = "gb", dataType = "String")
    private String gb;

    @ApiModelProperty(value = "产地",name = "cd", dataType = "String")
    private String cd;

    @ApiModelProperty(value = "扩展列1",name = "extendOne", dataType = "String")
    private String extendOne;

    @ApiModelProperty(value = "扩展列2",name = "extendTwo", dataType = "String")
    private String extendTwo;
}
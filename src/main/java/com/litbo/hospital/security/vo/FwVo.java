package com.litbo.hospital.security.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author zjc
 * @create 2018-12-09 20:21
 * 报修数据
 */
@Data
@ApiModel("返回数据名字及设备信息封装")
public class FwVo {

    @ApiModelProperty(value = "报修设备名称")
    private String eqName; //报修设备名称
    @ApiModelProperty(value = "报修人姓名")
    private String username; //报修人姓名
    @ApiModelProperty(value = "报修部门id")
    private String bmId; //报修部门id
    @ApiModelProperty(value = "报修部门名字")
    private String bmName; //报修部门名字
    @ApiModelProperty(value = "报修设备规格")
    private String eqGg; //报修设备规格
    @ApiModelProperty(value = "报修设备型号")
    private String eqXh; //报修设备型号
    @ApiModelProperty(value = "保修结束时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date eqBxjssj; //保修结束时间

}

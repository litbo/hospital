package com.litbo.hospital.security.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
@Data
@ApiModel(value = "配件请领")
public class FwPjql {
    @ApiModelProperty(hidden = true)
    private Integer id;
    @ApiModelProperty(value = "报修单号", required = true)
    private String fwId;
    @ApiModelProperty(hidden = true)
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date qlTime;
    @ApiModelProperty(hidden = true)
    private String qlrId;
    @ApiModelProperty(value = "确认人id", required = true)
    private String qrrId;
    @ApiModelProperty(value = "签字url", required = false)
    private String qzUrl;
    @ApiModelProperty(hidden = true)
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date qrTime;
    @ApiModelProperty(hidden = true)
    private Integer sqStatus;
    @ApiModelProperty(value = "请领原因", required = false)
    private String qlyy;


}
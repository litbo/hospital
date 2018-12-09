package com.litbo.hospital.security.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
@Data
@ApiModel(description = "配件出库")
public class FwPjck {
    @ApiModelProperty( required = false)
    private Integer id;
    @ApiModelProperty(value = "出库人id", required = false)
    private String userId;
    @ApiModelProperty(value = "请领表id", required = false)
    private Integer qlId;
    private Date pjCkTime;
    @ApiModelProperty(value = "审核原因", required = false)
    private String shyy;


}
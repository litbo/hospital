package com.litbo.hospital.security.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "配件请领中间表")
public class FwPjqlZjb {
    @ApiModelProperty(hidden = true)
    private Integer id;
    @ApiModelProperty(hidden = true)
    private Integer pjqlId;
    @ApiModelProperty(value = "配件字典id", required = true)
    private Integer pjzdId;
    @ApiModelProperty(value = "配件数量", required = true)
    private Integer pjsgCount;

}

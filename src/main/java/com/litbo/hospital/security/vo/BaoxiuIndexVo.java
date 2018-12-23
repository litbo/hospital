package com.litbo.hospital.security.vo;

import com.litbo.hospital.security.bean.FwBaoxiu;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author zjc
 * @create 2018-12-09 14:48
 * 受理主页面
 */
@Data
@ApiModel("报修主页面响应数据")
public class BaoxiuIndexVo {

    @ApiModelProperty(value = "姓名及设备信息显示")
    private FwVo fwVo;

    @ApiModelProperty(value = "报修表回显")
    private FwBaoxiu fwBaoxiu;

}

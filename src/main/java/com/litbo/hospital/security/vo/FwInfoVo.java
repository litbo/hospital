package com.litbo.hospital.security.vo;

import com.litbo.hospital.security.bean.FwBaoxiu;
import com.litbo.hospital.security.bean.FwShouli;
import com.litbo.hospital.security.bean.FwWeixiu;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author zjc
 * @create 2018-12-10 11:22
 */
@Data
@ApiModel("维修确认审核页面响应数据")
public class FwInfoVo {

    @ApiModelProperty(value = "报修信息")
    private FwBaoxiu fwBaoxiu;
    @ApiModelProperty(value = "姓名响应显示")
    private FwVo fwVo;
    @ApiModelProperty(value = "受理信息")
    private FwShouli fwShouli;

    private String slrUserName; //受理人姓名

    private FwWeixiu fwWeixiu;

    private String gcsName; //工程师姓名

    private String ywgcsName; //院外工程师姓名

    private String fzgcsName; //辅助工程师姓名

}

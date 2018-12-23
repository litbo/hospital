package com.litbo.hospital.security.vo;

import com.litbo.hospital.security.bean.FwBaoxiu;
import com.litbo.hospital.security.bean.FwShouli;
import lombok.Data;

/**
 * @author zjc
 * @create 2018-12-09 16:16
 */
@Data
public class ShouliIndexVo {

    private FwBaoxiu fwBaoxiu;

    private FwVo fwVo;

    private FwShouli fwShouli;

    private String slrUserName; //受理人姓名
}

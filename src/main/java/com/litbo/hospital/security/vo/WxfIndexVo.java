package com.litbo.hospital.security.vo;

import com.litbo.hospital.security.bean.FwWxf;
import com.litbo.hospital.supervise.bean.SEmp;
import lombok.Data;

import java.util.List;

/**
 * @author zjc
 * @create 2018-12-11 20:02
 */
@Data
public class WxfIndexVo {

    private FwNameVo fwNameVo;

    private List<PjVo> pjList;

    private List<SEmp> empList; //审核人

    private FwWxf fwWxf; //维修表

}

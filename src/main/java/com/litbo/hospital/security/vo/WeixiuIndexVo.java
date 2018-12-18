package com.litbo.hospital.security.vo;

import com.litbo.hospital.security.bean.FwBaoxiu;
import com.litbo.hospital.security.bean.FwWxnrzd;
import lombok.Data;

import java.util.List;

/**
 * @author zjc
 * @create 2018-12-10 9:59
 */
@Data
public class WeixiuIndexVo {

    private FwBaoxiu fwBaoxiu;

    private FwVo fwVo;

    //一级
    private List<FwWxnrzd> wxnrList1;
    //二级
    private List<FwWxnrzd> wxnrList2;
    //三级
    private List<FwWxnrzd> wxnrList3;

    private String userName; //工程师姓名
}

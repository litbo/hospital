package com.litbo.hospital.supervise.vo;

import com.litbo.hospital.supervise.bean.SGangwei;
import java.util.List;

public class GWReadyResourcesVO {
    // 岗位数据准备
    // 获取所有岗位
    private List<SGangwei> gws ;
    //获取下级审核人
//    private List<>

    public List<SGangwei> getGws() {
        return gws;
    }

    public void setGws(List<SGangwei> gws) {
        this.gws = gws;
    }
}

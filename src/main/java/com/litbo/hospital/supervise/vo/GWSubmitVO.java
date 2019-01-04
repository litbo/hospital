package com.litbo.hospital.supervise.vo;

import com.litbo.hospital.supervise.bean.SGangwei;

public class GWSubmitVO {
    private SGangwei sGangwei;   //制度信息对象
    private String shrId;   //审核人id

    public SGangwei getsGangwei() {
        return sGangwei;
    }

    public void setsGangwei(SGangwei sGangwei) {
        this.sGangwei = sGangwei;
    }

    public String getShrId() {
        return shrId;
    }

    public void setShrId(String shrId) {
        this.shrId = shrId;
    }
}

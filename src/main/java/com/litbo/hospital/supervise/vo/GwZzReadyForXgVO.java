package com.litbo.hospital.supervise.vo;

import com.litbo.hospital.supervise.bean.SGangwei;

public class GwZzReadyForXgVO {
    private String xgyj;   //修改意见
    private SGangwei sGangwei;  //岗位信息

    public String getXgyj() {
        return xgyj;
    }

    public void setXgyj(String xgyj) {
        this.xgyj = xgyj;
    }

    public SGangwei getsGangwei() {
        return sGangwei;
    }

    public void setsGangwei(SGangwei sGangwei) {
        this.sGangwei = sGangwei;
    }
}

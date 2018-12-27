package com.litbo.hospital.supervise.vo;

import java.util.List;

public class GwShDetailMsg {
    private SGangweiSelect sGangwei;    //岗位信息
    private List<SZhiduzhizeZtSelect> zts;    //岗位审核信息
    private SZhiduzhizeZtSelect dqshzt;  //当前审核状态信息
//    private List<>             审核人列表

    public SGangweiSelect getsGangwei() {
        return sGangwei;
    }

    public void setsGangwei(SGangweiSelect sGangwei) {
        this.sGangwei = sGangwei;
    }

    public List<SZhiduzhizeZtSelect> getZts() {
        return zts;
    }

    public void setZts(List<SZhiduzhizeZtSelect> zts) {
        this.zts = zts;
    }

    public SZhiduzhizeZtSelect getDqshzt() {
        return dqshzt;
    }

    public void setDqshzt(SZhiduzhizeZtSelect dqshzt) {
        this.dqshzt = dqshzt;
    }
}

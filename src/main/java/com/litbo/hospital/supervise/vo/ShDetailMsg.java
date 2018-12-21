package com.litbo.hospital.supervise.vo;

import java.util.List;

public class ShDetailMsg {
    private SZhiduSelect sZhidu;    //制度信息
    private List<SZhiduzhizeZtSelect> zts;    //制度审核信息
    private SZhiduzhizeZtSelect dqshzt;  //当前审核状态信息
//    private List<>             审核人列表

    public SZhiduSelect getsZhidu() {
        return sZhidu;
    }

    public void setsZhidu(SZhiduSelect sZhidu) {
        this.sZhidu = sZhidu;
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

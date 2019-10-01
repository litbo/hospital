package com.litbo.hospital.supervise.vo;

import com.litbo.hospital.supervise.bean.SBm;
import com.litbo.hospital.supervise.bean.SEmp;
import com.litbo.hospital.user.bean.EqInfo;

import java.util.List;

public class WxhfReadyResouceVO{
    private List<SBm>  wxbms;   // 维修科室
    private List<SEmp> wxemps;   // 维修人员
    private List<SBm>  kes;     //  目标维修科室
    private List<EqInfo> eqInfos; //目标设备

    public List<SBm> getWxbms() {
        return wxbms;
    }

    public void setWxbms(List<SBm> wxbms) {
        this.wxbms = wxbms;
    }

    public List<SEmp> getWxemps() {
        return wxemps;
    }

    public void setWxemps(List<SEmp> wxemps) {
        this.wxemps = wxemps;
    }

    public List<SBm> getKes() {
        return kes;
    }

    public void setKes(List<SBm> kes) {
        this.kes = kes;
    }

    public List<EqInfo> getEqInfos() {
        return eqInfos;
    }

    public void setEqInfos(List<EqInfo> eqInfos) {
        this.eqInfos = eqInfos;
    }
}

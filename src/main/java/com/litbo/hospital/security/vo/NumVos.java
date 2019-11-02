package com.litbo.hospital.security.vo;

import lombok.Data;

@Data
public class NumVos {
    public NumVos(int ydNum, int sdNum, int wdNum, int hgNum) {
        YdNum = ydNum;
        SdNum = sdNum;
        WdNum = wdNum;
        HgNum = hgNum;
    }

    public NumVos() {

    }

    private int YdNum;

    private int SdNum;

    private int WdNum;

    private int HgNum;
}

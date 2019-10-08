package com.litbo.hospital.lifemanage.bean;

import java.util.List;

public class PdResult {
//            result.put("pdScanList",pdScanList);
//        result.put("allNameList",allNameList);
//        result.put("isName",isName);
//        result.put("notExistName",notExistName);
//        result.put("bmPdZt",bmPdZt);

    String pdScanList;
    String allNameList;
    String isName;
    String notExistName;
    String  bmPdzt;

    @Override
    public String toString() {
        return "PdResult{" +
                "pdScanList='" + pdScanList + '\'' +
                ", allNameList='" + allNameList + '\'' +
                ", isName='" + isName + '\'' +
                ", notExistName='" + notExistName + '\'' +
                ", bmPdzt='" + bmPdzt + '\'' +
                '}';
    }

    public String getPdScanList() {
        return pdScanList;
    }

    public void setPdScanList(String pdScanList) {
        this.pdScanList = pdScanList;
    }

    public String getAllNameList() {
        return allNameList;
    }

    public void setAllNameList(String allNameList) {
        this.allNameList = allNameList;
    }

    public String getIsName() {
        return isName;
    }

    public void setIsName(String isName) {
        this.isName = isName;
    }

    public String getNotExistName() {
        return notExistName;
    }

    public void setNotExistName(String notExistName) {
        this.notExistName = notExistName;
    }

    public String getBmPdzt() {
        return bmPdzt;
    }

    public void setBmPdzt(String bmPdzt) {
        this.bmPdzt = bmPdzt;
    }
}

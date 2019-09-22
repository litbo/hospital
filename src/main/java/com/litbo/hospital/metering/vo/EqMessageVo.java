package com.litbo.hospital.metering.vo;

/**
 * @Author: 樊小铭
 * Date: 2019/9/22 19:00
 * @Version:
 * @Description:
 */
public class EqMessageVo {
    private String manufacturer;  // 生产厂家

    private String buyTime;   // 购买时间

    private String bmName;  // 使用科室

    private String agent;  // 代理商

    private String specification;  //规格型号

    private String modle;

    private String userName;

    public String getModle() {
        return modle;
    }

    public void setModle(String modle) {
        this.modle = modle;
    }

    @Override
    public String toString() {
        return "EqMessageVo{" +
                "manufacturer='" + manufacturer + '\'' +
                ", buyTime='" + buyTime + '\'' +
                ", bmName='" + bmName + '\'' +
                ", agent='" + agent + '\'' +
                ", specification='" + specification + '\'' +
                ", modle='" + modle + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(String buyTime) {
        this.buyTime = buyTime;
    }

    public String getBmName() {
        return bmName;
    }

    public void setBmName(String bmName) {
        this.bmName = bmName;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public EqMessageVo(String manufacturer, String buyTime, String bmName, String agent, String specification, String modle, String userName) {
        this.manufacturer = manufacturer;
        this.buyTime = buyTime;
        this.bmName = bmName;
        this.agent = agent;
        this.specification = specification;
        this.modle = modle;
        this.userName = userName;
    }
}

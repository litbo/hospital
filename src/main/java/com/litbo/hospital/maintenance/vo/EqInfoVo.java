package com.litbo.hospital.maintenance.vo;

/**
 * @Author: 樊小铭
 * Date: 2019/8/28 3:27
 * @Version:
 * @Description:
 */
public class EqInfoVo {
    private String id;
    private String name;
    private String num;
    private String model;
    private String specification;
    private String riskLevel;
    private String riskValue;

    @Override
    public String toString() {
        return "EqInfoVo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", num='" + num + '\'' +
                ", model='" + model + '\'' +
                ", specification='" + specification + '\'' +
                ", riskLevel='" + riskLevel + '\'' +
                ", riskValue='" + riskValue + '\'' +
                ", bmName='" + bmName + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }

    public String getRiskValue() {
        return riskValue;
    }

    public void setRiskValue(String riskValue) {
        this.riskValue = riskValue;
    }

    public String getBmName() {
        return bmName;
    }

    public void setBmName(String bmName) {
        this.bmName = bmName;
    }

    public EqInfoVo() {
    }

    public EqInfoVo(String id, String name, String num, String model, String specification, String riskLevel, String riskValue, String bmName) {
        this.id = id;
        this.name = name;
        this.num = num;
        this.model = model;
        this.specification = specification;
        this.riskLevel = riskLevel;
        this.riskValue = riskValue;
        this.bmName = bmName;
    }

    private String bmName;


}

package com.litbo.hospital.finance.vo;

/**
 * @Author: 樊小铭
 * Date: 2019/10/11 10:33
 * @Version:
 * @Description:
 */
public class ProfitAndLossVo {
    private Integer id;   // id

    private String year; // 折舊年限

    private String projectId;  // 项目id

    private String yearLoss;  // 每年折旧

    private String yearYunying;  // 每年运营费用

    private String totleLoss;   // 成本合计

    private String avgDayLoss;   // 每工作日平均成本

    private String baoLi;   // 保利点

    private String pingHeng;   // 盈亏平衡点

    private String zuoYeLv;   // 盈亏平衡作业率

    private String bianJi;  // 安全边际

    @Override
    public String toString() {
        return "ProfitAndLossVo{" +
                "id=" + id +
                ", year='" + year + '\'' +
                ", projectId='" + projectId + '\'' +
                ", yearLoss='" + yearLoss + '\'' +
                ", yearYunying='" + yearYunying + '\'' +
                ", totleLoss='" + totleLoss + '\'' +
                ", avgDayLoss='" + avgDayLoss + '\'' +
                ", baoLi='" + baoLi + '\'' +
                ", pingHeng='" + pingHeng + '\'' +
                ", zuoYeLv='" + zuoYeLv + '\'' +
                ", bianJi='" + bianJi + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getYearLoss() {
        return yearLoss;
    }

    public void setYearLoss(String yearLoss) {
        this.yearLoss = yearLoss;
    }

    public String getYearYunying() {
        return yearYunying;
    }

    public void setYearYunying(String yearYunying) {
        this.yearYunying = yearYunying;
    }

    public String getTotleLoss() {
        return totleLoss;
    }

    public void setTotleLoss(String totleLoss) {
        this.totleLoss = totleLoss;
    }

    public String getAvgDayLoss() {
        return avgDayLoss;
    }

    public void setAvgDayLoss(String avgDayLoss) {
        this.avgDayLoss = avgDayLoss;
    }

    public String getBaoLi() {
        return baoLi;
    }

    public void setBaoLi(String baoLi) {
        this.baoLi = baoLi;
    }

    public String getPingHeng() {
        return pingHeng;
    }

    public void setPingHeng(String pingHeng) {
        this.pingHeng = pingHeng;
    }

    public String getZuoYeLv() {
        return zuoYeLv;
    }

    public void setZuoYeLv(String zuoYeLv) {
        this.zuoYeLv = zuoYeLv;
    }

    public String getBianJi() {
        return bianJi;
    }

    public void setBianJi(String bianJi) {
        this.bianJi = bianJi;
    }

    public ProfitAndLossVo() {
    }

    public ProfitAndLossVo(Integer id, String year, String projectId, String yearLoss, String yearYunying, String totleLoss, String avgDayLoss, String baoLi, String pingHeng, String zuoYeLv, String bianJi) {
        this.id = id;
        this.year = year;
        this.projectId = projectId;
        this.yearLoss = yearLoss;
        this.yearYunying = yearYunying;
        this.totleLoss = totleLoss;
        this.avgDayLoss = avgDayLoss;
        this.baoLi = baoLi;
        this.pingHeng = pingHeng;
        this.zuoYeLv = zuoYeLv;
        this.bianJi = bianJi;
    }
}

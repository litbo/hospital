package com.litbo.hospital.finance.pojo;

import java.io.Serializable;

/**
 * profit_and_loss
 * @author 
 */
public class ProfitAndLoss implements Serializable {
    private Integer id;   // id

    private String projectId;  // 项目id

    private String yearLoss;  // 每年折旧

    private String yearYunying;  // 每年运营费用

    private String totleLoss;   // 成本合计

    private String avgDayLoss;   // 每工作日平均成本

    private String baoLi;   // 保利点

    private String pingHeng;   // 盈亏平衡点

    private String zuoYeLv;   // 盈亏平衡作业率

    private String bianJi;  // 安全边际

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        ProfitAndLoss other = (ProfitAndLoss) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getProjectId() == null ? other.getProjectId() == null : this.getProjectId().equals(other.getProjectId()))
            && (this.getYearLoss() == null ? other.getYearLoss() == null : this.getYearLoss().equals(other.getYearLoss()))
            && (this.getYearYunying() == null ? other.getYearYunying() == null : this.getYearYunying().equals(other.getYearYunying()))
            && (this.getTotleLoss() == null ? other.getTotleLoss() == null : this.getTotleLoss().equals(other.getTotleLoss()))
            && (this.getAvgDayLoss() == null ? other.getAvgDayLoss() == null : this.getAvgDayLoss().equals(other.getAvgDayLoss()))
            && (this.getBaoLi() == null ? other.getBaoLi() == null : this.getBaoLi().equals(other.getBaoLi()))
            && (this.getPingHeng() == null ? other.getPingHeng() == null : this.getPingHeng().equals(other.getPingHeng()))
            && (this.getZuoYeLv() == null ? other.getZuoYeLv() == null : this.getZuoYeLv().equals(other.getZuoYeLv()))
            && (this.getBianJi() == null ? other.getBianJi() == null : this.getBianJi().equals(other.getBianJi()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getProjectId() == null) ? 0 : getProjectId().hashCode());
        result = prime * result + ((getYearLoss() == null) ? 0 : getYearLoss().hashCode());
        result = prime * result + ((getYearYunying() == null) ? 0 : getYearYunying().hashCode());
        result = prime * result + ((getTotleLoss() == null) ? 0 : getTotleLoss().hashCode());
        result = prime * result + ((getAvgDayLoss() == null) ? 0 : getAvgDayLoss().hashCode());
        result = prime * result + ((getBaoLi() == null) ? 0 : getBaoLi().hashCode());
        result = prime * result + ((getPingHeng() == null) ? 0 : getPingHeng().hashCode());
        result = prime * result + ((getZuoYeLv() == null) ? 0 : getZuoYeLv().hashCode());
        result = prime * result + ((getBianJi() == null) ? 0 : getBianJi().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", projectId=").append(projectId);
        sb.append(", yearLoss=").append(yearLoss);
        sb.append(", yearYunying=").append(yearYunying);
        sb.append(", totleLoss=").append(totleLoss);
        sb.append(", avgDayLoss=").append(avgDayLoss);
        sb.append(", baoLi=").append(baoLi);
        sb.append(", pingHeng=").append(pingHeng);
        sb.append(", zuoYeLv=").append(zuoYeLv);
        sb.append(", bianJi=").append(bianJi);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
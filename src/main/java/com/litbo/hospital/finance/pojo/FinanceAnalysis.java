package com.litbo.hospital.finance.pojo;

import java.io.Serializable;

/**
 * finance_analysis
 * @author 
 */
public class FinanceAnalysis implements Serializable {
    private String id;   // id

    private String financeId; // 项目id

    private Integer year;  // 年度

    private Double investmentAmount;  // 投资金额

    private Double overhaul;  // 大修

    private Double estimatedIncome;  // 预计收入

    private Double operatingExpenses;  // 运营费用

    private Double netCashFlow; // 净现金流量

    private Double countNetCaseFlow;  // 累计净现金流量

    private Double discountFactor;  // 折现因子

    private String presentValue;  // 现值

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFinanceId() {
        return financeId;
    }

    public void setFinanceId(String financeId) {
        this.financeId = financeId;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Double getInvestmentAmount() {
        return investmentAmount;
    }

    public void setInvestmentAmount(Double investmentAmount) {
        this.investmentAmount = investmentAmount;
    }

    public Double getOverhaul() {
        return overhaul;
    }

    public void setOverhaul(Double overhaul) {
        this.overhaul = overhaul;
    }

    public Double getEstimatedIncome() {
        return estimatedIncome;
    }

    public void setEstimatedIncome(Double estimatedIncome) {
        this.estimatedIncome = estimatedIncome;
    }

    public Double getOperatingExpenses() {
        return operatingExpenses;
    }

    public void setOperatingExpenses(Double operatingExpenses) {
        this.operatingExpenses = operatingExpenses;
    }

    public Double getNetCashFlow() {
        return netCashFlow;
    }

    public void setNetCashFlow(Double netCashFlow) {
        this.netCashFlow = netCashFlow;
    }

    public Double getCountNetCaseFlow() {
        return countNetCaseFlow;
    }

    public void setCountNetCaseFlow(Double countNetCaseFlow) {
        this.countNetCaseFlow = countNetCaseFlow;
    }

    public Double getDiscountFactor() {
        return discountFactor;
    }

    public void setDiscountFactor(Double discountFactor) {
        this.discountFactor = discountFactor;
    }

    public String getPresentValue() {
        return presentValue;
    }

    public void setPresentValue(String presentValue) {
        this.presentValue = presentValue;
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
        FinanceAnalysis other = (FinanceAnalysis) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getFinanceId() == null ? other.getFinanceId() == null : this.getFinanceId().equals(other.getFinanceId()))
            && (this.getYear() == null ? other.getYear() == null : this.getYear().equals(other.getYear()))
            && (this.getInvestmentAmount() == null ? other.getInvestmentAmount() == null : this.getInvestmentAmount().equals(other.getInvestmentAmount()))
            && (this.getOverhaul() == null ? other.getOverhaul() == null : this.getOverhaul().equals(other.getOverhaul()))
            && (this.getEstimatedIncome() == null ? other.getEstimatedIncome() == null : this.getEstimatedIncome().equals(other.getEstimatedIncome()))
            && (this.getOperatingExpenses() == null ? other.getOperatingExpenses() == null : this.getOperatingExpenses().equals(other.getOperatingExpenses()))
            && (this.getNetCashFlow() == null ? other.getNetCashFlow() == null : this.getNetCashFlow().equals(other.getNetCashFlow()))
            && (this.getCountNetCaseFlow() == null ? other.getCountNetCaseFlow() == null : this.getCountNetCaseFlow().equals(other.getCountNetCaseFlow()))
            && (this.getDiscountFactor() == null ? other.getDiscountFactor() == null : this.getDiscountFactor().equals(other.getDiscountFactor()))
            && (this.getPresentValue() == null ? other.getPresentValue() == null : this.getPresentValue().equals(other.getPresentValue()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getFinanceId() == null) ? 0 : getFinanceId().hashCode());
        result = prime * result + ((getYear() == null) ? 0 : getYear().hashCode());
        result = prime * result + ((getInvestmentAmount() == null) ? 0 : getInvestmentAmount().hashCode());
        result = prime * result + ((getOverhaul() == null) ? 0 : getOverhaul().hashCode());
        result = prime * result + ((getEstimatedIncome() == null) ? 0 : getEstimatedIncome().hashCode());
        result = prime * result + ((getOperatingExpenses() == null) ? 0 : getOperatingExpenses().hashCode());
        result = prime * result + ((getNetCashFlow() == null) ? 0 : getNetCashFlow().hashCode());
        result = prime * result + ((getCountNetCaseFlow() == null) ? 0 : getCountNetCaseFlow().hashCode());
        result = prime * result + ((getDiscountFactor() == null) ? 0 : getDiscountFactor().hashCode());
        result = prime * result + ((getPresentValue() == null) ? 0 : getPresentValue().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", financeId=").append(financeId);
        sb.append(", year=").append(year);
        sb.append(", investmentAmount=").append(investmentAmount);
        sb.append(", overhaul=").append(overhaul);
        sb.append(", estimatedIncome=").append(estimatedIncome);
        sb.append(", operatingExpenses=").append(operatingExpenses);
        sb.append(", netCashFlow=").append(netCashFlow);
        sb.append(", countNetCaseFlow=").append(countNetCaseFlow);
        sb.append(", discountFactor=").append(discountFactor);
        sb.append(", presentValue=").append(presentValue);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
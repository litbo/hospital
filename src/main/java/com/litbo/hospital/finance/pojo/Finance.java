package com.litbo.hospital.finance.pojo;

import java.io.Serializable;

/**
 * finance
 * @author 
 */
public class Finance implements Serializable {
    private String id;

    private String name;  // 项目名称

    private String amount;  // 投资金额

    private String createTime;   // 创建时间

    private String yearsOfUse;   // 使用年限

    private String annualOperatingExpenses;  // 年运营费用

    private String annualWorkingDay;  // 年工作日

    private String overhaulYear;  // 大修年度

    private String dailyWorkload;   // 日工作量

    private String overhaulCost;  // 大修费用

    private String charges;   // 收费标准

    private String annualDiscountRate;  // 年贴现率

    private String expectedAnnualInterestRate;    // 期望年利润

    private String investmentStatus;    // 投资状态

    private String unit;  // 日工作量单位

    private String amountGet; // 投资回收期

    private String npv;   // 净现值

    private String irr; //内部收益率

    private String amountAdvance;   // 审批意见

    private String checkPerson;  // 审批人

    private static final long serialVersionUID = 1L;

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

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getYearsOfUse() {
        return yearsOfUse;
    }

    public void setYearsOfUse(String yearsOfUse) {
        this.yearsOfUse = yearsOfUse;
    }

    public String getAnnualOperatingExpenses() {
        return annualOperatingExpenses;
    }

    public void setAnnualOperatingExpenses(String annualOperatingExpenses) {
        this.annualOperatingExpenses = annualOperatingExpenses;
    }

    public String getAnnualWorkingDay() {
        return annualWorkingDay;
    }

    public void setAnnualWorkingDay(String annualWorkingDay) {
        this.annualWorkingDay = annualWorkingDay;
    }

    public String getOverhaulYear() {
        return overhaulYear;
    }

    public void setOverhaulYear(String overhaulYear) {
        this.overhaulYear = overhaulYear;
    }

    public String getDailyWorkload() {
        return dailyWorkload;
    }

    public void setDailyWorkload(String dailyWorkload) {
        this.dailyWorkload = dailyWorkload;
    }

    public String getOverhaulCost() {
        return overhaulCost;
    }

    public void setOverhaulCost(String overhaulCost) {
        this.overhaulCost = overhaulCost;
    }

    public String getCharges() {
        return charges;
    }

    public void setCharges(String charges) {
        this.charges = charges;
    }

    public String getAnnualDiscountRate() {
        return annualDiscountRate;
    }

    public void setAnnualDiscountRate(String annualDiscountRate) {
        this.annualDiscountRate = annualDiscountRate;
    }

    public String getExpectedAnnualInterestRate() {
        return expectedAnnualInterestRate;
    }

    public void setExpectedAnnualInterestRate(String expectedAnnualInterestRate) {
        this.expectedAnnualInterestRate = expectedAnnualInterestRate;
    }

    public String getInvestmentStatus() {
        return investmentStatus;
    }

    public void setInvestmentStatus(String investmentStatus) {
        this.investmentStatus = investmentStatus;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getAmountGet() {
        return amountGet;
    }

    public void setAmountGet(String amountGet) {
        this.amountGet = amountGet;
    }

    public String getNpv() {
        return npv;
    }

    public void setNpv(String npv) {
        this.npv = npv;
    }

    public String getIrr() {
        return irr;
    }

    public void setIrr(String irr) {
        this.irr = irr;
    }

    public String getAmountAdvance() {
        return amountAdvance;
    }

    public void setAmountAdvance(String amountAdvance) {
        this.amountAdvance = amountAdvance;
    }

    public String getCheckPerson() {
        return checkPerson;
    }

    public void setCheckPerson(String checkPerson) {
        this.checkPerson = checkPerson;
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
        Finance other = (Finance) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getYearsOfUse() == null ? other.getYearsOfUse() == null : this.getYearsOfUse().equals(other.getYearsOfUse()))
            && (this.getAnnualOperatingExpenses() == null ? other.getAnnualOperatingExpenses() == null : this.getAnnualOperatingExpenses().equals(other.getAnnualOperatingExpenses()))
            && (this.getAnnualWorkingDay() == null ? other.getAnnualWorkingDay() == null : this.getAnnualWorkingDay().equals(other.getAnnualWorkingDay()))
            && (this.getOverhaulYear() == null ? other.getOverhaulYear() == null : this.getOverhaulYear().equals(other.getOverhaulYear()))
            && (this.getDailyWorkload() == null ? other.getDailyWorkload() == null : this.getDailyWorkload().equals(other.getDailyWorkload()))
            && (this.getOverhaulCost() == null ? other.getOverhaulCost() == null : this.getOverhaulCost().equals(other.getOverhaulCost()))
            && (this.getCharges() == null ? other.getCharges() == null : this.getCharges().equals(other.getCharges()))
            && (this.getAnnualDiscountRate() == null ? other.getAnnualDiscountRate() == null : this.getAnnualDiscountRate().equals(other.getAnnualDiscountRate()))
            && (this.getExpectedAnnualInterestRate() == null ? other.getExpectedAnnualInterestRate() == null : this.getExpectedAnnualInterestRate().equals(other.getExpectedAnnualInterestRate()))
            && (this.getInvestmentStatus() == null ? other.getInvestmentStatus() == null : this.getInvestmentStatus().equals(other.getInvestmentStatus()))
            && (this.getUnit() == null ? other.getUnit() == null : this.getUnit().equals(other.getUnit()))
            && (this.getAmountGet() == null ? other.getAmountGet() == null : this.getAmountGet().equals(other.getAmountGet()))
            && (this.getNpv() == null ? other.getNpv() == null : this.getNpv().equals(other.getNpv()))
            && (this.getIrr() == null ? other.getIrr() == null : this.getIrr().equals(other.getIrr()))
            && (this.getAmountAdvance() == null ? other.getAmountAdvance() == null : this.getAmountAdvance().equals(other.getAmountAdvance()))
            && (this.getCheckPerson() == null ? other.getCheckPerson() == null : this.getCheckPerson().equals(other.getCheckPerson()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getYearsOfUse() == null) ? 0 : getYearsOfUse().hashCode());
        result = prime * result + ((getAnnualOperatingExpenses() == null) ? 0 : getAnnualOperatingExpenses().hashCode());
        result = prime * result + ((getAnnualWorkingDay() == null) ? 0 : getAnnualWorkingDay().hashCode());
        result = prime * result + ((getOverhaulYear() == null) ? 0 : getOverhaulYear().hashCode());
        result = prime * result + ((getDailyWorkload() == null) ? 0 : getDailyWorkload().hashCode());
        result = prime * result + ((getOverhaulCost() == null) ? 0 : getOverhaulCost().hashCode());
        result = prime * result + ((getCharges() == null) ? 0 : getCharges().hashCode());
        result = prime * result + ((getAnnualDiscountRate() == null) ? 0 : getAnnualDiscountRate().hashCode());
        result = prime * result + ((getExpectedAnnualInterestRate() == null) ? 0 : getExpectedAnnualInterestRate().hashCode());
        result = prime * result + ((getInvestmentStatus() == null) ? 0 : getInvestmentStatus().hashCode());
        result = prime * result + ((getUnit() == null) ? 0 : getUnit().hashCode());
        result = prime * result + ((getAmountGet() == null) ? 0 : getAmountGet().hashCode());
        result = prime * result + ((getNpv() == null) ? 0 : getNpv().hashCode());
        result = prime * result + ((getIrr() == null) ? 0 : getIrr().hashCode());
        result = prime * result + ((getAmountAdvance() == null) ? 0 : getAmountAdvance().hashCode());
        result = prime * result + ((getCheckPerson() == null) ? 0 : getCheckPerson().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", amount=").append(amount);
        sb.append(", createTime=").append(createTime);
        sb.append(", yearsOfUse=").append(yearsOfUse);
        sb.append(", annualOperatingExpenses=").append(annualOperatingExpenses);
        sb.append(", annualWorkingDay=").append(annualWorkingDay);
        sb.append(", overhaulYear=").append(overhaulYear);
        sb.append(", dailyWorkload=").append(dailyWorkload);
        sb.append(", overhaulCost=").append(overhaulCost);
        sb.append(", charges=").append(charges);
        sb.append(", annualDiscountRate=").append(annualDiscountRate);
        sb.append(", expectedAnnualInterestRate=").append(expectedAnnualInterestRate);
        sb.append(", investmentStatus=").append(investmentStatus);
        sb.append(", unit=").append(unit);
        sb.append(", amountGet=").append(amountGet);
        sb.append(", npv=").append(npv);
        sb.append(", irr=").append(irr);
        sb.append(", amountAdvance=").append(amountAdvance);
        sb.append(", checkPerson=").append(checkPerson);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
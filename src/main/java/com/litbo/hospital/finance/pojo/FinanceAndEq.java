package com.litbo.hospital.finance.pojo;

import java.io.Serializable;

/**
 * finance_and_eq
 * @author 
 */
public class FinanceAndEq implements Serializable {
    private Integer id;

    private String eqId;

    private String financeId;

    private String tiXing;

    private String day;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEqId() {
        return eqId;
    }

    public void setEqId(String eqId) {
        this.eqId = eqId;
    }

    public String getFinanceId() {
        return financeId;
    }

    public void setFinanceId(String financeId) {
        this.financeId = financeId;
    }

    public String getTiXing() {
        return tiXing;
    }

    public void setTiXing(String tiXing) {
        this.tiXing = tiXing;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
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
        FinanceAndEq other = (FinanceAndEq) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getEqId() == null ? other.getEqId() == null : this.getEqId().equals(other.getEqId()))
            && (this.getFinanceId() == null ? other.getFinanceId() == null : this.getFinanceId().equals(other.getFinanceId()))
            && (this.getTiXing() == null ? other.getTiXing() == null : this.getTiXing().equals(other.getTiXing()))
            && (this.getDay() == null ? other.getDay() == null : this.getDay().equals(other.getDay()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getEqId() == null) ? 0 : getEqId().hashCode());
        result = prime * result + ((getFinanceId() == null) ? 0 : getFinanceId().hashCode());
        result = prime * result + ((getTiXing() == null) ? 0 : getTiXing().hashCode());
        result = prime * result + ((getDay() == null) ? 0 : getDay().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", eqId=").append(eqId);
        sb.append(", financeId=").append(financeId);
        sb.append(", tiXing=").append(tiXing);
        sb.append(", day=").append(day);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
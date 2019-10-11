package com.litbo.hospital.finance.vo;

import com.litbo.hospital.finance.pojo.Finance;
import com.litbo.hospital.finance.pojo.FinanceAnalysis;
import com.litbo.hospital.finance.pojo.ProfitAndLoss;

import java.util.List;

/**
 * @Author: 樊小铭
 * Date: 2019/10/9 20:27
 * @Version:
 * @Description:
 */
public class FinanceVo {
    private Finance finance;

    private List<FinanceAnalysis> analyses;

    private List<ProfitAndLossVo> profitAndLosses;

    public FinanceVo() {
    }

    @Override
    public String toString() {
        return "FinanceVo{" +
                "finance=" + finance +
                ", analyses=" + analyses +
                ", profitAndLosses=" + profitAndLosses +
                '}';
    }

    public Finance getFinance() {
        return finance;
    }

    public void setFinance(Finance finance) {
        this.finance = finance;
    }

    public List<FinanceAnalysis> getAnalyses() {
        return analyses;
    }

    public void setAnalyses(List<FinanceAnalysis> analyses) {
        this.analyses = analyses;
    }

    public List<ProfitAndLossVo> getProfitAndLosses() {
        return profitAndLosses;
    }

    public void setProfitAndLosses(List<ProfitAndLossVo> profitAndLosses) {
        this.profitAndLosses = profitAndLosses;
    }

    public FinanceVo(Finance finance, List<FinanceAnalysis> analyses, List<ProfitAndLossVo> profitAndLosses) {
        this.finance = finance;
        this.analyses = analyses;
        this.profitAndLosses = profitAndLosses;
    }
}

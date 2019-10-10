package com.litbo.hospital.finance.service;

import com.litbo.hospital.common.vo.Test;
import com.litbo.hospital.finance.dao.FinanceAnalysisDAO;
import com.litbo.hospital.finance.dao.FinanceAndEqDAO;
import com.litbo.hospital.finance.dao.FinanceDAO;
import com.litbo.hospital.finance.dao.ProfitAndLossDAO;
import com.litbo.hospital.finance.pojo.Finance;
import com.litbo.hospital.finance.pojo.FinanceAnalysis;
import com.litbo.hospital.finance.pojo.FinanceAndEq;
import com.litbo.hospital.finance.pojo.ProfitAndLoss;
import com.litbo.hospital.finance.vo.FinanceEqVo;
import com.litbo.hospital.finance.vo.FinanceVo;
import com.litbo.hospital.metering.util.PropertiesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

import static java.lang.Math.pow;

/**
 * @Author: 樊小铭
 * Date: 2019/10/7 18:13
 * @Version:
 * @Description:
 */
@Service
public class FinanceServiceImpl implements FinanceService {

    @Autowired
    private FinanceDAO financeDAO;

    @Autowired
    private FinanceAnalysisDAO financeAnalysisDAO;

    @Autowired
    private ProfitAndLossDAO profitAndLossDAO;


    @Autowired
    private FinanceAndEqDAO financeAndEqDAO;

    @Override
    public int addFinance(Finance finance) {

        // 获得流水号
        String num = PropertiesUtil.getPropertie("FinanceNum");
        if(num == null){
            num = "0000001";
            PropertiesUtil.setPropertie("FinanceNum",num);
        }else{
            int tempNum = Integer.parseInt(num);
            tempNum++;
            num = new DecimalFormat("000000").format(tempNum);
            PropertiesUtil.setPropertie("FinanceNum",num);
        }

        //创建时间
        finance.setCreateTime(new SimpleDateFormat("yyyy年MM月dd日").format(new Date()));


        // 生成id
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String time = sdf.format(new Date()).substring(2) + num;
        finance.setId(time);

        finance.setInvestmentStatus("未投资");


        //  计算分析的值 begin

        List<FinanceAnalysis> financeAnalyses = analysis(finance);
        System.out.println("financeAnalyses:"+financeAnalyses);

        //  计算分析的值 end



        // 计算投资回收期 （累计净现金流量现值出现正值的年数-1）+上一年累计净现金流量现值的绝对值/出现正值年份净现金流量的现值
        /*以《某医院儿科新生儿保温箱投资决策分析论证报告》为例，
        从最左侧的年度栏向右，移到“累计净现金流”，第1年是-25000，第2年是-12000，
        第3年是1000，第3年出现正数。
        按照投资回收期公式Pt=3-1+第2年（第3年的上一年）累计净现金流量现值的绝对值12000/第3年净现金流量的现值13000
        ，即3-1+0.92=2.92。*/

        int year = 0; // 累计净现金流量现值出现正值的年数
        double d = 0D;  // 上一年累计净现金流量现值的绝对值/出现正值年份净现金流量的现值
        double countNewFlow = 0D;  // 上一年累计净现金流量现值的绝对值
        double netFlow = 0D; // 出现正值年份净现金流量的现值
        double NPVr = Double.valueOf(finance.getAnnualDiscountRate());  // 求 npv 的时候使用的折现率
        double i0 = Double.valueOf(finance.getAmount());  // 投资额
        double npv = 0D;   // npv的值
        boolean status = true;  // 如果执行过求投资回收期就不再执行
        int yearIndex = 0;
        for(FinanceAnalysis f : financeAnalyses){
            // 计算投资回收期   begin
            netFlow = f.getNetCashFlow();  // 记录出现正值年份净现金流量的现值
            if(f.getCountNetCaseFlow() > 0){
                year++;
                if(status){   // 求投资回收期
                    d = Math.abs(countNewFlow) / netFlow;
                    yearIndex = f.getYear();
                    status = false;
                }
            }
            countNewFlow = f.getCountNetCaseFlow();   // 记录上一年累计净现金流量现值
            // 计算投资回收期   end


            // 计算npv   begin
            npv += Double.valueOf(f.getPresentValue());
            // 计算npv   end

            financeAnalysisDAO.insert(f);
        }


        // 计算IRR      begin

        int useYear = Integer.parseInt(finance.getYearsOfUse());
        double[] a = new double[useYear];
        for(int  i = 0 ; i <= year ; i++){
            a[i] = financeAnalyses.get(i).getNetCashFlow();
        }
        finance.setIrr(String.valueOf(getIRR(useYear,a)));
        // 计算IRR      end


        DecimalFormat df = new DecimalFormat(".00");
        String getAmount = df.format(yearIndex-1+d);
        finance.setAmountGet(getAmount);
        finance.setNpv(df.format(npv));

        // 计算盈亏平衡
        List<ProfitAndLoss> profitAndLoss = getProfitAndLoss(finance);
        for(ProfitAndLoss p : profitAndLoss){
            profitAndLossDAO.insert(p);
        }

        return financeDAO.insert(finance);
    }

    @Override
    public int delFinance(String id) {
        return financeDAO.deleteByPrimaryKey(id);
    }


    /*#include <bits/stdc++.h>
    using namespace std;

    double a[1000];
    int n;

    double f(double r) {
        double sum = 0;
        for(int i = 1; i <= n; ++i) {
            sum += a[i]/pow(1+r,i-1);
        }
        return sum;
    }

    int main () {
        scanf("%d",&n);
        for(int i = 1; i <= n; ++i) scanf("%lf",&a[i]);
        double l = -1, r = 10000, ans, mid;
        for(int i = 1; i <= 1000; ++i) {
            mid = (l+r)/2.0;
            if(f(mid) < 0) r = mid;
            else l = mid;
        }
        printf("%f\n",(l+r)/2.0);
        return 0;
    }*/

    /**
     * 计算irr
     * @param year 使用年数
     * @param a 净现金流量数组
     * @return
     */
    private double getIRR(int year , double[] a){
        double l = -1, r = 10000, ans, mid;
        for(int i = 1; i <= 1000; ++i) {
            mid = (l+r)/2.0;
            if(f(mid,year,a) < 0) r = mid;
            else l = mid;
        }
        return (l+r)/2.0;
    }

    private double f(double r , int n , double[] a) {
        double sum = 0;
        for(int i = 1; i <= n; ++i) {
            sum += a[i]/pow(1+r,i-1);
        }
        return sum;
    }


    /**
     * 计算盈亏平衡
     * @param finance
     * @return
     */
    private List<ProfitAndLoss> getProfitAndLoss(Finance finance){

        int year = Integer.parseInt(finance.getYearsOfUse());

        ProfitAndLoss p5 = new ProfitAndLoss();
        p5.setProjectId(finance.getId());


        // 每年折旧
        DecimalFormat df = new DecimalFormat(".0");
        p5.setYearLoss(df.format(Double.valueOf(finance.getAmount()) / year));

        // 每年运营费用
        p5.setYearYunying(finance.getAnnualOperatingExpenses());

        // 成本合计
        p5.setTotleLoss(df.format(Double.valueOf(p5.getYearLoss()) + Double.valueOf(p5.getYearYunying())));

        // 每工作日平均成本
        p5.setAvgDayLoss(df.format(Double.valueOf(p5.getTotleLoss()) / Double.valueOf(finance.getAnnualWorkingDay())));

        // 盈亏平衡点
        p5.setPingHeng(df.format(Double.valueOf(p5.getAvgDayLoss()) / Double.valueOf(finance.getCharges())));


        // 保利点
        p5.setBaoLi(df.format((Double.valueOf(p5.getAvgDayLoss()) + Double.valueOf(finance.getAmount()) * Double.valueOf(finance.getExpectedAnnualInterestRate())) / Double.valueOf(finance.getCharges())));


        // 盈亏平衡点作业率=1－（（利润总额 /营业收入×100％）/（边际贡献/销售收入）*100%）

        List<ProfitAndLoss> list = new ArrayList<>();
        list.add(p5);
        return list;
    }

    /**
     * 计算项目的值
     * @param finance
     * @return
     */
    private List<FinanceAnalysis> analysis(Finance finance){

            int year = Integer.parseInt(finance.getYearsOfUse());   // 使用年限

            // 运营费用
            Double cast = Double.valueOf(finance.getAnnualOperatingExpenses());

            List<FinanceAnalysis> analyses = new ArrayList<>();

            // 预计收入
            double yuJiShouRu = Double.parseDouble(finance.getAnnualWorkingDay()) * Double.parseDouble(finance.getDailyWorkload()) * Double.parseDouble(finance.getCharges());

            double count = 0D; // 累计现金流量

            for(int i = 0 ; i <= year ; i++){
                FinanceAnalysis f = new FinanceAnalysis();
                f.setFinanceId(finance.getId());
                if(i == 0){
                    f.setYear(i+1);  // 年度
                    f.setInvestmentAmount(Double.valueOf(finance.getAmount()));  // 投资金额
                    f.setOverhaul(0D);  // 大修
                    f.setEstimatedIncome(0D);   // 预计收入
                    f.setOperatingExpenses(0D);  // 运营费用
                    //净现金流量
                    f.setNetCashFlow(f.getEstimatedIncome() - f.getOperatingExpenses() - f.getInvestmentAmount() - f.getOverhaul());//                    净现金流量
                    count += f.getNetCashFlow();
                    f.setCountNetCaseFlow(count); //  累计净现金流量
                    analyses.add(f);
                    continue;
                }
                if(i == Integer.parseInt(finance.getOverhaulYear())){   // 大修年度
                    f.setYear(i+1);  // 年度
                    f.setInvestmentAmount(0D);  // 投资金额
                    f.setOverhaul(Double.valueOf(finance.getOverhaulCost()));  // 大修
                    f.setEstimatedIncome(yuJiShouRu);   // 预计收入
                    f.setOperatingExpenses(cast);  // 运营费用
                    //净现金流量
                    f.setNetCashFlow(f.getEstimatedIncome() - f.getOperatingExpenses() - f.getInvestmentAmount() - f.getOverhaul());//                    净现金流量
                    count += f.getNetCashFlow();
                    f.setCountNetCaseFlow(count); //  累计净现金流量
                    analyses.add(f);
                    continue;
                }
                f.setYear(i+1);  // 年度
                f.setInvestmentAmount(0D);  // 投资金额
                f.setOverhaul(0D);  // 大修
                f.setEstimatedIncome(yuJiShouRu);   // 预计收入
                f.setOperatingExpenses(cast);  // 运营费用
                // 净现金流量
                f.setNetCashFlow(f.getEstimatedIncome() - f.getOperatingExpenses() - f.getInvestmentAmount() - f.getOverhaul());//                    净现金流量
                count += f.getNetCashFlow();
                f.setCountNetCaseFlow(count); //  累计净现金流量
                analyses.add(f);
            }

            // 计算折现因子
            List<Double> result = getZheXianYinZi(Double.valueOf(finance.getExpectedAnnualInterestRate()),Double.valueOf(finance.getYearsOfUse()));
            for(int i = 0 ; i <= year ; i++){
                analyses.get(i).setDiscountFactor(Double.valueOf(save4(result.get(i))));
            }

            // 计算现值
            for(FinanceAnalysis f : analyses){
                f.setPresentValue(save2(f.getNetCashFlow() * Double.valueOf(f.getDiscountFactor())));
            }

            return analyses;

    }

    /**
     * 保留四位小数
     * @param d
     * @return
     */
    private String save4(double d){
        DecimalFormat df = new DecimalFormat("0.0000");
        return df.format(d);
    }


    /**
     * 保留两位小数
     * @param d
     * @return
     */
    private String save2(double d){
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(d);
    }



    /**
     * 计算折现因子
     * @param yuQiLiLv 预期利率
     * @param totleYear 总年数
     * @return
     */
    private List<Double> getZheXianYinZi(double yuQiLiLv,double totleYear){
        int i = 1;
        double temp = 1; // 每一年的折现因子

        List<Double> result1 = new ArrayList<>();

        for(i = 1 ; i <= totleYear+1 ; i++){   // 总的要计算 i 年
            for(int j = 1 ; j <= i ; j++){   // 每一年的折现因子的指数 j
                temp = (1 + yuQiLiLv) * temp;
            }
            temp = 1.0 / temp;
            result1.add(temp);
            temp = 1;
        }

        return result1;
    }



    @Override
    public List<Finance> allFinance(String name, String status) {
        if(name != null){
            name = "%" + name + "%";
        }

        return financeDAO.allFinance(name,status);
    }

    @Override
    public FinanceVo getMessage(String id) {
        // 查询finance信息
        Finance f = financeDAO.selectByPrimaryKey(id);

        // 查询financeAnalysis信息
        List<FinanceAnalysis> financeAnalyses = financeAnalysisDAO.getFinanceAnalysis(id);

        // 查询Profitandloss信息
        List<ProfitAndLoss> profitAndLosses = profitAndLossDAO.getMessage(id);

        FinanceVo vo = new FinanceVo();
        vo.setAnalyses(financeAnalyses);
        vo.setFinance(f);
        vo.setProfitAndLosses(profitAndLosses);

        return vo;
    }

    @Override
    public int touZi(String id , String name , String advance) {
        Finance f = financeDAO.selectByPrimaryKey(id);
        f.setInvestmentStatus("已投资");
        f.setAmountAdvance(advance);
        f.setCheckPerson(name);
        return financeDAO.updateByPrimaryKey(f);
    }

    @Override
    public int guanlian(FinanceAndEq eq) {
        return financeAndEqDAO.insert(eq);
    }

    @Override
    public List<FinanceEqVo> getGuanLian(String eqNum, String eqName, String name, String bmName) {

        if(eqName != null){
            eqName = "%" + eqName + "%";
        }

        if(name != null){
            name = "%" + name + "%";
        }

        if(bmName != null){
            bmName = "%" + bmName + "%";
        }
        return financeAndEqDAO.getGuanLian(eqNum, eqName, name, bmName);
    }


}
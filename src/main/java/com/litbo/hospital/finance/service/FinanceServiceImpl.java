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
import com.litbo.hospital.finance.vo.ProfitAndLossVo;
import com.litbo.hospital.finance.vo.Text1;
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
        double[] a = new double[1000];
        for(int i = 0 ; i < financeAnalyses.size() ; i++){
            a[i] = financeAnalyses.get(i).getNetCashFlow();
        }
        double d2 = Text1.getIrr(financeAnalyses.size()-1,a);


        // 计算IRR      end


        DecimalFormat df = new DecimalFormat(".00");
        String getAmount = df.format(yearIndex-1+d);
        finance.setIrr(df.format(d2*100));
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

    @Override
    public int getFiance(FinanceAndEq eq) {
        Finance finance = financeDAO.selectByPrimaryKey(eq.getFinanceId());
        finance.setEqId(eq.getEqId());
        finance.setTiXing(eq.getTiXing());
        finance.setDay(eq.getDay());
        return financeDAO.updateByPrimaryKey(finance);
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

        DecimalFormat df = new DecimalFormat("#.00");

        // 每年折旧
        p5.setYearLoss(df.format(Double.valueOf(finance.getAmount()) / year));

        // 每年运营费用
        p5.setYearYunying(finance.getAnnualOperatingExpenses());

        // 成本合计
        p5.setTotleLoss(df.format(Double.valueOf(p5.getYearLoss()) + Double.valueOf(p5.getYearYunying())));

        // 每工作日平均成本
        p5.setAvgDayLoss(df.format(Double.valueOf(p5.getTotleLoss()) / Double.valueOf(finance.getAnnualWorkingDay())));

        // 盈亏平衡点
        p5.setPingHeng(df.format(Double.valueOf(p5.getAvgDayLoss()) / Double.valueOf(finance.getCharges())));


        // 保利点   每日平均工作成本 *  （ 期望年利率 + 1 ） / 收费标准
//          投入金额 / year / 工作天数 / 价格     * ( Double.valueOf(finance.getExpectedAnnualInterestRate()) + 1 )
        p5.setBaoLi(df.format((Double.valueOf(finance.getAmount()) + Double.valueOf(finance.getOverhaulCost())) / Double.valueOf(finance.getYearsOfUse()) / Double.valueOf(finance.getAnnualWorkingDay()) / Double.valueOf(finance.getCharges())+ Double.valueOf(p5.getPingHeng()))) ;


        //安全边际率=销售利润率/边际贡献率*100%=50.67/97=52.24%
        //
        //销售利润率＝利润总额 /营业收入×100％=38000元/75000元=50.67%
        //
        //边际贡献率=边际贡献/销售收入=73000/75000=97%
        //
        //边际贡献＝固定成本+利润=35000+38000=73000
        //
        //成本：折旧成本25000元+运营成本2000元*5
        //
        //利润总额＝营业收入－营业成本－费用=75000-35000-2000=38000元

        Double contentGet = Double.valueOf(finance.getAnnualWorkingDay()) * Double.valueOf(finance.getDailyWorkload()) * Double.valueOf(finance.getCharges()) * Double.valueOf(finance.getYearsOfUse());

        System.out.println("营业收入:"+contentGet.toString());

        Double chengBen = Double.valueOf(finance.getAmount()) + Double.valueOf(finance.getAnnualOperatingExpenses()) * Double.valueOf(finance.getYearsOfUse());

        System.out.println("营业成本："+chengBen.toString());

        Double liRunZongE = contentGet - chengBen - Double.valueOf(finance.getOverhaulCost());

        System.out.println("利润总额："+liRunZongE.toString());

        Double bianJiGongXianLv = ( chengBen + liRunZongE )  / contentGet;

        System.out.println("边际贡献率:" + bianJiGongXianLv.toString());

        Double anQuanBianJiLv = liRunZongE / contentGet / bianJiGongXianLv;

        System.out.println("安全边际率：" + anQuanBianJiLv.toString());


        p5.setBianJi(String.valueOf(anQuanBianJiLv * 100));

        // 盈亏平衡点作业率=1－安全边际率
        p5.setZuoYeLv(df.format((1 - anQuanBianJiLv) * 100));

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
        List<ProfitAndLossVo> profitAndLosses = profitAndLossDAO.getMessage(id);

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
        return financeDAO.getGuanLian(eqNum, eqName, name, bmName);
    }


}
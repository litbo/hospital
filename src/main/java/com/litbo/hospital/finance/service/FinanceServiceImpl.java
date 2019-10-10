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


        ExecutorService pool = Executors.newFixedThreadPool(20);
        // 创建多个有返回值的任务
        List<Future> list = new ArrayList<Future>();
        int yearOfUse = Integer.valueOf(finance.getYearsOfUse());
        for (int i = 0; i <= 10; i++) {
            Callable c = new IRR((i*10)/100.0 , financeAnalyses , i0 , NPVr ,yearOfUse);
            // 执行任务并获取Future对象
            Future f = pool.submit(c);
            list.add(f);
        }
        // 关闭线程池
        pool.shutdown();
        // 获取所有并发任务的运行结果
        int index1 = 0;

        try {
                                                            // 确定十位数  index
            for (index1 = 0; index1 < 10; index1++) {
                if((Double)list.get(index1).get() == 0){
                    break;
                }
                if((Double)list.get(index1).get() * (Double)list.get(index1+1).get() < 0  && (Double)list.get(index1+1).get() > 0){
                    break;
                }
            }

            System.out.println("index1:"+index1);
                                                            // 确定个位数   index1
            ExecutorService pool1 = Executors.newFixedThreadPool(20);
            // 创建多个有返回值的任务
            List<Future> list1 = new ArrayList<Future>();
            for (int i = 0; i <= 10; i++) {
                Callable c = new IRR((index1*10 + i)/100.0 , financeAnalyses , i0 , NPVr ,yearOfUse);
                // 执行任务并获取Future对象
                Future f = pool1.submit(c);
                list1.add(f);
            }
            // 关闭线程池
            pool1.shutdown();


            try {

                int index2 = 0;
                // 确定个位数
                for (index2 = 0; index2 < 10; index2++) {
                    if((Double)list1.get(index2).get() == 0){
                        break;
                    }
                    if((Double)list1.get(index2).get() * (Double)list1.get(index2+1).get() < 0   && (Double)list1.get(index1+1).get() > 0){
                        break;
                    }
                }

                System.out.println("index2:"+index2);

                // 确定小数点后一位数
                ExecutorService pool2 = Executors.newFixedThreadPool(20);
                // 创建多个有返回值的任务
                List<Future> list2 = new ArrayList<Future>();
                for (int i = 0; i <= 10; i++) {
                    Callable c = new IRR((index1*10+index2+i/10.0)/100.0 , financeAnalyses , i0 , NPVr ,yearOfUse);
                    // 执行任务并获取Future对象
                    Future f = pool2.submit(c);
                    list2.add(f);
                }
                // 关闭线程池
                pool2.shutdown();

                try {

                    int index3 = 0;
                    // 确定个位数
                    for (index3 = 0; index3 < 10; index3++) {
                        if((Double)list2.get(index3).get() == 0){
                            break;
                        }
                        if((Double)list2.get(index3).get() * (Double)list2.get(index3+1).get() < 0   && (Double)list2.get(index1+1).get() > 0){
                            break;
                        }
                    }
                    System.out.println("index3:"+index3);

                    // 确定小数点后一位数
                    ExecutorService pool3 = Executors.newFixedThreadPool(20);
                    // 创建多个有返回值的任务
                    List<Future> list3 = new ArrayList<Future>();
                    for (int i = 0; i <= 10; i++) {
                        Callable c = new IRR((index1*10+index2+index3/10.0 + i / 100.0)/100.0 , financeAnalyses , i0 , NPVr ,yearOfUse);
                        // 执行任务并获取Future对象
                        Future f = pool3.submit(c);
                        list3.add(f);
                    }
                    // 关闭线程池
                    pool3.shutdown();
                    try {

                        int index4 = 0;
                        // 确定最后一位数
                        for (index4 = 0; index4 < 10; index4++) {
                            if((Double)list3.get(index4).get() == 0){
                                break;
                            }
                            if((Double)list3.get(index4).get() * (Double)list3.get(index4+1).get() < 0   && (Double)list3.get(index1+1).get() > 0){
                                break;
                            }
                        }
                        System.out.println("index4:"+index4);
                        double  result = index1*10 + index2 + index3 / 10.0 + index4 / 100.0;
                        DecimalFormat df = new DecimalFormat(".00%");
                        finance.setIrr(df.format(result));
                    } catch (InterruptedException e) {
                        System.out.println("计算最后一位出错");
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        System.out.println("计算最后一位出错");
                        e.printStackTrace();
                    }
                } catch (InterruptedException e) {
                    System.out.println("计算第三位出错");
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    System.out.println("计算第三位出错");
                    e.printStackTrace();
                }
            } catch (InterruptedException e) {
                System.out.println("计算第二位出错");
                e.printStackTrace();
            } catch (ExecutionException e) {
                System.out.println("计算第二位出错");
                e.printStackTrace();
            }
        } catch (InterruptedException e) {
            System.out.println("计算第一位出错");
            e.printStackTrace();
        } catch (ExecutionException e) {
            System.out.println("计算第一位出错");
            e.printStackTrace();
        }
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


    /**
     * 计算盈亏平衡
     * @param finance
     * @return
     */
    private List<ProfitAndLoss> getProfitAndLoss(Finance finance){
        ProfitAndLoss p5 = new ProfitAndLoss();
        p5.setProjectId(finance.getId());


        ProfitAndLoss p10 = new ProfitAndLoss();
        p10.setProjectId(finance.getId());


        // 每年折旧
        DecimalFormat df = new DecimalFormat(".0");
        p5.setYearLoss(df.format(Double.valueOf(finance.getAmount()) / 5.0));
        p10.setYearLoss(df.format(Double.valueOf(finance.getAmount()) / 10.0));

        // 每年运营费用
        p5.setYearYunying(finance.getAnnualOperatingExpenses());
        p10.setYearYunying(finance.getAnnualOperatingExpenses());

        // 成本合计
        p5.setTotleLoss(df.format(Double.valueOf(p5.getYearLoss()) + Double.valueOf(p5.getYearYunying())));
        p10.setTotleLoss(df.format(Double.valueOf(p10.getYearLoss()) + Double.valueOf(p10.getYearYunying())));

        // 每工作日平均成本
        p5.setAvgDayLoss(df.format(Double.valueOf(p5.getTotleLoss()) / Double.valueOf(finance.getAnnualWorkingDay())));
        p10.setAvgDayLoss(df.format(Double.valueOf(p10.getTotleLoss()) / Double.valueOf(finance.getAnnualWorkingDay())));

        // 盈亏平衡点
        p5.setPingHeng(df.format(Double.valueOf(p5.getAvgDayLoss()) / Double.valueOf(finance.getCharges())));
        p10.setPingHeng(df.format(Double.valueOf(p10.getAvgDayLoss()) / Double.valueOf(finance.getCharges())));


        // 保利点
        p5.setBaoLi(df.format((Double.valueOf(p5.getAvgDayLoss()) + Double.valueOf(finance.getAmount()) * Double.valueOf(finance.getExpectedAnnualInterestRate())) / Double.valueOf(finance.getCharges())));
        p10.setBaoLi(df.format((Double.valueOf(p10.getAvgDayLoss()) + Double.valueOf(finance.getAmount()) * Double.valueOf(finance.getExpectedAnnualInterestRate())) / Double.valueOf(finance.getCharges())));


        // 盈亏平衡点作业率=1－（（利润总额 /营业收入×100％）/（边际贡献/销售收入）*100%）

        List<ProfitAndLoss> list = new ArrayList<>();
        list.add(p5);
        list.add(p10);
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
    public int touZi(String id) {
        Finance f = financeDAO.selectByPrimaryKey(id);
        f.setInvestmentStatus("已投资");
        return financeDAO.updateByPrimaryKey(f);
    }

    @Override
    public int guanlian(FinanceAndEq eq) {
        return financeAndEqDAO.insert(eq);
    }

    @Override
    public List<FinanceEqVo> getGuanLian(String eqNum, String eqName, String name, String bmName) {
        if(eqNum != null){
            eqNum = "%" + eqNum + "%";
        }

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


/*迭代法就是在假设r值情况下，使NPV等于或接近于0的数学迭代过程。
        用《某医院儿科新生儿保温箱投资决策分析论证报告》举例如下：
        计算NPV=0时的r值
        已知：
        I0=-25000，I1=13000，I2=13000，I3=11000，I4=13000，I5=13000
        假设：
        r=10%  I0=-25000,I1/(1+0.1)=11820  I2/(1+r)^2=10744，I3/(1+r)^3=8270， I4/(1+r)^4=8900  I5/(1+r)^5=8070
        六个数值相加：得数22734，远大于0
        r=40% I0=-25000, I1/(1+0.4)=9285.71, I2/(1+r)^2=6632.65, I3/(1+r)^3=4014.60, I4/(1+r)^4=3385.42, I5/(1+r)^5=2416.36
        六个数值相加：得数734.74,还是大于0
        R=45% I0=-25000, I1/(1+0.45)=8965.52, I2/(1+r)^2=6190.48 I3/(1+r)^3=3606.56, I4/(1+r)^4=2941.18, I5/(1+r)^5=2028.08
        六个数值相加：得数-1268.18,出现负数小于0。
        r=40%,大于0；r=45%小于0。得数为0的r值应在40-45%之间。
        第二层迭代
        r=41% I0=-25000, I1/(1+0.41)=9219.86, I2/(1+r)^2=6532.66，I3/(1+r)^3=3914.59，I4/(1+r)^4=3282.83, I5/(1+r)^5=2329.75
        六个数值相加：得数279.69,大于0。
        r=42% I0=-25000, I1/(1+0.42)=9154.93, I2/(1+r)^2=6435.64，I3/(1+r)^3=3832.75, I4/(1+r)^4=3186.27, I5/(1+r)^5=2245.25
        六个数值相加：得数-145.16,小于0。
        r=41%，得数大于0； r=42%，得数小于0。得数为0的r值应在41-42%之间
        第三层迭代
        r值在41.1%-41.9%，还可以得到得数大于0，得数小于0的两个相邻r值，在这两个r值之间继续做第四层迭代，在第四层上找得数大于0，得数小于0的两个相邻r值，如此循环，最终找到得数为0或逼近于0的r值，这个r值就是IRR。
        习惯上：
        每个层面按十个r值安排，算得负值，转入下个层面，一般算四个层面，就是小数点后两位数即可。*/
class IRR implements Callable{

    private double r;  // 一个代表irr的百分数

    private List<FinanceAnalysis> analyses;  // 计算结果

    private double tze;  // 投资额

    private double zxl; // 折现率

    private int year;  // 使用年限


    /**
     * 计算IRR（内部收益率）
     * @param analyses 项目的分析结果
     * @param tze 投资额
     * @param zxl 折现率
     * @param r 内部收益率
     * @param year 使用年限
     * @return
     */
    public IRR(double r, List<FinanceAnalysis> analyses, double tze, double zxl, int year) {
        this.r = r;
        this.analyses = analyses;
        this.tze = tze;
        this.zxl = zxl;
        this.year = year;
    }

    @Override
    public Object call() throws Exception {
        double i2= 1D;
        double npv = -tze;
        for(int j = 1 ; j <= year ; j++){
            i2 *= (1+zxl);
            FinanceAnalysis an = analyses.get(j-1);
            double jxj = an.getNetCashFlow(); // 净现金流量
            npv += jxj / i2;
        }
        return npv;
    }

}
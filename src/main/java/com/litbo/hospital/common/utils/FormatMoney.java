package com.litbo.hospital.common.utils;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;

/**
 * FormatMoney 格式化钱的金额
 *
 * @author Administrator on 2019-04-18
 */
public class FormatMoney {

    private static final long ONE_YUAN = 0L; //元
    private static final long TEN_YUAN = 10L; //十元
    private static final long HUNDRED_YUAN = 100L; //百元
    private static final long THOUSAND_YUAN = 1000L; //千元
    private static final long TEN_THOUSAND_YUAN = 10000L;  //万元
    private static final long ONE_HUNDRED_THOUSAND_YUAN = 100000L; //十万元
    private static final long MILLION_YUAN = 1000000L; //百万元
    private static final long TEN_MILLION_YUAN = 10000000L; //千万元
    private static final long ONE_HUNDRED_MILLION_YUAN = 100000000L; //亿元
    private static final long ONE_BILLION_YUAN = 1000000000L; //十亿元
    private static final long TEN_BILLION_YUAN = 10000000000L; //百亿元

    private static final String YUAN = "元";
    private static final String TEN = "十";
    private static final String HUNDRED = "百";
    private static final String THOUSAND = "千";
    private static final String TEN_THOUSAND = "万";
    private static final String ONE_HUNDRED_THOUSAND = "十万";
    private static final String MILLION = "百万";
    private static final String TEN_MILLION = "千万";
    private static final String ONE_HUNDRED_MILLION = "亿";
    private static final String ONE_BILLION = "十亿";
    private static final String TEN_BILLION = "百亿";

    public static String format(String money) {
        //如果值为空则返回0
        if (StringUtils.isBlank(money)) {
            return "0元";
        }
        return format(new BigDecimal(money));
    }

    public static String format(long money) {
        return format(new BigDecimal(money));
    }

    public static String format(BigDecimal money) {
        if (money.longValue() < 0) {
            throw new Error("金额不能为负数");
        }
        StringBuilder result = new StringBuilder();
        long value = money.longValue();
        //百亿
        if (value >= TEN_BILLION_YUAN) {
            result.append(value / TEN_BILLION_YUAN);
            value = value % TEN_BILLION_YUAN;
            result.append(TEN_BILLION);
        }
        //十亿
        if (value >= ONE_BILLION_YUAN) {
            result.append(value / ONE_BILLION_YUAN);
            value = value % ONE_BILLION_YUAN;
            result.append(ONE_BILLION);
        }
        //亿
        if (value >= ONE_HUNDRED_MILLION_YUAN) {
            result.append(value / ONE_HUNDRED_MILLION_YUAN);
            value = value % ONE_HUNDRED_MILLION_YUAN;
            result.append(ONE_HUNDRED_MILLION);
        }
        //千万
        if (value >= TEN_MILLION_YUAN) {
            result.append(value / TEN_MILLION_YUAN);
            value = value % ONE_HUNDRED_MILLION_YUAN;
            result.append(TEN_MILLION);
        }
        //百万
        if (value >= MILLION_YUAN) {
            result.append(value / MILLION_YUAN);
            value = value % ONE_HUNDRED_MILLION_YUAN;
            result.append(MILLION);
        }
        //十万
        if (value >= ONE_HUNDRED_THOUSAND_YUAN) {
            result.append(value / ONE_HUNDRED_THOUSAND_YUAN);
            value = value % ONE_HUNDRED_MILLION_YUAN;
            result.append(ONE_HUNDRED_THOUSAND);
        }
        //万
        if (value >= TEN_THOUSAND_YUAN) {
            result.append(value / TEN_THOUSAND_YUAN);
            value = value % TEN_THOUSAND_YUAN;
            result.append(TEN_THOUSAND);
        }
        //千
        if (value >= THOUSAND_YUAN) {
            result.append(value / THOUSAND_YUAN);
            value = value % THOUSAND_YUAN;

            result.append(THOUSAND);
        }
        //百
        if (value >= HUNDRED_YUAN) {
            result.append(value / HUNDRED_YUAN);
            value = value % HUNDRED_YUAN;
            result.append(HUNDRED);
        }
        //十
        if (value >= TEN_YUAN) {
            result.append(value / TEN_YUAN);
            result.append(TEN);
        }
        //个
        if (value >= ONE_YUAN) {
            long var = value % TEN_YUAN;
            if (var > 0){
                result.append(var);
            }
            result.append(YUAN);
        }
        return result.toString();
    }

    public static void main(String[] args){
        String format = FormatMoney.format("9050.21");
        System.out.println(format);
    }
}

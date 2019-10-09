package com.litbo.hospital.finance.service;

import com.litbo.hospital.finance.pojo.Finance;
import com.litbo.hospital.finance.vo.FinanceVo;

import java.util.List;

/**
 * @Author: 樊小铭
 * Date: 2019/10/7 18:12
 * @Version:
 * @Description:
 */
public interface FinanceService {

    int addFinance(Finance finance);

    List<Finance> allFinance(String name,String status);

    FinanceVo getMessage(String id);
}

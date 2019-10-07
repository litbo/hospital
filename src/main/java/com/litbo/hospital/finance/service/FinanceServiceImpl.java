package com.litbo.hospital.finance.service;

import com.litbo.hospital.finance.dao.FinanceDAO;
import com.litbo.hospital.finance.pojo.Finance;
import com.litbo.hospital.metering.util.PropertiesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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


        // 生成id
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String time = sdf.format(new Date()).substring(2) + num;
        finance.setId(time);
        return financeDAO.insert(finance);
    }

    @Override
    public List<Finance> allFinance(String name, String status) {
        if(name != null){
            name = "%" + name + "%";
        }

        return financeDAO.allFinance(name,status);
    }
}

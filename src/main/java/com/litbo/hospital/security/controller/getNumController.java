package com.litbo.hospital.security.controller;


import com.litbo.hospital.metering.util.PropertiesUtil;
import com.litbo.hospital.result.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/px")
public class getNumController {
    //自动生成培训编号
    @RequestMapping("/getNum")
    public Result getNum(){
        String num = PropertiesUtil.getPropertie("num");
        if(num==null) {
            num = "000001";
            PropertiesUtil.setPropertie("num",num);
        } else{
            Integer tmpNum = Integer.parseInt(num);
            tmpNum++;
            num = new DecimalFormat("000000").format(tmpNum);
            PropertiesUtil.setPropertie("num",num);
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String Pnum = sdf.format(new Date()).substring(2) + num;
        return Result.success(Pnum);
    }
}

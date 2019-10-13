package com.litbo.hospital.security.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.lifemanage.MyUtils.String2DateUtil;
import com.litbo.hospital.metering.util.PropertiesUtil;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.security.service.PxService;
import com.litbo.hospital.security.vo.BmVo;
import com.litbo.hospital.security.vo.RyPxJhVo;
import com.litbo.hospital.security.vo.YyPxJhVo;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.executor.ResultExtractor;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

@RestController
@RequestMapping("/px")
public class PxController {

    @Autowired
    private PxService pxService;

    @RequestMapping("/getYypxBt")
    public Result getYypxBt(){
        JSONArray myJson = null;
        String jsonMessage = "[{'type':'radio'},{field:'eqName',title:'设备名称'}," +
                "{field:'eqZcbh',title:'院内编码'},{field:'eqSbbh',title:'分类编码'}]";
        myJson = JSONObject.parseArray(jsonMessage);
        return Result.success(new PageInfo(myJson));
    }

    @RequestMapping("/getBmBt")
    public Result getBmBt(){
        JSONArray myJson = null;
        String jsonMessage = "[{'type':'radio'},{field:'bmId',title:'科室id'}," +
                "{field:'bmName',title:'科室'}]";
        myJson = JSONObject.parseArray(jsonMessage);
        return Result.success(myJson);
    }

    @RequestMapping("/getYypxNr")
    public Result getYypxNr(@RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
                            @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize){
        PageInfo pageInfo = pxService.getYypxNr(pageNum,pageSize);
        return Result.success(pageInfo);
    }

    @RequestMapping("/getYypxKsNr")
    public Result getYypxKsNr(@RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
                            @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize){
        List<BmVo> listBm = pxService.getYypxKsNr(pageNum,pageSize);
        return Result.success(new PageInfo(listBm));
    }

    @RequestMapping("/addRypxjh")
    public Result addYypxjh(RyPxJhVo ryPxJhVo) {
        ryPxJhVo.setJhJstime2(String2DateUtil.StringtoDate(ryPxJhVo.getJhJstime()));
        ryPxJhVo.setJhKstime2(String2DateUtil.StringtoDate(ryPxJhVo.getJhKstime()));
        Integer integer = pxService.addYypxjh(ryPxJhVo);
        if (integer > 0) {
            return Result.success();
        } else {
            return Result.error();
        }
    }

    //生成培训编号
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

    @Test
    public void test(){

    }
}

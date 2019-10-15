package com.litbo.hospital.security.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.metering.util.PropertiesUtil;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.security.service.PxService;
import com.litbo.hospital.security.vo.BmVo;
import com.litbo.hospital.security.vo.KsFzVo;
import com.litbo.hospital.security.vo.RyPxJhVo;
import com.litbo.hospital.security.vo.YyPxJhVo;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.apache.ibatis.executor.ResultExtractor;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/px")
public class PxController {

    @Autowired
    private PxService pxService;

    @RequestMapping("/findAllRyjh")
    public Result findAllRyjh(@RequestParam("pageNum") int pageNum,@RequestParam("pageSize") int pageSize){
            return Result.success(pxService.findAllRyjh(pageNum,pageSize));
    }
    @RequestMapping("/findAllYyjh")
    public Result findAllYyJh(@RequestParam("pageNum") int pageNum,@RequestParam("pageSize") int pageSize){
        PageInfo pageInfo = pxService.findAllYyJh(pageNum,pageSize);
        return Result.success(pageInfo);
    }
    @RequestMapping("/getYypxBt")
    public Result getYypxBt(){

        JSONArray myJson = null;
        String jsonMessage = "[{'type':'radio'},{field:'eqId',title:'设备id'},{field:'eqName',title:'设备名称'}," +
                "{field:'eqZcbh',title:'院内编码'},{field:'eqSbbh',title:'分类编码'}]";

        myJson = JSONObject.parseArray(jsonMessage);
        return Result.success(new PageInfo(myJson));
    }

    @RequestMapping("/getBmBt")
    public Result getBmBt(){
        JSONArray myJson = null;
        String jsonMessage = "[{'type':'radio'},{field:'bmId',title:'科室id'}," +
                "{field:'pxks',title:'科室'}]";
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
        List<KsFzVo> listBm = pxService.getYypxKsNr(pageNum,pageSize);
        return Result.success(new PageInfo(listBm));
    }

    @RequestMapping("/addYypxjh")
    public Result addYypxjh(@RequestBody YyPxJhVo yyPxJhVo){
       String str =  yyPxJhVo.getPxnrlb();
       System.out.println(str);
       String[] strs = str.split(",");
        for(String s:strs){
            yyPxJhVo.setPxnrlb(s);
            pxService.addYypxjh(yyPxJhVo);
        }
        return Result.success();
    }

    @RequestMapping("/addRypxjh")
    public Result addRypxjh(@RequestBody RyPxJhVo ryPxJhVo){
        String string = ryPxJhVo.getJhPxnrlb();
        String [] strs = string.split(",");
        for(String str:strs){
            ryPxJhVo.setJhPxnrlb(str);
            pxService.addRypxjh(ryPxJhVo);
        }
        return Result.success();
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

}

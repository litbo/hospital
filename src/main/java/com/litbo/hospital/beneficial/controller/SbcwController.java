package com.litbo.hospital.beneficial.controller;

import com.litbo.hospital.beneficial.service.SbcwService;
import com.litbo.hospital.beneficial.vo.*;
import com.litbo.hospital.common.utils.poi.ExcelData;
import com.litbo.hospital.common.utils.poi.ExportExcelUtil;
import com.litbo.hospital.lifemanage.MyUtils.String2DateUtil;
import com.litbo.hospital.result.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/*
*  设备成本效益分析
* */
@RestController
@RequestMapping(value = "/benefical/sbcw")
public class SbcwController {

    @Autowired
    private SbcwService sbcwService;

    //查询设备财务直接成本信息列表
    @RequestMapping(value = "/listZjcb")
    public Result listZjcb(@RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
                           @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize,
                           @RequestParam(required = false) String qssj) throws ParseException {
        Date qs=null;
        Date js=null;
        if(StringUtils.isNotBlank(qssj)){
            String[] split = qssj.split("~");
           if(split.length==2){
                qs= String2DateUtil.StringtoDateOnlyYear(split[0]);
                js= String2DateUtil.StringtoDateOnlyYear(split[1]);
            }
        }
        else{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
            qs=calendar.getTime();
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTime(new Date());
            calendar2.set(Calendar.DAY_OF_MONTH, calendar2.getActualMaximum(Calendar.DAY_OF_MONTH));
            js=calendar2.getTime();
            String s = sdf.format(qs);
            qs=sdf.parse(s);
            String s2 = sdf.format(js);
            js=sdf.parse(s2);


        }

        return Result.success(sbcwService.listZjcb(pageNum, pageSize,qs,js));
    }

    //查询设备直接成本列表根据条件查询
    @RequestMapping(value = "/listZjcbByX")
    public Result listZjcbByX(@RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
                              @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize,
                              CbMhVo cbMhVo) {

        return Result.success(sbcwService.listZjcbByX(pageNum, pageSize, cbMhVo));
    }

    //导出 excell设备直接成本列表
    @RequestMapping(value = "/listZjcbByXExport", method = RequestMethod.GET)
    public void listZjcbByXExport(CbMhVo cbMhVo, HttpServletResponse response,
                                    @RequestParam(value = "fileName", required = true) String fileName) {

        List<String> titles = Arrays.asList(new ExcelData().getFiledName(ZjcbVo.class));
        ExcelData data = new ExcelData(titles, sbcwService.listZjcbByXExport(cbMhVo), "sheet");
        try {
            ExportExcelUtil.exportExcel(response, fileName, data);
        } catch (Exception e) {

        }
    }

    //查询设备财务直接成本信息列表
    @RequestMapping(value = "/listJjcb")
    public Result listJjcb(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                           @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize,
                           @RequestParam(name = "qssj",required = false) String qssj) throws ParseException {
        Date qs=null;
        Date js=null;
        if(StringUtils.isNotBlank(qssj)){
            String[] split = qssj.split("~");
            if(split.length==2){
                qs= String2DateUtil.StringtoDateOnlyYear(split[0]);
                js= String2DateUtil.StringtoDateOnlyYear(split[1]);
            }
        }
        else{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
            qs=calendar.getTime();
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTime(new Date());
            calendar2.set(Calendar.DAY_OF_MONTH, calendar2.getActualMaximum(Calendar.DAY_OF_MONTH));
            js=calendar2.getTime();
            String s = sdf.format(qs);
            qs=sdf.parse(s);
            String s2 = sdf.format(js);
            js=sdf.parse(s2);


        }
        return Result.success(sbcwService.listJjcb(pageNum,pageSize,qs,js));
    }

    //查询设备直接成本列表根据条件查询
    @RequestMapping(value = "/listJjcbByX")
    public Result listJjcbByX(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                              @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize,
                              CbMhVo cbMhVo) throws ParseException {

        return Result.success(sbcwService.listJjcbByX(pageNum,pageSize,cbMhVo));
    }

    //导出 excell设备间接成本列表
    @RequestMapping(value = "/listJjcbByXExport", method = RequestMethod.GET)
    public void listJjcbByXExport(CbMhVo cbMhVo, HttpServletResponse response,
                                  @RequestParam(value = "fileName", required = true) String fileName) {

        List<String> titles = Arrays.asList(new ExcelData().getFiledName(JjcbVo.class));
        ExcelData data = new ExcelData(titles, sbcwService.listJjcbByXExport(cbMhVo), "sheet");
        try {
            ExportExcelUtil.exportExcel(response, fileName, data);
        } catch (Exception e) {

        }
    }

    //查询设备财务收入信息列表
    @RequestMapping(value = "/listSr")
    public Result listSr(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                           @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize,
                           @RequestParam(required = false) String qssj
                         ) throws ParseException {
        Date qs=null;
        Date js=null;
        if(StringUtils.isNotBlank(qssj)){
            String[] split = qssj.split("~");
            if(split.length==2){
                qs= String2DateUtil.StringtoDateOnlyYear(split[0]);
                js= String2DateUtil.StringtoDateOnlyYear(split[1]);
            }
        }
        else{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
            qs=calendar.getTime();
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTime(new Date());
            calendar2.set(Calendar.DAY_OF_MONTH, calendar2.getActualMaximum(Calendar.DAY_OF_MONTH));
            js=calendar2.getTime();
            String s = sdf.format(qs);
            qs=sdf.parse(s);
            String s2 = sdf.format(js);
            js=sdf.parse(s2);


        }
        return Result.success(sbcwService.listSr(pageNum,pageSize,qs,js));
    }

    //查询设备直收入信息列表根据条件查询
    @RequestMapping(value = "/listSrByX")
    public Result listSrByX(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                              @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize,
                              CbMhVo cbMhVo){

        return Result.success(sbcwService.listSrByX(pageNum,pageSize,cbMhVo));
    }

    //导出 excell设备收入列表
    @RequestMapping(value = "/listSrByXExport", method = RequestMethod.GET)
    public void listSrByXExport(CbMhVo cbMhVo, HttpServletResponse response,
                                  @RequestParam(value = "fileName", required = true) String fileName) {

        List<String> titles = Arrays.asList(new ExcelData().getFiledName(SrVo.class));
        ExcelData data = new ExcelData(titles, sbcwService.listSrByXExport(cbMhVo), "sheet");
        try {
            ExportExcelUtil.exportExcel(response, fileName, data);
        } catch (Exception e) {

        }
    }

    //查询设备效益分析列表
    @RequestMapping(value = "/listXyFx")
    public Result listXyFx(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                         @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize,
                         @RequestParam(required = false) String qssj
                           ) throws ParseException {
        Date qs=null;
        Date js=null;
        if(StringUtils.isNotBlank(qssj)){
            String[] split = qssj.split("~");
            if(split.length==2){
                qs= String2DateUtil.StringtoDateOnlyYear(split[0]);
                js= String2DateUtil.StringtoDateOnlyYear(split[1]);
            }
        }
        else{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
            qs=calendar.getTime();
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTime(new Date());
            calendar2.set(Calendar.DAY_OF_MONTH, calendar2.getActualMaximum(Calendar.DAY_OF_MONTH));
            js=calendar2.getTime();
            String s = sdf.format(qs);
            qs=sdf.parse(s);
            String s2 = sdf.format(js);
            js=sdf.parse(s2);


        }
        return Result.success(sbcwService.listXyFx(pageNum,pageSize,qs,js));
    }

    //查询设备效益分析列表根据条件查询
    @RequestMapping(value = "/listXyFxByX")
    public Result listXyFxByX(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                            @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize,
                            CbMhVo cbMhVo){

        return Result.success(sbcwService.listXyFxByX(pageNum,pageSize,cbMhVo));
    }

    //导出 excell设备效益分析列表
    @RequestMapping(value = "/listXyFxByXExport", method = RequestMethod.GET)
    public void listXyFxByXExport(CbMhVo cbMhVo, HttpServletResponse response,
                                @RequestParam(value = "fileName", required = true) String fileName) {

        List<String> titles = Arrays.asList(new ExcelData().getFiledName(XyFxVo.class));
        ExcelData data = new ExcelData(titles, sbcwService.listXyFxByXExport(cbMhVo), "sheet");
        try {
            ExportExcelUtil.exportExcel(response, fileName, data);
        } catch (Exception e) {

        }
    }

    @RequestMapping(value = "/listXyPj")
    public Result listXyPj(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                           @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize,
                           @RequestParam(required = false) String qssj
                           ) throws ParseException {
        Date qs=null;
        Date js=null;
        if(StringUtils.isNotBlank(qssj)){
            String[] split = qssj.split("~");
            if(split.length==2){
                qs= String2DateUtil.StringtoDateOnlyYear(split[0]);
                js= String2DateUtil.StringtoDateOnlyYear(split[1]);
            }
        }
        else{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
            qs=calendar.getTime();
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTime(new Date());
            calendar2.set(Calendar.DAY_OF_MONTH, calendar2.getActualMaximum(Calendar.DAY_OF_MONTH));
            js=calendar2.getTime();
            String s = sdf.format(qs);
            qs=sdf.parse(s);
            String s2 = sdf.format(js);
            js=sdf.parse(s2);


        }
        return Result.success(sbcwService.listXyPj(pageNum,pageSize,qs,js));
    }

    //查询设备评价信息列表根据条件查询
    @RequestMapping(value = "/listXyPjByX")
    public Result listXyPjByX(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                              @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize,
                              CbMhVo cbMhVo){

        return Result.success(sbcwService.listXyPjByX(pageNum,pageSize,cbMhVo));
    }

    //导出 excell设备效益分析列表
    @RequestMapping(value = "/listXyPjByXExport", method = RequestMethod.GET)
    public void listXyPjByXExport(CbMhVo cbMhVo, HttpServletResponse response,
                                  @RequestParam(value = "fileName", required = true) String fileName) {

        List<String> titles = Arrays.asList(new ExcelData().getFiledName(XyPjVo.class));
        ExcelData data = new ExcelData(titles, sbcwService.listXyPjByXExport(cbMhVo), "sheet");
        try {
            ExportExcelUtil.exportExcel(response, fileName, data);
        } catch (Exception e) {

        }
    }


}

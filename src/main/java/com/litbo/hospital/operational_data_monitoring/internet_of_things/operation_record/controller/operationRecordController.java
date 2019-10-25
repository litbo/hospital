package com.litbo.hospital.operational_data_monitoring.internet_of_things.operation_record.controller;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.lifemanage.MyUtils.String2DateUtil;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.operation_record.service.InspectdetailService;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.operation_record.service.InspectdetailbackService;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.operation_record.vo.OperationRecord;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.operation_record.vo.SearchVO;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.operation_record.vo.WorkTimeVO;
import com.litbo.hospital.result.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.operational_data_monitoring.internet_of_things.operation_record.controller
 * @Author: looli
 * @CreateTime: 2019-08-07 10:10
 * @Description: 运行记录相关操作
 */
@RestController
@RequestMapping("/operationRecord")
public class operationRecordController {
    @Autowired
    private InspectdetailService inspectdetailService;
    @Autowired
    private InspectdetailbackService inspectdetailbackService;

    /**
     * 显示设备详细运行记录
     * <p>
     * 当天   ： 显示当天数据
     * 非当天 ： 显示选择的时间范围的数据
     *
     * @param pageNum
     * @param pageSize
     * @param searchVO
     * @return
     */
    @RequestMapping("/show1")
    public Result show1(@RequestParam(required = false, defaultValue = "1") Integer pageNum,
                        @RequestParam(required = false, defaultValue = "10") Integer pageSize,
                        SearchVO searchVO) {
        //排除空串影响
        if (searchVO.getEqSbbh() != null) {
            if ("".equals(searchVO.getEqSbbh())) {
                searchVO.setEqSbbh(null);
            }
        }
        if (searchVO.getBmId() != null) {
            if ("".equals(searchVO.getBmId())) {
                searchVO.setBmId(null);
            }
        }
        if (searchVO.getMacid() != null) {
            if ("".equals(searchVO.getMacid())) {
                searchVO.setMacid(null);
            }
        }
        if (searchVO.getDate1() != null) {
            if (!searchVO.getDate1().equals("")) {
                searchVO.setBeginTime(searchVO.getDate1().substring(0, searchVO.getDate1().indexOf(" ~ ")));
                searchVO.setEndTime(searchVO.getDate1().substring(searchVO.getDate1().indexOf(" ~ ") + 3,
                        searchVO.getDate1().length()));
            }
        }
        //获取当前时间
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = dateFormat.format(new Date());
        //1.如果没有起始时间和结束时间 默认的情况
        if (searchVO.getBeginTime() == null || searchVO.getBeginTime().equals("") ||
                searchVO.getEndTime() == null || searchVO.getEndTime().equals("") ||
                (searchVO.getBeginTime().equals(searchVO.getEndTime()) && searchVO.getBeginTime().equals(format))) {//判断范围 如果起始时间和终止时间都等于今天，显示今天的数据
            //2.显示当天数据
            searchVO.setNowadays(format);
            //3.返回当天使用情况记录
            System.out.println(searchVO);
            return Result.success(inspectdetailService.showNow(pageNum, pageSize, searchVO));
        } else {//4.非当天，显示所选范围的数据
            System.out.println(searchVO);
            PageInfo show = inspectdetailbackService.show(pageNum, pageSize, searchVO);
            return Result.success(show);
        }
    }

    /**
     * 显示设备原始记录
     *
     * @param pageNum
     * @param pageSize
     * @param searchVO
     * @return
     */
    @RequestMapping("/show2")
    public Result show2(@RequestParam(required = false, defaultValue = "1") Integer pageNum,
                        @RequestParam(required = false, defaultValue = "10") Integer pageSize,
                        SearchVO searchVO) {
        if (searchVO.getEqSbbh() != null) {
            if ("".equals(searchVO.getEqSbbh())) {
                searchVO.setEqSbbh(null);
            }
        }
        if (searchVO.getBmId() != null) {
            if ("".equals(searchVO.getBmId())) {
                searchVO.setBmId(null);
            }
        }
        if (searchVO.getMacid() != null) {
            if ("".equals(searchVO.getMacid())) {
                searchVO.setMacid(null);
            }
        }
        if (searchVO.getDate1() != null) {
            if (!searchVO.getDate1().equals("")) {
                searchVO.setBeginTime(searchVO.getDate1().substring(0, searchVO.getDate1().indexOf(" ~ ")));
                searchVO.setEndTime(searchVO.getDate1().substring(searchVO.getDate1().indexOf(" ~ ") + 3,
                        searchVO.getDate1().length()));
            }
        }
        //1.获取当前时间
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = dateFormat.format(new Date());
        System.out.println(searchVO);
        System.out.println(format);
        //2.如果没有起始时间和结束时间
        if (searchVO.getBeginTime() == null || searchVO.getBeginTime().equals("") ||
                searchVO.getEndTime() == null || searchVO.getEndTime().equals("") ||
                (searchVO.getBeginTime().equals(searchVO.getEndTime())
                        && searchVO.getBeginTime().equals(format))) {//判断范围 如果起始时间和终止时间都等于今天，显示今天的数据
            //3.显示当天数据
            searchVO.setNowadays(format);
            //4.返回当天使用情况记录
            System.out.println("1---------------");
            System.out.println(searchVO);
            return Result.success(inspectdetailService.showNow2(pageNum, pageSize, searchVO));
        } else {//非当天，显示所选范围的时间
            System.out.println("2---------------");
            System.out.println(searchVO);
            PageInfo show = inspectdetailbackService.show2(pageNum, pageSize, searchVO);
            return Result.success(show);
        }
    }

    /**
     * 显示单机运行设备
     * 日
     * 今日
     * 其他时间
     * 月
     * 选择月份（本月不包括今天）
     * 年
     * 选择年份（本年不包括今天）
     *
     * @param pageNum
     * @param pageSize
     * @param searchVO
     * @return
     */
    @RequestMapping("/show3")
    public Result show3(@RequestParam(required = false, defaultValue = "1") Integer pageNum,
                        @RequestParam(required = false, defaultValue = "10") Integer pageSize,
                        SearchVO searchVO) {
        //初始化类型
        if (searchVO.getType() == null || searchVO.getType().equals("")) {
            searchVO.setType("1");
        }
        //排除空串影响
        if (searchVO.getPym() != null) {
            if ("".equals(searchVO.getPym())) {
                searchVO.setPym(null);
            }
        }
        if (searchVO.getBmId() != null) {
            if ("".equals(searchVO.getBmId())) {
                searchVO.setBmId(null);
            }
        }
        //日期格式处理
        if (searchVO.getDate1() != null) {
            if (searchVO.getType().equals("1")) {
                if (StringUtils.isNotBlank(searchVO.getDate1())) {
                    searchVO.setBeginTime(searchVO.getDate1().substring(0, searchVO.getDate1().indexOf(" ~ ")));
                    searchVO.setEndTime(searchVO.getDate1().substring(searchVO.getDate1().indexOf(" ~ ") + 3,
                            searchVO.getDate1().length()));
                }

            }
            if (searchVO.getType().equals("2")) {
                searchVO.setBeginTime(searchVO.getDate1().substring(0, 7));
                searchVO.setEndTime(searchVO.getDate1().substring(searchVO.getDate1().indexOf(" ~ ") + 3,
                        searchVO.getDate1().length() - 3));
            }
            if (searchVO.getType().equals("3")) {
                searchVO.setBeginTime(searchVO.getDate1().substring(0, 4));
                searchVO.setEndTime(searchVO.getDate1().substring(13,
                        searchVO.getDate1().length() - 6));
            }
        }
        //1.2.获取当前时间
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = dateFormat.format(new Date());
        //1.按日统计
        if ("1".equals(searchVO.getType())) {
            if (searchVO.getBeginTime() == null || searchVO.getBeginTime().equals("") ||
                    searchVO.getEndTime() == null || searchVO.getEndTime().equals("") ||
                    (searchVO.getBeginTime().equals(searchVO.getEndTime()) && searchVO.getBeginTime().equals(format))) {
                //1.1.显示当天数据
                searchVO.setNowadays(format);
                //1.3.返回当天使用情况记录
                PageInfo pageInfo = inspectdetailService.showNow3(pageNum, pageSize, searchVO);
                return Result.success(pageInfo);
            } else {//1.4非当天，显示所选时间的数据
                PageInfo show = inspectdetailbackService.show3(pageNum, pageSize, searchVO);
                return Result.success(show);
            }
        }
        //2.按月统计
        if ("2".equals(searchVO.getType())) {
            System.out.println(searchVO);
            PageInfo pageInfo = inspectdetailbackService.show31(pageNum, pageSize, searchVO);
            return Result.success(pageInfo);
        }
        //3.按年统计
        if ("3".equals(searchVO.getType())) {
            System.out.println(searchVO);
            PageInfo pageInfo = inspectdetailbackService.show32(pageNum, pageSize, searchVO);
            return Result.success(pageInfo);
        }
        return Result.error();
    }

    /**
     * 显示科室使用设备信息
     *
     * @param pageNum
     * @param pageSize
     * @param searchVO
     * @return
     */
    @RequestMapping("/show4")
    public Result show4(@RequestParam(required = false, defaultValue = "1") Integer pageNum,
                        @RequestParam(required = false, defaultValue = "10") Integer pageSize,
                        SearchVO searchVO) {
        //初始化类型
        if (searchVO.getType() == null || searchVO.getType().equals("")) {
            searchVO.setType("1");
        }
        //排除空串影响
        if (searchVO.getPym() != null) {
            if ("".equals(searchVO.getPym())) {
                searchVO.setPym(null);
            }
        }
        if (searchVO.getBmId() != null) {
            if ("".equals(searchVO.getBmId())) {
                searchVO.setBmId(null);
            }
        }
        //日期格式处理
        if (searchVO.getDate1() != null) {
            if (!searchVO.getDate1().equals("")) {
                if (searchVO.getType().equals("1")) {
                    searchVO.setBeginTime(searchVO.getDate1().substring(0, searchVO.getDate1().indexOf(" ~ ")));
                    searchVO.setEndTime(searchVO.getDate1().substring(searchVO.getDate1().indexOf(" ~ ") + 3,
                            searchVO.getDate1().length()));
                }
                if (searchVO.getType().equals("2")) {
                    searchVO.setBeginTime(searchVO.getDate1().substring(0, 7));
                    searchVO.setEndTime(searchVO.getDate1().substring(searchVO.getDate1().indexOf(" ~ ") + 3,
                            searchVO.getDate1().length() - 3));
                }
                if (searchVO.getType().equals("3")) {
                    searchVO.setBeginTime(searchVO.getDate1().substring(0, 4));
                    searchVO.setEndTime(searchVO.getDate1().substring(13,
                            searchVO.getDate1().length() - 6));
                }
            }
        }
        //1.2.获取当前时间
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = dateFormat.format(new Date());
        //1.按日统计
        if ("1".equals(searchVO.getType())) {
            if (searchVO.getBeginTime() == null || searchVO.getBeginTime().equals("") ||
                    searchVO.getEndTime() == null || searchVO.getEndTime().equals("") ||
                    (searchVO.getBeginTime().equals(searchVO.getEndTime()) && searchVO.getBeginTime().equals(format))) {
                //1.1.显示当天数据
                searchVO.setNowadays(format);
                //1.3.返回当天使用情况记录
                PageInfo pageInfo = inspectdetailService.showNow4(pageNum, pageSize, searchVO);
                return Result.success(pageInfo);
            } else {//1.4非当天，显示所选时间的数据
                PageInfo show = inspectdetailbackService.show4(pageNum, pageSize, searchVO);
                return Result.success(show);
            }
        }
        //2.按月统计
        if ("2".equals(searchVO.getType())) {
            System.out.println("2");
            System.out.println(searchVO);
            PageInfo pageInfo = inspectdetailbackService.show41(pageNum, pageSize, searchVO);
            return Result.success(pageInfo);
        }
        //3.按年统计
        if ("3".equals(searchVO.getType())) {
            System.out.println("3");
            System.out.println(searchVO);
            PageInfo pageInfo = inspectdetailbackService.show42(pageNum, pageSize, searchVO);
            return Result.success(pageInfo);
        }
        return Result.error();
    }

    @RequestMapping("/showAllYlxNewYxjl")
    public Result showAllYlxNewYxjl(@RequestParam(required = false, defaultValue = "1") Integer pageNum,
                                    @RequestParam(required = false, defaultValue = "10") Integer pageSize
                                    , @RequestParam(required = false, name = "qssj") String qssj,
                                    @RequestParam(required = false, name = "zcbh") String zcbh,
                                    @RequestParam(required = false, name = "bmid") String bmid,
                                    @RequestParam(required = false, name = "eqSName") String eqSName,
                                    @RequestParam(required = false, name = "bmName") String bmName
                                    ) {
        PageInfo info=null;

        Date qs =null;
        Date js=null;
        if(StringUtils.isNotBlank(qssj)){
            String[] split = qssj.split("\\~");
            if(split.length>1){
                if(split[0].length()>6){
                    qs = String2DateUtil.StringtoDateSfm(split[0]);
                    js = String2DateUtil.StringtoDateSfm(split[1]);
                }
                else{
                    qs = String2DateUtil.StringtoDateOnlyYear(split[0]);
                    js = String2DateUtil.StringtoDateOnlyYear(split[1]);
                }
            }
        }
        if(StringUtils.isBlank(bmid)&&StringUtils.isNotBlank(bmName)){
        info = inspectdetailService.showAllYlxNewYxjl2(pageNum, pageSize, qs, js, zcbh, bmName,eqSName);

        }
        else{
            info = inspectdetailService.showAllYlxNewYxjl(pageNum, pageSize, qs, js, zcbh, bmid);
        }
        return Result.success(info);
    }


    @RequestMapping("/showOnelYlxYxjl")
    public Result showOnelYlxYxjl(@RequestParam(required = false, defaultValue = "1") Integer pageNum,
                                    @RequestParam(required = false, defaultValue = "10") Integer pageSize
                         ,@RequestParam( name = "lwybh") String lwybh

    ) {
        PageInfo<OperationRecord> info = inspectdetailService.showOnelYlxYxjl(pageNum, pageSize, lwybh);
        return Result.success(info);
    }
    @RequestMapping("/showOnelYlxYxjl2")
    public Result showOnelYlxYxjl2(@RequestParam(required = false, defaultValue = "1") Integer pageNum,
                                  @RequestParam(required = false, defaultValue = "10") Integer pageSize
            ,@RequestParam( name = "lwybh") String lwybh,
            @RequestParam( name = "time",defaultValue = "月") String time,
            @RequestParam( name = "qssj",defaultValue = "") String qssj

                                   ) {
        SimpleDateFormat yyyy = new SimpleDateFormat("yyyy");
        SimpleDateFormat ym = new SimpleDateFormat("yyyy-MM");
        if(time.equals("年")){
            if(qssj.length()>11){
                qssj="";
            }
        }
        if(time.equals("月")){
            if(qssj.length()<12){
                qssj="";
            }
        }
        Date qs=null;
        Date js=null;
        if(StringUtils.isNotBlank(qssj)){
            String[] split = qssj.split("\\~");
            if(split.length>1){
                if(split[0].length()>6){
                    if(split[0].length()<9){

                        try {
                            qs=ym.parse(split[0]) ;
                            js=ym.parse(split[1]) ;
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }
                    else{
                        qs = String2DateUtil.StringtoDateSfm(split[0]);
                        js = String2DateUtil.StringtoDateSfm(split[1]);
                    }

                }
                else{
                    qs = String2DateUtil.StringtoDateOnlyYear(split[0]);
                    js = String2DateUtil.StringtoDateOnlyYear(split[1]);
                }
            }
        }

        PageInfo info = inspectdetailService.showOnelYlxYxjl2(pageNum, pageSize, lwybh,time);
        List<WorkTimeVO> list = info.getList();
        Date qs2=qs;
        Date js2=js;
       if(time.equals("年") &&StringUtils.isNotBlank(qssj)){
           list.removeIf(item->{
               try {
                   if(yyyy.parse(item.getDatetime()).getTime()>=qs2.getTime()&&
                           yyyy.parse(item.getDatetime()).getTime()<=js2.getTime()){
                       return false;
                   }
               } catch (Exception e) {
                   e.printStackTrace();
               }
               return true;

           });
       }
       else if(time.equals("月") &&StringUtils.isNotBlank(qssj)){
            list.removeIf(item->{
                try {
                    if(ym.parse(item.getDatetime()).getTime()>=qs2.getTime()&&
                            ym.parse(item.getDatetime()).getTime()<=js2.getTime()){
                        return false;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return true;

            });
        }
        return Result.success(info);
    }


    @RequestMapping("/showAllYxhjNewYxjl")
    public Result showAllYxhjNewYxjl(@RequestParam(required = false, defaultValue = "1") Integer pageNum,
                                    @RequestParam(required = false, defaultValue = "10") Integer pageSize
            , @RequestParam(required = false, name = "qssj") String qssj,
                                    @RequestParam(required = false, name = "zcbh") String zcbh,
                                    @RequestParam(required = false, name = "bmid") String bmid) {
        Date qs =null;
        Date js=null;
        if(StringUtils.isNotBlank(qssj)){
            String[] split = qssj.split("\\~");
            if(split.length>1){
                qs = String2DateUtil.StringtoDateSfm(split[0]);
                js = String2DateUtil.StringtoDateSfm(split[1]);
            }
        }
        PageInfo<OperationRecord> info = inspectdetailService.showAllYxhjNewYxjl(pageNum, pageSize, qs, js, zcbh, bmid);
        return Result.success(info);
    }


    @RequestMapping("/showOnelYxhjYxjl")
    public Result showOnelYxhjYxjl(@RequestParam(required = false, defaultValue = "1") Integer pageNum,
                                  @RequestParam(required = false, defaultValue = "10") Integer pageSize
            ,@RequestParam( name = "lwybh") String lwybh) {
        PageInfo<OperationRecord> info = inspectdetailService.showOnelYlxYxjl(pageNum, pageSize, lwybh);
        return Result.success(info);
    }




}

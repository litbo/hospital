package com.litbo.hospital.supervise.controller;


import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.common.utils.poi.ImportExcelUtil;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.supervise.bean.KaoqinVO;
import com.litbo.hospital.supervise.bean.PbJhVO;
import com.litbo.hospital.supervise.service.PbService;
import com.litbo.hospital.supervise.vo.RyVos;
import com.litbo.hospital.supervise.vo.getPbPlanVos;
import com.litbo.hospital.user.bean.EqFj;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.*;
import java.lang.reflect.Method;
import java.util.*;

import static com.litbo.hospital.common.utils.poi.ListToListMap.listToMap;
import static com.litbo.hospital.common.utils.poi.ListToListMap.parseMap2Object;

@Controller
@ResponseBody
@RequestMapping("/pb")
public class PbController {

    @Autowired
    private PbService pbService;
    @RequestMapping("/pbPlan")
    public Result pbPlan( PbJhVO pbJhVO){
        if (pbJhVO.getUserId()==null){
            return Result.error("人員為空");
        }else {
            pbService.addPbPlan(pbJhVO);

        }
        return Result.success();
    }

    @RequestMapping("getPbPlan")
    public Result getPbPlan(@RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
                            @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize){
        List<getPbPlanVos> pbPlanVosList = pbService.getPbPlan(pageNum,pageSize);
        if(pbPlanVosList!=null){
            return Result.success(new PageInfo(pbPlanVosList));
        }else{
            return Result.error("没有值班计划,请添加!");
        }
    }

    @RequestMapping("/getBmPeople")
    public Result getBmpeople(@RequestParam("bmId") String bmId,
                                @RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
                                @RequestParam(value = "pageSize", required = false, defaultValue = "15") int pageSize){
        System.out.println(bmId);
        String str = bmId.replaceAll("\\\"", "");
        return  Result.success(pbService.getBmpeople(str,pageNum,pageSize));

    }

    @RequestMapping("/getPbPeople")
    public Result getPbPeople(@RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
                              @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize,
                              @RequestParam("pbJhid") String id, HttpSession session)
    {
        session.setAttribute("pb_id",id);
        System.out.println("点击考勤是的id"+session.getAttribute("pb_id").toString());
        List<RyVos> ryVos = pbService.getPbPeople(pageNum,pageSize,id);
        if(ryVos!=null){
            return Result.success(new PageInfo(ryVos));
        }else{
            return Result.error("没有值班人员,请添加!");
        }
    }

    @RequestMapping("/ghPeople")
    public Result ghPeople(@RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
                              @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize,
                              HttpSession session)
    {
        String sid = session.getAttribute("pb_id").toString();
        System.out.println("点击更换时的id"+sid);
        List<RyVos> ryVos = pbService.ghPeople(pageNum,pageSize,sid);
        if(ryVos!=null){
            return Result.success(new PageInfo(ryVos));
        }else{
            return Result.error("没有值班人员,请添加!");
        }
    }



    @PostMapping(value = "/importKaoqin")
    public Integer importExcel(@RequestParam("file") MultipartFile file) {
        Workbook workbook = null;
        InputStream inputStream = null;
        List<Integer> ids = new ArrayList<>();

        try {
            inputStream = new ByteArrayInputStream(file.getBytes());
            workbook = WorkbookFactory.create(inputStream);
            inputStream.close();
            //工作表对象
            Sheet sheetAt = workbook.getSheetAt(0);
            Row row = sheetAt.getRow(0);
            int startRow = 1;
            int rowNum = sheetAt.getLastRowNum() + 1;
            short cellNum = row.getLastCellNum();
            /*int rowIsNull = getRowIsNull(row, rowNum);
            System.out.println(rowIsNull);*/
            List<String> list = ImportExcelUtil.readTitlesToExcel(workbook, sheetAt, row, cellNum);
            List<List<Object>> lists = ImportExcelUtil.readRowsToExcel(workbook, sheetAt, row, rowNum, ids, startRow);

            List<Map<String, Object>> mapList = listToMap(lists, list);
            for (Map<String, Object> map : mapList) {

                List<String> resultList = new ArrayList<>(); //存放excle表中一行的数据
                for (Map.Entry<String, Object> en : map.entrySet()) {
                    resultList.add(en.getValue().toString());
//                    System.out.println("Key = " + en.getKey() + ", Value = " + en.getValue());
                    System.out.println(en.getValue());
                }

                KaoqinVO kaoqinVO1 = new KaoqinVO();  //考勤表从excle一行的值读入，对象设置属性
                kaoqinVO1.setUserId(resultList.get(0));
                kaoqinVO1.setUserName(resultList.get(1));
                kaoqinVO1.setKaoQin(resultList.get(2));

                System.out.println("aaaaabnn");
                System.out.println(kaoqinVO1);
                pbService.insertKaoqin(kaoqinVO1);
            }


        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
        return 1;
    }



}

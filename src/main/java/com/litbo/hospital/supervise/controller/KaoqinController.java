package com.litbo.hospital.supervise.controller;

import com.litbo.hospital.common.utils.poi.ImportExcelUtil;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.supervise.bean.KaoqinVO;
import com.litbo.hospital.supervise.service.KaoqinService;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.litbo.hospital.common.utils.poi.ListToListMap.listToMap;

@Controller
@ResponseBody
@RequestMapping("/kaoqin")
public class KaoqinController {

    @Autowired
     KaoqinService kaoqinService;

    @PostMapping(value = "/importKaoqin")  //导入考勤excle表
    public Integer importExcel(@RequestParam("file") MultipartFile file) {
        kaoqinService.delKaoqin();
        Workbook workbook = null;
        InputStream inputStream = null;
        List<Integer> ids = new ArrayList<>();

        try {
            inputStream = new ByteArrayInputStream(file.getBytes());
            workbook = WorkbookFactory.create(inputStream);
            System.out.println("workBook"+workbook);
            inputStream.close();
            //工作表对象
            Sheet sheetAt = workbook.getSheetAt(0);
//            System.out.println("sheetAt"+sheetAt);
            Row row = sheetAt.getRow(0);
            int startRow = 1;
            int rowNum = sheetAt.getLastRowNum() + 1;
            short cellNum = row.getLastCellNum();
            /*int rowIsNull = getRowIsNull(row, rowNum);
            System.out.println(rowIsNull);*/
            List<String> list = ImportExcelUtil.readTitlesToExcel(workbook, sheetAt, row, cellNum);
//            System.out.println("List"+list);
            List<List<Object>> lists = ImportExcelUtil.readRowsToExcel(workbook, sheetAt, row, rowNum, ids, startRow);

            List<Map<String, Object>> mapList = listToMap(lists, list);
            if (mapList.size()>0){
                for (Map<String, Object> map : mapList) {

                    List<String> resultList = new ArrayList<>(); //存放excle表中一行的数据
                    for (Map.Entry<String, Object> en : map.entrySet()) {
                        resultList.add(en.getValue().toString());
//                    System.out.println("Key = " + en.getKey() + ", Value = " + en.getValue());
                        System.out.println(en.getValue());
                    }

                    KaoqinVO kaoqinVO1 = new KaoqinVO();  //考勤表从excle一行的值读入，对象设置属性
                    kaoqinVO1.setUserId(resultList.get(1));
                    kaoqinVO1.setUserName(resultList.get(4));
                    kaoqinVO1.setKaoQin(resultList.get(3));
                    kaoqinVO1.setZhengChang(resultList.get(0));
                    kaoqinVO1.setQueQin(resultList.get(2));
//                    kaoqinVO1.setDay1(resultList.get(2));
//                    kaoqinVO1.setDay2(resultList.get(3));
//                    kaoqinVO1.setDay3(resultList.get(4));
//                    kaoqinVO1.setDay4(resultList.get(5));
//                    kaoqinVO1.setDay5(resultList.get(6));
//                    kaoqinVO1.setDay5(resultList.get(7));
//                    kaoqinVO1.setDay7(resultList.get(8));
//                    kaoqinVO1.setDay8(resultList.get(9));
//                    kaoqinVO1.setDay9(resultList.get(10));
//                    kaoqinVO1.setDay10(resultList.get(11));
//                    kaoqinVO1.setDay11(resultList.get(12));
//                    kaoqinVO1.setDay12(resultList.get(13));
//                    kaoqinVO1.setDay13(resultList.get(14));
//                    kaoqinVO1.setDay14(resultList.get(15));
//                    kaoqinVO1.setDay15(resultList.get(16));
//                    kaoqinVO1.setDay16(resultList.get(17));
//                    kaoqinVO1.setDay17(resultList.get(18));
//                    kaoqinVO1.setDay18(resultList.get(19));
//                    kaoqinVO1.setDay19(resultList.get(20));
//                    kaoqinVO1.setDay20(resultList.get(21));
//                    kaoqinVO1.setDay21(resultList.get(22));
//                    kaoqinVO1.setDay22(resultList.get(23));
//                    kaoqinVO1.setDay23(resultList.get(24));
//                    kaoqinVO1.setDay24(resultList.get(25));
//                    kaoqinVO1.setDay25(resultList.get(26));
//                    kaoqinVO1.setDay26(resultList.get(27));
//                    kaoqinVO1.setDay27(resultList.get(28));
//                    kaoqinVO1.setDay28(resultList.get(29));
//                    kaoqinVO1.setDay29(resultList.get(30));
//                    kaoqinVO1.setDay30(resultList.get(31));
//                    kaoqinVO1.setDay31(resultList.get(32));

                    System.out.println("aaaaabnn");
                    System.out.println(kaoqinVO1);
                    kaoqinService.insertKaoqin(kaoqinVO1);
                }
            }



        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
        return 1;
    }

    @RequestMapping("listKaoqin")  //考勤列表
    public Result listKaoqin(@RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
                             @RequestParam(value = "pageSize", required = false, defaultValue = "15") int pageSize){
        System.out.println("调用列表");
        return Result.success( kaoqinService.listKaoqin(pageNum,pageSize));
    }


}

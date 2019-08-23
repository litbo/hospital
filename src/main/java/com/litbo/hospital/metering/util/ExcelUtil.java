package com.litbo.hospital.metering.util;

import com.alibaba.fastjson.JSONObject;
import com.litbo.hospital.common.utils.poi.ImportExcelUtil;
import com.litbo.hospital.user.bean.EqInfo;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.litbo.hospital.common.utils.poi.ListToListMap.listToMap;
import static com.litbo.hospital.common.utils.poi.ListToListMap.parseMap2Object;

/**
 * @Author: 樊小铭
 * Date: 2019/8/22 16:08
 * @Version:
 * @Description:
 */
public class ExcelUtil extends ImportExcelUtil {

    public static List importExcelContent(String filepath){

        File file = new File(filepath);
        Workbook workbook = null;
        InputStream inputStream = null;
        List<Integer> ids = new ArrayList<>();
        ids.add(6);
        ids.add(7);
        ids.add(10);
        ids.add(18);
        ids.add(19);
        ids.add(23);

        try {
            inputStream = new FileInputStream(file);
            workbook = WorkbookFactory.create(inputStream);
            inputStream.close();
            //工作表对象
            //获取第几个工作表
            Sheet sheetAt = workbook.getSheetAt(0);
            //获取表头
            Row row = sheetAt.getRow(2);
            //设置从第几行开始读取数据(表头所在行数)
            int startRow=3;
            //设置总行数
            int rowNum = sheetAt.getLastRowNum()+1;
            short cellNum = row.getLastCellNum();
            /*int rowIsNull = getRowIsNull(row, rowNum);
            System.out.println(rowIsNull);*/
            List<String> list = readTitlesToExcel(workbook, sheetAt,row,cellNum);
            List<List<Object>> lists = readRowsToExcel(workbook, sheetAt, row, rowNum,ids,startRow);
            System.out.println(list);

//
//            for (List<Object> objectList : lists) {
//                System.out.println(objectList);
////                System.out.println(JSONObject.toJSON(objectList));
//            }


//            System.out.println(listToMap(lists, list));
//            List<Map<String, Object>> mapList = listToMap(lists, list);
//            for (Map<String, Object> map : mapList) {
//                EqInfo user = parseMap2Object(map, EqInfo.class);
//                System.out.println(user);
//            }

            return lists;

        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) {
        System.out.println(importExcelContent("C:\\Users\\wang\\Desktop\\测试数据.xlsx"));


    }

}

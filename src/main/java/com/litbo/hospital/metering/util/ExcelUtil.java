package com.litbo.hospital.metering.util;

import com.alibaba.fastjson.JSONObject;
import com.litbo.hospital.common.utils.poi.ImportExcelUtil;
import com.litbo.hospital.user.bean.EqInfo;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author: 樊小铭
 * Date: 2019/8/22 16:08
 * @Version:
 * @Description:
 */
public class ExcelUtil extends ImportExcelUtil {

    public List<List<Object>> importContent(Workbook wb, Sheet sheetAt,Row row,int rowNum , List<Integer> ids,int startRow){
        short cellNum = row.getLastCellNum();
        Cell cell = null;
        List list = new ArrayList<>();
        for (int i = startRow;i<rowNum;i++){
            ArrayList<String> rowList = new ArrayList<>();
            row = sheetAt.getRow(i);
            if(row==null){
                continue;
            }
            label1: for( int j = 0 ;j<cellNum;j++){

                cell = row.getCell(j);
                for (Integer id : ids) {
                    if (j == id) {
                        if (cell != null&&cell.getCellType()!= HSSFCell.CELL_TYPE_BLANK) {
                            cell.setCellType(1);
                            String stringCellValue = cell.getStringCellValue();
                            Calendar calendar = new GregorianCalendar(1900, 0, -1);
                            Date d = calendar.getTime();
                            Date dd = DateUtils.addDays(d, Integer.parseInt(stringCellValue));
                            String ddd = (new SimpleDateFormat("yyyy-MM-dd")).format(dd);
                            rowList.add(ddd);
                            continue label1;
                        }
                    }
                }





                if(cell == null||cell.getCellType()==HSSFCell.CELL_TYPE_BLANK){
                    rowList.add("");
                    continue;
                }
                cell.setCellType(1);
                String cellValue = cell.getStringCellValue();

                //System.out.println(cellValue);
                rowList.add(cellValue);

            }

            list.add(rowList);
        }
        return list;
    }


    public static List importExcelContent(String filepath){

        File file = new File(filepath);
        Workbook workbook = null;
        InputStream inputStream = null;
        List<Integer> ids = new ArrayList<>();
//        ids.add(6);
//        ids.add(7);
//        ids.add(10);
//        ids.add(18);
//        ids.add(19);
//        ids.add(23);

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
            int startRow=2;
            //设置总行数
            int rowNum = sheetAt.getLastRowNum()+1;
            short cellNum = row.getLastCellNum();
            /*int rowIsNull = getRowIsNull(row, rowNum);
            System.out.println(rowIsNull);*/
//            List<String> list = readTitlesToExcel(workbook, sheetAt,row,cellNum);
            List<List<Object>> lists = readRowsToExcel(workbook, sheetAt, row, rowNum,ids,startRow);


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

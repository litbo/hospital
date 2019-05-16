package com.litbo.hospital.common.utils.poi;

import com.alibaba.fastjson.JSONObject;
import com.litbo.hospital.user.bean.EqInfo;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.litbo.hospital.common.utils.poi.ListToListMap.listToMap;
import static com.litbo.hospital.common.utils.poi.ListToListMap.parseMap2Object;


/**
 * 读取execl
 */
public class ImportExcelUtil {

    /**
     * 读取Xlsx
     */
  /*  public static ExcelData readXlsx(File file){
        ExcelData excelData = new ExcelData();
        Workbook workbook = null;
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
            if (JudgeExcelVesion.isExcel2007(file.getCanonicalPath())) {//2007版本
                workbook = new XSSFWorkbook(inputStream);
            } else {
                workbook = new HSSFWorkbook(inputStream);
            }
            workbook = WorkbookFactory.create(inputStream);
            inputStream.close();
            //工作表对象
            Sheet sheetAt = workbook.getSheetAt(0);
            //总行数
            int rowNum = sheetAt.getLastRowNum()+1;
            //工作表的列
            Row row = sheetAt.getRow(0);
            //总列数
            short cellNum = row.getLastCellNum();
            //excel的头部
            List<String> titleList = readTitlesToExcel(workbook, sheetAt, row, cellNum);
            //excel的内容
            List<List<Object>> rowList = readRowsToExcel(workbook, sheetAt, row, rowNum);
            excelData.setTitles(titleList);
            excelData.setRows(rowList);
            return excelData;
        }catch (Exception e){
            e.printStackTrace();
            excelData.setStatus(false);
            excelData.setMessage("读取失败");
            return excelData;
        }

    }*/

    /**
     * 判断是否是空行
     * @param row
     * @param rowNum
     * @return
     */
    public static int getRowIsNull(Row row,int rowNum) {
        int num = 0;        //空单元格的数量

        for (int i = 0 ; i < rowNum ; i ++ ){
            Cell cell = row.getCell(i);
            if (null == cell){        //判断这个行是否为空
                num ++;
            }else if (cell.getCellType() == HSSFCell.CELL_TYPE_BLANK){  //空值
                num ++;
            }
        }
        return num;
    }

    /**
     * 读取头部信息
     * @param wb
     * @param sheet
     * @param row
     * @param cellNum
     * @return
     */
    public static List<String> readTitlesToExcel(Workbook wb, Sheet sheet,Row row,int cellNum){
        //Row row = sheet.getRow(0);
        //row.getCell(0);
        List list = new ArrayList<String>();
        //short cellNum = row.getLastCellNum();
        for (int i = 0; i < cellNum; i++) {
            Cell cell = row.getCell(i);
            String stringCellValue = cell.getStringCellValue();
            list.add(stringCellValue);
        }
        return list;
    }


    /**
     * 读取内容
     * @param wb
     * @param sheetAt
     * @param row
     * @param rowNum
     * @return
     */
    public static List<List<Object>> readRowsToExcel(Workbook wb, Sheet sheetAt,Row row,int rowNum , List<Integer> ids,int startRow){
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
                            if (cell != null&&cell.getCellType()!=HSSFCell.CELL_TYPE_BLANK) {
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

    /*
    测试
     */
    public static void main(String[] args) {
        File file = new File("C:\\Users\\li66\\Desktop\\医院设备管理\\设备导入\\设备导入模板.xlsx");
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
            for (List<Object> objectList : lists) {
                System.out.println(objectList);
               System.out.println(JSONObject.toJSON(objectList));
            }
            System.out.println(listToMap(lists, list));
            List<Map<String, Object>> mapList = listToMap(lists, list);
            for (Map<String, Object> map : mapList) {
                EqInfo user = parseMap2Object(map, EqInfo.class);

                System.out.println(user);
            }


        }catch (Exception e){
            e.printStackTrace();
        }

    }


}

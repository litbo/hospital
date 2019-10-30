package com.litbo.hospital;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.litbo.hospital.beneficial.controller.SbcwController;
import com.litbo.hospital.result.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class ItextTest3 {
    private static Font headfont;// 设置字体大小
    private static Font keyfont;// 设置字体大小
    private static Font textfont;// 设置字体大小
    @Autowired
    SbcwController controller;
    private static int maxWidth = 520;
    static {
        BaseFont bfChinese;
        try {
            // bfChinese = BaseFont.createFont("STSong-Light","UniGB-UCS2-H",BaseFont.NOT_EMBEDDED);//设置字体用宋体
            bfChinese = BaseFont.createFont("c:\\windows\\fonts\\STSONG.TTF", BaseFont.IDENTITY_H,
                    BaseFont.NOT_EMBEDDED);// 华文中宋
            headfont = new Font(bfChinese, 18, Font.BOLD);// 标题字体大小
            keyfont = new Font(bfChinese, 8, Font.BOLD);// 关键标题字体大小
            textfont = new Font(bfChinese, 8, Font.NORMAL);// 字段字体大小
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 创建带部分属性的表格
     *
     * @param colNumber 列数
     * @return
     */
    public static PdfPTable createTable(int colNumber) {
        PdfPTable table = new PdfPTable(colNumber);
        try {
            table.setTotalWidth(maxWidth);
            table.setLockedWidth(true);
            table.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.getDefaultCell().setBorder(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return table;
    }
    /**
     * 一般用于创建表格标题
     * @param value  单元格内容
     * @param font	字体大小
     * @param align 垂直方向对齐方式 (ALIGN_CENTER, ALIGN_LEFT, ALIGN_MIDDLE,ALIGN_RIGHT)
     * @param colspan 所占列宽
     * @param boderFlag 是否设置padding
     * @return
     */
    public static PdfPCell createCell(String value, Font font, int align, int colspan, boolean boderFlag) {
        PdfPCell cell = new PdfPCell();
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(align);
        cell.setColspan(colspan);
        cell.setPhrase(new Phrase(value, font));
        cell.setPadding(3.0f);
        if (!boderFlag) {
            cell.setBorder(0);
            cell.setPaddingTop(15.0f);
            cell.setPaddingBottom(8.0f);
        }
        return cell;
    }
    /**
     * 一般用于创建表格标题行
     * @param value 单元格内容
     * @param font  字体大小
     * @param align 垂直方向对齐方式 (ALIGN_CENTER, ALIGN_LEFT, ALIGN_MIDDLE,ALIGN_RIGHT)
     * @return
     */
    public static PdfPCell createCell(String value, Font font, int align){
        PdfPCell cell = new PdfPCell();
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(align);
        cell.setPhrase(new Phrase(value,font));
        return cell;
    }
    /**
     * 一般用于创建表格正文内容
     * @param value 单元格内容
     * @param font  字体大小
     * @return
     */
    public static PdfPCell createCell(String value,Font font){
        PdfPCell cell = new PdfPCell();
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setPhrase(new Phrase(value,font));
        cell.setPadding(6.0f);
        return cell;
    }

    /**
     * 生成派工单pdf文件,传入参数为json字符串
     *
     * @throws IOException
     * @throws DocumentException
     */
    public void CreatePGDpdf(String json, HttpServletResponse response) throws IOException, DocumentException {
        // 在指定目录下创建一个文件
        response.setHeader("content-Type", "application/vnd.ms-pdf");
        //下载文件的默认名称
        response.setHeader("Content-Disposition", "attachment;filename=666.pdf");
        //设置中文
        BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);

        File file = new File("C:\\Users\\Administrator\\Desktop\\test.pdf");
        try {
            file.createNewFile();

            // 建立一个Document对象
            Document document = new Document();
            // 设置页面大小
            document.setPageSize(PageSize.A4);
            // 建立一个书写器(Writer)与document对象关联，通过书写器(Writer)可以将文档写入到磁盘中。
            PdfWriter.getInstance(document, response.getOutputStream());
            document.open();



            // 向文档中添加内容
            Paragraph paragraph = new Paragraph("医疗设备成本效益分析报表",headfont);
            paragraph.setAlignment(1);
            document.add(paragraph);
            document.add(new Paragraph("\n"));

            //   \t不起作用,没办法只能用n多的空格代替
            String table_up = "填报单位 : 医学工程处";
//                    "日期 : "+k_bxtime+"                             "+
//                    "单号 : "+k_recordsnum;
            paragraph = new Paragraph(table_up,textfont);
            SimpleDateFormat date = new SimpleDateFormat("yyyy-MM");
            String s = date.format(new Date());
            String[] split = s.split("-");
            Paragraph elements = new Paragraph("填报日期 :    "+split[0]+"  年  "+split[1]+"  月  ", textfont);
            elements.setAlignment(2);
//            paragraph.setAlignment(1);
            document.add(paragraph);
            document.add(elements);
            document.add(new Paragraph("\n"));

            PdfPTable table = createTable(11);
            //第一行内容
            //table.addCell(createCell("客户维修派工单", headfont, Element.ALIGN_CENTER, 6, true));
            PdfPCell cell1 = createCell("设备项", textfont);
            cell1.setColspan(4);
            table.addCell(cell1);
            PdfPCell cell2 = createCell("分析项", textfont);
            cell2.setColspan(7);
            table.addCell(cell2);

            //第二行内容
            PdfPCell cell = createCell("所属科室", textfont);
//            cell.setRowspan(1);
            table.addCell(cell);
//            cell.setRowspan(2);
//            cell.setColspan(3);
//            table.addCell(cell);
//            cell = createCell(k_bxtime, textfont);
//            cell.setNoWrap(true);
//            table.addCell(cell);
            table.addCell(createCell("资产编号", textfont));
            table.addCell(createCell("设备名称", textfont));
            table.addCell(createCell("规格型号", textfont));
            table.addCell(createCell("收入", textfont));
            table.addCell(createCell("成本", textfont));
            table.addCell(createCell("收益", textfont));
            table.addCell(createCell("期间例次", textfont));
            table.addCell(createCell("诊疗收入", textfont));
            table.addCell(createCell("诊疗成本", textfont));
            table.addCell(createCell("诊疗收益", textfont));
//            table.addCell(createCell(k_jbr, textfont));

            JSONArray array = JSONArray.parseArray(json);
            int size = array.size();
            for (int i = 0; i < size; i++) {
                JSONObject object = array.getJSONObject(i);
                String o = String.valueOf(object.get("bmName"));
                String o1 = String.valueOf(object.get("eqNum"));
                String o2 = String.valueOf(object.get("eqName"));
                String o3 = String.valueOf(object.get("eqXh"));
                if("null".equals(o3)|| StringUtils.isBlank(o3)){
                    o3="";
                }
                String o4 = String.valueOf(object.get("sr"));
                String o6 = String.valueOf(object.get("cb"));
                String o5 = String.valueOf(object.get("sy"));
                String o7 = String.valueOf(object.get("qjlc"));
                String o8 = String.valueOf(object.get("zcsr"));
                String o9 = String.valueOf(object.get("zccb"));
                String o10 = String.valueOf(object.get("zcsy"));
                table.addCell(createCell(o,textfont));
                table.addCell(createCell(o1,textfont));
                table.addCell(createCell(o2,textfont));
                table.addCell(createCell(o3,textfont));
                table.addCell(createCell(o4,textfont));
                table.addCell(createCell(o5,textfont));
                table.addCell(createCell(o6,textfont));
                table.addCell(createCell(o7,textfont));
                table.addCell(createCell(o8,textfont));
                table.addCell(createCell(o9,textfont));
                table.addCell(createCell(o10,textfont));

            }

            document.add(table);

            //备注
            /*paragraph = new Paragraph("备注 : ", textfont);
            document.add(paragraph);*/

            // 关闭文档
            document.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }

    }

    @RequestMapping("/xyfxbb")
    public void  sss(HttpServletResponse response,@RequestParam(required = false,defaultValue = "") String qssj) throws IOException, DocumentException, ParseException {

        Result result = controller.listXyfxBobiao(qssj);
        Object o = result.getData();
        String string = JSON.toJSONString(o);
        JSONArray array = JSONArray.parseArray(string);
        String s = array.toString();
        ItextTest3 printTest = new ItextTest3();
        printTest.CreatePGDpdf(s,response);
    }

}
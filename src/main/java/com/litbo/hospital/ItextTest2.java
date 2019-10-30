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
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class ItextTest2 {
    private static Font headfont;// 设置字体大小
    private static Font keyfont;// 设置字体大小
    private static Font textfont;// 设置字体大小
    private static List<BigDecimal> list = new ArrayList();
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
     *
     * @param value     单元格内容
     * @param font      字体大小
     * @param align     垂直方向对齐方式 (ALIGN_CENTER, ALIGN_LEFT, ALIGN_MIDDLE,ALIGN_RIGHT)
     * @param colspan   所占列宽
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
     *
     * @param value 单元格内容
     * @param font  字体大小
     * @param align 垂直方向对齐方式 (ALIGN_CENTER, ALIGN_LEFT, ALIGN_MIDDLE,ALIGN_RIGHT)
     * @return
     */
    public static PdfPCell createCell(String value, Font font, int align) {
        PdfPCell cell = new PdfPCell();
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(align);
        cell.setPhrase(new Phrase(value, font));
        return cell;
    }

    /**
     * 一般用于创建表格正文内容
     *
     * @param value 单元格内容
     * @param font  字体大小
     * @return
     */
    public static PdfPCell createCell(String value, Font font) {
        PdfPCell cell = new PdfPCell();
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setPhrase(new Phrase(value, font));
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
      /*  response.addHeader("Content-Disposition",
                " attachment;filename=" + new String("医疗设备收入统计表.pdf".getBytes(),"utf-8"));*/
        //下载文件的默认名称
        response.addHeader("Content-Disposition", "attachment;filename="+ URLEncoder.encode("医疗设备收入统计表.pdf", "UTF-8"));
//        response.setHeader("Content-Disposition", "attachment;filename=医疗设备收入统计表.pdf");
        //设置中文
        BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);

//        File file = new File("C:\\Users\\Administrator\\Desktop\\test.pdf");
        try {
//            file.createNewFile();

            // 建立一个Document对象
            Document document = new Document();
            // 设置页面大小
            document.setPageSize(PageSize.A4);
            // 建立一个书写器(Writer)与document对象关联，通过书写器(Writer)可以将文档写入到磁盘中。
            PdfWriter.getInstance(document, response.getOutputStream());
            document.open();


            // 向文档中添加内容
            Paragraph paragraph = new Paragraph("医疗设备收入统计表", headfont);
            paragraph.setAlignment(1);
            document.add(paragraph);
            document.add(new Paragraph("\n"));

            //   \t不起作用,没办法只能用n多的空格代替
            String table_up = "填报单位 : 医学工程处";
//                    "日期 : "+k_bxtime+"                             "+
//                    "单号 : "+k_recordsnum;
            paragraph = new Paragraph(table_up, textfont);
            SimpleDateFormat date = new SimpleDateFormat("yyyy-MM");
            String s = date.format(new Date());
            String[] split = s.split("-");
            Paragraph elements = new Paragraph("填报日期 :    " + split[0] + "  年  " + split[1] + " 月 ", textfont);
            elements.setAlignment(2);
//            paragraph.setAlignment(1);
            document.add(paragraph);
            document.add(elements);
            document.add(new Paragraph("\n"));

            PdfPTable table = createTable(9);
            //第一行内容
            //table.addCell(createCell("客户维修派工单", headfont, Element.ALIGN_CENTER, 6, true));
            PdfPCell cell1 = createCell("设备项", textfont);
            cell1.setColspan(4);
            table.addCell(cell1);
            PdfPCell cell2 = createCell("收入项", textfont);
            cell2.setColspan(5);
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
            table.addCell(createCell("门诊", textfont));
            table.addCell(createCell("住院", textfont));
            table.addCell(createCell("科教", textfont));
            table.addCell(createCell("其他", textfont));
            table.addCell(createCell("合计", textfont));
//            table.addCell(createCell(k_jbr, textfont));

            JSONArray array = JSONArray.parseArray(json);
            int size = array.size();
            for (int i = 0; i < size; i++) {
                JSONObject object = array.getJSONObject(i);
                String o = String.valueOf(object.get("bmName"));
                String o1 = String.valueOf(object.get("eqNum"));
                String o2 = String.valueOf(object.get("eqName"));
                String o3 = String.valueOf(object.get("eqXh"));
                if ("null".equals(o3) || StringUtils.isBlank(o3)) {
                    o3 = "";
                }
                String o4 = String.valueOf(object.get("mzsr"));
                String o6 = String.valueOf(object.get("zysr"));
                String o5 = String.valueOf(object.get("kjxmsr"));
                String o7 = String.valueOf(object.get("qt"));
                String o8 = String.valueOf(object.get("zj"));
                list.add(new BigDecimal(o8));

                table.addCell(createCell(o, textfont));
                table.addCell(createCell(o1, textfont));
                table.addCell(createCell(o2, textfont));
                table.addCell(createCell(o3, textfont));
                table.addCell(createCell(o4, textfont));
                table.addCell(createCell(o5, textfont));
                table.addCell(createCell(o6, textfont));
                table.addCell(createCell(o7, textfont));
                table.addCell(createCell(o8, textfont));

            }
            PdfPCell cell3 = createCell("共合计: ", textfont);
            cell3.setVerticalAlignment(Element.ALIGN_RIGHT);

            cell3.setColspan(8);
            table.addCell(cell3);
            int i = list.size();
            BigDecimal total = new BigDecimal("0.00");
            for (int k = 0; k < i; k++) {
                total = total.add(list.get(k));
            }
            table.addCell(createCell(String.valueOf(total), textfont));

            document.add(table);

            //备注
            /*paragraph = new Paragraph("备注 : ", textfont);
            document.add(paragraph);*/

            // 关闭文档
            document.close();
            list = new ArrayList<>();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
       /* String json = "{\"paigong\":{\"RECORDS_NUM\":\"201801070001\",\"BXTIME\":\"2018-01-07 10:25:32\",\"BXADRESS\":\"国务院A栋 1层 A102\",\"LOCATION\":\"\",\"YYSJ\":\"\",\"BXR\":\"\",\"LXR\":\"vicky\",\"LXDH\":\"18888888888\",\"BXLB\":\"空调\",\"WXXM\":\"\",\"JBR\":\"张三\",\"WBDW\":\"\",\"BXCONTEXT\":\"空调维修\",\"PGTIME\":\"2018-01-07 11:06:41\",\"PGR\":\"李四\",\"WXR\":\"李军\",\"DCTIME\":\"2018-01-07 09:30:00\",\"WGTIME\":\"2018-01-07 10:30:00\",\"FWLX\":\"收费\",\"WXJG\":\"完成\",\"WXPJ\":\"满意\",\"WXCONTENT\":\"\",\"CLFY\":\"22\",\"RGFY\":\"28\",\"ZFY\":\"50\",\"KF_NAME\":\"一园项目物料库房\",\"wxclmx\":[{\"CK_NAME\":\"一园项目物料库房\",\"WL_NAME\":\"A4复印纸\",\"SL\":\"2\",\"DJ\":\"11\",\"JE\":\"22\",\"JLDW\":\"包\"}]}}";

        ItextTest printTest = new ItextTest();
        printTest.CreatePGDpdf(json);*/
    }

    @RequestMapping("/srbb")
    public void ss(HttpServletResponse response, @RequestParam(required = false, defaultValue = "") String qssj) throws IOException, DocumentException, ParseException {

        Result result = controller.listSrbaobiao(qssj, null, null);
        Object o = result.getData();
        String string = JSON.toJSONString(o);
        JSONArray array = JSONArray.parseArray(string);
        String s = array.toString();
        ItextTest2 printTest = new ItextTest2();
        printTest.CreatePGDpdf(s, response);
    }

}
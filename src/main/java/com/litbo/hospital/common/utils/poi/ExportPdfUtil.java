package com.litbo.hospital.common.utils.poi;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class ExportPdfUtil {
    public static void exportExcel(HttpServletResponse response, String fileName, PdfData data) throws Exception {
        // 告诉浏览器用什么软件可以打开此文件
        response.setHeader("content-Type", "application/vnd.ms-pdf");
        // 下载文件的默认名称
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "utf-8"));
        exportPdf(data, response.getOutputStream());
    }

    private static void exportPdf(PdfData data, OutputStream out) throws Exception {
        Document document = new Document();
        // A4纸张
        document.setPageSize(PageSize.A4);

        PdfWriter.getInstance(document, out);
        document.open();
        List<String> titles = data.getTitles();
        List rows = data.getRows();

        PdfPTable table = new PdfPTable(titles.size());

        for (String title : titles) {
            PdfPCell cell = new PdfPCell();
            cell.setPhrase(new Paragraph(title, setChineseFont()));
            table.addCell(cell);

        }
        for (Object obj : rows) {
            List<String> values = getValue(obj);
            for (String value : values) {
                PdfPCell cell = new PdfPCell();
                cell.setPhrase(new Paragraph(value, setChineseFont()));
                table.addCell(cell);
            }
        }
        document.add(table);
        document.close();
    }

    private static Font setChineseFont() {
        com.itextpdf.text.Font fontChinese = null;
        try {
            BaseFont bf = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
            fontChinese = new com.itextpdf.text.Font(bf, 12, Font.NORMAL);
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }
        return fontChinese;
    }

    private static List<String> getValue(Object obj) throws Exception {
        Class clz = obj.getClass();
        Field[] field = clz.getDeclaredFields();
        List<String> values = new ArrayList<>();
        for (Field f : field) {
            f.setAccessible(true);
            String value = (String) f.get(obj);
            values.add(value);
        }
        return values;
    }
}

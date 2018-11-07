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

/**
 * 页面数据生成pdf的工具类
 */
public class ExportPdfUtil {

    /**
     * 设置请求头
     * @param response HttpServletResponse
     * @param fileName 文件名
     * @param data 需要显示在pdf中的属性值对象
     * @throws IOException IO异常
     * @throws DocumentException 文档异常
     * @throws IllegalAccessException 无法访问对象属性异常
     */
    public static void exportExcel(HttpServletResponse response, String fileName, PdfData data) throws IOException, IllegalAccessException, DocumentException {
        // 告诉浏览器用什么软件可以打开此文件
        response.setHeader("content-Type", "application/vnd.ms-pdf");
        // 下载文件的默认名称
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "utf-8"));
        exportPdf(data, response.getOutputStream());
    }

    /**
     * 数据存到pdf中并把pdf文件写入到输出流中
     * @param data 需要显示在pdf中的属性值对象
     * @param out 输出流
     * @throws IOException IO异常
     * @throws DocumentException 文档异常
     * @throws IllegalAccessException 无法访问对象属性异常
     */
    private static void exportPdf(PdfData data, OutputStream out) throws DocumentException, IOException, IllegalAccessException {
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

    /**
     * 设置字体样式主要针对pdf中无法显示中文
     * @return Font 返回字体样式
     * @throws IOException IO异常
     * @throws DocumentException 文档异常
     */
    private static Font setChineseFont() throws IOException, DocumentException {
        BaseFont bf = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
        return new Font(bf, 12, Font.NORMAL);
    }

    /**
     * 通过反射获取Object中属性的值
     *
     * @param object 需要获取属性值的对象
     * @return List<String> 返回属性值的列表
     * @throws IllegalAccessException 无法访问对象属性异常
     */
    private static List<String> getValue(Object object) throws IllegalAccessException {
        Class clz = object.getClass();
        Field[] field = clz.getDeclaredFields();
        List<String> values = new ArrayList<>();
        for (Field f : field) {
            f.setAccessible(true);
            String value = (String) f.get(object);
            values.add(value);
        }
        return values;
    }
}

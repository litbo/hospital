package com.litbo.hospital.jasperreport.controller;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;
import com.litbo.hospital.jasperreport.domain.Product;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.type.OrientationEnum;
import net.sf.jasperreports.engine.util.JRLoader;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class TestController {

	public List<Product> getProductList() {
		List<Product> list = new ArrayList<>();
		for (int i = 1; i <= 20; i++) {
			list.add(new Product(String.valueOf(i), "名称" + i));
		}
		return list;
	}

	@RequestMapping(path = "/htmlPreview", method = RequestMethod.GET)
	public void reportHtml(HttpServletRequest request, HttpServletResponse response) throws Exception {
		JRDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(getProductList());
		Map params = new HashMap();
		params.put("Parameter1", "hello 你好");
		// 编译jrxml文件，生成jasper文件
		URL url = this.getClass().getClassLoader().getResource("jasperreport/test.jrxml");
		JasperCompileManager.compileReportToFile(url.getPath());
		File jasperFile = ResourceUtils.getFile("classpath:jasperreport/test.jasper");
		JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperFile);
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, jrBeanCollectionDataSource);
		JasperExportManager.exportReportToHtmlFile(jasperPrint,
				request.getServletContext().getRealPath("/") + "reportPreviewTemp.html");
		response.sendRedirect("/static/reportPreviewTemp.html");
	}

	@RequestMapping(path = "/pdfExport", method = RequestMethod.GET)
	public String pdfExport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		JRDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(getProductList());
		Map params = new HashMap();
		params.put("Parameter1", "hello 你好");
		// 编译jrxml文件，生成jasper文件
        String path = this.getClass().getClassLoader().getResource("jasperreport/test.jrxml").getPath();
        JasperCompileManager.compileReportToFile(path);
		File jasperFile = ResourceUtils.getFile("classpath:jasperreport/test.jasper");
		JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperFile);
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, jrBeanCollectionDataSource);
		JRPdfExporter pdf = new JRPdfExporter();
		pdf.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
		pdf.setParameter(JRExporterParameter.OUTPUT_STREAM, response.getOutputStream());
		String fileName = new String("测试.pdf".getBytes("utf-8"), "ISO_8859_1");
		response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
		response.setContentType("application/pdf");
		response.setCharacterEncoding("utf-8");
		pdf.exportReport();
		return null;
	}

	// 预览并浏览器自动弹出打印
	@RequestMapping(path = "/previewPrint", method = RequestMethod.GET)
	public void previewPrint(HttpServletRequest request, HttpServletResponse response) throws Exception {
		JRDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(getProductList());
		Map params = new HashMap();
		params.put("Parameter1", "hello 你好");

		// 编译jrxml文件，生成jasper文件
		URL url = this.getClass().getClassLoader().getResource("jasperreport/test.jrxml");
		JasperCompileManager.compileReportToFile(url.getPath());
		File jasperFile = ResourceUtils.getFile("classpath:jasperreport/test.jasper");
		JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperFile);

		byte[] pdfStream = JasperRunManager.runReportToPdf(jasperReport, params, jrBeanCollectionDataSource);
		PdfReader reader = new PdfReader(pdfStream);
		ByteArrayOutputStream bos = new ByteArrayOutputStream(pdfStream.length);
		try {
			// 给pdf加上脚本实现自动打印
			StringBuffer script = new StringBuffer();
			script.append("this.print({bUI:false,bSilent:true,bShrinkToFit:false});");
			PdfStamper stamp = new PdfStamper(reader, bos);
			stamp.setViewerPreferences(PdfWriter.HideMenubar | PdfWriter.HideToolbar | PdfWriter.HideWindowUI);
			stamp.addJavaScript(script.toString());
			stamp.close();
		} catch (Exception e) {
		}
		// 输出pdf
		byte[] bytes = bos.toByteArray();
		if (bytes != null && bytes.length > 0) {
			response.setContentType("application/pdf");
			response.setContentLength(bytes.length);
			response.setHeader("Expires", "0");
			response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
			response.setHeader("Pragma", "public");
			ServletOutputStream ouputStream = response.getOutputStream();
			try {
				ouputStream.write(bytes, 0, bytes.length);
				ouputStream.flush();
			} finally {
				if (ouputStream != null) {
					try {
						ouputStream.close();
					} catch (IOException ex) {
					}
				}
			}
		}
	}

	// 连接打印机打印
	@RequestMapping(path = "/print1", method = RequestMethod.GET)
	public void print1(HttpServletRequest request, HttpServletResponse response) throws Exception {
		JRDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(getProductList());
		Map params = new HashMap();
		params.put("Parameter1", "hello 你好");
		// 编译jrxml文件，生成jasper文件
		URL url = this.getClass().getClassLoader().getResource("jasperreport/test.jrxml");
		JasperCompileManager.compileReportToFile(url.getPath());
		File jasperFile = ResourceUtils.getFile("classpath:jasperreport/test.jasper");
		JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperFile);
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, jrBeanCollectionDataSource);
		// 设置打印方向 LANDSCAPE横向 PORTRAIT竖向
		jasperPrint.setOrientation(OrientationEnum.LANDSCAPE);
		// withPrintDialog表示在打印的时候是否显示打印机设置对话框
		JasperPrintManager.printReport(jasperPrint, false);
	}
}

package com.litbo.hospital.jasperreport.view;

import net.sf.jasperreports.engine.*;
import org.springframework.web.servlet.view.AbstractView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class PdfReportView extends AbstractView {
	private static final String CONTENT_TYPE = "application/pdf";

	private String templatePath;
	private String exportFileName;

	public PdfReportView(String templatePath, String exportFileName) {
		this.templatePath = templatePath;
		if (exportFileName != null) {
			try {
				exportFileName = URLEncoder.encode(exportFileName, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		this.exportFileName = exportFileName;
		setContentType(CONTENT_TYPE);
	}

	protected Map<String, Object> getParamsMap(Map<String, Object> map) throws Exception {
		Map<String, Object> params = new HashMap<>();
		for (String key : map.keySet()) {
			Object val = map.get(key);
			if (val instanceof JRDataSource) {
				continue;
			} else {
				params.put(key, val);
			}
		}
		return params;
	}

	protected JRDataSource getDataSource(Map<String, Object> map) throws Exception {
		for (String key : map.keySet()) {
			Object val = map.get(key);
			if (val instanceof JRDataSource) {
				return (JRDataSource) map.get(key);
			}
		}
		return new JREmptyDataSource();
	}

	@Override
	protected void renderMergedOutputModel(Map<String, Object> map, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		response.setCharacterEncoding("utf-8");
		response.setContentType(getContentType());
		// response.setContentType("application/octet-stream");
		response.setHeader("content-disposition", "attachment;filename=" + exportFileName + ".pdf");

		try (InputStream inputStream = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream(templatePath)) {
			try (OutputStream ouputStream = response.getOutputStream()) {

				JasperPrint jasperPrint = JasperFillManager.fillReport(inputStream, getParamsMap(map),
						getDataSource(map));

				JasperExportManager.exportReportToPdfStream(jasperPrint, ouputStream);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}

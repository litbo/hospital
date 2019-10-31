//package com.litbo.hospital.controller;
//
//import net.sf.jasperreports.engine.JRDataSource;
//import net.sf.jasperreports.engine.data.JRMapArrayDataSource;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.imageio.ImageIO;
//import javax.servlet.http.HttpServletResponse;
//import java.awt.*;
//import java.awt.image.BufferedImage;
//import java.io.IOException;
//import java.io.OutputStream;
//import java.util.List;
//import java.util.*;
//
//@RestController
//@RequestMapping("/reports")
//public class TestController {
//
//	/***
//	 * 处理jasperreport生成图表的image src="null" 的bug
//	 *
//	 * @param response
//	 */
//	@RequestMapping("/null")
//	public void ifnull(HttpServletResponse response) {
//		try {
//			BufferedImage image = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
//			Graphics g = image.getGraphics();
//			g.setColor(new Color(255, 255, 255));
//			g.fillRect(0, 0, 1, 1);
//			response.setContentType("image/png");
//			OutputStream out = response.getOutputStream();
//			ImageIO.write(image, "jpg", out);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//
//	@GetMapping("/{reportName}")
//	public ModelAndView getReportByParam(final ModelMap modelMap, @PathVariable String reportName,
//                                         HttpServletResponse response) {
////		response.setContentType("text/html;charset=UTF-8");
//		response.setContentType("application/pdf");
//		List<Map> list = new ArrayList();
//		for (int i = 0; i < 30; i++) {
//			Map p = new HashMap();
//			p.put("id", UUID.randomUUID().toString());
//			p.put("name", "张" + (i + 1));
//			list.add(p);
//		}
//		JRDataSource jrDataSource = new JRMapArrayDataSource(list.toArray());// 这里可以使用多种类型的JRDataSource，具体可查看JRDataSource的实现类
//		modelMap.put("datasource", jrDataSource);
//		modelMap.put("format", "pdf");
//		ModelAndView modelAndView = new ModelAndView(reportName, modelMap);
//		return modelAndView;
//	}
//}

//package com.litbo.hospital.common;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//import org.springframework.web.servlet.view.jasperreports.JasperReportsMultiF;
//import org.springframework.web.servlet.view.jasperreports.JasperReportsViewResolver;
//
//@Configuration
//public class JasperConfig extends WebMvcConfigurerAdapter {
//
//	@Override
//	public void configureDefaultServletHandling(final DefaultServletHandlerConfigurer configurer) {
//		configurer.enable();
//	}
//
//	@Bean
//	public JasperReportsViewResolver getJasperReportsViewResolver() {
//		JasperReportsViewResolver resolver = new JasperReportsViewResolver();
//		resolver.setPrefix("classpath:jrxml/");
//		resolver.setSuffix(".jrxml");
//		resolver.setReportDataKey("datasource");
//		resolver.setViewNames("rpt_*");
//		resolver.setViewClass(JasperReportsMultiFormatView.class);
//		resolver.setOrder(0);
//		return resolver;
//	}
//}

/**   
* @Title: SpiderProperties.java 
* @Package com.config 
* @Description: TODO(用一句话描述该文件做什么) 
* @author zhuyj   
* @date 2019-08-17 
*/
package com.litbo.hospital.supervise.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

/** 
* @ClassName: SpiderProperties 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author: zhuyj
* @date: 2019-08-17 
*/
@Data
@Component
@ConfigurationProperties(prefix="spider")
public class SpiderProperties {
	private Integer retryTimes;
	private Integer sleepTime;
	private Integer threadNum;
	private String starUrl;
	private String savePath;
	private String detailPath;
	
	private String driver;
	private String execPath;
	private String driverLoglevel;
	private String driverLogFile;
	
	private String proxyType;
	private String proxyHost;
	private Integer proxyPort;
}

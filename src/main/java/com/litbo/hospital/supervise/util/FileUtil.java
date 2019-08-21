/**   
* @Title: FileUtil.java 
* @Package com.util 
* @Description: TODO(用一句话描述该文件做什么) 
* @author zhuyj   
* @date 2019-08-17 
*/
package com.litbo.hospital.supervise.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.litbo.hospital.supervise.config.SpiderProperties;

/** 
* @ClassName: FileUtil 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author: zhuyj
* @date: 2019-08-17 
*/
public class FileUtil {
	
	private static Logger log = LoggerFactory.getLogger(FileUtil.class);
	
	private static SpiderProperties spiderProperties = SpringBeanUtil.getBean("spiderProperties");
	
	private static BufferedWriter out ;
	
	public static void init() throws Exception{
		log.info("intit file:" + spiderProperties.getSavePath());
		File file = new File(spiderProperties.getSavePath());
		if(file.exists()) {
			DateTimeFormatter ftf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
			String newSuf = ftf.format(LocalDateTime.ofInstant(Instant.ofEpochMilli(file.lastModified()), ZoneId.systemDefault()));
			new File(spiderProperties.getSavePath()).renameTo(new File(spiderProperties.getSavePath()  + "_" + newSuf));
		}
		
		file.createNewFile();
		
		out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true)), 1024);
	}
	
	public static void appendFile(String content) throws Exception{
		if(out != null) {
			out.write(content);
			out.flush();
		}else {
			init();
		}
	}
	
	public static void close() {
		try {
			if(out != null) {
				out.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}

/**   
* @Title: StartSpider.java 
* @Package com.spider 
* @Description: TODO(用一句话描述该文件做什么) 
* @author zhuyj   
* @date 2019-08-17 
*/
package com.litbo.hospital.supervise.spider;

import com.litbo.hospital.supervise.config.SpiderProperties;
import com.litbo.hospital.supervise.util.FileUtil;
import com.litbo.hospital.supervise.util.SpringBeanUtil;

import us.codecraft.webmagic.Spider;

/**
 * @ClassName: StartSpider
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author: zhuyj
 * @date: 2019-08-16
 */
public class StartSpider implements Runnable {
	
	public static boolean isRuning = false;

	private SpiderProperties spiderProperties  = SpringBeanUtil.getBean("spiderProperties");;

	@SuppressWarnings("resource")
	@Override
	public void run() {
		try {
			FileUtil.init();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		isRuning = true;
		
		Spider.create(new CfdaProcessor())
			.addUrl(spiderProperties.getStarUrl())
			.addPipeline(new MyFilePipeline(spiderProperties.getSavePath()))
			.setDownloader(new CfdaSeleniumDownloader().setSleepTime(Integer.valueOf(spiderProperties.getSleepTime())))
			.thread(Integer.valueOf(spiderProperties.getThreadNum()))
			.run();
			
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			isRuning = false;
		}
	
	}

}

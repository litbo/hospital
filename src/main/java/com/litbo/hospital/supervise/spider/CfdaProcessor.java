/**   
* @Title: CfdaProcessor.java 
* @Package com.local.WebSpider.cfda 
* @Description: TODO(用一句话描述该文件做什么) 
* @author zhuyj   
* @date 2019-08-16 
*/
package com.litbo.hospital.supervise.spider;

import com.litbo.hospital.supervise.config.SpiderProperties;
import com.litbo.hospital.supervise.util.SpringBeanUtil;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * @ClassName: CfdaProcessor
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author: zhuyj
 * @date: 2019-08-16
 */
public class CfdaProcessor implements PageProcessor {
	
	private SpiderProperties spiderProperties = SpringBeanUtil.getBean(SpiderProperties.class);
	
	private Site site = Site.me();

	/**
	 * @Title: process
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param page
	 * @see us.codecraft.webmagic.processor.PageProcessor #process(us.codecraft.webmagic.Page)
	 */
	@Override
	public void process(Page page) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @Title: getSite
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @return
	 * @see us.codecraft.webmagic.processor.PageProcessor #getSite()
	 */
	@Override
	public Site getSite() {
		site.setRetryTimes(spiderProperties.getRetryTimes()).setSleepTime(spiderProperties.getSleepTime());

		return site;
	}
}

/**   
* @Title: BaseController.java 
* @Package com.dao.controller 
* @Description: TODO(用一句话描述该文件做什么) 
* @author zhuyj   
* @date 2019-08-15 
*/
package com.litbo.hospital.supervise.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.litbo.hospital.supervise.bean.ItemInfo;
import com.litbo.hospital.supervise.service.IItemInfoService;
import com.litbo.hospital.supervise.spider.StartSpider;

/**
 * @ClassName: BaseController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author: zhuyj
 * @date: 2019-08-15
 */
@Controller
@RequestMapping("/base")
public class BaseController {
	
	private static Logger log = LoggerFactory.getLogger(BaseController.class);
	
	@Autowired
	private IItemInfoService iItemInfoService;
	
	@RequestMapping(method = RequestMethod.GET, path = "/searchByPage")
	@ResponseBody
	public Map<String, Object> search(Integer pageNum, Integer pageSize, ItemInfo info) {
		log.info("===============start search info by page===============");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 0);
		map.put("msg", "查询成功");
		map.put("result", iItemInfoService.search(info, pageNum == null ? 0 : pageNum, pageSize == null ? 10 : pageSize));
		return map;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/startSpider")
	@ResponseBody
	public Map<String, Object> startSpider() {
		log.info("===============start spider===============");
		Map<String, Object> map = new HashMap<String, Object>();
		if(StartSpider.isRuning) {
			map.put("result", "执行中，请稍后再试");
			
			return map;
		}
		
		Thread thread = new Thread(new StartSpider());
		thread.start();
		
		map.put("result", "开始爬取数据");
		
		return map;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/insertToDb")
	@ResponseBody
	public Map<String, Object> insertToDb() {
		log.info("===============start insert===============");
		Map<String, Object> map = new HashMap<String, Object>();
		map.putAll(iItemInfoService.saveItem());		
		return map;
	}
}

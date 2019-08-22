/**   
* @Title: IItemInfoService.java 
* @Package com.service 
* @Description: TODO(用一句话描述该文件做什么) 
* @author zhuyj   
* @date 2019-08-15 
*/
package com.litbo.hospital.supervise.service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.plugins.Page;

import com.litbo.hospital.supervise.bean.ItemInfo;

/** 
* @ClassName: IItemInfoService 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author: zhuyj
* @date: 2019-08-15 
*/
public interface IItemInfoService {
	public List<ItemInfo> search(ItemInfo info);
	
	public Page<ItemInfo> search(Page<ItemInfo> page,ItemInfo info);

	public Map<String, Object> saveItem();
}

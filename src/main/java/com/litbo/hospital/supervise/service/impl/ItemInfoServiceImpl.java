/**   
* @Title: IItemInfoServiceImpl.java 
* @Package com.service.impl 
* @Description: TODO(用一句话描述该文件做什么) 
* @author zhuyj   
* @date 2019-08-15 
*/
package com.litbo.hospital.supervise.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.supervise.bean.ItemInfo;
import com.litbo.hospital.supervise.config.SpiderProperties;
import com.litbo.hospital.supervise.dao.ItemInfoDao;
import com.litbo.hospital.supervise.service.IItemInfoService;
import com.litbo.hospital.supervise.spider.StartSpider;

/** 
* @ClassName: IItemInfoServiceImpl 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author: zhuyj
* @date: 2019-08-15 
*/
@Service
public class ItemInfoServiceImpl implements IItemInfoService{
	
	@Autowired
	private ItemInfoDao itemInfoDao;
	
	@Autowired
	private SpiderProperties spiderProperties;



	/* (非 Javadoc) 
	* <p>Title: saveItem</p> 
	* <p>Description: </p>  
	* @see com.service.IItemInfoService#saveItem() 
	*/
	@Override
	public Map<String, Object> saveItem() {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		String path = spiderProperties.getSavePath();
		File file = new File(path);
		map.put("code", -1);
		if(file.exists()) {
			if(StartSpider.isRuning) {
				map.put("result", "正在爬取数据，请稍后再试");
			}else {
				BufferedReader br = null;
				int updateNum = 0;
				int newNum = 0;
				try {
					
					br = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
					String str;
					while((str = br.readLine()) != null) {
						ItemInfo item = JSON.parseObject(str,ItemInfo.class);
						
						ItemInfo temp = itemInfoDao.selectById(item.getEsId());
						int flag = item.equal(temp);
						if(flag == -1) {
							itemInfoDao.insert(item);
							newNum ++;
						}else if(flag == 1){
							itemInfoDao.updateById(item);
							updateNum ++;
						}
						
					}
					map.put("updateNum", updateNum);
					map.put("newNum", newNum);
					map.put("code", 0);
					map.put("result", "入库成功");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					if(br != null) {
						try {
							br.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}

			}
			
		}else {
			map.put("result", "文件不存在");
		}
		
		return map;
	}



	/* (非 Javadoc) 
	* <p>Title: search</p> 
	* <p>Description: </p> 
	* @param info
	* @param pageNum
	* @param pageSize
	* @return 
	* @see com.litbo.hospital.supervise.service.IItemInfoService#search(com.litbo.hospital.supervise.bean.ItemInfo, int, int) 
	*/
	@Override
	public PageInfo<ItemInfo> search(ItemInfo info, int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum,pageSize);
		
		List<ItemInfo> list = itemInfoDao.selectByPage(info);
		
		return new PageInfo<ItemInfo>(list);
	}

}

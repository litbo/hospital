/**   
* @Title: ItemInfoDao.java 
* @Package com.dao 
* @Description: TODO(用一句话描述该文件做什么) 
* @author zhuyj   
* @date 2019-08-15 
*/
package com.litbo.hospital.supervise.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.litbo.hospital.supervise.bean.ItemInfo;

/** 
* @ClassName: ItemInfoDao 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author: zhuyj
* @date: 2019-08-15 
*/
public interface ItemInfoDao extends BaseMapper<ItemInfo>{
	List<ItemInfo> selectMyPage(RowBounds rowBounds, @Param("ew") Wrapper<ItemInfo> wrapper);
}

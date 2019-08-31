/**   
* @Title: ItemInfoDao.java 
* @Package com.dao 
* @Description: TODO(用一句话描述该文件做什么) 
* @author zhuyj   
* @date 2019-08-15 
*/
package com.litbo.hospital.supervise.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import com.litbo.hospital.supervise.bean.ItemInfo;
import com.litbo.hospital.supervise.dao.provider.ItemInfoProvider;

/** 
* @ClassName: ItemInfoDao 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author: zhuyj
* @date: 2019-08-15 
*/
@Mapper
public interface ItemInfoDao{
	@SelectProvider(type = ItemInfoProvider.class ,method = "selectByPage")
	List<ItemInfo> selectByPage(ItemInfo ItemInfo);
	
	@Select("SELECT ES_ID, PRODUCT_NAME, APPROVAL_NUM, ENTERPRISE, ENTERPRISE_ADDRESS, APPROVAL_DATE, EXPIRED_DATE, "
			+ " case when datediff(day,EXPIRED_DATE,GetDate()) >= -1 then 1 else 0 end AS expired " 
			+ " from ITEM_INFO where ES_ID = #{esId}")
	ItemInfo selectById(String esId);
	
	@Insert("INSERT INTO ITEM_INFO(ES_ID, PRODUCT_NAME, APPROVAL_NUM, ENTERPRISE, ENTERPRISE_ADDRESS, APPROVAL_DATE, EXPIRED_DATE) " +
           " VALUES (#{esId}, #{productName}, #{approvalNum}, #{enterprise}, #{enterpriseAddress}, #{approvalDate}, #{expiredDate})")
	Integer insert(ItemInfo ItemInfo);
	
	@Update("UPDATE ITEM_INFO SET PRODUCT_NAME = #{productName}, APPROVAL_NUM = #{approvalNum}, ENTERPRISE = #{enterprise},"
			+ " ENTERPRISE_ADDRESS = #{enterpriseAddress}, APPROVAL_DATE = #{approvalDate}, EXPIRED_DATE = #{expiredDate}"
			+ " WHERE ES_ID = #{esId}")
	void updateById(ItemInfo ItemInfo);
}

/**   
* @Title: ItemInfoProvider.java 
* @Package com.litbo.hospital.supervise.dao.provider 
* @Description: TODO(用一句话描述该文件做什么) 
* @author zhuyj   
* @date 2019-08-30 
*/
package com.litbo.hospital.supervise.dao.provider;

import com.litbo.hospital.supervise.bean.ItemInfo;

/** 
* @ClassName: ItemInfoProvider 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author: zhuyj
* @date: 2019-08-30 
*/
public class ItemInfoProvider {
	public String selectByPage(ItemInfo itemInfo) {
		StringBuffer sql = new StringBuffer(" SELECT ES_ID, PRODUCT_NAME, APPROVAL_NUM, ENTERPRISE, ENTERPRISE_ADDRESS, APPROVAL_DATE, EXPIRED_DATE, "
				+ " case when datediff(day,EXPIRED_DATE,GetDate()) >= -1 then 1 else 0 end AS expired "
				+ " from ITEM_INFO where 1=1 ");
		
		if(itemInfo.getEsId() != null) {
			sql.append(" and ES_ID Like '%'+#{esId}+'%'");
		}
		
		if(itemInfo.getProductName() != null) {
			sql.append(" and PRODUCT_NAME Like '%'+#{productName}+'%'");
		}
		
		if(itemInfo.getApprovalNum() != null) {
			sql.append(" and APPROVAL_NUM Like '%'+#{approvalNum}+'%'");
		}
		
		if(itemInfo.getEnterprise() != null) {
			sql.append(" and ENTERPRISE Like '%'+#{enterprise}+'%'");
		}
		
		return sql.toString();
	}
}

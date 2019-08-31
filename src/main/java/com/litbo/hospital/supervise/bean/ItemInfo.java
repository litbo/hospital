/**   
* @Title: ItemInfo.java 
* @Package com.model 
* @Description: TODO(用一句话描述该文件做什么) 
* @author zhuyj   
* @date 2019-08-15 
*/
package com.litbo.hospital.supervise.bean;

import com.alibaba.fastjson.annotation.JSONField;

import lombok.Data;

/** 
* @ClassName: ItemInfo 
* @Description: ITEM_INFO 表对应实体类
* @author: zhuyj
* @date: 2019-08-15 
*/
@Data
public class ItemInfo{

	private String esId;
	private String productName;
	private String approvalNum;
	private String enterprise;
	private String enterpriseAddress;
	private String approvalDate;
	private String expiredDate;
	
	@JSONField(serialize = false, deserialize = false)
	private String expired;

	
	@Override
	public String toString() {
		return "{\"esId\":\"" + esId + "\"," + 
				"\"productName\":\"" + productName + "\"," +  
				"\"approvalNum\":\"" + approvalNum + "\"," + 
				"\"enterprise\":\"" + enterprise + "\"," + 
				"\"enterpriseAddress\":\"" + enterpriseAddress + "\"," + 
				"\"expiredDate\":\"" + expiredDate + "\"," + 
				"\"approvalDate\":\"" + approvalDate + 
				"}";
	}
	

	public int equal(ItemInfo another) {
		if(another == null) {
			return -1;
		}
		if(this.esId.equalsIgnoreCase(another.getEsId())) {
			if(this.productName.equalsIgnoreCase(another.getProductName()) &&
					this.approvalNum.equalsIgnoreCase(another.getApprovalNum()) && 
					this.enterprise.equalsIgnoreCase(another.getEnterprise()) && 
					this.enterpriseAddress.equalsIgnoreCase(another.getEnterpriseAddress()) && 
					this.expiredDate.equalsIgnoreCase(another.getExpiredDate()) && 
					this.approvalDate.equalsIgnoreCase(another.getApprovalDate())) {
				return 0;
			}
			return 1;
		}
		
		return  -1;
	}

}

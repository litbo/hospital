/**   
* @Title: ItemInfo.java 
* @Package com.model 
* @Description: TODO(用一句话描述该文件做什么) 
* @author zhuyj   
* @date 2019-08-15 
*/
package com.litbo.hospital.supervise.bean;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import lombok.Data;
import lombok.EqualsAndHashCode;

/** 
* @ClassName: ItemInfo 
* @Description: ITEM_INFO 表对应实体类
* @author: zhuyj
* @date: 2019-08-15 
*/
@Data
@EqualsAndHashCode(callSuper=true)
@TableName("ITEM_INFO")
public class ItemInfo extends Model<ItemInfo>{

	private static final long serialVersionUID = -2406466700647121948L;
	
	@TableId
	private String esId;
	private String productName;
	private String approvalNum;
	private String enterprise;
	private String enterpriseAddress;
	private String approvalDate;
	private String expiredDate;
	
	@JSONField(serialize = false, deserialize = false)
	@TableField(exist = false)
	private String expired;

	/** 
	* @Title: pkVal 
	* @Description: 定义主键
	* @return 
	* @see com.baomidou.mybatisplus.activerecord.Model#pkVal() 
	*/
	@Override
	protected Serializable pkVal() {
		// TODO Auto-generated method stub
		return this.esId;
	}
	
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

/**   
* @Title: SpringBeanUtil.java 
* @Package com.util 
* @Description: TODO(用一句话描述该文件做什么) 
* @author zhuyj   
* @date 2019-08-17 
*/
package com.litbo.hospital.supervise.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/** 
* @ClassName: SpringBeanUtil 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author: zhuyj
* @date: 2019-08-17 
*/
@Component
public class SpringBeanUtil implements ApplicationContextAware {
	
	private static ApplicationContext applicationContext = null;

	/* (非 Javadoc) 
	* <p>Title: setApplicationContext</p> 
	* <p>Description: </p> 
	* @param applicationContext
	* @throws BeansException 
	* @see org.springframework.context.ApplicationContextAware#setApplicationContext(org.springframework.context.ApplicationContext) 
	*/
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		SpringBeanUtil.applicationContext = applicationContext;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T getBean(String name) {
		if(name == null || applicationContext == null)
			return null;
		return (T) applicationContext.getBean(name);
	}
 
	/**
	 * 从静态变量applicationContext中得到Bean, 自动转型为所赋值对象的类型.
	 */
	public static <T> T getBean(Class<T> clazz) {
		return applicationContext.getBean(clazz);
	}


}

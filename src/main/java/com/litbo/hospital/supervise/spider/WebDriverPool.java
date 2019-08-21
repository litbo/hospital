/**
 * 
 */
package com.litbo.hospital.supervise.spider;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;

import com.litbo.hospital.supervise.config.SpiderProperties;
import com.litbo.hospital.supervise.util.SpringBeanUtil;
import org.openqa.selenium.Proxy.ProxyType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.phantomjs.PhantomJSDriverService.Builder;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/** 
* @ClassName: WebDriverPool 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author: zhuyj
* @date: 2019-08-16 
*/
public class WebDriverPool {
	private static Logger log = LoggerFactory.getLogger(WebDriverPool.class);
	
	private final static int DEFAULT_CAPACITY = 5;

	private final int capacity;

	private final static int STAT_RUNNING = 1;

	private final static int STAT_CLODED = 2;

	private AtomicInteger stat = new AtomicInteger(STAT_RUNNING);

	private WebDriver mDriver = null;

	@SuppressWarnings("unused")
	private boolean mAutoQuitDriver = true;

	private static final String DRIVER_PHANTOMJS = "phantomjs";

	protected static DesiredCapabilities sCaps;
	
	private SpiderProperties spiderProperties = SpringBeanUtil.getBean("spiderProperties");
	
	public void configure() throws IOException{
		String driver = spiderProperties.getDriver();
		String isUseProxy = spiderProperties.getProxyType();
		
		PhantomJSDriverService pjsds = null;
		
		if (driver.equals(DRIVER_PHANTOMJS)) {
			sCaps = new DesiredCapabilities();
			sCaps.setJavascriptEnabled(true);
			sCaps.setCapability("takesScreenshot", false);
			
			String[] phantomArgs = new String[]{"--webdriver-loglevel=" + spiderProperties.getDriverLoglevel()
												,"--web-security=false"
												,"--ssl-protocol=any"
												,"--ignore-ssl-errors=true"};
			
			File logfile = new File(spiderProperties.getDriverLogFile());
			
			Builder builder = new PhantomJSDriverService.Builder();
			
			builder.usingCommandLineArguments(phantomArgs)
					.withLogFile(logfile);
			
			// "phantomjs_exec_path"
			if (spiderProperties.getExecPath() != null) {
				String driverPath = WebDriverPool.class.getClassLoader().getResource(spiderProperties.getExecPath()).getPath();
				builder.usingPhantomJSExecutable(new File(driverPath));
			} else {
				throw new IOException(
						String.format(
								"Property '%s' not set!",
								PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY));
			}
			
			sCaps.setCapability("acceptSslCerts",true);
			
			if(isUseProxy.equals("on")){
				String proxyStr = spiderProperties.getProxyHost() + ":" + spiderProperties.getProxyPort();
				org.openqa.selenium.Proxy proxy = new org.openqa.selenium.Proxy();
				proxy.setSslProxy(proxyStr)
					.setHttpProxy(proxyStr);
				proxy.setProxyType(ProxyType.MANUAL);
				builder.withProxy(proxy);
			}
			pjsds = builder.build();
		}
		
		if (isUrl(driver)) {
			sCaps.setBrowserName("phantomjs");
			mDriver = new RemoteWebDriver(new URL(driver), sCaps);
		} else if (driver.equals(DRIVER_PHANTOMJS)) {
			mDriver = new PhantomJSDriver(pjsds, sCaps);
		}
		
	}
	
	private boolean isUrl(String urlString) {
		try {
			new URL(urlString);
			return true;
		} catch (MalformedURLException mue) {
			return false;
		}
	}
	
	/**
	 * store webDrivers created
	 */
	private List<WebDriver> webDriverList = Collections
			.synchronizedList(new ArrayList<WebDriver>());

	/**
	 * store webDrivers available
	 */
	private BlockingDeque<WebDriver> innerQueue = new LinkedBlockingDeque<WebDriver>();

	public WebDriverPool(int capacity) {
		this.capacity = capacity;
	}

	public WebDriverPool() {
		this(DEFAULT_CAPACITY);
	}

	/**
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public WebDriver get() throws InterruptedException {
		checkRunning();
		WebDriver poll = innerQueue.poll();
		if (poll != null) {
			return poll;
		}
		if (webDriverList.size() < capacity) {
			synchronized (webDriverList) {
				if (webDriverList.size() < capacity) {

					// add new WebDriver instance into pool
					try {
						configure();
						innerQueue.add(mDriver);
						webDriverList.add(mDriver);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}

		}
		return innerQueue.take();
	}
	
	public void returnToPool(WebDriver webDriver) {
		checkRunning();
		innerQueue.add(webDriver);
	}

	protected void checkRunning() {
		if (!stat.compareAndSet(STAT_RUNNING, STAT_RUNNING)) {
			throw new IllegalStateException("Already closed!");
		}
	}

	public void closeAll() {
		boolean b = stat.compareAndSet(STAT_RUNNING, STAT_CLODED);
		if (!b) {
			throw new IllegalStateException("Already closed!");
		}
		for (WebDriver webDriver : webDriverList) {
			log.info("Quit webDriver" + webDriver);
			webDriver.quit();
			webDriver = null;
		}
	}
}

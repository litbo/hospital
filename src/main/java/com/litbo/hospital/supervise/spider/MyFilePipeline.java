/**
 * 
 */
package com.litbo.hospital.supervise.spider;

import com.litbo.hospital.supervise.util.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;
import us.codecraft.webmagic.utils.FilePersistentBase;


/** 
* @ClassName: MyFilePipeline 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author: zhuyj
* @date: 2019-08-16 
*/
public class MyFilePipeline extends FilePersistentBase implements Pipeline {
	private static Logger log = LoggerFactory.getLogger(MyFilePipeline.class);
	/**
	 * create a FilePipeline with default path"/data/webmagic/"
	 */
	public MyFilePipeline() {
		setPath("/data/webmagic/");
	}

	public MyFilePipeline(String path) {
		setPath(path);
	}

	@Override
	public void process(ResultItems resultItems, Task task) {
		// TODO Auto-generated method stub
		Request request = resultItems.getRequest();
		String urlStr = request.getUrl();
		String info = resultItems.get("info");

		try {

			if (!urlStr.matches(".*?/cfda$") && !urlStr.matches(".*?totalNum=(\\d+)&currentPage=(\\d+)$")) {
				if(info != null) {
					log.info(info);
					FileUtil.appendFile(info + "\n");
				}
			}

			log.info("Processing complete");
		} catch (Exception e) {
			log.warn("write file error", e);
		} finally {
			try {

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			log.info("----------------------------------------------------------------");
		}
	}

}

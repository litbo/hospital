package com.litbo.hospital.common.utils;

import java.io.File;
import java.io.FileOutputStream;

public class FileUtil {
    /**
    * @Description: 文件上传
    * @Param: [file, filePath, fileName]
    * @return: void
    * @Author: Gowen
    * @Date: 2018/11/6
    */
    public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath+"\\"+fileName);
        out.write(file);
        out.flush();
        out.close();
    }
}

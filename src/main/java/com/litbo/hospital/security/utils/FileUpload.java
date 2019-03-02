package com.litbo.hospital.security.utils;

import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

public class FileUpload {
    public static String upload(String filePath, MultipartFile file){
        String newFileName = null;
        String insertPath = null;

        String PATH = "static/"+filePath;
        try {
            //获取跟目录
            File path = new File(ResourceUtils.getURL("classpath:").getPath());
            if(!path.exists()) path = new File("");
            File upload = new File(path.getAbsolutePath(),PATH);
            if(!upload.exists()) upload.mkdirs();
            insertPath = UUID.randomUUID().toString()+file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
            newFileName =upload.getAbsolutePath()+"\\" + insertPath;
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(new File(newFileName)));
            out.write(file.getBytes());
            out.flush();
            out.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return filePath+insertPath;



    }
}

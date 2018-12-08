package com.litbo.hospital.common.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;
/**
 *   filePath 文件储存文件夹
 *   multipartFile  文件
 *
 *   @return url
 *   @author li66
**/

public class UploadFile {

    public static String upload(String filePath, MultipartFile multipartFile){
        String fileName = multipartFile.getOriginalFilename();
        String newFileName = UUID.randomUUID().toString()+fileName.substring(fileName.lastIndexOf("."));
        java.io.File file = new java.io.File(filePath);
        if(!file.exists()){
            file.mkdirs();
        }
        try {

            multipartFile.transferTo(new java.io.File(filePath+newFileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

       return filePath+newFileName;

    }
}

package com.litbo.hospital.user.service.impl;

import com.litbo.hospital.common.utils.UploadFile;
import com.litbo.hospital.user.bean.SysLogo;
import com.litbo.hospital.user.dao.LogoDao;
import com.litbo.hospital.user.dao.SysDao;
import com.litbo.hospital.user.service.LogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class LogoServiceImpl implements LogoService {

    @Autowired
    private LogoDao logoDao;
    @Autowired
    private SysDao sysDao;


/*
    @Override
    public int setLogo(SysLogo logo) {
        if(logo.getLogo()!=null)   return logoDao.setLogo(logo);
        if(logo.getBbtt()!=null)   return logoDao.setBbtt(logo);
        if(logo.getSbbqtt()!=null) return logoDao.setSbbqtt(logo);
        return -1;
    }

    @Override
    public int setLogo(SysLogo logo, MultipartFile multipartFile) {
        if(logo.getLogo()!=null)   return logoDao.setLogo(logo);
        if(logo.getBbtt()!=null)   return logoDao.setBbtt(logo);
        if(logo.getSbbqtt()!=null) return logoDao.setSbbqtt(logo);
        return -1;
    }*/




    @Override
    public int setLogo(SysLogo logo, MultipartFile multipartFile) {
        String path = System.getProperty("user.dir");
        String filePath =path+"/logo/";
        String url = UploadFile.upload(filePath,multipartFile);
        int begin = url.indexOf("logo")+4;

        logo.setLogo(url.substring(begin,url.length()));
        if(sysDao.count("sys_logo")>0){
            return logoDao.updateLogo(logo);
        }
        return logoDao.setLogo(logo);
    }

    @Override
    public int setBbtt(SysLogo logo, MultipartFile multipartFile) {
        String path = System.getProperty("user.dir");
        String filePath =path+"/logo/";
        String url = UploadFile.upload(filePath,multipartFile);
        int begin = url.indexOf("logo")+4;
        logo.setBbtt(url.substring(begin,url.length()));
        if(sysDao.count("sys_logo")>0){
            return logoDao.updateLogo(logo);
        }
        return logoDao.setLogo(logo);
    }

    @Override
    public int setSbbqtt(SysLogo logo, MultipartFile multipartFile) {
        String path = System.getProperty("user.dir");
        String filePath =path+"/logo/";
        String url = UploadFile.upload(filePath,multipartFile);
        int begin = url.indexOf("logo")+4;
        logo.setSbbqtt(url.substring(begin,url.length()));
        if(sysDao.count("sys_logo")>0){
            return logoDao.updateLogo(logo);
        }
        return logoDao.setLogo(logo);
    }


    public  static  void  main (String args[]){

        String a ="C:\\hospital\\major/logo/fa0ceffb-a521-4577-aaa1-b081ff0ae01d.jpg";
        int begin = a.indexOf("logo")+4;
        System.out.println(begin);
        System.out.println( a.substring(begin,a.length()));
    }

}

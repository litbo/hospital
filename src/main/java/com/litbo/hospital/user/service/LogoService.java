package com.litbo.hospital.user.service;

import com.litbo.hospital.user.bean.SysLogo;
import org.springframework.web.multipart.MultipartFile;

public interface LogoService {


    int setLogo(SysLogo logo, MultipartFile multipartFile);


    int setBbtt(SysLogo logo, MultipartFile multipartFile);

    int setSbbqtt(SysLogo logo, MultipartFile multipartFile);
}

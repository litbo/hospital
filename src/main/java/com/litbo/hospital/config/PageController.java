package com.litbo.hospital.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("/")
    public String index(){
        return "forward:admin/index/index.html";
    }//如果未登录shiro拦截到login.html
}

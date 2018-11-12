package com.litbo.hospital.user.controller;

import com.litbo.hospital.common.vo.LoginVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/hospital")
public class LoginController {

    @RequestMapping("/")
    public String tologin(){
        return "login";
    }
    @RequestMapping("/tomain")
    public String tomain(){
        return "main";
    }
    @RequestMapping("/submit")
    @ResponseBody
    public Map<String,Object> submit(@Valid LoginVo loginVo, BindingResult bindingResult){
        Map<String,Object> map = new HashMap<String, Object>();
        if(bindingResult.hasErrors()){
            map.put("success",false);
            map.put("msg",bindingResult.getFieldError());
        }

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(loginVo.getUserName(),loginVo.getUserPwd());
        try {
            subject.login(token);
            //把用户名存入session
            Session session =  subject.getSession();
            session.setAttribute("username",loginVo.getUserName());

            map.put("success",true);
            map.put("msg","登录验证通过");

            return map;

        }catch (Exception e){
            map.put("success",false);
            map.put("msg","用户名密码错误");
            return map;
        }
    }
}

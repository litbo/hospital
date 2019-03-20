package com.litbo.hospital.user.controller;

import com.litbo.hospital.common.vo.LoginVo;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.supervise.bean.SEmp;
import com.litbo.hospital.supervise.service.EmpService;
import com.litbo.hospital.user.bean.SRight;
import com.litbo.hospital.user.bean.SRole;
import com.litbo.hospital.user.service.RightService;
import com.litbo.hospital.user.service.RoleService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.*;

@Controller
@RequestMapping("/hospital")
public class LoginController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private RightService rightService;
    @Autowired
    private EmpService empService;
    @RequestMapping("/")
    public String tologin(){
        return "login";
    }
    @RequestMapping("/tomain")
    public String tomain(){
        return "index";
    }

   /* public Map<String,Object> submit(@Valid LoginVo loginVo, BindingResult bindingResult){
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
    }*/

    @RequestMapping("/submit")
    @ResponseBody
    public Result submit(@Valid LoginVo loginVo, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            return Result.error(bindingResult.getFieldErrorCount());
        }
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(loginVo.getUserName(),loginVo.getUserPwd());


        try {
            subject.login(token);
            //把用户名存入session
            Session session =  subject.getSession();
            session.setAttribute("username",loginVo.getUserName());
            SEmp emp =  empService.getEmpsByUserId(loginVo.getUserName());
            session.setAttribute("emp",emp);
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            Set<String> roles = new HashSet<>();
            List<SRole> rolesByUsername = roleService.getRoleByUsername(loginVo.getUserName());
            for (SRole role : rolesByUsername) {
                roles.add(role.getRoleName());
                List<SRight> rightsByUsername = rightService.getRightsByRolename(role.getRoleName());
                for (SRight right : rightsByUsername) {
                    info.addStringPermission(right.getRightName());
                }
            }
            info.setRoles(roles);
            return Result.success(info);

        }catch (Exception e){
            return Result.error("用户名密码错误");
        }


    }
}



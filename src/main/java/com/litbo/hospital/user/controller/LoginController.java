package com.litbo.hospital.user.controller;

import com.litbo.hospital.common.vo.LoginVo;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.supervise.bean.SEmp;
import com.litbo.hospital.supervise.service.EmpService;
import com.litbo.hospital.user.bean.SRight;
import com.litbo.hospital.user.bean.SRole;
import com.litbo.hospital.user.bean.SysLogo;
import com.litbo.hospital.user.dao.LogoDao;
import com.litbo.hospital.user.dao.RoleDao;
import com.litbo.hospital.user.service.RightService;
import com.litbo.hospital.user.service.RoleService;
import com.litbo.hospital.user.service.UserService;
import com.litbo.hospital.user.vo.LiveEmpVo;
import com.litbo.hospital.user.vo.RoleRightVo;
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
    private UserService userService;
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private LogoDao logoDao;

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
            LiveEmpVo emp =  userService.getLiveUserById(loginVo.getUserName());
            session.setAttribute("emp",emp);
            SysLogo logos =logoDao.selectLogo();
            session.setAttribute("logos",logos);


            SRole role =  roleDao.getRole(loginVo.getUserName());
            List<SRight> rightsByUsername=null;
            if(role!=null)
            rightsByUsername = rightService.getRightsByRolename(role.getRoleName());
            RoleRightVo auth = new RoleRightVo();
            if(role!=null)
            auth.setRole(role.getRoleName());
            if(rightsByUsername!=null)
            auth.setRightList(rightsByUsername);
            rightsByUsername.add(new SRight());
            auth.setRightList(rightsByUsername);
            auth.setEmp(emp);
            auth.setLogos(logos);


            return Result.success(auth);

        }catch (Exception e){
            return Result.error("用户名密码错误");
        }


    }

    @RequestMapping("lock")
    @ResponseBody
    public Result lock(String userId, String userPwd){

        if(userId!=null&&userPwd!=null&&userPwd.equals(userService.getUserByUsername(userId).getUserPwd())){

            return Result.success();
        }
        return Result.error();

    }
}



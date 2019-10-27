package com.litbo.hospital.security.controller;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.security.service.KhService;
import com.litbo.hospital.security.vo.KhTablesVo;
import com.litbo.hospital.security.vo.KhVos;
import com.litbo.hospital.security.vo.KhZxinxiVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/px")
public class KhController {

    @Autowired(required = false)
    KhService khService;

    @RequestMapping("/kh")
    public Result kh(@RequestParam(value = "pageNum",required = false, defaultValue = "1") int pageNum,
                     @RequestParam(value = "pageSize",required = false, defaultValue = "15") int pageSize,
                     @RequestParam("id") String id, HttpSession session){
        session.setAttribute("gl_id",id);
        System.out.println("传送的计划id"+session.getAttribute("gl_id").toString());
        PageInfo pageInfo = khService.kh(pageNum,pageSize,id);
        return Result.success(pageInfo);
    }

    @RequestMapping("/khBc")
    public Result khBc(@RequestBody KhVos khVos,HttpSession session){
        System.out.println("进来了。。。。。。。。。。。。");
        //System.out.println("点击保存时的id+++++++++"+session.getAttribute("gl_id"));
        KhTablesVo []listT =  khVos.getListZb();
        System.out.println("所有"+khVos.toString());
        KhZxinxiVo ks = new KhZxinxiVo();
        System.out.println("进去之前:"+ks.toString());
        for(KhTablesVo k:listT){
            String khjg = k.getKhjg();
            ks.setKhjg(khjg);
            String llcj = k.getLlcj();
            ks.setLlcj(llcj);
            String sjcz =  k.getSjcz();
            ks.setSjcz(sjcz);
            String username = k.getUserName();
            ks.setUserName(username);
            ks.setPxry(khVos.getPxry());
            ks.setKsry(khVos.getKsry());
            ks.setKhry(khVos.getKhry());
            ks.setPjyj(khVos.getPjyj());
            ks.setJhId(session.getAttribute("gl_id").toString());
            System.out.println("进去之后:"+ks.toString());
        }
        System.out.println(khVos.toString());
        return Result.success();
    }

}

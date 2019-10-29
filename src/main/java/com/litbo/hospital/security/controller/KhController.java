package com.litbo.hospital.security.controller;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.security.service.KhService;
import com.litbo.hospital.security.service.impl.KhServiceImpl;
import com.litbo.hospital.security.vo.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.text.DecimalFormat;
import java.text.NumberFormat;

@RestController
@RequestMapping("/px")
public class KhController {

    @Autowired(required = false)
    KhService khService;

    @RequestMapping("/findInfo")
    public Result findInfo(@RequestParam(value = "pageNum",required = false, defaultValue = "1") int pageNum,
                           @RequestParam(value = "pageSize",required = false, defaultValue = "15") int pageSize){
        PageInfo pageInfo = khService.findInfo(pageNum,pageSize);
        return Result.success(pageInfo);
    }

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
        //System.out.println("点击保存时的id+++++++++idcee46e1c-02bc-4927-ae21-4f888dcc3601"+session.getAttribute("gl_id"));
        double pxjgCount = 0.0;
        double khjgCount = 0.0;
        KhTablesVo []listT =  khVos.getListZb();
        KhZxinxiVo ks = new KhZxinxiVo();
       // System.out.println("进去之前:"+ks.toString());
        if(listT != null&&listT.length>0){
            for(KhTablesVo k:listT){
                if(k.getLlcj()==null&&k.getSjcz()==null&&k.getKhjg()==null){
                    continue;
                }
                String pxjg = k.getPxjg();
                ks.setPxjg(pxjg);
                if(pxjg.equals("是")){
                    pxjgCount++;
                }
                String khjg = k.getKhjg();
                if(khjg.equals("及格")){
                    khjgCount++;
                }
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
//                boolean bool = khService.khBc(ks);
//                if (bool==false){
//                    if(pxjg.equals("是")){
//                        pxjgCount--;
//                    }
//
//                    if(khjg.equals("及格")){
//                        khjgCount--;
//                    }
//                }
                System.out.println("进去之后:"+ks.toString());
            }
            System.out.println("培训人数:"+pxjgCount+"考核及格人数:"+khjgCount);

        }

        ListJiGeVo jiGeVo = khService.findByKhjgJg();//查询数据库中及格总人数
        double AllkhjgCount = khjgCount+jiGeVo.getJige();
        System.out.println("总及格人数:"+AllkhjgCount);

        ListCanJiaVo canJiaVo = khService.findByPxjgIs();//数据库中出勤总人数+刚刚保存的出勤人数
        double AllpxjgCount = pxjgCount+canJiaVo.getCanjia();
        System.out.println("总出勤人数:"+AllpxjgCount);
     //   System.out.println(khVos.toString());

        //该计划中所有应到人数
        ListSumRenVo sumRenVo = khService.findsumRen(session.getAttribute("gl_id").toString());
        double sumRen = sumRenVo.getSumRen();
        System.out.println("应到人数"+sumRen);
        if(sumRen!=0.0){
            //将结果保留四位小数
            DecimalFormat d = new DecimalFormat("0.0000");
            String chuqinlv = d.format(AllpxjgCount/sumRen);
            String hegelv = d.format(AllkhjgCount/sumRen);
            //String hegelv = d.format(AllpxjgCount/sumRen);
//            System.out.println("合格率"+hegelv);
//            System.out.println("出勤率"+chuqinlv);
            //Double.parseDouble(hegelv);

            //将结果转化为百分制
            DecimalFormat df = new DecimalFormat("0.00%");
            String hgl = df.format(Double.parseDouble(hegelv));
            String pxl = df.format(Double.parseDouble(chuqinlv));
            /*
                插入合格率和出勤率之前判断是否存在已知数据,若有更新即可
             */
            LvJcVos jcVos =  khService.getPxlAndKhl(session.getAttribute("gl_id").toString());

            if(jcVos==null){
                khService.insertLv(hgl,pxl,session.getAttribute("gl_id").toString());
            }else{
                khService.updateLv(pxl,hgl,session.getAttribute("gl_id").toString());
            }
        }
        return Result.success();
    }

    @RequestMapping("/getYdRy")
    public Result getYdRy(@RequestParam(value = "pageNum",required = false, defaultValue = "1") int pageNum,
                          @RequestParam(value = "pageSize",required = false, defaultValue = "15") int pageSize
                    ,@RequestParam("id") String id)
    {
        PageInfo pageInfo = new PageInfo(khService.getYdRen(pageNum,pageSize,id));
        return Result.success(pageInfo);
    }

    @RequestMapping("/getSdRy")
    public Result getSdRy(@RequestParam(value = "pageNum",required = false, defaultValue = "1") int pageNum,
                          @RequestParam(value = "pageSize",required = false, defaultValue = "15") int pageSize
            ,@RequestParam("id") String id)
    {
        PageInfo pageInfo = new PageInfo(khService.getSdRen(pageNum,pageSize,id));
        return Result.success(pageInfo);
    }

    @RequestMapping("/getWdRy")
    public Result getWdRy(@RequestParam(value = "pageNum",required = false, defaultValue = "1") int pageNum,
                          @RequestParam(value = "pageSize",required = false, defaultValue = "15") int pageSize
            ,@RequestParam("id") String id)
    {
        PageInfo pageInfo = new PageInfo(khService.getWdRen(pageNum,pageSize,id));
        return Result.success(pageInfo);
    }

    @Test
    public void test(){

        double result1=0.67;
        DecimalFormat df = new DecimalFormat("0.00%");
        String r = df.format(result1);
        System.out.println("第二种"+r);
        
        double b = 6;
        double a = 2;
        DecimalFormat d = new DecimalFormat("0.0000");
        String r1 = d.format(a/b);
        System.out.println(r1);
     }



}

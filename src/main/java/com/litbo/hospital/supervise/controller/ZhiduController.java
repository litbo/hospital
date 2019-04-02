package com.litbo.hospital.supervise.controller;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.common.utils.poi.PoiWordToHtml;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.supervise.bean.SZhidu;
import com.litbo.hospital.supervise.dao.ZhiduDao;
import com.litbo.hospital.supervise.service.ZhiduService;
import com.litbo.hospital.supervise.vo.*;
import com.litbo.hospital.user.vo.LiveEmpVo;
import io.swagger.annotations.Api;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.net.URLDecoder;
import java.util.List;

@RestController
@RequestMapping("/supervise/zdgl")
@Api(tags = "制度审核管理")
public class ZhiduController {

    @Autowired
    private ZhiduService zhiduService;
    @Autowired
    private ZhiduDao zhiduDao;


    @GetMapping("/listZds")
    public Result getZds(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                         @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize){
        PageInfo date = zhiduService.getZds(pageNum,pageSize);
        return Result.success(date);
    }

    @GetMapping("/getZdById")
    public Result getZdById(String zdId){
        if(zdId.equals("")) return Result.success();
        SZhidu sZhidu = zhiduService.getZdById(zdId);
        return Result.success(sZhidu);
    }

    @GetMapping("/listZds2")
    public Result listZds2(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                         @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize){
        List<SZhidu> zds = zhiduDao.getZds();
        return Result.success(zds);
    }

    @RequestMapping("/listZdsByTimeAndZdNameAndZt")
    public Result listZdsByTimeAndZdNameAndZt(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                                              @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize,
                                              String startTime, String endTime, String zdName, String zdZt,String reFlag){
        PageInfo date = null;
        try {
            date = zhiduService.listZdsByTimeAndZdNameAndZt(pageNum,pageSize,startTime,endTime,zdName,zdZt,reFlag);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.success(date);
    }

    @GetMapping("/listZdsByZdZt")
    public Result listZdsByZdZt(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                         @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize,String zdZt){
        PageInfo date = zhiduService.listZdsByZdZt(pageNum,pageSize,zdZt);
        return Result.success(date);
    }

    @PostMapping("/saveZd")
    public Result saveZd(@RequestBody SZhidu zd){
        zhiduService.saveZd(zd);
        return Result.success();
    }
    @GetMapping("/deleteZd")
    public Result deteleZd(@RequestParam int zd_id){
        zhiduService.deteleZd(zd_id);
        return Result.success();
    }
    @PostMapping("/updateZd")
    public Result updateZd(@RequestBody SZhidu zd){
        zhiduService.updateZd(zd);
        return Result.success();
    }
    @PostMapping("/submit")
    public Result submit(@RequestBody ZhiduSubmitVO zhiduSubmitVO){
        //提交时 SZhidu对象包括信息 bmid  zdname  zdcontent  docurl  userid createTime
        zhiduService.submit(zhiduSubmitVO);
        return Result.success();
    }

    @PostMapping("/reSubmit")
    public Result reSubmit(@RequestBody ZhiduSubmitVO zhiduSubmitVO){
        zhiduService.reSubmit(zhiduSubmitVO);
        return Result.success();
    }

    @GetMapping("/listZdsByShr")
    public Result listZdsByShr(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                         @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize,String zdZt,String reFlag,String zdName){
        LiveEmpVo emp = (LiveEmpVo) SecurityUtils.getSubject().getSession().getAttribute("emp");
        String shrId = emp.getUserId();
        PageInfo date = zhiduService.listZdsByShr(pageNum,pageSize,shrId,zdZt,reFlag,zdName);
        return Result.success(date);
    }
    //通过审核人id获取待审核的制度的信息
    @GetMapping("/getShDetailMgs")
    public Result getShDetailMgsByZdId(@RequestParam Integer zdId,@RequestParam String shrId){
        ZdShDetailMsg date = zhiduService.getShDetailMgsByZdId(zdId,shrId);
        return Result.success(date);
    }

    @GetMapping("/getShProcesses")
    public Result getShProcesses(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                                 @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize,
                                 @RequestParam Integer zdId){
        PageInfo date = zhiduService.getShProcesses(pageNum,pageSize,zdId);
        return Result.success(date);
    }

    @PostMapping("/submitShMsg")
    public Result submitShMsg(@RequestBody ShMsgVO shMsgVO){

        zhiduService.submitShMsg(shMsgVO);
        return Result.success();
    }

    @PostMapping("/dpjSubmitMsg")
    public Result dpjSubmitMsg(@RequestBody ZpjSumbitVO zpjSumbitVO){
        zhiduService.dpjSubmitMsg(zpjSumbitVO);
        return Result.success();
    }


    @GetMapping("/getZpjMsgByZdId")
    public Result getZpjMsgByZdId(@RequestParam String zdId){
        ZpjMsgVO zpjMsgVO = zhiduService.getZpjMsgByZdId(zdId);


        return Result.success(zpjMsgVO);
    }
    @PostMapping("/dpjSubmitShMsg")
    public Result dpjSubmitShMsg(@RequestBody ShMsgVO shMsgVO){

        zhiduService.dpjSubmitShMsg(shMsgVO);
        return Result.success();
    }

    @PostMapping( "/importZdDoc")
    @ResponseBody
    public Result importZdDoc(@RequestParam("file") MultipartFile file) throws Exception{
        String fileName = file.getOriginalFilename();
        String docUrl = zhiduService.importZdDoc(file);
        return Result.success(docUrl);
    }
    @GetMapping( "/getDocByUrl")
    @ResponseBody
    public void getDocByUrl(HttpServletResponse res, HttpServletRequest req, String url) throws Exception{
        String filePath = System.getProperty("user.dir")+url;
        ServletOutputStream out;
        res.setContentType("text/html");
        res.setCharacterEncoding("UTF-8");
        res.setContentType("text/html");
//        String filePath = getClass().getResource(fileName).getPath();
//        String userAgent = req.getHeader("User-Agent");
//        if (userAgent.contains("MSIE") || userAgent.contains("Trident")) {
//            fileName = java.net.URLEncoder.encode(fileName, "UTF-8");
//        } else {
//            // 非IE浏览器的处理：
//            fileName = new String((fileName).getBytes("UTF-8"), "ISO-8859-1");
//        }
//        filePath = URLDecoder.decode(filePath, "UTF-8");
//        res.setHeader("Content-Disposition", "attachment;fileName=" + fileName);
        FileInputStream inputStream = new FileInputStream(filePath);
        out = res.getOutputStream();
        int b = 0;
        byte[] buffer = new byte[1024];
        while ((b = inputStream.read(buffer)) != -1) {
            // 4.写到输出流(out)中
            out.write(buffer, 0, b);
        }
        inputStream.close();

        if (out != null) {
            out.flush();
            out.close();
        }

    }

    @RequestMapping( "/readDocOnline")
    @ResponseBody
    public Result readDocOnline(String url) throws Exception{
        PoiWordToHtml.PoiWord07ToHtml(url);
        return Result.success();
    }

}

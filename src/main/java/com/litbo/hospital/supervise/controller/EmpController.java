package com.litbo.hospital.supervise.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.supervise.bean.SEmp;
import com.litbo.hospital.supervise.service.EmpService;
import com.litbo.hospital.supervise.vo.EmpDeleteVO;
import com.litbo.hospital.supervise.vo.EmpSelectVO;
import com.litbo.hospital.supervise.vo.EmpVO;
import com.litbo.hospital.user.vo.LiveEmpVo;
import io.swagger.annotations.Api;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/kwgl/empgl")
@Api(tags = "人员管理")
public class EmpController {
    @Autowired
    private EmpService empService;


    @PostMapping("/listSelectEmpsCols")
    public Result listSelectEmpsCols(@RequestParam(required = false) String key) {
        JSONArray myJsonArray = null;
        if ("checkbox".equals(key)){
            String jsonMessage = "[{'type': 'checkbox'}, " +
                    "{field: 'userId', title: '人员ID'}, " +
                    "{field: 'userXm', title: '人员姓名'}]";
            myJsonArray = JSONObject.parseArray(jsonMessage);
        }else if ("radio".equals(key)){
            String jsonMessage = "[{'type': 'radio'}, " +
                    "{field: 'userId', title: '人员ID'}, " +
                    "{field: 'userXm', title: '人员姓名'}]";
            myJsonArray = JSONObject.parseArray(jsonMessage);
        }
        PageInfo date = new PageInfo(myJsonArray);
        return Result.success(date);
    }

    @RequestMapping("/empSe")
    public Result empSe(){
        Map map =new HashMap();
        map.put("dom",
                "<div class='layui-inline'><input type=\"text\" name=\"userName\" class=\"layui-input\" placeholder=\"员工姓名\" autocomplete=\"off\"></div>" +
                        "    <div class='layui-input-inline mar10-0' align='center'>" +
                        "<button class='layui-btn' data-type='reload'>查询</button>" +
                        "</div>");

        Map m = new HashMap();
        m.put("url","/kwgl/empgl/listSelectEmpsByUserName");
        m.put("type","reload");
        String[] data = {"userName"};
        m.put("data",data);
        map.put("data",m);
        return Result.success(new JSONObject(map));

    }



    //获取Emp基本信息
    @RequestMapping("/listSelectEmps")
    public Result listSelectEmps(@RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
                                 @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize) {
        PageInfo info = empService.listSelectEmps(pageNum, pageSize);
        return Result.success(info);
    }

    //获取Emp基本信息
    @RequestMapping("/listSelectEmpsByUserName")
    public Result listSelectEmpsByUserName(@RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
                                 @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize,
                                 String userName) {
        List<EmpSelectVO> emps=empService.listSelectEmpsByUserName(pageNum, pageSize,userName);
        return Result.success(new PageInfo<>(emps));
    }

    @GetMapping("/listSelectEmpsByUserId")
    public Result listSelectEmpsByUserId(@RequestParam String userId) {
        EmpSelectVO selectVO = empService.listSelectEmpsByUserId(userId);
        return Result.success(selectVO);
    }

    @GetMapping("/listSelectEmpBybmIdAndUserIdAndStatus")
    public Result listSelectEmps(@RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
                                 @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize,
                                 String bmId, String userId,String status,String bmName) {
        PageInfo info = empService.listSelectEmpBybmIdAndUserId(pageNum, pageSize, bmId, userId,status,bmName);
        return Result.success(info);
    }


    @GetMapping("/listEmpsByBmId")
    public Result getEmpsByBmId(@RequestParam String bmId) {
        List<SEmp> emps = empService.getEmpsByBmId(bmId);
        return Result.success(emps);
    }

    @GetMapping("/getEmpsByUserId")
    public Result getEmpsByUserId(@RequestParam String userId) {
        if(userId.equals("")) return  Result.success();
        EmpVO emps = empService.getEmpsByUserId(userId);
        return Result.success(emps);
    }
    @PostMapping("/saveEmp")
    public Result saveEmp(@RequestBody SEmp emp) {

        if(empService.getEmpsByUserId(emp.getUserId())!=null){
            empService.updateEmp(emp);
        }else {
            empService.saveEmp(emp);
        }

        return Result.success();
    }

    @GetMapping("/deleteEmpByUserId")
    public Result deleteEmpByUserId(@RequestParam String empId) {
        empService.deleteEmpByUserId(empId);
        return Result.success();
    }

    @PostMapping("/deleteEmpsByUserIds")
    public Result deleteEmpsByUserIds(@RequestBody EmpDeleteVO deleteVO) {
        for(String userId:deleteVO.getUserIds()){
            empService.deleteEmpByUserId(userId);
        }
        return Result.success();
    }

    @GetMapping("/listEmpByBmId")
    public Result listEmpByBmId(@RequestParam String bmId) {
        List<SEmp> emps = empService.listEmpByBmId(bmId);
        return Result.success(emps);
    }

    @GetMapping("/listGcsEmp")
    public Result listGcsEmp() {
        List<SEmp> emps = empService.getWxEmps();
        return Result.success(emps);
    }

    //获取登陆人的同部门伙伴信息  只包括userId和userXm
    @RequestMapping("/listPartnerByUserId")
    public Result listPartnerByUserId(
            @RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize,
            @RequestParam(required = false) String key, HttpServletRequest request) {

        LiveEmpVo emp = (LiveEmpVo) SecurityUtils.getSubject().getSession().getAttribute("emp");
        String userId = emp.getUserId();
//        userId=(String) request.getSession().getAttribute("username");
        List<SEmp> sEmps = empService.listPartnerByUserId(userId, pageNum, pageSize);
        return Result.success(new PageInfo<>(sEmps));
    }

    @RequestMapping("/listBmPartnerByUserId")
    public Result listBmPartnerByUserId(
            @RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize,
            @RequestParam(required = false) String key, HttpServletRequest request) {

        LiveEmpVo emp = (LiveEmpVo) SecurityUtils.getSubject().getSession().getAttribute("emp");
        String userId = emp.getUserId();
//        userId=(String) request.getSession().getAttribute("username");
        List<SEmp> sEmps = empService.listBmPartnerByUserId(userId, pageNum, pageSize);
//        return Result.success(new PageInfo<>(sEmps));
        return Result.success(sEmps);
    }


    @PostMapping( "/batchImportEmps")
    @ResponseBody
    public Result batchImportEmps(@RequestParam("file") MultipartFile file) throws Exception{
        String fileName = file.getOriginalFilename();
        if(empService.batchImportBms(fileName,file) == 0){
            return Result.error();
        }
        return Result.success();
    }

    @RequestMapping("/setQzzp")
    public Result setQzzp(@RequestParam("img")MultipartFile img){
        String docUrl = empService.setQzzp(img);
        String pjpath = System.getProperty("user.dir");
        docUrl=docUrl.replace(pjpath+"\\emp\\","");
        return Result.success("\\"+docUrl);
    }



    @RequestMapping(value="getImg" )
    @ResponseBody
    public void getImg(String imgPathEncode,HttpServletResponse response) throws IOException {

        response.setContentType("text/html");
        String imgPath = URLDecoder.decode(imgPathEncode, "utf-8");
        imgPath= imgPathEncode.replaceAll("/","\\\\") ;

        String pjpath = System.getProperty("user.dir");

        String realUrl =pjpath+"\\"+imgPath;

        File file = new File(realUrl);
        if(file.exists()) {
            FileInputStream in = new FileInputStream(file);
            OutputStream os = response.getOutputStream();
            byte[] b = new byte[1024];
            while(in.read(b)!= -1) {
                os.write(b);
            }
            in.close();
            os.flush();
            os.close();
        }
    }

}

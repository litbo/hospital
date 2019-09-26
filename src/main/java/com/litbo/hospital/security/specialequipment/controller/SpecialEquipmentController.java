package com.litbo.hospital.security.specialequipment.controller;


import com.github.pagehelper.PageInfo;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.security.specialequipment.bean.SpecialEquipment;
import com.litbo.hospital.security.specialequipment.bean.vo.AgreeApplys;
import com.litbo.hospital.security.specialequipment.bean.vo.DeleteSpeqsVo;
import com.litbo.hospital.security.specialequipment.bean.vo.SpecialEquipmentEmployeeVo;
import com.litbo.hospital.security.specialequipment.bean.vo.UserVo;
import com.litbo.hospital.security.specialequipment.service.SpecialEquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.net.URLDecoder;


@RestController
@RequestMapping("/specialEq")
public class SpecialEquipmentController {

    @Autowired
    private SpecialEquipmentService specialEquipmentService ;

    //查询部门以及负责人信息
    @GetMapping("/selectSpEqBmInfo")
    public Result selectSpEqBmInfo(@RequestParam(required = false,defaultValue = "10") Integer pageSize,
                                   @RequestParam(required = false,defaultValue = "1") Integer pageNum){
        try {
            PageInfo pageInfo = specialEquipmentService.selectSpEqBmInfo(pageNum, pageSize);
            return Result.success(pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("读取信息错误");
        }


    }
    //查询部门以及负责人信息根据部门名称
    @PostMapping("/selectSpEqBmInfoByName")
    public Result selectSpEqBmInfoByName(@RequestParam(required = false,defaultValue = "10") Integer pageSize,
                                         @RequestParam(required = false,defaultValue = "1") Integer pageNum,
                                         @RequestParam String bmName){
        try {
            PageInfo pageInfo = specialEquipmentService.selectSpEqBmInfoByName(pageNum, pageSize, bmName);
            return Result.success(pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("读取信息错误");
        }
    }




    //录入特种设备信息
    @PostMapping("/insertSpecialEq")
    public Result insertSpecialEq(@RequestBody SpecialEquipment specialEquipment){

        try {
            int specialEq = specialEquipmentService.insertSpecialEq(specialEquipment);
            return Result.success(specialEq);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("读取信息错误");
        }

    }
    //删除特种设备信息根据设备id
    @PostMapping("/deleteSpecialEq")
    public Result deleteSpecialEq(@RequestBody String[] speqIds){

        try {
            for (String speqId : speqIds) {
                specialEquipmentService.deleteSpecialEq(speqId.trim());
            }
            return Result.success();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("读取信息错误");
        }
    }
    //修改设备信息根据设备
    @PostMapping("/updateSpecialEq")
    public Result updateSpecialEq(@RequestBody SpecialEquipment specialEquipment){
        try {
            return Result.success(specialEquipmentService.updateSpecialEq(specialEquipment));
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("读取信息错误");
        }
    }
    //查询特种设备信息根据id
    @PostMapping("/selectSpecialEqById")
    public Result selectSpecialEqById(@RequestParam String speqId){
        try {
            SpecialEquipment specialEq = specialEquipmentService.selectSpecialEqById(speqId);
            return Result.success(specialEq);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("读取信息错误");
        }
    }
    //查询所有特种设备
    @GetMapping("/selectSpecialEqVo")
    public Result selectSpecialEqVo(@RequestParam(required = false,defaultValue = "10") Integer pageSize,
                                  @RequestParam(required = false,defaultValue = "1") Integer pageNum){
        try {
            PageInfo pageInfo = specialEquipmentService.selectSpecialEq(pageNum, pageSize);
            return Result.success(pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("读取信息错误");
        }
    }
    //查询特种设备信息Vo根据设备id name 类型 生产商 科室名称 设备状态
    @PostMapping("/selectSpeqVoByBhAndNameAndScsAndTypeAndBmId")
    public Result selectSpeqVoByBhAndNameAndScsAndTypeAndBmId(@RequestParam(required = false,defaultValue = "10") Integer pageSize,
                                                              @RequestParam(required = false,defaultValue = "1") Integer pageNum,
                                                              @RequestParam(required = false,name = "speqBh") String speqBh,  @RequestParam(required = false,name = "speqName") String speqName,
                                                              @RequestParam(required = false,name = "speqScs") String speqScs,@RequestParam(required = false,name = "speqType",defaultValue = "2") int speqType,
                                                              @RequestParam(required = false,name = "bmId") String bmId,@RequestParam(required = false, name = "speqRun", defaultValue = "2")int speqRun){

        System.out.println(speqBh);
        try {
            PageInfo pageInfo = specialEquipmentService
                                    .selectSpeqVoByBhAndNameAndScsAndTypeAndBmId(pageNum, pageSize, speqBh, speqName, speqScs, speqType, bmId, speqRun);
            return Result.success(pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("读取信息错误");
        }
    }
    //查询特种设备结果记录根据speqId
    @PostMapping("/selectSpeqRecordBySpeqBh")
    public Result selectSpeqRecordBySpeqBh(@RequestParam(required = false,defaultValue = "10") Integer pageSize,
                                           @RequestParam(required = false,defaultValue = "1") Integer pageNum,
                                           @RequestParam("speqBh") String speqBh){
        try {
            PageInfo page = specialEquipmentService.selectSpeqRecordBySpeqId(pageNum, pageSize, speqBh);
            return Result.success(page);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("读取信息错误");
        }
    }










    //查询所有不是特种设备从业人员的用户
    @GetMapping("/selectAllUser")
    public Result selectAllUser(@RequestParam(required = false,defaultValue = "10") Integer pageSize,
                                @RequestParam(required = false,defaultValue = "1") Integer pageNum){
        try {
//            List<UserVo> userVos = specialEquipmentService.selectAllUser();
            PageInfo<UserVo> pageInfo = specialEquipmentService.selectAllUser(pageNum, pageSize);
            return Result.success(pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("读取信息错误");
        }
    }
    //查询所有是特种设备从业人员的用户
    @GetMapping("/selectAllUserIsSpem")
    public Result selectAllUserIsSpem(@RequestParam(required = false,defaultValue = "10") Integer pageSize,
                                      @RequestParam(required = false,defaultValue = "1") Integer pageNum){
        try {
            PageInfo<UserVo> pageInfo = specialEquipmentService.selectAllUserIsSpem(pageNum, pageSize);
            return Result.success(pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("读取信息错误");
        }
    }
    //查询员工信息根据id name bmname
    @PostMapping("/selectUserByIdAndNameAndBmName")
    public Result selectUserByIdAndNameAndBmName(@RequestParam(required = false,defaultValue = "10") Integer pageSize,
                                                 @RequestParam(required = false,defaultValue = "1") Integer pageNum,
                                                 @RequestParam("userId") String userId,
                                                 @RequestParam("userXm") String userXm,
                                                 @RequestParam("bmName") String bmName){
        try {
            PageInfo pageInfo = specialEquipmentService.selectUserByIdAndNameAndBmName(pageNum, pageSize, userId, userXm, bmName);
            return Result.success(pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("读取信息错误");
        }

    }
    //查询特种设备员工信息根据id name bmname
    @PostMapping("/selectSpeqUserByIdAndNameAndBmName")
    public Result selectSpeqUserByIdAndNameAndBmName(@RequestParam(required = false,defaultValue = "10") Integer pageSize,
                                                     @RequestParam(required = false,defaultValue = "1") Integer pageNum,
                                                     @RequestParam("userId") String userId,
                                                     @RequestParam("userXm") String userXm,
                                                     @RequestParam("bmName") String bmName){
        try {
            PageInfo pageInfo = specialEquipmentService.selectSpeqUserByIdAndNameAndBmName(pageNum, pageSize, userId, userXm, bmName);
            return Result.success(pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("读取信息错误");
        }

    }
    //将员工设为特种设备从业人员
    @PostMapping("/updateIsSpeqEm")
    public Result updateIsSpeqEm(@RequestBody AgreeApplys agreeApplys){
        try {
            String[] userIds= agreeApplys.getUserIds();
            for (String userId : userIds) {
                specialEquipmentService.updateIsSpeqEm(userId.trim());
            }
            return Result.success();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("读取信息错误");
        }
    }
    //将员工剔除特种设备从业人员
    @PostMapping("/updateIsNotSpeqEm")
    public Result updateIsNotSpeqEm(@RequestBody String[] userIds){
        try {
            for (String userId : userIds) {
                specialEquipmentService.updateIsNotSpeqEm(userId.trim());
            }
            return Result.success();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("读取信息错误");
        }
    }
    //根据user_id查询user信息
    @PostMapping("/selectSpemById")
    public Result selectSpemById(@RequestParam String userId){
        try {
            SpecialEquipmentEmployeeVo specialEquipmentEmployee = specialEquipmentService.selectSpemById(userId);
            return Result.success(specialEquipmentEmployee);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("读取信息错误");
        }
    }
    //更改数据
    @PostMapping("/updateSpem")
    public Result updateSpem(@RequestBody SpecialEquipmentEmployeeVo specialEquipmentEmployee){
        try {
            int i = specialEquipmentService.updateSpem(specialEquipmentEmployee);
            return Result.success(i);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("读取信息错误");
        }
    }

    //到期日期排序
    @GetMapping("/selctDate")
    public Result selctDate(@RequestParam(required = false,defaultValue = "10") Integer pageSize,
                            @RequestParam(required = false,defaultValue = "1") Integer pageNum){
        try {
            return Result.success(specialEquipmentService.selctDate(pageNum, pageSize));
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("读取信息错误");
        }
    }



    //选中图片返回照片的相对路径
    @RequestMapping("/setSpemImg")
    public Result setSpemImg(@RequestParam("img")MultipartFile img){
        String docUrl = specialEquipmentService.setSpemImg(img);
        String pjpath = System.getProperty("user.dir");
        docUrl=docUrl.replace(pjpath+"\\spEqEmployee\\","");
        return Result.success("\\"+docUrl);
    }

    //Excel导入设备信息
    @RequestMapping("/importSpeqInfo")
    public Result importEq(MultipartFile file) {
        if (specialEquipmentService.importSpeqInfo(file) < 0) {
            return Result.error();
        }
        return Result.success();
    }

    /**
     * 描述：下载外部案件导入模板
     * @throws Exception
     */
    @RequestMapping(value = "/downloadExcel")
    @ResponseBody
    public void downloadExcel(HttpServletResponse res, HttpServletRequest req, String name) throws Exception {
        String fileName = name+".xlsx";
        ServletOutputStream out;
        res.setContentType("multipart/form-data");
        res.setCharacterEncoding("UTF-8");
        res.setContentType("text/html");
        /* String filePath = getClass().getResource("/templates/" + fileName).getPath();*/
        String filePath = System.getProperty("user.dir")+"/templates/"+fileName;
        String userAgent = req.getHeader("User-Agent");

        if (userAgent.contains("MSIE") || userAgent.contains("Trident")) {
            //IE
            fileName = java.net.URLEncoder.encode(fileName, "UTF-8");
        } else {
            // 非IE浏览器的处理：
            fileName = new String((fileName).getBytes("UTF-8"), "ISO-8859-1");
        }
        filePath = URLDecoder.decode(filePath, "UTF-8");
        res.setHeader("Content-Disposition", "attachment;fileName=" + fileName);
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



}

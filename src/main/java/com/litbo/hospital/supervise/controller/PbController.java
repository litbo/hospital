package com.litbo.hospital.supervise.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.supervise.bean.KaoqinVO;
import com.litbo.hospital.supervise.bean.PbJhVO;
import com.litbo.hospital.supervise.service.PbService;
import com.litbo.hospital.supervise.vo.RyVos;
import com.litbo.hospital.supervise.vo.getPbPlanVos;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/pb")
public class PbController {

    @Autowired
    private PbService pbService;
    @RequestMapping("/pbPlan")
    public Result pbPlan( PbJhVO pbJhVO){
        if (pbJhVO.getUserId()==null){
            return Result.error("人員為空");
        }else {
            pbService.addPbPlan(pbJhVO);

        }
        return Result.success();
    }

    @RequestMapping("getPbPlan")
    public Result getPbPlan(@RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
                            @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize){
        List<getPbPlanVos> pbPlanVosList = pbService.getPbPlan(pageNum,pageSize);
        if(pbPlanVosList!=null){
            return Result.success(new PageInfo(pbPlanVosList));
        }else{
            return Result.error("没有值班计划,请添加!");
        }
    }

    @RequestMapping("/getBmPeople")
    public Result getBmpeople(@RequestParam("bmId") String bmId,
                                @RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
                                @RequestParam(value = "pageSize", required = false, defaultValue = "15") int pageSize){
        System.out.println(bmId);
        String str = bmId.replaceAll("\\\"", "");
        return  Result.success(pbService.getBmpeople(str,pageNum,pageSize));

    }

    @RequestMapping("/getPbPeople")
    public Result getPbPeople(@RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
                              @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize,
                              @RequestParam("pbJhid") String id, HttpSession session)
    {
        session.setAttribute("pb_id",id);
        System.out.println("点击考勤是的id"+session.getAttribute("pb_id").toString());
        List<RyVos> ryVos = pbService.getPbPeople(pageNum,pageSize,id);
        if(ryVos!=null){
            return Result.success(new PageInfo(ryVos));
        }else{
            return Result.error("没有值班人员,请添加!");
        }
    }

    @RequestMapping("/ghPeople")
    public Result ghPeople(@RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
                              @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize,
                              HttpSession session)
    {
        String sid = session.getAttribute("pb_id").toString();
        System.out.println("点击更换时的id"+sid);
        List<RyVos> ryVos = pbService.ghPeople(pageNum,pageSize,sid);
        if(ryVos!=null){
            return Result.success(new PageInfo(ryVos));
        }else{
            return Result.error("没有值班人员,请添加!");
        }
    }


    /**
     * 导入学员清单
     * @param
     * @param
     * @return
     * @throws IOException
     */

    @RequestMapping(value = "/importKaoqin",method = RequestMethod.POST)
    @ResponseBody
    public Result importUsers(@RequestParam MultipartFile file, HttpServletRequest request) throws IOException {
        System.out.println("调用成功");
        List<KaoqinVO> list = new ArrayList<KaoqinVO>();
        XSSFWorkbook workbook =null;

        //把MultipartFile转化为File
        CommonsMultipartFile cmf= (CommonsMultipartFile) file;
        DiskFileItem dfi=(DiskFileItem) cmf.getFileItem();
        File fo=dfi.getStoreLocation();

        //创建Excel，读取文件内容
        workbook = new XSSFWorkbook(FileUtils.openInputStream(fo));

        //获取第一个工作表
        XSSFSheet sheet = workbook.getSheet("学员信息");

        //获取sheet中第一行行号
        int firstRowNum = sheet.getFirstRowNum();
        //获取sheet中最后一行行号
        int lastRowNum = sheet.getLastRowNum();

        try {
            //循环插入数据
            for(int i=firstRowNum+1;i<=lastRowNum;i++){
                XSSFRow row = sheet.getRow(i);

                KaoqinVO kaoqin = new KaoqinVO();
//                kaoqin.setStatus(true);//默认为启用状态

                XSSFCell userId = row.getCell(0);//人员id
                if(userId!=null){
                    userId.setCellType(Cell.CELL_TYPE_STRING);
                    kaoqin.setUserId((userId.getStringCellValue()));
                }

                XSSFCell userName = row.getCell(1);//人员姓名
                if(userName!=null){
                    userName.setCellType(Cell.CELL_TYPE_STRING);
                    kaoqin.setUserName((userName.getStringCellValue()));
                }
                list.add(kaoqin);
                System.out.println(list);
            }
            //usersMapper.insert(list);//往数据库插入数据
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            workbook.close();
        }

        System.out.println("文件上传成功");
        return Result.success();

    }
}

package com.litbo.hospital.metering.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.metering.dao.MeteringHistoryNumberDAO;
import com.litbo.hospital.metering.pojo.*;
import com.litbo.hospital.metering.service.MaintenanceRecordsService;
import com.litbo.hospital.metering.service.MeteringService;
import com.litbo.hospital.metering.util.ExcelUtil;
import com.litbo.hospital.metering.vo.PageVo;
import com.litbo.hospital.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

/**
 * @Author: 樊小铭
 * Date: 2019/8/8 12:42
 * @Version:
 * @Description:
 */
@RestController
@RequestMapping("/Metering")
public class MeteringController {

    @Autowired
    private MeteringService meteringService;

    @Autowired
    private MeteringHistoryNumberDAO meteringHistoryNumberDAO;

    @Autowired
    private MaintenanceRecordsService maintenanceRecordsService;

    /**
     * 添加计量设备信息
     * @param meteringutil 计量设备的信息
     * @return
     */
    @RequestMapping("/addMeteringUtil.do")
    public Result addMetering(MeteringUtil meteringutil){
        int result = meteringService.addMeteringUtil(meteringutil);
        if(result == 1){
            return Result.success();
        }
        return Result.error("添加失败,数据库中可能已经存在此编号的设备");
    }


    /**
     * 永久删除计量设备
     * @param meteringUtilId 计量设备的id
     * @return
     */
    @RequestMapping("/deleterMeteringUtil.do")
    public Result deleteMeteringUtil(int meteringUtilId){
        int result = meteringService.deleteMeteringUtil(meteringUtilId);
        if(result == 1){
            return Result.success();
        }
        return Result.error("删除失败，请重试");
    }



    /**
     * 更新设备信息
     * @param meteringUtil 更新的设备信息
     * @return
     */
    @RequestMapping("/updateMeteringUtil.do")
    public Result updateMeteringUtil(MeteringUtil meteringUtil,MeteringUtilStatus status){
        if(status != null){
            updateUtilUseStatus(status);
        }

        status.setUtilId(meteringUtil.getId());
        int result = meteringService.updateMeteringUtil(meteringUtil);
        if(result == 1){
            return Result.success();
        }
        return Result.error("信息更新失败,请检查数据重试");
    }

    /**
     * 根据设备id查询设备信息
     * @param id 设备id
     * @return
     */
    @RequestMapping("/findMeteringUtilById.do")
    public Result findMeteringUtilById(int id){
        MeteringUtil meteringUtil = meteringService.findMeteringUtilById(id);
        if(meteringUtil == null){
            return Result.error("没有查询到该设备的相关信息，请检查输入的id是否正确");
        }
        return Result.success(meteringUtil);
    }


    /**
     * 查询所有的设备信息
     * @param sign  标记
     * @param gaugeCategory  器具类别
     * @param meteringName  器具名称
     * @param bmName  使用科室
     * @param meteringstatus 器具状态
     * @param beginTime 开始时间
     * @param endTime  结束时间
     * @param needMeter 是否送检
     * @param pageNum 分页页码
     * @param pageSize 分页每页数据数量
     * @return
     */
    @RequestMapping("/findAllMeteringUtil.do")
    public PageVo findAllMeteringUtil(@RequestParam(name = "sign" ,defaultValue = "-1") Integer sign,
                                      @RequestParam(name = "gaugeCategory" , defaultValue = "") String gaugeCategory,
                                      @RequestParam(name = "meteringName" ,defaultValue = "") String meteringName ,
                                      @RequestParam(name = "bmName" , defaultValue = "") String bmName,
                                      @RequestParam(name = "meteringstatus" , defaultValue = "") String meteringstatus,
                                      @RequestParam(name = "beginTime" , defaultValue = "0000/00/00") String beginTime,
                                      @RequestParam(name = "endTime" , defaultValue = "9999/99/99") String endTime,
                                      @RequestParam(name = "needMeter",defaultValue = "")String needMeter,
                                      @RequestParam(name = "pageNum" , defaultValue = "1") int pageNum,
                                      @RequestParam(name = "pageSize" , defaultValue = "15") int pageSize){
        if(gaugeCategory.equals("")){
            gaugeCategory = null;
        }

        if(sign == -1){
            sign = null;
        }

        if(meteringName.equals("")){
            meteringName = null;
        }

        if(bmName.equals("")){
            bmName = null;
        }

        if(meteringstatus.equals("")){
            meteringstatus = null;
        }

        if(needMeter.equals("")){
            needMeter = null;
        }


        PageHelper.startPage(pageNum,pageSize);
        List<MeteringUtil> meteringUtils = meteringService.findAllMeteringUtilAllCheck(sign,gaugeCategory,meteringName,bmName,meteringstatus,beginTime,endTime,needMeter);

        PageInfo info = new PageInfo(meteringUtils);

        PageVo vo = new PageVo();
        if(!meteringUtils.isEmpty()){
            vo.setCode(0);
            vo.setMsg("success");
            vo.setData(vo.new DataEntity((int) info.getTotal(),meteringUtils));
            return vo;
        }

        vo.setMsg("没有查询到设备信息");
        vo.setCode(0);
        vo.setData(vo.new DataEntity((int) info.getTotal(),meteringUtils));
        return vo;
    }



    /**
     * 按部门查看在用设备信息
     * @param bmName
     * @return
     */
    @RequestMapping("/findAllNeedMeteringUtilByDepartment.do")
    public PageVo findAllNeedMeteringUtilByDepartment(@RequestParam(name = "pageNum" , defaultValue = "1") int pageNum,
                                                      @RequestParam(name = "pageSize" , defaultValue = "15") int pageSize,
                                                      @RequestParam(name = "bmName" , defaultValue = "%")String bmName){
        if(bmName.equals("%")){
            bmName = null;
        }
        PageHelper.startPage(pageNum,pageSize);
        List<MeteringUtil> meteringUtils = meteringService.findAllMeteringUtilByDepartment(bmName);
        PageInfo info = new PageInfo(meteringUtils);
        PageVo vo = new PageVo();
        if(!meteringUtils.isEmpty()){
            vo.setCode(0);
            vo.setMsg("success");
            vo.setData(vo.new DataEntity((int) info.getTotal(),meteringUtils));
            return vo;
        }
        vo.setMsg("没有查询到设备信息");
        vo.setCode(0);
        vo.setData(vo.new DataEntity((int) info.getTotal(),meteringUtils));
        return vo;
    }





    /**
     *  根据部门查看设备信息
     * @param bmName
     * @return
     */
    @RequestMapping("/findAllMeteringUtilByDepartment.do")
    public PageVo findAllMeteringUtilByDepartment(@RequestParam(name = "pageNum" , defaultValue = "1") int pageNum,
                                                  @RequestParam(name = "pageSize" , defaultValue = "15") int pageSize,
                                                  @RequestParam(name = "bmName" , defaultValue = "%")String bmName,
                                                  @RequestParam(name = "meteringUtilName" , defaultValue = "%")String meteringUtilName){
        PageVo vo = new PageVo();
        if(bmName.equals("%") ){
            bmName = null;
        }

        if (meteringUtilName.equals("%")){
            meteringUtilName = null;
        }

        PageHelper.startPage(pageNum,pageSize);
        List<MeteringUtil> meteringUtils = meteringService.findAllMeteringUtilByDepartmentAndMeteringUtilName(bmName,meteringUtilName);

        PageInfo info = new PageInfo(meteringUtils);
        if(!meteringUtils.isEmpty()){
            vo.setCode(0);
            vo.setMsg("success");
            vo.setData(vo.new DataEntity((int) info.getTotal(),meteringUtils));
            return vo;
        }
        vo.setMsg("没有查询到设备信息");
        vo.setCode(0);
        vo.setData(vo.new DataEntity((int) info.getTotal(),meteringUtils));
        return vo;
    }



    /**
     * 查找在某一时间段需要计量的设备信息
     * @param beginTime
     * @param endTiem
     * @return
     */
    @RequestMapping("/findAllMeteringUtilByTime.do")
    public PageVo findAllMeteringUtilByTime(@RequestParam(name = "pageNum" , defaultValue = "1") int pageNum,
                                            @RequestParam(name = "pageSize" , defaultValue = "15") int pageSize,
                                            @RequestParam(name = "beginTime" , defaultValue = "0000/00/00") String beginTime,
                                            @RequestParam(name = "endTiem" , defaultValue = "9999/99/99") String endTiem){
        PageHelper.startPage(pageNum,pageSize);
        List<MeteringUtil> meteringUtils = meteringService.findAllMeteringUtilByTime(beginTime, endTiem);
        PageInfo info = new PageInfo(meteringUtils);
        PageVo vo = new PageVo();
        if(!meteringUtils.isEmpty()){
            vo.setCode(0);
            vo.setMsg("success");
            vo.setData(vo.new DataEntity((int) info.getTotal(),meteringUtils));
            return vo;
        }
        vo.setMsg("没有查询到设备信息");
        vo.setCode(0);
        vo.setData(vo.new DataEntity((int) info.getTotal(),meteringUtils));
        return vo;
    }




    /**
     * 多条件查询
     * @param beginTime 开始时间
     * @param endTiem 结束时间
     * @param bmName 部门
     * @param description 设备状态,0未进入审批流程，1已进入审批流程
     * @return
     */
    @RequestMapping("/searchMeteringUtil.do")
    public PageVo searchMeteringUtil(@RequestParam(name = "pageNum" , defaultValue = "1") int pageNum,
                                     @RequestParam(name = "pageSize" , defaultValue = "15") int pageSize,
                                     @RequestParam(name = "beginTime" , defaultValue = "0000/00/00") String beginTime,
                                     @RequestParam(name = "endTiem" , defaultValue = "9999/99/99") String endTiem,
                                     @RequestParam(name = "bmName" , defaultValue = "%")String bmName,
                                     @RequestParam(name = "description" , defaultValue = "%") String description){
        if(bmName.equals("%")){
            bmName = null;
        }
        if(description.equals("%")){
            description = null;
        }

        PageHelper.startPage(pageNum,pageSize);
        List<MeteringUtil> meteringUtils = meteringService.searchMeteringUtil(beginTime, endTiem, bmName, description);
        PageInfo info = new PageInfo(meteringUtils);
        PageVo vo = new PageVo();
        if(!meteringUtils.isEmpty()){
            vo.setCode(0);
            vo.setMsg("success");
            vo.setData(vo.new DataEntity((int) info.getTotal(),meteringUtils));
            return vo;
        }
        vo.setMsg("没有查询到设备信息");
        vo.setCode(0);
        vo.setData(vo.new DataEntity((int) info.getTotal(),meteringUtils));
        return vo;
    }


    /**
     * 得到未来90天中需要送去检查的计量设备，按照部门来分类
     * @param department 部门
     * @return
     */
    @RequestMapping("/getTheMonthUtil.do")
    public PageVo getTheMonthNeedToMeteringUtils(@RequestParam(name = "pageNum" , defaultValue = "1") int pageNum,
                                                 @RequestParam(name = "pageSize" , defaultValue = "15") int pageSize,
                                                 @RequestParam(name = "department" , defaultValue = "") String department){

        if(department.equals("")){
            department = null;
        }

        // 得到当前月的第一天和最后一天的日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.DAY_OF_MONTH, 1);//设置为1号,当前日期既为本月第一天
        String firstDay = sdf.format(calendar.getTime());
        calendar.add(Calendar.MONTH,2);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));  // 设置日期为本月的最后一天
        String endDay = sdf.format(calendar.getTime());

//        通过日期来查询未来90天尚未进行计量的设备
        PageHelper.startPage(pageNum,pageSize);
        List<MeteringUtil> meteringUtils = meteringService.searchMeteringUtil(firstDay,endDay,department,"0");
        PageInfo info = new PageInfo(meteringUtils);
        PageVo vo = new PageVo();
        if(!meteringUtils.isEmpty()){
            vo.setCode(0);
            vo.setMsg("success");
            vo.setData(vo.new DataEntity((int) info.getTotal(),meteringUtils));
            return vo;
        }
        vo.setMsg("没有查询到设备信息");
        vo.setCode(0);
        vo.setData(vo.new DataEntity((int) info.getTotal(),meteringUtils));
        return vo;
    }


    /**
     * 删除设备历史编号信息
     * @param id
     * @return
     */
    @RequestMapping("/deleteMeteringHistoryNum.do")
    public Result deleteMeteringHistroyNum(int id){
        int result = meteringHistoryNumberDAO.deleteByPrimaryKey(id);
        if(result == 0){
            return Result.error("删除失败");
        }
        return Result.success();
    }


    /**
     * 查询设备历史编号信息
     * @param pageNum
     * @param pageSize
     * @param id
     * @return
     */
    @RequestMapping("/seeAllHistoryNum.do")
    public PageVo seeAllHistoryNum(@RequestParam(name = "pageNum" , defaultValue = "1") int pageNum,
                                   @RequestParam(name = "pageSize" , defaultValue = "15") int pageSize,int id){
        PageHelper.startPage(pageNum,pageSize);
        List<MeteringHistoryNumber> meteringHistoryNumbers = meteringHistoryNumberDAO.findAllMeteringHistoryNumber(id);
        PageInfo info = new PageInfo(meteringHistoryNumbers);
        PageVo vo = new PageVo();
        if(!meteringHistoryNumbers.isEmpty()){
            vo.setCode(0);
            vo.setMsg("success");
            vo.setData(vo.new DataEntity((int) info.getTotal(),meteringHistoryNumbers));
            return vo;
        }
        vo.setMsg("没有查询到设备信息");
        vo.setCode(0);
        vo.setData(vo.new DataEntity((int) info.getTotal(),meteringHistoryNumbers));
        return vo;
    }


    /**
     * 设备使用状态更改
     * @param status
     * @return
     */
    @RequestMapping("/updateUtilUseStatus.do")
    public Result updateUtilUseStatus(MeteringUtilStatus status){
        int result = meteringService.updateMeteringUtilUseStatus(status);
        if(result == 0){
            return Result.error("删除失败");
        }
        return Result.success();
    }


    /**
     * 得到设备状态信息
     * @param id
     * @return
     */
    @RequestMapping("/getUtilStatusMsg.do")
    public Result getUtilStatusMsg(int id){
        MeteringUtilStatus status = meteringService.getMeteringUtilUseStatusByUtilId(id);
        if(status == null){
            return Result.success();
        }
        return Result.success(status);
    }


    /**
     * 添加修理信息
     * @param maintenanceRecords
     * @return
     */
    @RequestMapping("/addMaintenanceRecords.do")
    public Result addMaintenanceRecords(MaintenanceRecords maintenanceRecords){
        int result = maintenanceRecordsService.insert(maintenanceRecords);
        if(result == 0){
            return Result.success("添加失败");
        }
        return Result.success();
    }


    /**
     * 删除修理信息
     * @param id
     * @return
     */
    @RequestMapping("/deleteMaintenanceRecords.do")
    public Result deleteMaintenanceRecords(int id){
        int result = maintenanceRecordsService.deleteByPrimaryKey(id);
        if(result == 0){
            return Result.success("删除失败");
        }
        return Result.success();
    }

    /**
     * 查看修理信息
     * @param id
     * @return
     */
    @RequestMapping("/seedeleteMaintenanceRecords.do")
    public PageVo seedeleteMaintenanceRecords(int id,
                                              @RequestParam(name = "pageNum" , defaultValue = "1") int pageNum,
                                              @RequestParam(name = "pageSize" , defaultValue = "15") int pageSize){

        PageHelper.startPage(pageNum,pageSize);
        List<MaintenanceRecords> list = maintenanceRecordsService.seeAllRecords(id);
        PageInfo info = new PageInfo(list);
        PageVo vo = new PageVo();
        if(!list.isEmpty()){
            vo.setCode(0);
            vo.setMsg("success");
            vo.setData(vo.new DataEntity((int) info.getTotal(),list));
            return vo;
        }
        vo.setMsg("没有查询到设备信息");
        vo.setCode(0);
        vo.setData(vo.new DataEntity((int) info.getTotal(),list));
        return vo;
    }



    @RequestMapping("/ImportExcelToAddMeteringUtil.do")
    public void ImportExcelToAddMeteringUtil(@RequestParam("file") MultipartFile file,String userXm){
//        if (file.isEmpty()) {
//            return Result.error("上传失败，请选择文件");
//        }
//
//        // 文件名
//        String fileName = file.getOriginalFilename();
//        String[] fileNameCheck = fileName.split(".");
//        if(!fileNameCheck[1].equals("xlsx")){
//            return Result.success("上传文件格式错误！");
//        }


        // 创建文件所在的文件夹
        File dir = new File("D:\\hospitalConfigFile\\temp\\");
        if(!dir.exists()){
            dir.mkdirs();
        }

        String filePath = "D:\\hospitalConfigFile\\temp\\"+file.getOriginalFilename();

        File dest = new File(filePath);

        try {
            file.transferTo(dest);
        } catch (IOException e) {
        }

        List list= ExcelUtil.importExcelContent(filePath);
        System.out.println(list);

    }
}

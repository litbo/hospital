package com.litbo.hospital.metering.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.metering.dao.MeteringHistoryNumberDAO;
import com.litbo.hospital.metering.pojo.MeteringHistoryNumber;
import com.litbo.hospital.metering.pojo.MeteringUtil;
import com.litbo.hospital.metering.service.MeteringService;
import com.litbo.hospital.metering.vo.PageVo;
import com.litbo.hospital.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.security.util.AuthResources_it;

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
     * 废弃计量设备
     * @param meteringUtilId
     * @return
     */
    @RequestMapping("/disableMeteringUtil.do")
    public Result disableMeteringUtil(int meteringUtilId){
        int result = meteringService.disableDevice(meteringUtilId);
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
    public Result updateMeteringUtil(MeteringUtil meteringUtil){
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
     * 根据设备编号查询设备信息
     * @param num 设备编号
     * @return
     */
    @RequestMapping("/findMeteringUtilByNum.do")
    public Result findMeteringUtilByNum(String num){
        MeteringUtil meteringUtil = meteringService.findMeteringUtilByUtilNum(num);
        if(meteringUtil == null){
            return Result.error("没有查询到该设备的相关信息，请检查输入的id是否正确");
        }
        return Result.success(meteringUtil);
    }



    /**
     * 查询所有的设备信息
     * @return
     */
    @RequestMapping("/findAllMeteringUtil.do")
    public PageVo findAllMeteringUtil(int pageIndex,int pageSize){
        PageHelper.startPage(pageIndex,pageSize);
        List<MeteringUtil> meteringUtils = meteringService.findAllMeteringUtil();

        PageInfo info = new PageInfo(meteringUtils);

        PageVo vo = new PageVo();
        if(!meteringUtils.isEmpty()){
            vo.setCode(0);
            vo.setMsg("success");
            vo.setData(vo.new DataEntity((int) info.getTotal(),meteringUtils));
            return vo;
        }

        vo.setMsg("error");
        vo.setCode(1);
        return vo;
    }


    /**
     *  根据部门查看设备信息
     * @param department
     * @return
     */
    @RequestMapping("/findAllMeteringUtilByDepartment.do")
    public Result findAllMeteringUtilByDepartment(String department){
        List<MeteringUtil> meteringUtils = meteringService.findAllMeteringUtilByDepartment(department);
        if(meteringUtils.isEmpty()){
            return Result.error("没有找到任何数据呦");
        }
        return Result.success(meteringUtils);
    }



    /**
     * 查找在某一时间段需要计量的设备信息
     * @param beginTime
     * @param endTiem
     * @return
     */
    @RequestMapping("/findAllMeteringUtilByTime.do")
    public Result findAllMeteringUtilByTime(String beginTime, String endTiem){
        List<MeteringUtil> meteringUtils = meteringService.findAllMeteringUtilByTime(beginTime, endTiem);
        if(meteringUtils.isEmpty()){
            return Result.error("没有找到任何数据呦");
        }
        return Result.success(meteringUtils);
    }



    /**
     * 按部门查看在用设备信息
     * @param department
     * @return
     */
    @RequestMapping("/findAllNeedMeteringUtilByDepartment.do")
    public Result findAllNeedMeteringUtilByDepartment(String department){
        List<MeteringUtil> meteringUtils = meteringService.findAllMeteringUtilByDepartment(department);
        if(meteringUtils.isEmpty()){
            return Result.error("没有找到任何数据呦");
        }
        return Result.success(meteringUtils);
    }


    /**
     * 多条件查询
     * @param beginTime 开始时间
     * @param endTiem 结束时间
     * @param department 部门
     * @param description 设备状态,0未进入审批流程，1已进入审批流程
     * @return
     */
    @RequestMapping("/searchMeteringUtil.do")
    public Result searchMeteringUtil(String beginTime, String endTiem, String department, String description){
        List<MeteringUtil> meteringUtils = meteringService.searchMeteringUtil(beginTime, endTiem, department, description);
        if(meteringUtils.isEmpty()){
            return Result.error("没有找到任何数据呦");
        }
        return Result.success(meteringUtils);
    }


    /**
     * 得到这一个月中需要送去检查的计量设备，按照部门来分类
     * @param department 部门
     * @return
     */
    @RequestMapping("/getTheMonthUtil.do")
    public Result getTheMonthNeedToMeteringUtils(String department){

        // 得到当前月的第一天和最后一天的日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);//设置为1号,当前日期既为本月第一天
        String firstDay = sdf.format(calendar.getTime());
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));  // 设置日期为本月的最后一天
        String endDay = sdf.format(calendar.getTime());

//        通过日期来查询本月尚未进行计量的设备
        List<MeteringUtil> meteringUtils = meteringService.searchMeteringUtil(firstDay,endDay,department,"1");
        if(meteringUtils.isEmpty()){
            return Result.error("本月暂无需要进行计量的设备！");
        }
        return Result.success(meteringUtils);
    }

    @RequestMapping("/deleteMeteringHistoryNum.do")
    public Result deleteMeteringHistroyNum(int id){
        int result = meteringHistoryNumberDAO.deleteByPrimaryKey(id);
        if(result == 0){
            return Result.error("删除失败");
        }
        return Result.success();
    }


    @RequestMapping("/seeAllHistoryNum.do")
    public Result seeAllHistoryNum(int id){
        List<MeteringHistoryNumber> meteringHistoryNumbers = meteringHistoryNumberDAO.findAllMeteringHistoryNumber(id);
        if(meteringHistoryNumbers.isEmpty()){
            return Result.error("没有查到该设备的历史编号信息！");
        }
        return Result.success(meteringHistoryNumbers);
    }
}

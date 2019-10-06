package com.litbo.hospital.security.inspectionplan.controller;


import com.github.pagehelper.PageInfo;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.security.inspectionplan.bean.InspEqStandard;
import com.litbo.hospital.security.inspectionplan.service.InspPlStandardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 巡检计划标准Controller
 *
 * @author Administrator on 2019-07-31
 */
@RestController
@RequestMapping("/inspection/inspPlStandard")
public class InspEqStandardController {


    @Autowired
    private InspPlStandardService
            inspPlStandardService;


    /**
     * 查询巡检计划标准根据Id
     * @param
     * @return int
     */
    @PostMapping("/selectStandardById")
    public Result selectStandardById(@RequestParam String inspPlStandardId){
        try {
            InspEqStandard i = inspPlStandardService.selectStandardById(inspPlStandardId);
            return Result.success(i);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("巡检计划标准添加失败");
        }
    }
    /**
     * 添加巡检计划标准
     * @param inspEqStandard
     * @return int
     */
    @PostMapping("/insertInspStandard")
    public Result insertInspStandard(@RequestBody InspEqStandard inspEqStandard){
        try {
            int i = inspPlStandardService.insertInspStandard(inspEqStandard);
            return Result.success(i);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("巡检计划标准添加失败");
        }
    }

    /**
     * 功能描述: 删除巡检计划标准
     *
     * @Param: inspPlStandardIds
     * @Return: int
     * @Author: ZYJ
     * @Date: 2019/8/1 0001 9:51
     */
    @PostMapping("/deleteInspStandard")
    public Result deleteInspStandard(@RequestBody String[] inspPlStandardIds){
        try {
            int i = inspPlStandardService.deleteInspStandard(inspPlStandardIds);
            return Result.success(i);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("删除巡检计划标准失败");
        }
    }

    /**
     * 功能描述: 修改巡检计划标准
     *
     * @Param: inspEqStandard
     * @Return: int
     * @Author: ZYJ
     * @Date: 2019/8/1 0001 10:06
     */
    @PostMapping("/updateInspStandard")
    public Result updateInspStandard(@RequestBody InspEqStandard inspEqStandard){
        try {
            int i = inspPlStandardService.updateInspStandard(inspEqStandard);
            return Result.success(i);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("修改巡检计划标准失败");
        }
    }


    /**
     * 功能描述: 查询所有巡检计划标准项 & 根据name 查询
     *
     * @Param: [pageSize, pageNum]
     * @Return: com.litbo.hospital.result.Result
     * @Author: ZYJ
     * @Date: 2019/7/31 0031 18:27
     */
    @PostMapping("/selectInspStandard")
    public Result selectInspStandard(@RequestParam(required = false,defaultValue = "10") Integer pageSize,
                                     @RequestParam(required = false,defaultValue = "1") Integer pageNum,
                                     @RequestParam String inspPlStandardName){
        try {
            PageInfo<InspEqStandard> inspEqStandardPageInfo = inspPlStandardService.selectInspEqStandard(pageNum, pageSize, inspPlStandardName);
            return Result.success(inspEqStandardPageInfo);
        }catch (Exception e){
            e.printStackTrace();
            return Result.error("巡检计划标准查询失败");
        }
    }

    /**
     * 功能描述: 查询所有巡检计划标准项
     *
     * @Param: [pageSize, pageNum]
     * @Return: com.litbo.hospital.result.Result
     * @Author: ZYJ
     * @Date: 2019/7/31 0031 18:27
     */
    @GetMapping("/selectAllInspStandard")
    public Result selectAllInspStandard(@RequestParam(required = false,defaultValue = "10") Integer pageSize,
                                     @RequestParam(required = false,defaultValue = "1") Integer pageNum){
        try {
            PageInfo<InspEqStandard> inspEqStandardPageInfo = inspPlStandardService.selectAllInspEqStandard(pageNum, pageSize);
            return Result.success(inspEqStandardPageInfo);
        }catch (Exception e){
            e.printStackTrace();
            return Result.error("巡检计划标准查询失败");
        }
    }


}

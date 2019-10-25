package com.litbo.hospital.security.controller;

import com.litbo.hospital.common.utils.poi.ExcelData;
import com.litbo.hospital.common.utils.poi.ExportExcelUtil;
import com.litbo.hospital.result.CodeMsg;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.security.bean.FwBlsj;
import com.litbo.hospital.security.enums.EnumApplyStatus;
import com.litbo.hospital.security.service.FwBlsjService;
import com.litbo.hospital.user.vo.LiveEmpVo;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("security/blsj")
public class FwBlsjController {
//    Logger logger = LoggerFactory.getLogger(FwBlsjController.class);
    @Autowired
    private FwBlsjService blsjService;
    @RequestMapping(value = "insertFwBlsj",method = RequestMethod.POST)
    public Result insertFwBlsj(@RequestBody FwBlsj blsj){
        LiveEmpVo sEmp = (LiveEmpVo)SecurityUtils.getSubject().getSession().getAttribute("emp");
        try {
            if(blsjService.insertFwBlsj(blsj,sEmp)>0)
                return Result.success();
            else
                return Result.error();
        }catch (Exception e){
            log.error("insertFwBlsj参数错误 FwBlsj={}",blsj);
            e.printStackTrace();
            return Result.error(CodeMsg.SERVER_ERROR);
        }

    }
    @RequestMapping(value = "updateFwBlsjStatus",method = RequestMethod.POST)
    public Result updateFwBlsjStatus(Integer status,  Integer id,  Integer taskId){
        try {
            if(status != null && (status==EnumApplyStatus.APPLY_APPROVAL.getCode() || status==EnumApplyStatus.APPLY_REJECT.getCode())){
                int res = blsjService.updateFwBlsjStatus( status,   id,   taskId);
                if(res>0){
                    return Result.success();
                }else {
                    return Result.error(CodeMsg.PARAM_ERROR);
                }
            }else {
                return Result.error(CodeMsg.PARAM_ERROR);
            }
        }catch (Exception e){
            e.printStackTrace();
            return Result.error(CodeMsg.SERVER_ERROR);
        }



    }
    @RequestMapping(value = "listFwBlsj",method = RequestMethod.GET)
    public Result listFwBlsj(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                                   @RequestParam(value = "pageSize" ,required = false,defaultValue="10")int pageSize,
                             @RequestParam(required = false) String cpmc, @RequestParam(required = false)String bgrXm){
        return  Result.success(blsjService.listFwBlsj(pageNum,pageSize,cpmc,bgrXm));


    }
    @RequestMapping(value = "listFwBlsjWaitExamine",method = RequestMethod.GET)
    public Result listFwBlsjWaitExamine(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                             @RequestParam(value = "pageSize" ,required = false,defaultValue="10")int pageSize,
                            @RequestParam(required = false) String cpmc, @RequestParam(required = false)String bgrXm){
//                             @RequestParam(required = false)String sbcsName, @RequestParam(required = false)String bgmc){
        return  Result.success(blsjService.listFwBlsjWaitExamine(pageNum,pageSize,cpmc,bgrXm));
    }
    @ApiOperation(value = "通过id查询不良事件")
    @RequestMapping(value = "selectFwBlsjById",method = RequestMethod.GET)
    public Result selectFwBlsjById(Integer id) {
        try {
            FwBlsj fwBlsj = blsjService.selectFwBlsjById(id);
            if (fwBlsj != null)
                return Result.success(fwBlsj);
            else
                return Result.error(CodeMsg.PARAM_ERROR);
        } catch (Exception e) {
            log.error("selectFwBlsjById参数错误 id={}",id);
            return Result.error(CodeMsg.SERVER_ERROR);
        }
    }

    @ApiOperation(value = "导出不良事件到excel")
    @RequestMapping(value = "/listFwBlsjExport",method = RequestMethod.GET)

    public Result listFwBlsjExport(@RequestParam(required = false) String cpmc, @RequestParam(required = false)String bgrXm,
                                   HttpServletResponse response, @RequestParam(value = "fileName",required = true,defaultValue = "不良事件.xls") String fileName){
        List<String> titles = Arrays.asList("id","报告日期","上报科室","联系电话","条码号","报告人姓名","产品名称","注册证编号","型号","规格","产品批号","产品编号","院内编码","UDI","生产日期",
                "有效期至","上市许可持有人姓名","事件发生日期","发现或获知日期","伤害","伤害表现","器械故障表现","姓名","出生日期","年龄类型","年龄","性别","病历号","既往病史","预期治疗疾病与作用","器械使用日期","使用场所"
                ,"场所名称","使用过程","合并用药/械情况说明","事件原因分析","事件原因分析描述","初步处置情况","设备id（保留字段）","报告人id","创建日期","类别(1 设备   2 物资)","审核人id","不良事件状态","报修单号");
        List pjzds = blsjService.listFwBlsjExport(cpmc,bgrXm);
        ExcelData data = new ExcelData(titles,pjzds,"sheet");
        try {
            ExportExcelUtil.exportExcel(response,fileName,data);
        }catch (Exception e){
            e.printStackTrace();
            log.error("异常信息",e.getMessage(),cpmc , bgrXm);
        }
        return null;
    }



}

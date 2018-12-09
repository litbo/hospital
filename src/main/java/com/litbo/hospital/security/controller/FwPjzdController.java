package com.litbo.hospital.security.controller;
import com.litbo.hospital.common.utils.poi.ExcelData;
import com.litbo.hospital.common.utils.poi.ExportExcelUtil;
import com.litbo.hospital.result.CodeMsg;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.security.bean.FwPjzd;
import com.litbo.hospital.security.service.FwPjzdService;
import com.sun.org.apache.regexp.internal.RE;
import com.sun.tools.javac.jvm.Code;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//import com.litbo.hospital.security.enums.EnumStatus;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("security/pjzd")
@Api(value = "security/pjzd" ,description = "配件字典操作")
public class FwPjzdController {
    @Autowired
    private FwPjzdService pjzdService;


    /**
     * 插入一个新的配件字典
     * @param pjzd
     * @return
     */
    @ApiOperation(value = "插入配件字典")
    @ApiResponses(value = {@ApiResponse(code = 500,message = "服务器端异常",response = Result.class)})
    @RequestMapping(value = "/insertFwPjzd",method = RequestMethod.POST)
    public Result insertFwPjzd(@RequestParam(required = true) FwPjzd pjzd){
        try {
            if(pjzdService.insertFwPjzd(pjzd)>0){
                return Result.success();
            }else {
                return Result.error(CodeMsg.PARAM_ERROR);
            }
        }catch (Exception e){
            return Result.error(CodeMsg.PARAM_ERROR);
        }

    }

    /**
     *
     * @param pjSzm 配件首字母
     * @param pageNum
     * @param pageSize
     * @param pjfl  配件分类
     * @return
     */
    @ApiOperation(value = "查询所有配件字典")
    @RequestMapping(value = "/listFwPjzd",method = RequestMethod.GET)
    public Result listFwPjzd(@RequestParam(value = "pjSzm",required = false) String pjSzm,
                              @RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                              @RequestParam(value = "pageSize" ,required = false,defaultValue="10")int pageSize,
                              @RequestParam(value = "pjfl" ,required = false) String pjfl){
        try {
            return Result.success(pjzdService.listFwPjzd( pjSzm, pageNum, pageSize, pjfl));
        }catch (Exception e){
            return Result.error(CodeMsg.SERVER_ERROR);
        }

    }

    /**
     * 导出配件字典到excel
     * @param pjSzm
     * @param pjfl
     * @param response
     */
    @ApiOperation(value = "导出配件字典到excel")
    @RequestMapping(value = "/listFwPjzdExport",method = RequestMethod.GET)
    public void listFwPjzdExport(@RequestParam(value = "pjSzm",required = false) String pjSzm,
                                   @RequestParam(value = "pjfl" ,required = false) String pjfl,
                                 HttpServletResponse response,@RequestParam(value = "fileName",required = true) String fileName){
        List<String> titles = Arrays.asList(new ExcelData().getFiledName(FwPjzd.class));
        ExcelData data = new ExcelData(titles,pjzdService.listFwPjzdExport(pjSzm , pjfl),"sheet");
        try {
            ExportExcelUtil.exportExcel(response,fileName,data);
        }catch (Exception e){

        }

    }


}

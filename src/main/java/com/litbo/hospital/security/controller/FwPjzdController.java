package com.litbo.hospital.security.controller;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.common.utils.poi.ExcelData;
import com.litbo.hospital.common.utils.poi.ExportExcelUtil;
import com.litbo.hospital.result.CodeMsg;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.security.bean.FwPjzd;
import com.litbo.hospital.security.service.FwPjzdService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletResponse;
import java.util.*;

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
    public Result insertFwPjzd(FwPjzd pjzd){
        try {
            if(pjzdService.insertFwPjzd(pjzd)>0){
                return Result.success();
            }else {
                return Result.error(CodeMsg.PARAM_ERROR);
            }
        }catch (Exception e){
            e.printStackTrace();
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
    @RequestMapping(value = "/listFwPjzd",method = RequestMethod.POST)
    public Result listFwPjzd(@RequestParam(value = "pjSzm",required = false) String pjSzm,
                              @RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                              @RequestParam(value = "pageSize" ,required = false,defaultValue="10")int pageSize,
                              @RequestParam(value = "pjfl" ,required = false) String pjfl){
        try {
            PageInfo pageInfo = pjzdService.listFwPjzd( pjSzm, pageNum, pageSize, pjfl);
            return Result.success(pageInfo);
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

    public Result listFwPjzdExport(@RequestParam(value = "pjSzm",required = false) String pjSzm,
                                   @RequestParam(value = "pjfl" ,required = false) String pjfl,
                                 HttpServletResponse response,@RequestParam(value = "fileName",required = true) String fileName){
        List<String> titles = Arrays.asList("配件编号","配件名称","型号规格","注册证号","注册证到期日期","生产厂家","供货商");
        List pjzds = pjzdService.listFwPjzdExport(pjSzm , pjfl);
        ExcelData data = new ExcelData(titles,pjzds,"sheet");
        try {
            ExportExcelUtil.exportExcel(response,fileName,data);
            return Result.success();
        }catch (Exception e){
            return Result.error(CodeMsg.SERVER_ERROR);
        }
    }
    @RequestMapping(value = "fwPjzdTitle",method = RequestMethod.POST)
    public Result fwPjzdTitle(){
        String title ="[{'type': 'radio'}, "+
                "{field: 'pjbh', title: '配件编号'},"+
                "{field: 'pjName', title: '配件名称'},"+
                "{field: 'pjGgxh', title: '规格型号'},"+
                "{field: 'pjZczh', title: '注册证号'},"+
                "{field: 'pjZczDqTime', title: '注册证到期日期'},"+
                "{field: 'scqyName', title: '生产厂家'},"+
                "{field: 'ghsName', title: '供货商'},"+
                "]";
        return Result.success(JSON.parseArray(title));

    }


}


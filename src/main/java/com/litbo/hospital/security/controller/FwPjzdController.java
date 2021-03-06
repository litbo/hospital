package com.litbo.hospital.security.controller;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.common.utils.poi.ExcelData;
import com.litbo.hospital.common.utils.poi.ExportExcelUtil;
import com.litbo.hospital.result.CodeMsg;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.security.bean.FwPjzd;
import com.litbo.hospital.security.service.FwPjzdService;
import com.litbo.hospital.security.vo.DeleteFwPjzdByIdsVo;
import com.litbo.hospital.security.vo.SelectFwPjzdVo;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletResponse;
import java.util.*;

@RestController
@RequestMapping("security/pjzd")
@Api(value = "security/pjzd" ,description = "配件字典操作")
@Slf4j
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
    public Result insertFwPjzd(@RequestBody FwPjzd pjzd){
        try {
            if(pjzdService.insertFwPjzd(pjzd)>0){
                return Result.success();
            }else {
                log.error("异常信息",pjzd);
                return Result.error(CodeMsg.PARAM_ERROR);
            }
        }catch (Exception e){
            log.error("异常信息",e.getMessage());
            return Result.error(CodeMsg.PARAM_ERROR);
        }

    }
    @ApiOperation(value = "查询单个配件字典")
    @RequestMapping(value = "selectFwPjzdById",method = RequestMethod.GET)
    public Result selectFwPjqlById(Integer id){
        try {
            SelectFwPjzdVo pjzd = pjzdService.selectFwPjzdById(id);
            return Result.success(pjzd);
        }catch (Exception e){
            log.error("异常信息",e.getMessage(),id);
            return Result.error(CodeMsg.PARAM_ERROR);
        }


    }
    @ApiOperation(value = "更新配件字典")
    @RequestMapping(value = "updateFwPjzd",method = RequestMethod.POST)
    public Result updateFwPjzd(@RequestBody FwPjzd pjzd){
        try {
            Integer res = pjzdService.updateFwPjzd(pjzd);
            if(res>0){
                return Result.success();
            }else {
                return Result.error(CodeMsg.SERVER_ERROR);
            }
        }catch (Exception e){
            e.printStackTrace();
            log.error("异常信息",e.getMessage(),pjzd);
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
    @RequestMapping(value = "/listFwPjzd")
    public Result listFwPjzd(@RequestParam(value = "pjSzm",required = false,defaultValue = "") String pjSzm,
                              @RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                              @RequestParam(value = "pageSize" ,required = false,defaultValue="10")int pageSize,
                              @RequestParam(value = "pjfl" ,required = false) String pjfl){
        try {
            PageInfo pageInfo = pjzdService.listFwPjzd( pjSzm, pageNum, pageSize, pjfl);
            return Result.success(pageInfo);
        }catch (Exception e){
            log.error("异常信息",e.getMessage());
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
        }catch (Exception e){
            log.error("异常信息",e.getMessage(),pjSzm , pjfl);
        }
        return null;
    }
    @ApiOperation(value = "删除配件字典")
    @RequestMapping(value = "deleteFwPjzdByIds",method = RequestMethod.POST)
    public Result deleteFwPjzdByIds(@RequestBody DeleteFwPjzdByIdsVo pjzdIdsVo){
        Integer[] ids = pjzdIdsVo.getIds();
        if(ids.length>0){
            for(int i =0;i<ids.length;i++){
                Integer res = pjzdService.deleteFwPjzdById(ids[i]);
            }

        }else {
            return Result.error(CodeMsg.PARAM_ERROR);
        }
        return Result.success();
    }
    @ApiOperation(value = "配件字典标题")
    @RequestMapping(value = "fwPjzdTitle",method = RequestMethod.POST)
    public Result fwPjzdTitle(){
        String title ="[{'type': 'checkbox'}, "+
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
    @ApiOperation(value = "配件分类标题")
    @RequestMapping(value = "fwPjzdSe")
    public Result fwPjzdSe(){
        Map map =new HashMap();
        map.put("dom","<div class='layui-inline'><select class='layui-select' name='pjfl'>" +
                "<option value='' selected>选择配件类型</option>"+
                "<option value='维材-医疗维修'>维材-医疗维修</option>" +
                "<option value='维材-办公维修'>维材-办公维修</option>" +
                "<option value='维材-普通维修'>维材-普通维修</option>" +
                "<option value='维材-家具维修'>维材-家具维修</option>" +
                "<option value='维材-其他'>维材-其他</option>" +
                "</select> </div> " +
                "<div class='layui-inline'><input type=\"text\" name=\"pjSzm\" class=\"layui-input\" " +
                "placeholder=\"配件名称\" autocomplete=\"off\"></div>" +
                "    <div class='layui-input-inline mar10-0' align='center'>" +
                "<button class='layui-btn' data-type='reload'>查询</button>" +
                "</div>");
        Map m = new HashMap();
        m.put("url","/security/pjzd/listFwPjzd");
        m.put("type","reload");
        String[] data = {"pjfl","pjSzm"};
        m.put("data",data);
        map.put("data",m);
        return Result.success(new JSONObject(map));

    }



}


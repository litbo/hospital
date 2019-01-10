package com.litbo.hospital.beneficial.controller;

import com.litbo.hospital.beneficial.service.CbxySzService;
import com.litbo.hospital.beneficial.vo.CbMhVo;
import com.litbo.hospital.beneficial.vo.CbysVo;
import com.litbo.hospital.beneficial.vo.kmListBjVo;
import com.litbo.hospital.common.utils.poi.ExcelData;
import com.litbo.hospital.common.utils.poi.ExportExcelUtil;
import com.litbo.hospital.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

/*
 *  设备成本效益设置
 * */
@RestController
@RequestMapping("/benefical/cbxySz")
public class CbxySzController {

    @Autowired
    private CbxySzService cbxySzService;

    //查询设备成本效益列表
    @RequestMapping("/listCbxySz")
    public Result listCbxySz(@RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
                           @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize) {
        return Result.success(cbxySzService.listCbxySz(pageNum,pageSize));
    }

    //查询设备成本效益列表根据条件查询
    @RequestMapping("/listCbxySzByX")
    public Result listCbxySzByX(@RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
                              @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize,
                              CbMhVo cbMhVo) {

        return Result.success(cbxySzService.listCbxySzByX(pageNum, pageSize, cbMhVo));
    }

    //导出 excell查询设备成本效益列表
    @RequestMapping(value = "/listCbxySzByXExport", method = RequestMethod.GET)
    public void listCbxySzByXExport(CbMhVo cbMhVo, HttpServletResponse response,
                                  @RequestParam(value = "fileName", required = true) String fileName) {

        List<String> titles = Arrays.asList(new ExcelData().getFiledName(CbysVo.class));
        ExcelData data = new ExcelData(titles, cbxySzService.listCbxySzByXExport(cbMhVo), "sheet");
        try {
            ExportExcelUtil.exportExcel(response, fileName, data);
        } catch (Exception e) {

        }
    }


    //根据设备id查询成本科目
    @RequestMapping("/selectCbkmByEqId")
    public Result selectCbkmByEqId(@RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
                                @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize,
                                   @RequestParam("eqId")Integer eqId) {

        return Result.success(cbxySzService.selectCbkmByEqId(pageNum, pageSize, eqId));
    }

    //导出 excell根据设备id查询成本科目
    @RequestMapping(value = "/selectCbkmByEqIdExport", method = RequestMethod.GET)
    public void selectCbkmByEqIdExport(@RequestParam("eqId")Integer eqId, HttpServletResponse response,
                                    @RequestParam(value = "fileName", required = true) String fileName) {

        List<String> titles = Arrays.asList(new ExcelData().getFiledName(kmListBjVo.class));
        ExcelData data = new ExcelData(titles, cbxySzService.selectCbkmByEqIdExport(eqId), "sheet");
        try {
            ExportExcelUtil.exportExcel(response, fileName, data);
        } catch (Exception e) {

        }
    }
    //查询设备收入列表
    @RequestMapping(value = "/listSrSz")
    public Result listSrSz(@RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
                             @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize) {
        return Result.success(cbxySzService.listSrSz(pageNum,pageSize));
    }

    //查询设备收入列表根据条件查询
    @RequestMapping(value = "/listSrSzByX")
    public Result listSrSzByX(@RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
                                @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize,
                                CbMhVo cbMhVo) {

        return Result.success(cbxySzService.listSrSzByX(pageNum, pageSize, cbMhVo));
    }

    //导出 excell查询设备收入效益列表
    @RequestMapping(value = "/listSrSzByXExport", method = RequestMethod.GET)
    public void listSrSzByXExport(CbMhVo cbMhVo, HttpServletResponse response,
                                    @RequestParam(value = "fileName", required = true) String fileName) {

        List<String> titles = Arrays.asList(new ExcelData().getFiledName(CbysVo.class));
        ExcelData data = new ExcelData(titles, cbxySzService.listSrSzByXExport(cbMhVo), "sheet");
        try {
            ExportExcelUtil.exportExcel(response, fileName, data);
        } catch (Exception e) {

        }
    }


    //根据设备id查询收入科目
    @RequestMapping(value = "/selectSrkmByEqId")
    public Result selectSrkmByEqId(@RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
                                   @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize,
                                   @RequestParam("eqId")Integer eqId) {

        return Result.success(cbxySzService.selectSrkmByEqId(pageNum, pageSize, eqId));
    }

    //导出 excell根据设备id查询收入科目
    @RequestMapping(value = "/selectSrkmByEqIdExport", method = RequestMethod.GET)
    public void selectSrkmByEqIdExport(@RequestParam("eqId")Integer eqId, HttpServletResponse response,
                                       @RequestParam(value = "fileName", required = true) String fileName) {

        List<String> titles = Arrays.asList(new ExcelData().getFiledName(kmListBjVo.class));
        ExcelData data = new ExcelData(titles, cbxySzService.selectSrkmByEqIdExport(eqId), "sheet");
        try {
            ExportExcelUtil.exportExcel(response, fileName, data);
        } catch (Exception e) {

        }
    }
}

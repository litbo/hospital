package com.litbo.hospital.supervise.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.security.bean.Cszj;
import com.litbo.hospital.supervise.bean.CsZjDeleteVO;
import com.litbo.hospital.supervise.bean.EqCszjVO;
import com.litbo.hospital.supervise.service.EqCsService;
import com.litbo.hospital.supervise.vo.CsDeleteVO;
import com.litbo.hospital.supervise.vo.EqCsInsertReadyVO;
import com.litbo.hospital.supervise.vo.EqCsSelectVO;
import com.litbo.hospital.supervise.vo.EqCsVO;
import com.litbo.hospital.user.bean.EqCs;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/supervise/csgl")
@Api(tags = "厂商管理")
public class EqCsController {
    @Autowired
    private EqCsService eqCsService;

    @PostMapping("/listEqCs")
    public Result listEqCs(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                           @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize){
        List<EqCs> eqCs = eqCsService.listEqCs(pageNum, pageSize);
        return Result.success(new PageInfo<>(eqCs));
    }
    @GetMapping("/readyResource")
    public Result readyResource(){
        EqCsInsertReadyVO readyVO = eqCsService.readyResource();
        return Result.success(readyVO);
    }
    @PostMapping("/insertEqCs")
    public Result insertEqCs(@RequestBody EqCs eqCs){
        if(eqCs.getSbcsId()==null||eqCs.getSbcsId().equals(""))
            eqCsService.insertEqCs(eqCs);
        else
            eqCsService.updateEqCs(eqCs);
        return Result.success();
    }

    @PostMapping("/insertCszj")
    public Result insertCszj(@RequestBody Cszj cszj){
        if(cszj.getCszjId()==null)
            eqCsService.insertCszj(cszj);
        else
            eqCsService.upDateCszj(cszj);
        return Result.success();
    }

    @RequestMapping("/deleteEqCs")
    public Result deleteEqCs(@RequestBody CsDeleteVO deleteVO){
        eqCsService.deleteEqCs(deleteVO);
        return Result.success();
    }

    @RequestMapping("/deleteEqCsZj")
    public Result deleteEqCsZj(@RequestBody CsZjDeleteVO deleteVO){
        eqCsService.deleteEqCsZj(deleteVO);
        return Result.success();
    }
    @RequestMapping("/getEqCsById")
    public Result getEqCsById(String sbcsId){
         EqCs eqCs =  eqCsService.getEqCsById(sbcsId);
        return Result.success(eqCs);
    }

    @RequestMapping("/getCszjByCszjId")
    public Result getCszjByCszjId(String cszjId){
        EqCszjVO cszj =  eqCsService.getCszjByCszjId(cszjId);
        if(cszj==null) return  Result.success();
        if(cszj.getCszjZjlx()!=null&&!"".equals(cszj.getCszjZjlx())){
            if("1".equals(cszj.getCszjZjlx())){
                cszj.setCszjZjlx("产品注册证");
            }else if("2".equals(cszj.getCszjZjlx())){
                cszj.setCszjZjlx("经营许可证");
            }else if("3".equals(cszj.getCszjZjlx())){
                cszj.setCszjZjlx("经营许可证");
            }else if("4".equals(cszj.getCszjZjlx())){
                cszj.setCszjZjlx("特种设备生产许可证");
            }
        }else {
            cszj.setCszjZjlx("");
        }
        return Result.success(cszj);
    }


    @RequestMapping("/listEqcsByX")
    @ResponseBody
    public Result listEqcsByX(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                               @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize,
                              EqCsSelectVO selectVo){
        PageInfo date = eqCsService.listEqcsByX(pageNum,pageSize,selectVo);
        return Result.success(date);
    }
    @RequestMapping(value = "listEqcsByXSe",method = RequestMethod.POST)
    public Result listEqcsByXSe(){
        Map map =new HashMap();
        map.put("dom","<div class='layui-inline'><input type=\"text\" name=\"sbcsName\" class=\"layui-input\" placeholder=\"厂商名称\" autocomplete=\"off\"></div>" +
                "    <div class='layui-input-inline mar10-0' align='center'>" +
                "<button class='layui-btn' data-type='reload'>搜索</button>" +
                "</div>");
        Map m = new HashMap();
        m.put("url","/supervise/csgl/listEqcsByX");
        m.put("type","reload");
        String[] data = {"sbcsName"};
        m.put("data",data);
        map.put("data",m);
        return Result.success(new JSONObject(map));

    }

    @RequestMapping("/listEqcsVOByX")
    public Result listEqcsVOByX(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                               @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize,
                               EqCsSelectVO selectVo){
        List<EqCsVO> eqCsVOS = eqCsService.listEqCsVO(selectVo, pageNum, pageSize);
        return Result.success(new PageInfo<>(eqCsVOS));
    }

    @RequestMapping("/listEqCszjVOByX")
    public Result listEqCszjVOByX(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                                @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize,
                                EqCsSelectVO selectVo){
        List<EqCszjVO> cszjVOS = eqCsService.listEqCszjVOByX(selectVo, pageNum, pageSize);
        return Result.success(new PageInfo<>(cszjVOS));
    }
    //供应商
    @PostMapping("/listEqcsByX1")
    public Result listEqcsByX1(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                              @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize,
                              EqCsSelectVO selectVo){
        PageInfo date = eqCsService.listEqcsByX1(pageNum,pageSize,selectVo);
        return Result.success(date);
    }
    @RequestMapping(value = "listEqcsByX1Se",method = RequestMethod.POST)
    public Result listEqcsByX1Se(){
        Map map =new HashMap();
        map.put("dom","<div class='layui-inline'><input type=\"text\" name=\"sbcsName\" class=\"layui-input\" placeholder=\"厂商名称\" autocomplete=\"off\"></div>" +
                "    <div class='layui-input-inline mar10-0' align='center'>" +
                "<button class='layui-btn' data-type='reload'>搜索</button>" +
                "</div>");
        Map m = new HashMap();
        m.put("url","/supervise/csgl/listEqcsByX1");
        m.put("type","reload");
        String[] data = {"sbcsName"};
        m.put("data",data);
        map.put("data",m);
        return Result.success(new JSONObject(map));
    }

    //生产商
    @PostMapping("/listEqcsByX2")
    public Result listEqcsByX2(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                              @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize,
                              EqCsSelectVO selectVo){
        PageInfo date = eqCsService.listEqcsByX2(pageNum,pageSize,selectVo);
        return Result.success(date);
    }
    @RequestMapping(value = "listEqcsByX2Se",method = RequestMethod.POST)
    public Result listEqcsByX2Se(){
        Map map =new HashMap();
        map.put("dom","<div class='layui-inline'><input type=\"text\" name=\"sbcsName\" class=\"layui-input\" placeholder=\"厂商名称\" autocomplete=\"off\"></div>" +
                "    <div class='layui-input-inline mar10-0' align='center'>" +
                "<button class='layui-btn' data-type='reload'>搜索</button>" +
                "</div>");
        Map m = new HashMap();
        m.put("url","/supervise/csgl/listEqcsByX2");
        m.put("type","reload");
        String[] data = {"sbcsName"};
        m.put("data",data);
        map.put("data",m);
        return Result.success(new JSONObject(map));
    }

    @RequestMapping(value = "csSe",method = RequestMethod.POST)
    public Result csSe(){
        Map map =new HashMap();
        map.put("dom","<div class='layui-inline'><input type=\"text\" name=\"sbcsName\" class=\"layui-input\" placeholder=\"厂商名称\" autocomplete=\"off\"></div>" +
                "    <div class='layui-input-inline mar10-0' align='center'>" +
                "<button class='layui-btn' data-type='reload'>搜索</button>" +
                "</div>");
        Map m = new HashMap();
        m.put("url","/supervise/csgl/listEqcsVOByX");
        m.put("type","reload");
        String[] data = {"sbcsName"};
        m.put("data",data);
        map.put("data",m);
        return Result.success(new JSONObject(map));
    }
    //维修商
    @PostMapping("/listEqcsByX3")
    public Result listEqcsByX3(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                               @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize,
                               EqCsSelectVO selectVo){
        PageInfo date = eqCsService.listEqcsByX3(pageNum,pageSize,selectVo);
        return Result.success(date);
    }
    @PostMapping("eqcsTitles")
    public Result eqcsTitles() {
        String title ="[{'type': 'radio'}, "+
                "{field: 'sbcsName', title: '供货商'},"+
                "{field: 'sbcsLxr1', title: '联系人'},"+
                "{field: 'sbcsLxdh1', title: '联系电话'},"+
                "{field: 'email', title: 'Email地址'}"+
                "]";
        return Result.success(JSON.parseArray(title));
    }

    @PostMapping("/eqcsTitles1")
    public Result eqcsTitles1() {
        String title ="[{'type': 'radio'}, "+
                "{field: 'sbcsName', title: '厂商名称'},"+
                "{field: 'sbcsLxr1', title: '联系人'},"+
                "{field: 'sbcsLxdh1', title: '联系电话'},"+
                "{field: 'email', title: 'Email地址'}"+
                "]";
        return Result.success(JSON.parseArray(title));
    }

    @PostMapping( "/batchImportCszjs")
    @ResponseBody
    public Result batchImportCszjs(@RequestParam("file") MultipartFile file[]) throws Exception{
        String docUrl = eqCsService.batchImportCszjs(file);
        return Result.success(docUrl);
    }



}

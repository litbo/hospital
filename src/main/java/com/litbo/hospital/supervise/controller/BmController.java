package com.litbo.hospital.supervise.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.supervise.bean.SBm;
import com.litbo.hospital.supervise.dao.BmDao;
import com.litbo.hospital.supervise.service.BmService;
import com.litbo.hospital.supervise.vo.BmSelectVO;
import com.litbo.hospital.supervise.vo.SetBmVO;
import com.litbo.hospital.supervise.vo.WxBmHfVO;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/supervise/bmgl")
@Api(tags = "部门管理")
public class BmController {

    @Autowired
    private BmService bmService;
    @Autowired
    private BmDao bmDao;
    @GetMapping("/ztree")
    public String ToZtree(){
        return "ztreeBmDemo";
    }


    @RequestMapping("/listSelectBmsCols")
    public Result listSelectBmsCols(@RequestParam(required = false) String key) {
        JSONArray myJsonArray = null;
        if ("checkbox".equals(key)){
            String jsonMessage = "[{'type': 'checkbox'}, " +
                    "{field: 'bmId', title: '部门ID'}, " +
                    "{field: 'bmName', title: '部门名称'}]";
            myJsonArray = JSONObject.parseArray(jsonMessage);
        }else if ("radio".equals(key)){
            String jsonMessage = "[{'type': 'radio'}, " +
                    "{field: 'bmId', title: '部门ID'}, " +
                    "{field: 'bmName', title: '部门名称'}]";
            myJsonArray = JSONObject.parseArray(jsonMessage);
        }
        PageInfo date = new PageInfo(myJsonArray);
        return Result.success(date);
    }

    //列出所有部门信息
    @RequestMapping("/listBms")
    public Result getBmList(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                            @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize){
        PageInfo date = bmService.getBmList(pageNum,pageSize);
        return Result.success(date);
    }
    //列出所有部门信息不分頁
    @GetMapping("/listBm")
    @ResponseBody
    public Result getBmList(){
        return Result.success(bmService.getBmList());

    }
    //列出所有部门信息
    @GetMapping("/listBms2")
    @ResponseBody
    public Result getBmLsist2(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                            @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize){
        List<SBm> bmList = bmDao.getBmList();
        return Result.success(bmList);
    }
    @PostMapping ("/listBms3")
    @ResponseBody
    public Result listBms3(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                              @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize){
        List<SBm> bmList = bmDao.getBmList();
        return Result.success(bmList);
    }
    @RequestMapping("/listBmsAsLbBms")
    @ResponseBody
    public Result listBmsAsLbBms(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                            @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize,int flag){
        PageInfo date = bmService.listBmsAsLbBms(pageNum,pageSize,flag);
        return Result.success(date);
    }
    @RequestMapping("/listBmsAsLbBmsBySelectVO")
    @ResponseBody
    public Result listBmsAsLbBmsBySelectVO(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                                 @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize,BmSelectVO selectVO){
        PageInfo date = bmService.listBmsAsLbBmsBySelectVO(pageNum,pageSize,selectVO);
        return Result.success(date);
    }
    //查询部门信息通过老id
    @GetMapping("/getBmByOid")
    @ResponseBody
    public Result getBmByOid(@RequestParam String oid){
        SBm date = bmService.getBmByOid(oid);
        return Result.success(date);
    }
    //列出所有维修部门信息
    @GetMapping("/listWXbms")
    @ResponseBody
    public Result listWXbms(){
        List<SBm> date = bmService.getWxBmList();
        return Result.success(date);
    }
    //列出所有部门信息通过父id
    @GetMapping("/listBmsByPid")
    @ResponseBody
    public Result getBmListByPid(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                                 @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize,
                                 @RequestParam String pid){
        PageInfo date = bmService.getBmListByPid(pageNum,pageSize,pid);
        return Result.success(date);
    }
    //级联查询
    @GetMapping("/listBmsByX")
    @ResponseBody
    public Result getBmListByX(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                               @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize,
                               BmSelectVO selectVo){
        PageInfo date = bmService.getBmListByX(pageNum,pageSize,selectVo);
        return Result.success(date);
    }


    //保存部门信息
    @PostMapping("/saveBm")
    @ResponseBody
    public Result saveBm(@RequestBody SBm bm){
        bmService.saveBm(bm);
        return Result.success();
    }
    //删除部门通过老id
    @GetMapping("/removeBmByOid")
    @ResponseBody
    public Result removeBmByOid(@RequestParam String oid){
        boolean flag = true;
        flag = bmService.isZJD(oid);
        if(!flag) return Result.error("删除部门必须为叶子部门！！");
        bmService.removeBmByOid(oid);
        return Result.success();
    }

    //设置部门归属 调整部门
    @PostMapping("/setBmBeto")
    @ResponseBody
    public Result setBmBeto(@RequestBody SetBmVO bmVO){
        boolean flag = true;
        flag = bmService.isAllZJD(bmVO.getObm_ids());
        //判断部门是否为叶子部门
        if(!flag) return Result.error("部门必须为叶子部门！！");
        //调整部门
        bmService.setBmsBeto(bmVO);
        return Result.success();
    }

    @GetMapping("/setBmBetoTest")
    @ResponseBody
    public Result setBmBetoTest(@RequestParam String obm_id, @RequestParam String new_pbm_id  ){

        bmService.setBmBeto(obm_id,new_pbm_id);
        return Result.success();
    }

    //设置维修部门
    @PostMapping("/hfWxbm")
    @ResponseBody
    public Result hfWxbm(@RequestBody WxBmHfVO wxBmHfVO){
        bmService.setWxbm(wxBmHfVO.getObmIds(),1);  // 1 为维修部门
        return Result.success();
    }
    //去除维修部门
    @PostMapping("/qchfWxbm")
    @ResponseBody
    public Result qchfWxbm(@RequestBody WxBmHfVO wxBmHfVO){
        bmService.setWxbm(wxBmHfVO.getObmIds(),0);  // 0 为非维修部门
        return Result.success();
    }

    //  获取叶子部门
    @GetMapping("/listGLBm")
    @ResponseBody
    public Result listGLBm(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                           @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize){

        PageInfo yzBmList = bmService.getGLBmList(pageNum, pageSize);
        return Result.success(yzBmList);
    }

    @GetMapping("/listFWXBm")
    @ResponseBody
    public Result listFWXBm(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                           @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize){

        PageInfo fwxBms = bmService.getFwxBms(pageNum, pageSize);
        return Result.success(fwxBms);
    }

    @GetMapping("/listFWXBmByBmName")
    @ResponseBody
    public Result listFWXBmByBmName(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                            @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize,@RequestParam String bmName){

        PageInfo fwxBms = bmService.listFWXBmByBmName(pageNum, pageSize,bmName);
        return Result.success(fwxBms);
    }

    @PostMapping( "/batchImportBms")
    @ResponseBody
    public Result batchImportBms(@RequestParam("file") MultipartFile file) throws Exception{
        String fileName = file.getOriginalFilename();
        if(bmService.batchImportBms(fileName,file) == 0){
            return Result.error();
        }
        return Result.success();
    }
}

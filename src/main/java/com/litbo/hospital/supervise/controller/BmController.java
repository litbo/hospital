package com.litbo.hospital.supervise.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.supervise.bean.SBm;
import com.litbo.hospital.supervise.dao.BmDao;
import com.litbo.hospital.supervise.service.BmService;
import com.litbo.hospital.supervise.vo.*;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @RequestMapping("/bmSe")
    public Result bmSe(){
        Map map =new HashMap();
        map.put("dom",
                "<div class='layui-inline'><input type=\"text\" name=\"bmName\" class=\"layui-input\" placeholder=\"部门名称\" autocomplete=\"off\"></div>" +
                        "    <div class='layui-input-inline mar10-0' align='center'>" +
                        "<button class='layui-btn' data-type='reload'>搜索</button>" +
                        "</div>");

        Map m = new HashMap();
        m.put("url","/supervise/bmgl/listBmsByBmName");
        m.put("type","reload");
        String[] data = {"bmName"};
        m.put("data",data);
        map.put("data",m);
        return Result.success(new JSONObject(map));

    }

    //列出所有部门信息
    @RequestMapping("/listBms")
    public Result getBmList(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                            @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize){
        PageInfo date = bmService.getBmList(pageNum,pageSize);
        return Result.success(date);
    }
    @RequestMapping("/listInitBms")
    public Result listInitBms(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                            @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize){
        PageInfo date = bmService.listInitBms(pageNum,pageSize);
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
    public Result getBmLsist2(){
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
    @GetMapping("/listBmForTree")
    @ResponseBody
    public List<SBm> listBmForTree(){
        return bmService.getBmList();

    }

    @GetMapping ("/listTreeBms")

    @ResponseBody
    public List<BmsTreeVO> listTreeBms(){
        List<BmsTreeVO> bmList = bmService.listTreeBms();
        return bmList;
    }

    @RequestMapping("/listBmsByBmName")
    @ResponseBody
    public Result listBmsByBmName(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                                 @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize,String bmName){
        List<SBm> bms = bmService.listBmsByBmName(pageNum,pageSize,bmName);
        return Result.success(new PageInfo<>(bms));
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

    @PostMapping("/updateBm")
    @ResponseBody
    public Result updateBm(@RequestBody SBm bm){
        bmService.updateBm(bm);
        return Result.success();
    }
    //删除部门通过老id
    @GetMapping("/removeBmByOBmId")
    @ResponseBody
    public Result removeBmByOBmId(@RequestParam String obmId){
        boolean flag = true;
        flag = bmService.isZJD(obmId);
        if(!flag) return Result.error("删除部门必须为叶子部门！！");
        bmService.removeBmByOBmId(obmId);
        return Result.success();
    }

    //设置部门归属 调整部门
    @PostMapping("/setBmBeto")
    @ResponseBody
    public Result setBmBeto(@RequestBody SetBmVO bmVO){
        boolean flag = true;
        flag = bmService.isAllZJD(bmVO.getObmIds());
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

    @RequestMapping("/listKgsBm") //获取可以归属的部门 包括未编号和没有子节点的部门
    @ResponseBody
    public Result listKgsBm(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                                    @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize,
                                    @RequestParam(required = false) String bmName,String iCode){

        List<BmSelectLbVO> bms = bmService.listKgsBm(pageNum, pageSize,bmName,iCode);
        return Result.success(new PageInfo<>(bms));
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

    @PostMapping( "/adjustBmIdForEq")
    @ResponseBody
    public Result adjustBmIdForEq(){
        bmService.adjustBmIdForEq();
        return Result.success();
    }

    /**
     * 描述：下载外部案件导入模板
     * @throws Exception
     */
    @RequestMapping(value = "/downloadExcel")
    @ResponseBody
    public void downloadExcel(HttpServletResponse res, HttpServletRequest req, String name) throws Exception {
        String fileName = name+".xlsx";
        ServletOutputStream out;
        res.setContentType("multipart/form-data");
        res.setCharacterEncoding("UTF-8");
        res.setContentType("text/html");
       /* String filePath = getClass().getResource("/templates/" + fileName).getPath();*/
        String filePath = System.getProperty("user.dir")+"/templates/"+fileName;
        String userAgent = req.getHeader("User-Agent");
        if (userAgent.contains("MSIE") || userAgent.contains("Trident")) {
            fileName = java.net.URLEncoder.encode(fileName, "UTF-8");
        } else {
            // 非IE浏览器的处理：
            fileName = new String((fileName).getBytes("UTF-8"), "ISO-8859-1");
        }
        filePath = URLDecoder.decode(filePath, "UTF-8");
        res.setHeader("Content-Disposition", "attachment;fileName=" + fileName);
        FileInputStream inputStream = new FileInputStream(filePath);
        out = res.getOutputStream();
        int b = 0;
        byte[] buffer = new byte[1024];
        while ((b = inputStream.read(buffer)) != -1) {
        // 4.写到输出流(out)中
         out.write(buffer, 0, b);
        }
        inputStream.close();

        if (out != null) {
        out.flush();
        out.close();
        }

    }


//    @GetMapping( "/setXXX")
//    @ResponseBody
//    public Result setXXX() throws Exception{
//        List<BmsTreeVO> vos = bmDao.listTreeBms();
//        for(BmsTreeVO vo:vos){
//            if(bmDao.getAmountByPid(vo.getBmId())>0){
//                bmDao.setxbm(vo.getBmId(),"1");
//            }
//        }
//        return Result.success();
//    }

//    @RequestMapping(value = "/getDir")
//    @ResponseBody
//    public Result getDir() throws Exception {
//
//        String property = System.getProperty("user.dir");
//        return Result.success(property);
//    }

}

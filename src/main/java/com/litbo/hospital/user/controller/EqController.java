package com.litbo.hospital.user.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.user.bean.EqFj;
import com.litbo.hospital.user.bean.EqInfo;
import com.litbo.hospital.user.service.EqService;
import com.litbo.hospital.user.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/eq")
public class EqController {

    @Autowired
    EqService es;

    //查询所有设备信息
    @RequestMapping("/listEqs")
    public Result listEq(Model model) {

        List<EqVo> eqInfos = es.getAllEq();

        return Result.success(eqInfos);
    }

    //查询设备展示信息
    @RequestMapping("/listShowEqs")
    public Result listShowEqs(@RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
                              @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize) {

        return Result.success(es.listShowEqs(pageNum, pageSize));
    }

    //模糊查询
    @RequestMapping("/listEqByX")
    public Result listEqByX(@RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
                            @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize,
                            SelectEqVo selectEqVo) {
        PageInfo pageInfo = es.listEqByX(pageNum, pageSize, selectEqVo);
        return Result.success(pageInfo);
    }

    //通过设备id 查询设备信息
    @RequestMapping("/getEqById")
    public Result getEqById(String eqId) {

        return Result.success(es.getEqById(eqId));
    }

    /**
                                                                                                                                                              * 添加设备
     *
     * @return
     **/
    @RequestMapping(value = "/addEq")
    public Result addEq(@RequestBody EqInfoVo eqInfo) {

            if (es.addEq(eqInfo) > 0) {
            return Result.success();
        }
        return Result.error();
    }
    //上传文件
    @RequestMapping("/uploadFile1")
    public Result uploadFile(@RequestParam("file") MultipartFile[] multipartFiles){
        String totalUrl = null;
        for (MultipartFile multipartFile : multipartFiles) {
            String url = es.uploadFile(multipartFile);
            if(totalUrl!=null){
                totalUrl = totalUrl+","+url;
            }
            totalUrl =url;
        }
       return Result.success(totalUrl);
    }

    @RequestMapping("/uploadFile")
    public Result uploadFile(@RequestParam("file") MultipartFile multipartFiles){

        String url = es.uploadFile(multipartFiles);
        return Result.success(url);
    }


    @RequestMapping("/setPm")
    public Result setPm(@RequestBody SetPmVo setPmVo) {

        if (es.setPm(setPmVo) < 0) {
            return Result.error();
        }
        return Result.success();
    }

    //Excel导入设备信息
    @RequestMapping("/importEq")
    public Result importEq(MultipartFile file) {
        if (es.importEq(file) < 0) {
            return Result.error();
        }
        return Result.success();
    }

    //Execl 导入设备附件信息
    @RequestMapping("/importFj")
    public Result importFj(MultipartFile file){
        if(es.importFj(file)<0){
            return Result.error();
        }
         return Result.success();

    }


    /**
     * 修改
     *
     * @return
     **/
    @RequestMapping("/updateEq")
    public Result updateEq(@RequestBody EqInfoVo eqInfo) {

        if (es.updateEq(eqInfo) > 0) {
            return Result.success();
        }
        return Result.error();
    }


    //查询已经关联设备
    @RequestMapping("/listFlEq")
    public Result listFlEq(@RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
                           @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize) {

        PageInfo pageInfo = es.listFlEq(pageNum, pageSize);
        return Result.success(pageInfo);
    }

    //模糊查询已经关联设备
    @RequestMapping("/listFlEqByX")
    public Result listFlEqByX(@RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
                              @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize,
                              SelectFlEqVo selectFlEqVo) {
        PageInfo pageInfo = es.listFlEqByX(pageNum,pageSize,selectFlEqVo);
        return Result.success(pageInfo);
    }

    //查询未关联设备
    @RequestMapping("/listWFlEq")
    public Result listWFlEq(@RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
                            @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize) {

        PageInfo pageInfo = es.listWFlEq(pageNum, pageSize);
        return Result.success(pageInfo);
    }

    //模糊查询已经关联设备
    @RequestMapping("/listWFlEqByX")
    public Result listWFlEqByX(@RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
                              @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize,
                              SelectFlEqVo selectFlEqVo) {
        PageInfo pageInfo = es.listWFlEqByX(pageNum,pageSize,selectFlEqVo);
        return Result.success(pageInfo);
    }

    //解除卫标分类
    @RequestMapping("/cancelFl")
    public Result cancelFl(@RequestBody ListVo listVo) {

        for (String eqId : listVo.getEqIds()) {
            if (es.cancelFl(eqId) < 0) {
                return Result.error(eqId);
            }
        }
        return Result.success();

    }
    //删除设备
    @RequestMapping("/delEq")
    @ResponseBody
    public Result delEq(@RequestBody ListVo listVo){

        for (String id : listVo.getEqIds()) {
           es.delEq(id);
        }
        return Result.success();


    }

    //使用性质接口
    @RequestMapping("/listSyxz")
    public Result listSyxz(@RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
                           @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize) {

        return Result.success(es.listSyxz());
    }

    // 设备品名表头
    @RequestMapping("/listPmsCols")
    public Result listPmsCols(@RequestParam(required = false) String key,
                              @RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
                              @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize) {
        JSONArray myJsonArray = null;
        if ("checkbox".equals(key)) {
            String jsonMessage = "[{'type': 'checkbox'}, " +
                    "{field: 'eqPmId', title: '品名编号'}, " +
                    "{field: 'eqPmName', title: '品名'}]" ;
            myJsonArray = JSONObject.parseArray(jsonMessage);
        }else  if ("radio".equals(key)){
            String jsonMessage = "[{'type': 'radio'}, " +
                    "{field: 'eqPmId', title: '品名编号'}, " +
                    "{field: 'eqPmName', title: '品名'}]" ;
            myJsonArray = JSONObject.parseArray(jsonMessage);
        }
        PageInfo date = new PageInfo(myJsonArray);
        return Result.success(date);
    }

    //查询品名
    @RequestMapping("/listPms")
    public Result listPms(@RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
                          @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize) {
        PageInfo pageInfo = es.listPms(pageNum, pageSize);

        return Result.success(pageInfo);
    }

    //品名树返回数据
    @RequestMapping("/listPmTree")
    public Result listPmTree(){

        return Result.success(es.listPmTree());
    }
    //查询品名信息
    @RequestMapping("/getPmById")
    public Result getPmById(String eqPmId){

        return Result.success(es.getPmById(eqPmId));
    }
    //通过品名 拼音码pym 查询品名
    @RequestMapping("/listPmsByPym")
    public Result listPmsByPym(@RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
                               @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize,
                               @RequestParam(value = "pym",required = false) String pym) {

        PageInfo pageInfo = es.listPmsByPym(pageNum, pageSize, pym);
        return Result.success(pageInfo);
    }

    //添加附件
    @RequestMapping("/saveFj")
    public Result saveFj(EqFj eqFj){
        if(es.saveFj(eqFj)>0){
            return Result.success();
        }else {
            return Result.error();
        }

    }


    //返回表头
    @RequestMapping("/listEqbt")
    public Result listSelectEmpsCols(@RequestParam(required = false) String key) {
        JSONArray myJsonArray = null;
        if ("checkbox".equals(key)) {
            String jsonMessage = "[{'type': 'checkbox'}, " +
                    "{field: 'eqSbbh', title: '设备编号''}, " +
                    "{field: 'eqName', title: '设备名称'}" +
                    "{field: 'bmName', title: '部门名称'}" +
                    "{field: 'eqGg', title: '规格'}" +
                    "{field: 'eqXh', title: '型号'}]";
            myJsonArray = JSONObject.parseArray(jsonMessage);
        } else if ("radio".equals(key)) {
            String jsonMessage = "[{'type': 'radio'}, " +
                    "{field: 'eqSbbh', title: '设备编号'}, " +
                    "{field: 'eqName', title: '设备名称'}" +
                    "{field: 'bmName', title: '部门名称'}" +
                    "{field: 'eqGg', title: '规格'}" +
                    "{field: 'eqXh', title: '型号'}]";
            myJsonArray = JSONObject.parseArray(jsonMessage);
        }
        PageInfo date = new PageInfo(myJsonArray);
        return Result.success(date);
    }


    @RequestMapping(value = "/pmSe")
    public Result pmSe(){
        Map map =new HashMap();
        map.put("dom",
                "<div class='layui-inline'><input type=\"text\" name=\"pym\" class=\"layui-input\" placeholder=\"品名拼音码\" autocomplete=\"off\"></div>" +
                        "    <div class='layui-input-inline mar10-0' align='center'>" +
                        "<button class='layui-btn' data-type='reload'>查询</button>" +
                        "</div>");

        Map m = new HashMap();
        m.put("url","/eq/listPmsByPym");
        m.put("type","reload");
        String[] data = {"pym"};
        m.put("data",data);
        map.put("data",m);
        return Result.success(new JSONObject(map));

    }
    @RequestMapping(value = "/eqSe")
    public Result eqSe(){
        Map map =new HashMap();
        map.put("dom",
                "<div class='layui-inline'><input type=\"text\" name=\"eqPym\" class=\"layui-input\" placeholder=\"设备拼音码\" autocomplete=\"off\"></div>" +
                        "<div class='layui-inline'><input type=\"text\" name=\"eqSbbh\" class=\"layui-input\" placeholder=\"设备编码\" autocomplete=\"off\"></div>" +
                        "<div class='layui-inline'><input type=\"text\" name=\"eqZcbh\" class=\"layui-input\" placeholder=\"资产编码\" autocomplete=\"off\"></div>" +
                        "<div class='layui-inline'><input type=\"text\" name=\"bmName\" class=\"layui-input\" placeholder=\"部门名称\" autocomplete=\"off\"></div>" +
                        "    <div class='layui-input-inline mar10-0' align='center'>" +
                        "<button class='layui-btn' data-type='reload'>查询</button>" +
                        "</div>");

        Map m = new HashMap();
        m.put("url","/eq/listEqByX");
        m.put("type","reload");
        String[] data = {"eqPym","eqSbbh","eqZcbh","bmName"};
        m.put("data",data);
        map.put("data",m);
        return Result.success(new JSONObject(map));

    }

    @RequestMapping("listEqNameCols")
    public Result listEqNameCols(@RequestParam(required = false) String key,
                              @RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
                              @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize) {
        JSONArray myJsonArray = null;

            String jsonMessage = "[{'type': 'radio'}, " +
                    "{field: 'id', title: '设备id'}, " +
                    "{field: 'ccname', title: '设备名称'}]" ;
            myJsonArray = JSONObject.parseArray(jsonMessage);

        PageInfo date = new PageInfo(myJsonArray);
        return Result.success(date);
    }

    @RequestMapping("/listEqName")
    public Result listEqName(@RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
                          @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize) {
        PageInfo pageInfo = es.listEqName(pageNum, pageSize);

        return Result.success(pageInfo);
    }

    //模糊查询
    @RequestMapping("/listEqNameByX")
    public Result listEqNameByX(@RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
                                @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize,
                                String ccname) {
        PageInfo pageInfo = es.listEqNameByX(pageNum, pageSize, ccname);
        return Result.success(pageInfo);
    }

    @RequestMapping(value = "/eqNameSe")
    public Result eqNameSe(){
        Map map =new HashMap();
        map.put("dom",
                "<div class='layui-inline'><input type=\"text\" name=\"ccname\" class=\"layui-input\" placeholder=\"设备名称\" autocomplete=\"off\"></div>" +
                        "    <div class='layui-input-inline mar10-0' align='center'>" +
                        "<button class='layui-btn' data-type='reload'>查询</button>" +
                        "</div>");

        Map m = new HashMap();
        m.put("url","/eq/listEqNameByX");
        m.put("type","reload");
        String[] data = {"ccname"};
        m.put("data",data);
        map.put("data",m);
        return Result.success(new JSONObject(map));

    }
}

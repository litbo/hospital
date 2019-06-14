package com.litbo.hospital.user.controller;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.security.bean.EqCslb;
import com.litbo.hospital.security.bean.Gb;
import com.litbo.hospital.security.bean.Jg;
import com.litbo.hospital.security.bean.Xllb;
import com.litbo.hospital.user.bean.*;
import com.litbo.hospital.user.dao.DictDao;
import com.litbo.hospital.user.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/eqdict")
public class DictController {

    @Autowired
    DictService ds;
    @Autowired
    DictDao dictDao;
    //资金来源
    @RequestMapping("/zjly")
    public Result listZjlys(){

        List<EqZjly> eqZjlys = ds.listZjlys();
        return Result.success(eqZjlys);
    }
    @RequestMapping("/zjlyByX")
    public Result listZjlysByX(EqZjly eqZjly){
        List<EqZjly> eqZjlys =   dictDao.listZjlysByX(eqZjly);

        return Result.success(eqZjlys);
    }

    //计量单位
    @RequestMapping("/jldw")
    public Result listJldw(){

        List<EqJldw> eqJldws = ds.listJldw();
        return Result.success(eqJldws);

    }

    //查询分类
    @RequestMapping("/cxfl")
    public Result listCxfl(){

        List<EqCxfl> eqCxfls = ds.listCxfl();
        return  Result.success(eqCxfls);
    }

    //取得方式
    @RequestMapping("/qdfs")
    public Result listQdfs(){

        List<EqQdfs> eqQdfs = ds.listQdfs();
        return Result.success(eqQdfs);
    }

    //购置类别
    @RequestMapping("/gzlb")
    public Result listGzlb(){

        List<EqGzlb> eqGzlbs = ds.listGzlb();
        return Result.success(eqGzlbs);
    }



    @RequestMapping("/zggwlb")
    public Result listZggwlb(){

        List<Zggwlb> zggwlb = dictDao.listZggwlb();
        return Result.success(zggwlb);
    }

    

    @RequestMapping("/listMz")
    public Result listMz(){
        List<Mz> mz = dictDao.listMz();
        return Result.success(mz);
    }
    @RequestMapping("/listEqCslb")
    public Result listEqCslb(){
        List<EqCslb> cslbs = dictDao.listEqCslb();
        return Result.success(cslbs);
    }

    @RequestMapping("/listGb")
    public Result listGb(){
        List<Gb> gbs = dictDao.listGb();
        return Result.success(gbs);
    }

    @RequestMapping("/listJg")
    public Result listJg(){
        List<Jg> jgs = dictDao.listJg();
        return Result.success(jgs);
    }

    @RequestMapping("/listXllb")
    public Result listXllb(){
        List<Xllb> xllb = dictDao.listXllb();
        return Result.success(xllb);
    }
    @RequestMapping("/listZc")
    public Result listZc(){
        List<Zc> zc = dictDao.listZc();

        return Result.success(zc);
    }


    @RequestMapping("/gglx")
    public Result listGglx(){

        List<SysGglx> gglxes = dictDao.listGglx();
        return Result.success(gglxes);
    }
    @RequestMapping("/jczd")
    public Result listJczd(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                           @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize){

        PageInfo pageInfo = ds.listJczd(pageNum,pageSize);
        return  Result.success(pageInfo);


    }
    @RequestMapping("/zyzd")
    public Result listZyzd(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                           @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize){

        PageInfo pageInfo = ds.listZyzd(pageNum,pageSize);
        return  Result.success(pageInfo);


    }


    @RequestMapping("/listDictByTName")
    public Result listDictByTName(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                                  @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize,String tName){

        PageInfo pageInfo =ds.listDictByTName(pageNum,pageSize,tName);
        return Result.success(pageInfo);
    }

    @RequestMapping("addDictByTName")
    public Result addDictByTName(String tName,String dictName){

       if(ds.addDictByTName(tName,dictName)>0){
           return Result.success();
       }

       return Result.error();
    }

    @RequestMapping("delByTNameAndId")
    public Result delByTNameAndId(String bName,String dictId){

        if(dictDao.delByTNameAndId(bName,dictId)>0){
            return Result.success();
        }
        return Result.error();

    }
    @RequestMapping("getByTNameAndId")
    public Result getByTNameAndId(String bName,String id){

        return Result.success(dictDao.getByTNameAndId(bName,id));
    }





}

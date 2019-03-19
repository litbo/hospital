package com.litbo.hospital.user.controller;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.user.bean.*;
import com.litbo.hospital.user.dao.DictDao;
import com.litbo.hospital.user.service.DictService;
import com.litbo.hospital.user.vo.DictVo;
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







}

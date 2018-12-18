package com.litbo.hospital.user.controller;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.user.bean.EqInfo;
import com.litbo.hospital.user.service.EqService;
import com.litbo.hospital.user.vo.EqVo;
import com.litbo.hospital.user.vo.SelectEqVo;
import com.litbo.hospital.user.vo.SetPmVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/eq")
public class EqController {

    @Autowired
    EqService es;

    //查询所有设备信息
    @RequestMapping("/listEqs")
    public Result listEq(Model model){

        List<EqVo>  eqInfos = es.getAllEq();

        return Result.success(eqInfos);
    }
    //查询设备展示信息
    @RequestMapping("/listShowEqs")
    public Result listShowEqs(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                              @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize){

        return Result.success(es.listShowEqs(pageNum,pageSize));
    }

    //模糊查询
    @RequestMapping("/listEqByX")
    public Result listEqByX(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                            @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize,
                            SelectEqVo selectEqVo){
        PageInfo pageInfo =  es.listEqByX(pageNum ,pageSize, selectEqVo);
        return Result.success(pageInfo);
    }

    /**
    *
    *   添加设备
    *   @return
    **/
    @RequestMapping(value = "/addEq")
    public Result addEq(EqInfo eqInfo, @RequestParam("sbzp") MultipartFile sbzp,@RequestParam("mpzp") MultipartFile mpzp){

        if(es.addEq(eqInfo,sbzp,mpzp)>0){
            return Result.success();
        }
        return Result.error();
    }
    @RequestMapping("/setPm")
    public Result setPm(@RequestBody SetPmVo setPmVo){

        if(es.setPm(setPmVo)<0){
            return Result.error();
        }
        return Result.success();
    }

    //Excel导入设备信息
    @RequestMapping("/importEq")
    public Result importEq(MultipartFile file){
       if(es.importEq(file)<0){
           return Result.error();
       }
       return Result.success();
    }


    /**
    *
    *   修改
    *   @return
    **/
  /*  public R updateEq(){

        if(es.updateEq>0){
            return R.ok();
        }
        return R.error();
    }
*/


}

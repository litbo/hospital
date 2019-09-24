package com.litbo.hospital.lifemanage.controller.MyController;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.lifemanage.MyUtils.String2DateUtil;
import com.litbo.hospital.lifemanage.bean.MyBean.CzGc;
import com.litbo.hospital.lifemanage.bean.vo.MyVO.CzGcShowEqVO;
import com.litbo.hospital.lifemanage.bean.vo.MyVO.DeleteHtsByIdsVO;
import com.litbo.hospital.lifemanage.dao.MyMapper.CzGcMapper;
import com.litbo.hospital.lifemanage.service.MyService.CzGcService;
import com.litbo.hospital.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/lifeManage")
public class CzGcController {
    @Autowired
    private CzGcService service;
    @Autowired
    private CzGcMapper mapper;

    /*录入*/
    @PostMapping("/insertOneCzgc")
    public Result insertzGc(@RequestBody CzGc gc) {
        int i = service.insertCzgc(gc);
        if (i == 1) {
            return Result.success(i);
        } else {
            return Result.error();
        }
    }

    /*待审核查询*/
    @PostMapping("/DshCzgcCx")
    public Result DshCzgcCx(@RequestParam(required = false, name = "pageNum", defaultValue = "1") Integer pageNum,
                            @RequestParam(required = false, name = "pageSize", defaultValue = "10") Integer pageSize,
                            @RequestParam(required = false, name = "bh") String bh,
                            @RequestParam(required = false, name = "mc") String mc,
                            @RequestParam(required = false, name = "ngr") String ngr,
                            @RequestParam(required = false, name = "qssj") String qssj,
                            @RequestParam(required = false, name = "jssj") String jssj
    ) {

        Date qs = String2DateUtil.StringtoDate(qssj);
        Date js = String2DateUtil.StringtoDate(jssj);
        PageInfo<CzGc> info = service.AllDshCzgc(pageNum, pageSize, bh, mc, ngr, qs, js);
        return Result.success(info);

    }

    /*统计查询*/
    @PostMapping("/CzGcTjCx")
    public Result CzGcTjCx(@RequestParam(required = false, name = "pageNum", defaultValue = "1") Integer pageNum,
                           @RequestParam(required = false, name = "pageSize", defaultValue = "10") Integer pageSize,
                           @RequestParam(required = false, name = "zt") String zt,
                           @RequestParam(required = false, name = "qssj") String qssj,
                           @RequestParam(required = false, name = "jssj") String jssj,
                           @RequestParam(required = false, name = "bh") String bh,
                           @RequestParam(required = false, name = "mc") String mc
    ) {

        Date qs = String2DateUtil.StringtoDate(qssj);
        Date js = String2DateUtil.StringtoDate(jssj);
        PageInfo<CzGc> info = service.Tjcx(pageNum, pageSize, zt, qs, js, bh, mc);
        return Result.success(info);

    }

    /*普通修改*/
    @PostMapping("/CzgcPtXg")
    public Result CzgcPtXg(@RequestBody CzGc gc) {
        int i = service.updateOneCzgc(gc);
        if (i == 1) {
            return Result.success(i);
        } else {
            return Result.error();
        }
    }

    /*审核后修改*/
    @PostMapping("/CzgcAfterSh")
    public Result CzgcAterSh(@RequestBody CzGc gc) {
        int i = service.ShAfterUpdate(gc);
        if (i == 1) {
            return Result.success(i);
        } else {
            return Result.error();
        }
    }

    /*弃用*/
    @PostMapping("/QyCzGcs")
    public Result QyCzGcs(  @RequestBody DeleteHtsByIdsVO vo) {
        boolean yes=true;
        String[] ids = vo.getIds();
        for (int i = 0; i < ids.length; i++) {
            int zt = service.updateCzgcZt(ids[i]);
            if(zt==0){
                yes=false;
                break;
            }
        }
        if(yes){
            return Result.success();
        }
        else {
            return Result.error();
        }
    }

    /*总数据*/
    @PostMapping("/CzgcTypeCount")
    public Result CzgcTypeCount() {

        int i = service.Tjcx(null, null, "2", null, null, null, null).getList().size();
        int k = service.Tjcx(null, null, "1", null, null, null, null).getList().size();
        int j = service.Tjcx(null, null, "0", null, null, null, null).getList().size();

        return Result.success(Arrays.asList(i + k + j, i, k, j));
    }


    @PostMapping("/CzGcSelectEq")
    public Result CzGcSelectEq(@RequestParam(required = false, name = "pageNum", defaultValue = "1") Integer pageNum,
                               @RequestParam(required = false, name = "pageSize", defaultValue = "10") Integer pageSize,
            @RequestParam(name = "eqName", required = false) String eqName) {
        PageHelper.startPage(pageNum,pageSize);
        List<CzGcShowEqVO> vos = mapper.selectAllEqInfo(eqName);
        return Result.success(new PageInfo<>(vos));
    }


    @PostMapping("/listCzgcZbBt")
    public Result listSelectEmpsCols(@RequestParam(required = false) String key) {
        JSONArray myJsonArray = null;
        if ("checkbox".equals(key)) {
            String jsonMessage = "[{'type': 'checkbox'}, " +
                    "{field: 'eqSbbh', title: '设备编号'}, " +
                    "{field: 'eqName', title: '设备名称'}, " +
                    "{field: 'eqPp', title: '设备品牌'}, " +
                    "{field: 'eqGg', title: '设备规格'}, " +
                    "{field: 'eqXh', title: '设备型号'}, " +
                    "{field: 'eqPmName', title: '设备品名'}]";
            myJsonArray = JSONObject.parseArray(jsonMessage);
        } else if ("radio".equals(key)) {
            String jsonMessage = "[{'type': 'radio'}, " +
                    "{field: 'eqSbbh', title: '设备编号'}, " +
                    "{field: 'eqName', title: '设备名称'}, " +
                    "{field: 'eqPp', title: '设备品牌'}, " +
                    "{field: 'eqGg', title: '设备规格'}, " +
                    "{field: 'eqXh', title: '设备型号'}, " +
                    "{field: 'eqPmName', title: '设备品名'}]";
            myJsonArray = JSONObject.parseArray(jsonMessage);
        }
        PageInfo date = new PageInfo(myJsonArray);
        return Result.success(date);
    }

    @PostMapping("/listCzgcMbBt")
    public Result listCzgcMbBt(@RequestParam(required = false) String key) {
        JSONArray myJsonArray = null;
        if ("checkbox".equals(key)) {
            String jsonMessage = "[{'type': 'checkbox'}, " +
                    "{field: 'mbId', title: '模板编号'}, " +
                    "{field: 'mbMc', title: '模板名称'}, " +
                    "]";
            myJsonArray = JSONObject.parseArray(jsonMessage);
        } else if ("radio".equals(key)) {
            String jsonMessage = "[{'type': 'radio'}, " +
                    "{field: 'mbId', title: '模板编号'}, " +
                    "{field: 'mbMc', title: '模板名称'}, " +
                    "]";
            myJsonArray = JSONObject.parseArray(jsonMessage);
        }
        PageInfo date = new PageInfo(myJsonArray);
        return Result.success(date);
    }

}

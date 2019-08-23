package com.litbo.hospital.lifemanage.controller.MyController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.lifemanage.MyUtils.DelSpaceUtils;
import com.litbo.hospital.lifemanage.MyUtils.String2DateUtil;
import com.litbo.hospital.lifemanage.bean.MyBean.EqHt;
import com.litbo.hospital.lifemanage.bean.vo.MyVO.DeleteHtsByIdsVO;
import com.litbo.hospital.lifemanage.bean.vo.MyVO.EqHtShowVO;
import com.litbo.hospital.lifemanage.bean.vo.MyVO.EqHtZbVO;
import com.litbo.hospital.lifemanage.bean.vo.MyVO.SbCsVO;
import com.litbo.hospital.lifemanage.service.MyService.EqHtService;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.user.service.CsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/lifeManage")
public class EqHtController {
    @Autowired
    private EqHtService service;

    @Autowired
    private CsService csService;

    /*选择查询与查询全部*/
    @PostMapping("/selectAllHt")
    public Result selectAllHt(@RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                              @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                              @RequestParam(required = false, name = "htYf") String htYf,
                              @RequestParam(required = false, name = "htZt") String htZt,
                              @RequestParam(required = false, name = "htBianhao") String htBianhao,
                              @RequestParam(required = false, name = "htQssj") String htQssj,
                              @RequestParam(required = false, name = "htJssj") String htJssj)  {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date qssj =  String2DateUtil.StringtoDate(htQssj);
        Date jssj =  String2DateUtil.StringtoDate(htJssj);
        EqHtShowVO showVO = new EqHtShowVO(htYf,htZt,htBianhao,qssj,jssj);

        service.loginCheckHtStatus();
        PageInfo<EqHtShowVO> list = service.ListHtAccount(pageNum, pageSize, showVO);
        return Result.success(list);

    }

    /*根据主键查询单个合同*/
    @PostMapping("/selectHtByPrimary")
    public Result selectByPrimary(@RequestParam(name = "id") String id) {
        EqHt ht = service.selectHtByPrimaryKey(id);
        return Result.success(ht);
    }

    /*合同录入*/
    @PostMapping("/addEqHt")
    public Result addEqHt(@RequestBody EqHt ht) {
        String s = DelSpaceUtils.deleteSpace(ht.getHtBianhao());
        if (service.selectHtIds().contains(s)) {
            return Result.error("合同编号已存在,请重新填写");
        }
        List<EqHtZbVO> zb = ht.getListZb();
        if (zb != null && zb.size() > 0) {
            ht.setHtZbhz(JSON.toJSONString(zb));
        } else {
            ht.setHtZbhz("[]");
        }
        Integer i = service.InsertHt(ht);
        if (i == 1) {
            return Result.success(i);
        } else {
            return Result.error("合同录入失败");
        }
    }

    /*保存新增生产厂*/
    @PostMapping("/addScs")
    public Result addScs(@RequestBody SbCsVO vo) {

        return Result.success(service.addSbCs(vo));

    }

    /*根据合同编号修改合同状态*/
    @PostMapping("/updateHtStatusByHtId")
    public Result updateHtStatusByHtId(@RequestParam(required = true, name = "htBianhao") String htBianhao, @RequestParam(required = true, name = "htZt") String htZt) {

        Integer update = null;
        try {
            update = service.updateByHtBianhao(htBianhao, htZt);

        } catch (Exception e) {
            return Result.error("修改合同状态失败");
        }

        return Result.success(update);
    }

    /*根据主键修改合同*/
    @PostMapping("/updateHtByPrimaryKey")
    public Result updateHtByPrimaryKey(@RequestBody EqHt ht) {
        String s = DelSpaceUtils.deleteSpace(ht.getHtBianhao());
        List<String> list = service.selectHtIds();
        list.remove(ht.getHtBianhao());
        if (list.contains(s)) {
            return Result.error("合同编号已存在,请重新填写");
        }
        Integer id = service.updateByPrimaryId(ht);
        if (id == 1) {
            return Result.success(id);
        } else {
            return Result.error("修改失败");
        }
    }

    /*根据主键删除合同*/
    @PostMapping("/deleteHtsByPrimaryKey")
    public Result deleteHtsByPrimaryKey(@RequestBody DeleteHtsByIdsVO vo) {
        String[] ids = vo.getIds();
        List<String> list = Arrays.asList(ids);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            service.deleteHtByPrimaryKey(list.get(i));
        }
        return Result.success(1);
    }

    /*厂商表头*/

    @PostMapping("/listHtBiaotou")
    public Result listSelectEmpsCols(@RequestParam(required = false) String key) {
        JSONArray myJsonArray = null;
        if ("checkbox".equals(key)) {
            String jsonMessage = "[{'type': 'checkbox'}, " +
                    "{field: 'sbcsIdScs', title: '厂商ID'}, " +
                    "{field: 'scsName', title: '厂商名称'}]";
            myJsonArray = JSONObject.parseArray(jsonMessage);
        } else if ("radio".equals(key)) {
            String jsonMessage = "[{'type': 'radio'}, " +
                    "{field: 'sbcsIdScs', title: '厂商ID'}, " +
                    "{field: 'scsName', title: '厂商名称'}]";
            myJsonArray = JSONObject.parseArray(jsonMessage);
        }
        PageInfo date = new PageInfo(myJsonArray);
        return Result.success(date);
    }

    /*查询所有合同编号*/
    @GetMapping("/HtBianhaoList")
    public Result HtBianhaoList(@RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                @RequestParam(name = "pageSzie", required = false, defaultValue = "10") Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return Result.success(new PageInfo<>(service.selectHtIds()));
    }

    /*根据厂商sbcs_id查询厂商名字*/
    @GetMapping("/selectCsNameById")
    public Result selectCsNameById(String id) {
        String str = service.selectCsNameById(id);
        return Result.success(str);
    }

}

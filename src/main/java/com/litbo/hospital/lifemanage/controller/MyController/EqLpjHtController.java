package com.litbo.hospital.lifemanage.controller.MyController;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.lifemanage.MyUtils.String2DateUtil;
import com.litbo.hospital.lifemanage.bean.MyBean.EqLpjht;
import com.litbo.hospital.lifemanage.bean.vo.MyVO.EqLpjHtShowVO;
import com.litbo.hospital.lifemanage.bean.vo.MyVO.EqLpjHtZbVO;
import com.litbo.hospital.lifemanage.bean.vo.MyVO.SbCsVO;
import com.litbo.hospital.lifemanage.service.MyService.EqLpjService;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.user.service.CsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/lifeManage")
public class EqLpjHtController {

    @Autowired
    private EqLpjService service;
    @Autowired
    private CsService csService;

    /*查询或条件查询*/
    @PostMapping("/selectAllLpjHt")
    public Result getAll(@RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                         @RequestParam(name = "pageSzie", required = false, defaultValue = "10") Integer pageSize,
                         @RequestParam(required = false,name = "htSbmc") String htSbmc,
                         @RequestParam(required = false,name = "htYf") String htYf,
                         @RequestParam(required = false,name = "htQssj") String htQssj,
                         @RequestParam(required = false,name = "htJssj") String htJssj
                         ) {
        Date qssj = String2DateUtil.StringtoDate(htQssj);
        Date jssj = String2DateUtil.StringtoDate(htJssj);

        EqLpjHtShowVO showVO = new EqLpjHtShowVO(htYf,htSbmc,qssj,jssj);
        PageInfo pageInfo = service.selectAll(pageNum, pageSize, showVO);
        return Result.success(pageInfo);
    }

    /*根据主键查询单个零配件合同*/
    @PostMapping("/selectLpjHtByPrimary")
    public Result selectLpjHtByPrimary(@RequestParam(name = "id") String id) {
        EqLpjht ht = service.selectLpjHtByPrimaryKey(id);
        return Result.success(ht);
    }

    @PostMapping("/deleteLpjHt")
    public Result delete(@RequestParam(required = false) List<String> ids) {
        try {
            for (int i = 0; i < ids.size(); i++) {
                service.deleteByPrimaryKey(ids.get(i));
            }
            return Result.success(1);
        } catch (Exception e) {

            log.error("删除失败", e.getMessage());
            return Result.error("删除失败");
        }

    }

    @PostMapping("/addEqLpjHt")
    public Result add(@RequestBody EqLpjht lpjht) {
        try {

            List<EqLpjHtZbVO> lpjlist = lpjht.getListLpj();
            if (lpjlist != null && lpjlist.size() > 0) {
                lpjht.setHtLpjhz(JSON.toJSONString(lpjlist));
            } else {
                lpjht.setHtLpjhz("[]");
            }

            int i = service.addLpjHt(lpjht);
            return Result.success(i);
        } catch (Exception e) {

            log.error("添加失败", e.getMessage());
            return Result.error("添加失败");
        }

    }

    @PostMapping("/updateLpjHtByPrimaryKey")
    public Result updateByPrimaryKey(@RequestBody EqLpjht ht) {
        try {
            int i = service.updateByPrimaryKey(ht);
            return Result.success(i);
        } catch (Exception e) {

            log.error("更新异常", e.getMessage());
            return Result.error("更新异常");
        }
    }

    @PostMapping("/addWxCs")
    public Result addWxCs(@RequestBody SbCsVO vo) {
        return Result.success(service.addWxCs(vo));
    }

    @GetMapping("/SbWxsCsList")
    public Result SbCsList(@RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                           @RequestParam(name = "pageSzie", required = false, defaultValue = "10") Integer pageSize) {
        return Result.success(csService.listWxs(pageNum, pageSize));
    }


    /*表头*/
    @PostMapping("/listLpjHtBiaotou")

    /*
     * 方法功能描述:
     * @Param: [key]
     * @Return: com.litbo.hospital.result.Result
     * @Description:
     * @Author: NCH
     * @Date: 2019/08/01 上午 9:18
     */

    public Result listSelectEmpsCols(@RequestParam(required = false) String key) {
        JSONArray myJsonArray = null;
        if ("checkbox".equals(key)) {
            String jsonMessage = "[{'type': 'checkbox'}, " +
                    "{field: 'sbcsIdWxs', title: '厂商ID'}, " +
                    "{field: 'wxsName', title: '厂商名称'}]";
            myJsonArray = JSONObject.parseArray(jsonMessage);
        } else if ("radio".equals(key)) {
            String jsonMessage = "[{'type': 'radio'}, " +
                    "{field: 'sbcsIdWxs', title: '厂商ID'}, " +
                    "{field: 'wxsName', title: '厂商名称'}]";
            myJsonArray = JSONObject.parseArray(jsonMessage);
        }

        PageInfo date = new PageInfo(myJsonArray);
        return Result.success(date);
    }

}

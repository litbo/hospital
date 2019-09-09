package com.litbo.hospital.lifemanage.controller.MyController;


import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.lifemanage.MyUtils.String2DateUtil;
import com.litbo.hospital.lifemanage.bean.vo.MyVO.*;
import com.litbo.hospital.lifemanage.dao.MyMapper.EqTjsqMapper;
import com.litbo.hospital.lifemanage.service.MyService.EqTjService;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.user.vo.LiveEmpVo;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/*调剂请求*/
@RestController
@RequestMapping("/lifeManage")
public class EqTjSqController {

    @Autowired
    private EqTjService service;

    @Autowired
    private EqTjsqMapper mapper;

    /*查询本部门所有设备*/
    @PostMapping("/ListEqInfo")
    public Result ListEqInfo(@RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                             @RequestParam(name = "pageSzie", required = false, defaultValue = "10") Integer pageSize,
                             @RequestParam(required = false, name = "bmid") String bmid) {
        LiveEmpVo sEmp = (LiveEmpVo) SecurityUtils.getSubject().getSession().getAttribute("emp");
        PageInfo info = service.ListEqInfo(pageNum, pageSize, sEmp.getBmId());

        return Result.success(info);
    }

    /*增加调剂请求*/
    @PostMapping("/addTjsq")
    public Result addTjsq(@RequestBody EqTjsqVO sq) {
        /*list包括装备名称和数量*/
        LiveEmpVo sEmp = (LiveEmpVo) SecurityUtils.getSubject().getSession().getAttribute("emp");
        sq.setTjSqks(sEmp.getBmId());
//        sq.setTjSqks("0201000000");
        int i = service.insertTjDrSq(sq);
        if(i==0){
            return Result.error("请求失败");
        }
        return Result.success(i);
    }

    /*签字图片上传*/
    @RequestMapping("/importTjsqimg")
    public Result setQzzp(@RequestParam("img") MultipartFile img) {
        String docUrl = service.importTjsqimg(img);
        String pjpath = System.getProperty("user.dir");
        docUrl = docUrl.replace(pjpath + "\\tj\\", "");
        return Result.success("\\" + docUrl);
    }

    /*查询或条件查询本部门所有调剂申请*/
    @PostMapping("/listBenBmTjSq")
    public Result selectBenBmByExample(@RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                       @RequestParam(name = "pageSzie", required = false, defaultValue = "10") Integer pageSize,
                                       @RequestParam(required = false, name = "tjQssj") String tjQssj,
                                       @RequestParam(required = false, name = "tjJssj") String tjJssj,
                                       @RequestParam(required = false, name = "sfyl") String sfyl,
                                       @RequestParam(required = false, name = "sfqbsl") String sfqbsl
    ) {
        Date qssj = String2DateUtil.StringtoDate(tjQssj);
        Date jssj = String2DateUtil.StringtoDate(tjJssj);

        LiveEmpVo sEmp = (LiveEmpVo) SecurityUtils.getSubject().getSession().getAttribute("emp");
        EqTjShowVO showVO = new EqTjShowVO(sEmp.getBmName(), qssj, jssj, sfyl, sfqbsl);

        PageInfo list = service.selectByBenBmExample(pageNum, pageSize, showVO);
        return Result.success(list);
    }

    /*查询所有调剂申请,查询所有替换申请是另一个,还没写，改成show.setTjSqlx("1")即可*/
    @PostMapping("/AllTjsq")
    public Result AllTjsq(@RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                          @RequestParam(name = "pageSzie", required = false, defaultValue = "10") Integer pageSize,
                          @RequestParam(required = false, name = "bmName") String bmName,
                          @RequestParam(required = false, name = "tjQssj") String tjQssj,
                          @RequestParam(required = false, name = "tjJssj") String tjJssj,
                          @RequestParam(required = false, name = "sfyl") String sfyl,
                          @RequestParam(required = false, name = "sfqbsl") String sfqbsl
    ) {
//        LiveEmpVo sEmp = (LiveEmpVo) SecurityUtils.getSubject().getSession().getAttribute("emp");
        //TODO 仅有综合设备科可以查询替换设备
//        if("0301b50000".equals(sEmp.getBmId())){
        Date qssj = String2DateUtil.StringtoDate(tjQssj);
        Date jssj = String2DateUtil.StringtoDate(tjJssj);

        EqTjShowVO show = new EqTjShowVO(bmName, qssj, jssj, sfyl, sfqbsl);
        show.setTjSqlx("0");
        PageInfo info = service.selectByExample(pageNum, pageSize, show);
        return Result.success(info);
//        }
//        else{
//            return Result.success("无所属权限！");
//        }

    }




    @PostMapping("/AllThsq")
    public Result AllThsq(@RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                          @RequestParam(name = "pageSzie", required = false, defaultValue = "10") Integer pageSize,
                          @RequestParam(required = false, name = "bmName") String bmName,
                          @RequestParam(required = false, name = "tjQssj") String tjQssj,
                          @RequestParam(required = false, name = "tjJssj") String tjJssj,
                          @RequestParam(required = false, name = "sfyl") String sfyl,
                          @RequestParam(required = false, name = "sfqbsl") String sfqbsl
    ) {
//        LiveEmpVo sEmp = (LiveEmpVo) SecurityUtils.getSubject().getSession().getAttribute("emp");
        //TODO 仅有综合设备科可以查询替换设备
//        if("0301b50000".equals(sEmp.getBmId())){
        Date qssj = String2DateUtil.StringtoDate(tjQssj);
        Date jssj = String2DateUtil.StringtoDate(tjJssj);

        EqTjShowVO show = new EqTjShowVO(bmName, qssj, jssj, sfyl, sfqbsl);
        show.setTjSqlx("1");
        PageInfo info = service.selectByExample(pageNum, pageSize, show);
        return Result.success(info);
//        }
//        else{
//            return Result.success("无所属权限！");
//        }

    }

    /*主键查看单个调剂请求申请*/
    @PostMapping("/selectTjsqByPrimaryKey")
    public Result selectByPrimary(@RequestParam(name = "id") String id) {
        EqTjsqVO vo = service.selectByPrimaryKey(id);
        List<TjZbMcNameCount> counts = JSONArray.parseArray(vo.getTjZbmc(), TjZbMcNameCount.class);
        vo.setZbmclist(counts);
        vo.setBmName(mapper.selectBmNameByBmid(vo.getTjSqks()));
        return Result.success(vo);
    }

    /*删除调剂请求们*/
    @PostMapping("/deleteTjsqs")
    public Result deleteIds(@RequestBody DeleteHtsByIdsVO vo) {
        String[] list = vo.getIds();
        List<String> ids = Arrays.asList(list);
        for (int i = 0; i < ids.size(); i++) {
            service.deleteByPrimaryKey(ids.get(i));
        }
        return Result.success(1);
    }

    /*根据调剂选择更新调剂装备数量
     * 需要id，选中数量,装备名称
     *
     * */
    @PostMapping("/updateTjsqZbCount")
    public Result updateTjsqZbCount(@RequestParam("id") String id,
                                    @RequestParam("count") Integer count,
                                    @RequestParam("zbname") String zbname) {
        int i = service.updateSqZbBykey(id, count, zbname);
        return Result.success(i);
    }

    /*增加或者修改装备调出记录*/
    @PostMapping("/insertZbdc")
    public Result insertZbdc(@RequestBody List<EqTjZbdcVO> listzbdc) {
        int i = service.insertTjZbdc(listzbdc);
        return Result.success(i);
    }





    /*
     * 方法功能描述:
     * @Param: [id, zbbm, ggxh]
     * @Return: com.litbo.hospital.result.Result
     * @Description:  id为装备调出id
     * @Author: NCH
     * @Date: 2019/08/01 上午 8:39
     */
    /*删除整条调出装备记录*/
    @PostMapping("/deleteTjZbdc")
    public Result deleteTjZbdc(@RequestBody DeleteHtsByIdsVO vo) {
        int i = 1;
        String[] ids = vo.getIds();
        for (String id : ids) {
            i = service.deleteZbDcById(id);
            if (i == 0) {
                return Result.error();
            }
        }


        return Result.success(i);
    }

    /*根据主键查询一条装备调出记录*/
    @PostMapping("/selectOneZbdc")
    public Result selectOneZbdc(@RequestParam("id") String id) {
        EqTjZbdcVO vo = service.selectTjZbdcByPrimary(id);

        return Result.success(vo);
    }

    /*根据主键修改一条装备调出记录*/
    @PostMapping("/updateOneZbdc")
    public Result updateOneZbdc(@RequestBody EqTjZbdcVO vo) {
        int i = service.updateZbdcByPrimaryKey(vo);
        if(i==1)
        {
            return Result.success();
        }

        else{
            return Result.error("修改异常");
        }
    }

    /*查询或条件查询可调剂设备*/
    @PostMapping("/selectAllEqInfo")
    public Result selectAllEqInfo(@RequestParam("sbName") String sbName,
                                  @RequestParam(required = false, name = "bmname") String bmname,
                                  @RequestParam(required = false, name = "yq") String yq) {
        PageInfo info = service.selectAllEqInfo(sbName, bmname, yq);
        return Result.success(info);
    }


    /*查看所有未送达调配单*/
    @PostMapping("/selectWsdDpd")
    public Result selectWsdDpd(@RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                               @RequestParam(name = "pageSzie", required = false, defaultValue = "10") Integer pageSize,
                               @RequestParam(name = "lx") String lx ) {
        PageInfo info = service.selectWsdYsd(pageNum,pageSize,lx);
        return Result.success(info);
    }

    /*查看所有已送达调配单*/
    @PostMapping("/selectYsdDpd")
    public Result selectYsdDpd(@RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                               @RequestParam(name = "pageSzie", required = false, defaultValue = "10") Integer pageSize,
                               @RequestParam(name = "lx") String lx) {
        PageInfo info = service.selectYsdYsd(pageNum,pageSize,lx);
        return Result.success(info);
    }
/*
    @PostMapping("/selectYsdDpd")
    public Result selectYsdDpd() {
        PageInfo info = service.selectYsdYsd();
        return Result.success(info);
    }*/

}

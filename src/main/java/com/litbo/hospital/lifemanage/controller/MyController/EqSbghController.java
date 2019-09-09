package com.litbo.hospital.lifemanage.controller.MyController;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.lifemanage.MyUtils.String2DateUtil;
import com.litbo.hospital.lifemanage.bean.vo.MyVO.EqSbghVO;
import com.litbo.hospital.lifemanage.bean.vo.MyVO.EqSbghZbVO;
import com.litbo.hospital.lifemanage.service.MyService.EqSbghService;
import com.litbo.hospital.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

@RestController
@RequestMapping("/lifeManage")
public class EqSbghController {
    @Autowired
    private EqSbghService service;

    /**
     * 设备归还增加
     * @param vo
     * @return
     */
    @PostMapping("/insertEqSbgh")
    public Result insertEqSbgh(@RequestBody EqSbghVO vo) {
        int i = service.insertEqSbgh(vo);
        return Result.success(i);
    }

    /**
     * 查询全部或者条件查询设备归还
     * @param pageNum
     * @param pageSize
     * @param bmid
     * @param qssj
     * @param jssj
     * @return
     */
    @PostMapping("/selectAllSbgh")
    public Result selectAllSbgh(@RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                @RequestParam(name = "bmid", required = false) String bmid,
                                @RequestParam(name = "qssj", required = false) String qssj,
                                @RequestParam(name = "jssj", required = false)String jssj,
                                @RequestParam(name = "lx") String lx) {
        Date qs = String2DateUtil.StringtoDate(qssj);
        Date js = String2DateUtil.StringtoDate(jssj);

        PageInfo info = service.selectAllSbgh(pageNum, pageSize, bmid, qs, js,lx);
        return Result.success(info);
    }

    /**
     * 主键查询设备归还详情
     * @param id
     * @return
     */

    @PostMapping("/selectOneSbghByPrimaryKey")
    public Result selectOneSbghByPrimaryKey(@RequestParam(name = "id") String id) {
        EqSbghVO vo = service.selectOneSbghByPrimaryKey(id);

        return Result.success(vo);
    }

    /**
     * 根据设备编号查询设备调剂交接Id,所属科室和借出科室
     * @param sbbh
     * @return
     */
    @PostMapping("/selectEq2ByBianhao")
    public Result selectEq2ByBianhao(@RequestParam(name = "sbbh") String sbbh, @RequestParam(name = "lx") String lx, HttpServletRequest request) {
        EqSbghZbVO vo = service.selectEq2ByBianhao(sbbh,lx);
        if(vo!=null){
            request.getSession().setAttribute("tjjjdcks2",vo.getTjjjDcks());
        }
        Object tjjjdcks = request.getSession().getAttribute("tjjjdcks2");
        return Result.success(vo);
    }

    /**
     * 根据调剂交接id查询已经归还的设备编号
     * @param pageNum
     * @param pageSize
     * @param dpjjid
     * @return
     */
    @PostMapping("/selectAllSbgh2")
    public Result selectAllSbgh2(@RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                 @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                 @RequestParam(name = "dpjjid") String dpjjid) {
        PageInfo info = service.selectAllSbgh(pageNum, pageSize, dpjjid);
        return Result.success(info);
    }

    /**(选择项)根据装备编号查询调出科室和调入科室再查询调剂交接表中要还装备*/
    @RequestMapping("/selectElseZb")
    public Result selectElseZb(@RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                               @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                               @RequestParam(name = "drks")  String drks,
                               HttpServletRequest request) {
        String dcks="";
       /* Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if("tjjjdcks".equals(cookie.getName()))
            {
                 dcks=cookie.getValue();
            }
        }*/
        HttpSession session = request.getSession();
        dcks = (String)session.getAttribute("tjjjdcks2");
        PageInfo vo = service.selectElseZb(pageNum, pageSize, drks, dcks);
        return Result.success(vo);
    }



    /**
     * 方法功能描述: 修改设备归还
     * @Param: [vo]
     * @Return: com.litbo.hospital.result.Result
     * @Description:
     * @Author: NCH
     * @Date: 2019/08/07 上午 11:02
     */

    @PostMapping("/updateEqsbghByPrimaryKey")
    public Result updateEqsbghByPrimaryKey(@RequestBody EqSbghVO vo) {
        int i = service.insertEqSbgh(vo);
        return Result.success(i);
    }




    /*厂商表头*/

    @PostMapping("/listSbghBiaotou")
    public Result listSbghBiaotou(@RequestParam(required = false) String key) {
        JSONArray myJsonArray = null;
        if ("checkbox".equals(key)) {
            String jsonMessage = "[{'type': 'checkbox'}, " +
                    "{field: 'eqSbbh', title: '设备编号'}, " +
                    "{field: 'eqGg', title: '设备编号'}, " +
                    "{field: 'eqXh', title: '型号'}, " +
                    "{field: 'eqName', title: '设备名称'}]";
            myJsonArray = JSONObject.parseArray(jsonMessage);
        } else if ("radio".equals(key)) {
            String jsonMessage = "[{'type': 'radio'}, " +
                    "{field: 'eqSbbh', title: '设备编号'}, " +
                    "{field: 'eqGg', title: '规格'}, " +
                    "{field: 'eqXh', title: '型号'}, " +
                    "{field: 'eqName', title: '设备名称'}]";
            myJsonArray = JSONObject.parseArray(jsonMessage);
        }
        PageInfo date = new PageInfo(myJsonArray);
        return Result.success(date);
    }


}

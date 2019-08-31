package com.litbo.hospital.lifemanage.controller.MyController;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.lifemanage.MyUtils.String2DateUtil;
import com.litbo.hospital.lifemanage.bean.vo.MyVO.YjyaLclogVO;
import com.litbo.hospital.lifemanage.dao.MyMapper.YjyaZdMapper;
import com.litbo.hospital.lifemanage.service.MyService.YjyaLclogService;
import com.litbo.hospital.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/*应急预案流程记录*/
@RestController
@RequestMapping("/lifeManage")
public class YjyaLclogController {

    @Autowired
    private YjyaLclogService service;

    @Autowired
    private YjyaZdMapper mapper;
    /*/**
     * 方法功能描述: 编号查询预案记录详情
     * @Param: 预案编号
     * @Return:
     * @Description:
     * @Author: NCH
     * @Date: 2019/08/27 下午 3:00
     */

    @PostMapping("/selectYalogByBh")
    public Result selectYalogByBh(@RequestParam(name = "bh")String bh){
        YjyaLclogVO vo = service.selectYalogByBh(bh);
        return Result.success(vo);
    }

    /*/**
     * 方法功能描述:  全部查询或条件查询预案记录
     * @Param:   状态,查询起始时间，查询结束时间，预案编号，预案名称
     * @Return:
     * @Description:
     * @Author: NCH
     * @Date: 2019/08/27 下午 3:00
     */

    @PostMapping("/selectAllYalogByExample")
    public Result selectAllYalogByExample(@RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                          @RequestParam(name = "pageSzie", required = false, defaultValue = "10") Integer pageSize,
                                          @RequestParam(required = false,name = "zt") String zt,
                                          @RequestParam(required = false,name = "qssj")String qssj,
                                          @RequestParam(required = false,name = "jssj")String jssj,
                                          @RequestParam(required = false,name = "yabh")String yabh,
                                          @RequestParam(required = false,name = "yaname") String yaname
                                          ){
        Date qs = String2DateUtil.StringtoDate(qssj);
        Date js = String2DateUtil.StringtoDate(jssj);
        PageInfo info = service.selectAllYalogByExample(pageNum, pageSize, zt, qs, js, yabh, yaname);
        return Result.success(info);
    }

    /*/**
     * 方法功能描述: 弃用备案
     * @Param: bhs[List<String>]   预案编号集合
     * @Return: com.litbo.hospital.result.Result
     * @Description:
     * @Author: NCH
     */
    @PostMapping("/updateYaStatus")
    public Result updateYaStatus(@RequestBody List<String> bhs) {

        for (String bh : bhs) {
            mapper.updateYaStatus(bh, "0");
        }
        return Result.success();

    }


    /*查询总记录数，已备案数,试用中数,已弃用数*/

    @PostMapping("/AllTypeCount")
    public Result AllTypeCount() {

        List list = service.selectAllYalogByExample(1, 10, null, null, null, null, null).getList();
        List list2 = service.selectAllYalogByExample(1, 10, "2", null, null, null, null).getList();
        List list3 = service.selectAllYalogByExample(1, 10, "1", null, null, null, null).getList();
        List list4 = service.selectAllYalogByExample(1, 10, "0", null, null, null, null).getList();
        List<Integer> asList = Arrays.asList(list.size(),list2.size(),list3.size(),list4.size());
        return Result.success(asList);

    }



}

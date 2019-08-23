package com.litbo.hospital.lifemanage.controller.MyController;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.lifemanage.MyUtils.String2DateUtil;
import com.litbo.hospital.lifemanage.bean.vo.MyVO.EqTjjjShowVO;
import com.litbo.hospital.lifemanage.bean.vo.MyVO.EqTjjjVO;
import com.litbo.hospital.lifemanage.service.MyService.EqTjjjService;
import com.litbo.hospital.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/lifeManage")
public class EqTjjjController {

    /**调剂交接增加记录*/
    @Autowired
    private EqTjjjService service;

    @PostMapping("/insertTjjj")
    public Result insertTjjj(@RequestBody EqTjjjVO tjjj) {
        int i = service.insertTjjj(tjjj);
        if (i == 1) {
            return Result.success();
        } else {
            return Result.error();
        }
    }

    /**
     * 方法功能描述: 调剂交接查询或条件查询
     * @Param: [tjjj]
     * @Return: com.litbo.hospital.result.Result
     * @Description:
     * @Author: NCH
     * @Date: 2019/08/04 上午 9:59
     */
    @PostMapping("/selectByExample")
    public Result selectByExample(
            @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
            @RequestParam(required = false, name = "tjjjQssj") String tjjjQssj,
            @RequestParam(required = false, name = "tjjjJssj") String tjjjJssj) {
        Date qssj = String2DateUtil.StringtoDate(tjjjQssj);
        Date jssj = String2DateUtil.StringtoDate(tjjjJssj);
        EqTjjjShowVO vo = new EqTjjjShowVO();
        vo.setTjjjQssj(qssj);
        vo.setTjjjJssj(jssj);
        PageInfo<EqTjjjShowVO> info = service.selectByExample(pageNum, pageSize, vo);

        return Result.success(info);
    }

    /*
     * 方法功能描述: 根据主键查询交接记录
     * @Param: [pageNum, pageSize, tjjjQssj, tjjjJssj]
     * @Return: com.litbo.hospital.result.Result
     * @Description:
     * @Author: NCH
     * @Date: 2019/08/04 上午 10:33
     */
    @PostMapping("/selectByPrimaryKey")
    public Result selectByPrimaryKey(@RequestParam(name = "id") String id) {
        EqTjjjVO tjjjVO = service.selectByPrimaryKey(id);
        return Result.success(tjjjVO);
    }

}

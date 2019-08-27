package com.litbo.hospital.lifemanage.controller;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.lifemanage.bean.vo.DhdjksjsVO;
import com.litbo.hospital.lifemanage.bean.vo.SgDhdjVO;
import com.litbo.hospital.lifemanage.service.SgDhdjService;
import com.litbo.hospital.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 到货登记表Controller
 *
 * @author 马
 */
@RestController
@RequestMapping("/lifeManage")
public class SgDhdjController {
    @Autowired
    private SgDhdjService sgDhdjService;

    /**
     * 选择合同编号
     */
    @GetMapping("/selectHtBianhao")
    public Result selectHtBianhao(@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                  @RequestParam(value = "pageSzie", required = false, defaultValue = "10") Integer pageSize) {
        PageInfo info = sgDhdjService.selectHtBianhao(pageNum, pageSize);
        return Result.success(info);
    }

    /**
     * 添加到货登记信息
     *
     * @param sgDhdjVO 到货登记信息
     * @return Result
     */
    @PostMapping("/insertSgDhdj")
    public Result insertSgDhdj(@RequestBody SgDhdjVO sgDhdjVO) {
        sgDhdjService.insertSgDhdj(sgDhdjVO);
        return Result.success();
    }


    /**
     * 查询科室接收的货物
     *
     * @param userId   当前用户id
     * @param pageNum  当前页数
     * @param pageSize 每页显示的记录数
     * @return Result
     */
    @PostMapping("/selectDjhwKsjs")
    public Result selectDjhwKsjs(@RequestParam(name = "userId") String userId,
                                 @RequestParam(name = "pageNum", defaultValue = "1", required = false) Integer pageNum,
                                 @RequestParam(name = "pageSize", defaultValue = "10", required = false) Integer pageSize) {
        Result<PageInfo<DhdjksjsVO>> result = null;
        try {
            result = Result.success(sgDhdjService.selectDjhwKsjs(userId, pageNum, pageSize));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.success(result);
    }

    /**
     * 科室接收
     * @param djhwId 登记货物id
     * @param userId 登陆人id
     * @return Result
     */
    @PostMapping("/updateSgDhdjKsjs")
    public Result updateSgDhdjKsjs(@RequestParam(name = "djhwId") String djhwId,
                                   @RequestParam(name = "userId") String userId) {
        sgDhdjService.updateSgDhdjKsjs(djhwId, userId);
        return Result.success();
    }

    /**
     * 科室接收货物详情信息
     *
     * @param djhwId 到货登记id
     * @return Result
     */
    @PostMapping("/selectSgDhdjDetails")
    public Result selectSgDhdjDetails(@RequestParam(name = "djhwId") String djhwId) {
        return Result.success(sgDhdjService.selectSgDhdjDetails(djhwId));
    }
    /*
     * 方法功能描述:
     * @Param: [pageNum, pageSize, htid, htzt]
     * @Return: com.litbo.hospital.result.Result
     * @Description:
     * @Author: NCH
     * @Date: 2019/08/01 下午 16:37
     */
    @PostMapping("/selectAllSgDhdjAndDjhw")
    public Result selectAllSgDhdjAndDjhw(@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                         @RequestParam(value = "pageSzie", required = false, defaultValue = "10") Integer pageSize,
                                         @RequestParam(required = false, name = "htid") String htid,
                                         @RequestParam(required = false, name = "htzt") String htzt) {

        PageInfo<List<SgDhdjVO>> info = sgDhdjService.selectAllDhdj(pageNum, pageSize, htid, htzt);
        return Result.success(info);
    }

    @GetMapping("/selectOneSgDhdjAndDjhwByHtid")
    public Result selectOneSgDhdjAndDjhwByHtid(@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                               @RequestParam(value = "pageSzie", required = false, defaultValue = "10") Integer pageSize,
                                               String htid) {

        PageInfo<List<SgDhdjVO>> info = sgDhdjService.selectDhdjAndDjhwBy(pageNum, pageSize, htid);
        return Result.success(info);
    }



    @RequestMapping("/importdjhwimgurls")
    public Result importdjhwimgurls(@RequestParam("imgs") MultipartFile[] imgs) {

        String docUrl = sgDhdjService.Importdjhwimgurls(imgs);
        return Result.success(docUrl);
    }
}

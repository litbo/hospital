package com.litbo.hospital.operational_data_monitoring.software_interface.controller;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.operational_data_monitoring.software_interface.bean.EqInfo;
import com.litbo.hospital.operational_data_monitoring.software_interface.bean.EqYzTab;
import com.litbo.hospital.operational_data_monitoring.software_interface.bean.HisSfxmDict;
import com.litbo.hospital.operational_data_monitoring.software_interface.mapper.HisSfxmDictMapper;
import com.litbo.hospital.operational_data_monitoring.software_interface.service.EqYzTabService;
import com.litbo.hospital.operational_data_monitoring.software_interface.service.HisSfxmDictService;
import com.litbo.hospital.operational_data_monitoring.software_interface.vo.EqXm;
import com.litbo.hospital.operational_data_monitoring.software_interface.vo.EqXmVO;
import com.litbo.hospital.operational_data_monitoring.software_interface.vo.TD;
import com.litbo.hospital.operational_data_monitoring.software_interface.vo.XmVO;
import com.litbo.hospital.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.operational_data_monitoring.software_interface.controller
 * @Author: looli
 * @CreateTime: 2019-07-28 10:55
 * @Description: todo
 */
@RestController
@RequestMapping("/medical")
public class MedicalOrderController {
    @Autowired
    private HisSfxmDictService service;
    @Autowired
    private EqYzTabService eqYzTabService;
    @Autowired
    private HisSfxmDictMapper mapper;
    @RequestMapping("/show")
    public Result show(@RequestParam(required = false,defaultValue = "10") Integer pageSize,
                       @RequestParam(required = false,defaultValue = "1") Integer pageNum,
                       @RequestParam(required = false) String name){
//        System.out.println(pageNum);
        if (name ==null || name.equals("")){
            name = null;
        }
        PageInfo pageInfo = service.showXmByName(name, pageNum, pageSize);
        return Result.success(pageInfo);
    }

    /**
     * 重新导入医嘱数据
     */
    @RequestMapping("/importData")
    public Result importData() {
        //删除之前的数据
        service.delete();
        eqYzTabService.delete();
        //查询数据   导入数据
        List<HisSfxmDict> hisSfxmDicts = mapper.selectAll();
        int batchCount = 200;
        int batchLastIndex = batchCount - 1;
        for (int index = 0; index < hisSfxmDicts.size() - 1; ) {
            if (batchLastIndex > hisSfxmDicts.size() - 1) {
                batchLastIndex = hisSfxmDicts.size() - 1;
                service.saves(hisSfxmDicts.subList(index, batchLastIndex + 1));
                break;// 数据插入完毕,退出循环
            } else {
                service.saves(hisSfxmDicts.subList(index, batchLastIndex + 1));
                index = batchLastIndex + 1;// 设置下一批下标
                batchLastIndex = index + (batchCount - 1);
            }
        }
        return Result.success();
    }

    @RequestMapping("/save")
    public Result save(@RequestBody EqXmVO eqXmVO){
        List<EqYzTab> eqYzTabList = new ArrayList<>();
        for (XmVO xmVO:
                eqXmVO.getXmList()) {
            for (EqInfo eq:
                    eqXmVO.getEqList()) {
                EqYzTab eqYzTab = new EqYzTab();
                eqYzTab.setYzXmBm(xmVO.getSfXmBm());
                eqYzTab.setEqId(eq.getEqId());
                eqYzTabList.add(eqYzTab);
            }
        }
        eqYzTabService.save(eqYzTabList);
        return Result.success();
    }

    /**
     * 取消匹配
     * @param eqXmVO
     * @return
     */
    @RequestMapping("/delete")
    public Result delete(@RequestBody EqXmVO eqXmVO){
        List<EqYzTab> eqYzTabList = new ArrayList<>();
        for (XmVO xmVO:
                eqXmVO.getXmList()) {
            for (EqInfo eq:
                    eqXmVO.getEqList()) {
                EqYzTab eqYzTab = new EqYzTab();
                eqYzTab.setYzXmBm(xmVO.getSfXmBm());
                eqYzTab.setEqId(eq.getEqId());
                eqYzTabList.add(eqYzTab);
            }
        }
        eqYzTabService.delete(eqYzTabList);
        return Result.success();
    }


    /**
     * 取消匹配 根据id删除信息
     * @param id
     * @return
     */
    @RequestMapping("/deleteOne")
    public Result deleteOne(String id){
        eqYzTabService.deleteOne(id);
        return Result.success();
    }

    /**
     * 批量 根据id删除信息
     * @param
     * @return
     */
    @RequestMapping(value = "/deletes",method = RequestMethod.POST)
    public Result deleteOne(
            @RequestBody TD ids){
        String[] ids1 = ids.getIds();
        eqYzTabService.deletes(ids1);
        return Result.success();
    }
//
//    /**
//     * 取消匹配
//     * @param eqXmVO
//     * @return
//     */
//    @RequestMapping("/deleteOne")
//    public Result deleteOne(@RequestBody EqXmVO eqXmVO){
//        List<EqYzTab> eqYzTabList = new ArrayList<>();
//        for (XmVO xmVO:
//                eqXmVO.getXmList()) {
//            for (EqInfo eq:
//                    eqXmVO.getEqList()) {
//                EqYzTab eqYzTab = new EqYzTab();
//                eqYzTab.setYzXmBm(xmVO.getSfXmBm());
//                eqYzTab.setEqId(eq.getEqId());
//                eqYzTabList.add(eqYzTab);
//            }
//        }
//        eqYzTabService.delete(eqYzTabList);
//        return Result.success();
//    }


    /**
     * 查询已匹配信息
     * @return
     */
    @RequestMapping("/showMsg")
    public Result show(@RequestParam(required = false,defaultValue = "10") Integer pageSize,
                       @RequestParam(required = false,defaultValue = "1") Integer pageNum, EqXm eqXm){
        return Result.success(eqYzTabService.show(pageNum,pageSize,eqXm));
    }


    /**
     * 修改匹配信息
     * @param eqXm
     * @return
     */
    @RequestMapping("/update")
    public Result update(EqXm eqXm){
        eqYzTabService.update(eqXm);
        return Result.success();
    }

}

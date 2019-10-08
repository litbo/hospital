package com.litbo.hospital.lifemanage.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


import com.litbo.hospital.lifemanage.bean.SelectVO;
import com.litbo.hospital.lifemanage.bean.SgPd;
import com.litbo.hospital.lifemanage.bean.vo.SgCheckVO;
import com.litbo.hospital.lifemanage.dao.SelectMapper;
import com.litbo.hospital.lifemanage.dao.SgCheckMapper;
import com.litbo.hospital.lifemanage.dao.SgPdMapper;
import com.litbo.hospital.lifemanage.service.SelectService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class SelectServiceImp implements SelectService {

    @Autowired
    private SgPdMapper sgPdMapper;
    @Autowired
    private SelectMapper selectMapper;
    @Autowired
    private SgCheckMapper sgCheckMapper;
    @Override
    public PageInfo<SelectVO> selectAll(@Param("pdJhid")String pdJhid,
                                        @Param("bmId") String bmId
                                    , @Param("pageNum")Integer pageNum
                                    , @Param("pageSize")Integer pageSize) {

        PageHelper.startPage(pageNum, pageSize);
        List<SelectVO> adllDate = new ArrayList<SelectVO>();  //所有数据
        String getAllBmName = selectMapper.getBmName(bmId); //对应planid下的部门
        List<SgPd> list = sgPdMapper.selectAllData(pdJhid); //查询所有插入的扫描到的编号
        for (SgPd sgPd : list) {
                adllDate.add(selectMapper.listAllDate(sgPd.getPdScanId()));
        }

        // 临时集合
        List<SelectVO> listTemp = new ArrayList<SelectVO>();
        List<SelectVO> listTemp2 = new ArrayList<SelectVO>();//盘亏集合
        for (int i = 0;i < adllDate.size(); i++) {
            // 保存不为空的元素
            if (adllDate.get(i) != null) {
                String asd = adllDate.get(i).getBmName();
                System.out.println(asd);
                if (getAllBmName.equals(asd)){
                    listTemp.add(adllDate.get(i));
                }else {
                    listTemp2.add(adllDate.get(i));
                }
            }

        }

            adllDate = listTemp;

        return new PageInfo<>(adllDate);
    }

    @Override
    public PageInfo<SelectVO> selectNot(String pdJhid, String bmId, Integer pageNum, Integer pageSize) {

        PageHelper.startPage(pageNum, pageSize);
        List<SelectVO> adllDate = new ArrayList<SelectVO>();  //所有数据
        String getAllBmName = selectMapper.getBmName(bmId); //对应planid下的部门
        List<SgPd> list = sgPdMapper.selectAllData(pdJhid); //查询所有插入的扫描到的编号
//        List<SgCheckVO> listCheck = sgCheckMapper.getListByPlanId(pdJhid);//查询科室下所有设备
        for (SgPd sgPd : list) {
            adllDate.add(selectMapper.listAllDate(sgPd.getPdScanId()));
        }

        // 临时集合
        List<SelectVO> listTemp = new ArrayList<SelectVO>();
        for (int i = 0;i < adllDate.size(); i++) {
            // 保存不为空的元素
            if (adllDate.get(i) != null) {
                String asd = adllDate.get(i).getBmName();
//                System.out.println(asd);
                if (getAllBmName.equals(asd)){
                    listTemp.add(adllDate.get(i));
                }
            }
        }
        adllDate = listTemp;
        /*
        adllDate  和allDate2
        * */
        List<SelectVO> adllDate2 = selectMapper.listCheckDate(bmId);

        System.out.println(adllDate2); //所有应该盘的。
        List<SelectVO> allDate3 = new ArrayList<>();
        for(SelectVO a : adllDate){
            if(adllDate2.contains(a)){

                adllDate2.remove(a);
                System.out.println("ok!!!");
            }
        }
        System.out.println(adllDate);
        System.out.println(adllDate2);
        return new PageInfo<>(adllDate2);
    }

    @Override
    public PageInfo<SelectVO> allList(String pdJhid, String bmId, Integer pageNum, Integer pageSize) {

        PageHelper.startPage(pageNum, pageSize);
        List<SelectVO> adllDate3 = selectMapper.listCheckDate(bmId);
        return new PageInfo<>(adllDate3);
    }
    @Override
    public PageInfo<SelectVO> selectLess(@Param("pdJhid")String pdJhid,
                                        @Param("bmId") String bmId
            , @Param("pageNum")Integer pageNum
            , @Param("pageSize")Integer pageSize) {

        PageHelper.startPage(pageNum, pageSize);
        List<SelectVO> adllDate = new ArrayList<SelectVO>();  //所有数据
        String getAllBmName = selectMapper.getBmName(bmId); //对应planid下的部门
        List<SgPd> list = sgPdMapper.selectAllData(pdJhid); //查询所有插入的扫描到的编号
        for (SgPd sgPd : list) {
            adllDate.add(selectMapper.listAllDate(sgPd.getPdScanId()));
        }

        // 临时集合
        List<SelectVO> listTemp = new ArrayList<SelectVO>();
        List<SelectVO> listTemp2 = new ArrayList<SelectVO>();//盘亏集合
        for (int i = 0;i < adllDate.size(); i++) {
            // 保存不为空的元素
            if (adllDate.get(i) != null) {
                String asd = adllDate.get(i).getBmName();
                System.out.println(asd);
                if (getAllBmName.equals(asd)){
                    listTemp.add(adllDate.get(i));
                }else {
                    listTemp2.add(adllDate.get(i));
                }
            }

        }

        adllDate = listTemp;

        return new PageInfo<>(listTemp2);
    }
}




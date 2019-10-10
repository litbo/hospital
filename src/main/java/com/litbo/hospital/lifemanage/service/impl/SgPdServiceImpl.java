package com.litbo.hospital.lifemanage.service.impl;



import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.common.utils.DbUtil.IDFormat;
import com.litbo.hospital.lifemanage.bean.*;
import com.litbo.hospital.lifemanage.bean.vo.SgPdVO;
import com.litbo.hospital.lifemanage.dao.SelectMapper;
import com.litbo.hospital.lifemanage.dao.SgPdMapper;
import com.litbo.hospital.lifemanage.dao.SgPlanMapper;
import com.litbo.hospital.lifemanage.service.SgPdSeverice;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class SgPdServiceImpl implements SgPdSeverice {
    @Autowired
    private SgPdMapper sgPdMapper;
    @Autowired
    private SgPlanMapper sgPlanMapper;
    @Autowired
    private SelectMapper selectMapper;

//    /**
//     * 插入盘点的计划id和操作人id
//     * @param record
//     * @return
//     */
//    @Override
//    public int insertJhCz(SgPdVO record){
//
//        SgPd sgPd = new SgPd();
//        BeanUtils.copyProperties(record, sgPd);
//        int successCount = 0;
//        if((record.getPdJhid()!=null) && (record.getPdCzr()!=null)){
//            sgPd.setPdId(IDFormat.getIdByIDAndTime("sg_pd", "pd_id"));
//            sgPdMapper.insertPdId(sgPd);
//            successCount++;
//        }
//        return successCount;
//    }

    /**
     * 插入盘点扫描到的所有编号和盘点时间
     *
     * @param record
     */
    @Override
    public int insertPdId(SgPdVO record,String pdJhid) {
        System.out.println(pdJhid+"盘点计划id");
        SgPd sgPd = new SgPd();
        sgPd.setPdJhid(pdJhid);
        BeanUtils.copyProperties(record, sgPd);
        int successCount = 0;
        for (String pdScanId : record.getPid()) {
            for (String pdScsj : record.getPdScsj()) {
                if (StringUtils.isBlank(pdScanId)) {
                    continue;
                }
//                String selectId = sgPdMapper.selectScanId(pdScanId); //检查重复
//                if (StringUtils.isNotBlank(selectId)) {
//                    continue;
//                }

            sgPd.setPdScsj(pdScsj);
            }
            sgPd.setPdId(IDFormat.getIdByIDAndTime("sg_pd", "pd_id"));
            sgPd.setPdScanId(pdScanId);

//              sgPd.setPdScsj(record.getPdScsj());
            sgPd.setPdJhid(pdJhid);
            sgPdMapper.insertPdId(sgPd);
            System.out.println("成功");
            successCount++;
        }
        return successCount;
    }



    @Override
    public void insetStatus(String pdJhid, String bmId, Integer pageNum, Integer pageSize) {

        PageHelper.startPage(pageNum, pageSize);
        List<SelectVO> adllDate = new ArrayList<SelectVO>();  //所有数据
        String getAllBmName = selectMapper.getBmName(bmId); //对应planid下的部门
        List<SgPd> list = sgPdMapper.selectAllData(pdJhid); //查询所有插入的扫描到的编号
        for (SgPd sgPd : list) {
            adllDate.add(selectMapper.listAllDate(sgPd.getPdScanId()));
        }

        List<SelectVO> listTemp = new ArrayList<SelectVO>();
        List<SelectVO> listTemp2 = new ArrayList<SelectVO>();//盘亏集合
        for (int i = 0;i < adllDate.size(); i++) {
            if (adllDate.get(i) != null) {
                String asd = adllDate.get(i).getBmName();
                if (getAllBmName.equals(asd)){
                    listTemp.add(adllDate.get(i));
                }else {
                    listTemp2.add(adllDate.get(i));
                }
            }

        }
        List<SelectVO> adllDate2 = selectMapper.listCheckDate(bmId);
        List<SelectVO> allDate3 = new ArrayList<>();
        for(SelectVO a : adllDate){
            if(adllDate2.contains(a)){
                adllDate2.remove(a);
            }
        }
        List<SelectVO> adllDate3 = selectMapper.listCheckDate(bmId);

        SgPdZt sgPdZt = new SgPdZt();
        sgPdZt.setPdJhid(pdJhid);
//        System.out.println("已盘的"+listTemp);
//        SgPdZt sgPdZt4 = new SgPdZt();
        for (SelectVO sgPd :listTemp){
            sgPdZt.setBmName(sgPd.getBmName());
            sgPdZt.setEqBh(sgPd.getEqSbbh());
            sgPdZt.setEqName(sgPd.getEqName());
            sgPdZt.setPdZt("已盘");
            selectMapper.insertZt(sgPdZt);
        }
        System.out.println("2");

//        System.out.println("盘盈"+listTemp2);
        for (SelectVO sgPd :listTemp2){
            sgPdZt.setBmName(sgPd.getBmName());
            sgPdZt.setEqBh(sgPd.getEqSbbh());
            sgPdZt.setEqName(sgPd.getEqName());
            sgPdZt.setPdZt("盘盈");
            selectMapper.insertZt(sgPdZt);
        }

        System.out.println("3");


//        System.out.println("盘亏的"+adllDate2);
        for (SelectVO sgPd :adllDate2){
            sgPdZt.setBmName(sgPd.getBmName());
            sgPdZt.setEqBh(sgPd.getEqSbbh());
            sgPdZt.setEqName(sgPd.getEqName());
            sgPdZt.setPdZt("盘亏");
            selectMapper.insertZt(sgPdZt);
        }
        System.out.println("4");


//        System.out.println("盘点计划的"+adllDate3);
        for (SelectVO sgPd :adllDate3){
            if (allDate3.contains(adllDate2)||allDate3.contains(listTemp)){
                adllDate3.remove(adllDate2);
                allDate3.remove(listTemp);
                sgPdZt.setBmName(sgPd.getBmName());
                sgPdZt.setEqBh(sgPd.getEqSbbh());
                sgPdZt.setEqName(sgPd.getEqName());
                sgPdZt.setPdZt("正常");
                selectMapper.insertZt(sgPdZt);
            }
        }
        System.out.println("1");


    }
}

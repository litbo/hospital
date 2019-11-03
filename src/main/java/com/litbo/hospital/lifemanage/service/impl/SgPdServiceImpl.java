package com.litbo.hospital.lifemanage.service.impl;



import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.common.utils.DbUtil.IDFormat;
import com.litbo.hospital.lifemanage.bean.*;
import com.litbo.hospital.lifemanage.bean.vo.SgCheckVO;
import com.litbo.hospital.lifemanage.bean.vo.SgPdVO;
import com.litbo.hospital.lifemanage.check.mapper.PlanMapper;
import com.litbo.hospital.lifemanage.dao.SelectMapper;
import com.litbo.hospital.lifemanage.dao.SgCheckMapper;
import com.litbo.hospital.lifemanage.dao.SgPdMapper;
import com.litbo.hospital.lifemanage.dao.SgPlanMapper;
import com.litbo.hospital.lifemanage.service.SgPdSeverice;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
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
    @Autowired
    SgCheckMapper sgCheckMapper;

    @Autowired
    PlanMapper planMapper;
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
//        System.out.println(pdJhid+"盘点计划id");
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
//            System.out.println("成功");
            successCount++;
        }
        return successCount;
    }



    @Override
    public void insetStatus(String pdJhid, String bmId) {

        List<SelectVO> adllDate = new ArrayList<SelectVO>();  //所有数据
        String getAllBmName = selectMapper.getBmName(bmId); //对应planid下的部门
        List<SgPd> list = sgPdMapper.selectAllData(pdJhid); //查询所有插入的扫描到的编号
//        List<SelectVO> listVo = new ArrayList<>();
        SelectVO s1= new SelectVO();
        for (SgPd sgPd : list) {
            System.out.println(sgPd.getPdScanId());
            List<SelectVO> listVo=selectMapper.listAllDate(sgPd.getPdScanId());
            for (SelectVO selectVO :listVo){
                adllDate.add(selectVO);
            }
        }

        // 临时集合
        List<SelectVO> listTemp = new ArrayList<SelectVO>();
        List<SelectVO> listTemp2 = new ArrayList<SelectVO>();//盘亏集合
        for (int i = 0;i < adllDate.size(); i++) {
            // 保存不为空的元素
            if (adllDate.get(i) != null) {
                String asd = adllDate.get(i).getBmName();
                if (getAllBmName.equals(asd)){
                    listTemp.add(adllDate.get(i));
                }else {
                    listTemp2.add(adllDate.get(i));
                }
            }

        }
        adllDate = listTemp;
        List<SelectVO> adllDate2 = new ArrayList<>();
//                selectMapper.listCheckDate(bmId);
        String getAllBmName2 = selectMapper.getBmName(bmId); //对应planid下的部门
        List<SgCheckVO> adllDate4  =sgCheckMapper.getListByPlanId(pdJhid);
        for (SgCheckVO s2:adllDate4){
            SelectVO selectVO = new SelectVO(s2.getEqZcbh(),s2.getEqName(),getAllBmName2);
            adllDate2.add(selectVO);
        }


//        System.out.println("addate2"+adllDate2);
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
            sgPdZt.setEqSbbh(sgPd.getEqSbbh());
            sgPdZt.setEqName(sgPd.getEqName());
            sgPdZt.setPdZt("已盘");
            selectMapper.insertZt(sgPdZt);
        }
//        System.out.println("2");

//        System.out.println("盘盈"+listTemp2);
        for (SelectVO sgPd :listTemp2){
            sgPdZt.setBmName(sgPd.getBmName());
            sgPdZt.setEqSbbh(sgPd.getEqSbbh());
            sgPdZt.setEqName(sgPd.getEqName());
            sgPdZt.setPdZt("盘盈");
            selectMapper.insertZt(sgPdZt);
        }


//        List<SgPdZt> listPankui = selectMapper.findPankui(pdJhid,"");
//        System.out.println("盘亏+++"+listPankui.size()+listPankui);
//        List<SelectVO> lisSbbh = new ArrayList<>(); //现存盘亏的
//        for (SgPdZt sgPdZt1 :listPankui){
//            SelectVO selectVO = new SelectVO(sgPdZt1.getEqSbbh(),sgPdZt1.getEqName(),sgPdZt1.getBmName());
//            lisSbbh.add(selectVO);
//        }
//        System.out.println("插入的"+adllDate2.size()+adllDate2);
////        adllDate2.addAll(lisSbbh);
////        System.out.println("盘亏的jia"+adllDate2.size());
//
//
//        List<SelectVO> listAll = new ArrayList();
//        List<SelectVO> resultList= new ArrayList();
//        listAll.addAll(lisSbbh);
//        listAll.addAll(adllDate2);
//        for (int i = 0; i < listAll.size(); i++) {
//            if(adllDate2.contains(listAll.get(i))&&lisSbbh.contains(listAll.get(i))){
//                continue;
//            }else{
//                resultList.add(listAll.get(i));
//            }
//        }
//        System.out.println("更新后的"+resultList.size()+resultList);


        for (SelectVO sgPd :adllDate2){

            sgPdZt.setBmName(sgPd.getBmName());
            sgPdZt.setEqSbbh(sgPd.getEqSbbh());
            sgPdZt.setEqName(sgPd.getEqName());
            sgPdZt.setPdZt("盘亏");
            // int size = userList.size(); 此处一定不要在这里将size写死，因为size是一直在变的
            selectMapper.insertZt(sgPdZt);
        }


        ListNum listNum = selectMapper.getListNum(pdJhid);
        String fileStatus = "已上传";
        planMapper.updataOtherNum(listNum.getYiPanNum(),listNum.getPanYingNum(),listNum.getPanKuiNum(),fileStatus,pdJhid);
        System.out.println("已上传"+listNum.getYiPanNum()+listNum.getPanYingNum()+listNum.getPanKuiNum());


    }




    @Test
    public void test(){

        List<SelectVO> list1 = new ArrayList<>();
        list1.add(new SelectVO("aa","bb","cc"));
        list1.add(new SelectVO("aa1","bb1","cc1"));
        List<SelectVO> list2 = new ArrayList<>();
        list2.add(new SelectVO("aa","bb","cc"));
        list2.add(new SelectVO("22","22","22"));
        list2.add(new SelectVO("33","33","33"));


        List<SelectVO> listAll = new ArrayList();
        List<SelectVO> resultList= new ArrayList();
        listAll.addAll(list1);
        listAll.addAll(list2);
        for (int i = 0; i < listAll.size(); i++) {
            if(list1.contains(listAll.get(i))&&list2.contains(listAll.get(i))){
                continue;
            }else{
                resultList.add(listAll.get(i));
            }
        }
        System.out.println(resultList);
    }


}

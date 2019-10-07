package com.litbo.hospital.lifemanage.service.impl;

import cn.hutool.json.JSONObject;
import com.alibaba.druid.support.json.JSONUtils;
import com.litbo.hospital.common.utils.DbUtil.IDFormat;
import com.litbo.hospital.lifemanage.bean.SgPd;
import com.litbo.hospital.lifemanage.bean.SgPdJg;
import com.litbo.hospital.lifemanage.bean.SgPlan;
import com.litbo.hospital.lifemanage.bean.vo.SgPdVO;
import com.litbo.hospital.lifemanage.dao.SgPdMapper;
import com.litbo.hospital.lifemanage.dao.SgPlanMapper;
import com.litbo.hospital.lifemanage.service.SgPdSeverice;
import com.sun.org.apache.xerces.internal.xs.datatypes.ObjectList;
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

    /**
     * 插入盘点的计划id和操作人id
     * @param record
     * @return
     */
    @Override
    public int insertJhCz(SgPdVO record){

        SgPd sgPd = new SgPd();
        BeanUtils.copyProperties(record, sgPd);
        int successCount = 0;
        if((record.getPdJhid()!=null) && (record.getPdCzr()!=null)){
            sgPd.setPdId(IDFormat.getIdByIDAndTime("sg_pd", "pd_id"));
            sgPdMapper.insertPdId(sgPd);
            successCount++;
        }
        return successCount;
    }

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
    public String selectAllData(String pdJhid) {
        List<String> pdScanList = sgPdMapper.selectAllData(pdJhid);
        SgPlan sgPlan = sgPlanMapper.selectByPrimaryKey(pdJhid);
        if (sgPlan == null) {
            return null;
        }
        String bmId=sgPlan.getBmId();

        List<String> allNameList = sgPdMapper.selectNameByBmId(bmId);

        List<String> sbbhList = sgPdMapper.selectSbbhByBmId(bmId);
        List<String> zcbhList = sgPdMapper.selectZcbhByBmId(bmId);

        Map<String, List> result = new HashMap<>();
        //所有查出来的该是这个科室的设备名字
        List<String> isName=new ArrayList<>();
        List<String> bmPdZt=new ArrayList<>();
        
        for (String scanId : pdScanList) {
            if (sbbhList.contains(scanId)|| zcbhList.contains(scanId)) {
                String sb = sgPdMapper.selectSbbhById(scanId);
                String zc = sgPdMapper.selectZcbhById(scanId);
                if (ObjectUtils.allNotNull(sb)){
                    isName.add(sb);
                }else if(ObjectUtils.allNotNull(zc)){
                    isName.add(zc);
                }
            }
        }

        List<String> notExistName =new ArrayList<>();
        CollectionUtils.addAll(notExistName, new Object[allNameList.size()]);
        Collections.copy(notExistName, allNameList);
        notExistName.removeAll(isName);  //这个不删除

        SgPdJg sgPdJg=new SgPdJg();

        if((pdScanList.size()) > (allNameList.size())){
            bmPdZt.add("盘亏");
            sgPdJg.setPdWcsj(new Date());
            sgPdJg.setPdBmzt("-1");
            sgPdJg.setPdJgId(IDFormat.getIdByIDAndTime("sg_pd_jg", "pd_jgId"));
            sgPdMapper.insertPdZt(sgPdJg);
        }else if((pdScanList.size()) < (allNameList.size())){
            bmPdZt.add("盘赢");
            sgPdJg.setPdJgId(IDFormat.getIdByIDAndTime("sg_pd_jg", "pd_jgId"));
            sgPdJg.setPdWcsj(new Date());
            sgPdJg.setPdBmzt("1");
            sgPdMapper.insertPdZt(sgPdJg);
        }else if((pdScanList.size())==(allNameList.size())){
            bmPdZt.add("正常");
            sgPdJg.setPdJgId(IDFormat.getIdByIDAndTime("sg_pd_jg", "pd_jgId"));
            sgPdJg.setPdWcsj(new Date());
            sgPdJg.setPdBmzt("0");
            sgPdMapper.insertPdZt(sgPdJg);
        }

        //返回的PDA数据 该科室下所有的设备名字 盘点的是该科室设备的名称 是该科室的但是没有扫描的设备名称 该科室盘点状态
        result.put("pdScanList",pdScanList);
        result.put("allNameList",allNameList);
        result.put("isName",isName);
        result.put("notExistName",notExistName);
        result.put("bmPdZt",bmPdZt);


//        List<String> keylist =new ArrayList<>(result.keySet());
////        for(String key:keylist ){
////            System.out.println(key);
////        }
//
//        List<Object> valuesList = new ArrayList<Object>(result.values());
//        for(Object str:valuesList){
//            System.out.println(str);
//        }
//        System.out.println(valuesList.get(2));
//        valuesList.get(3);


        String msg=	JSONUtils.toJSONString(result);
        System.out.println(msg);
        System.out.println(msg.toString());

        return msg;
    }
}

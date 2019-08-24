package com.litbo.hospital.lifemanage.service.impl;

import com.litbo.hospital.common.utils.DbUtil.IDFormat;
import com.litbo.hospital.lifemanage.bean.SgPd;
import com.litbo.hospital.lifemanage.bean.SgPlan;
import com.litbo.hospital.lifemanage.bean.vo.SgPdVO;
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

    /**
     * 插入盘点扫描到的所有编号
     *
     * @param record
     */
    @Override
    public int insertPdId(SgPdVO record) {
        SgPd sgPd = new SgPd();
        BeanUtils.copyProperties(record, sgPd);
        int successCount = 0;
        for (String pdScanId : record.getPid()) {
            if (StringUtils.isBlank(pdScanId)) {
                continue;
            }
            String selectId = sgPdMapper.selectScanId(pdScanId);
            if (StringUtils.isNotBlank(selectId)) {
                continue;
            }
            sgPd.setPdId(IDFormat.getIdByIDAndTime("sg_pd", "pd_id"));
            sgPd.setPdScanId(pdScanId);
            sgPd.setPdScsj(new Date());
            sgPdMapper.insertPdId(sgPd);
            successCount++;
        }
        return successCount;
    }

    @Override
    public Map<String, List> selectAllData(String pdJhid) {
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
        notExistName.removeAll(isName);

        //返回的PDA数据 该科室下所有的设备名字 盘点的是该科室设备的名称 是该科室的但是没有扫描的设备名称
        result.put("pdScanList",pdScanList);
        result.put("allNameList",allNameList);
        result.put("isName",isName);
        result.put("notExistName",notExistName);

        return result;
    }
}

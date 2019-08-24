package com.litbo.hospital.lifemanage.service.impl;

import com.litbo.hospital.common.utils.DbUtil.IDFormat;
import com.litbo.hospital.lifemanage.bean.SgPd;
import com.litbo.hospital.lifemanage.bean.vo.SgPdVO;
import com.litbo.hospital.lifemanage.dao.SgPdMapper;
import com.litbo.hospital.lifemanage.service.SgPdSeverice;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SgPdServiceImpl implements SgPdSeverice {
    @Autowired
    private SgPdMapper sgPdMapper;

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
        List<String> jhList = sgPdMapper.selectAllData(pdJhid);
        // todo //调用计划表的方法 通过计划的id获取到这个计划下所有设备表里的设备编号和资产编号
        List<String> sbbhList = new ArrayList<>();
        List<String> zcbhList = new ArrayList<>();
        sbbhList.add("1");
        zcbhList.add("1");

        //设备编号 资产编号
        List<String> isSbbh = new ArrayList<>();
        List<String> isZcbh = new ArrayList<>();

        List<String> isNotExist = new ArrayList<>();
        for (String jh : jhList) {
            if (sbbhList.contains(jh)) {
                isSbbh.add(jh);
            } else if (zcbhList.contains(jh)) {
                isZcbh.add(jh);
            } else {
                isNotExist.add(jh);
            }
        }
        Map<String, List> result = new HashMap<>();
        result.put("isSbbh", isSbbh);
        result.put("isZcbh", isZcbh);
        result.put("isNotExist", isNotExist);
        return result;
    }
}

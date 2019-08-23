package com.litbo.hospital.lifemanage.service.impl.MyServiceImpl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.lifemanage.bean.Example.EqSbghExample;
import com.litbo.hospital.lifemanage.bean.vo.MyVO.EqSbghVO;
import com.litbo.hospital.lifemanage.bean.vo.MyVO.EqSbghZbVO;
import com.litbo.hospital.lifemanage.dao.MyMapper.EqSbghMapper;
import com.litbo.hospital.lifemanage.dao.MyMapper.EqTjsqMapper;
import com.litbo.hospital.lifemanage.service.MyService.EqSbghService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Transactional
@Service
public class EqSbghServiceimpl implements EqSbghService {
    @Autowired
    private EqSbghMapper mapper;
    @Autowired
    private EqTjsqMapper tjsqMapper;

    /*设备归还增加*/
    @Override
    public int insertEqSbgh(EqSbghVO sbgh) {
        sbgh.setId(UUID.randomUUID().toString());
        List<String> list = sbgh.getZbbmlist();
        sbgh.setEqCount(list.size());
        String s = JSON.toJSONString(list);
        sbgh.setEqZbbm(s);
        int i = mapper.insertEqSbgh(sbgh);
        if (i == 1) {
            if (sbgh.getEqDrurl() != null && sbgh.getEqDcurl() != null) {
                for (String s1 : list) {
                    tjsqMapper.updateEqInfoSfJc(s1, "0");
                }
            }
        }
        return i;
    }

    /*归还设备记录全部查询与条件查询*/
    @Override
    public PageInfo selectAllSbgh(Integer pageNum, Integer pageSize, String bmid, Date qssj,Date jssj) {
        //TODO 条件查询未定
        PageHelper.startPage(pageNum,pageSize);
        EqSbghExample example = new EqSbghExample();
        EqSbghExample.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotBlank(bmid)){
            criteria.andEqGhksEqualTo(bmid);
        }
        if(qssj!=null){
            criteria.andEqGhrqGreaterThanOrEqualTo(qssj);
        }
        if(jssj!=null){
            criteria.andEqGhrqLessThanOrEqualTo(jssj);
        }
        return new PageInfo(mapper.selectAllSbgh(example));
    }

    @Override
    public EqSbghVO selectOneSbghByPrimaryKey(String id) {
        EqSbghVO vo = mapper.selectOneSbghByPrimaryKey(id);
        JSONArray array = JSONArray.parseArray(vo.getEqZbbm());
        List<EqSbghZbVO> list1 = new ArrayList<>();
        int size = array.size();
        for (int i = 0; i < size; i++) {
            EqSbghZbVO zbVO = mapper.selectEq2ByBianhao((String) array.get(i));
            list1.add(zbVO);
        }
        vo.setList(list1);
        return vo;
    }

    /*根据设备编号查询设备调剂交接Id,所属科室和借出科室*/
    @Override
    public EqSbghZbVO selectEq2ByBianhao(String sbbh) {
        return mapper.selectEq2ByBianhao(sbbh);
    }

    /*暂时不用*/
    /*根据调剂交接id查询已经归还的设备编号*/
    @Override
    public PageInfo selectAllSbgh(Integer pageNum, Integer pageSize,String dpjjid) {
        PageHelper.startPage(pageNum,pageSize);
        List<String> list = mapper.selectAllSbgh2(dpjjid);
        return new PageInfo(list);
    }

    /*(选择项)根据装备编号查询调出科室和调入科室再查询调剂交接表中要还装备*/
    @Override
    public PageInfo selectElseZb(Integer pageNum, Integer pageSize, String drks, String dcks) {
        PageHelper.startPage(pageNum,pageSize);
        List<EqSbghZbVO> vos = new ArrayList<>();
        /*获取所有要还装备编号*/
        List<String> list = mapper.selectElseZb(drks, dcks);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            String s = list.get(i);
            JSONArray array = JSONArray.parseArray(s);
            for (Object o : array) {
                EqSbghZbVO vo = mapper.selectEq2ByBianhao((String)o);
                vos.add(vo);
            }

        }
        return new PageInfo(vos);
    }

    /*根据主键修改设备归还记录*/
    @Override
    public int updateEqsbghByPrimaryKey(EqSbghVO vo) {
        List<String> list = vo.getZbbmlist();
        String s = JSON.toJSONString(list);
        vo.setEqZbbm(s);
        EqSbghVO oldsbgh = mapper.selectOneSbghByPrimaryKey(vo.getId());
        BeanUtil.copyProperties(vo, oldsbgh, true,
                CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));
        int i = mapper.updateSbghByPrimaryKey(oldsbgh);
        if (i == 1) {
            if (vo.getEqDrurl() != null && vo.getEqDcurl() != null) {
                for (String s1 : list) {
                    tjsqMapper.updateEqInfoSfJc(s1, "0");
                }
            }
        }
        return i;
    }
}

package com.litbo.hospital.lifemanage.service.impl.MyServiceImpl;


import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.common.utils.DbUtil.IDFormat;
import com.litbo.hospital.lifemanage.MyUtils.DelSpaceUtils;
import com.litbo.hospital.lifemanage.bean.Example.EqLpjhtExample;
import com.litbo.hospital.lifemanage.bean.MyBean.EqLpjht;
import com.litbo.hospital.lifemanage.bean.vo.MyVO.EqLpjHtShowVO;
import com.litbo.hospital.lifemanage.bean.vo.MyVO.EqLpjHtZbVO;
import com.litbo.hospital.lifemanage.bean.vo.MyVO.SbCsVO;
import com.litbo.hospital.lifemanage.dao.MyMapper.EqHtMapper;
import com.litbo.hospital.lifemanage.dao.MyMapper.EqLpjhtMapper;
import com.litbo.hospital.lifemanage.service.MyService.EqLpjService;
import com.litbo.hospital.user.dao.EqDao;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class EqLpjServiceimpl implements EqLpjService {

    @Autowired
    private EqLpjhtMapper mapper;
    @Autowired
    private EqHtMapper htmapper;
    @Autowired
    private EqDao eqDao;

    @Override
    public int deleteByPrimaryKey(String id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int addLpjHt(EqLpjht lpjht) {
        String id = IDFormat.getIdByIDAndTime("eq_lpjht", "id");
        String jhtid = IDFormat.getIdByIDAndTime("eq_lpjht", "ht_jhtid") + id.substring(8);
        lpjht.setId(id);
        lpjht.setHtJhtid(jhtid);
        return mapper.insert(lpjht);
    }

    @Override
    public PageInfo selectAll(Integer pageNum,
                              Integer pageSize,
                              EqLpjHtShowVO showVO) {
        PageHelper.startPage(pageNum, pageSize);
        EqLpjhtExample example = new EqLpjhtExample();
        EqLpjhtExample.Criteria criteria = example.createCriteria();
        String sbbh = DelSpaceUtils.deleteSpace(showVO.getHtSbbh());
        String sbmc = DelSpaceUtils.deleteSpace(showVO.getHtSbmc());
        String htyf = DelSpaceUtils.deleteSpace(showVO.getHtYf());

        if (StringUtils.isNotBlank(sbbh)) {
            criteria.andHtSbbhLike("%" + sbbh + "%");
        }
        if (StringUtils.isNotBlank(sbmc)) {
            criteria.andHtSbmcLike("%" + sbmc + "%");
        }
       /* if (StringUtils.isNotBlank(htyf)) {
            criteria.andHtYfLike("%" + htyf + "%");
        }*/
        if (showVO.getHtQssj() != null) {
            criteria.andHtYfrqGreaterThanOrEqualTo(showVO.getHtQssj());
        }
        if (showVO.getHtJssj() != null) {
            criteria.andHtYfrqLessThanOrEqualTo(showVO.getHtJssj());
        }
        List<EqLpjHtShowVO> showVOS = mapper.selectByExample(example);
        int size = showVOS.size();
        for (int k = 0; k < size; k++) {
            showVOS.get(k).setHtYfName(htmapper.selectCsNameById(showVOS.get(k).getHtYf()));
           /* EqLpjHtShowVO vo = showVOS.get(k);
            String name = mapper.selectEqnameByHtBianhao(vo.getHtSbbh());
            vo.setHtSbmc(name);*/
            if(StringUtils.isNotBlank(htyf)){
               if(!showVOS.get(k).getHtYfName().contains(htyf)){
                   showVOS.remove(k);
                   k--;
                   size=showVOS.size();
               }
            }

        }

        return new PageInfo(showVOS);
    }




    @Override
    public int updateByPrimaryKey(EqLpjht ht) {
        EqLpjht oldHt = mapper.selectByPrimaryKey(ht.getId());
        BeanUtil.copyProperties(ht, oldHt, true,
                CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));

        return mapper.updateByPrimaryKey(oldHt);
    }

    @Override
    public int updateByJhtId(String htJhtid, String htZt) {

        return mapper.updateByJhtId(htJhtid, htZt);

    }

    @Override
    public int addWxCs(SbCsVO vo) {
        vo.setSbCslbId(UUID.randomUUID().toString());
        vo.setSbCslbId("1");
        return mapper.addWxCs(vo);
    }

    @Override
    public EqLpjht selectLpjHtByPrimaryKey(String id) {
        EqLpjht lpjht = mapper.selectLpjHtByPrimaryKey(id);
        lpjht.setHtYfName(htmapper.selectCsNameById(lpjht.getHtYf()));
        List<EqLpjHtZbVO> list=new ArrayList<>();
        JSONArray array = JSONArray.parseArray(lpjht.getHtLpjhz());
        int size = array.size();
        for (int i = 0; i < size; i++) {
            list.add(array.getObject(i,EqLpjHtZbVO.class));
        }
        lpjht.setListLpj(list);
        return lpjht;
    }
}

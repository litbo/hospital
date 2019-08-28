package com.litbo.hospital.lifemanage.service.impl.MyServiceImpl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.lifemanage.bean.Example.EqTjjjExample;
import com.litbo.hospital.lifemanage.bean.vo.MyVO.EqSbghZbVO;
import com.litbo.hospital.lifemanage.bean.vo.MyVO.EqTjjjShowVO;
import com.litbo.hospital.lifemanage.bean.vo.MyVO.EqTjjjVO;
import com.litbo.hospital.lifemanage.dao.MyMapper.EqHtMapper;
import com.litbo.hospital.lifemanage.dao.MyMapper.EqSbghMapper;
import com.litbo.hospital.lifemanage.dao.MyMapper.TjjjMapper;
import com.litbo.hospital.lifemanage.service.MyService.EqTjjjService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class EqTjjjServiceimpl implements EqTjjjService {
    @Autowired
    private TjjjMapper mapper;
    @Autowired
    private EqHtMapper htMapper;
    @Autowired
    private EqSbghMapper sbghMapper;

    @Override
    public int insertTjjj(EqTjjjVO tjjj) {
        tjjj.setId(UUID.randomUUID().toString());
        tjjj.setTjjjBianma(JSON.toJSONString(tjjj.getListbianma()));
        return mapper.insertTjjj(tjjj);
    }

    @Override
    public PageInfo selectByExample(Integer pageNum, Integer pageSize, EqTjjjShowVO vo) {
        PageHelper.startPage(pageNum, pageSize);
        EqTjjjExample example = new EqTjjjExample();
        EqTjjjExample.Criteria criteria = example.createCriteria();
        Date qssj = vo.getTjjjQssj();
        Date jssj = vo.getTjjjJssj();
        if (qssj != null) {
            criteria.andTjjjTpsjGreaterThanOrEqualTo(qssj);
        }
        if (jssj != null) {
            criteria.andTjjjTpsjLessThanOrEqualTo(jssj);
        }
        List<EqTjjjShowVO> vos = mapper.selectByExample(example);

        return new PageInfo(vos);
    }

    @Override
    public EqTjjjVO selectByPrimaryKey(String id) {

        EqTjjjVO vo = mapper.selectByPrimaryKey(id);
        /*获取编码集合*/
        String s = vo.getTjjjBianma();
        JSONArray array = JSONArray.parseArray(s);
        int size = array.size();
        /*利用编码查询规格型号等属性*/
        List<EqSbghZbVO> vos = new ArrayList<>();
        /*查询改调剂交接单号已经归还的设备编号*/
        List<String> list = sbghMapper.selectAllSbgh2(id);


        for (int i = 0; i < size; i++) {
            EqSbghZbVO zbVO = sbghMapper.selectEq2ByBianhao((String) array.get(i));
            List<String> strings = new ArrayList<>();
            /*如果已经归还状态变为1为已经归还*/
            for (String str : list) {
                strings=JSONArray.parseArray(str,String.class);
                if(strings.contains((String)array.get(i))){
                    zbVO.setSfgh(1);
                }
            }

            vos.add(zbVO);
        }
        vo.setListsbgh(vos);

        return vo;
    }

}

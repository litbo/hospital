package com.litbo.hospital.lifemanage.service.impl.MyServiceImpl;


import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.common.utils.DbUtil.IDFormat;
import com.litbo.hospital.lifemanage.MyUtils.DelSpaceUtils;
import com.litbo.hospital.lifemanage.bean.Example.EqHtExample;
import com.litbo.hospital.lifemanage.bean.MyBean.EqHt;
import com.litbo.hospital.lifemanage.bean.vo.MyVO.EqHtShowVO;
import com.litbo.hospital.lifemanage.bean.vo.MyVO.EqHtZbVO;
import com.litbo.hospital.lifemanage.bean.vo.MyVO.LoginCheckHtStatusVO;
import com.litbo.hospital.lifemanage.bean.vo.MyVO.SbCsVO;
import com.litbo.hospital.lifemanage.dao.MyMapper.EqHtMapper;
import com.litbo.hospital.lifemanage.dao.SgDhdjMapper;
import com.litbo.hospital.lifemanage.service.MyService.EqHtService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Transactional
@Service
public class EqHtServiceImpl implements EqHtService {
    @Autowired
    private EqHtMapper mapper;
    @Autowired
    private SgDhdjMapper dhdjmapper;

    @Override
    public Integer InsertHt(EqHt ht) {
        String id = IDFormat.getIdByIDAndTime("eq_ht", "id");
        ht.setId(id);
        int i = mapper.insert(ht);
        return i;
    }

    @Override
    public PageInfo<EqHtShowVO> ListHtAccount(Integer pageNum, Integer pageSize, EqHtShowVO showVO) {

        PageHelper.startPage(pageNum, pageSize);
        String bianhao = DelSpaceUtils.deleteSpace(showVO.getHtBianhao());
        String zbmc = DelSpaceUtils.deleteSpace(showVO.getHtZbmc());
        String htzt = DelSpaceUtils.deleteSpace(showVO.getHtZt());
        String yf = DelSpaceUtils.deleteSpace(showVO.getHtYf());
        EqHtExample example = new EqHtExample();
        EqHtExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(zbmc)) {
            criteria.andHtZbhzLike("%" + zbmc + "%");
        }

        if (StringUtils.isNotBlank(bianhao)) {

            criteria.andHtBianhaoLike("%" + bianhao + "%");
        }
        if (StringUtils.isNotBlank(htzt)) {
            criteria.andHtZtEqualTo(htzt);
        }

    /*    if (StringUtils.isNotBlank(yf)) {
            criteria.andHtYfLike("%" + yf + "%");
        }*/

        if (showVO.getHtQssj() != null) {
            criteria.andHtYfrqGreaterThanOrEqualTo(showVO.getHtQssj());
        }
        if (showVO.getHtJssj() != null) {
            criteria.andHtYfrqLessThanOrEqualTo(showVO.getHtJssj());
        }

        List<EqHtShowVO> showVOS = mapper.selectByExample(example);
        int size = showVOS.size();
        for (int k = 0; k < size; k++) {

            EqHtShowVO vo = showVOS.get(k);
            String json = showVOS.get(k).getHtZbHz();
            JSONArray array = JSONArray.parseArray(json);
            showVOS.get(k).setHtYfName(mapper.selectCsNameById(showVOS.get(k).getHtYf()));
            if(StringUtils.isNotBlank(yf)){
                if (!showVOS.get(k).getHtYfName().contains(yf)) {
                    showVOS.remove(k);
                    k--;
                    size=showVOS.size();
                }
            }

            /*for (int i = 0; i < array.size(); i++) {
                EqHtShowVO showVo = new EqHtShowVO();
                JSONObject object = array.getJSONObject(i);
                if(i==0){
                    vo.setHtZbmc((String) object.get("htZbmc"));
                    vo.setHtCount((Integer) object.get("htCount"));
                    vo.setHtDanjia(new BigDecimal(String.valueOf(object.get("htDanjia"))));
                    vo.setHtGgxh((String)object.get("htGgxh"));
                }

                else{
                    BeanUtils.copyProperties(showVOS.get(k),showVO);
                    showVo.setHtZbmc((String) object.get("htZbmc"));
                    showVo.setHtCount((Integer) object.get("htCount"));
                    showVo.setHtDanjia(new BigDecimal(String.valueOf(object.get("htDanjia"))));
                    showVo.setHtGgxh((String)object.get("htGgxh"));
                    showVOS.add(k+1,showVO);
                    k++;
                }

            }*/
            String str = "";
            int size1 = array.size();
            for (int i = 0; i < size1; i++) {
                JSONObject object = array.getJSONObject(i);
                String htZbmc = (String) object.get("htZbmc");

                if (i == 0) {
                    str = str + htZbmc;
                } else {
                    str = str + "," + htZbmc;
                }


            }
            vo.setHtZbmc(str);
//            vo.setHtZbHz(null);

        }
        return new PageInfo<>(showVOS);
    }

    @Override
    public String selectZbHz(String id) {

        return mapper.selectHtZbHzById(id);
    }

    @Override
    public EqHt selectHtByPrimaryKey(String id) {
        EqHt ht = mapper.selectByPrimaryId(id);
        ht.setHtYfName(selectCsNameById(ht.getHtYf()));
        String s = ht.getHtZbhz();
        JSONArray array = JSONArray.parseArray(s);
        List<EqHtZbVO> list = new ArrayList<>();
        int size = array.size();
        for (int i = 0; i < size; i++) {
            list.add(array.getObject(i, EqHtZbVO.class));
        }
        ht.setListZb(list);
        return ht;
    }

    @Override
    public EqHt selectHtByHtId(String htid) {
        return mapper.selectByHtId(htid);
    }


    @Override
    public List<String> selectHtIds() {
        return mapper.selectHtIds();
    }

    @Override
    public int deleteHtByPrimaryKey(String id) {
        String htid = mapper.selectByPrimaryId(id).getHtBianhao();
        dhdjmapper.deleteYsByHtid(htid);
        dhdjmapper.deleteDjhwByHtid(htid);
        dhdjmapper.deleteDjhwJlByHtid(htid);
        dhdjmapper.deleteDhdjJlByHtid(htid);
        dhdjmapper.deleteDhdjByHtid(htid);
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public Integer updateByPrimaryId(EqHt ht) {
        List<EqHtZbVO> zb = ht.getListZb();
        JSONArray objects = JSONArray.parseArray(JSON.toJSONString(zb));
        EqHt oldHt = mapper.selectByPrimaryId(ht.getId());
        BeanUtil.copyProperties(ht, oldHt, true,
                CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));
        oldHt.setHtZbhz(objects.toJSONString());
        return mapper.updateByPrimaryId(oldHt);
    }

    @Override
    public Integer updateByHtBianhao(String htBianhao, String htZt) {
        return mapper.updateByHtBianhao(htBianhao, htZt);

    }

    @Override
    public Integer addSbCs(SbCsVO vo) {
        vo.setSbcsId(UUID.randomUUID().toString());
        vo.setSbCslbId("1");
        return mapper.addSbCs(vo);
    }

    /*修改合同状态为已完成*/
    @Override
    public void loginCheckHtStatus() {
        List<LoginCheckHtStatusVO> vos = mapper.loginCheckHtStatus();
        for (int i = 0; i < vos.size(); i++) {
            String s = mapper.selectHtZbHzById(vos.get(i).getHtId());
            JSONArray array = JSONArray.parseArray(s);
            if (array.size() == vos.get(i).getCount()) {
                EqHt eqHt = mapper.selectByPrimaryId(vos.get(i).getHtId());
                Calendar cal = Calendar.getInstance();
                cal.setTime(vos.get(i).getDate());
                cal.add(Calendar.MONTH, eqHt.getHtBxq());
                long lasttime = cal.getTime().getTime();
                if (new Date().getTime() - lasttime >= 0) {
                    EqHt ht = mapper.selectByPrimaryId(vos.get(i).getHtId());
                    if (!"2".equals(ht.getHtZt())) {
                        ht.setHtZt("2");
                        updateByPrimaryId(ht);
                    }

                }
            }
        }


    }

    @Override
    public String selectCsNameById(String id) {
        return mapper.selectCsNameById(id);

    }


}

package com.litbo.hospital.lifemanage.service.impl.MyServiceImpl;


import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.common.utils.DbUtil.IDFormat;
import com.litbo.hospital.common.utils.UploadFile;
import com.litbo.hospital.lifemanage.MyUtils.DelSpaceUtils;
import com.litbo.hospital.lifemanage.bean.Example.EqTjsqExample;
import com.litbo.hospital.lifemanage.bean.vo.MyVO.*;
import com.litbo.hospital.lifemanage.dao.MyMapper.EqTjsqMapper;
import com.litbo.hospital.lifemanage.service.MyService.EqTjService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class EqTjServiceImpl implements EqTjService {

    @Autowired
    private EqTjsqMapper mapper;


    /*条件查或者查询全部*/
    @Override
    public PageInfo selectByExample(Integer pageNum,
                                    Integer pageSize,
                                    EqTjShowVO showVO) {
        PageHelper.startPage(pageNum, pageSize);
        List<EqTjShowVO> list = new ArrayList<>();
        EqTjsqExample example = new EqTjsqExample();
        EqTjsqExample.Criteria criteria = example.createCriteria();
        String bmname = DelSpaceUtils.deleteSpace(showVO.getBmName());
        String sfyl = DelSpaceUtils.deleteSpace(showVO.getTjSfyl());
        String sfqbsl = DelSpaceUtils.deleteSpace(showVO.getTjSfqbsl());
        String sqlx = DelSpaceUtils.deleteSpace(showVO.getTjSqlx());
        criteria.andTjSqlxLike(sqlx);
        if (StringUtils.isNotBlank(bmname)) {
            criteria.andBmNameLike(bmname);
        }
        if (StringUtils.isNotBlank(sfyl)) {
            criteria.andTjSfylLike(sfyl);
        }
        if (StringUtils.isNotBlank(sfqbsl)) {
            criteria.andTjSfqbslLike(sfqbsl);
        }
        if (showVO.getTjQssj() != null) {
            criteria.andTjSqsjGreaterThanOrEqualTo(showVO.getTjQssj());
        }
        if (showVO.getTjJssj() != null) {
            criteria.andTjSqsjLessThanOrEqualTo(showVO.getTjJssj());
        }

        List<EqTjShowVO> vos = mapper.selectByExample(example);
       /* for (int i = 0; i < vos.size(); i++) {
            String str = vos.get(i).getTjZbmc();
            JSONArray array = JSONArray.parseArray(str);
            for (int k = 0; k < array.size(); k++) {
                JSONObject o = array.getJSONObject(k);
                if (StringUtils.isNotBlank(showVO.getTjZbmc())) {
                    if (((String) o.get("name")).contains(showVO.getTjZbmc()) || showVO.getTjZbmc().contains((String) o.get("name"))) {
                        EqTjShowVO vo = new EqTjShowVO();
                        BeanUtil.copyProperties(vos.get(i), vo);
                        *//*申请数量为0的不查*//*
                        Integer count = (Integer) o.get("count");
                            vo.setSbsl(count);
                            vo.setTjZbmc((String) o.get("name"));
                            list.add(vo);
                    }

                } else {
                    EqTjShowVO vo = new EqTjShowVO();
                    BeanUtil.copyProperties(vos.get(i), vo);
                    vo.setSbsl((Integer) o.get("count"));
                    vo.setTjZbmc((String) o.get("name"));
                    list.add(vo);
                }

            }
        }*/
        return new PageInfo(vos);
    }

    @Override
    public PageInfo selectByBenBmExample(Integer pageNum, Integer pageSize, EqTjShowVO showVO) {
        PageHelper.startPage(pageNum, pageSize);
        List<EqTjShowVO> list = new ArrayList<>();
        EqTjsqExample example = new EqTjsqExample();
        EqTjsqExample.Criteria criteria = example.createCriteria();
        String bmname = DelSpaceUtils.deleteSpace(showVO.getBmName());

        if (showVO.getTjQssj() != null) {
            criteria.andTjSqsjGreaterThanOrEqualTo(showVO.getTjQssj());
        }
        if (showVO.getTjJssj() != null) {
            criteria.andTjSqsjLessThanOrEqualTo(showVO.getTjJssj());
        }
//        criteria.andBmNameLike(bmname);

        List<EqTjShowVO> vos = mapper.selectByExample(example);
        for (int i = 0; i < vos.size(); i++) {
            String str = vos.get(i).getTjZbmc();
            JSONArray array = JSONArray.parseArray(str);
            for (int k = 0; k < array.size(); k++) {
                JSONObject o = array.getJSONObject(k);
                if (StringUtils.isNotBlank(showVO.getTjZbmc())) {
                    if (((String) o.get("name")).contains(showVO.getTjZbmc()) || showVO.getTjZbmc().contains((String) o.get("name"))) {
                        EqTjShowVO vo = new EqTjShowVO();
                        BeanUtil.copyProperties(vos.get(i), vo);
                        vo.setSbsl((Integer) o.get("count"));
                        vo.setTjZbmc((String) o.get("name"));
                        list.add(vo);
                    }

                } else {
                    EqTjShowVO vo = new EqTjShowVO();
                    BeanUtil.copyProperties(vos.get(i), vo);
                    vo.setSbsl((Integer) o.get("count"));
                    vo.setTjZbmc((String) o.get("name"));
                    list.add(vo);
                }

            }
        }
        return new PageInfo(list);

    }

    /*主键查看详情*/
    @Override
    public EqTjsqVO selectByPrimaryKey(String id) {
       /* EqTjsqVO vo = mapper.selectSqJlByKey(id);
        String s = vo.getTjZbmc();
        JSONArray array = JSONArray.parseArray(s);
        int size = array.size();
        List<TjZbMcNameCount> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            TjZbMcNameCount count = array.getObject(i, TjZbMcNameCount.class);
            list.add(count);
        }
        vo.setZbmclist(list);
        return list;*/
        EqTjsqVO vo = mapper.selectSqJlByKey(id);
        return vo;
    }

    /*增加调剂申请*/
    @Override
    public int insertTjDrSq(EqTjsqVO sq) {
        List<TjZbMcNameCount> list = sq.getZbmclist();
        String s = JSON.toJSONString(list);
        sq.setTjZbmc(s);
        sq.setId(IDFormat.getIdByIDAndTime("eq_tjsq", "id"));
        return mapper.insertTjDrSq(sq);
    }

    /*查询所在科室设备**/
    @Override
    public PageInfo ListEqInfo(Integer pageNum, Integer pageSize, String bmId) {
        PageHelper.startPage(pageNum, pageSize);
        List<Map<String, String>> list = mapper.ListEqInfo(bmId);
        return new PageInfo(list);
    }

    /*删除*/
    @Override
    public int deleteByPrimaryKey(String id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteZbDcById(String id) {

        EqTjZbdcVO eqTjZbdcVO = mapper.selectByPrimaryKey(id);
        String zbbm=eqTjZbdcVO.getTjZbbm();
        JSONArray zbbms = JSONArray.parseArray(zbbm);
        String sqzbbms = eqTjZbdcVO.getTjSqzbbms();
        JSONArray jsonArray = JSONArray.parseArray(sqzbbms);
        String sqcounts = eqTjZbdcVO.getTjSqzbcounts();
        JSONArray jsonArray2 = JSONArray.parseArray(sqcounts);
        int size = jsonArray.size();
        EqTjsqVO tjsqVO = mapper.selectSqJlByKey(eqTjZbdcVO.getTjSqtj());
        String tjZbmc = tjsqVO.getTjZbmc();
        JSONArray array = JSONArray.parseArray(tjZbmc);
        List<TjZbMcNameCount> list = array.toJavaList(TjZbMcNameCount.class);
        int size2 = list.size();
        for (int i = 0; i < size2; i++) {
            for (int k = 0; k < size; k++) {
                  if(list.get(i).getSbbh().equals(jsonArray.get(k))){
                      TjZbMcNameCount tjZb= list.get(i);
                      tjZb.setYslcount(tjZb.getYslcount()-(int)jsonArray2.get(k));
                      System.out.println("");
                  }
            }
        }
        mapper.updateSqZbBykey(eqTjZbdcVO.getTjSqtj(), JSON.toJSONString(list));
        for (Object o : zbbms) {
            mapper.updateEqInfoSfJc((String)o, "0");
        }

        tjsqVO.setTjSfqbsl("0");
        updateByPrimaryKey(tjsqVO);

        return mapper.deleteZbDcById(id);
    }

    /*修改调剂申请*/
    @Override
    public int updateByPrimaryKey(EqTjsqVO tj) {
        EqTjsqVO old = mapper.selectSqJlByKey(tj.getId());
        BeanUtil.copyProperties(tj, old, true,
                CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));

        return mapper.updateByPrimaryKey(old);
    }

    /*修改装备调出*/
    @Override
    public int updateZbdcByPrimaryKey(EqTjZbdcVO vo) {
        EqTjZbdcVO old = mapper.selectByPrimaryKey(vo.getId());
        BeanUtil.copyProperties(vo, old, true,
                CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));

        return mapper.updateZbdcByprimaryKey(old);
    }

    /*根据设备名称和部门名称模糊查询可调剂设备*/
    //TODO 已经加入院区和部门的条件查询
    @Override
    public PageInfo selectAllEqInfo(String sbName, String bmname, String yq) {
        List<EqInfoShowVO> vos = mapper.selectAllEqInfo(sbName, bmname, yq);

        return new PageInfo(vos);
    }

    /*
     * 需要提供调剂申请id，调出装备科室Id,申请调剂装备名称
     * */
    /*录入或者修改调出设备部门信息*/

    @Override
    public int insertTjZbdc(List<EqTjZbdcVO> listzbdc) {
      /*  List<EqTjZbdcVO> vos = mapper.selectTjZbdcThree();
        List<String> sqtjlist = vos.stream().map(EqTjZbdcVO::getTjSqtj)
                .collect(Collectors.toList());
        List<String> dckslist = vos.stream().map(EqTjZbdcVO::getTjDcks)
                .collect(Collectors.toList());*/
        EqTjZbdcVO vo1 = listzbdc.get(0);
        String tjsqzbbm = vo1.getTjSqzbbms();
        int size = listzbdc.size();
        for (int k = 0; k < size; k++) {
            EqTjZbdcVO zbdcVO = listzbdc.get(k);
            zbdcVO.setTjGgxh(zbdcVO.getTjGg() + " / " + zbdcVO.getTjXh());
            boolean add = true;
            if (zbdcVO != null
                    && StringUtils.isNotBlank(zbdcVO.getTjDcks())
                    && StringUtils.isNotBlank(zbdcVO.getTjSqtj())) {
                /*判断是否在同一科室的同一张调剂单且调配单未送达借东西(不同指挥长不同调剂单)*/
                EqTjZbdcVO vo = mapper.selectTjjd(zbdcVO.getTjDcks(), zbdcVO.getTjSqtj(), zbdcVO.getTjZhz());
                if (vo != null && StringUtils.isNotBlank(vo.getId())) {
                    add = false;
                    /*修改*/
                    String zbbm = vo.getTjZbbm();
                    String ggxh = vo.getTjGgxh();
                    String sqzbbm = vo.getTjSqzbbms();
                    String sqcount=vo.getTjSqzbcounts();
                    JSONArray sqcounts = JSONArray.parseArray(sqcount);
                    ggxh = ggxh.replaceAll("null", "");
                    JSONArray bmarray = JSONArray.parseArray(zbbm);
                    if (StringUtils.isNotBlank(zbdcVO.getTjZbbm())) {

                        bmarray.add(zbdcVO.getTjZbbm());
                        mapper.updateEqInfoSfJc(zbdcVO.getTjZbbm(), "1");
                    }

                    JSONArray xharray = JSONArray.parseArray(ggxh);

                    if (StringUtils.isNotBlank(zbdcVO.getTjGgxh())) {
                        xharray.add(zbdcVO.getTjGgxh());
                    }

                    JSONArray sqzbbms = JSONArray.parseArray(sqzbbm);
                    if (StringUtils.isNotBlank(zbdcVO.getTjSqzbbms())) {
                        int s=sqzbbms.size();
                        for (int i = 0; i < s; i++) {
                            if(!zbdcVO.getTjSqzbbms().equals(sqzbbms.get(i))){
                                sqcounts.add(listzbdc.size());
                            }
                            else{
                                if(sqcounts.size()==0){
                                    sqcounts.add(listzbdc.size());
                                }
                                else {
                                    sqcounts.set(i,(int)sqcounts.get(i)+1);
                                }
                            }
                        }
                        if (!sqzbbms.contains(zbdcVO.getTjSqzbbms())) {
                            sqzbbms.add(zbdcVO.getTjSqzbbms());

                        }
                    }


                    int i = mapper.updateDcZb(vo.getId(), bmarray.toString(), xharray.toString(), sqzbbms.toString(), sqcounts.toString(), new Date());
//                    if (i == 1) {
//                        EqTjsqVO key = mapper.selectSqJlByKey(zbdcVO.getTjSqtj());
//                        String s = key.getTjZbmc();
//                        JSONArray array = JSONArray.parseArray(s);
//                        for (int j = 0; j < array.size(); j++) {
//                            TjZbMcNameCount zbmc = array.getObject(i, TjZbMcNameCount.class);
//                        }
////                        array.remove(zbdcVO.getZbName());
//                        /*需要调剂id,调配数量,待调剂装备名称*/
////                        updateSqZbBykey(key.getId(), zbdcVO.getTjTpsl(), zbdcVO.getZbName());
//
//                    }

                    updateZbCount(vo.getId());

                }
            }

            if (add) {
                /*增加*/
                String id = IDFormat.getIdByIDAndTime("tj_zbdc", "id");
                zbdcVO.setId(id);
                zbdcVO.setTjDcjd("0");
                /*接受的装备编号和设备规格为两个数组*/
                JSONArray array = new JSONArray();
                JSONArray array2 = new JSONArray();
                String zbbm = zbdcVO.getTjZbbm();
                String ggxh = zbdcVO.getTjGgxh();
                ggxh = ggxh.replaceAll("null", "");
                if (StringUtils.isNotBlank(zbbm)) {
                    array.add(zbbm);
                    zbdcVO.setTjZbbm(array.toString());
                } else {
                    zbdcVO.setTjZbbm("[]");
                }
                if (StringUtils.isNotBlank(ggxh)) {
                    array2.add(ggxh);
                    zbdcVO.setTjGgxh(array2.toString());
                } else {
                    zbdcVO.setTjGgxh("[]");
                }

                for (int i = 0; i < array.size(); i++) {
                    mapper.updateEqInfoSfJc(array.get(i).toString(), "1");
                }
                zbdcVO.setTjDpsj(new Date());

                /*对传入的调剂装备处理*/
                String sqzbbms = zbdcVO.getTjSqzbbms();
                JSONArray jsonArray = new JSONArray();
                jsonArray.add(sqzbbms);
                zbdcVO.setTjSqzbbms(jsonArray.toString());

                /*对传入的调剂装备数量处理*/
                JSONArray sqcounts = JSONArray.parseArray("[]");
                sqcounts.add(listzbdc.size());
                zbdcVO.setTjSqzbcounts(sqcounts.toString());
                int i = mapper.insertTjZbdc(zbdcVO);

                if (i == 1) {
                    updateZbCount(id);
                }

//                updateSqZbBykey(zbdcVO.getTjSqtj(), zbdcVO.getTjTpsl(), zbdcVO.getZbName());

            }


        }

        EqTjZbdcVO vo = listzbdc.get(0);
        String s = vo.getTjSqtj();
        EqTjsqVO tjsqVO = mapper.selectSqJlByKey(s);
        String tjZbmc = tjsqVO.getTjZbmc();
        JSONArray array = JSONArray.parseArray(tjZbmc);
        List<TjZbMcNameCount> list = array.toJavaList(TjZbMcNameCount.class);
        for (TjZbMcNameCount count : list) {
            if (tjsqzbbm.equals(count.getSbbh())) {
                count.setYslcount(count.getYslcount() + size);
            }
        }

        boolean qbcl=false;
        for (TjZbMcNameCount count : list) {
            if(count.getCount()==count.getYslcount())
            {
                qbcl=true;
            }
            else {
                qbcl=false;
            }
        }

        if(qbcl){
            tjsqVO.setTjSfqbsl("1");
           updateByPrimaryKey(tjsqVO);
        }

        mapper.updateSqZbBykey(s, JSON.toJSONString(list));

        return 1;
    }

    /*删除调出装备后调剂申请也改变,参数为现在的数据和装备调出单位id*/

    /*
     * 方法功能描述:
     * @Param: [id, zbbm, ggxh]
     * @Return: int
     * @Description: id为装备调出Id  zbbm和ggxh为剩下的
     * @Author: NCH
     * @Date: 2019/07/31 下午 06:02
     */
    @Override
    public int deleteTjZbdc(String id, List<String> zbbm, List<String> ggxh) {

        if (zbbm == null || ggxh == null) {
            return 0;
        }
        /*根据id查询调剂装备编码们*/
        EqTjZbdcVO vo = mapper.selectByPrimaryKey(id);
        String s = vo.getTjZbbm();
        String s2 = vo.getTjGgxh();
        /*将传入的装备编码们转换为json数组*/
        String zbbmjson = JSON.toJSONString(zbbm);
        /*将传入的规格型号们转换为json数组*/
        String ggxhjson = JSON.toJSONString(ggxh);

        if (s.equals(zbbmjson)) {

        } else {
            /*老装备编码们json数组*/
            JSONArray jsonArray = JSONArray.parseArray(s);
            JSONArray jsonArray2 = JSONArray.parseArray(s2);
            /*新装备编码们json数组*/
            JSONArray array = JSONArray.parseArray(zbbmjson);
            JSONArray array2 = JSONArray.parseArray(ggxhjson);
            int size = array.size();
            if (size > 0) {
                for (int i = 0; i < size; i++) {
                    if (jsonArray.contains(array.get(i))) {
                        jsonArray.remove(array.get(i));
                    }
                }
            }


            EqTjsqVO tjsqVO = mapper.selectSqJlByKey(vo.getTjSqtj());
            /*获取申请的全部装备*/
            String zbmc = tjsqVO.getTjZbmc();
            JSONArray zbmcArray = JSONArray.parseArray(zbmc);
            int size1 = zbmcArray.size();
            int size2 = jsonArray.size();
            for (int j = 0; j < size2; j++) {
                String str = (String) jsonArray.get(j);
                updateEqInfoSfJc(str, "0");
            }
            for (int k = 0; k < size2; k++) {
                String s3 = mapper.selectZbNameByZbBh((String) jsonArray.get(k));
                for (int i = 0; i < size1; i++) {
                    String name = (String) zbmcArray.getJSONObject(i).get("name");
                    /*先判断相等的，没有相等的再模糊找*/
                    if (s3.equals(name)
                            || s3.contains(name)) {
                        TjZbMcNameCount object = zbmcArray.getObject(i, TjZbMcNameCount.class);
                        object.setCount(object.getCount() + 1);
                        String str = JSON.toJSONString(object);
                        JSONObject jsonObject = JSONObject.parseObject(str);
                        zbmcArray.set(i, jsonObject);
                        System.out.println("");
                    }
                }
            }
            EqTjsqVO tjsq = new EqTjsqVO();
            tjsq.setId(vo.getTjSqtj());
            tjsq.setTjZbmc(zbmcArray.toString());
            updateByPrimaryKey(tjsq);
            int i = mapper.updateDcZb(id, zbbmjson, ggxhjson, null,null ,new Date());
            updateZbCount(id);
        }
        return 1;
    }

    /*查看装备调出详情*/
    @Override
    public EqTjZbdcVO selectTjZbdcByPrimary(String id) {
        EqTjZbdcVO eqTjZbdcVO = mapper.selectByPrimaryKey(id);
        ArrayList<String> list = new ArrayList<>();
        JSONArray array = JSONArray.parseArray(eqTjZbdcVO.getTjZbbm());
        int size = array.size();
        for (int i = 0; i < size; i++) {
            String s = mapper.selectZbNameByZbBh((String) array.get(i));
            list.add(s);
        }
        eqTjZbdcVO.setTjZbName(list);
        eqTjZbdcVO.setTjDcksName(mapper.selectBmNameByBmid(eqTjZbdcVO.getTjDcks()));
        return eqTjZbdcVO;
    }

    /*更改设备状态*/
    @Override
    public int updateEqInfoSfJc(String sbbh, String status) {
        return mapper.updateEqInfoSfJc(sbbh, status);
    }

    /*查询未送达调配单*/
    @Override
    public PageInfo selectWsdYsd() {
        List<EqTjDpdVO> vos = mapper.selectWsdDpd();
        for (int i = 0; i < vos.size(); i++) {
            vos.get(i).setZbSdks(mapper.selectKsNameByID(vos.get(i).getZbSdks()));
        }
        return new PageInfo(vos);
    }

    /*查询验收单已送达*/
    @Override
    public PageInfo selectYsdYsd() {

        List<EqTjDpdVO> vos = mapper.selectYsdDpd();
        for (int i = 0; i < vos.size(); i++) {
            vos.get(i).setZbSdks(mapper.selectKsNameByID(vos.get(i).getZbSdks()));
        }
        return new PageInfo(vos);
    }

    /*暂时没用到0.0*/
    @Override
    public int updateDcZb(String id, String zbbm, String ggxh) {

        return 0;
    }

    @Override
    public int updateZbCount(String id) {
        EqTjZbdcVO vo = mapper.selectByPrimaryKey(id);
        JSONArray array = JSONArray.parseArray(vo.getTjZbbm());
        JSONArray array2 = JSONArray.parseArray(vo.getTjGgxh());
        if (array.size() == array2.size()) {
            return mapper.updateZbCount(id, array.size());
        } else {
            return 0;
        }

    }

    @Override
    public int updateSqZbBykey(String id, Integer count, String zbname) {
        return 0;
    }

//    @Override
//    public int updateSqZbBykey(String id, Integer count, String zbname) {
//        String zbmc = mapper.selectSqJlByKey(id).getTjZbmc();
//        JSONArray array = JSONArray.parseArray(zbmc);
//        for (int i = 0; i < array.size(); i++) {
//            TjZbMcNameCount object = array.getObject(i, TjZbMcNameCount.class);
//            if (object.getName().equals(zbname)) {
//                int count2 = object.getCount() - count;
//                if (count2 != 0 && count2 > 0) {
//                    object.setCount(count2);
//                    String s = JSON.toJSONString(object);
//                    JSONObject jsonObject = JSONObject.parseObject(s);
//                    array.set(i, jsonObject);
//                    break;
//                } /*else if (count2 == 0) {
//                    array.remove(i);
//                }*/ else {
//                    return 0;
//                }
//            }
//
//        }
//
//        return mapper.updateSqZbBykey(id, array.toString());
//
//    }

    @Override
    public String importTjsqimg(MultipartFile img) {
        String path = System.getProperty("user.dir");
        String filePath = path + "/tj/imgs/";
        String url = UploadFile.upload(filePath, img);
        url = url.replaceAll("/", "\\\\");
        return url;
    }

}

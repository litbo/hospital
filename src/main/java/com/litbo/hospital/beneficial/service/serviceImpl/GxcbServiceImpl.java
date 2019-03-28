package com.litbo.hospital.beneficial.service.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.litbo.hospital.beneficial.MathUtils;
import com.litbo.hospital.beneficial.bean.BSbcwBean;
import com.litbo.hospital.beneficial.dao.GxcbDao;
import com.litbo.hospital.beneficial.service.GxcbService;
import com.litbo.hospital.beneficial.vo.InsertSbcwVo;
import com.litbo.hospital.beneficial.vo.ShowSbcwVo;
import com.litbo.hospital.beneficial.vo.UpdateKmVo;
import com.litbo.hospital.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class GxcbServiceImpl implements GxcbService {

    @Autowired
    private GxcbDao gxcbDao;

    @Override
    public Result insertCb(InsertSbcwVo insertSbcwVo) {
        //接收科目名称与金额的列表
        List<UpdateKmVo> list= insertSbcwVo.getKmNameAndValue();
        //转换为json
        String json = JSON.toJSONString(list);
        BSbcwBean bSbcwBean = new BSbcwBean();
        //转换为json数组
        JSONArray jsonArray = (JSONArray) JSONArray.parseArray(json);

        //遍历该数组内的json串   并读出各个科目的名称与金额
        for(int i = 0 ;i<insertSbcwVo.getKmNameAndValue().size() ;i++){

            //获取科目名称
            String kmName1 = jsonArray.getJSONObject(i)+"";
            JSONObject kmName2 = JSON.parseObject(kmName1);
            String kmName3 = (String) kmName2.get("kmName1");
            bSbcwBean.setKmName(kmName3);

            //获取科目金额
            String kmValue1 = jsonArray.getJSONObject(i)+"";
            JSONObject kmValue2 = JSON.parseObject(kmValue1);
            Object kmValue3 = kmValue2.get("kmValue1");
            /*BigDecimal kmValue3 = (BigDecimal) kmValue2.get("kmValue1");*/
            bSbcwBean.setKmValue(MathUtils.getBigDecimal(kmValue3));

            //获取科目编号
            String kmNum1 = jsonArray.getJSONObject(i)+"";
            JSONObject kmNum2 = JSON.parseObject(kmNum1);
            String kmNum3 = (String) kmValue2.get("kmNum1");
            bSbcwBean.setKmNum(kmNum3);

            bSbcwBean.setEqId(insertSbcwVo.getEqId());
            bSbcwBean.setEqName(insertSbcwVo.getEqName());
            bSbcwBean.setKsId(insertSbcwVo.getBmId());
            bSbcwBean.setBmName(insertSbcwVo.getBmName());
            bSbcwBean.setKmSj(insertSbcwVo.getKmSj());
            bSbcwBean.setQjlc(0);
            if(kmName3=="管理费用"||kmName3=="辅助科室分摊"){
                bSbcwBean.setKmCjdm(2);
            }
            bSbcwBean.setKmCjdm(1);
            //bSbcwBean.setaId(i+3);

            if( gxcbDao.insertCb(bSbcwBean)>0){
                if(i == insertSbcwVo.getKmNameAndValue().size()) {
                    return Result.success();
                }
            }
            else {
                return Result.error();
            }
        }
        return Result.success();
    }

    @Override
    public Result showSbCb(Integer aId) {
        return Result.success(gxcbDao.showSbCb(aId));
    }

    @Override
    public Integer updateSbCb(Integer aId, BigDecimal kmValue) {
        return gxcbDao.updateSbCb(aId,kmValue);
    }

    @Override
    public Integer deleteSbCb(Integer aId) {
        return gxcbDao.deleteSbCb(aId);
    }
}

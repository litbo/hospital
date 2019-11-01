package com.litbo.hospital.supervise.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.supervise.bean.PbJhVO;
import com.litbo.hospital.supervise.dao.PbMapper;
import com.litbo.hospital.supervise.service.PbService;
import com.litbo.hospital.supervise.vo.RyVos;
import com.litbo.hospital.supervise.vo.getPbPlanVos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PbServiceImp implements PbService {

    @Autowired(required = false)
    private PbMapper pbMapper;

    @Override
    public List<RyVos> getPbPeople(int pageNum,int pageSize,String id) {
        PageHelper.startPage(pageNum,pageSize);
        return pbMapper.getPbPeople(id);
    }

    @Override
    public PageInfo<RyVos> getBmpeople(String bmId,int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo<>(pbMapper.getBmpeople(bmId));
    }

    @Override
    public List<RyVos> ghPeople(int pageNum, int pageSize, String sid) {
        PageHelper.startPage(pageNum,pageSize);
        return pbMapper.ghPeople(sid);
    }

    @Override
    public List<getPbPlanVos> getPbPlan(int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return pbMapper.getPbPlanVos();
    }

    @Override
    public void addPbPlan(PbJhVO pbJhVO) {
        try{
            String pbJhid = UUID.randomUUID().toString();
            String ids[] = pbJhVO.getUserId().split(",");
            for(int i=0; i<ids.length; i++){
                pbJhVO.setUserId(ids[i]);
                pbJhVO.setPbJhid(pbJhid);
                System.out.println(pbJhVO);
                pbMapper.addPbPlan(pbJhVO);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

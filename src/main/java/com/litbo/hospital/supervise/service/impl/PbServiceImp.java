package com.litbo.hospital.supervise.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.supervise.bean.PbJhVO;
import com.litbo.hospital.supervise.dao.PbMapper;
import com.litbo.hospital.supervise.service.PbService;
import com.litbo.hospital.supervise.vo.*;
import org.apache.ibatis.annotations.Param;
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
    public void insertGhRy(@Param("uid") String uid, @Param("sid") String sid, @Param("gid") String gid) {
        pbJhRyVo JhRyVo = new pbJhRyVo();
        String zt = "代替"+gid;
        JhRyVo.setUId(UUID.randomUUID().toString());
        JhRyVo.setUserZt(zt);
        JhRyVo.setPbJhid(sid);
        JhRyVo.setUserId(uid);
        pbMapper.insertGhRy(JhRyVo);
    }

    @Override
    public void BcKqRy(List<KqRyVos> pbRyVos,String jid) {//id代表排班计划pb_jhid

       // System.out.println(jid);

       for(KqRyVos k:pbRyVos){
           KqRyVos kq = new KqRyVos();
           kq.setId(UUID.randomUUID().toString());
           kq.setUserId(k.getUserId());
           kq.setUserName(k.getUserName());
           kq.setIsKq(k.getIsKq());
           kq.setPbJhid(jid);
           pbMapper.BcKqRy(kq);
       }

       List<UserIdVo> userIdVos = pbMapper.getUidByKqYd(jid);
       if(userIdVos.size()>0){
           for(UserIdVo u:userIdVos){
               String uid = u.getUserId();
               pbMapper.updateRyZtYd(uid,jid);//更新人员状态
           }
       }

       List<UserIdVo> userIdVos1 = pbMapper.getUidByKqWd(jid);
        if(userIdVos1.size()>0){
            for(UserIdVo u:userIdVos1){
                String uid = u.getUserId();
                pbMapper.updateRyZtWd(uid,jid);//更新人员状态
            }
        }
      pbMapper.updatePbCheck(jid);//更新审核状态
    }

    @Override
    public void addPbPlan(PbJhVO pbJhVO) {
        try{
            String pbJhid = UUID.randomUUID().toString();

                pbJhVO.setPbJhid(pbJhid);
                pbJhVO.setPbCheck("未审核");
               // System.out.println(pbJhVO);
                pbMapper.addPbPlan(pbJhVO);

            String ids[] = pbJhVO.getUserId().split(",");

            if(ids.length>0){
                for(String id:ids){
                    pbJhRyVo  ryVo = new pbJhRyVo();
                    ryVo.setUId(UUID.randomUUID().toString());
                    ryVo.setPbJhid(pbJhVO.getPbJhid());
                    ryVo.setUserId(id);
                    ryVo.setUserZt("应到");
                   // System.out.println(ryVo);
                    pbMapper.addPbPlanRy(ryVo);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
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



}

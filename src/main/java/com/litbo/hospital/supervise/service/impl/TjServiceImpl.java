package com.litbo.hospital.supervise.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.security.vo.TjRyVo;
import com.litbo.hospital.supervise.dao.TjDao;
import com.litbo.hospital.supervise.service.TjService;
import com.litbo.hospital.supervise.vo.RyVos;
import com.litbo.hospital.supervise.vo.TjRyVos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TjServiceImpl implements TjService {

    @Autowired(required = false)
    private TjDao tjDao;

    @Override
    public PageInfo getInfo(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<RyVos> Rylist = tjDao.getInfo();
        List<TjRyVos> tjs = new ArrayList<>();
        if(Rylist.size()>0){
            for(RyVos r:Rylist){
                TjRyVos vos = new TjRyVos();
                String userid = r.getUserId();
                String pbcs = tjDao.getPbCiShuByid(userid);//查询排班人数
                String zbcs = tjDao.getZbCiShuByid(userid);//查询值班人数
                vos.setUserId(userid);
                if(pbcs==null){
                    vos.setPbcs("0");
                }else{
                    vos.setPbcs(pbcs);
                }
                if(zbcs==null){
                    vos.setZbcs("0");
                }else{
                    vos.setZbcs(zbcs);
                }
                vos.setUserName(r.getUserName());
                tjs.add(vos);
            }
            return new PageInfo(tjs);
        }else{
            return new PageInfo();
        }
    }
}

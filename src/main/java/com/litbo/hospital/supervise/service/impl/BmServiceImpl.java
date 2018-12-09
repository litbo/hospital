package com.litbo.hospital.supervise.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.common.utils.StringCutUtils;
import com.litbo.hospital.supervise.bean.SBm;
import com.litbo.hospital.supervise.dao.BmDao;
import com.litbo.hospital.supervise.service.BmService;
import com.litbo.hospital.supervise.vo.BmSelectVO;
import com.litbo.hospital.supervise.vo.SetBmVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.expression.Ids;

import java.util.List;
@Service
public class BmServiceImpl implements BmService {

    @Autowired
    private BmDao bmDao;
    @Override
    public PageInfo getBmList(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<SBm> date = bmDao.getBmList();
        return new PageInfo(date);
    }

    @Override
    public PageInfo getBmListByPid(int pageNum, int pageSize, String pid) {
        PageHelper.startPage(pageNum,pageSize);
        List<SBm> date = bmDao.getBmListByPid(pid);
        return new PageInfo(date);
    }
    @Override
    public SBm getBmByOid(String id) {
        SBm date = bmDao.getBmByOid(id);
        return date;
    }

    @Override
    public void saveBm(SBm bm) {
        bmDao.saveBm(bm);
    }

    @Override
    public PageInfo getBmListByX(int pageNum, int pageSize, BmSelectVO selectVo) {
        PageHelper.startPage(pageNum,pageSize);
        List<SBm> date = bmDao.getBmListByX(selectVo);
        return new PageInfo(date);
    }

    @Override
    public void removeBmByOid(String oid) {
        bmDao.removeBmByOid(oid);
    }

    @Override
    public boolean isZJD(String oid) {
        Integer num = bmDao.getAmountByPid(oid);  //获取子节点
        if(num>0) return false;
        return true;
    }

    @Override
    public boolean isAllZJD(String[] obm_ids) {
        for(String obm_id :obm_ids){
            if(!isZJD(obm_id)) return false;
        }
        return true;
    }

    @Override
    public void setBmsBeto(SetBmVO bmVO) {
        String new_pbm_id = bmVO.getPbm_id();
        String[] obm_ids = bmVO.getObm_ids();
        for(String obm_id:obm_ids){
            setBmBeto(obm_id,new_pbm_id);
        }
    }

    @Override
    public void setBmBeto(String obm_id, String new_pbm_id) {
        SBm bm = bmDao.getBmByOid(obm_id); // 获得需要修改bm的信息
        List<SBm> old_bmListByPid = bmDao.getBmListByPid(bm.getpBmId()); //获取平级下的部门信息
        List<SBm> new_bmListByPid = bmDao.getBmListByPid(new_pbm_id); //获取平级下的部门信息

        SBm old_idmax_mb = getMaxBm(old_bmListByPid);
        SBm new_idmax_mb = getMaxBm(new_bmListByPid);

        String new_bm_id = createNewBmId(new_idmax_mb);
        bmDao.setBmBeto(obm_id,new_bm_id,new_pbm_id);

        if(!old_idmax_mb.getBmId().equals(bm.getBmId())) {   //如果原来平级部门id的最大值不为当前修改的部门的id，酒吧这个部门的id赋给他
            bmDao.setBmIdByOid(old_idmax_mb.getObmId(),bm.getBmId());

        }

    }

    private String createNewBmId(SBm idmax_mb) {
        List<String> bmid_cuted = StringCutUtils.stringToList(idmax_mb.getBmId());
        System.out.println(bmid_cuted);
        int l=0;
        for(String s:bmid_cuted){
            if(!s.equals("00")) l++;
        }
        System.out.println(l);

        int mb = Integer.parseInt(bmid_cuted.get(l - 1))+1;
        if(mb+1<10)
            bmid_cuted.add(l-1,"0"+Integer.toString(mb));
        else
            bmid_cuted.add(l-1,Integer.toString(mb));
        bmid_cuted.remove(l);
        System.out.println(bmid_cuted);

        StringBuffer new_bmid = new StringBuffer();
        for(String s:bmid_cuted){
            new_bmid.append(s);
        }
        return new_bmid.toString();
    }

    private SBm getMaxBm(List<SBm> bms) {
        SBm idmaxbm = bms.get(0);
        for (SBm bm:bms){
            if(Integer.parseInt(bm.getBmId())>Integer.parseInt(idmaxbm.getBmId())){
                idmaxbm = bm;
            }
        }
        return idmaxbm;
    }
}

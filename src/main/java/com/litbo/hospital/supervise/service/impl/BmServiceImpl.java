package com.litbo.hospital.supervise.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.common.utils.StringCutUtils;
import com.litbo.hospital.supervise.bean.SBm;
import com.litbo.hospital.supervise.dao.BmDao;
import com.litbo.hospital.supervise.service.BmService;
import com.litbo.hospital.supervise.vo.BmSelectLbVO;
import com.litbo.hospital.supervise.vo.BmSelectVO;
import com.litbo.hospital.supervise.vo.SetBmVO;
import com.litbo.hospital.supervise.vo.WxbmSzSelectVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<SBm> getBmList() {
        return bmDao.getBmList();
    }

    @Override
    public PageInfo getXBmList(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<SBm> date = bmDao.getXBmList();
        return new PageInfo(date);
    }

    @Override
    public PageInfo getYZBmList(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<SBm> date = bmDao.getYZBmList();
        return new PageInfo(date);
    }

    @Override
    public PageInfo getGLBmList(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<SBm> bms = bmDao.getGLBmList();
        List<WxbmSzSelectVO> date = new ArrayList<>();

        for(SBm bm:bms){
            WxbmSzSelectVO szSelectVO = new WxbmSzSelectVO();
            szSelectVO.setBmId(bm.getBmId());
            szSelectVO.setBmName(bm.getBmName());
            if(bm.getBmId().startsWith("01")){
                szSelectVO.setBmLb("机构领导");
            }else if(bm.getBmId().startsWith("02")){
                szSelectVO.setBmLb("管理部门");
            }else{
                szSelectVO.setBmLb("使用部门");
            }

            if(bm.getBmId().startsWith("0201")){
                szSelectVO.setGlBmLb("医工");
            }else if(bm.getBmId().startsWith("0202")){
                szSelectVO.setGlBmLb("信息");
            }else if(bm.getBmId().startsWith("0203")){
                szSelectVO.setGlBmLb("后勤");
            }else {
                szSelectVO.setGlBmLb("0");
            }

            if ((bm.getWxFlag().equals("1"))) {
                szSelectVO.setIsWxbm("是");
            } else {
                szSelectVO.setIsWxbm("否");
            }
            date.add(szSelectVO);
        }

        return new PageInfo(date);
    }

    @Override
    public List<SBm>  getXBmList() {
        return bmDao.getXBmList();
    }

    @Override
    public List<SBm>  getYZBmList() {
        return bmDao.getYZBmList();
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
    public SBm getBmByBmId(String bmid) {
        SBm date = bmDao.getBmBybmid(bmid);
        return date;
    }

    @Override
    public List<SBm> getWxBmList() {
        List<SBm> date = bmDao.getWxBmList();
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
        String new_pbm_id = bmVO.getPbm_id();   //获取父部门
        String[] obm_ids = bmVO.getObm_ids();   //获取子部门
        for(String obm_id:obm_ids){
            setBmBeto(obm_id,new_pbm_id);       //设置归属
        }
    }

    @Override
    public void setBmBeto(String obm_id, String new_pbm_id) {
        SBm bm = bmDao.getBmByOid(obm_id); // 获得需要修改bm的信息
        List<SBm> old_bmListByPid = bmDao.getBmListByPid(bm.getpBmId()); //获取平级下的部门信息
        List<SBm> new_bmListByPid = bmDao.getBmListByPid(new_pbm_id); //获取平级下的部门信息

        SBm old_idmax_mb = getMaxBm(old_bmListByPid);    //
        SBm new_idmax_mb = getMaxBm(new_bmListByPid);    //

        String new_bm_id = createNewBmId(new_idmax_mb);
        bmDao.setBmBeto(obm_id,new_bm_id,new_pbm_id);

        if(!old_idmax_mb.getBmId().equals(bm.getBmId())) {   //如果原来平级部门id的最大值不为当前修改的部门的id，酒吧这个部门的id赋给他
            bmDao.setBmIdByOid(old_idmax_mb.getObmId(),bm.getBmId());

        }

    }

    private String createNewBmId(SBm idmax_mb) {
        /**  List<String> bmid_cuted = StringCutUtils.stringToList(idmax_mb.getBmId());
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
//        System.out.println(bmid_cuted);

        StringBuffer new_bmid = new StringBuffer();
        for(String s:bmid_cuted){
            new_bmid.append(s);
        }
        return new_bmid.toString();  */

        List<Integer> bmid_cuted = StringCutUtils.stringToIntList(idmax_mb.getBmId());
        System.out.println(bmid_cuted);
        int l=0;
        for(Integer s:bmid_cuted){
            if(s!=0) l++;
        }
        System.out.println(l);
//        18 10 6 0 0 0

        List<String> bmidc = new ArrayList<>();
        bmid_cuted.set(l-1,bmid_cuted.get(l - 1)+1);
        for(int j = 0;j<5;j++){
            Integer teni = bmid_cuted.get(j);
            String hexi = Integer.toHexString(teni);
            if(hexi.length()==1){
                bmidc.add(j,"0"+hexi);
            }else{
                bmidc.add(j,hexi);
            }
        }

        StringBuffer new_bmid = new StringBuffer();
        for(String s:bmidc){
            new_bmid.append(s);
        }
        return new_bmid.toString();
    }

    private SBm getMaxBm(List<SBm> bms) {

        SBm idmaxbm = bms.get(0);
        for (SBm bm:bms){
            System.out.println(Long.parseLong(bm.getBmId(),16));
//            if(Integer.parseInt(bm.getBmId())>Integer.parseInt(idmaxbm.getBmId())){
//                idmaxbm = bm;
//            }
            if(Long.parseLong(bm.getBmId(),16)>Long.parseLong(idmaxbm.getBmId(),16)){
                idmaxbm = bm;
            }
        }
        return idmaxbm;
    }

    @Override
    public void setWxbm(List<String> obmids, int fwFlag) {
        for(String obmid:obmids){
            bmDao.setWxbm(obmid,fwFlag);
        }
    }

    @Override
    public List<SBm> getWxBms() {

        return bmDao.getWxBms();
    }

    @Override
    public List<SBm> getFwxBms() {

        return bmDao.getFwxBms();
    }

    @Override
    public PageInfo getFwxBms(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo(bmDao.getFwxBms());
    }


    @Override
    public PageInfo listFWXBmByBmName(int pageNum, int pageSize, String bmName) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo(bmDao.listFWXBmByBmName(bmName));
    }

    @Override
    public PageInfo listBmsAsLbBms(int pageNum, int pageSize,int flag) {
        PageHelper.startPage(pageNum,pageSize);

        List<SBm> bms = bmDao.getBmList();


        List<BmSelectLbVO> lbbms = new ArrayList<>();
        if(flag==1){
            for (SBm bm:bms){
                BmSelectLbVO lbbm = new BmSelectLbVO();
                lbbm.setBmId(bm.getBmId());
                lbbm.setBmName(bm.getBmName());
                if(bm.getBmId().startsWith("02"))
                    lbbm.setBmLb("管理部门");
                else if (bm.getBmId().startsWith("01")){
                    lbbm.setBmLb("机构领导");
                }else {
                    lbbm.setBmLb("使用部门");
                }
                lbbms.add(lbbm);
            }
        }else if(flag==2){
            for (SBm bm:bms){
                BmSelectLbVO lbbm = new BmSelectLbVO();
                if(bm.getBmId().startsWith("02")){
                    lbbm.setBmId(bm.getBmId());
                    lbbm.setBmName(bm.getBmName());
                    if(bm.getBmId().startsWith("0201")){
                        lbbm.setBmgk("医工");
                    }else if(bm.getBmId().startsWith("0202")) {
                        lbbm.setBmgk("信息");
                    }else if(bm.getBmId().startsWith("0203")) {
                        lbbm.setBmgk("后勤");
                    }
                }
                lbbms.add(lbbm);
            }
        }else if(flag==3){
            for (SBm bm:bms){
                BmSelectLbVO lbbm = new BmSelectLbVO();
                if(bm.getBmId().startsWith("02")){
                    lbbm.setBmId(bm.getBmId());
                    lbbm.setBmName(bm.getBmName());
                    if(bm.getBmId().startsWith("0201")){
                        lbbm.setBmgk("医工");
                    }else if(bm.getBmId().startsWith("0202")) {
                        lbbm.setBmgk("信息");
                    }else if(bm.getBmId().startsWith("0203")) {
                        lbbm.setBmgk("后勤");
                    }

                    if(bm.getWxFlag().equals("1")){
                        lbbm.setIsGlbm("是");
                    }else {
                        lbbm.setIsGlbm("否");
                    }
                }
                lbbms.add(lbbm);
            }
        }


        return new PageInfo(lbbms);

    }
}

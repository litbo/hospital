package com.litbo.hospital.supervise.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.common.utils.StringCutUtils;
import com.litbo.hospital.supervise.bean.SBm;
import com.litbo.hospital.supervise.dao.BmDao;
import com.litbo.hospital.supervise.service.BmService;
import com.litbo.hospital.supervise.vo.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

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
        bm.setObmId(UUID.randomUUID().toString());
        List<SBm> new_bmListByPid = bmDao.getBmListByPid(bm.getpBmId()); //获取平级下的部门信息
        SBm new_idmax_mb = getMaxBm(new_bmListByPid,bm.getpBmId());
        String new_bm_id = createNewBmId(new_idmax_mb,new_idmax_mb.getBmId().equals(bm.getpBmId()));
        bm.setBmId(new_bm_id);
        bm.setXbmFlag("0");
        bmDao.saveBm(bm);
    }

    @Override
    public void updateBm(SBm bm) {
        bmDao.updateBm(bm);
    }

    @Override
    public PageInfo getBmListByX(int pageNum, int pageSize, BmSelectVO selectVo) {
        PageHelper.startPage(pageNum,pageSize);
        List<SBm> date = bmDao.getBmListByX(selectVo);
        return new PageInfo(date);
    }

    @Override
    public void removeBmByBmId(String oid) {
        bmDao.removeBmByBmId(oid);
    }

    @Override
    public boolean isZJD(String oid) {
        SBm bmByOid = bmDao.getBmByOid(oid);
        Integer num = bmDao.getAmountByPid(bmByOid.getBmId());  //获取子节点
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
        String new_pbm_id = bmVO.getPbmId();   //获取父部门
        String[] obm_ids = bmVO.getObmIds();   //获取子部门
        for(String obm_id:obm_ids){
            setBmBeto(obm_id,new_pbm_id);       //设置归属
        }
    }

    @Override
    public void setBmBeto(String obm_id, String new_pbm_id) {
        SBm bm = bmDao.getBmByOid(obm_id); // 获得需要修改bm的信息
        List<SBm> old_bmListByPid = bmDao.getBmListByPid(bm.getpBmId()); //获取平级下的部门信息
        List<SBm> new_bmListByPid = bmDao.getBmListByPid(new_pbm_id); //获取平级下的部门信息

        SBm old_idmax_mb = getMaxBm(old_bmListByPid,bm.getpBmId());    //
        SBm new_idmax_mb = getMaxBm(new_bmListByPid,new_pbm_id);    //

        String new_bm_id = createNewBmId(new_idmax_mb,new_idmax_mb.getBmId().equals(new_pbm_id));
        bmDao.setBmBeto(obm_id,new_bm_id,new_pbm_id);

        if(!old_idmax_mb.getBmId().equals(bm.getBmId())) {   //如果原来平级部门id的最大值不为当前修改的部门的id，酒吧这个部门的id赋给他
            bmDao.setBmIdByOid(old_idmax_mb.getObmId(),bm.getBmId());

        }

    }

    private String createNewBmId(SBm idmax_mb,Boolean xj) {
        List<Integer> bmid_cuted = StringCutUtils.stringToIntList(idmax_mb.getBmId());
        System.out.println(bmid_cuted);
        int l=0;
        for(Integer s:bmid_cuted){
            if(s!=0) l++;
        }
        System.out.println(l);

        if(xj==true) l++;
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

    private SBm getMaxBm(List<SBm> bms,String id) {

        if(bms.size()==0) return bmDao.getBmBybmid(id);
        SBm idmaxbm = bms.get(0);
        for (SBm bm:bms){
            System.out.println(Long.parseLong(bm.getBmId(),16));
            if(Long.parseLong(bm.getBmId(),16)>Long.parseLong(idmaxbm.getBmId(),16)){
                idmaxbm = bm;
            }
        }
        return idmaxbm;
    }

    @Override
    public void setWxbm(String[] obmids, int fwFlag) {
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
                }else if(bm.getBmId().startsWith("03")){
                    lbbm.setBmLb("使用部门");
                }else{
                    lbbm.setBmLb("未设置");
                }
                lbbms.add(lbbm);
            }
        }else if(flag==2){
            for (SBm bm:bms){

                if(bm.getBmId().startsWith("02")){
                    BmSelectLbVO lbbm = new BmSelectLbVO();
                    lbbm.setBmId(bm.getBmId());
                    lbbm.setBmName(bm.getBmName());
                    if(bm.getBmId().startsWith("0201")){
                        lbbm.setBmGk("医工");
                    }else if(bm.getBmId().startsWith("0202")) {
                        lbbm.setBmGk("信息");
                    }else if(bm.getBmId().startsWith("0203")) {
                        lbbm.setBmGk("后勤");
                    }
                    lbbms.add(lbbm);
                }
            }
        }else if(flag==3){
            for (SBm bm:bms){
                if(bm.getBmId().startsWith("02")){
                    BmSelectLbVO lbbm = new BmSelectLbVO();
                    lbbm.setBmId(bm.getBmId());
                    lbbm.setBmName(bm.getBmName());
                    if(bm.getBmId().startsWith("0201")){
                        lbbm.setBmGk("医工");
                    }else if(bm.getBmId().startsWith("0202")) {
                        lbbm.setBmGk("信息");
                    }else if(bm.getBmId().startsWith("0203")) {
                        lbbm.setBmGk("后勤");
                    }

                    if(bm.getWxFlag().equals("1")){
                        lbbm.setIsGlbm("是");
                    }else {
                        lbbm.setIsGlbm("否");
                    }
                    lbbms.add(lbbm);
                }

            }
        }


        return new PageInfo(lbbms);

    }

    @Override
    public PageInfo listBmsAsLbBmsBySelectVO(int pageNum, int pageSize,  BmSelectVO selectVO) {
        PageHelper.startPage(pageNum,pageSize);
        List<BmSelectLbVO> lbbms = bmDao.listBmsAsLbBmsBySelectVO(selectVO);

        if(selectVO.getFlag()==1){
            for (BmSelectLbVO lbbm:lbbms){
                if(lbbm.getBmId().startsWith("02"))
                    lbbm.setBmLb("管理部门");
                else if (lbbm.getBmId().startsWith("01")){
                    lbbm.setBmLb("机构领导");
                }else if(lbbm.getBmId().startsWith("03")){
                    lbbm.setBmLb("使用部门");
                }else{
                    lbbm.setBmLb("未设置");
                }
            }
        }else if(selectVO.getFlag()==2){
            for (BmSelectLbVO lbbm:lbbms){

                if(lbbm.getBmId().startsWith("02")){

                    if(lbbm.getBmId().startsWith("0201")){
                        lbbm.setBmGk("医工");
                    }else if(lbbm.getBmId().startsWith("0202")) {
                        lbbm.setBmGk("信息");
                    }else if(lbbm.getBmId().startsWith("0203")) {
                        lbbm.setBmGk("后勤");
                    }

                }
            }
        }else if(selectVO.getFlag()==3){
            for (BmSelectLbVO lbbm:lbbms){
                if(lbbm.getBmId().startsWith("02")){
                    if(lbbm.getBmId().startsWith("0201")){
                        lbbm.setBmGk("医工");
                    }else if(lbbm.getBmId().startsWith("0202")) {
                        lbbm.setBmGk("信息");
                    }else if(lbbm.getBmId().startsWith("0203")) {
                        lbbm.setBmGk("后勤");
                    }

                    if(lbbm.getWxFlag().equals("1")){
                        lbbm.setIsGlbm("是");
                    }else {
                        lbbm.setIsGlbm("否");
                    }
                }

            }
        }


        return new PageInfo(lbbms);
    }

    private void setBmIdAndPId(SBm bm){
        Random random = new Random(System.currentTimeMillis());
        List<SBm> bmList = bmDao.getBmList();
        SBm bm1 = null;

        while(true){
            bm1=bmList.get(random.nextInt(bmList.size()));
            List<Integer> bmid_cuted = StringCutUtils.stringToIntList(bm1.getBmId());
            int l=0;
            for(Integer s:bmid_cuted){
                if(s!=0) l++;
            }

            if(!bm1.getBmId().equals("0100000000")&&!bm1.getBmId().equals("0200000000")&&!bm1.getBmId().equals("0300000000")&&l<4) break;

        }

        String bmId = bm1.getBmId();
        bm.setpBmId(bmId);
        List<SBm> new_bmListByPid = bmDao.getBmListByPid(bmId); //获取平级下的部门信息
        SBm new_idmax_mb = getMaxBm(new_bmListByPid,bmId);
        String new_bm_id = createNewBmId(new_idmax_mb,new_idmax_mb.getBmId().equals(bmId));
        bm.setBmId(new_bm_id);
    }

    @Override
    public Integer batchImportBms(String fileName, MultipartFile file) throws  Exception {

        boolean notNull = false;
        Integer status = 1;
        if (!fileName.matches("^.+\\.(?i)(xls)$") && !fileName.matches("^.+\\.(?i)(xlsx)$")) {
            String error = "上传文件格式不正确";
            status = 0;
            return status;
        }
        boolean isExcel2003 = true;
        if (fileName.matches("^.+\\.(?i)(xlsx)$")) {
            isExcel2003 = false;
        }
        InputStream is = file.getInputStream();
        Workbook wb = null;
        if (isExcel2003) {
            wb = new HSSFWorkbook(is);
        } else {
            wb = new XSSFWorkbook(is);
        }
        Sheet sheet = wb.getSheetAt(0);
        if(sheet!=null){
            notNull = true;
        }

        for (int r = 1; r < sheet.getLastRowNum()-1; r++) {
            Row row = sheet.getRow(r);
            if (row == null){
                continue;
            }
            SBm bm = new SBm();


            row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
            row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);//设置读取转String类型
            row.getCell(3).setCellType(Cell.CELL_TYPE_STRING);
            row.getCell(4).setCellType(Cell.CELL_TYPE_STRING);
            row.getCell(5).setCellType(Cell.CELL_TYPE_STRING);
            row.getCell(6).setCellType(Cell.CELL_TYPE_STRING);
            row.getCell(7).setCellType(Cell.CELL_TYPE_STRING);
            row.getCell(8).setCellType(Cell.CELL_TYPE_STRING);





            String obmId = row.getCell(0).getStringCellValue();
            String bmId = row.getCell(1).getStringCellValue();
            String bmName = row.getCell(2).getStringCellValue();
            String userId = row.getCell(3).getStringCellValue();
            String bmTel = row.getCell(4).getStringCellValue();
            String bmAddr = row.getCell(5).getStringCellValue();
            String wxFlag = row.getCell(6).getStringCellValue();
            String pBmId = row.getCell(7).getStringCellValue();
            String xbmFlag = row.getCell(8).getStringCellValue();

            bm.setObmId(obmId);
//            bm.setBmId(bmId);


            bm.setBmId("0000000000");
            bm.setBmName(bmName);
            bm.setUserId(userId);
            bm.setBmTel(bmTel);
            bm.setBmAddr(bmAddr);
            bm.setWxFlag(wxFlag);
            bm.setpBmId(pBmId);
            bm.setXbmFlag(xbmFlag);

            setBmIdAndPId(bm);
            bmDao.saveBm(bm);

        }

        return status;
    }

    @Override
    public List<BmsTreeVO> listTreeBms() {
        List<BmsTreeVO> vos  =  bmDao.listTreeBms();
        for (BmsTreeVO treeVO :vos){
            if(treeVO.getBmId().startsWith("02")){
                treeVO.setIsGlbm("1");
            }else{
                treeVO.setIsGlbm("0");
            }

            if(treeVO.getBmId().startsWith("0201")){
                treeVO.setGkCode("0");
            }else  if(treeVO.getBmId().startsWith("0202")){
                treeVO.setGkCode("1");
            }else  if(treeVO.getBmId().startsWith("0203")){
                treeVO.setGkCode("2");
            }else {
                treeVO.setGkCode("3");
            }
        }
        return vos;
    }

    @Override
    public List<SBm> listBmsByBmName(int pageNum, int pageSize,String bmName) {
        PageHelper.startPage(pageNum,pageSize);
        return bmDao.listBmsByBmName(bmName);
    }
}

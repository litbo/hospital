package com.litbo.hospital.user.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.common.utils.UploadFile;
import com.litbo.hospital.common.utils.WordToPinYin;
import com.litbo.hospital.common.utils.poi.ChangeFile;
import com.litbo.hospital.common.utils.poi.ImportExcelUtil;
import com.litbo.hospital.operational_data_monitoring.software_interface.vo.EqInfoVO;
import com.litbo.hospital.operational_data_monitoring.software_interface.vo.SearchEqVO;
import com.litbo.hospital.user.bean.EqFj;
import com.litbo.hospital.user.bean.EqInfo;
import com.litbo.hospital.user.bean.EqPm;
import com.litbo.hospital.user.bean.EqSyxz;
import com.litbo.hospital.user.dao.EqDao;
import com.litbo.hospital.user.dao.PmDao;
import com.litbo.hospital.user.service.EqService;
import com.litbo.hospital.user.vo.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.litbo.hospital.common.utils.poi.ListToListMap.listToMap;
import static com.litbo.hospital.common.utils.poi.ListToListMap.parseMap2Object;


@Service
public class EqServiceImpl implements EqService {

    @Autowired
    EqDao eqDao;
    @Autowired
    PmDao pmDao;

    //初始化设备流水号（设备Id）
    public  String  setLsh(){
        if(eqDao.countEq()==0){
            String eqId ="10000";
            return eqId;
        }else{
            Integer eqId1 = Integer.parseInt(eqDao.getLastId())+1;
            String  eqId = eqId1.toString();
            return eqId;
        }
    }

    //设置设备编号
    public String setSbbh(String pmId,Date qysj) {
        //初始化设备编号
        //启用时间 年月1812 + pm编号68031409 + 级别 1 +
        //获取当前时间
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM");
        String time1 = sf.format(qysj);
        String time = time1.substring(2,4)+time1.substring(5,time1.length());
        EqPm pm = pmDao.getPmById(pmId);
        //初始化分类号
        String LastSbbh =  eqDao.getEqSbbhByPmid(pmId);
        if(StringUtils.isNotBlank(LastSbbh)){
            String Lastflbm = LastSbbh.substring(13,LastSbbh.length());
            Integer flbmInt = Integer.parseInt(Lastflbm)+1;
            String  flbm = String.format("%05d",flbmInt);
            String sbbh = time+pm.getPid()+pm.getGlh()+flbm;
            return sbbh;
        }else {
            String flbm1 = "00001";
            String sbbh = time+pm.getPid()+pm.getGlh()+flbm1;
            return sbbh;
        }
    }

    public String setPic(String[] pics){
        String path = System.getProperty("user.dir");
        String filePath = path+"/eq/";
        String tmpUrl =null;
        String url =null;
        String totalUrl=null;
        java.io.File file = new java.io.File(filePath);
        if(pics!=null){
            for (String pic : pics) {
                if(pic.contains(":")){
                    tmpUrl = UUID.randomUUID().toString()+pic.substring(pic.lastIndexOf("."));
                    url = filePath+tmpUrl;
                    if(!file.exists()){
                        file.mkdirs();
                    }
                    try {
                        ChangeFile.changeFile(pic,url);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if(totalUrl==null){
                        totalUrl="/"+tmpUrl;
                    }else {
                        totalUrl = totalUrl+","+"/"+tmpUrl;
                    }

                }

                else{
                    if(totalUrl==null){
                        totalUrl=pic;
                    }
                    else{
                        totalUrl=totalUrl+","+pic;
                    }
                }
                }



        }
        return totalUrl;

    }


    @Override
    public List<EqVo> getAllEq() {
        return eqDao.getAllEq();
    }

    @Override
    public PageInfo listShowEqs(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo(eqDao.listShowEqs());
    }

    @Override
    @Transactional
    public int addEq(EqInfoVo eqInfo) {

        //设置设备拼音码
        String pym =  WordToPinYin.toPinYin(eqInfo.getEqName());
        if(pym!=""){
            eqInfo.setEqPym(pym);
        }

        //初始化设备流水号
        eqInfo.setEqId(setLsh());


        //初始化设备编号
        //年月1812 + pm编号68031409 + 级别 1 +
        //获取当前时间
        if(eqInfo.getEqPmId()!=null){

            String sbbh =setSbbh(eqInfo.getEqPmId(),eqInfo.getEqQysj());
            eqInfo.setEqSbbh(sbbh);
        }


        //设置使用状态
        String syzt = "在用";
        eqInfo.setEqSyzt(syzt);


        //将临时保存在tmp的图片文件保存到eq文件夹下  并将tmp文件夹清空
        eqInfo.setEqMpzp(setPic(eqInfo.getMpzp()));
        eqInfo.setEqSbzp(setPic(eqInfo.getSbzp()));


        if(new java.io.File(System.getProperty("user.dir")+"/tmp/").exists())
            ChangeFile.deleteDir(System.getProperty("user.dir")+"/tmp/");
        //存
        return eqDao.addEq(eqInfo);
    }

    @Override
    public PageInfo listEqNameByX(int pageNum, int pageSize, String ccname) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo(eqDao.listEqNameByX(ccname));
    }

    @Override
    public PageInfo selectAllBy(Integer pageNum, Integer pageSize, SearchEqVO searchVO) {
        PageHelper.startPage(pageNum,pageSize);
        List<EqInfoVO> eqInfoVOS = eqDao.selectAllBy(searchVO);
//        System.out.println(eqInfoVOS.size());
        return new PageInfo(eqInfoVOS);
    }

    @Override
    public PageInfo selectAllBy2(Integer pageNum, Integer pageSize, SearchEqVO searchVO) {
        PageHelper.startPage(pageNum,pageSize);
        List<EqInfoVO> eqInfoVOS = eqDao.selectAllBy2(searchVO);
        return new PageInfo(eqInfoVOS);
    }
    @Override
    @Transactional
    public Integer importEq(MultipartFile file)  {

        Workbook workbook = null;
        InputStream inputStream = null;
        List<Integer> ids = new ArrayList<>();
        ids.add(6);
        ids.add(7);
        ids.add(10);
        ids.add(18);
        ids.add(19);
        ids.add(23);
        ids.add(35);
        try {
            inputStream = new ByteArrayInputStream(file.getBytes());
            workbook = WorkbookFactory.create(inputStream);
            inputStream.close();
            //工作表对象
            Sheet sheetAt = workbook.getSheetAt(0);
            Row row = sheetAt.getRow(2);
            int startRow=3;
            int rowNum = sheetAt.getLastRowNum() + 1;
            short cellNum = row.getLastCellNum();
            /*int rowIsNull = getRowIsNull(row, rowNum);
            System.out.println(rowIsNull);*/
            List<String> list = ImportExcelUtil.readTitlesToExcel(workbook, sheetAt, row, cellNum);
            List<List<Object>> lists = ImportExcelUtil.readRowsToExcel(workbook, sheetAt, row, rowNum,ids,startRow);

            List<Map<String, Object>> mapList = listToMap(lists, list);

            for (Map<String, Object> map : mapList) {
                /*SUser user = parseMap2Object(map, SUser.class);*/
                EqInfoVo eqInfo = parseMap2Object(map,EqInfoVo.class);
                if(eqInfo.getEqName().contains("*")){
                    return 1;
                }
                if(eqInfo.getEqBmName()!=null){
                    eqInfo.setEqBmid(eqDao.getBmIdByName(eqInfo.getEqBmName()));
                }
                if(eqInfo.getEqJldwName()!=null){
                    eqInfo.setEqJldwId(eqDao.getJldwId(eqInfo.getEqJldwName()));
                }
                if(eqInfo.getEqCxflName()!=null) {
                    eqInfo.setEqCxflId(eqDao.getCxflId(eqInfo.getEqCxflName()));
                }
                if(eqInfo.getEqZjlyName()!=null){
                    eqInfo.setZjlyId(eqDao.getZjlyId(eqInfo.getEqZjlyName()));
                }
                //初始化设备流水号
                eqInfo.setEqId(setLsh());
                //设置拼音码
                String pym =  WordToPinYin.toPinYin(eqInfo.getEqName());
                if(StringUtils.isNotBlank(pym)){
                    eqInfo.setEqPym(pym);
                }
               if(eqDao.addEq(eqInfo)<=0){
                    return 1/0;
               }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1;
    }

    @Override
    @Transactional
    public Integer importFj(MultipartFile file) {
        Workbook workbook = null;
        InputStream inputStream = null;
        List<Integer> ids = new ArrayList<>();

        try {
            inputStream = new ByteArrayInputStream(file.getBytes());
            workbook = WorkbookFactory.create(inputStream);
            inputStream.close();
            //工作表对象
            Sheet sheetAt = workbook.getSheetAt(0);
            Row row = sheetAt.getRow(0);
            int startRow=1;
            int rowNum = sheetAt.getLastRowNum() + 1;
            short cellNum = row.getLastCellNum();
            /*int rowIsNull = getRowIsNull(row, rowNum);
            System.out.println(rowIsNull);*/
            List<String> list = ImportExcelUtil.readTitlesToExcel(workbook, sheetAt, row, cellNum);
            List<List<Object>> lists = ImportExcelUtil.readRowsToExcel(workbook, sheetAt, row, rowNum,ids,startRow);

            List<Map<String, Object>> mapList = listToMap(lists, list);
            for (Map<String, Object> map : mapList) {
                /*SUser user = parseMap2Object(map, SUser.class);*/
                EqFj eqFj = parseMap2Object(map,EqFj.class);

                if(eqDao.saveFj(eqFj)<0){
                    return 1/0;
                }
            }


        }catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
        return 1;
    }

    @Override
    public PageInfo listFlEqByX(int pageNum, int pageSize, SelectFlEqVo selectFlEqVo) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo(eqDao.listFlEqByX(selectFlEqVo));
    }

    @Override
    public String uploadFile(MultipartFile multipartFile) {
        String path = System.getProperty("user.dir");
        String filePath =path+"/tmp/";
        String url = UploadFile.upload(filePath,multipartFile);
        return url;
    }

    @Override
    public Integer delEq(String eqId) {
        return eqDao.delEq(eqId);
    }

    @Override
    public List<EqPm> listPmTree() {

        List<EqPm> pms =  eqDao.listPmTree();
        for (EqPm pm : pms) {
            if(pm.getPid().length()<8){
                pm.setNocheck(true);
            }
        }
        return pms;
    }

    @Override
    public PageInfo listWFlEqByX(int pageNum, int pageSize, SelectFlEqVo selectFlEqVo) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo(eqDao.listWFlEqByX(selectFlEqVo));
    }

    @Override
    public EqPm getPmById(String eqPmId) {
        return eqDao.getPmById(eqPmId);
    }




    @Override
    @Transactional
    public Integer setPm(SetPmVo setPmVo) {
        List<String> eqIds = setPmVo.getEqIds();
        for (String eqId : eqIds) {
            EqInfo eqInfo = eqDao.getEqById(eqId);
            String sbbh = setSbbh(setPmVo.getEqPmId(),eqInfo.getEqQysj());
            String syzt="在用";
            if(eqDao.setPm(setPmVo.getEqPmId(),eqId,sbbh,syzt)<0){
                return 1/0;
            }

        }
        return 1;
    }

    @Override
    public Integer updateEq(EqInfoVo eqInfo) {
        if(StringUtils.isNotBlank(eqInfo.getEqName())){
            String pym =  WordToPinYin.toPinYin(eqInfo.getEqName());
            eqInfo.setEqPym(pym);
        }

        if(eqInfo.getMpzp()!=null)
            eqInfo.setEqMpzp(setPic(eqInfo.getMpzp()));

        if(eqInfo.getSbzp()!=null)
            eqInfo.setEqSbzp(setPic(eqInfo.getSbzp()));
      /*  if(new java.io.File(System.getProperty("user.dir")+"/tmp/").exists())
            ChangeFile.deleteDir(System.getProperty("user.dir")+"/tmp/");
*/
        return eqDao.updateEq(eqInfo);
    }

    @Override
        public EqInfo getEqById(String eqId) {

        EqInfo eqInfo= eqDao.getEqWithNameById(eqId);
        //查询厂商
        if(eqInfo.getSbcsIdScs()!=null)
            eqInfo.setScsName(eqDao.getCsById(eqInfo.getSbcsIdScs()));
        if(eqInfo.getSbcsIdGys()!=null)
                eqInfo.setGysName(eqDao.getCsById(eqInfo.getSbcsIdGys()));
        if(eqInfo.getSbcsIdWxs()!=null)
            eqInfo.setWxsName(eqDao.getCsById(eqInfo.getSbcsIdWxs()));

        return eqInfo;
    }

    @Override
    public PageInfo listPms(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo(eqDao.listPms());
    }

    @Override
    public PageInfo listEqName(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo(eqDao.listEqName());
    }


    @Override
    public PageInfo listFlEq(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo(eqDao.listFlEq());
    }

    @Override
    public PageInfo listWFlEq(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo(eqDao.listWFlEq());
    }

    @Override
    public Integer cancelFl(String eqId) {

        return eqDao.cancelFl(eqId);
    }

    @Override
    public PageInfo listPmsByPym(int pageNum, int pageSize, String pym) {
        PageHelper.startPage(pageNum,pageSize);
        if(StringUtils.isNotBlank(pym)){
            String newPym = "%"+pym+"%";
            return new PageInfo(eqDao.listPmsByPym(newPym));
        }
       return new PageInfo(eqDao.listPmsByPym(pym));
    }

    /**
     * 使用性质接口
     * @return
     */
    @Override
    public List<EqSyxz> listSyxz() {
        return eqDao.listSyxz();
    }

    @Override
    public Integer saveFj(EqFj eqFj) {
        return eqDao.saveFj(eqFj);

    }



}

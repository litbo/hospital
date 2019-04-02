package com.litbo.hospital.user.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.common.utils.UploadFile;
import com.litbo.hospital.common.utils.WordToPinYin;
import com.litbo.hospital.common.utils.poi.ChangeFile;
import com.litbo.hospital.common.utils.poi.ImportExcelUtil;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.user.bean.EqFj;
import com.litbo.hospital.user.bean.EqInfo;
import com.litbo.hospital.user.bean.EqPm;
import com.litbo.hospital.user.bean.EqSyxz;
import com.litbo.hospital.user.dao.EqDao;
import com.litbo.hospital.user.dao.PmDao;
import com.litbo.hospital.user.service.EqService;
import com.litbo.hospital.user.vo.EqVo;
import com.litbo.hospital.user.vo.SelectEqVo;
import com.litbo.hospital.user.vo.SelectFlEqVo;
import com.litbo.hospital.user.vo.SetPmVo;
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
import java.io.File;
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
    public int addEq(EqInfo eqInfo) {

        //设置设备拼音码
        String pym =  WordToPinYin.toPinYin(eqInfo.getEqName());
        if(pym!=""){
            eqInfo.setEqPym(pym);
        }

        //初始化设备流水号
        eqInfo.setEqId(setLsh());


        //初始化设备编号
        //年月1812 + pm编号68031409 + 级别 1 + 流水号eqId
        //获取当前时间
        if(eqInfo.getEqPmId()!=null){
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM");
            String time1 = sf.format(new Date());
            String time = time1.substring(2,4)+time1.substring(5,time1.length());
            EqPm pm = pmDao.getPmById(eqInfo.getEqPmId());
            String sbbh =time+pm.getPid()+pm.getGlh()+eqInfo.getEqId();
            eqInfo.setEqSbbh(sbbh);
        }


        //设置使用状态
        String syzt = "在用";
        eqInfo.setEqSyzt(syzt);

        //将临时保存在tmp的图片文件保存到eq文件夹下  并将tmp文件夹清空
        String path = System.getProperty("user.dir");
        String filePath = path+"/eq/";
        String mpzp =null;
        String sbzp = null;
        java.io.File file = new java.io.File(filePath);
        if(eqInfo.getEqMpzp()!=null){
            mpzp = filePath+ UUID.randomUUID().toString()+eqInfo.getEqMpzp().substring(eqInfo.getEqMpzp().lastIndexOf("."));
            if(!file.exists()){
                file.mkdirs();
            }
            try {
                ChangeFile.changeFile(eqInfo.getEqMpzp(),mpzp);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(eqInfo.getEqSbzp()!=null){
            sbzp = filePath+ UUID.randomUUID().toString()+eqInfo.getEqSbzp().substring(eqInfo.getEqSbzp().lastIndexOf("."));
            if(!file.exists()){
                file.mkdirs();
            }
            try {
                ChangeFile.changeFile(eqInfo.getEqSbzp(),sbzp);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        ChangeFile.deleteDir(path+"/tmp/");

        eqInfo.setEqMpzp(mpzp);
        eqInfo.setEqSbzp(sbzp);

        //存
        return eqDao.addEq(eqInfo);
    }


    @Override
    public PageInfo listEqByX(int pageNum, int pageSize, SelectEqVo selectEqVo) {
        PageHelper.startPage(pageNum,pageSize);
        if(StringUtils.isNotBlank(selectEqVo.getBmName()))
            selectEqVo.setBmName("%"+selectEqVo.getBmName()+"%");
        if(StringUtils.isNotBlank(selectEqVo.getEqPym()))
            selectEqVo.setEqPym("%"+selectEqVo.getEqPym()+"%");
        if(StringUtils.isNotBlank(selectEqVo.getEqSbbh()))
            selectEqVo.setEqSbbh("%"+selectEqVo.getEqSbbh()+"%");
        if(StringUtils.isNotBlank(selectEqVo.getEqZcbh()))
            selectEqVo.setEqZcbh("%"+selectEqVo.getEqZcbh()+"%");

        return new PageInfo(eqDao.listEqByX(selectEqVo));
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
        ids.add(17);
        ids.add(19);
        ids.add(23);
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
                EqInfo eqInfo = parseMap2Object(map,EqInfo.class);
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
                if(pym!=""){
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
    @Transactional
    public Integer setPm(SetPmVo setPmVo) {
        List<String> eqIds = setPmVo.getEqIds();
        for (String eqId : eqIds) {
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM");
            String time1 = sf.format(new Date());
            String time = time1.substring(2,4)+time1.substring(5,time1.length());
            EqPm pm = pmDao.getPmById(setPmVo.getEqPmId());
            String sbbh =time+pm.getPid()+pm.getGlh()+eqId;
            String syzt="在用";
            if(eqDao.setPm(setPmVo.getEqPmId(),eqId,sbbh,syzt)<0){
                return 1/0;
            }

        }
        return 1;
    }

    @Override
    public Integer updateEq(EqInfo eqInfo) {
        if(eqInfo.getEqName()!=null){
            String pym =  WordToPinYin.toPinYin(eqInfo.getEqName());
            eqInfo.setEqPym(pym);
        }
        return eqDao.updateEq(eqInfo);
    }

    @Override
        public EqInfo getEqById(String eqId) {

        return eqDao.getEqWithNameById(eqId);
    }

    @Override
    public PageInfo listPms(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo(eqDao.listPms());
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

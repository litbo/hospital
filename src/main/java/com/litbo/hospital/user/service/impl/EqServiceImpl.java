package com.litbo.hospital.user.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.common.utils.UploadFile;
import com.litbo.hospital.common.utils.WordToPinYin;
import com.litbo.hospital.common.utils.poi.ImportExcelUtil;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.user.bean.EqInfo;
import com.litbo.hospital.user.bean.EqPm;
import com.litbo.hospital.user.dao.EqDao;
import com.litbo.hospital.user.dao.PmDao;
import com.litbo.hospital.user.service.EqService;
import com.litbo.hospital.user.vo.EqVo;
import com.litbo.hospital.user.vo.SelectEqVo;
import com.litbo.hospital.user.vo.SetPmVo;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.litbo.hospital.common.utils.poi.ListToListMap.listToMap;
import static com.litbo.hospital.common.utils.poi.ListToListMap.parseMap2Object;

@Service
public class EqServiceImpl implements EqService {

    @Autowired
    EqDao eqDao;
    @Autowired
    PmDao pmDao;
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
    public int addEq(EqInfo eqInfo, MultipartFile sbzp, MultipartFile mpzp) {
        //文件上传
        String path = "F:\\img";
        String eqSbzp =  UploadFile.upload(path,sbzp);
        String eqMpzp =  UploadFile.upload(path,mpzp);
        eqInfo.setEqSbzp(eqSbzp);
        eqInfo.setEqMpzp(eqMpzp);
        //初始化设备流水号
        if(eqDao.countEq()==0){
           String eqId ="10000";
           eqInfo.setEqId(eqId);
        }else{
            Integer eqId1 = Integer.parseInt(eqDao.getLastId())+1;
            String  eqId = eqId1.toString();
            eqInfo.setEqId(eqId);
        }

        //初始化设备编号
        //年月1812 + pm编号68031409 + 级别 1 + 流水号eqId
        //获取当前时间
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM");
        String time1 = sf.format(new Date());
        String time = time1.substring(2,4)+time1.substring(5,time1.length());
        EqPm pm = pmDao.getPmById(eqInfo.getEqPmId());
        String sbbh =time+pm.getPid()+pm.getGlh()+eqInfo.getEqId();
        eqInfo.setEqSbbh(sbbh);
        //存
        return eqDao.addEq(eqInfo);
    }


    @Override
    public PageInfo listEqByX(int pageNum, int pageSize, SelectEqVo selectEqVo) {
        PageHelper.startPage(pageNum,pageSize);

        return new PageInfo(eqDao.listEqByX(selectEqVo));
    }

    @Override
    public Integer importEq(MultipartFile file)  {

        Workbook workbook = null;
        InputStream inputStream = null;

        try {
            inputStream = new ByteArrayInputStream(file.getBytes());
            workbook = WorkbookFactory.create(inputStream);
            inputStream.close();
            //工作表对象
            Sheet sheetAt = workbook.getSheetAt(0);
            Row row = sheetAt.getRow(0);
            int rowNum = sheetAt.getLastRowNum() + 1;
            short cellNum = row.getLastCellNum();
            /*int rowIsNull = getRowIsNull(row, rowNum);
            System.out.println(rowIsNull);*/
            List<String> list = ImportExcelUtil.readTitlesToExcel(workbook, sheetAt, row, cellNum);
            List<List<Object>> lists = ImportExcelUtil.readRowsToExcel(workbook, sheetAt, row, rowNum);

            List<Map<String, Object>> mapList = listToMap(lists, list);

            for (Map<String, Object> map : mapList) {
                /*SUser user = parseMap2Object(map, SUser.class);*/
                EqInfo eqInfo = parseMap2Object(map,EqInfo.class);

                //初始化设备流水号
                if(eqDao.countEq()==0){
                    String eqId ="10000";
                    eqInfo.setEqId(eqId);
                }else{
                    Integer eqId1 = Integer.parseInt(eqDao.getLastId())+1;
                    String  eqId = eqId1.toString();
                    eqInfo.setEqId(eqId);
                }

               if(eqDao.addEq(eqInfo)<0){
                    return -1;
               }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1;
    }

    @Override
    public Integer setPm(SetPmVo setPmVo) {
        List<String> eqIds = setPmVo.getEqIds();
        for (String eqId : eqIds) {
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM");
            String time1 = sf.format(new Date());
            String time = time1.substring(2,4)+time1.substring(5,time1.length());
            EqPm pm = pmDao.getPmById(setPmVo.getEqPmId());
            String sbbh =time+pm.getPid()+pm.getGlh()+eqId;
            if(eqDao.setPm(setPmVo.getEqPmId(),eqId,sbbh)<0){
                return -1;
            }
        }
        return 1;
    }


}

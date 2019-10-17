package com.litbo.hospital.security.specialequipment.service.serviceimpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.common.utils.UploadFile;
import com.litbo.hospital.common.utils.poi.ImportExcelUtil;
import com.litbo.hospital.security.specialequipment.bean.SpecialEquipment;
import com.litbo.hospital.security.specialequipment.bean.SpecialEquipmentExample;
import com.litbo.hospital.security.specialequipment.bean.vo.SpecialEquipmentEmployeeVo;
import com.litbo.hospital.security.specialequipment.bean.vo.SpecialEquipmentInfoVo;
import com.litbo.hospital.security.specialequipment.bean.vo.UserVo;
import com.litbo.hospital.security.specialequipment.dao.SpecialEquipmentCheckDao;
import com.litbo.hospital.security.specialequipment.dao.SpecialEquipmentEmployeeMapper;
import com.litbo.hospital.security.specialequipment.dao.SpecialEquipmentMapper;
import com.litbo.hospital.security.specialequipment.service.SpecialEquipmentService;
import com.litbo.hospital.security.specialequipment.utils.DateUtils;
import com.litbo.hospital.security.specialequipment.utils.GenerateId;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
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
import java.util.*;

import static com.litbo.hospital.common.utils.poi.ListToListMap.listToMap;
import static com.litbo.hospital.common.utils.poi.ListToListMap.parseMap2Object;

@Service
public class SpecialEquipmentServiceImpl implements SpecialEquipmentService {


    @Autowired
    private SpecialEquipmentMapper
            specialEquipmentMapper;
    @Autowired
    private SpecialEquipmentEmployeeMapper
            specialEquipmentEmployeeMapper;
    @Autowired
    private SpecialEquipmentCheckDao
            specialEquipmentCheckDao;


    //查询科室信息
    @Override
    public PageInfo selectSpEqBmInfo(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo(specialEquipmentMapper.selectSpEqBmInfo());
    }
    //查询科室信息根据科室名称
    @Override
    public PageInfo selectSpEqBmInfoByName(int pageNum, int pageSize, String bmName) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo(specialEquipmentMapper.selectSpEqBmInfoByName(bmName == null ? null : bmName.trim()));
    }




    //插入特种设备信息
    @Override
    public int insertSpecialEq(SpecialEquipment specialEquipment) {

        //设置特种设备流水号
        String speqId = specialEquipment.getSpeqId();
        if(StringUtils.isBlank(speqId)){
            speqId = GenerateId.getIdByIDAndTime("special_eq", "speq_id");
        }
        specialEquipment.setSpeqId(speqId);
        //设置计划检测日期 = 上次检测日期 + 检查周期(月)
        if(specialEquipment.getSpeqJcsj() != null){
            specialEquipment.setSpeqJhjcrq(DateUtils.DateAddUseMonth(specialEquipment.getSpeqJcsj(),
                    specialEquipment.getSpeqJczq()));
        }



        return specialEquipmentMapper.insertSelective(specialEquipment);
    }
    //删除特种设备信息
    @Override
    public int deleteSpecialEq(String speqId) {
        return specialEquipmentMapper.deleteByPrimaryKey(speqId);
    }
    //修改特种设备信息
    @Override
    public int updateSpecialEq(SpecialEquipment specialEquipment) {
        return specialEquipmentMapper.updateByPrimaryKey(specialEquipment);
    }
    //查询特种设备信息根据Id
    @Override
    public SpecialEquipment selectSpecialEqById(String speqId) {
        return specialEquipmentMapper.selectByPrimaryKey(speqId);
    }
    //查询特种设备信息
    @Override
    public PageInfo selectSpecialEq(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<SpecialEquipmentInfoVo> specialEquipmentInfoVos = specialEquipmentMapper.selectSpeqVo();
        return new PageInfo(specialEquipmentInfoVos);
    }
    //查询特种设备信息Vo根据设备id name 类型 生产商 科室名称
    @Override
    public PageInfo selectSpeqVoByBhAndNameAndScsAndTypeAndBmId(int pageNum, int pageSize,
                                                                String speqBh, String speqName,
                                                                String speqScs, int speqType,
                                                                String bmId, int speqRun){

        PageHelper.startPage(pageNum, pageSize);
        bmId = specialEquipmentCheckDao.selectBmName(bmId);
        if(bmId == null){
            bmId = "";
        }
        return new PageInfo(specialEquipmentMapper
                .selectSpeqVoByBhAndNameAndScsAndTypeAndBmId(speqBh == null ? null : speqBh.trim(),
                                                             speqName == null ? null : speqName.trim(),
                                                             speqScs == null ? null : speqScs.trim(),
                                                             speqType ,
                                                             bmId == null ? null : bmId.trim(),
                                                             speqRun));

    }
    //查询特种设备结果记录根据speqBh
    public PageInfo selectSpeqRecordBySpeqId(int pageNum, int pageSize, String speqBh){
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo(specialEquipmentMapper.selectSpeqRecordBySpeqId(speqBh));
    }






    //查询所有bu是特种设备从业人员的用户
    @Override
    public PageInfo<UserVo> selectAllUser(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<UserVo> pageInfo = new PageInfo<UserVo>(specialEquipmentMapper.selectAllUser());
        return pageInfo;
    }
    //查询所有是特种设备从业人员的用户
    @Override
    public PageInfo<UserVo> selectAllUserIsSpem(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<UserVo> pageInfo = new PageInfo<UserVo>(specialEquipmentMapper.selectAllUserIsSpem());
        return pageInfo;
    }
    //查询员工信息根据id name bmname
    @Override
    public PageInfo<List<UserVo>> selectUserByIdAndNameAndBmName(int pageNum, int pageSize, String userId, String userXm, String bmName) {
        PageHelper.startPage(pageNum, pageSize);

//        bmName = specialEquipmentCheckDao.selectBmName(bmName);
//        if(bmName == null){
//            bmName = "";
//        }
        return new PageInfo(specialEquipmentMapper.selectUserByIdAndNameAndBmName(
                userId == null ? null : userId.trim(),
                userXm == null ? null : userXm.trim(),
                bmName == null ? null : bmName.trim()));
    }
    //查询员工信息根据id name bmname
    @Override
    public PageInfo<List<UserVo>> selectSpeqUserByIdAndNameAndBmName(int pageNum, int pageSize, String userId, String userXm, String bmName) {
        PageHelper.startPage(pageNum, pageSize);

        bmName = specialEquipmentCheckDao.selectBmName(bmName);
        if(bmName == null){
            bmName = "";
        }

        return new PageInfo(specialEquipmentMapper.selectSpeqUserByIdAndNameAndBmName(
                userId == null ? null : userId.trim(),
                userXm == null ? null : userXm.trim(),
                bmName == null ? null : bmName.trim()));
    }
    //将员工设为特种设备从业人员
    @Override
    @Transactional
    public void updateIsSpeqEm(String userId) {
        //更改中间表
        specialEquipmentMapper.updateIsSpeqEm(userId);
        //插入基本信息
        specialEquipmentMapper.insertSpemInfo(userId);
        String bmName = specialEquipmentMapper.selectBmName(userId);
        specialEquipmentMapper.updateBmName(userId, bmName);
    }
    //将员工剔除特种设备从业人员
    @Override
    @Transactional
    public void updateIsNotSpeqEm(String userId) {
        specialEquipmentMapper.updateIsNotSpeqEm(userId);
        specialEquipmentEmployeeMapper.deleteByPrimaryKey(userId);

    }
    //根据user_id查询user信息
    public SpecialEquipmentEmployeeVo selectSpemById(String userId){
        return specialEquipmentMapper.selectSpeqEmployeeByUserId(userId);
    }

    //更改数据
    public int updateSpem(SpecialEquipmentEmployeeVo specialEquipmentEmployee) {
        return specialEquipmentMapper.updateSpemInfo(specialEquipmentEmployee);
    }
    //上传文件
    @Override
    public String setSpemImg(MultipartFile img) {
        String path = System.getProperty("user.dir");
        String filePath =path+"/spEqEmployee/";
        String url = UploadFile.upload(filePath,img);
        url = url.replaceAll("/","\\\\");
        return url;
    }
    //到期日期排序
    @Override
    public PageInfo selctDate(int pageNum, int pageSize){
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo(specialEquipmentMapper.selctDate());
    }



    //导入excel表格特种设备信息
    public int importSpeqInfo(MultipartFile file){
        Workbook workbook = null;
        InputStream inputStream = null;
        ArrayList ids = new ArrayList();
        ids.add(4);

        try {
            //流加载文件到内存 读取后封装成WorkBook
            inputStream = new ByteArrayInputStream(file.getBytes());
            workbook = WorkbookFactory.create(inputStream);
            //关闭流 文件自己释放
            inputStream.close();

            Sheet sheetAt = workbook.getSheetAt(0);
            Row row = sheetAt.getRow(3);
            int startRow = 4;
            int rowNum = sheetAt.getLastRowNum() + 1;
            short cellNum = row.getLastCellNum();

            List<String> list = ImportExcelUtil.readTitlesToExcel(workbook, sheetAt, row, cellNum);
            List<List<Object>> lists = ImportExcelUtil.readRowsToExcel(workbook, sheetAt, row, rowNum, ids, startRow);

            List<Map<String, Object>> mapList = listToMap(lists, list);
            for (Map<String, Object> map : mapList) {

                SpecialEquipment specialEquipment = parseMap2Object(map, SpecialEquipment.class);
                //初始化设备流水号
                //设置特种设备流水号
                if(specialEquipment.getSpeqBh().contains("*"))
                {
                    return 1;
                }
                String speqId = specialEquipment.getSpeqId();

                if(StringUtils.isBlank(speqId)){
                    try {
                        speqId = GenerateId.getIdByIDAndTime("special_eq", "speq_id");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                specialEquipment.setSpeqId(speqId);
                Date date = DateUtils
                        .DateAddUseMonth(specialEquipment.getSpeqJcsj(), specialEquipment.getSpeqJczq());
                specialEquipment.setSpeqJhjcrq(date);

                int i = specialEquipmentMapper.insertSelective(specialEquipment);

                if(i<=0){
                    return 1/0;
                }
            }



        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }

        return 1;
    }


}

package com.litbo.hospital.supervise.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.common.utils.UploadFile;
import com.litbo.hospital.supervise.bean.SBm;
import com.litbo.hospital.supervise.bean.SEmp;
import com.litbo.hospital.supervise.dao.BmDao;
import com.litbo.hospital.supervise.dao.EmpDao;
import com.litbo.hospital.supervise.service.EmpService;
import com.litbo.hospital.supervise.vo.EmpSelectVO;
import com.litbo.hospital.supervise.vo.EmpVO;
import com.litbo.hospital.user.dao.UserDao;
import com.litbo.hospital.user.service.UserService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpDao empDao;

    @Autowired
    private UserDao userDao;
    @Autowired
    UserService userService;
    @Autowired
    private BmDao bmDao;
    @Override
    public List<SEmp> getWxEmps() {
        return empDao.getWxEmps();
    }

    @Override
    public List<SEmp> getEmpsByBmId(String bmId) {
        return empDao.getEmpsByBmId(bmId);
    }

    @Override
    public void saveEmp(SEmp emp) {
        emp.setStatus("0");
        empDao.saveEmp(emp);
    }

    @Override
    public void deleteEmpByUserId(String empId) {

        empDao.deleteEmpByUserId(empId);
        userService.delUser(empId);
    }

    @Override
    public SBm getBmByEmpId(String empId) {
        return empDao.getBmByEmpId(empId);
    }

    @Override
    public SEmp getEmpsById(String id) {
        return empDao.getEmpsById(id);
    }

    @Override
    public List<String> getIdByXm(String xm) {
        return empDao.getIdByXm(xm);
    }

    @Override
    public List<SEmp> listEmpByBmId(String bmId) {

        return empDao.listEmpByBmId(bmId);
    }

    @Override
    public PageInfo listSelectEmps(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<EmpSelectVO> emps = empDao.listSelectEmps();
        return new PageInfo(emps);
    }

    @Override
    public List<EmpSelectVO> listSelectEmpsByUserName(int pageNum, int pageSize, String userName) {
        PageHelper.startPage(pageNum,pageSize);
        if(userName==null||userName.equals("")) return null;
        List<EmpSelectVO> emps = empDao.listSelectEmpsByUserName(userName);
        return emps;
    }

    @Override
    public EmpSelectVO listSelectEmpsByUserId(String userId) {
        return empDao.listSelectEmpsByUserId(userId);
    }

    @Override
    public PageInfo listSelectEmpBybmIdAndUserId(int pageNum, int pageSize, String bmId, String userId,String status,String bmName,String userXm) {
        PageHelper.startPage(pageNum,pageSize);
        List<EmpSelectVO> emps = empDao.listSelectEmpBybmIdAndUserId(bmId,userId,status,bmName,userXm);
        return new PageInfo(emps);
    }

    @Override
    public List<SEmp> listPartnerByUserId(String userId,int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<SEmp> partners = empDao.listPartnerByUserId(userId);
        return partners;
    }

    @Override
    public List<SEmp> listBmPartnerByUserId(String userId, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<SEmp> partners = empDao.listBmPartnerByUserId(userId);
        return partners;
    }

    @Override
    public EmpVO getEmpsByUserId(String userId) {
        EmpVO emp = empDao.getEmpsByUserId(userId);
        if(emp==null) return null;
        emp.setZwlbId(emp.getZwlbId()!=null?emp.getZwlbId().trim():null);
        emp.setXllbId(emp.getXllbId()!=null?emp.getXllbId().trim():null);
        emp.setMzId(emp.getMzId()!=null?emp.getMzId().trim():null);
        emp.setBmName(emp.getBmId()!=null?bmDao.getBmBybmid(emp.getBmId())!=null?bmDao.getBmBybmid(emp.getBmId()).getBmName():null:null);

//        String path = System.getProperty("user.dir");
//        if (emp.getQzzp()!=null&&!emp.getQzzp().equals(""))
//            emp.setQzzp(emp.getQzzp().replace(path+"\\","").replaceAll("\\\\","/"));

        return emp;
    }

    @Override
    public void updateEmp(SEmp emp) {
        empDao.updateEmp(emp);
    }

    private Integer batchImportGl(Workbook wb){
        Sheet sheet = wb.getSheetAt(0);
        int lastRowNum = sheet.getLastRowNum();

        boolean flag = false;
        for (int r = 1; r < sheet.getLastRowNum()+1; r++) {
            Row row = sheet.getRow(r);
            if (row == null){
                continue;
            }
            for (Cell c : row) {
                c.setCellType(Cell.CELL_TYPE_STRING);
                if(c==null||"".equals(c.getStringCellValue())){
                    flag=true;
                }else {
                    flag=false;
                    break;
                }
            }
            if (flag==true){
                lastRowNum--;
            }
        }
        return lastRowNum;
    }
    @Override
    @Transactional
    public Integer batchImportBms(String fileName, MultipartFile file)   {

        boolean notNull = false;
        Integer status = 1;

        try {
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

            Integer rowsct = batchImportGl(wb);
            for (int r = 1; r < rowsct+1; r++) {
                Row row = sheet.getRow(r);
                if (row == null){
                    continue;
                }
                SEmp emp = new SEmp();


                if(row.getCell(0)==null){
                    row.createCell(0);
                    row.getCell(0).setCellValue("");
                }

                if(row.getCell(1)==null){
                    row.createCell(1);
                    row.getCell(1).setCellValue("");
                }
                if(row.getCell(2)==null){
                    row.createCell(2);
                    row.getCell(2).setCellValue("");
                }

                if(row.getCell(3)==null){
                    row.createCell(3);
                    row.getCell(3).setCellValue("");
                }

                if(row.getCell(4)==null){
                    row.createCell(4);
                    row.getCell(4).setCellValue("");
                }
                if(row.getCell(5)==null){
                    row.createCell(5);
                    row.getCell(5).setCellValue("");
                }
                if(row.getCell(6)==null){
                    row.createCell(6);
                    row.getCell(6).setCellValue("");
                }
                if(row.getCell(7)==null){
                    row.createCell(7);
                    row.getCell(7).setCellValue("");
                }


//                if(row.getCell(0)==null) row.getCell(0).setCellValue("");
//                if(row.getCell(1)==null) row.getCell(1).setCellValue("");
//                if(row.getCell(2)==null) row.getCell(2).setCellValue("");
//                if(row.getCell(3)==null) row.getCell(3).setCellValue("");
//                if(row.getCell(4)==null) row.getCell(4).setCellValue("");
//                if(row.getCell(5)==null) row.getCell(5).setCellValue("");
//                if(row.getCell(6)==null) row.getCell(6).setCellValue("");
//                if(row.getCell(7)==null) row.getCell(7).setCellValue("");



                if(row.getCell(0)!=null)row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
                if(row.getCell(1)!=null)row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);//设置读取转String类型
                if(row.getCell(2)!=null)row.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
                if(row.getCell(3)!=null)row.getCell(3).setCellType(Cell.CELL_TYPE_STRING);
                if(row.getCell(4)!=null)row.getCell(4).setCellType(Cell.CELL_TYPE_STRING);
                if(row.getCell(5)!=null)row.getCell(5).setCellType(Cell.CELL_TYPE_STRING);
                if(row.getCell(6)!=null)row.getCell(6).setCellType(Cell.CELL_TYPE_STRING);
                if(row.getCell(7)!=null)row.getCell(7).setCellType(Cell.CELL_TYPE_STRING);



                String userId = row.getCell(0).getStringCellValue();   emp.setUserId(userId);
                if(userId.contains("*"))  return 1;
                String userXm = row.getCell(1).getStringCellValue();    emp.setUserXm(userXm);
                String sfzh = row.getCell(2).getStringCellValue();      emp.setSfzh(sfzh);
                String jtzz = row.getCell(3).getStringCellValue();      emp.setJtzz(jtzz);
                String tel = row.getCell(4).getStringCellValue();      emp.setTel(tel);
                String email = row.getCell(5).getStringCellValue();    emp.setEmail(email);
                String byyx = row.getCell(6).getStringCellValue();     emp.setByyx(byyx);
                String obmid = row.getCell(7).getStringCellValue();
                SBm bm = bmDao.getBmByOid(obmid);
                if(bm!=null)
                    emp.setBmId(obmid);
                emp.setStatus("0");

                if(empDao.saveEmp(emp)<=0){
                    return 1/0;
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return status;
    }

    @Override
    public String setQzzp(MultipartFile img) {
        String path = System.getProperty("user.dir");
        String filePath =path+"/emp/qzzp/";
        String url = UploadFile.upload(filePath,img);
        url = url.replaceAll("/","\\\\");
        return url;
    }
}

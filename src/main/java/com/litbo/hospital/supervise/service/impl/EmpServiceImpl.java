package com.litbo.hospital.supervise.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;
import java.util.Random;

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
    public PageInfo listSelectEmpBybmIdAndUserId(int pageNum, int pageSize, String bmId, String userId,String status,String bmName) {
        PageHelper.startPage(pageNum,pageSize);
        List<EmpSelectVO> emps = empDao.listSelectEmpBybmIdAndUserId(bmId,userId,status,bmName);
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
        emp.setZwlbId(emp.getZwlbId().trim());
        emp.setXllbId(emp.getXllbId().trim());
        emp.setMzId(emp.getMzId().trim());
        emp.setBmName(bmDao.getBmBybmid(emp.getBmId()).getBmName());
        return emp;
    }

    @Override
    public void updateEmp(SEmp emp) {
        empDao.updateEmp(emp);
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

        for (int r = 1; r < sheet.getLastRowNum()+1; r++) {
            Row row = sheet.getRow(r);
            if (row == null){
                continue;
            }
            SEmp emp = new SEmp();

            for (Cell c : row) {
                if(c==null) c.setCellValue("");
            }

            row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
            row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);//设置读取转String类型
            row.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
            row.getCell(3).setCellType(Cell.CELL_TYPE_STRING);
            row.getCell(4).setCellType(Cell.CELL_TYPE_STRING);
            row.getCell(5).setCellType(Cell.CELL_TYPE_STRING);
            row.getCell(6).setCellType(Cell.CELL_TYPE_STRING);



            String userId = row.getCell(0).getStringCellValue();   emp.setUserId(userId);
            String userXm = row.getCell(1).getStringCellValue();    emp.setUserXm(userXm);
            String sfzh = row.getCell(2).getStringCellValue();      emp.setSfzh(sfzh);
            String jtzz = row.getCell(3).getStringCellValue();      emp.setJtzz(jtzz);
            String tel = row.getCell(4).getStringCellValue();      emp.setTel(tel);
            String email = row.getCell(5).getStringCellValue();    emp.setEmail(email);
            String byyx = row.getCell(6).getStringCellValue();     emp.setByyx(byyx);
            emp.setStatus("0");
            empDao.saveEmp(emp);

        }

        return status;
    }
}

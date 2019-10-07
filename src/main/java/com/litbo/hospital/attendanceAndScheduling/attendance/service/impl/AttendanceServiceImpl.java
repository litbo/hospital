package com.litbo.hospital.attendanceAndScheduling.attendance.service.impl;

import com.litbo.hospital.attendanceAndScheduling.attendance.dao.AttendanceDAO;
import com.litbo.hospital.attendanceAndScheduling.attendance.pojo.Attendance;
import com.litbo.hospital.attendanceAndScheduling.attendance.service.AttendanceService;
import com.litbo.hospital.attendanceAndScheduling.attendance.vo.SignVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.SimpleBeanInfo;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author: 樊小铭
 * Date: 2019/10/4 13:51
 * @Version:
 * @Description:
 */
@Service
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    private AttendanceDAO attendanceDAO;


    @Override
    public List getSelfStaff(String id,String name) {
        return attendanceDAO.getSelfStaff(id,name);
    }

    @Override
    public int sing(SignVo signVo) {

        List<String> ids = signVo.getIds();

        // 得到当前时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String time = sdf.format(new Date(System.currentTimeMillis()));

        Attendance attendance = new Attendance();
        attendance.setSignTime(time);
        attendance.setSignType(String.valueOf(signVo.getSign()));
        for(String id : ids){
            attendance.setEmpId(id);
            attendanceDAO.insert(attendance);
        }

        return 1;
    }

    @Override
    public List countSign(String id, String name) {
        return attendanceDAO.countSign(id, name);
    }
}

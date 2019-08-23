package com.litbo.hospital.metering.service.impl;

import com.litbo.hospital.metering.dao.MeteringHistoryNumberDAO;
import com.litbo.hospital.metering.dao.MeteringUtilDAO;
import com.litbo.hospital.metering.dao.MeteringUtilStatusDAO;
import com.litbo.hospital.metering.pojo.MeteringHistoryNumber;
import com.litbo.hospital.metering.pojo.MeteringUtil;
import com.litbo.hospital.metering.pojo.MeteringUtilStatus;
import com.litbo.hospital.metering.service.MeteringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @Author: 樊小铭
 * Date: 2019/8/8 1:44
 * @Version:
 * @Description:
 */
@Service("meteringServiceImpl")
public class MeteringServiceImpl implements MeteringService {

    @Autowired
    private MeteringUtilDAO meteringUtilDAO;

    @Autowired
    private MeteringHistoryNumberDAO meteringHistoryNumberDAO;

    @Autowired
    private MeteringUtilStatusDAO meteringUtilStatusDAO;


    @Override
    public int addMeteringUtil(MeteringUtil meteringutil) {

        // 检查台账中是否存在相同设备  根据设备编号来查询   如果存在则不可重复添加
        MeteringUtil testMeteringUtil = meteringUtilDAO.selectByUtilNum(meteringutil.getMeteringNum());
        if(testMeteringUtil != null){
            return 0;
        }
        // 自动添加更新设备时间
        String nowDate = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss a").format(new Date());
        meteringutil.setUpdateMessageTime(nowDate);

        // 自动添加记录时间
        meteringutil.setRecordTime(nowDate);

        // 新加设备未进入计量流程
        meteringutil.setDescription("0");

        // 生成设备的系统编号
        String key = "XXXX" + System.currentTimeMillis() + "hello" + System.currentTimeMillis();
        meteringutil.setMeteringSystemNum(key);

        // 新加设备直接在用
        if(meteringutil.getMeteringstatus() == null){
            meteringutil.setMeteringstatus("在用");
        }

        if(meteringutil.getMeteringGetNumberTime() != null && !meteringutil.getMeteringGetNumberTime().equals("")){
            // 计算出下次送去计量的时间
            // 使用Calendar类来计算下一次的计量时间
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date(meteringutil.getMeteringGetNumberTime()));
            calendar.add(Calendar.MONTH,Integer.parseInt(meteringutil.getMeteringInspectionCycle()));
            //得到下一次的计量时间
            Date nextMeteringTime = calendar.getTime();
            meteringutil.setThisMeteringTime(new SimpleDateFormat("yyyy/MM/dd").format(nextMeteringTime));
        }

        // 设置计量编号编号有效期
        meteringutil.setEffectiveDate(meteringutil.getThisMeteringTime());



        // 将设备存放到数据库中，得到设备id
        int i = meteringUtilDAO.insert(meteringutil);
        MeteringUtil util = meteringUtilDAO.selectByUtilNum(meteringutil.getMeteringSystemNum());
        // 如果有计量编号，则将计量编号存放在历史计量编号的里面
        if(util.getMeteringNum() != null && i == 1){
            MeteringHistoryNumber meteringHistoryNumber = new MeteringHistoryNumber();
            // 记录时间
            meteringHistoryNumber.setRecordTime(nowDate);
            //计量编号
            meteringHistoryNumber.setDescription(util.getMeteringNum());
            // 得到计量编号的时间
            meteringHistoryNumber.setGetNumberTime(util.getMeteringGetNumberTime());
            // meteringutil id
            meteringHistoryNumber.setMeteringutilId(util.getId());
            // 设备编号
            meteringHistoryNumber.setMeteringutillNumber(util.getMeteringSystemNum());
            // 记录人
            meteringHistoryNumber.setRecordPerson(util.getRecordPerson());

            i = meteringHistoryNumberDAO.insert(meteringHistoryNumber);
        }

        return i;
    }

    @Override
    public int deleteMeteringUtil(int meteringutilId) {
        return meteringUtilDAO.deleteByPrimaryKey(meteringutilId);
    }

    @Override
    public List<MeteringUtil> findAllMeteringUtil() {
        return meteringUtilDAO.findAllMeteringUtil();
    }

    @Override
    public List<MeteringUtil> findAllMeteringUtilAllCheck(Integer sign, String gaugeCategory, String meteringName, String bmName, String meteringstatus,String beginTime,String endTime,String needMeter) {
        if(gaugeCategory != null){
            gaugeCategory = "%" + gaugeCategory + "%";
        }
        if(meteringName != null){
            meteringName = "%" + meteringName + "%";
        }
        if(bmName != null){
            bmName = "%" + bmName + "%";
        }
        return meteringUtilDAO.findAllMeteringUtilAllChech(sign,gaugeCategory,meteringName,bmName,meteringstatus,beginTime,endTime,needMeter);
    }

    @Override
    public List<MeteringUtil> findAllMeteringUtilByDepartmentAndMeteringUtilName(String department,String meteringUtilName) {
        if(department != null){
            department = department + "%";
        }

        if(meteringUtilName != null){
            meteringUtilName = meteringUtilName + "%";
        }
        return meteringUtilDAO.findAllMeteringUtilByDepartmentAndName(department,meteringUtilName);
    }

    @Override
    public List<MeteringUtil> findAllMeteringUtilByDepartment(String department) {

        return meteringUtilDAO.findAllMeteringUtilByDepartment(department);
    }


    @Override
    public List<MeteringUtil> findAllMeteringUtilByTime(String beginTime, String endTiem) {
        return meteringUtilDAO.findAllMeteringUtilByTime(beginTime, endTiem);
    }

    @Override
    public List<MeteringUtil> searchMeteringUtil(String beginTime, String endTiem, String department, String status) {
        return meteringUtilDAO.searchMeteringUtil(beginTime, endTiem, department, status);
    }

    @Override
    public int updateMeteringStatus(int id) {
        MeteringUtil m = meteringUtilDAO.selectByPrimaryKey(id);
        if(m == null){
            return 0;
        }
        if(m.getDescription().equals("1")){
            m.setDescription("0");
        }else if(m.getDescription().equals("0")){
            m.setDescription("1");
        }
        return meteringUtilDAO.updateByPrimaryKey(m);
    }

    @Override
    public int updateMeteringUtilUseStatus(MeteringUtilStatus status) {
        MeteringUtilStatus status1 = meteringUtilStatusDAO.selectByUtilId(status.getUtilId());
        if(status1 != null){
            meteringUtilStatusDAO.deleteByPrimaryKey(status1.getId());
        }
        return  meteringUtilStatusDAO.insert(status);

    }

    @Override
    public MeteringUtilStatus selectStatusById(int id) {
        return meteringUtilStatusDAO.selectByPrimaryKey(id);
    }

    @Override
    public MeteringUtilStatus getMeteringUtilUseStatusByUtilId(int id) {
        return meteringUtilStatusDAO.selectByUtilId(id);
    }


    @Override
    public int updateMeteringUtil(MeteringUtil meteringutilNewMessage) {
        // 查询台账中是否有这个设备
        MeteringUtil meteringUtilTestOldMessage = meteringUtilDAO.selectByPrimaryKey(meteringutilNewMessage.getId());
        if(meteringUtilTestOldMessage == null){
            return 0;
        }


        // 自动添加更新设备时间
        String nowDate = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss a").format(new Date());
        meteringutilNewMessage.setUpdateMessageTime(nowDate);


        // 将老数据重复
        meteringutilNewMessage.setDescription(meteringUtilTestOldMessage.getDescription());
        meteringutilNewMessage.setMeteringstatus(meteringUtilTestOldMessage.getMeteringstatus());
        meteringutilNewMessage.setRecordTime(meteringUtilTestOldMessage.getRecordTime());
        meteringutilNewMessage.setMeteringSystemNum(meteringUtilTestOldMessage.getMeteringSystemNum());


        // 如果计量周期发生变化，则重新计算计量时间
        if(meteringutilNewMessage.getMeteringGetNumberTime() != null && !meteringutilNewMessage.getMeteringGetNumberTime().equals("")){
            // 计算出下次送去计量的时间
            // 使用Calendar类来计算下一次的计量时间
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date(meteringutilNewMessage.getMeteringGetNumberTime()));
            calendar.add(Calendar.MONTH,Integer.parseInt(meteringutilNewMessage.getMeteringInspectionCycle()));
            //得到下一次的计量时间
            Date nextMeteringTime = calendar.getTime();
            meteringutilNewMessage.setThisMeteringTime(new SimpleDateFormat("yyyy/MM/dd").format(nextMeteringTime));
        }

        // 设置计量编号编号有效期
        meteringutilNewMessage.setEffectiveDate(meteringutilNewMessage.getThisMeteringTime());


        int i = meteringUtilDAO.updateByPrimaryKey(meteringutilNewMessage);
        // 如果计量编号发生变化，则在历史计量编号中添加一条新信息
        if(meteringutilNewMessage.getMeteringNum() != meteringUtilTestOldMessage.getMeteringNum()){
            MeteringHistoryNumber meteringHistoryNumber = new MeteringHistoryNumber();
            // 记录时间
            meteringHistoryNumber.setRecordTime(nowDate);
            //计量编号
            meteringHistoryNumber.setDescription("");
            meteringHistoryNumber.setDescription(meteringUtilTestOldMessage.getMeteringNum());
            // 得到计量编号的时间
            meteringHistoryNumber.setGetNumberTime(meteringUtilTestOldMessage.getMeteringGetNumberTime());
            // meteringutil id
            meteringHistoryNumber.setMeteringutilId(meteringUtilTestOldMessage.getId());
            // 设备编号
            meteringHistoryNumber.setMeteringutillNumber(meteringUtilTestOldMessage.getMeteringSystemNum());
            // 记录人
            meteringHistoryNumber.setRecordPerson(meteringUtilTestOldMessage.getRecordPerson());

            i = meteringHistoryNumberDAO.insert(meteringHistoryNumber);
        }

        return i;
    }

    @Override
    public MeteringUtil findMeteringUtilById(int meteringutilId) {
        return meteringUtilDAO.selectByPrimaryKey(meteringutilId);
    }

}

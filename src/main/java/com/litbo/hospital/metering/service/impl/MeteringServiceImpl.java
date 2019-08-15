package com.litbo.hospital.metering.service.impl;

import com.litbo.hospital.metering.dao.MeteringHistoryNumberDAO;
import com.litbo.hospital.metering.dao.MeteringUtilDAO;
import com.litbo.hospital.metering.pojo.MeteringHistoryNumber;
import com.litbo.hospital.metering.pojo.MeteringUtil;
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
        meteringutil.setMeteringstatus("在用");

        if(meteringutil.getBuyTime() != null && !meteringutil.getBuyTime().equals("")){
            // 计算出下次送去计量的时间
            // 使用Calendar类来计算下一次的计量时间
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date(meteringutil.getBuyTime()));
            calendar.add(Calendar.MONTH,Integer.parseInt(meteringutil.getMeteringInspectionCycle()));
            //得到下一次的计量时间
            Date nextMeteringTime = calendar.getTime();
            meteringutil.setThisMeteringTime(new SimpleDateFormat("yyyy/MM/dd").format(nextMeteringTime));
        }

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
    public int disableDevice(int meteringutilId){
        // 查询台账中是否有这个设备
        MeteringUtil meteringUtil = meteringUtilDAO.selectByPrimaryKey(meteringutilId);
        if(meteringUtil == null){
            return 0;
        }
        // 自动添加更新设备时间
        String nowDate = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss a").format(new Date());
        meteringUtil.setUpdateMessageTime(nowDate);

        // 将设备状态改为停用
        meteringUtil.setMeteringstatus("停用");
        return meteringUtilDAO.updateByPrimaryKey(meteringUtil);
    }

    @Override
    public List<MeteringUtil> findAllMeteringUtil() {
        return meteringUtilDAO.findAllMeteringUtil();
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
    public int updateMeteringUtil(MeteringUtil meteringutilNewMessage) {
        // 查询台账中是否有这个设备
        MeteringUtil meteringUtilTestOldMessage = meteringUtilDAO.selectByPrimaryKey(meteringutilNewMessage.getId());
        if(meteringUtilTestOldMessage == null){
            return 0;
        }

        // 检查编号是否重复
        MeteringUtil meteringUtilTestOldMEssage02 = meteringUtilDAO.selectByUtilNum(meteringutilNewMessage.getMeteringNum());
        if(meteringUtilTestOldMEssage02 != null){
            if(meteringutilNewMessage.getId() != meteringUtilTestOldMEssage02.getId()){
                return 0;
            }
        }

        // 自动添加更新设备时间
        String nowDate = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss a").format(new Date());
        meteringutilNewMessage.setUpdateMessageTime(nowDate);


        // 将老数据重复
        meteringutilNewMessage.setDescription(meteringUtilTestOldMEssage02.getDescription());
        meteringutilNewMessage.setMeteringstatus(meteringUtilTestOldMEssage02.getMeteringstatus());
        meteringutilNewMessage.setRecordTime(meteringUtilTestOldMEssage02.getRecordTime());

        // 如果计量周期发生变化，则重新计算计量时间
        if(meteringUtilTestOldMessage.getMeteringInspectionCycle() != meteringutilNewMessage.getMeteringInspectionCycle()){
            // 计算出下次送去计量的时间
            // 使用Calendar类来计算下一次的计量时间
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date(meteringutilNewMessage.getBuyTime()));
            calendar.add(Calendar.MONTH,Integer.parseInt(meteringutilNewMessage.getMeteringInspectionCycle()));
            //得到下一次的计量时间
            Date nextMeteringTime = calendar.getTime();
            meteringutilNewMessage.setThisMeteringTime(new SimpleDateFormat("yyyy/MM/dd").format(nextMeteringTime));
        }

        int i = meteringUtilDAO.updateByPrimaryKey(meteringutilNewMessage);
        MeteringUtil util = meteringUtilDAO.selectByUtilNum(meteringutilNewMessage.getMeteringSystemNum());
        // 如果计量编号发生变化，则在历史计量编号中添加一条新信息
        if(meteringutilNewMessage.getMeteringNum() != util.getMeteringNum()){
            MeteringHistoryNumber meteringHistoryNumber = new MeteringHistoryNumber();
            // 记录时间
            meteringHistoryNumber.setRecordTime(nowDate);
            //计量编号
            meteringHistoryNumber.setDescription("");
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
    public MeteringUtil findMeteringUtilById(int meteringutilId) {
        return meteringUtilDAO.selectByPrimaryKey(meteringutilId);
    }

    @Override
    public MeteringUtil findMeteringUtilByUtilNum(String num) {
        return meteringUtilDAO.selectByUtilNum(num);
    }
}

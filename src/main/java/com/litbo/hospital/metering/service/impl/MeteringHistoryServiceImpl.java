package com.litbo.hospital.metering.service.impl;

import com.litbo.hospital.metering.dao.MeteringHistoryNumberDAO;
import com.litbo.hospital.metering.dao.MeteringUtilDAO;
import com.litbo.hospital.metering.pojo.MeteringHistoryNumber;
import com.litbo.hospital.metering.service.MeteringHistoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author: 樊小铭
 * Date: 2019/8/10 1:21
 * @Version:
 * @Description:
 */
public class MeteringHistoryServiceImpl implements MeteringHistoryService {

    @Autowired
    private MeteringHistoryNumberDAO meteringHistoryNumberDAO;

    @Autowired
    private MeteringUtilDAO meteringUtilDAO;

    @Override
    public List<MeteringHistoryNumber> selectAllHistoryNum(int utilId) {
        return meteringHistoryNumberDAO.findAllMeteringHistoryNumber(utilId);
    }

    @Override
    public int addHistoryNum(MeteringHistoryNumber meteringHistoryNumber) {
        return meteringHistoryNumberDAO.insert(meteringHistoryNumber);
    }

    @Override
    public int updateHistoryNumber(MeteringHistoryNumber meteringHistoryNumber) {
        return meteringHistoryNumberDAO.updateByPrimaryKey(meteringHistoryNumber);
    }
}

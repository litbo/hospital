package com.litbo.hospital.operational_data_monitoring.internet_of_things.operation_record.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.operation_record.dao.InspectdetailDAO;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.operation_record.dao.Temp1DAO;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.operation_record.dao.Temp2DAO;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.operation_record.service.InspectdetailService;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.operation_record.vo.OperationRecord;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.operation_record.vo.SearchVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.operational_data_monitoring.internet_of_things.operation_record.service.impl
 * @Author: looli
 * @CreateTime: 2019-07-23 10:42
 * @Description: 运行记录显示接口实现
 */
@Service
@Transactional
public class InspectdetailServiceImpl implements InspectdetailService {
    @Autowired
    private InspectdetailDAO inspectdetailDAO;
    @Autowired
    private Temp1DAO temp1DAO;
    @Autowired
    private Temp2DAO temp2DAO;

    /**
     * 分页可查询显示当天数据
     * @param pageNum
     * @param pageSize
     * @param searchVO
     * @return 分页查询后的当天数据
     */
    @Override
    public PageInfo showNow(Integer pageNum, Integer pageSize, SearchVO searchVO) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo(inspectdetailDAO.select(searchVO));
    }

    /**
     * 显示设备原始记录
     * @param pageNum
     * @param pageSize
     * @param searchVO
     * @return 分页查询后的当天的数据
     */
    @Override
    public PageInfo showNow2(Integer pageNum, Integer pageSize, SearchVO searchVO) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo(inspectdetailDAO.select2(searchVO));
    }

    @Override
    public PageInfo showNow3(Integer pageNum, Integer pageSize, SearchVO searchVO) {
        //查出数据
        List<OperationRecord> operationRecords = inspectdetailDAO.select3(searchVO);
//        System.out.println(operationRecords.get(0));
        //清空临时表
        temp1DAO.delete();
        //存储临时表数据
        int batchCount =300;
        int batchLastIndex = batchCount - 1;
        if (operationRecords.size() != 0){
            for (int index = 0; index <= operationRecords.size() - 1;) {
                if (batchLastIndex > operationRecords.size() - 1) {
                    batchLastIndex = operationRecords.size() - 1;
                    temp1DAO.save(operationRecords.subList(index, batchLastIndex + 1));
                    // 数据插入完毕,退出循环
                    break;
                } else {
                    temp1DAO.save(operationRecords.subList(index, batchLastIndex + 1));
                    // 设置下一批下标
                    index = batchLastIndex + 1;
                    batchLastIndex = index + (batchCount - 1);
                }
            }
        }
        //查询临时表数据
        //分页
        PageHelper.startPage(pageNum,pageSize);
        //返回临时表数据
        return new PageInfo(temp1DAO.select());
    }

    @Override
    public PageInfo showNow4(Integer pageNum, Integer pageSize, SearchVO searchVO) {
        //查出数据
        List<OperationRecord> operationRecords = inspectdetailDAO.select4(searchVO);
//        System.out.println(operationRecords.get(0));
        //清空临时表
        temp2DAO.delete();
        //存储临时表数据
        int batchCount =300;
        int batchLastIndex = batchCount - 1;
        if (operationRecords.size() != 0){
            for (int index = 0; index <= operationRecords.size() - 1;) {
                if (batchLastIndex > operationRecords.size() - 1) {
                    batchLastIndex = operationRecords.size() - 1;
                    temp2DAO.save(operationRecords.subList(index, batchLastIndex + 1));
                    // 数据插入完毕,退出循环
                    break;
                } else {
                    temp2DAO.save(operationRecords.subList(index, batchLastIndex + 1));
                    // 设置下一批下标
                    index = batchLastIndex + 1;
                    batchLastIndex = index + (batchCount - 1);
                }
            }
        }
        //查询临时表数据
        //分页
        PageHelper.startPage(pageNum,pageSize);
        //返回临时表数据
        return new PageInfo(temp2DAO.select());
    }
}

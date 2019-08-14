package com.litbo.hospital.operational_data_monitoring.internet_of_things.operation_record.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.operation_record.dao.InspectdetailbackDAO;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.operation_record.dao.Temp1DAO;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.operation_record.dao.Temp2DAO;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.operation_record.service.InspectdetailbackService;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.operation_record.vo.OperationRecord;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.operation_record.vo.SearchVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.operational_data_monitoring.internet_of_things.operation_record.service.impl
 * @Author: looli
 * @CreateTime: 2019-08-07 10:21
 * @Description: todo
 */
@Service
public class InspectdetailbackServiceImpl implements InspectdetailbackService {

    @Autowired
    private InspectdetailbackDAO inspectdetailbackDAO;
    @Autowired
    private Temp1DAO temp1DAO;
    @Autowired
    private Temp2DAO temp2DAO;

    /**
     * 分页显示符合搜索条件的数据
     * @param pageNum
     * @param pageSize
     * @param searchVO
     * @return
     */
    @Override
    public PageInfo show(Integer pageNum, Integer pageSize, SearchVO searchVO) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo(inspectdetailbackDAO.select(searchVO));
    }

    /**
     * 分页显示符合搜索条件的原始记录
     * @param pageNum
     * @param pageSize
     * @param searchVO
     * @return
     */
    @Override
    public PageInfo show2(Integer pageNum, Integer pageSize, SearchVO searchVO) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo(inspectdetailbackDAO.select2(searchVO));
    }

    @Override
    public PageInfo show3(Integer pageNum, Integer pageSize, SearchVO searchVO) {
        //查出数据
        List<OperationRecord> operationRecords = inspectdetailbackDAO.select3(searchVO);
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
    public PageInfo show31(Integer pageNum, Integer pageSize, SearchVO searchVO) {
        //查出数据
        List<OperationRecord> operationRecords = inspectdetailbackDAO.select31(searchVO);
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
    public PageInfo show32(Integer pageNum, Integer pageSize, SearchVO searchVO) {
        //查出数据
        List<OperationRecord> operationRecords = inspectdetailbackDAO.select32(searchVO);
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
    public PageInfo show4(Integer pageNum, Integer pageSize, SearchVO searchVO) {
        //查出数据
        List<OperationRecord> operationRecords = inspectdetailbackDAO.select4(searchVO);
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

    @Override
    public PageInfo show41(Integer pageNum, Integer pageSize, SearchVO searchVO) {
        //查出数据
        List<OperationRecord> operationRecords = inspectdetailbackDAO.select41(searchVO);
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

    @Override
    public PageInfo show42(Integer pageNum, Integer pageSize, SearchVO searchVO) {
        //查出数据
        List<OperationRecord> operationRecords = inspectdetailbackDAO.select42(searchVO);
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

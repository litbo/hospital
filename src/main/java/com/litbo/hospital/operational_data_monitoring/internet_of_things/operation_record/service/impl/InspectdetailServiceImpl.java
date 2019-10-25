package com.litbo.hospital.operational_data_monitoring.internet_of_things.operation_record.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.dao.DeviceparameterDAO;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.dao.InspectdetailDAO;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.dao.Temp1DAO;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.dao.Temp2DAO;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.bean.Deviceparameter;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.operation_record.service.InspectdetailService;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.operation_record.vo.OperationRecord;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.operation_record.vo.SearchVO;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.operation_record.vo.WorkTimeVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    private DeviceparameterDAO deviceparameterDAO;
    @Autowired
    private Temp1DAO temp1DAO;
    @Autowired
    private Temp2DAO temp2DAO;
    static boolean add = true;

    /**
     * 分页可查询显示当天数据
     *
     * @param pageNum
     * @param pageSize
     * @param searchVO
     * @return 分页查询后的当天数据
     */
    @Override
    public PageInfo showNow(Integer pageNum, Integer pageSize, SearchVO searchVO) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo(inspectdetailDAO.select(searchVO));
    }

    /**
     * 显示设备原始记录
     *
     * @param pageNum
     * @param pageSize
     * @param searchVO
     * @return 分页查询后的当天的数据
     */
    @Override
    public PageInfo showNow2(Integer pageNum, Integer pageSize, SearchVO searchVO) {
        PageHelper.startPage(pageNum, pageSize);
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
        int batchCount = 300;
        int batchLastIndex = batchCount - 1;
        if (operationRecords.size() != 0) {
            for (int index = 0; index <= operationRecords.size() - 1; ) {
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
        PageHelper.startPage(pageNum, pageSize);
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
        int batchCount = 300;
        int batchLastIndex = batchCount - 1;
        if (operationRecords.size() != 0) {
            for (int index = 0; index <= operationRecords.size() - 1; ) {
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
        PageHelper.startPage(pageNum, pageSize);
        //返回临时表数据
        return new PageInfo(temp2DAO.select());
    }

    @Override
    public PageInfo<OperationRecord> showAllYlxNewYxjl(Integer pageNum, Integer pageSize, Date qssj, Date jssj, String zcbh, String bmid) {
        PageHelper.startPage(pageNum, pageSize);
        List<OperationRecord> list = inspectdetailDAO.showAllYlxNewYxjl(qssj, jssj, zcbh, bmid);
        list.forEach(item -> {
            if (item.getEndTime() == null || item.getBeginTime() == null) {
                item.setWorkHours("\\");
            } else if (item.getEndTime() != null && item.getBeginTime() != null) {
                item.setWorkHours(String.valueOf((item.getEndTime().getTime() - item.getBeginTime().getTime()) / 1000));
            }
        });
        return new PageInfo<>(list);
    }

    @Override
    public PageInfo<OperationRecord> showAllYlxNewYxjl2(Integer pageNum, Integer pageSize, Date qssj, Date jssj, String zcbh, String bmName, String eqSName) {
        PageHelper.startPage(pageNum, pageSize);
        List<OperationRecord> list = inspectdetailDAO.showAllYlxNewYxjl2(qssj, jssj, zcbh, bmName, eqSName);
        list.forEach(item -> {
            if (item.getEndTime() == null || item.getBeginTime() == null) {
                item.setWorkHours("\\");
            } else if (item.getEndTime() != null && item.getBeginTime() != null) {
                item.setWorkHours(String.valueOf((item.getEndTime().getTime() - item.getBeginTime().getTime()) / 1000));
            }

        });
        return new PageInfo<>(list);
    }

    @Override
    public PageInfo<OperationRecord> showAllYxhjNewYxjl(Integer pageNum, Integer pageSize, Date qssj, Date jssj, String zcbh, String bmid) {
        PageHelper.startPage(pageNum, pageSize);
        List<OperationRecord> list = inspectdetailDAO.showAllYlxNewYxjl(qssj, jssj, zcbh, bmid);
        list.forEach(item -> {
            if (item.getEndTime() == null || item.getBeginTime() == null) {
                item.setWorkHours("\\");
            } else if (item.getEndTime() != null && item.getBeginTime() != null) {
                item.setWorkHours(String.valueOf((item.getEndTime().getTime() - item.getBeginTime().getTime()) / 1000));
            }
            Deviceparameter lwx = deviceparameterDAO.showOneLwxByLwyBh(item.getMachineNumber());

            if (StringUtils.isNotBlank(item.getHumiValue())) {
                if (StringUtils.isNotBlank(lwx.getMinSdCurrent()) && (Integer.valueOf(item.getHumiValue()) < Integer.valueOf(lwx.getMinSdCurrent()))) {
                    item.setHumiStatus("1");
                } else if (StringUtils.isNotBlank(lwx.getMaxSdCurrent()) && (Integer.valueOf(item.getHumiValue()) > Integer.valueOf(lwx.getMaxSdCurrent()))) {
                    item.setHumiStatus("2");
                }
            }
            if (StringUtils.isNotBlank(item.getTempValue())) {

                if (StringUtils.isNotBlank(lwx.getMinWdCurrent()) && (Integer.valueOf(item.getTempValue()) < Integer.valueOf(lwx.getMinWdCurrent()))) {
                    item.setTempStatus("1");
                } else if (StringUtils.isNotBlank(lwx.getMaxWdCurrent()) && (Integer.valueOf(item.getTempValue()) > Integer.valueOf(lwx.getMaxWdCurrent()))) {
                    item.setTempStatus("2");
                }
            }

            if (StringUtils.isBlank(item.getCurrWeight())) {
                item.setCurrWeight("\\");
            }
            if (StringUtils.isNotBlank(item.getSmokeValue())) {
                if (StringUtils.isNotBlank(lwx.getMaxYwCurrent()) && (StringUtils.isNotBlank(item.getSmokeValue()))
                        && (Integer.valueOf(item.getSmokeValue()) > Integer.valueOf(lwx.getMaxYwCurrent()))) {
                    item.setSmokeStatus("2");
                }
            }
            if (item.getNowCurrent() != null) {
                if (StringUtils.isNotBlank(lwx.getMinCurrent()) && (item.getNowCurrent() < Integer.valueOf(lwx.getMinCurrent()))) {
                    item.setCurrentStatus("1");
                } else if (StringUtils.isNotBlank(lwx.getMaxCurrent()) && (item.getNowCurrent() > Integer.valueOf(lwx.getMaxCurrent()))) {
                    item.setCurrentStatus("2");
                }
            }


        });
        return new PageInfo<>(list);
    }

    @Override
    public PageInfo<OperationRecord> showOnelYlxYxjl(Integer pageNum, Integer pageSize, String lwybh) {
        PageHelper.startPage(pageNum, pageSize);
        List<OperationRecord> list = inspectdetailDAO.showOnelYlxYxjl(lwybh);
        list.forEach(item -> {
            if (item.getEndTime() == null || item.getBeginTime() == null) {
                item.setWorkHours("\\");
            } else if (item.getEndTime() != null && item.getBeginTime() != null) {
                item.setWorkHours(String.valueOf((item.getEndTime().getTime() - item.getBeginTime().getTime()) / 1000));
            }

            Deviceparameter lwx = deviceparameterDAO.showOneLwxByLwyBh(item.getMachineNumber());

            if (StringUtils.isNotBlank(item.getHumiValue())) {
                if (StringUtils.isNotBlank(lwx.getMinSdCurrent()) && (Integer.valueOf(item.getHumiValue()) < Integer.valueOf(lwx.getMinSdCurrent()))) {
                    item.setHumiStatus("1");
                } else if (StringUtils.isNotBlank(lwx.getMaxSdCurrent()) && (Integer.valueOf(item.getHumiValue()) > Integer.valueOf(lwx.getMaxSdCurrent()))) {
                    item.setHumiStatus("2");
                }
            }
            if (StringUtils.isNotBlank(item.getTempValue())) {

                if (StringUtils.isNotBlank(lwx.getMinWdCurrent()) && (Integer.valueOf(item.getTempValue()) < Integer.valueOf(lwx.getMinWdCurrent()))) {
                    item.setTempStatus("1");
                } else if (StringUtils.isNotBlank(lwx.getMaxWdCurrent()) && (Integer.valueOf(item.getTempValue()) > Integer.valueOf(lwx.getMaxWdCurrent()))) {
                    item.setTempStatus("2");
                }
            }

            if (StringUtils.isBlank(item.getCurrWeight())) {
                item.setCurrWeight("\\");
            }
            if (StringUtils.isNotBlank(item.getSmokeValue())) {
                if (StringUtils.isNotBlank(lwx.getMaxYwCurrent()) && (StringUtils.isNotBlank(item.getSmokeValue()))
                        && (Integer.valueOf(item.getSmokeValue()) > Integer.valueOf(lwx.getMaxYwCurrent()))) {
                    item.setSmokeStatus("2");
                }
            }
            if (item.getNowCurrent() != null) {
                if (StringUtils.isNotBlank(lwx.getMinCurrent()) && (item.getNowCurrent() < Integer.valueOf(lwx.getMinCurrent()))) {
                    item.setCurrentStatus("1");
                } else if (StringUtils.isNotBlank(lwx.getMaxCurrent()) && (item.getNowCurrent() > Integer.valueOf(lwx.getMaxCurrent()))) {
                    item.setCurrentStatus("2");
                }
            }


        });

        return new PageInfo<>(list);
    }

    @Override
    public PageInfo showOnelYlxYxjl2(Integer pageNum, Integer pageSize, String lwybh, String time) {

        List<OperationRecord> list = inspectdetailDAO.showOnelYlxYxjl(lwybh);


        List<WorkTimeVO> vos = new ArrayList();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM");
        if ("月".equals(time)) {
            list.forEach(item -> {
                add=true;
                if ("00".equals(item.getNewStatus())) {
                    String s = format.format(item.getBeginTime());

                    long l = 0;
                    if (item.getEndTime() != null && item.getBeginTime() != null) {
                        l = item.getEndTime().getTime() - item.getBeginTime().getTime();
                    }
                    vos.forEach(ik -> {
                        if (ik.getDatetime().equals(s)) {
                            add = false;
                            if (item.getEndTime() != null && item.getBeginTime() != null) {
                                ik.setCloseTime(item.getEndTime().getTime() - item.getBeginTime().getTime() + ik.getWorkTime());
                            }
                        }
                    });
                    if (add) {
                        WorkTimeVO vo2 = new WorkTimeVO();
                        vo2.setDatetime(s);
                        vo2.setCloseTime(l);
                        vos.add(vo2);
                        add = true;
                    }

                } else if ("01".equals(item.getNewStatus())) {
                    String s = format.format(item.getBeginTime());

                    long l = 0;
                    if (item.getEndTime() != null && item.getBeginTime() != null) {
                        l = item.getEndTime().getTime() - item.getBeginTime().getTime();
                    }
                    vos.forEach(ik -> {
                        if (ik.getDatetime().equals(s)) {
                            add = false;
                            if (item.getEndTime() != null && item.getBeginTime() != null) {
                                ik.setWorkTime(item.getEndTime().getTime() - item.getBeginTime().getTime() + ik.getWorkTime());
                            }

                        }
                    });
                    if (add) {
                        WorkTimeVO vo2 = new WorkTimeVO();
                        vo2.setDatetime(s);
                        vo2.setWorkTime(l);
                        vos.add(vo2);
                        add = true;
                    }

                }
                else if ("02".equals(item.getNewStatus())) {
                    String s = format.format(item.getBeginTime());
                    long l = 0;
                    if (item.getEndTime() != null && item.getBeginTime() != null) {
                        l = item.getEndTime().getTime() - item.getBeginTime().getTime();
                    }
                    vos.forEach(ik -> {
                        if (ik.getDatetime().equals(s)) {
                            add = false;
                            if (item.getEndTime() != null && item.getBeginTime() != null) {
                                ik.setWaitTime(item.getEndTime().getTime() - item.getBeginTime().getTime() + ik.getWorkTime());
                            }

                        }
                    });
                    if (add) {
                        WorkTimeVO vo2 = new WorkTimeVO();
                        vo2.setDatetime(s);
                        vo2.setWaitTime(l);
                        vos.add(vo2);
                        add = true;
                    }

                }
                else if ("03".equals(item.getNewStatus())) {
                    String s = format.format(item.getBeginTime());

                    long l = 0;
                    if (item.getEndTime() != null && item.getBeginTime() != null) {
                        l = item.getEndTime().getTime() - item.getBeginTime().getTime();
                    }
                    vos.forEach(ik -> {
                        if (ik.getDatetime().equals(s)) {
                            add = false;
                            if (item.getEndTime() != null && item.getBeginTime() != null) {
                                ik.setBrokenTime(item.getEndTime().getTime() - item.getBeginTime().getTime() + ik.getWorkTime());
                            }

                        }
                    });
                    if (add) {
                        WorkTimeVO vo2 = new WorkTimeVO();
                        vo2.setDatetime(s);
                        vo2.setBrokenTime(l);
                        vos.add(vo2);
                        add = true;
                    }

                }

            });
        }
        if ("年".equals(time)) {
            list.forEach(item -> {
                add=true;
                if ("00".equals(item.getNewStatus())) {
                    String s = format2.format(item.getBeginTime());
                    long l = 0;
                    if (item.getEndTime() != null && item.getBeginTime() != null) {
                        l = item.getEndTime().getTime() - item.getBeginTime().getTime();
                    }
                    vos.forEach(ik -> {
                        if (ik.getDatetime().equals(s)) {
                            add = false;
                            if (item.getEndTime() != null && item.getBeginTime() != null) {
                                ik.setCloseTime(item.getEndTime().getTime() - item.getBeginTime().getTime() + ik.getWorkTime());
                            }
                        }
                    });
                    if (add) {
                        WorkTimeVO vo2 = new WorkTimeVO();
                        vo2.setDatetime(s);
                        vo2.setCloseTime(l);
                        vos.add(vo2);
                        add = true;
                    }

                } else if ("01".equals(item.getNewStatus()))
                {
                    String s = format2.format(item.getBeginTime());

                    long l = 0;
                    if (item.getEndTime() != null && item.getBeginTime() != null) {
                        l = item.getEndTime().getTime() - item.getBeginTime().getTime();
                    }
                    vos.forEach(ik -> {
                        if (ik.getDatetime().equals(s)) {
                            add = false;
                            if (item.getEndTime() != null && item.getBeginTime() != null) {
                                ik.setWorkTime(item.getEndTime().getTime() - item.getBeginTime().getTime() + ik.getWorkTime());
                            }

                        }
                    });
                    if (add) {
                        WorkTimeVO vo2 = new WorkTimeVO();
                        vo2.setDatetime(s);
                        vo2.setWorkTime(l);
                        vos.add(vo2);
                        add = true;
                    }

                }
                else if ("02".equals(item.getNewStatus())) {
                    String s = format2.format(item.getBeginTime());
                    long l = 0;
                    if (item.getEndTime() != null && item.getBeginTime() != null) {
                        l = item.getEndTime().getTime() - item.getBeginTime().getTime();
                    }
                    vos.forEach(ik -> {
                        if (ik.getDatetime().equals(s)) {
                            add = false;
                            if (item.getEndTime() != null && item.getBeginTime() != null) {
                                ik.setWaitTime(item.getEndTime().getTime() - item.getBeginTime().getTime() + ik.getWorkTime());
                            }

                        }
                    });
                    if (add) {
                        WorkTimeVO vo2 = new WorkTimeVO();
                        vo2.setDatetime(s);
                        vo2.setWaitTime(l);
                        vos.add(vo2);
                        add = true;
                    }

                }
                else if ("03".equals(item.getNewStatus())) {
                    String s = format2.format(item.getBeginTime());

                    long l = 0;
                    if (item.getEndTime() != null && item.getBeginTime() != null) {
                        l = item.getEndTime().getTime() - item.getBeginTime().getTime();
                    }
                    vos.forEach(ik -> {
                        if (ik.getDatetime().equals(s)) {
                            add = false;
                            if (item.getEndTime() != null && item.getBeginTime() != null) {
                                ik.setBrokenTime(item.getEndTime().getTime() - item.getBeginTime().getTime() + ik.getWorkTime());
                            }

                        }
                    });
                    if (add) {
                        WorkTimeVO vo2 = new WorkTimeVO();
                        vo2.setDatetime(s);
                        vo2.setBrokenTime(l);
                        vos.add(vo2);
                        add = true;
                    }

                }

            });
        }
        int k = pageNum * pageSize;
        if (k > vos.size()) {
            k = vos.size();
        }
        List<WorkTimeVO> subList = vos.subList((pageNum - 1) * pageSize, k);
        PageHelper.startPage(pageNum, pageSize);
        PageInfo info = new PageInfo(subList);
        info.setTotal(vos.size());
        return info;
    }

    @Override
    public PageInfo<OperationRecord> showOnelYxhjYxjl(Integer pageNum, Integer pageSize, String lwybh) {
        return null;
    }
}

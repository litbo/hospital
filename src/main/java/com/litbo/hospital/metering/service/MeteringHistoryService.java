package com.litbo.hospital.metering.service;

import com.litbo.hospital.metering.pojo.MeteringHistoryNumber;

import java.util.List;

/**
 * @Author: 樊小铭
 * Date: 2019/8/10 1:21
 * @Version:
 * @Description:
 */
public interface MeteringHistoryService {
    // 根据设备id查看所有用过的编号
    List<MeteringHistoryNumber> selectAllHistoryNum(int utilId);

    // 添加历史编号
    int addHistoryNum(MeteringHistoryNumber meteringHistoryNumber);

    // 修改历史编号信息
    int updateHistoryNumber(MeteringHistoryNumber meteringHistoryNumber);

}
